package JVM3;
//浅拷贝

//class Teacher{
//    private String name;
//    private String job;
//
//    public Teacher(String name, String job) {
//        this.name = name;
//        this.job = job;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getJob() {
//        return job;
//    }
//
//    public void setJob(String job) {
//        this.job = job;
//    }
//
////    @Override
////    public String toString() {
////        return "Teacher{" +
////                "name='" + name + '\'' +
////                ", job='" + job + '\'' +
////                '}';
////    }
//}
//class Student implements Cloneable{
//    private String name;
//    private int age;
//    private Teacher teacher;
//
//    public Student(String name, int age, Teacher teacher) {
//        this.name = name;
//        this.age = age;
//        this.teacher = teacher;
//    }
//    public Student clone(){
//        Student student=null;
//        try {
//            //实现拷贝处理：产生一个新的Student对象
//            student=(Student)super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return student;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
////    @Override
////    public String toString() {
////        return "Student{" +
////                "name='" + name + '\'' +
////                ", age=" + age +
////                ", teacher=" + teacher +
////                '}';
////    }
//}
//public class TestJVM3 {
//    public static void main(String[] args) {
//        Teacher teacher=new Teacher("cc","teacher");
//        Student student=new Student("aa",18,teacher);
//
//        Student studentClone=student.clone();
//        System.out.println(studentClone);
//        System.out.println(student);
//        System.out.println(studentClone.getName());
//        System.out.println(studentClone.getAge());
//
//        System.out.println(studentClone.getTeacher().getName());
//        System.out.println(studentClone.getTeacher().getJob());
//    }
//}


import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

//深拷贝
class Teacher implements Serializable{
    private String name;
    private String job;

    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }
    public Teacher clone(){
        Teacher teacher=null;
        try {
            teacher=(Teacher)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "name='" + name + '\'' +
//                ", job='" + job + '\'' +
//                '}';
//    }
}
class Student implements Serializable{
    private String name;
    private int age;
    private Teacher teacher;

    public Student(String name, int age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }
    public Student cloneStudent() throws Exception{
//        Student student=null;
//        try {
//            //实现拷贝处理：产生一个新的Student对象
//            student=(Student)super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return student;
//        通过内存进行序列化的读取与写入
        //获取序列化的两个核心类
        ByteOutputStream bos=new ByteOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis=new ByteArrayInputStream(bos.getBytes());
        ObjectInputStream ois=new ObjectInputStream(bis);
        return (Student)ois.readObject();
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", teacher=" + teacher +
//                '}';
//    }
}

class Person implements Serializable{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestJVM3 {
    public static void main(String[] args) throws Exception {

        //序列化
//        Person person=new Person("yida",18);
//        File file=new File("F:\\笔记\\test666.txt");
//        OutputStream out=new FileOutputStream(file);
//        ObjectOutputStream oos=new ObjectOutputStream(out);
//        oos.writeObject(person);
//        oos.close();
//        反序列化
//        File file=new File("F:\\笔记\\test666.txt");
//            InputStream in=new FileInputStream(file);
//        ObjectInputStream ois=new ObjectInputStream(in);
//        Person person=(Person)ois.readObject();
//        System.out.println(person);

        Teacher teacher=new Teacher("cc","teacher");
        Student student=new Student("aa",18,teacher);

        Student studentClone=student.cloneStudent();
        System.out.println(studentClone);
        System.out.println(student);
        System.out.println(studentClone.getName());
        System.out.println(studentClone.getAge());

        System.out.println(studentClone.getTeacher().getName());
        System.out.println(studentClone.getTeacher().getJob());

        System.out.println(teacher==studentClone.getTeacher());//false
    }
}
