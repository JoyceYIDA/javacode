package DS4;


import java.util.LinkedList;
import java.util.Queue;

public class BinSearchTree<E extends Comparable> implements BinTree<E> {
    //定义节点；私有内部类
    private class Node{
        private Node left;
        private Node right;
        private E data;
        public Node(E data) {

            this.data=data;
        }
    }
    //根节点和节点个数size
    private Node root;
    private int size;

    @Override
    public void add(E e) {
        if(root==null){
            Node newNode=new Node(e);
            root=newNode;
            size++;
        }
        add(root,e);
    }

    /**
     * 以指定的node为根节点，插入指定元素e
     * 插入的值刚好是当前树的根节点，直接返回
     * @param e
     * @return
     */
    private void add(Node node,E e){
        if(node.data.compareTo(e)==0){
            return;
        }else if(e.compareTo(node.data)<0&&node.left==null){
            Node newNode=new Node(e);
            node.left=newNode;
            size++;
        }else if(e.compareTo(node.data)>0&&node.right==null){
            Node newNode=new Node(e);
            node.right=newNode;
            size++;
        }
        //递归子树，插入数据
        if(e.compareTo(node.data)<0){
            add(node.left,e);
        }else if(e.compareTo(node.data)>0){
            add(node.right,e);
        }
    }

    /**
     * 以当前节点为根节点，插入元素为e的结点
     * 返回插入后树的根节点
     * @param e
     * @return
     */



    @Override
    public boolean contains(E e) {

        return contains(root,e);
    }

    /**
     * 递归寻找
     */
    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }else if(e.compareTo(node.data)<0){
            return contains(node.left,e);
        }else if(e.compareTo(node.data)>0){
            return contains(node.right,e);
        }else{
            return true;
        }
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 以当前节点为根节点进行遍历
     */
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.data);
        inOrder(node.left);
        inOrder(node.right);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 以node为根节点中序遍历
     */
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    /**
     * 层序遍历
     * 用队列实现，根节点
     *
     */
    @Override
    public void levelOrder() {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node newNode=queue.poll();
            System.out.println(newNode.data);
            if(newNode.left!=null){
                queue.add(newNode.left);
            }
            if(newNode.right!=null){
                queue.add(newNode.right);
            }
        }
    }

    /**
     * 最小值；一直递归向左走直到走不动为止，
     * @return
     */
    @Override
    public E getMin() {
        if(root==null){
            throw new IllegalArgumentException("BST is empty!!");
        }
        Node node=getMinNode(root);
        return node.data;
    }

    /**
     * 语义：查找以node为根节点的二分搜索树的最小根节点
     * @param node
     * @return
     */
    private Node getMinNode(Node node){
        if(node.left==null){
            return node;
        }
        return getMinNode(node.left);
    }

    /**
     * 最大值：向右走走到走不动为止
     * @return
     */
    @Override
    public E getMax() {
        if(root==null){
            throw new IllegalArgumentException("BST is empth!!!");
        }
        Node node=getMaxNode(root);
        return node.data;

    }
    private Node getMaxNode(Node node){
        if(node.right==null){
            return node;
        }
        return getMaxNode(node.right);
    }

    @Override
    public E removeMin() {
        E res=getMin();
        root=removeMin(root);
        return res;
    }

    /**
     * 删除传入二叉树的最小值节点，返回删除后二叉树的根节点
     * 删除的是节点，不能只删除值
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        //先找到需要删除的节点
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        //一直向左走直到找到最小值节点
        node.left=removeMin(node.left);
        return node;
    }

    @Override
    public E removeMax() {
        E result=getMax();
        root=removeMax(root);
        return result;
    }

    /**
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }
        node.right=removeMax(node.right);
        return node;
    }


    /**
     * 删除任意值节点（Hibbard Deletion）找到节点的前驱或者后集结点，将它替换
     *
     * 前驱节点：以当前root为根节点的二叉树中小于root节点值的最大值节点（左子树的最右叶子结点；左子树的最大值）
     * 后继节点：以当前root为根节点的二叉树中大于root节点值的最小值节点（右子树的最左叶子结点；右子树的最小值）
     * @param e
     */
    @Override
    public void remove(E e) {
        root=remove(root,e);
    }
    private Node remove(Node node,E e){
        if(node==null){
            return null;
        }
        if(e.compareTo(node.data)<0){
            node.left=remove(node.left,e);
            return node;
        }
        if(e.compareTo(node.data)>0){
            node.right=remove(node.right,e);
            return node;
        }
        //此时node就是需要删除的结点
        else {
            if(node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
                //左右都有节点，找到前驱或者后继节点
                Node successor=getMinNode(node.right);//后继
//                Node prev=getMaxNode(node.left);//前驱
                successor.right=removeMin(node.right);
                successor.left=node.left;
                node.right=node.left=null;
                return successor;
        }
    }







    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {

        return super.toString();
    }
    private void print(){

    }
}
