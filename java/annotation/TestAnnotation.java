package Day.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.reflect.Method;

////   注解的作用范围：SOURCE/RUNTIME/CLASS
//
//@Deprecated//弃用
//@SuppressWarnings(value = {"unused"})//压制警告
//public class TestAnnotation {
//    @Deprecated
//    public String toString(){
//        return super.toString();
//    }
//
//    public static void main(String[] args) {
//        Class cls=TestAnnotation.class;
////        Annotation[] annotations=cls.getAnnotations();
////        for (Annotation annotation:annotations){
////            System.out.println(annotation.annotationType().getName()+"/"+annotation.toString());
////        }
//        try {
//            Annotation annotation=cls.getMethod("toString").getAnnotation(Deprecated.class);
//            System.out.println(annotation.annotationType().getName()+"/"+annotation.toString());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//    }
//}

//   自定义注解
//       1.注解类是一个接口，在interface前添加@符号
//       2.通过@Retention标注注解作用范围
//       3.通过注解@Targer标注注解使用的位置{属性、类型、方法、变量等}


public class TestAnnotation{
    public static void main(String[] args) {
//        Annotation[] annotations=Member.class.getAnnotations();
//        for (Annotation annotation:annotations
//             ) {
//            System.out.println(annotation.toString());
//        }
        MyAnnotation myAnnotation=Member.class.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.getClass());
        System.out.println(myAnnotation.name());
        System.out.println(myAnnotation.age());
    }
}
//      4.注解类定义了抽象方法，如果无默认值，使用时需要指定值
//        在抽象方法之后加default增加默认值
@MyAnnotation(
        //name="joyce",age=18
        )
class Member{

}
