package myLinkedList.DoubleList;

import myLinkedList.SingleList.ILinked;

/**
 * @author yida
 */
public class TestDouble {
    public static void main(String[] args) {
        ILinked<Integer> linked=new DoubleLinked<>();
        linked.addFirst(1);
        linked.addFirst(2);
        linked.addFirst(3);
        linked.addFirst(4);
        linked.addLast(5);
        linked.addLast(6);
        linked.print();
        linked.addIndex(3,6);
        linked.delete(5);
        linked.delete(4);
        System.out.println(linked.delete(18));
        linked.print();
        linked.addLast(6);
        linked.addLast(5);
        linked.addFirst(6);
        linked.addFirst(6);
        linked.print();
        linked.removeAll(6);
        linked.print();
        linked.clear();
        System.out.println(linked.size());
    }
}
