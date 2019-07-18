package CJuly;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        Map<Integer,Integer> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        while(sc.hasNext()){
            int n=sc.nextInt();
            int res=0;
            String t=sc.nextLine();
            for(int a=0;a<n;a++){
                int i=sc.nextInt();
                int l=sc.nextInt();
                if(i==1){
                    if(!map.containsKey(l)){
                        map.put(l,1);
                    }else{
                        map.put(l,map.get(l)+1);
                    }
                }else{
                    if(map.containsKey(l)){
                        map.put(l,map.get(l)-1);
                    }
                }
                for(int j=3;j<n+3;j++){
                    if(map.containsValue(j)){
                        list.add("Yes");
                        break;
                    }
                }
                List<Integer> key=new ArrayList<>();
                Iterator iterator=map.keySet().iterator();
                while(iterator.hasNext()){
                    key.add((Integer) iterator.next());
                }

            }
            for(int i=0;i<n;i++){
                System.out.println(list.get(i));
            }
        }
    }
}


/**
 * 地下迷宫：找出体力消耗的最短路径，不能逃离迷宫就输出“Can not escape”
 */
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            int m=sc.nextInt();
//            int p=sc.nextInt();
//            String t=sc.nextLine();
//            int [][] arr=new int[n][m];
//            for(int i=0;i<n;i++){
//                String str=sc.nextLine();
//                String s=str.trim();
//                for(int j=0;j<m;j++){
//                    arr[i][j]=s.charAt(j);
//                }
//            }
//            findWay(arr,n,m);
//        }
//    }
//    public static void findWay(int[][] arr,int n,int m){
//        List<String> list=new ArrayList<>();
//        list.add(0+","+0);
//        boolean flag=true;
//        for(int i=0;i<n-1;i++){
//            for(int j=0;j<m-1;j++){
//                if(arr[i][j+1]==1){
//                    list.add(i+","+(j+1));
//                }else if(arr[i+1][j]==1){
//                    list.add((i+1)+","+j);
//                }else if((i-1>0)&&(arr[i-1][j]==1)){
//                    list.add(i-1+","+j);
//                }else if((j-1>0)&&(arr[i][j-1]==1)){
//                    list.add(i+","+(j-1));
//                }else{
//                    flag=false;
//                }
//            }
//        }
//        if(flag){
//            for(int i=0;i<list.size();i++){
//                System.out.println("["+list.get(i)+"]");
//            }
//        }else {
//            System.out.println("Can not escape");
//        }
//    }
//}