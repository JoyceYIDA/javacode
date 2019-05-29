package Day14;

import java.util.Scanner;


//public class Test13 {
//    //输入1-1000中任意一个数，算出它的阶乘结果的末尾有几个0
//
//    public static void main(String[] args){
//
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            int n=scanner.nextInt();
//            int count = 0;
//            if(n/5>0){
//                count=n/5;
//                int temp=count;
//                while(temp/5>0){
//                    count=count+temp/5;
//                    temp=temp/5;
//                }
//            }
//            System.out.println(count);
//            }
//        }
//    }


public class Test13 {
    public static void main(String [] args){
        System.out.println(new B().getValue());
    }
    static class A{
        protected int value;
        public A(int v) {
            setValue(v);
        }
        public void setValue(int value){
            this.value = value;
        }
        public int getValue(){
        try{
            value++;
            return value;
        } catch(Exception e){
            System.out.println(e.toString());
        } finally {
            this.setValue(value);
            System.out.println(value);
        }
        return value;
        }
    }
    static class B extends A{
        public B() {
            super(5);
            setValue(getValue() - 3);
        }
        public void setValue(int value){
            super.setValue(2 * value);
        }
    }
}
