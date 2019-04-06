package Day.reflection;

import java.lang.reflect.Constructor;

//        2.使用反射来取得类的所有构造方法,两种方法都尝试一遍

//Class类在通过反射实例化对象时必须要调用无参构造；所以尽量保证有一个无参构造
class Fruit{
    private String fruitName;
    protected int expirationData;
    public String origin;
    public Fruit(){

    }
    Fruit(String fruitName){

    }
    private Fruit(String fruitName,int expirationData){
    }
}
public class Test1 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Fruit> cls=Fruit.class;
//        Constructor<?>[] constructors=cls.getConstructors();
//        Constructor<?>[] constructors=cls.getDeclaredConstructors();
//        for(Constructor constructors1:constructors){
//            System.out.println(constructors1);
//        }
//        Constructor<?> constructor=cls.getConstructor(String.class);
        Constructor<Fruit> constructor=cls.getDeclaredConstructor(String.class);
        System.out.println(constructor);
    }
}