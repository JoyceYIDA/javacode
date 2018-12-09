//练习编写斐波那契数

    public class Fibonacci{
            public static int Fib(int i){
            if(i<3){
                return 1;
            }
            else{
                return Fib(i-2)+Fib(i-1);//递归
            }
        }
        public static void main(String[] args){
            int i=5;
         Fib(i);
         System.out.println(Fib(i));
         //输出第五个斐波那契数
        }
    }