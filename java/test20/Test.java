package SingleThread;


//class Outter{
//    private int i=10;
//    class Inner{
//        private int j=7;
//        public void fun(){
//            System.out.println(i);
//        }
//    }
//    public void eat(){
//        //外部类要访问内部类的私有属性必须要通过内部类的引用间接访问
//        Inner in=new Inner();
//        System.out.println(in.j);
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Outter out=new Outter();
//        out.eat();
//        //在外部类之外创建内部类
//        Outter.Inner inner=new Outter().new Inner();
//        inner.fun();
//    }
//}

//class Outter{
//    private String strOut="外部类的私有属性";
//    //用private封装的私有内部类仅供外部类使用（比如HashMap中的Entry方法）
//    private class Inner{
//        private String strIn="内部类的私有属性";
//        public void fun(){
//            System.out.println(strOut);
//        }
//    }
//}

//class Outter{
//    private static String str="外部类的静态变量";
//    static class Inner{
//        //不能访问外部类的所有非static域，但是可以拥有成员变量
//        private int i=10;
//        public void fun(){
//            System.out.println(str);
//        }
//    }
//}
//
//public class Test{
//    public static void main(String[] args) {
//        //可以直接创建内部类对象，不需要外部类也可创建，没有调用Outter的无参构造
//        Outter.Inner inner=new Outter.Inner();
//        inner.fun();
//    }
//}

//class Outter{
//    private String str="外部类的私有属性";
//    public void fun(final int num){
//        //不使用任何访问权限修饰符，对方法外完全隐蔽
//        class Inner{
//            public void in(){
//                System.out.println(str);
//            }
//        }
//        Inner inner=new Inner();
//        inner.in();
//    }
//    public void test(){
//        //在fun以外的方法中都不能产生实例化Inner对象
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Outter outter=new Outter();
//        outter.fun(20);
//    }
//}

public class Test{
    public static void main(String[] args) {
        new Thread(()-> new Runnable() {
            @Override
            public void run() {
                System.out.println("***************");
            }
        }).start();
    }
}