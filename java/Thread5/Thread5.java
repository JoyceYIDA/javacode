package Thread5;
//
////死锁的实现
//
//class Pen{
//    private String pen="笔";
//
//    public String getPen() {
//        return pen;
//    }
//}
//class Book{
//    private String book="本";
//
//    public String getBook() {
//        return book;
//    }
//}
//
//
//public class Thread5 {
//    private static Pen pen=new Pen();
//    private static Book book=new Book();
//
//    public static void main(String[] args) {
//       Thread5 thread5=new Thread5();
//       thread5.deadLock();
//
//    }
//    public void deadLock(){
//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (pen){
//                    System.out.println("我有笔，没有本");
//                    synchronized (book){
//                        System.out.println("我有笔，也有本");
//                    }
//                }
//            }
//        },"线程A");
//        Thread thread1=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (book){
//                    System.out.println("我有本，没有笔");
//                    synchronized (pen){
//                        System.out.println("我有本，也有笔");
//                    }
//                }
//            }
//        },"线程B");
//        thread.start();
//        thread1.start();
//    }
//}

//锁粗化
public class Thread5{
//    public static StringBuffer sb=new StringBuffer();//静态全局变量，都可以访问
    public static void main(String[] args) {
//        sb.append("a");
//        sb.append("b");
//        sb.append("c");
//        public synchronized StringBuffer append(String str)
//        append是同步方法，每调用一次都要进行一次加锁解锁操作
//        锁粗化
//        可以将线程安全的StringBuffer换成线程不安全的StringBuilder
//        StringBuilder builder=new StringBuilder();
//        builder.append("aaa");
//        builder.append("bbb");
//        builder.append("ccc");
//        sb.append(builder.toString());
//        锁消除
//        StringBuffer的append是同步方法，但是吧StringBuffer设置为一个局部变量，并且不会从方法中逃逸出去，就可以将锁消除
        StringBuffer sb=new StringBuffer();
        sb.append("a").append("b").append("c");

    }
}