package Day.listAndGenericity;

public interface ISequence<T> {
    void add(T data);
    boolean remove(int index);
    boolean contains(T data);
    Object set(int index,T data);
    Object get(int index);
    int size();
    void clear();
    Object[] toArray();
}
