package myLinkedList.SingleList;

/**
 * @author yida
 */
public interface ILinked<E> {
    void addFirst(E data);
    void addLast(E data);
    int size();
    void clear();
    boolean addIndex(int index,E data);
    boolean contains(E e);
    E delete(E e);
    void removeAll(E e);
    void print();
}
