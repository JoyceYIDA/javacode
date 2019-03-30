package Day;
///*
//反射的第一个应用：改造工厂模式
// */
//interface IFruit{
//    public void eat();
//}
//class Apple implements IFruit{
//    @Override
//    public void eat() {
//        System.out.println("吃苹果");
//    }
//}
//class Orange implements IFruit{
//    @Override
//    public void eat() {
//        System.out.println("吃橘子");
//    }
//}
//class Melon implements IFruit{
//    @Override
//    public void eat() {
//        System.out.println("柠檬精");
//    }
//}
////反射改造工厂模式：添加新的类不用改变工厂代码，取得类就取得class对象的newInstance
//class FruitFactory{
//    private FruitFactory(){}
//    public static IFruit getInstance(String fruitName){
//        IFruit fruit=null;
//        try {
//            Class<?> cls=Class.forName(fruitName);
//            try {
//                fruit= (IFruit) cls.newInstance();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return fruit;
//    }
//}
//public class Test01 {
//    public static void main(String[] args) {
//        IFruit fruit=FruitFactory.getInstance("Day.Melon");//包名.类名
//        fruit.eat();
//    }
//}
/*
反射与类操作：1.取得父类父接口信息
             2.取得父类的Class对象
             3.取得实现的父接口Class对象
 */

//interface IMassage{}
//interface INews{}
//abstract class Fun{}
////先继承一个类，再实现多个接口
//class RealClass extends Fun implements IMassage,INews{}
//
//public class Test01{
//    public static void main(String[] args) {
//        Class<RealClass> cls=RealClass.class;
//        System.out.println(cls.getPackage());
//        System.out.println(cls.getPackage().getName());
//        System.out.println(cls.getSuperclass());
//        System.out.println(cls.getSuperclass().getName());
//        Class[] cls1=cls.getInterfaces();
//        for (Class c:cls1
//             ) {
//            System.out.println(c);
//        }
//    }
//}
/*
反射调用普通方法(Method类提供）
*/

import java.lang.reflect.Field;

//import java.lang.reflect.Method;
//
//class Person{
//    private String name;
//    private int age;
//
//}
//public class Test01{
//    public static void main(String[] args) throws Exception {
////        1.取得Class对象
//        Class<Person> cls=Person.class;
////        2.组装方法名称
//        String setMethodName="set"+initCap(args[0]);
//        String getMethodName="get"+initCap(args[0]);
////        3.取得Method对象
//        Method setMethod=cls.getMethod(setMethodName,String.class);
//        Method getMethod=cls.getMethod(getMethodName);
////        4.取得Person类的实例化对象，而后调用方法
//        Person per=cls.newInstance();
//        setMethod.invoke(per,"yida");
//        System.out.println(getMethod.invoke(per));
//    }
////    首字母大写拼接方法名
//    private static String initCap(String str){
//        return str.substring(0,1).toUpperCase()+str.substring(1);
//    }
//}
/*
反射与普通属性（Field）：1.取得类中指定名称属性
                              public  Field getField(String name)
                              public  Field getDeclaredField(String name)
                        2.取得类中所有属性
                              public  Field[] getFields(String name)
                              public  Field[] getDeclaredFields(String name)
                        3.Field类提供的设置与取得值
                              public  set(Object obj,Object value)
 */
class Person{
    public static String test;
    private String name;
    public int age;
}
class Student extends Person{
    private String school;
    public String className;
}
public class Test01{
    public static void main(String[] args) {
        Class<Person> cls=Person.class;
        {
            Field[] fields=cls.getFields();
            for (Field field:fields
                 ) {
                System.out.println(field);
            }
        }
        System.out.println("----------------------------------------------");
        {
            Field[] fields=cls.getDeclaredFields();
            for (Field field:fields
                 ) {
                System.out.println(field);
            }
        }
    }
}