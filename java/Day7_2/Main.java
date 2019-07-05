package AJuly.Day7_2;

import java.util.*;

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            System.out.println(method(n)+" "+method(n*n));
//
//        }
//    }
//    public static long method(int num){
//        long temp=0;
//        while(num!=0) {
//            temp = num % 10 + temp;
//            num = num / 10;
//        }
//        return temp;
//    }
//}


interface IVote{
    /**
     * 设置候选人
     * @param pCandidateName 候选人名称
     * @return 添加成功返回1；否则返回0
     */
    int AddCandidate(char pCandidateName);

    /**
     * 投票
     * @param pCandidateName
     */
    void vote(char pCandidateName);

    /**
     * 获取候选人票数
     * @param pCandidateName
     * @return 该候选人的票数
     */
    int getVoteResult(char pCandidateName);

    /**
     * 清空
     */
    void clear();
}
public class Main{
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNext()){
//            String n1=sc.nextLine();
//            String s1=sc.nextLine();
//            String s2=sc.nextLine();
//            String n2=sc.nextLine();
//            Map<String,Integer> map=new HashMap<>();
//            String str=s1.trim();
//            char[] names=str.toCharArray();
//            String votes=s2.trim();
//            int temp=0;
//            for(int i=0;i<s1.length();i++){
//                for(int j=0;j<s2.length();j++){
//                    int count=0;
//                    char v=votes.charAt(i);
//                    if (v==names[i]){
//                        count++;
//                    }
//                    if(v!=' ') {
//                        map.put(v+":"+count, count);
//                    }
//                }
//            }
//            Iterator iterator=map.keySet().iterator();
//            while (iterator.hasNext()){
//                System.out.println(iterator.next());
//            }
//            Object[] arr=map.values().toArray();
//            for(int i=0;i<arr.length;i++){
//                temp=temp+(int)arr[i];
//            }
//            System.out.println("Invalid:"+temp);
//        }
//    }


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            //候选人人数
            int n=in.nextInt();
            String[] s=new String[n];
            //记录候选人
            HashMap<String,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                String temp=in.next();
                map.put(temp,0);
                s[i]=temp;
            }
            //投票人数
            int m=in.nextInt();
            Set<String> keys=map.keySet();
            int count=0;
            for(int i=0;i<m;i++){
                //投票
                String tick=in.next();
                if(keys.contains(tick)){
                    map.put(tick,map.get(tick)+1);
                }else{
                    count++;
                }
            }
            //输出结果
            for (String k:s
                 ) {
                System.out.println(k+":"+map.get(k));
            }
            System.out.println("Invalid:"+count);
        }
        in.close();
    }
}


























