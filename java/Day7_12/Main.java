package BJuly.Day7_12;

/**
 * 动态规划
 */
//public class Main {
//    public static int calculateMax(int[] prices){
//        //第一次买入的最好的价格（越低越好）
//        int firstBuy=Integer.MAX_VALUE;
//        //第一次卖出的价格，越高越好
//        int firstSell=0;
//        //第二次买入时剩余的最高收益，越高越好
//        int secondBuy=Integer.MAX_VALUE;
//        //第二次卖出时总的最高收益，越高越好
//        int secondSell=0;
//        for(int price:prices){
//            //当前第一次买入的价格
//            firstBuy=Math.min(firstBuy,price);
//            //当前价格-买入价格=第一次买卖的收益
//            firstSell=Math.max(firstSell,price-firstBuy);
//            //第一次卖出的收益-当前价格=当前价格下第二次买入后还剩余的收益
//            secondBuy=Math.max(secondBuy,firstSell-price);
//            //剩余收益+当前价格=当前价格下，第二次买卖的收益
//            secondSell=Math.max(secondSell,secondBuy+price);
//        }
//        return secondSell;
//    }
//}

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Main{
//    /**
//     * 计算你能获得的最大收益
//     *
//     * @param prices Prices[i]即第i天的股价
//     * @return 整型
//     */
//    public static int calculateMax(int[] prices) {
//        if(prices.length<2){
//            return 0;
//        }
//        //第一次买的最大收益
//        List<Integer> list1=new ArrayList<>();
//
//        for(int i=0;i<prices.length-1;i++){
//            for(int j=i;j<prices.length-1;j++){
//                int t=prices[j]-prices[i];
//                for(int k=j;k<prices.length;k++){
//                    for(int v=k;v<prices.length;v++){
//                        int t2=prices[v]-prices[k];
//                        list1.add(t+t2);
//                    }
//                }
//            }
//        }
//        Collections.sort(list1);
//        Collections.reverse(list1);
//        return list1.get(0);
//    }
//
//    public static void main(String[] args) {
//        int[] arr=new int[]{3,8,5,1,7,8};
//        System.out.println(calculateMax(arr));
//    }
//}

/**
 * 富豪找陌生人换钱问题，复杂度O（1）
 * 富豪的钱的单位是万元 陌生人的单位是分
 */
public class Main{
    public static void main(String[] args) {
        long sumRich=30*10;
        long sumStranger=(1L<<30)-1;
        System.out.println(sumRich+" "+sumStranger);
    }
}










