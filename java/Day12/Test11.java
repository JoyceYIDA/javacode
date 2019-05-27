package Day12;


import java.util.Scanner;

/**
 * 内存回收程序不允许在指定时间内释放内存，不可以指定时间！！！
 *
 * 静态块只执行一次，JVM加载时执行；构造块在类中用{}定义，没创建一次对象执行一次·
 */


public class Test11 {


    //求两个数的最小公倍数
//    private static int method(int max,int min){
//        if(max%min==0){
//            return max;
//        }
//        int temp=0;
//        int i=1;
//        while(i<min){
//            i++;
//            if((max*i)%min==0){
//                temp=max*i;
//                break;
//            }
//        }
//        return temp;
//    }
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            int A=scanner.nextInt();
//            int B=scanner.nextInt();
//            int result=0;
//            if(A==0||B==0){
//                result=0;
//            }else if(A>B){
//                result=method(A,B);
//            }else if(A<B){
//                result=method(B,A);
//            }else{
//                result=A;
//            }
//            System.out.println(result);
//        }
//    }


    //不要二
    private static int method(int h,int w){
        //计数器
        int count=0;
        if(h%4==0||w%4==0){
            count=h*w/2;

        }else{
            count=h*w/2+1;
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int W=scanner.nextInt();
            int H=scanner.nextInt();
            System.out.println(method(H,W));
        }
    }
}
