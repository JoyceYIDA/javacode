package BinaryTree;

import sun.reflect.generics.tree.Tree;

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
}
