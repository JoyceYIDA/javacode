package Day15;

import java.util.Scanner;

public class Test14 {
    public static int walk(int x,int y){
        //递归出口，行为1或者列为1就只有一条路
        if(x==1||y==1){
            return 1;
        }else{
            return walk(x-1,y)+walk(x,y-1);
        }
    }

//求一个数变为斐波那契数的最短步数，每次只能+1或-1；

    public static int isFib(int n){
        int a=0,b=1;
        int temp=0;
        while(a<n) {
            temp=a;
            a=b;
            b=temp+b;
        }
        if(a==n){
            return 0;
        }if(n-temp==a-n){
            return n-temp;
        }
        return n-temp>a-n?a-n:n-temp;
    }
    public static void main(String[] args) {
//        System.out.println(walk(2,3));
        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNext()){
            int x=scanner.nextInt();
            System.out.println(isFib(x));
        }
    }
}
