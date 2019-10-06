package AAA.Day10_6;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author yida
 */


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
 }
public class Main {
    public static String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        int start=0;
        int end=0;
        boolean flag=false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
               stack.push(c);
               if(!flag){
                   start=i ;
                   flag=true;
               }
            }
            if(c==')'){
                stack.pop();
                if(stack.isEmpty()){
                    end=i;
                    sb.append(s.substring(start+1,end));
                    flag=false;
                    start=end;
                }
            }
        }
        return sb.toString();
    }


    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int temp=arr1[arr1.length-1]<arr2[arr2.length-1]?arr1[arr1.length-1]:arr2[arr2.length-1];
        int max=temp<arr3[arr3.length-1]?temp:arr3[arr3.length-1];
        List<Integer> list=new LinkedList<>();
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]<=max){
                for(int j=0;j<arr2.length;j++){
                    if(arr1[i]==arr2[j]){
                        list.add(arr1[i]);
                    }
                }
            }
        }
        for(int i=0;i<list.size();i++){
            int j=0;
            boolean flag=false;
            while(arr3[j]<=max){
                if(arr3[j]==list.get(i)){
                    flag=true;
                }
                j++;
            }
            if(!flag){
                list.remove(list.get(i));
            }
        }
        return list;
    }

    public static String method(String s){
        String[] arr=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=arr.length-1;i>0;i--){
            sb.append(arr[i]+" ");
        }
        sb.append(arr[0]);
        return sb.toString();
    }
    public static String reverseWords(String s) {
        String[] arr=s.split(" ");
        String s1="";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            s1=arr[i];
            for(int j=s1.length()-1;j>=0;j--){
                sb.append(s1.charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static boolean lemonadeChange(int[] bills) {
        int c1=0;
        int c2=0;
        boolean flag=false;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                c1++;
            }
            if(bills[i]==10){
                if(c1>0){
                    flag=true;
                    c1--;
                    c2++;
                }else{
                    flag=false;
                    break;
                }
            }
            if(bills[i]==20){
                if(c2>0&&c1>0){
                    flag=true;
                    c2--;
                    c1--;
                }else if(c1>3){
                    flag=true;
                    c1=c1-3;
                }else{
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum=0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            sum=sum+root.left.val;
        }
        sum+=sumOfLeftLeaves(root.right)+sumOfLeftLeaves(root.left);
        return sum;
    }

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String s=sc.nextLine();
//            System.out.println(removeOuterParentheses(s));
//        }
//        int[] arr1={1,2,3,4,5,7};
//        int[] arr2={1,2,5,7,9};
//        int[] arr3={1,3,4,5,7,8};
//        System.out.println(arraysIntersection(arr1,arr2,arr3));
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String s=sc.nextLine();
//            System.out.println(reverseWords(s));
//        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            String[] str=s.split(",");
            int[] arr=new int[str.length-1];
            for(int i=0;i<s.length();i++){
                arr[i]=Integer.parseInt(str[i]);
            }
            System.out.println(lemonadeChange(arr));
        }
    }
}
