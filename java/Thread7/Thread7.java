package Thread7;

import java.util.concurrent.*;

public class Thread7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //使用内置固定大小线程池

        MyThread myThread=new MyThread();
//    ExecutorService executorService= Executors.newFixedThreadPool(6);

//        ExecutorService executorService=Executors.newSingleThreadPool();

//        ExecutorService executorService=Executors.newCachedThreadPool();

        ScheduledExecutorService executorService=Executors.newScheduledThreadPool(4);
        for (int i=0;i<10;i++){
//            Future future=executorService.submit(myThread);
//            System.out.println(future.get());

//            executorService.schedule(myThread,2000,TimeUnit.MILLISECONDS);
            executorService.scheduleAtFixedRate(myThread,2000,1000,TimeUnit.MILLISECONDS);
        }
        //关闭线程池
//        executorService.shutdown();
    }
}
//class MyThread implements Callable<String> {
//
//    @Override
//    public String call() throws Exception {
//        for (int i=0;i<10;i++) {
//            System.out.println(Thread.currentThread().getName() + "-" + i);
//        }
//        return Thread.currentThread().getName()+"执行完毕";
//    }
//}
class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"-"+i);
        }
    }
}