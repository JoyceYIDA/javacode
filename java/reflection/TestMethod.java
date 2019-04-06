package Day.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
    private String name;
    private int age;
    public Student(){}
    public Student(String name){
        this.name=name;
    }
    public Student(String name,int age){
        this.age=age;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class TestMethod{
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InstantiationException,
            InvocationTargetException, ClassNotFoundException {
////        1.取得class对象
//        Class<Student> cls=Student.class;
////        2.设置方法名称（拼接：set+name但是name首字母要大写
//        String setName="set"+initCap("name");
//        String getName="get"+initCap("age");
////        3.取得method对象
//        Method setMethod=cls.getMethod("setName",String.class);
//        Method getMethod=cls.getMethod("getName");
////        4.取得student对象
//        Student student=cls.newInstance();
////        5.调用方法测试
//        setMethod.invoke(student,"zhangsan");
//        System.out.println(getMethod.invoke(student));

//        1.取得class对象
        Class<?> cls=Class.forName("Day.reflection.Student");
//        2.使用newInstance实例化对象
        Object obj=cls.newInstance();
//        3.取得setName的实例化对象，设置方法名称和参数
        Method setName=cls.getMethod("setName",String.class);
//        4.调用invoke
        setName.invoke(obj,"zhangsan");
//        5.取得getName实例化对象
        Method getName=cls.getMethod("getName");
        System.out.println(getName.invoke(obj));
    }

    //首字母大写方法
    private static String initCap(String str) {
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
