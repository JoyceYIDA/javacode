package Thread3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread3 {
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        Thread thread1=new Thread(mt,"黄牛1");
        Thread thread2=new Thread(mt,"黄牛2");
        Thread thread3=new Thread(mt,"黄牛3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class MyThread implements Runnable{

    private int ticket=50;
    private Lock lock=new ReentrantLock();
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            try{
                lock.lock();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"还剩下"+this.ticket--+"张票");
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
