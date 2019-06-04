package OJ;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class SameTree {

    public boolean isSameTree(TreeNode p,TreeNode q){
        //两棵树都为空，他们相同；
        // 两棵树任意一棵为空，另一颗不为空，两棵树一定不相同
        // 两棵树的根节点值不想等，两棵树一定不相同
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(q.val!=p.val){
            return false;
        }
        //此时两棵树根节点不为空并且根节点值相等；
        // 去两棵二叉树的子树中比较
       return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    /**
     * 另一棵树的子树=查找二叉树中指定节点+判断两个树是否相同
     * 找到s中和t的根节点值相等的结点;判断子树和t是否相同
     * s和t都非空
     * @param s
     * @param t
     * @return
     */

    public boolean isSubtree(TreeNode s, TreeNode t) {
//        设置标志位
        boolean flag=false;
        //递归出口
        if(s!=null){
            //找到s中值与t的根节点相同的子节点
            if(s.val==t.val){
                flag=isSameTree(s,t);
            }
            //此时s还没有遍历完,还没有找到s中值为t的结点；
            // 递归从s的子树中继续寻找
            if(!flag){
                flag=isSubtree(s.left,t)||isSubtree(s.right,t);
            }
        }
        return flag;
    }


    /**
     * 二叉树的最大深度
     * 返回以root为根节点的二叉树的最大深度
     * @param root
     * @return
     */

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        //maxDepth是子树的最大深度：Math.max()比较两个数，返回大的；比较左子树的最大深度和右子树的最大深度
        int maxDepth=Math.max(maxDepth(root.left),maxDepth(root.right));
        return maxDepth+1;
    }
}
