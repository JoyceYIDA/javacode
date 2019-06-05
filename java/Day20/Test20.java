package Day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test20 {
//    //任何一个整数的m立方都可写成m个连续奇数之和
//    // 输入一个int整数，输出分解后的string
//    public static String GetSequeOddNum(int m){
//        StringBuilder sb=new StringBuilder();
//        int mid=m*m;
//        if(mid%2==1){
//            int count=0;
//            int n=m/2;
//            int num=0;
//            for(int i=0;i<n;i++){
//                num=mid-2*n+2*count;
//                sb.append(num+"+");
//                count++;
//            }
//            for(int i=n;i<m;i++){
//                sb.append(mid);
//                mid=mid+2;
//                count++;
//                if(count!=m){
//                    sb.append("+");
//                }
//            }
//        }
//        if(mid%2==0){
//            int n=m/2;
//            int count=0;
//            for(int i=0;i<n;i++){
//                int num=mid-(2*n-1)+count*2;
//                sb.append(num+"+");
//                count++;
//            }
//            for(int i=n;i<m;i++){
//                int num=mid+1;
//                sb.append(num);
//                mid=mid+2;
//                count++;
//                if(count!=m){
//                    sb.append("+");
//                }
//            }
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            int m=scanner.nextInt();
//            System.out.println(GetSequeOddNum(m));
//        }
//    }




    //给定数字0-9若干个，任意排列这些数字，但是必须全部使用。使得最后得到的数尽可能的小（0不能作为首位）
    //输入整数间用一个空格分隔
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNext()){
            String str=scanner.nextLine();
            String[] strs=str.split(" ");
            int[] arr=new int[strs.length];
            for(int i=0;i<strs.length;i++){
                arr[i]=Integer.parseInt(strs[i]);
            }
            System.out.println(minNum(arr));
        }
    }
    public static String minNum(int[] arr){
        StringBuilder sb=new StringBuilder();
        int temp=0;
        int x=1;
        if(x<10){
            //先把第一个不为0的数添加进去
            if(arr[x]!=0){
                temp=x;
            }else{
                x++;
            }
        }
        sb.append(temp);
        for(int i=0;i<10;i++){
            if(i==temp){
                for(int j=1;j<arr[i];j++){
                    sb.append(i);
                }
            }else{
                for(int j=0;j<arr[i];j++){
                    sb.append(i);
                }
            }
        }
        return sb.toString();
    }

}
