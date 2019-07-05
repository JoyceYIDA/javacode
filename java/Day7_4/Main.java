package AJuly.Day7_4;

import java.util.Scanner;
import java.util.Stack;

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            String square=n*n+"";
//            Stack<Character> stack=new Stack<>();
//            for(int i=0;i<square.length();i++){
//                stack.push(square.charAt(i));
//            }
//            String num=n+"";
//            int flag=num.length();
//            for(int i=num.length()-1;i>=0;i--){
//                if(stack.peek()==num.charAt(i)) {
//                    stack.pop();
//                    flag--;
//                }
//            }
//            if(flag==0){
//                System.out.println("Yes!");
//            }else{
//                System.out.println("No!");
//            }
//        }
//    }
//}
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            System.out.println(password(str));

        }
    }
    public static String password(String str){
        if(str.length()-1>7){
            char[] arr=str.toCharArray();
            boolean ic=false;
            boolean jc=false;
            boolean nc=false;
            boolean kc=false;
            for(int i=0;i<str.length();i++){
                if(arr[i]>'a'&&arr[i]<'z'){
                    ic=true;
                }else if(arr[i]>'A'&&arr[i]<'Z'){
                    jc=true;
                }else if(arr[i]>'0'&&arr[i]<'9'){
                    nc=true;
                }else{
                    kc=true;
                }
            }
            if((ic&&jc&&nc)||(jc&&nc&&kc)||(nc&&kc&&ic)||(ic&&nc&&kc)||(ic&&jc&&kc)){
                for(int i=0;i<str.length()-3;i++){
                    String s1=str.substring(i,i+3);
                    String s2=str.substring(i+3);
                    if((s2.contains(s1))){
                        return "NG";
                    }
                }
                return "OK";
            }
        }
        return "NG";
    }
}