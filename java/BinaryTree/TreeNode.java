package BinaryTreeTest;

/**
 * @author yida
 */
/**
 *
 */
//  Definition for a binary tree node.
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        invert(root);
        return root;
    }
    private void invert(TreeNode node){
        if(node.left==null&&node.right==null){
            return;
        }else if(node.left==null&&node.right!=null){
            node.left=node.right;
            node.right=null;
            node=node.left;
        }else if(node.right==null&&node.left!=null){
            node.right=node.left;
            node.left=null;
            node=node.right;
        }else{
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
        }
        invert(node.left);
        invert(node.right);
    }
}
