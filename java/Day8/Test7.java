package Day8;

//import java.util.Scanner;
//
////想购买的苹果数n；6个每袋或8个每袋
//public class Test7 {
//
//    public static int buy(int n){
//        int i=n/8;
//        int j=n/6;
//        int num=0;
//        int count=-1;
//
//        for(int p=0;p<=i;p++){
//            for(int q=0;q<=j;q++){
//                num=8*p+6*q;
//                if(num==n){
//                    count=p+q;
//                }
//            }
//        }
//        return count;
//    }
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            int n=scanner.nextInt();
//            System.out.println(buy(n));
//        }
//    }
//}

import TestEquals.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

////删除公共字符
//public class Test7{
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            String str1=scanner.nextLine();
//            String str2=scanner.nextLine();
//            int index=0;
//            char[] arr=new char[str1.length()];
//            for(int i=0;i<str1.length();i++){
//                if(!str2.contains(str1.charAt(i)+"")){
//                    arr[index]=str1.charAt(i);
//                    index++;
//                }
//            }
//            System.out.println(String.valueOf(arr).trim());
//        }
//    }
//}
//class Main{
//    public static String delectC(String str1,String str2){
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<str2.length();i++){
//            char c2=str2.charAt(i);
//            for(int j=0;j<str1.length();j++){
//                char c1=str1.charAt(j);
//                if(c1!=c2){
//                    sb.append(c1);
//                }
//            }
//        }
//        return sb.toString();
//    }
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            String str1=scanner.nextLine();
//            String str2=scanner.nextLine();
//            System.out.println(delectC(str1,str2));
//        }
//    }
//}