// class Person{
//     private String name;
//     private int age;
//     public Person(String name,int age){
//         this.name=name;
//         this.age=age;
//     }
//     public String toString(){
//         return this.name+","+this.age;
//     }
// //equals
//        public boolean equlas(Object obj){
//          if(this==obj){//判断地址是否相等
//         return true;
//        }
//          if(!(obj instanceof Person)){//判断传入对象是否是Person对象
//           return false;
//        }//向下转型判断属性值是否相等
//            Person per=(Person)obj;
//           return per.name.equals(this.name)&&per.age==this.age;
//     }
// }
// public class Day11{
//     public static void main(String[] args){
//         fun(new Person("Tom",30));
//         fun("hello");
//     }
//     public static void fun(Object obj){
//         System.out.println(obj);
//     }
// }

//接口
// interface IMassage{
//     public static final String MSG="i am a student!";//全局常量
//     public abstract void print();//抽象方法
// }
// interface INews{
//     public abstract String getNews();
// }
// class MassageImpl implements IMassage,INews{//子类必须覆写所有抽象方法
//     public void print(){
//         System.out.println(IMassage.MSG);
//     }
//     public String getNews(){
//         return IMassage.MSG;//访问常量都建议加上类名称
//     }
// }
// public class Day11{
//     public static void main(String[] args){
//         IMassage m=new MassageImpl();//子类向上转型，为弗雷接口实例化对象
//         m.print();//调用被子类覆写过的方法
//         INews n=(INews)m;//父接口的相互转换
//         System.out.println(n.getNews());
//     }
// }
interface A{
    public void printA();
}
interface B{
    public void printB();
}
interface C extends A,B{
    public void printC();
}
abstract class CImpl implements C{
    //强调这个类是接口
}
class Impl implements C{//所有方法全部覆写
    public void printA(){}
    public void printB(){}
    public void printC(){}
}
public class Day11{
    public static void main(String[] args){

    }
}