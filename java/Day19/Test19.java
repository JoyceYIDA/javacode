package Day19;

import java.util.Scanner;
import java.util.Stack;

public class Test19{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNext()){
            String s=scanner.nextLine();
            String s1=s.split(" ")[0];
            String s2=s.split(" ")[1];
            int n=Integer.parseInt(s1);
            char c=s2.charAt(0);
            method(n,c);
        }

//        String s1="196";
//        String s2="1";
//        String s3=AddLongInteger(s1,s2);
//        System.out.println(s3);


    }
    public static void method(int n,char c){
        int row=0;
        int max=n/2;
        if(n%2==1){
            max=max+1;
        }
        for(;row<max;row++){
            if(row==0||row==max-1) {
                for (int col=0; col < n; col++) {
                    System.out.print(c);
                }
                System.out.println();
            }
            else {
                System.out.print(c);
                for (int i = 1; i < n - 1; i++) {
                    System.out.print(" ");
                }
                System.out.print(c);
                System.out.println();
            }
        }
    }

//    //设计一个算法完成两个超长正整数的加法。
//    // addend是加数，augend是被加数
//    public static String AddLongInteger(String addend,String augend){
//        if(addend==null||augend==null){
//            return null;
//        }
//        char[] temp=new char[addend.length()+1];
//        char[] add=new char[addend.length()];
//        char[] aug=new char[augend.length()];
//        for(int i=0;i<add.length;i++){
//            add[i]=addend.charAt(i);
//        }
//        for(int i=0;i<aug.length;i++){
//            aug[i]=augend.charAt(i);
//        }
//        int res=0;
//        int i=0;
//        for(i=temp.length-1;i>=0;i--){
//            if(i-1==-1&&res==0){
//                break;
//            }else if(i-1==-1&&res==1){
//                temp[i]='0'+1;
//                break;
//            }
//            int a=aug[i-1]-'0';
//            int b=aug[i-1]-'0';
//            int num=a+b;
//            if(res==1){
//                num=num+1;
//            }
//            if(num>9){
//                res=1;
//                temp[i]= (char) ((num-10)+'0');
//            }else{
//                res=0;
//                temp[i]= (char) (num+'0');
//            }
//        }
//        if(temp[0]!='0'){
//
//        }
//    }



    public static String AddLongInteger(String addend,String augend){
        Stack<Character> stack1=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        Stack<Integer> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        stack1.push('0');
        stack2.push('0');
        for(int i=0;i<addend.length();i++){
            stack1.push(addend.charAt(i));
            if(i<addend.length()-augend.length()){
                stack2.push('0');
            }
        }
        for(int j=0;j<augend.length();j++){
            stack2.push(augend.charAt(j));
        }
        while(!stack2.isEmpty()){
            int a=stack1.pop()-'0';
            int b=stack2.pop()-'0';
            int res=a+b;
            if(res>9){
                stack.push(res%10);
            }else{
                stack.push(res);
                res=res+1;
            }
        }
        if(stack.peek().equals(0)){
            stack.pop();
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
