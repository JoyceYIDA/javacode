package myLinkedList.SingleList;

import myLinkedList.SingleList.ILinked;
import myLinkedList.SingleList.MySingleList;

/**
 * @author yida
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ILinked<Integer> linked=new MySingleList<>();
        linked.addFirst(18);
        linked.addFirst(20);
        linked.addFirst(30);
        linked.print();
        linked.addFirst(40);
        linked.addFirst(50);
        linked.addLast(90);
        System.out.println(linked.size());
        linked.print();
        System.out.println(linked.contains(10));
        System.out.println(linked.contains(18));
        System.out.println(linked.delete(20));
        linked.print();
        System.out.println(linked.delete(50));
        linked.print();
        System.out.println(linked.delete(90));
        linked.print();
        linked.addLast(30);
        linked.addLast(30);
        linked.addLast(30);
        linked.print();
        linked.removeAll(30);
        linked.print();
        /**
         * 测试内存泄漏：
         * 不让程序跑完可以让程序睡会；然后进行调试
         * jps：查看当前java进程号
         * jmap -histo:live 当前类的进程号> 产生一个文件，设定文件路径
         * 然后打开这个文件，找到当前类是否存在，如果不存在，就说明没有内存泄漏
         */
        Thread.sleep(1000);
        System.out.println("睡醒了");
    }

}
