package Thread6;

import java.util.concurrent.*;

public class Thread6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //手工创建线程池
        ExecutorService executorService=new ThreadPoolExecutor(
                5,10,200,
                TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        MyThread myThread=new MyThread();
        for (int i=0;i<10;i++){
            Future future=executorService.submit(myThread);
            System.out.println(future.get());
        }
    }
}
//class MyThread implements Runnable{
//
//    @Override
//    public void run() {
//        for (int i=0;i<10;i++){
//            System.out.println(Thread.currentThread().getName()+"-"+i);
//        }
//    }
//}

class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        for (int i=0;i<10;i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
        return Thread.currentThread().getName()+"执行完毕";
    }
}
