// class Person{
//     public void print(){
//         System.out.println("Person类的print方法");
//     }
// }
// class Student extends Person{
//     public void print(){
//         System.out.println("Student类的print方法");
//     }
// }

// public class Day9{
//     public static void main(String[] args){
//     //     //向上转型
//     //     Person per=new Student();
//     //     //向下转型
//     //     Student stu=(Student) per;//Exception in thread "main" java.lang.ClassCastException: Person cannot be cast to Student
//     //    // at Day9.main(Day9.java:16)运行时错误，所以向下转型一定要先向上转型
//        if(per instanceof Student){//instanceof可以用来判断所有强制类型转换
//            Person per=new Person();
//            Student stu=(Student) per;
//        }else{
//         System.out.println("无法强制类型转换");
//         per=new Student();
//        }
//     }
// }

// //抽象类
// abstract class Person{
//     //抽象方法
//     public abstract void print();//没有方法体，且有abstract关键字
//     //抽象方法
//     public abstract void fun();
// }
// class Student extends Person{
//     public void print(){
//         //空实现
//     }
//     public void fun(){}//必须覆写抽象类的所有抽象方法
// }
// public class Day9{
//     public static void main(String[] args){
//       Person per=new Student();//Person不能new Person
//     }
// }

// //抽象类
//  abstract class Person{
//      //抽象方法
//      public abstract void print();
//      //抽象类中的普通方法
//      public static Person getInstance(){
//          //局部内部类（封装具体实现子类）
//          class Student extends Person{
//              public void print(){
//                  System.out.println("Hello i am student");
//              }
//          }
//          return new Student();
//      }
//  }//在抽象类的内部提供一个能够用的对象，也可以向上转型实现实例化
//  public class Day9{
//      public static void main(String[] args){
//          Person per=Person.getInstance();
//          per.print();
//      }
//  }

// abstract class Person{
//     public Person(){//2
//         this.print();//3调用父类print方法
//     }
//     public abstract void print();//3
// }
// class Student extends Person{
//     private int num=100;
//     public Student(int num){//1
//         super();//隐藏
//         this.num=num;//还没执行到这一步，还在父类的构造方法中
//     }
//     public void print(){//4在对上开辟空间，所有属性是默认值
//         System.out.println(this.num);//5
//     }
// }
// public class Day9{
//     public static void main(String[] args){
//         new Student(30);//输出结果为0；改为new Student(30).print();结果为 0 30
//     }
// }


// abstract class Person{
//     public abstract void test1();

//     abstract class Inner{
//         public abstract void test2();
//     }
// }
// class Student extends Person{
//     public void test1(){}//不能直接覆写内部抽象类test2;直接继承的才需要覆写
//     class InnerReal extends Inner{
//         public void test2(){}//外部类负责外部抽象类，内部类负责内部抽象类
//     }
// }

// public class Day9{
//     public static void main(String[] args){
//         new Student();
//     }
// }

