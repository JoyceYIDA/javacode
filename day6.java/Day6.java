// 1.定义一个Father和Child类，并进行测试。 
// 要求如下： 
// 1）Father类为外部类，类中定义一个私有的String类型的属性name，name的值为“zhangjun”。
// 2）Child类为Father类的内部类，其中定义一个introFather()方法，方法中调用Father类的name属性。 
// 3）定义一个测试类Test，在Test类的main()方法中，创建Child对象，并调用introFather ()方法。 
// class Father{
//     private String name="zhangjun";
//     class Child{
//         public void introFather(){
//             System.out.println(name);
//         }
//     }
// }
// public class Day6{
//     public static void main(String args[]){
//     Father.Child child=new Father().new Child();
//     child.introFather();
// }
// }
// 2.简述下列程序运行结果: 
// class A{ 
//  int y=6; 
//  class Inner{ 
//  static int y=3; //使用了static修饰的变量
//  void show(){ 
//  System.out.println(y); 
//  } 
//  } 
// } 
// class Dome{ 
//  public static void main(String [] args){ 
//  A.Inner inner=new A().new Inner(); //Inner是A的成员内部类，成员内部类中不存在任何的static变量和方法
//  inner.show(); //因此输出会发生编译错误
//  } 
// } 

// // 3.写出下面程序运行结果: 
// class A{ 
//  public A(){ 
//  System.out.println("A"); 
//  } 
//  } 

// class B extends A{ 
//  public B(){ 
//  System.out.println("B");
//  } 
// public static void main(String[] args){ 
//  B b=new B(); 
//  } 
// }
//    //输出结果  输出A和B
// 4.编程题： 
// 打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
//例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。 

// public class Day6{
//     public static void main(String[] args){
//         for(int i=100;i<1000;i++){
//             int x=i%10;
//             int y=(i/10)%10;
//             int z=(i/100)%10;
//             if((x*x*x+y*y*y+z*z*z)==i){
//                 System.out.println(i+"是水仙花数");
//             }
//         }
//     }
//     }


