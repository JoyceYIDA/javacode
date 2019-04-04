package Day.genericity;

//class MyClass<T>{
//    T t;
//}
//
//class Point<T>{
//   private T x;
//   private T y;
//    public T getX() {
//        return x;
//    }
//
//    public void setX(T x) {
//        this.x = x;
//    }
//
//    public T getY() {
//        return y;
//    }
//
//    public void setY(T y) {
//        this.y = y;
//    }
//
//}
//
//public class Test {
//    public static void main(String[] args) {
//        Point<String> point=new Point<String>();
//        point.setX("东经20度");
//        point.setY("北纬10度");
//        String str=point.getX();
//        String str1=point.getY();
//        System.out.println(str);
//        System.out.println(str1);
////        MyClass<String > myClass=new MyClass<String>();
//    }
//}
////  泛型方法
//class MyClass<T>{
//    public T method1(T t){
//        return t;
//    }
//    public <T> T test(T t){
//        return t;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
////        MyClass mc=new MyClass();
////        mc.test("hello");
////        mc.test(123);
////        mc.test(10.1);
//        MyClass<String> mc=new MyClass<>();
//        System.out.println(mc.method1("hello"));
//        System.out.println(mc.test(123));
//    }
//}
//class MyClass<T>{
//    T t;
//    public T getT(){
//        return t;
//    }
//    public void setT(T t){
//        this.t=t;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
////        MyClass<String> mc=new MyClass<>();
////        mc.setT("hello");
////
////        MyClass<Integer> mc1=new MyClass<>();
////        mc1.setT(20);
////
//////        print(mc);
//////        print(mc1);
////
//////        Integer是Number的子类
////        MyClass<Integer> mc1=new MyClass<>();
////        MyClass<Number> mc2=new MyClass<>();
//////        MyClass<String> mc3=new MyClass<>();
//        MyClass<Object> mc=new MyClass<>();
//        print(mc);
//    }
//    public static void print(MyClass<? super String> mc){
//        mc.setT("hello");
//        System.out.println(mc.getT());
//    }
//}

interface IFruit<T>{
    T test(T t);
}

//  1.子类实现接口时继续保留泛型
class Apple<T> implements IFruit<T>{

    @Override
    public T test(T t) {
        return t;
    }
}
// 2.子类实现接口时就确定好类型
class Orange implements IFruit<String>{

    @Override
    public String test(String s) {
        return s;
    }
}

public class Test{
    public static void main(String[] args) {
//        IFruit<String> f=new Apple<>();
        IFruit f=new Orange();
        System.out.println(f.test("hello"));
    }
}
