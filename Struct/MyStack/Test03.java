package DataStruct;
import DataStruct.MyStack;

public class Test03 {
    public static void main(String[] args) {

        //创建一个栈
        MyStack ms=new MyStack();
        //压入数组
        ms.push(9);
        ms.push(8);
        ms.push(7);
        ms.push(6);
        ms.push(5);

        //取出栈顶元素
//        System.out.println(ms.pop());
////        System.out.println(ms.pop());
////        System.out.println(ms.pop());
////        System.out.println(ms.pop());
//////       输出结果：
//////        5
//////        6
//////        7
//////        8
        //查看栈顶元素
        System.out.println(ms.peek());
        System.out.println(ms.pop());
        System.out.println(ms.peek());
        System.out.println(ms.isEmpty());


    }
}
