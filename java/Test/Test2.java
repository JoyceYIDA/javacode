package Test;

import java.util.Scanner;

/**
 * @author yida
 */

/**
 * 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
 *
 * 魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
 *
 * 魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
 *
 * 小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
 *
 * 输入描述:
 *
 * 输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
 *
 * 输出描述:
 *
 * 输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。
 *
 * 输入例子1:
 *
 * 10
 *
 * 输出例子1:
 *
 * 122
 */
public strictfp class Test2 {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        if(sc.hasNext()){
//            int n=sc.nextInt();
//            StringBuilder sb=new StringBuilder();
//            while(n>0){
//                if(n%2==0){
//                    n=(n-2)/2;
//                    sb.append("2");
//                }else{
//                    n=(n-1)/2;
//                    sb.append("1");
//                }
//            }
//            System.out.println(sb.reverse().toString());
//        }


//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String num=sc.next();
//            StringBuilder sb=new StringBuilder(num).reverse();
//            System.out.println(Integer.parseInt(num)+Integer.parseInt(sb.toString()));
//        }
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String s=sc.next();
//            float len=s.length();
//            int count=1;
//            for(int i=0;i<len-1;i++){
//                if(s.charAt(i)!=s.charAt(i+1)){
//                    count++;
//                }
//            }
//            System.out.println(len/count);
//        }

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();
            int x=(a+c)>>1;
            int y=(b+d)>>1;
            int z=(d-b)>>1;
            if((x-y==a)&&(y-z==b)&&(x+y==c)&&(y+z==d)){
                System.out.println(x+" "+y+" "+z);
            }else {
                System.out.println("No");
            }
        }
        sc.close();
    }
}
