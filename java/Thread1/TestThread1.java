package Thread1;

public class TestThread1 {
    public static void main(String[] args) {
////        MyThread mt1=new MyThread("线程A");
////        MyThread mt2=new MyThread("线程B");
////        Thread t1=new Thread(mt1);
////        Thread t2=new Thread(mt2);
//        MyThread mt=new MyThread();
//        Thread t1=new Thread(mt,"线程A");
//        Thread t2=new Thread(mt,"线程B");
//        t1.start();
//        t2.start();
//    }
        Runnable runnable = () -> System.out.println("hello world");
        new Thread(runnable).start();
        Thread.yield();
    }
}
//class MyThread extends Thread{
//    private String title;
//
//    public MyThread(String title) {
//        this.title = title;
//    }
//    public void run(){
//        for(int i=0;i<10;i++){
//            System.out.println(this.title+"i="+i);
//        }
//    }
//}
//class MyThread implements Runnable {

//    private int ticket=10;
//    private String name;
//
//
//
//    @Override
//    public void run() {
//        while(ticket>0){
//            System.out.println("还剩"+this.ticket--+"张票");
//        }
//    }
//}
