package myLinkedList.CHeadSingle;

import myLinkedList.SingleList.ILinked;

import java.util.List;

/**
 * @author yida
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ILinked<Integer> linked=new CSingleList<>();
        linked.addFirst(1);
        linked.addFirst(2);
        linked.addFirst(3);
        linked.addLast(4);
        linked.print();
        linked.addLast(2);
        linked.addLast(2);
        linked.addFirst(9);
        linked.print();
        linked.removeAll(2);
        linked.print();
        System.out.println(linked.delete(3));
        linked.print();
        linked.clear();
        Thread.sleep(1000);
        System.out.println("睡醒了");
        System.out.println(linked.size());
    }
}
