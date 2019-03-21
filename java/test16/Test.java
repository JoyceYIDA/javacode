package test;

//import java.sql.SQLOutput;
//
//@FunctionalInterface
////检查是否有多个抽象方法在接口中
//interface ISubject{
////    void test();
//    int test(int a,int b);
//}
//public class Test{
//    public static void main(String[] args) {
////        ISubject subject=new ISubject(){
////          @Override
////          public void test(){
////              System.out.println("hello world");
////          }
////        };
////        subject.test();
//        //函数式编程
//        //使用lambda表达式要求接口中有且仅有一个抽象方法
//
//        //-> 相当于implements 实际上是简化的匿名内部类
////        ISubject subject1=()->System.out.println("hello world");
////        //多行用大括号括起来
////        ISubject subject2=()-> {
////            System.out.println("hello world");
////            System.out.println("hello yida");
////        };
//        //有返回语句:多行return不可以省略
//        ISubject s3=(r1,r2)->r1+r2;
//        ISubject s4=(r1,r2)->{
//            r1=r1+10;
//            r2=r2+20;
//            return  r1+r2;
//        };
//    }
//}

//     方法引用：一般结合lambda表达式使用
//引用某个对象的静态方法
//@FunctionalInterface
//interface ISubject<R,T>{
//    T switchPara(R r);
//}
//public class Test{
//    public static void main(String[] args) {
//        ISubject<Integer,String> StringISubject=
//                String::valueOf;
//        System.out.println(StringISubject.switchPara(10));
//    }
//}

////引用某个对象的普通方法
//@FunctionalInterface
//interface ISubject<T>{
//    T switchPara();
//}
//public class Test{
//    public static void main(String[] args) {
//        ISubject<String> StringISubject=
//                "hello"::toUpperCase;
//        //等同于“hello”.toUpperCase
//        System.out.println(StringISubject.switchPara());
//    }
//}

////引用某个类的普通方法
//
//@FunctionalInterface
//interface ISubject<R,T>{
//    T switchPara(R r1,R r2);
//}
//public class Test{
//    public static void main(String[] args) {
//        ISubject<String,Integer> ISubject=
//                String::compareTo;
//        System.out.println(ISubject.switchPara("王","张"));
//    }
//}

///*
////引用某个类的构造方法
//class Person{
//    private Integer age;
//    private String name;
//    public Person(Integer age,String name){
//        this.age=age;
//        this.name=name;
//    }
//    @Override
//    public String toString(){
//        return "age"+age+",name"+name;
//    }
//}
//@FunctionalInterface
//interface ISubject<R,PI,PS>{
//    R createPerson(PI pi,PS ps);
//}
//public class Test{
//    public static void main(String[] args) {
//        ISubject<Person,Integer,String> s1=
//                Person::new;
//        //方法创建对象  等同于new Person(18,"益逹");
//        Person per=s1.createPerson(18,"益逹");
//        System.out.println(per);
//    }
//}
//*/


//import java.util.Date;

//*****反射*****
//没有反射就没有EE的任何框架；反射是类与对象的关系
// 正向处理：类->对象
//public class Test{
//    public static void main(String[] args) {
//////       正向处理
////        Date date=new Date();
////        System.out.println(date);
//////        Tue Mar 19 13:42:58 GMT+08:00 2019 （打印出当前时间）
//////        先创建类 然后通过类创建对象
//        Date date=new Date();
//        Class<Date> cls=(Class<Date>) date.getClass();
//        System.out.println(cls);
////       输出该类的包名
//    }
////}
////   反射就是根据现有的对象倒推类的组成
////   反射中最核心的类：class类
////   任何一个类在JVM中都有唯一一个class类，此对象（class对象）记录该类的组成结构
////   要想在java中应用反射，首先取得该类的class对象
////      取得class对象的三种方式
////         1.调用Object提供的getClass方法
////         2.类名称.class
//public class Test {
//    public static void main(String[] args) throws ClassNotFoundException {
//        Date date = new Date();
//        Class<Date> cls = (Class<Date>) date.getClass();
//        System.out.println(cls);
//        System.out.println(Date.class);
//        //       3.调用class类提供的静态方法Class.forName(类的全名称);
//        Class cls1 = Class.forName("java.util.Date");
//        System.out.println(cls1);
//    }
//}
////   当类加载时由JVM产生，用户只能取得此对象无法创建
//
////   拿到一个类的Class对象后
////     1.创建该类的新对象   反射与工厂模式的简单应用，通过反射来创建一个类的新对象，调用newInstance方法
////        public T newInstance()：使用的是类中无参构造进行对象的创建
//public class Test{
//    public static void main(String[] args) throws Exception{
//        Class<Date> cls=Date.class;
////        通过反射取得Date类的对象
//        Date date=cls.newInstance();
//        System.out.println(date);
//    }
//}


////     2.取得包名称、父类、父接口信息
//interface IMassage{}
//interface INews{}
//class MyClass implements IMassage,INews{}
//
//public class Test{
//    public static void main(String[] args) {
//        Class<Test> cls=Test.class;
//        //取得包信息
//        System.out.println(cls.getPackage().getName());
//        //取得父类信息
//        System.out.println(cls.getSuperclass().getName());
//        //取得一个类的所有父接口
//        Class[] classes=MyClass.class.getInterfaces();
//        for(Class cls1:classes){
//            System.out.println(cls1);
//        }
//        //int不是一个类，是基本类型，但是他有自己的class对象，所有基本类型都有class对象
//        // 所以java中任何一个类都有它的class对象
//        Class cls2=int.class;
//        System.out.println(cls2);
//    }
//}


import java.lang.reflect.Constructor;

//     3.取得构造方法，普通方法，普通属性
//        Constructor:描述一个类的构造方法
class Animal{
    private Double weight;
    public Animal(){}
    private Animal(Double weight){
        this.weight=weight;
    }
}

class Person extends Animal{
    private Integer age;
    private String name;
//    public Person(){
//    }
//    Person(Integer age){
//        this.age=age;
//    }
    private Person(Integer age,String name){
        this.age=age;
        this.name=name;
    }
    @Override
    public String toString(){
        return "age"+age+",name"+name;
    }
}
public class Test{
    public static void main(String[] args) throws Exception {
        Class<Person> cls=Person.class;
////  取得所有参数所有构造方法
//        //getConstructors()和getDeclaredConstructors()只有获取的权限不同，都取不到父类信息
//        Constructor[] constructors=cls.getDeclaredConstructors();
//        for(Constructor constructor:constructors){
//            //Class类提供的getConstructors():方法只能取得权限为public权限的构造方法
//            //Class提供的getDeclaredConstructors():可以取得类中的所有构造方法，与权限无关
//            System.out.println(constructor);
//        }
//        System.out.println("----------------------");
//        constructors=cls.getConstructors();
//        for(Constructor constructor:constructors){
//            System.out.println(constructor);
//        }
        Constructor constructor=cls.getDeclaredConstructor(Integer.class,String.class);
        //动态破坏封装性，仅一次在JVM进程中
        //创建新对象：Constructor类提供的
        //public T newInstance(Object...initargs)来创建，反射创建新对象更加灵活
        constructor.setAccessible(true);
        Person per=(Person) constructor.newInstance(18,"joyce");
        System.out.println(constructor);
    }
}

