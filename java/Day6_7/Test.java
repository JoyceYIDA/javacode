package Day6_7;

import java.util.*;

public class Test {
    public String str = "6";

    //火车进站
    //按字典排序输出火车出站的可能顺序
    //也就是一个栈有多少种出栈的顺序
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //N是火车的数量
            int N = scanner.nextInt();
            //火车的编号
            int[] A=new int[N];
            for(int i=0;i<N;i++)
                A[i]=scanner.nextInt();
            int start=0;
            //计算N个火车的出战的编号的排列组合
            ArrayList<int[]> res=new ArrayList<int[]>();
            Permutation(A,start,N,res);
            //使用treeset记录出栈的结果；比如1 2 3；1 3 2
            Set<String> sortResult=new TreeSet<String>();
            //循环排列组合
            for(int[] out:res){
                //判断是否满足出栈的要求
                if(isLegal(A,out,N)){
                    //满足条件的就输出
                    StringBuilder sb=new StringBuilder();
                    for(int i=0;i<N-1;i++){
                        sb.append(out[i]+" ");
                    }
                    sb.append(out[N-1]);
                    sortResult.add(sb.toString());
                }
            }
            //最终输出所有符合出栈要求的组合
            for(String list:sortResult){
                System.out.println(list);
            }
        }
        scanner.close();
    }

    /**
     *
     * @param in  火车编号的数组
     * @param out  火车出站的顺序
     * @param n  火车数量
     * @return
     */
    private static boolean isLegal(int[] in,int[] out,int n){
        //栈：存储进站的火车编号
        LinkedList<Integer> stack=new LinkedList<>();
        int i=0;
        int j=0;
        while(i<n){//还有元素的时候都需要判断
            if(in[i]==out[j]){//相等的时候就不用入栈，直接后移
                i++;
                j++;
            }else{
                if(stack.isEmpty()){//栈为空的时候就入栈
                    stack.push(in[i]);
                    i++;
                }else{
                    int top=stack.peek();
                    //栈顶元素相等。进行出栈
                    if(top==out[j]){
                        j++;
                        //不相等的时候就说明还有待进栈的元素
                    }else if(i<n){
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        //in的结束后，栈中元素进程出栈序列应该和out剩余的元素相同
        while(!stack.isEmpty()&& j<n){
            int top=stack.pop();
            if(top==out[j])
                j++;
            else
                return false;
        }
        return true;
    }

    /**
     * 求出所有的排列
     * @param A
     * @param start
     * @param n
     * @param res
     */
    private static void Permutation(int[] A,int start,int n,ArrayList<int[]> res){
        if(start==n){
            return;
        }
        if(start==n-1){
            int[] B=A.clone();
            res.add(B);
            return;
        }
        for(int i=start;i<n;i++){
            swap(A,start,i);
        }
    }
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}

//    public class Solution {
//        public void Mirror(TreeNode root) {
//            //镜像二叉树
//            //递归出口
//            if(root==null){
//                return;
//            }
//            //递归交换左右子节点
//            TreeNode node=root.left;
//            root.left=root.right;
//            root.right=node;
//            if(root.left!=null){
//                Mirror(root.left);
//            }
//            if(root.right!=null){
//                Mirror(root.right);
//            }
//        }
//    }
//}
