// package www.czy.java;
// public class Day15{
//     public static void main(String[] args){
//         System.out.println("hello i am day15");
//     }
// }

// //观察String与Object输出
// class Person{
//     private String name;
//     private int age;
//     public Person(String name,int age){
//         this.name=name;
//         this.age=age;
//     }
// }
// class Student{}
// public class Day15{
//     public static void main(String[] args){
//         fun(new Person("joyce",18));
//         fun("hello");
//     }
//     public static void fun(Object obj){
//         System.out.println(obj.toString());//默认输出对象调用的就是toString()方法
//     }
// }
// //输出结果
// //Person@15db9742（地址）
// //hello（字符串内容）
//覆写toString()方法
class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.age=age;
        this.name=name;
    }
    //方法覆写
    public String toString(){
        return "姓名"+this.name+"，年龄"+this.age;
    }
}
class Student{}
public class Day15{
    public static void main(String[] args){
        fun(new Person("joyce",18));
        fun("hello");
    }
    public static void fun(Object obj){
        System.out.println(obj.toString());//默认输出对象调用的就是toString()方法
    }
}
