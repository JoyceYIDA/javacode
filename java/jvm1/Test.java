package JVM111;


//import java.util.ArrayList;
//import java.util.List;
//
////Java堆溢出
////Java堆内存的OOM异常是实际应用中常见的内存溢出情况。
//// 当出现Java堆内存溢出时，异常堆栈信 息"java.lang.OutOfMemoryError"会进一步提示"Java heap space"。
//// 当出现"Java heap space"则很明确的告知我们，OOM发生在堆上
//// 参数-Xmx20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
//public class Test {
//    static class OOMObject{
//
//    }
//    public static void main(String[] args) {
//        List<OOMObject> list=new ArrayList<>();
//        while(true){
//            list.add(new OOMObject());
//        }
//    }
//// 运行结果：   Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//
//}

////Java栈溢出
////JVM参数：-Xss128k
//
//public class Test{
//    private int stackLength=1;
//    public void stackLeak(){
//        stackLength++;
//        stackLeak();
//    }
//    public static void main(String[] args) {
//       Test test=new Test();
//       try{
//           test.stackLeak();
//       }catch(Throwable e){
//           System.out.println("Stack Length"+test.stackLength);
//           throw e;
//       }
//    }
//// 输出结果： Exception in thread "main" java.lang.StackOverflowError
////    出现StackOverflowError异常时有错误堆栈可以阅读，比较好找到问题所在。如果使用虚拟机默认参数，栈深度在1000-2000完全没问题，对于正常方法调用（包括递归），完全够用。
////    如果是多线程导致内存溢出问题，在不能减少线程数的情况下，只能减少最大堆和减少栈容量的方式来换取更多线程。
//
//}


//多线程下的内存溢出异常
public class Test{
    private void dontStop(){
        while(true){

        }
    }

    public void stackLendByThread(){
        while(true){
            Thread thread=new Thread(new Runnable(){

                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[] args) {
        Test test=new Test();
        test.stackLendByThread();
    }
}
