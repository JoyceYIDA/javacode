package BJuly.Day7_10;
//import java.util.*;
//public class Main {
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
////            int cx=0;
////            int cy=0;
////            int c=0;
////            List<String> listX=new ArrayList<>();
////            List<String> listY=new ArrayList<>();
////            int n=sc.nextInt();
////            for(int i=0;i<n;i++){
////                String s=sc.nextLine();
////                String x=s.split(" ")[0];
////                String y=s.split(" ")[1];
////                if(x=="C"){
////                    if(y=="J"){
////                        listX.add("C");
////                        cx++;
////                    }else if(y=="B"){
////                        listY.add("B");
////                        cy++;
////                    }else{
////                        c++;
////                    }
////                }
////                if(x=="B"){
////                    if(y=="C"){
////                        listX.add("B");
////                        cx++;
////                    }else if(y=="J"){
////                        listY.add("J");
////                        cy++;
////                    }else{
////                        c++;
////                    }
////                }
////                if(x=="J"){
////                    if(y=="B"){
////                        listX.add("J");
////                        cx++;
////                    }else if(y=="C"){
////                        listY.add("C");
////                        cy++;
////                    }else{
////                        c++;
////                    }
////                }
////            }
////            System.out.println(cx+" "+c+" "+cy);
////            System.out.println(cy+" "+c+" "+cx);
////
//            int n=sc.nextInt();
//            String t=sc.nextLine();
//            int count=0;
//            Map<String,Integer> mapX=new HashMap<>();
//            Map<String,Integer> mapY=new HashMap<>();
//            int cx=0;
//            int cy=0;
//            for(int i=0;i<n;i++){
//                String str=sc.nextLine();
//                String x=str.split(" ")[0];
//                String y=str.split(" ")[1];
//                if(x.equals(y)){
//                    count++;
//                }
//                if(x.equals("C")){
//                    if(y.equals("J")) {
//                        cx++;
//                        if (!mapX.containsKey(x)) {
//                            mapX.put(x, 1);
//                        } else {
//
//                            mapX.put(x, mapX.get(x) + 1);
//                        }
//                    }else{
//                        if (!mapX.containsKey(y)) {
//                            mapY.put(y, 1);
//                        } else {
//                            mapY.put(y, mapX.get(y) + 1);
//                        }
//                    }
//                }
//                if(x.equals("B")){
//                    if(y.equals("C")) {
//                        cx++;
//                        if (!mapX.containsKey(x)) {
//                            mapX.put(x, 1);
//                        } else {
//                            mapX.put(x, mapX.get(x) + 1);
//                        }
//                    }else{
//                        if (!mapX.containsKey(y)) {
//                            mapY.put(y, 1);
//                        } else {
//                            mapY.put(y, mapX.get(y) + 1);
//                        }
//                    }
//                }
//                if(x.equals("J")){
//                    if(y.equals("B")) {
//                        cx++;
//                        if (!mapX.containsKey(x)) {
//                            mapX.put(x, 1);
//                        } else {
//                            mapX.put(x, mapX.get(x) + 1);
//                        }
//                    }else{
//                        if (!mapX.containsKey(y)) {
//                            mapY.put(y, 1);
//                        } else {
//                            mapY.put(y, mapX.get(y) + 1);
//                        }
//                    }
//                }
//
//
//
////                if(x.equals("J")&&y.equals("B")){
////                    if(!mapX.containsKey("J")){
////                        mapX.put("J",1);
////                        cx++;
////                    }else{
////                        mapX.put("J",mapX.get("J")+1);
////                    }
////                }
////                if(x.equals("B")&&y.equals("C")){
////                    if(!mapX.containsKey("B")){
////                        mapX.put("B",1);
////                        cx++;
////                    }else{
////                        mapX.put("B",mapX.get("B")+1);
////                    }
////                }
//            }
//            cy=n-cx-count;
//            System.out.println(cx+" "+count+" "+cy);
//            System.out.println(cy+" "+count+" "+cx);
//            System.out.println(win(mapX)+" "+win(mapY));
//        }
//    }
//    public static String win(Map<String,Integer> mapX){
//        List<Map.Entry<String,Integer>> listX=new ArrayList<Map.Entry<String,Integer>>(mapX.entrySet());
//        Collections.sort(listX, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return (o2.getValue()-o1.getValue());
//            }
//        });
//        return listX.get(1).getKey();
//    }
//}

import java.util.*;

//public class Main {
//    /**
//     * 上楼梯
//     * @param n
//     * @return
//     */
//    public static int countWays(int n) {
//        if (n < 1)
//            return 0;
//        if (n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        if(n==3)
//            return 4;
//        int array[] =new int[n];
//        array[0] =1;
//        array[1] =2;
//        array[2] =4;
//        for(int i=3;i<n;i++){
//            array[i]=((array[i-1]+array[i-2])%1000000007+array[i-3]%1000000007)%1000000007;
//        }
//        return array[n-1];
//    }
//    public static void main(String[] args){
//
//        System.out.println(countWays(4));
//    }
//}


/**
 * 剪刀石头布
 * 计算甲方赢的次数 平局次数 甲方输的次数
 * 计算乙方赢的次数 平局次数 乙方输的次数
 * 并且算出甲方和乙方赢的最多是什么
 */
public class Main{
    public static void main(String[] args) {
        Record[] records=new Record[2];
        records[0]=new Record();
        records[1]=new Record();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String a=sc.next();
            String b=sc.next();
            judge(a,b,records);
        }
        System.out.format("%d %d %d\n",records[0].win,records[0].tie,records[0].lose);
        System.out.format("%d %d %d\n",records[1].win,records[1].tie,records[1].lose);
        System.out.format(mostWinGesture(records[0].winCount)+" "+mostWinGesture(records[1].winCount));
    }

    /**
     * 私有内部类
     */
    private static class Record{
        public int win;
        public int tie;
        public int lose;
        TreeMap<String,Integer> winCount;

        /**
         * 构造方法
         */
        Record(){
            this.win=0;
            this.tie=0;
            this.lose=0;
            this.winCount=new TreeMap<>();
            this.winCount.put("B",0);
            this.winCount.put("C",0);
            this.winCount.put("J",0);
        }
    }
    private static void win(Record[] records,int win,String gesture){
        int lose=1-win;
        records[win].win++;
        records[lose].lose++;
        int winCount=records[win].winCount.get(gesture);
        records[win].winCount.put(gesture,winCount+1);
    }
    private static void judge(String a,String b,Record[] records){
        if(a.equals("B")){
            if(b.equals("B")){
                records[0].tie++;
                records[1].tie++;
            }else if(b.equals("C")){
                win(records,0,"B");
            }else{
                win(records,1,"J");
            }
        }else if(a.equals("C")){
            if(b.equals("B")){
                win(records,1,"B");
            }else if(b.equals("J")){
                win(records,0,"C");
            }else{
                records[0].tie++;
                records[1].tie++;
            }
        }else{
            if(b.equals("B")){
                win(records,0,"J");
            }else if(b.equals("C")){
                win(records,1,"C");
            }else{
                records[0].tie++;
                records[1].tie++;
            }
        }
    }
    private static String mostWinGesture(TreeMap<String,Integer> winCount){
        if(winCount.get("C")>=winCount.get("J")){
            if(winCount.get("B")>=winCount.get("C")){
                return "B";
            }else{
                return "C";
            }
        }else{
            if(winCount.get("B")>=winCount.get("J")){
                return "B";
            }else{
                return "J";
            }
        }
    }
}







