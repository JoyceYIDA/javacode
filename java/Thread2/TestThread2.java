package Thread2;
//
//public class TestThread2 {
//    public static void main(String[] args) throws InterruptedException {
////        Sync sync=new Sync();
//        MyThread mt=new MyThread();
//        Thread thread1=new Thread(mt,"子线程A");
//        Thread thread2=new Thread(mt,"子线程B");
//        Thread thread3=new Thread(mt,"子线程C");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//
////        //必须在线程启动前设置守护线程
////        thread1.setDaemon(true);
////        thread1.start();
////        thread2.start();
////        Thread.sleep(3000);
////        thread2.interrupt();
//    }
//}
////class MyThread implements Runnable{
////
////    @Override
////    public void run() {
////        int i=1;
////        while(true){
////            try{
////                Thread.sleep(1000);
////                System.out.println(Thread.currentThread().getName()+"是否是守护线程"+Thread.currentThread().isDaemon());
////
////            }catch(InterruptedException e){
////                System.out.println(Thread.currentThread().getName()+"退出");
////                return;
////            }
////        }
////    }
////}
////class MyThread implements Runnable{
////
////    private int ticket=100;
////    @Override
////    public void run() {
//////
//////        //同步代码块上锁：
//////        // 在此处设置一个锁，防止多个线程同时进去修改值，只有一个线程获取了锁权限，保证了拿到的一定是最新的修改值
////
//////        synchronized (this) {
//////            while(this.ticket>0) {
//////                try {
//////                    Thread.sleep(100);
//////                } catch (InterruptedException e) {
//////                    e.printStackTrace();
//////                }
//////                System.out.println(Thread.currentThread().getName() + "还剩下" + this.ticket-- + "张票");
//////            }
//////        }
////        for(int i=0;i<100;i++){
////            sale();
////        }
////    }
////    //隐式锁,锁的就是this当前对象
////    public synchronized void sale(){
////        if(ticket>0) {
////            System.out.println(Thread.currentThread().getName() + "还剩下" + this.ticket-- + "张票");
////        }
////    }
////}
//class Sync{
//    //普通类中定义同步方法
//    //任意时刻只有一个线程（同一个对象）可以进去
//    // 没有竞争，各自锁各自
//    // 用static修饰，锁的是Sync.class
//    public static synchronized void fun() {
//        System.out.println(Thread.currentThread().getName()+"fun方法开始");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"fun方法结束");
//    }
//}
//class MyThread implements Runnable{
////
////    private Sync sync;
////    public MyThread(Sync sync){
////        this.sync=sync;
////    }
//    @Override
//    public void run() {
////       this.sync.fun();
//        Sync sync=new Sync();
//        sync.fun();
//    }
//}

//public class TestThread2{
//    public static void main(String[] args) throws InterruptedException {
////        Object obj=new Object();
////        synchronized (obj){
////            System.out.println("hello world");
////        }
////        test();
////    }
////    public static synchronized void test(){
////
////    }
//        //可重入性
//        MyThread mt=new MyThread();
//        Thread threadA=new Thread(mt,"线程A");
//        Thread threadB=new Thread(mt,"线程B");
//
//        threadA.start();
//        Thread.sleep(1000);
//        threadB.start();
//
//    }
//}
//class MyThread implements Runnable{
//
//    @Override
//    public void run() {
//        test1();
//        test2();
//    }
//    public synchronized void test1(){
//        if(Thread.currentThread().getName().equals("A")){
//            test2();
//        }
//    }
//    public synchronized void test2(){
//        if (Thread.currentThread().getName().equals("B")){
//            System.out.println("B线程进入该同步方法test2..");
//        }else{
//            System.out.println(Thread.currentThread().getName()+"进入test2方法");
//        }
//    }
//}

//可重入性
public class TestThread2{
    public static void main(String[] args) throws InterruptedException {
        MyThread mt=new MyThread();
        Thread threadA=new Thread(mt,"线程A");
        Thread threadB=new Thread(mt,"线程B");

        threadA.start();
        threadB.start();

    }
}
class MyThread implements Runnable{

    @Override
    public void run() {
        test1();
    }
    public synchronized void test1(){
        if(Thread.currentThread().getName().equals("A")){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A线程进入test1方法");
            test2();
        }
    }
    public synchronized void test2(){
//        if (Thread.currentThread().getName().equals("B")){
//            System.out.println("B线程进入该同步方法test2..");
//        }else{
            System.out.println(Thread.currentThread().getName()+"进入test2方法");
//        }
    }
}
