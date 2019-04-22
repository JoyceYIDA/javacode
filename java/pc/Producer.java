package pc;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    //生产者和消费者共享这个商品容器，所以不能直接实例化，而应该通过构造方法来传入
    private final Queue<Goods> goodsQueue;
    private final Integer MAX_Goods;
    private final AtomicInteger goodsID=new AtomicInteger(0);
    private final Long speed;

    public Producer(Queue<Goods> goodsQueue, Integer max_goods, long speed) {
        this.goodsQueue = goodsQueue;
        MAX_Goods = max_goods;
        this.speed = speed;
    }


    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goodsQueue) {
                if (this.goodsQueue.size() >= this.MAX_Goods) {
                    try {
                        System.out.println(Thread.currentThread().getName()+
                                "goodQueue is full,waiting for consumption");
                        this.goodsQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    Goods goods=new Goods("GOODS-"+goodsID.getAndDecrement(),  200.5);
                    this.goodsQueue.add(goods);
                    System.out.println("goodQueue is not full,produces goods"+goods);
                }
            }
        }
    }
}
