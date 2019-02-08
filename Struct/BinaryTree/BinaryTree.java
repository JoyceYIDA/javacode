
//二叉树接口
//可以有不同的实现类，每个类可以使用不同的存储结构，比如顺序结构、链式结构

public interface BinaryTree{

    //是否为空树【判断没有根】
    public boolean isEmpty();

    //树节点的数量
    public int size();

    //树的高度
    public int getHight();

    //查询指定值的位置
    public Node findKey(int value);

    //前序递归遍历
    public void preOrderTraverse();

    //中序递归遍历
    public void inOrderTraverse();

    //后序递归遍历
    public void postOrderTraverse();

    //中序非递归遍历(非递归需要借助栈来实现)
    public void inOrderByStack();

    //前序费递归遍历
    public void preOrderByStack();

    //后序非递归遍历
    public void postOrderByStack();

    //按照层次遍历二叉树(队列)
    public void levelOrderByStack();


}