package DS4;

import java.util.*;

/**
 * Definition for a binary tree node.
 * */
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
  }
class Solution {
//    List<Integer> list=new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//
//        if(root==null){
//            return Collections.emptyList();
//        }
//        list.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return list;
//    }
//}


//class Solution {
//    public String tree2str(TreeNode t) {
//        StringBuilder res=new StringBuilder();
//        tree(t,res);
//        return res.toString();
//    }
//    private void tree(TreeNode node,StringBuilder res){
//        if(node==null){
//            return;
//        }
//        res.append(node.val);
//        if(node.left!=null) {
//            res.append("(");
//            tree(node.left, res);
//            res.append(")");
//        }else{
//            if(node.right!=null) {
//                res.append("()");
//            }
//        }
//        if(node.right!=null){
//            res.append("(");
//            tree(node.right,res);
//            res.append(")");
//        }
//    }
//
//    //非递归
//    List<Integer> list=new ArrayList();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        if (root == null) {
//            return list;
//        }
//        stack.push(root);
//        while(!stack.isEmpty()){
//            root=stack.pop();
//            list.add(stack.pop().val);
//            if(root.right!=null){
//                stack.push(root.right);
//
//            }
//            if(root.left!=null){
//                stack.push(root.left);
//            }
//        }
//        return list;
//    }

//非递归中序遍历
//    List<Integer> list=new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                list.add(root.val);
                root=root.right;
            }
        }
        return list;
    }

    //后序非递归遍历

    List<Integer> list=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
    }
}














