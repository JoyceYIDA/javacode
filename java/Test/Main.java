package Test;

import java.util.*;

/**
 * @author yida
 */
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        Map<Integer,Integer> map=new HashMap<>();
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            int m=sc.nextInt();
//            for(int i=1;i<=n;i++){
//                map.put(i,0);
//            }
//            for(int i=0;i<m;i++){
//                int key=sc.nextInt();
//                if(map.containsKey(key)){
//                    map.put(key,map.get(key)+1);
//                }
//            }
//            Object[] arr=map.values().toArray();
//            Arrays.sort(arr);
//            System.out.println(arr[0]);
//        }
//    }
//}

//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            int k=sc.nextInt();
//            int[] cls=new int[n];
//            int[] les=new int[n];
//            for(int i=0;i<n;i++){
//                cls[i]=sc.nextInt();
//            }
//            for(int i=0;i<n;i++){
//                les[i]=sc.nextInt();
//            }
//            int now=0;
//            for(int i=0;i<n;i++){
//                now=now+cls[i]*les[i];
//            }
//            //现在没有叫醒时获取的知识点的感兴趣值
//            //尝试着在他每次不清醒的时候叫醒他，取出最大值
//            int res=now;
//            int i=0;
//            while (i<n){
//                if(les[i]==0){
//                    now+=1*cls[i];
//                }
//                if(++i>=k){
//                    res=Math.max(now,res);
//                    if(i-k<n&&i-k>=0){
//                        if(les[i-k]==0){
//                            now-=1*cls[i-k];
//                        }
//                    }
//                }
//            }
//            System.out.println(res);
//        }
//        sc.close();
//    }
//}

//public class Main{
//    public static void main(String[] args) {
////        Scanner sc=new Scanner(System.in);
////        while(sc.hasNext()){
////            int n=sc.nextInt();
////            int[] apple=new int[n];
////            int temp=0;
////            for(int i=0;i<n;i++){
////                int a=sc.nextInt();
////                temp=temp+a;
////                apple[i]=temp;
////            }
////            int m=sc.nextInt();
////            int[] arr=new int[m];
////            for(int i=0;i<m;i++){
////                arr[i]=sc.nextInt();
////                for(int j=0;i<apple.length;j++){
////                    if(arr[i]<=apple[j]){
////                        System.out.println(j+1);
////                        break;
////                    }
////                }
////            }
////        }
////        sc.close();
//        Integer i1=59;
//        int i2=59;
//        Integer i3=Integer.valueOf(59);
//        Integer i4=new Integer(59);
//        System.out.println(i1==i2);
//        System.out.println(i1==i3);
//        System.out.println(i3==i4);
//        System.out.println(i2==i4);
//    }
//}
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNext()){
//            int n=sc.nextInt();
//            List<Integer> list=new ArrayList<>();
//            for(int i=0;i<n;i++){
//                list.add(sc.nextInt());
//            }
//            List<Integer> res=new ArrayList<>();
//            if(n==3){
//                res.add(list.get(2));
//                res.add(list.get(0));
//                res.add(list.get(1));
//            }else {
//                if (n % 2 == 0) {
//                    res = method(list, n);
//                } else {
//                    int temp = list.get(n - 1);
//                    list.remove(list.get(n - 1));
//                    res = method(list, n - 1);
//                    Collections.reverse(res);
//                    res.add(temp);
//                }
//            }
//            for(int i=0;i<n-1;i++){
//                System.out.print(res.get(i)+" ");
//            }
//            System.out.print(res.get(n-1));
//        }
//    }
//    public static List<Integer> method(List<Integer> list1,int n){
//        List<Integer> list2=new ArrayList<>();
//        int len1=n;
//        int len2=0;
//        for(int i=0;i<list1.size();i++){
//            if(i<n/2){
//                list2.add(list1.get(len1-1));
//                len1=len1-2;
//            }else{
//                list2.add(list1.get(len2));
//                len2=len2+2;
//            }
//        }
//        return list2;
//    }
//}


//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            String temp=sc.nextLine();
//            String str=sc.nextLine();
//            char[] arr=str.toCharArray();
//            int res=0;
//            for(int i=0;i<n;i++){
//               if(arr[i]=='L'){
//                   res++;
//               }else{
//                   res--;
//               }
//               res=res%4;
//            }
//            if(res==0){
//                System.out.println("N");
//            }else if(res==1||res==-3){
//                System.out.println("W");
//            }else if(res==2||res==-2){
//                System.out.println("S");
//            }else{
//                System.out.println("E");
//            }
//        }
//    }
//}


//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            int m=sc.nextInt();
//            int res=1;
//            for(int i=1;i<=n-m;i++){
//                res+=i;
//            }
//            System.out.println(res);
//        }
//    }
//}


public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            long count=0;
            if(k==0){
                count=(long)n*n;
            }else{
                for(long y=k+1;y<=n;y++){
                    count+=(n/y)*(y-k)+(n%y>=k?n%y-k+1:0);
                }
            }
            List list=new ArrayList();
            list.re
        }

    }
}




