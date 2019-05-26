package Day9;

import java.util.Scanner;
import java.util.Stack;


//数组复制效率最高：System.arraycopy;

//public class Test8 {
//    //两个栈实现一个队列
//        Stack<Integer> stack1 = new Stack<Integer>();
//        Stack<Integer> stack2 = new Stack<Integer>();
//
//        public void push(int node) {
//            //栈是先进后出，所以放元素和队列的相同
//            stack1.push(node);
//        }
//
//        public int pop() {
//
//            if (stack2.isEmpty()) {
//                while (stack1.size() > 1) {
//                    stack2.push(stack1.pop());
//                }
//                int result = stack1.pop();
//                while (!stack2.isEmpty()) {
//                    stack1.push(stack2.pop());
//                }
//                return result;
//            } else {
//                while (stack2.size() > 1) {
//                    stack1.push(stack2.pop());
//                }
//                int result = stack2.pop();
//                while (stack1.size() > 1) {
//                    stack2.push(stack1.pop());
//                }
//                return result;
//            }
//        }
//
//        public static void main(String[] args) {
//            Test8 test = new Test8();
//            test.push(10);
//            test.push(20);
//            test.push(30);
//            test.push(40);
//            test.push(50);
//            for (int i = 0; i < 5; i++) {
//                System.out.println(test.pop());
//            }
//        }
//    }

public class Test8{

    //有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，
    // 这些物品的总体积必须是40。John现在有n个想要得到的物品，
    // 每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，
    // 如果选出的物体的总体积是40，那么利用这个神奇的口袋，
    // John就可以得到这些物品。
    // 现在的问题是，John有多少种不同的选择物品的方式。

    static int[] weight;
    static int N;
    static int count=0;
    public static void method(int s,int n){
        //刚好装满
        if(s==0){
            ++count;
            return ;
        }
        if(s<0||(s>0&&n<1))
            return ;
        method(s-weight[n],n-1);
        method(s,n-1);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            N=scanner.nextInt();
            weight=new int[N+1];
            for(int i=1;i<=N;i++){
                weight[i]=scanner.nextInt();
            }
            method(40,N);
            System.out.println(count);
        }
    }
}
