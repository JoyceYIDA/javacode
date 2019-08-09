package BinaryTree;

/**
 * @author yida
 */
public interface IBinaryTree<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);

    E getMin();
    E getMax();
    E removeMin();
    E removeMax();
    int size();
    
    void preOrder();
    void inOrder();
    void postOrder();
}
