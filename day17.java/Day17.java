// //懒汉式单例模式

// class Singleton{
//     private static Singleton instance;
//     private Singleton(){
//         //private声明构造
//     }
//     public static Singleton getInstance(){
//         if(instance==null){//表示此事还没有实例化
//             instance=new Singleton();//用时再new 
//         }
//         return instance;
//     }
//     public void print(){
//         System.out.println("hello world");
//     }
// }
// public class Day17{
//     public static void main(String[] args){
//         Singleton singleton=null;//声明对象
//         singleton=Singleton.getInstance();
//         singleton.print();
//     }
// }

// //饿汉式单例模式

// class Singleton{
//     private final static Singleton INSTANCE=new Singleton();
//     private Singleton(){
//         //private声明构造
//     }
//     public static Singleton getInstance(){
//         return INSTANCE;
//     }
//     public void print(){
//         System.out.println("hello world");
//     }
// }
// public class Day17{
//     public static void main(String[] args){
//         Singleton singleton=null;//声明对象
//         singleton=Singleton.getInstance();
//         singleton.print();
//     }
// }

// //测试泛型
// public class Day17{
//     public static void main(String[] args){

//         MyCollection<String> mc=new MyCollection<String>();
//         mc.set("yida",0);

//         String i=mc.get(0);//使用泛型以后就不需要强转
//     }
// }
// //定义一个容器
// class MyCollection<E>{//可以在类的声明处增加泛型列表，如：<T,E,V>此处字符可以是任何标识符，一般采用这三个字母
//     Object[] obj=new Object[5];
//     public void set(E e,int index){
//         obj[index]=e;
//     }
//     public E get(int index){
//         return (E)obj[index];
//     }
// }
//测试Collect接口中的方法

public class Day17{
    public static void main(String[] args) {
        Collection<String> c=new ArrayList<>();
        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("益逹");
        c.add("joyce");
         System.out.println(c);
    }
}