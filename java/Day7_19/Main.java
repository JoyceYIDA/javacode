package CJuly.Day7_19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            String t=sc.nextLine();
            List<Integer> list=new ArrayList<>();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(sc.nextInt());
            }

//            int sum=0;
//            int count1=0;
//            int count2=0;
//            for(int i=0;i<n;i++){
//                if(list.get(i)>0){
//                    sum=sum+list.get(i);
//                    count2++;
//                }else{
//                    sum=0;
//                    count1++;
//                }
//                temp.add(sum);
//            }
//            if(count1==n) {
//                Collections.sort(list);
//                Collections.reverse(list);
//                System.out.println(list.get(0));
//            }
//            else {
//                Collections.sort(temp);
//                Collections.reverse(temp);
//                if(count2==n){
//                    if(list.get(0)>list.get(n-1)){
//                        System.out.println(temp.get(0)-list.get(n-1));
//                    }else{
//                        System.out.println(temp.get(0)-list.get(0));
//                    }
//                }else {
//                    System.out.println(temp.get(0));
//                }
//            }
        }
    }
}
//
//public class Main{
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String s=sc.nextLine();
//            String[] arr=s.split(";");
//            int i=0;
//            int j=0;
//            for(int k=0;k<arr.length;k++){
//                String co=arr[k];
//                int len=co.length();
//                //长度小于1或者大于4的字符串都是不合法的
//                if(len<4&&len>1){
//                    String temp=co.substring(1,len);
//                    boolean flag=true;
//                    for(int m=0;m<temp.length();m++){
//                        if(temp.charAt(m)<'0'|| temp.charAt(m)>'9'){
//                            flag=false;
//                        }
//                    }
//                    if(flag) {
//                        int num = Integer.parseInt(temp);
//                        if (co.charAt(0) == 'A') {
//                            i = i - num;
//                        } else if (co.charAt(0) == 'S') {
//                            j = j - num;
//                        } else if (co.charAt(0) == 'W') {
//                            j = j + num;
//                        } else if (co.charAt(0) == 'D') {
//                            i = i + num;
//                        } else {
//                            //不合法
//                            continue;
//                        }
//                    }
//                }
//            }
//            System.out.println(i+","+j);
//        }
//    }
//}
