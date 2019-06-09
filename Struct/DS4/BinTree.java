package DS4;

/**
 * 二叉树通用接口
 */
public interface BinTree<E> {
    void add(E e);
    boolean contains(E e);
    /*
    前序遍历
     */
    void preOrder();

    /**
     * 中序遍历
     */
    void inOrder();

    /**
     * 后序遍历
     */
    void postOrder();

    /**
     * 层序遍历
     * @return
     */
    void levelOrder();

    E getMin();
    E getMax();
    E removeMin();
    E removeMax();
    void remove(E e);
    int size();
}
