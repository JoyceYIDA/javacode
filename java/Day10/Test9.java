package Day10;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

////输入n个整数；输出次数大于等于数组长度一半的数
//public class Test9 {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        List<String> list = new LinkedList<>();
//        String str=new String();
//        if(scanner.hasNext()){
//            str=scanner.nextLine();
//        }
//        String[] arr=str.split(" ");
//        for(int i=0;i<arr.length;i++){
//            list.add(arr[i].toString());
//        }
//        int n = list.size();
//        int num=0;
//        if(n%2==0){
//            num=n/2;
//        }else{
//            num=n/2+1;
//        }
//        boolean flag=false;
//        if(n==1){
//            flag=true;
//            System.out.println(list.get(0));
//        }
//        int temp=0;
//        for (int i = 0; i < list.size(); i++) {
//            int count = 1;
//            int j = 1;
//            String element=list.get(i);
//            while (j < list.size()) {
//                String data=list.get(j);
//                if (element.equals(data)) {
//                    count++;
//                    list.remove(j);
//                } else {
//                    j++;
//                }
//            }
//            if (count >= num) {
//                System.out.println(element);
//                flag=true;
//            }
//        }
//        if(!flag){
//            System.out.println("No");
//        }
//    }
//}

import java.util.Scanner;
public class Test9{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNext()){
            int E=scanner.nextInt();
            int F=scanner.nextInt();
            int G=scanner.nextInt();
            int H=scanner.nextInt();
            int A=(E+G)/2;
            int B=(F+H)/2;
            int C=(H-F)/2;
            if((A-B==E)&&(B-C==F)&&(A+B==G)&&(B+C==H)){
                System.out.println(A+","+B+","+C);
            }else{
                System.out.println("No");
            }
        }
    }
}