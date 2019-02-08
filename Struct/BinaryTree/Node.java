//链式二叉树节点


public class Node{
    Object value;//节点值
    Node leftChild;//左子树
    Node rightChild;//右子树
//构造方法
    public Node(Object value){
        super();
        this.value=value;
    }
    public Node(Object value,Node leftChild,Node rigthChild){
        super();
        this.value=value;
        this.leftChild=leftChild;
        this.rightChild=rigthChild;
    }

    public String toString(){
        return "Node[value="+value+",leftChild:"+leftChild+",rightChild:"+rightChild+"]";
    }

}
