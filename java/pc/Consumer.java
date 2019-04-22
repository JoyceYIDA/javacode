package pc;

import java.util.Queue;

public class Consumer implements Runnable{

    private final Queue<Goods> goodsQueue;
    private final Long speed;

    public Consumer(Queue<Goods> goodsQueue, long speed) {
        this.goodsQueue = goodsQueue;
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
            synchronized (goodsQueue){
                if(this.goodsQueue.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+
                            "  goodQueue is empty,please product");
                    //多线程，唤醒全部；notify是随机唤醒多线程中的任意一个线程
                    this.goodsQueue.notifyAll();
                }else{
                    //取出队列中的元素，poll方法
                    Goods goods=this.goodsQueue.poll();
                    if(goods!=null){
                        System.out.println(Thread.currentThread().getName()
                                +"goodsQueue is not empty,u can buy it");
                    }
                }
            }
        }
    }
}
