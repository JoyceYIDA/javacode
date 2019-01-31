package DataStruct;

import DataStruct.MyQueue;
public class TestMyQueue {

    public static void main(String[] args) {
        //创建一个队列
        MyQueue mq=new MyQueue();
        //入队列
        mq.add(5);
        mq.add(4);
        mq.add(3);
        mq.add(2);
        //出队列
        System.out.println(mq.poll());
        System.out.println(mq.poll());
        mq.add(6);
        //并不会影响出队列顺序
        System.out.println(mq.poll());
        System.out.println(mq.poll());
        System.out.println(mq.poll());
        System.out.println(mq.isEmpty());
//        输出结果：
//        5
//        4
//        3
//        2
//        6
//        true

    }

}
