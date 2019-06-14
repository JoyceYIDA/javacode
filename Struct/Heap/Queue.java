package Heap;

public interface Queue<E> {
    void enQueue(E e);
    E deQueue();
    E peek();
    boolean isEmpty();
    int size();
}
