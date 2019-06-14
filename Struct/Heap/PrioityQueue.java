package Heap;

/**
 * 基于大顶堆的优先级队列
 * @param <E>
 */
public class PrioityQueue<E extends Comparable<E>> implements Queue<E> {
    private Heap<E> heap=new Heap<E>();

    @Override
    public void enQueue(E e) {
        heap.add(e);
    }

    @Override
    public E deQueue() {
        return heap.extractMax();
    }

    @Override
    public E peek() {
        return heap.findMax();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.getSize();
    }
}
