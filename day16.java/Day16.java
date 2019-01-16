// //使用object接收接口对象
// interface IMassage{
//     public void getMessage();
// }
// class MessageImpl implements IMassage{
//     //方法覆写
//     public String toString(){
//         return "i am joyce";
//     }
//     public void getMessage(){
//         System.out.println("我是益逹");
//     }
// }
// public class Day16{
//     public static void main(String[] args){
//         IMassage msg=new MessageImpl();//子类向父接口转型
//         Object obj=msg;//接口向Object转型
//         System.out.println(obj);
//         IMassage temp=(IMassage)obj;//强制类型转换
//         temp.getMessage();
//     }
// }

// package czy.joyce.java;
// public class Day16{
//     public static void main(String[] args){
//         System.out.println("hello yida");
//     }
// }

// //编写一个类被其他程序类使用
// package www.czy.java.util;
// public class Message{
//     public void print(){
//         System.out.println("[Message]hello czy");
//     }
// }
// //导入包
// package www.czy.java.test;
// import www.czy.java.util.Message;//导入程序类
// public class Day16{
//     public static void main(String[] args){
//         Message msg=new Message();
//         msg.print();
//     }
// }

// package test;
// class Singleton{
//     public void print(){
//         System.out.println("hello world");
//     }
// }
// public class Day16{
//     public static void main(String[] args){
//         Singleton singleton=null;//声明对象
//         singleton=new Singleton();//实例化对象
//         singleton.print();
//     }
// }//在进行实例化时调用了Singleton的无参构造


// package test;
// class Singleton{
//     Singleton instance=new Singleton();
//     private Singleton(){
//         //private声明构造
//     }
//     public void print(){
//         System.out.println("hello world");
//     }
// }
// public class Day16{
//     public static void main(String[] args){
//         Singleton singleton=null;//声明对象
//         singleton=Singleton.instance;//实例化对象
//         singleton.print();
//     }
// }

package test;
class Singleton{
    static Singleton instance=new Singleton();//使用stataic产生实例化对象，在类的内部可以访问私有结构
    private Singleton(){
        //private声明构造
    }
    public void print(){
        System.out.println("hello world");
    }
}
public class Day16{
    public static void main(String[] args){
        Singleton singleton=null;//声明对象
        singleton=Singleton.instance;
        singleton.print();
    }
}