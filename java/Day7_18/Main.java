package CJuly.Day7_18;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * 删除公共字符
 * 1)可以将s2中出现的字符保存在一张表里面，如果这个字符串出现过，那么对应的位置就标志为true。
 * 然后遍历s1,拿着s1的字符在表里查找，这个字符在s2中是否出现过，出现过就删除
 * 2)
 */
public class Main {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            String temp="["+s2+"]";
            /**
             * replaceAll()方法使用给定的参数replacement替换
             * 字符串所有匹配给正则表达式的子字符串
             */
            String res=s1.replaceAll(temp,"");
            //replaceAll方法传入的第一个参数是正则表达式，字符串形式的正则表达式第[abcd]
            System.out.println(res);
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        StringBuilder sb=new StringBuilder();
//        while (sc.hasNext()) {
//            String s1 = sc.nextLine();
//            String s2 = sc.nextLine();
//            if (s2.length() < s1.length()) {
//                delectC(s1,s2);
//            }
//            else{
//                delectC(s2,s1);
//            }
//        }
//    }
//    public static void delectC(String s1,String s2){
//        Stack<Character> stack = new Stack<>();
//        List<Character> list = new ArrayList<>();
//        for (int i = 0; i < s1.length(); i++) {
//            stack.push(s1.charAt(i));
//        }
//        while (!stack.isEmpty()) {
//            for (int j = 0; j < s2.length(); j++) {
//                if (stack.peek() == s2.charAt(j)) {
//                    stack.pop();
//                }
//            }
//            list.add(stack.pop());
//        }
//        Collections.reverse(list);
//        for(int i=0;i<list.size();i++){
//            System.out.print(list.get(i));
//        }
//    }
}

/**
 * 句子逆序
 * 单词为单位 每两个单词之间以空格分隔
 */
//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String s=sc.nextLine();
//            String[] arr=s.split(" ");
//            StringBuilder sb=new StringBuilder();
//            for(int i=arr.length-1;i>=0;i--){
//                sb.append(arr[i]);
//                if(i!=0){
//                    sb.append(" ");
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }
//}