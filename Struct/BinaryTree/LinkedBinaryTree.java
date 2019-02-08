


public class LinkedBinaryTree implements BinaryTree{

    private Node root;//根节点

    //构造方法
    public LinkedBinaryTree(){
        super();
    }
    public LinkedBinaryTree(Node root){
        super();
        this.root=root;
    }

     //是否为空树【判断没有根】
     public boolean isEmpty(){
         return root==null;
     }

     //树节点的数量
     public int size(){
         System.out.println("二叉树节点个数：");
         return this.size(root);
     }
     private int size(Node root){
        if(root==null){
            return 0;
        }else{
         //获取左子树的size
         int nl=this.size(root.leftChild);

        //获取右子树的size
        int nr=this.size(root.rightChild);

       //  返回size之和，并+1
       return nl+nr+1;
     }
 
     //树的高度
     public int getHight(){
         System.out.println("二叉树的高度是：");
         return this.getHight(root);
     }
     private int getHight(Node node){
         if(root==null){
             return 0;
         }else{
          //获取左子树的高度
          int nl=this.getHight(root.leftChild);

         //获取右子树的高度
         int nr=this.getHight(root.rightChild);

        //  返回左子树、右子树较大高度，并+1
        return nl>nr?nl+1:nr+1;
         }
     }
 
     //查询指定值的位置
     public Node findKey(Object value){
         return this.findKey(value,root);
     }
     public Node findKey(Object value,Node root){
         if(root==null){
             return null;
         }else if(root!=null&&root.value==value){
             return root;
         } else{
             Node node1=this.findKey(value,root.leftChild);
             Node node2=this.findKey(value,root.rightChild);
             if(node1!=null&&node1.value==value){
                 return node1;
             }else if(node2!=null&&node2.value==value){
                 return node2;
             }else{
                 return null;
             }
        }
     }
 
     //前序递归遍历
     public void preOrderTraverse(){

         //1.输出节点的值
         if(root!=null){
         System.out.println(root.value);
         //2.对左子树进行遍历
           //创建左子树二叉树，根是左子树的根
           BinaryTree leftTree=new LinkedBinaryTree(root.leftChild);
           leftTree.preOrderTraverse();
           //3.对右子树进行遍历
            //创建右子树二叉树，根是左子树的根
            BinaryTree rightTree=new LinkedBinaryTree(root.rightChild);
            leftTree.preOrderTraverse();
         }
        // // 对左子树进行先序遍历
        // if(root!=null){
        //     //创建左子树二叉树，根是左子树的根
        //     BinaryTree leftTree=new LinkedBinaryTree(root.leftChild);
        //     leftTree.preOrderTraverse();
        // }
        // if(root!=null){
        //     //创建右子树二叉树，根是左子树的根
        //     BinaryTree rightTree=new LinkedBinaryTree(root.rightChild);
        //     leftTree.preOrderTraverse();
        // }
     }
 
     //中序递归遍历
     public void inOrderTraverse(){

        System.out.println("中序遍历");
        this.inOrderTraverse(root);
        System.out.println();
     }
     private void inOrderTraverse(Node root){

        if(root!=null){
            //遍历左子树
            this.inOrderTraverse(root.leftChild);

            //输出根的值
            System.out.println(root.value+"   ");

            //遍历右子树
            this.inOrderTraverse(root.rightChild);
        }
     }
 
     //后序递归遍历
     public void postOrderTraverse(){
        System.out.println("后序遍历");
        this. postOrderTraverse(root);
        System.out.println();
     }
     private void postOrderTraverse(Node node){
         if(node!=null){
             this.postOrderTraverse(root.leftChild);
             this.postOrderTraverse(root.rightChild);
             System.out.println(node.value+"    ");
         }

    }
 
     //中序非递归遍历(非递归需要借助栈来实现)
     public void inOrderByStack(){

     }
 
     //前序费归遍历
     public void preOrderByStack(){

     }
 
     //后序非递归遍历
     public void postOrderByStack(){

     }
 
     //按照层次遍历二叉树(队列)
     public void levelOrderByStack(){

     }
 
}