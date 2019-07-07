package AJuly.Day7_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            //不放回的抽奖；第一个人有n种抽奖的可能，第二个人有n-1种
            //那么就是n的阶乘
            float sum1=factorial(n);
            float sum2=count(n);
            float res=(sum2/sum1)*100;
            System.out.println(String.format("%.2f",res)+"%");
        }
    }

    /**
     * 排错算法
     * @param n
     * @return
     */
    public static float count(int n){
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        }else{
            return (n-1)*(count(n-1)+count(n-2));
        }
    }

    /**
     * n的阶乘
     * @param num
     * @return
     */
    public static float factorial(int num){
        float res=1;
        if(num==0){
            return 1;
        }else if(num>0){
            res=num* factorial(num-1);
        }
        return res;
    }
}
