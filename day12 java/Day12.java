// interface InterfaceA { 
//     String S = "good "; 
//     void f(); 
//     } 
    
//     abstract class ClassA { 
//     abstract void g(); 
//     } 
    
//     class ClassB extends ClassA implements InterfaceA { 
//     void g() { 
//     System.out.print(S); 
//     } 
    
//     public void f() { 
//     System.out.print(" "+ S); 
//     } 
//     } 
//     public class Test{ 
//     public static void main(String[] args) { 
//     ClassA a = new ClassB(); 
//     InterfaceA b = new ClassB(); 
//     a.g(); 
//     b.f(); 
//     } 
//     }
// 输出good   good
    
    // // 2.编程题: 
    // // 利用接口做参数，写个计算器，能完成加减乘除运算。 
    // // （1）定义一个接口Compute含有一个方法int computer(int n, int m)。 
    // // （2）设计四个类分别实现此接口，完成加减乘除运算。 
    // // （3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, int one, int two)，此方法能够用传递过来的对象调用computer方法完成运算，并输出运算的结果。 
    // // （4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。 
    // interface IComputer{
    //     public abstract int computer(int n,int m);//抽象方法
    // }
    // class AddImpl implements IComputer{
    //     public int computer(int n,int m){
    //         int ret=n+m;
    //         return ret;
    //     }
    // }
    // class SubImpl implements IComputer{
    //     public int computer(int i,int j){
    //         int ret=i-j;
    //         return ret;
    //     }
    // }
    // class MulImpl implements IComputer{
    //     public int computer(int x,int y){
    //         int ret=x*y;
    //         return ret;
    //     }
    // }
    // class DivImpl implements IComputer{
    //     public int computer(int a,int b){
    //         if(b!=0){
    //             int ret=a/b;
    //         return ret;
    //         }else{
    //         System.out.println("除数不能为0");
    //         return 0;
    //         }
    //     }
    // }
    // class Computer{
    //     public void computer(IComputer c,int n,int m){
    //         System.out.println(c.computer(n,m));
    //     }
    // }
    // public class Day12{
    //     public static void main(String[] args){
    //         Computer com=new Computer();
    //         AddImpl a=new AddImpl();
    //         com.computer(a,3,6);
    //         SubImpl s=new SubImpl();
    //         com.computer(s,9,3);
    //         MulImpl m=new MulImpl();
    //         com.computer(m,5,2);
    //         DivImpl d=new DivImpl();
    //         com.computer(d,4,2);
    //     }
    // }


    // // 3.按如下要求编写Java程序： 
    // // （1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。 
    // // （2）定义接口B，里面包含抽象方法void setColor(String c)。 
    // // （3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。 
    // // （4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、 
    // // 圆柱体的高height、颜色color。 
    // // （5）创建主类来测试类Cylinder。 
    // interface IA{
    //     public static double PI=3.14;
    //     public abstract double area();
    // }
    // interface IB{
    //     public abstract void setColor(String c);
    // }
    // interface IC extends IA,IB{
    //     public abstract void volume();
    // }
    // class Cylinder implements IC{
    //     private double radius;
    //     private double height;
    //     private String color;
    //     public Cylinder(double radius,double height,String color){//构造方法
    //         this.radius=radius;
    //         this.height=height;
    //         this.color=color;
    //     }
    //     public double area(){
    //         double ret=(PI*radius*radius)+(2*PI*radius*height);
    //         return ret;
    //     }
    //     public void setColor(String c){
    //         System.out.println("圆柱体的颜色是"+c);
    //     }
    //     public void volume(){
    //         double result=PI*radius*radius*height;
    //         System.out.println("圆柱体的体积是"+result);
    //     }//覆写所有抽象方法
    // }
    // public class Day12{
    //     public static void main(String[] args){
    //         Cylinder cy=new Cylinder(3,6,"green");
    //         System.out.println("圆柱体的面积是"+cy.area());
    //         cy.setColor("green");
    //         cy.volume();
    //     }
    // }
    

