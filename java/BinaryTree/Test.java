package BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author yida
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class Test {
    /**
     * 判断以p和q为根节点的两棵二叉树是否完全相同
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null ||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        //此时两棵树节点不为空且根节点值相等
        //此时去两棵树的子树中比较
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    /**
     * 判断这棵树是否是另一棵树的子树
     * 1.找到t的根节点在s中的位置
     * 2.判断两棵二叉树是否相同
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t){
        boolean flag=false;
        //递归的出口
        if(s!=null){
            if(s.val==t.val){
                flag=isSameTree(s,t);
            }
            //此时s还没有遍历完，仍未找到s中值也为t的结点
            //递归的从子树中查找
            if(!flag){
                flag=isSubtree(s.left,t)||isSubtree(s.right,t);
            }
        }
        //没找到根节点
        return flag;
    }

    /**
     * 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int maxDepth=Math.max(maxDepth(root.left),maxDepth(root.right));
        //子树的最大深度加上根节点就是二叉树的最大深度
        return maxDepth+1;
    }

    /**
     * 判断一个数组是不是二叉树后序遍历的结果
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
        return verify(sequence,0,sequence.length-1);
    }
    private boolean verify(int[] arr,int begin,int end){
        if(begin>=end){
            return true;
        }
        int root=arr[end];
        //获取左子树
        int left=begin;
        for(;left<end&&arr[left]<root;left++);
        int right=left;
        for(;right<end;right++){
            if(arr[right]<=root){
                return false;
            }
        }
        return verify(arr,begin,left-1)&&verify(arr,right,end-1);
    }

    /**
     * 根据二叉树创建字符串
     * 前序遍历构建字符串
     * 如果左右孩子都为空就不输出
     * 左孩子为空右孩子不为空输出一个空括号
     *
     * @param t
     * @return
     */
    public String tree2Str(TreeNode t){
        StringBuilder sb=new StringBuilder();
        tree2Str(t,sb);
        return sb.toString();
    }
    private void tree2Str(TreeNode node,StringBuilder res){
        if(node==null){
            return;
        }
        res.append(node.val);
        if(node.left!=null){
            res.append("(");
            tree2Str(node.left,res);
            res.append(")");
        }else{
            //左子树为空,同时右子树不为空
            if(node.right!=null){
                res.append("()");
            }
        }
        if(node.right!=null){
            res.append("(");
            tree2Str(node.right,res);
            res.append(")");
        }
    }

    /**
     * 镜像二叉树
     * 将二叉树的左右子树进行翻转
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.right=left;
        root.left=right;
        Mirror(root.right);
        Mirror(root.left);
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //在root1中找到第一个和root2的val相等的
        boolean flag=false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val) {
                flag = method(root1, root2);
            }
            //递归在左子树和右子树中寻找
            if(!flag){
                flag=HasSubtree(root1.left,root2);
            }
            if(!flag)
                flag=HasSubtree(root1.right,root2);
        }
        return flag;
    }
    private boolean method(TreeNode node1,TreeNode node2){
        if(node2==null){
            return true;
        }
        if(node1==null){
            //遍历完第一棵树都没有找到和root2相等的
            return false;
        }
        if(node1.val!=node2.val){
            return false;
        }
        return method(node1.left,node2.left)&&method(node1.right,node2.right);
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //利用队列先进先出的性质，将左孩子和右孩子依次放进去
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        //当前根节点不为空就将他放进队列，那么根节点会第一个出来
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return list;
    }

    /**
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null||target<0){
            return res;
        }
        list.add(root.val);
        target-=root.val;
        if(root.left==null&&root.right==null&&target==0){
            res.add(new ArrayList<>(list));
        }
        //递归左子树和右子树
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return res;
    }


    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
     * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list=new ArrayList<>();
        char[] strs=str.toCharArray();
        list.add(str);

        return list;
    }

//    private static void swap(char[] arr,int x,int y){
//        char temp=arr[x];
//        arr[x]=arr[y];
//        arr[y]=temp;
//    }
//    private static String tostr(char[] strs){
//        StringBuilder sb=new StringBuilder();
//        for(char c:strs){
//            sb.append(c);
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) {
//        String str="abcd";
//        ArrayList<String> res=Permutation(str);
//        for(int i=0;i<res.size();i++){
//            System.out.print(res.get(i)+" ");
//        }

        int[] arr={9,3,6,2,7,2,9};
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }





    public static void heapSort(int[] arr){

        //初始化为堆结构
        for(int i=(arr.length-1-1)/2;i>=0;i--){
            heap(arr,i,arr.length-1);
        }

        for(int i=0;i<arr.length-1;i++){
            int temp=arr[0];
            arr[0]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
            heap(arr,0,arr.length-i-1-1);
        }
    }
    private static void heap(int[] arr,int start,int end){
        int temp=arr[start];
        for(int i=start*2+1;i<=end;i=i*2+1){
            if(i<end&&arr[i]<arr[i+1]){
                i++;//此时i保存的是左右孩子最大值的下标
            }
            if(arr[i]>temp){
                arr[start]=arr[i];
                start=i;
            }else if(arr[i]<temp){
                break;
            }
        }
        arr[start]=temp;
    }

    /**
     * 输出二叉树
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        List<String> list=new ArrayList<>();
        List<List<String>> res=new ArrayList<>();
        return res;
    }

    /**
     * 对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return method1(root,root);
    }
    private boolean method1(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null){
            return true;
        }
        if(node1==null||node2==null){
            return false;
        }
        return method1(node1.left,node2.right)
                &&method1(node1.right,node2.left)&&
                (node1.val==node2.val);
    }

}
