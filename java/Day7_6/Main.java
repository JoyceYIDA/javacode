package AJuly.Day7_6;

import java.math.BigInteger;
import java.util.*;

//public class Main{
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()) {
//            int n = sc.nextInt();
//            String t = sc.nextLine();
//            String[] strs = new String[n];
//            for (int i = 0; i < n; i++) {
//                strs[i] = sc.nextLine();
//            }
//            method(strs,n-1);
//        }
//    }
//    public static void method(String[] strs,int n){
//        for(int i=0;i<n;++i){
//            for(int j=0;j<n-i-1;++j){
//                if(strs[j].length()>strs[j+1].length()){
//                    swap(strs,j,j+1);
//                }else if(strs[j].length()==strs[j+1].length()){
//                   // 长度长的一定是大的，长度相等的话就从字符串第一个数开始比较
//                     int len = strs[i].length();
//                     for (int k = 0; k < len; k++) {
//                     char a = strs[j].charAt(k);
//                     char b = strs[j + 1].charAt(k);
//                     if (a > b) {
//                           swap(strs, j,j+1);
//                     }
//                }
//                }
//            }
//        }
//        for(int m=0;m<n;m++){
//            System.out.println(strs[m]);
//        }

//        int i = 0;
//        while (i < n-1) {
//            for()
//            if (strs[i].length() > strs[i + 1].length()) {
//                swap(strs, i, i + 1);
//            } else if(strs[i].length()<strs[i+1].length()){
//                i++;
//            }else{
//                //长度长的一定是大的，长度相等的话就从字符串第一个数开始比较
//                int len = strs[i].length();
//                for (int j = 0; j < len; i++) {
//                    char a = strs[i].charAt(j);
//                    char b = strs[i + 1].charAt(j);
//                    if (a > b) {
//                        swap(strs, i, i - 1);
//                    }
//                }
//            }
//        }
//    }
//    public static void swap(String[] strs,int index1,int index2){
//        String temp=strs[index1];
//        strs[index1]=strs[index2];
//        strs[index2]=temp;
//    }
//}

/**
 * 奇偶校验
 * 数字3实际存储是用她的ASSII码----51（十进制）转化为二进制为 0110011
 * 取最高位为奇校验位，校验位为1
 */
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String str=sc.nextLine();
//            test(str.toCharArray());
//        }
//    }
//    public static void test(char[] s){
//        //最终的结果是 校验位+七位二进制
//        int[] result=new int[8];
//        for(int i=0;i<s.length;i++){
//            int n=0x01;
//            int j=7;
//            int sum=0;
//            while(j>0){
//                //进行七次与运算 得出1的个数以及二进制形式
//                result[j]=(s[i]&n)==0?0:1;//与运算
//                if(result[j]==1)
//                    sum++;
//                n=n<<1;
//                j--;
//            }
//            if((sum&1)==0)
//                result[0]=1;//进行校验
//            for(int k=0;k<result.length;k++){
//                System.out.print(result[k]);
//            }
//            result[0]=0;
//            System.out.println();
//        }
//    }
//}

/**
 * 大整数排序
 * 通过Arrays的排序方法以及BigInteger
 */
public  class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n= sc.nextInt();
            BigInteger[] bg=new BigInteger[n];
            for(int i=0;i<n;i++){
                bg[i]=sc.nextBigInteger();
            }
            Arrays.sort(bg);
            for(int i=0;i<n;i++){
                System.out.println(bg[i]);
            }
        }
    }
}