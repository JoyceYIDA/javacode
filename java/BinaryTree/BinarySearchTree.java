package BinaryTree;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author yida
 */

public class BinarySearchTree<E extends Comparable<E>> implements IBinaryTree<E>{

    private class Node{
        E data;
        Node left;
        Node right;
        public Node(E e){
            this.data=e;
        }
    }
    private Node root;
    private int size;


    @Override
    public void add(E e) {
        if(root==null){
            Node node=new Node(e);
            root=node;
            size++;
        }
        //递归的寻找插入位置
        add(root,e);
    }

    /**
     * 以指定的node为根节点插入指定元素e
     * @param node
     * @param e
     */
    private void add(Node node,E e){
        if(node.data.compareTo(e)==0){
            //插入的值刚好是当前树根节点的值
            return;
        }else if(e.compareTo(node.data)<0 &&node.left==null){
            //找到插入位置，在左子树做插入
            Node newNode=new Node(e);
            node.left=newNode;
            size++;
        }else if(e.compareTo(node.data)>0&&node.right==null){
            Node newNode=new Node(e);
            node.right=newNode;
            size++;
        }else if(e.compareTo(node.data)<0){
            add(node.left,e);
        }else{
            add(node.right,e);
        }

    }

    /**
     * 删除任意节点
     * @return
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
        }else if(e.compareTo(node.data)>0){
            node.right=remove(node.right,e);
            return node;
        }else{
            //相等的时候，说明当前节点就是要删除的结点
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                node=rightNode;
            }else if(node.right==null){
                Node leftNode=node.left;
                node.left=node;
                node=leftNode;
            }
            //左右都有节点的时候
            // 删除当前节点，将前驱节点或者后继节点放在删除的结点位置
            Node houji=getMinNode(node.right);
            houji.right=removeMinNode(node.right);
            houji.left=node.left;
            node.right=node.left=null;
            return houji;
        }
    }



    @Override
    public boolean contains(E e) {
        if(root==null){
            return false;
        }
        return contains(root,e);
    }
    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.data)==0){
            return true;
        }else if (e.compareTo(node.data)<0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    @Override
    public E getMin() {
        if(root==null){
            throw new IllegalArgumentException("BST is Empty");
        }
        Node node=getMinNode(root);
        return node.data;

    }
    private Node getMinNode(Node node){
        if(node.left==null){
            return node;
        }
        return getMinNode(node.left);
    }

    @Override
    public E getMax() {
        if(root==null){
            throw new IllegalArgumentException("BST is Empty");
        }
        Node node=getMinNode(root);
        return node.data;
    }
    private Node getMaxNode(Node node){
        if(node.right==null){
            return node;
        }
        return getMinNode(node.right);
    }

    @Override
    public E removeMin() {
        E result=getMin();
        root=removeMinNode(root);
        return result;
    }

    /**
     * 删除传入二叉树的最小值节点
     * 1.找到要删除的节点
     * 2.保存要删除节点的指针
     * 3.将删除节点置为空并且递归寻找
     * 返回删除后二叉树的根节点
     * @param node
     * @return
     */
    private Node removeMinNode(Node node){
        //找到需要删除的结点
        if(node.left==null){
            Node temp=node.right;
            node.right=node;
            size--;
            return temp;
        }
        node.left=removeMinNode(node.left);
        return node;
    }

    @Override
    public E removeMax() {
        E result=getMax();
        root=removeMaxNode(root);
        return result;
    }
    private Node removeMaxNode(Node node){
        if(node.right==null){
            Node temp=node.left;
            node.left=null;
            size--;
            return temp;
        }
        node.right=getMaxNode(node.left);
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void preOrder() {

        preOrder(root);
    }

    /**
     * 以当前节点为根节点进行递归前序遍历
     * @param node
     */
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+"、");
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+"、");
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
        System.out.print(node.data+"、");
    }

    public static void main(String[] args) {
        IBinaryTree<Integer> binaryTree=new BinarySearchTree();
        int[] num=new int[]{28,16,13,22,30,29,42};
        for(int i=0;i<num.length;i++){
            binaryTree.add(num[i]);
        }
        System.out.println(binaryTree.contains(16));
        System.out.println(binaryTree.contains(10));
        binaryTree.postOrder();
        System.out.println();
        binaryTree.inOrder();
        System.out.println();
        binaryTree.preOrder();
        System.out.println();

    }
}
