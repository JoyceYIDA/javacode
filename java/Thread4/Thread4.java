package Thread4;

//public class Thread4 {
//    public static void main(String[] args) throws InterruptedException {
//        Object obj=new Object();
//        MyThread mt1=new MyThread(obj,true);
//        MyThread mt2=new MyThread(obj,false);
//        //多个线程同时进行
//        for(int i=0;i<10;i++){
//            Thread wt=new Thread(mt1);
//            wt.start();
//        }
//
//        Thread nt=new Thread(mt2);
//        Thread.sleep(1000);
//        nt.start();
//    }
//}
//class MyThread implements Runnable{
//    private Object obj;
//    private boolean flag;
//
//    public MyThread(Object obj, boolean flag) {
//        this.obj = obj;
//        this.flag = flag;
//    }
//
//    public void waitMethod(){
//        synchronized (obj){
//            System.out.println(Thread.currentThread().getName()+"wait begin");
//            try {
//                obj.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"wait end");
//        }
//    }
//    public void notifyMethod(){
//        synchronized (obj){
//            System.out.println(Thread.currentThread().getName()+"notify begin");
//            obj.notify();
//            System.out.println(Thread.currentThread().getName()+"notify end");
//        }
//    }
//    @Override
//    public void run() {
//         if(flag){
//             waitMethod();
//         }else{
//             notifyMethod();
//         }
//    }
////
////    @Override
////    public void run() {
////        synchronized (this) {
////            try {
////                System.out.println("wait begin");
////                wait();
////                System.out.println("wait end");
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////        }
////    }
//}

import java.util.ArrayList;
import java.util.List;

//生产消费者模型
// 1.单生产单消费
// 2.多个生产者，多个消费者
//class Goods{
////    商品名称
//    private String name;
////   商品数量
//    private int count;
//
//    @Override
//    public String toString() {
//        return "Goods{" +
//                "name='" + name + '\'' +
//                ", count=" + count +
//                '}';
//    }
//
//    //    生产商品的方法（同步方法）凡是涉及数量、名称的修改，必须同步
//    public synchronized void setGoods(String name){
//
//        //当前还有商品，生产者需要等待消费者消费完再生产
//        while(this.count>0){
//            try {
//                System.out.println("商品有库存");
//                wait();
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        this.name=name;
//        this.count++;
//        System.out.println("生产者"+toString());
//
//        //生产完商品后唤醒消费者
//        notify();
//    }
//    //消费商品方法
//
//    public synchronized void getGoods(){
//
//        //当前还没有商品，消费者需要等待
//        while(this.count==0){
//            try {
//                System.out.println("商品卖完了");
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        this.count--;
//
//        System.out.println("消费者"+toString());
//        //消费者消费完唤醒生产者
////        notifyAll()唤醒全部线程
//        notifyAll();
//    }
//}
//
////生产者
//class Producer implements Runnable{
//    private  Goods goods;
//
//    public Producer(Goods goods) {
//        this.goods = goods;
//    }
//
//    @Override
//    public void run() {
//        while(true) {
//            this.goods.setGoods("1234567");
//        }
//    }
//}
//
////消费者
//class Consumer implements Runnable{
//    private Goods goods;
//
//    public Consumer(Goods goods) {
//        this.goods = goods;
//    }
//
//    @Override
//    public void run() {
//        while(true) {
//            this.goods.getGoods();
//        }
//    }
//}
//
//public class Thread4{
//    public static void main(String[] args) {
//        Goods goods=new Goods();
//        List<Thread> list=new ArrayList<>();
//        Producer p=new Producer(goods);
//        Consumer c=new Consumer(goods);
//
//        //        5个生产者
//        for(int i=0;i<5;i++){
//            Thread thread=new Thread(p,"生产者"+i);
//            list.add(thread);
//        }
//        //   10个消费者
//        for(int i=0;i<10;i++){
//            Thread thread=new Thread(c,"消费者"+i);
//            list.add(thread);
//        }
//        for (Thread thread:list
//             ) {
//            thread.start();
//        }
////        Thread t1=new Thread(p,"生产者");
////        Thread t2=new Thread(c,"消费者");
////        t2.start();
////        t1.start();
//    }
//}


//    生产多个，消费者多个的生产--消费者模型

class Goods{
    //    商品名称
    private String name;
    //   商品数量
    private int count;

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    //    生产商品的方法（同步方法）凡是涉及数量、名称的修改，必须同步
    public synchronized void setGoods(String name){

        //当前还有商品，生产者需要等待消费者消费完再生产
        while(this.count>0){
            try {
                System.out.println("商品有库存");
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name=name;
        this.count++;
        System.out.println("生产者"+toString());

        //生产完商品后唤醒消费者
        notify();
    }
    //消费商品方法

    public synchronized void getGoods(){

        //当前还没有商品，消费者需要等待
        while(this.count==0){
            try {
                System.out.println("商品卖完了");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;

        System.out.println("消费者"+toString());
        //消费者消费完唤醒生产者
//        notifyAll()唤醒全部线程
        notifyAll();
    }
}

//生产者
class Producer implements Runnable{
    private  Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while(true) {
            this.goods.setGoods("1234567");
        }
    }
}

//消费者
class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while(true) {
            this.goods.getGoods();
        }
    }
}

public class Thread4{
    public static void main(String[] args) {
        Goods goods=new Goods();
        List<Thread> list=new ArrayList<>();
        Producer p=new Producer(goods);
        Consumer c=new Consumer(goods);

        //        5个生产者
        for(int i=0;i<5;i++){
            Thread thread=new Thread(p,"生产者"+i);
            list.add(thread);
        }
        //   10个消费者
        for(int i=0;i<10;i++){
            Thread thread=new Thread(c,"消费者"+i);
            list.add(thread);
        }
        for (Thread thread:list
                ) {
            thread.start();
        }
    }
}
