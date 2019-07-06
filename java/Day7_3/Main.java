package AJuly.Day7_3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            List<Integer> list=new ArrayList<>();
//            for(int i=0;i<n;i++){
//                list.add(sc.nextInt());
//            }
//            int x=sc.nextInt();
//            if(list.contains(x)){
//                System.out.println(list.indexOf(x));
//            }else{
//                System.out.println(-1);
//            }
//        }
//    }
//}
//运行不通过
//public class Main{
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        if(sc.hasNext()){
//            String s1=sc.nextLine();
//            String s2=sc.nextLine();
//            System.out.println(decToBin(s1));
//            System.out.println(binToDec(s2));
//        }
//    }
//    public static long decToBin(String str){
//        String[] arr=str.split("\\.");
//        long res=0;
//        for(int i=arr.length-1 ;i>=0;i--){
//            String temp=Integer.toBinaryString(Integer.parseInt(arr[i]));
//            int len=temp.length();
//            if(len<8){
//                for(int x=0;x<8-len;x++){
//                    temp="0"+temp;
//                }
//            }
//            for(int j=temp.length()-1;j>=0;j--){
//                if(temp.charAt(j)=='1') {
//                    double a= Math.round(Math.pow(2, 8*(3-i)+(7-j)));
//                    long l=new Double(a).longValue();
//                    res=l+res;
//                }
//            }
//        }
//        return res;
//    }
//    public static String binToDec(String str){
//        BigInteger bi=new BigInteger(str);
//        String temp=bi.toString(2);
//        StringBuilder sb=new StringBuilder();
//        while(temp.length()<32){
//            temp="0"+temp;
//        }
//        int i=0;
//        while(i<temp.length()){
//            String ss=temp.substring(i,i+8);
//            int res=0;
//            for(int j=ss.length()-1;j>=0;j--){
//                if(ss.charAt(j)=='1'){
//                    res=res+(int)Math.pow(2,(7-j));
//                }
//            }
//            if(i==0){
//                sb.append(res);
//            }else {
//                sb.append("." + res);
//            }
//            i=i+8;
//        }
//        return sb.toString();
//    }
//}

/*
正确解答：
整数与IP地址之间的转换：
IP地址转十进制：字符串拆分，每段转二进制，二进制转Long
十进制转IP地址：十进制转为字符串，不足32位补位，按照每段8位进行拆分，每段转10进制
拼接四段组成IP地址
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(decToBin(s1));
            System.out.println(binToDec(s2));
        }
    }
    public static long decToBin(String ip){
        String[] ips=ip.split("\\.");
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<ips.length;i++){
            sb.append(binaryString(ips[i]));
        }
        //转二进制的内置方法
        return Long.parseLong(sb.toString(),2);
    }

    /**
     * 定义一个十进制转为8位二进制的函数
     * @param s 字符串
     * @return 八位的二进制字符串
     */
    private static String binaryString(String s){
        StringBuffer sb=new StringBuffer();
        int num=Integer.parseInt(s);
        int k=1<<7;
        for(int i=0;i<8;i++){
            int flag=(num&k)==0?0:1;
            sb.append(flag);
            num=num<<1;
        }
        return sb.toString();
    }
    public static String binToDec(String s){
        StringBuffer sb=new StringBuffer();
        String ip=Long.toBinaryString(Long.parseLong(s));
        String as="";
        //不够32位就在前面补0
        if(ip.length()<32){
            for(int i=0;i<32-ip.length();i++){
                as+="0";
            }
        }
        ip=as+ip;
        //将每段IP地址进行拼接
        String[] ips=new String[4];
        ips[0]=ip.substring(0,8);
        ips[1]=ip.substring(8,16);
        ips[2]=ip.substring(16,24);
        ips[3]=ip.substring(24,32);
        for(int i=0;i<4;i++){
            sb.append(Integer.parseInt(ips[i],2));
            if(i!=3){
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
