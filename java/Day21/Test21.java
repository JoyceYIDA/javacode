package Day21;

import java.util.Scanner;

public class Test21 {
//    //设计一个函数将两个数字相加但是不能使用算术运算符
//
//    public static int addAB(int A, int B) {
//        if(A==0){
//            return B;
//        }
//        if(B==0){
//            return A;
//        }
//        //亦或就是不进位的加法结果；
//        // 与操作结果为1就说明要进位
//            int i=A^B;
//            int u=(A&B)<<1;
//            if(u==0){
//                return i;
//            }
//            return addAB(i,u);
//    }
//    public static void main(String[] args) {
//        System.out.println(addAB(2,3));
//
//    }




    //输入一个初始位置X_0，范围在1到1000 000 006
    //一次只能移动到4*x+3或者8*x+7，最多能移动100 000次
    //位置只能是被1000 000 007整除的位置；位置1 1000 000 007；位置2 2000 000 014等）
    //输入125 000 000 输出1

    /**
     * 移动公式：f(x)=4*x+4   g(x)=8*x+7;
     *
     * 两个函数的执行顺序没有影响
     * f(f(f(x)))=g(g(x))
     * 三次f变换等价于做两次g变换
     * @param
     * @return
     */


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            long x0=scanner.nextLong();
            long m=1000000007;
            long s=100000;

            //f(x)=4x+3 执行三次
            long[] begin=new long[3];

            //三次的取值
            begin[0]=x0;
            begin[1]=(4*begin[0]+3)%m;
            begin[2]=(4*begin[1]+3)%m;
            long minStep=s;
            long cur=0;
            int step=0;
            for(int i=0;i<3;i++){
                cur=begin[i];
                step=i;
                while(cur!=0&& step<minStep){
                    cur=(8*cur+7)%m;
                    step++;
                }
                minStep=minStep<step?minStep:step;
            }
            if(minStep<s){
                //执行步长没有超过s输出的最小步长
                System.out.println(minStep);
            }else{
                System.out.println(-1);
            }
        }
    }
}
