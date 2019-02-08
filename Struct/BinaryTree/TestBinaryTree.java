

public class TestBinaryTree{
     public static void main(String[] args){

        //创建一个二叉树
        Node node5=new Node(5, null, null);
        Node node4=new Node(4, null, node5);

        Node node3=new Node(3, null, null);
        Node node7=new Node(7, null, null);
        Node node6=new Node(6, null, node7);

        Node node2=new Node(2, node3, node6);
        Node node1=new Node(1, node4, node2);

        //把创建的节点和树连接起来
         BinaryTree bt=new LinkedBinaryTree(node1);
      // BinaryTree bt=new LinkedBinaryTree();
        // 判断二叉树是否为空
        System.out.println(bt.isEmpty());

        // 先序遍历递归
        System.out.println("先序遍历");
        bt.preOrderTraverse();
        System.out.println();

        // 中序遍历递归
        bt.inOrderTraverse();


        // 后序遍历递归
       bt.postOrderTraverse();


        // 中序遍历非递归


        // 先序遍历非递归


        // 后序遍历非递归


        // 按照层次遍历


        // 在二叉树中查找某个值
        System.out.println(bt.findKey(7));

        // 二叉树的高度
        System.out.println(bt.getHight());

        // 二叉树的节点数量
        System.out.println(bt.size());
     }
}