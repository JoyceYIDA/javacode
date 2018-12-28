
class Person{
    {//定义在类中，不加任何修饰符，构造块
        System.out.println("1.Person类的构造块");
    }
    public Person(){
        System.out.println("2.Person类的构造方法");
    }
    static {//定义在非主类中，用static修饰，非主类中的静态块
        System.out.println("3.Person类的静态块");
    }
}
public class Day7{
    public static void main(String[] args){
        System.out.println("---------------");
        new Person();
        new Person();
        System.out.println("***************");
    }
}
//输出结果（说明静态块优先于构造块执行，而且无论有多少实例化对象产生，静态块只执行一次！！！
// ---------------
// 3.Person类的静态块
// 1.Person类的构造块
// 2.Person类的构造方法
// 1.Person类的构造块
// 2.Person类的构造方法
// ***************