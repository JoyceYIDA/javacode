package AJuly.Day7_1;

import javafx.scene.transform.Scale;

import java.text.Format;
import java.util.Scanner;
import java.util.Stack;

///**
// * 计算学分绩点
// */
//public class Main {
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            int[] credit=new int[n];
//            int temp1=0;
//
//            for(int i=0;i<n;i++){
//                credit[i]=sc.nextInt();
//                temp1=temp1+credit[i];
//            }
//
//            int[] point=new int[n];
//            double temp2=0.0;
//            for(int i=0;i<n;i++){
//                point[i]=sc.nextInt();
//                temp2=temp2+GPA(point[i])*credit[i];
//            }
//            double res=temp2/temp1;
//            System.out.println(String.format("%.2f",res).toString());
//        }
//    }
//    public static double GPA(int score){
//        double res=0.0;
//        if(score<=100&&score>89){
//            res= 4.0;
//        }else if(score<90&&score>=85){
//            res= 3.7;
//        }else if(score<85&&score>=82){
//            res=3.3;
//        }else if(score<82&&score>=78){
//            res=3.0;
//        }else if(score<78&&score>=75){
//            res=2.7;
//        }else if(score<75&&score>=72){
//            res=2.3;
//        }else if(score<72&&score>=68){
//            res=2.0;
//        }else if(score<78&&score>=64){
//            res=1.5;
//        }else if(score<64&&score>=60){
//            res=1.0;
//        }else{
//            res=0;
//        }
//        return res;
//    }
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            String s1=s.split("\\.")[0] ;
            String s2=s.split("\\.")[1] ;
            String[] arr1={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
            String str=RMB1(s1,arr1)+"元"+RMB2(s2,arr1);
            System.out.println(str);
        }
    }
    public static String RMB1(String s1,String[] arr1){

        String[] arr2={"拾","佰","千","万"};
        String res=new String();
        int len=s1.length();
        for(int i=0;i<len;i++){
            int num=s1.charAt(i)-48;
            if(i!=len-1&&num!=0){
                res+=(arr1[num]+arr2[len-2-i]);
            }else{
                if(arr1[num].equals("零") &&
                        res.substring(res.length()-1,res.length())
                                .equals("零")){
                    continue;
                }
                else{
                    res+=arr1[num];
                }
            }
        }
        return res;
    }
    public static String RMB2(String s1,String[] arr1){
        String res=new String();
        String[] arr2={"分","角"};
        int len=s1.length();
        for(int i=0;i<len;i++){
            int num=s1.charAt(i)-48;
            if(i!=len&&num!=0){
                res+=(arr1[num]+arr2[len-1-i]);
            }
        }
        return res;
    }
}

