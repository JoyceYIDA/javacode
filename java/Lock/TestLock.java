package TestLock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class MyLock implements Lock{

    private Sync sync=new Sync();

//    模板类
//    模板方法acquire，最核心，延迟到子类实现
    static class Sync extends AbstractQueuedSynchronizer{


        //规定同步状态为1
        //独占式获取锁：在一个时刻只有一个可以获取锁
//    整个过程也就是能从0改为1，表示能获取到锁
//    能从1改为0，表示释放锁,其他线程就能竞争锁，
        @Override
        protected boolean tryAcquire(int arg) {
            if(arg!=1){
                throw new RuntimeException("arg不为1！");
            }
            if(compareAndSetState(0,1)){
                //当前线程成功获取到锁
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        //
        @Override
        protected boolean tryReleaseShared(int arg) {
            if (getState()==0){
                throw new IllegalMonitorStateException();
            }
            //置空表示当前锁没有被任何线程获取
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            //=1就是拿到锁，否则就返回false
            return getState()==1;
        }
    }
    //---------------------lock接口方法-------------------------
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {

        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,time);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
class MyThread1 implements Runnable{
    Lock myLock1=new MyLock();
    @Override
    public void run() {
        try{
            myLock1.lock();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            myLock1.unlock();
        }
    }
}

public class TestLock {
    public static void main(String[] args) {
        MyThread1 myThread1=new MyThread1();
        for(int i=0;i<10;i++){
            Thread thread=new Thread(myThread1);
            thread.start();
        }
    }
}
