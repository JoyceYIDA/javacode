package JVM2;


import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

////-XX:+PrintGC
//public class TestJVM2 {
//    private Object instance;
//    private static int _1MB=1024*1024;
//    private byte[] bigSize=new byte[2*_1MB];
//    public static void main(String[] args) {
////        TestJVM2 test1=new TestJVM2();
////        TestJVM2 test2=new TestJVM2();
////        //循环引用
////        test1.instance=test2;
////        test2.instance=test1;
////        test1=test2=null;
////        System.gc();
//
//        TestJVM2 test=new TestJVM2();//强引用
////        SoftReference softReference=new SoftReference(test);//软引用
//        WeakReference weakReference=new WeakReference(test);//弱引用
//        test=null;
//        System.gc();
//    }
//}

public class TestJVM2{

    private static TestJVM2 test;
    public void isAlive(){
        if(test!=null){
            System.out.println("i am alive");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute");
        test=this;//建立联系
    }

    public static void main(String[] args) {
        test=new TestJVM2();//分配了一个新GC Roots
        test=null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(test!=null){
            test.isAlive();
        }else{
            System.out.println("i am dead");
        }
        //-------------------------------------------------

        test=null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(test!=null){
            test.isAlive();
        }else{
            System.out.println("i am dead");
        }
    }
}
