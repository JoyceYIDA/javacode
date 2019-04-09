package Day.genericSet;

import java.util.*;

class Person{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
    //覆写equals和hashCode方法


     @Override
     public boolean equals(Object o) {
        //自反性
         if (this == o) return true;
         //非空性
         if (o == null || getClass() != o.getClass()) return false;
         Person person = (Person) o;
         return age == person.age &&
                 Objects.equals(name, person.name);
     }

     @Override
    public int hashCode() {

        return Objects.hash(age, name);
    }

    public int compareTo(Person o){
        if(this.age>o.age){
            return 1;
        }else if(this.age<o.age){
            return -1;
        }else{
            return this.name.compareTo(o.name);
        }
    }
}
public class TestArrayList {
    public static void code(){
        //面向接口编程
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(2,4);
        System.out.println(list);
        System.out.println(list.toArray());
        System.out.println(list.contains(1));
        System.out.println(list.remove(2));
        System.out.println(list.get(2));
        System.out.println(list.set(2,999));
        System.out.println(list);
    }

    public static void code1(){
        //保存自定义的 Person对象
        List<Person> list=new ArrayList<>();
        list.add(new Person(20,"Jackson"));
        list.add(new Person(21,"Mark"));
        list.add(new Person(22,"Tom"));
        System.out.println(list);
        //判断匿名对象是否存在
        System.out.println(list.contains(new Person(20,"Jackson")));
    }
    public static void main(String[] args) {
//        List<Integer> list=new Vector<>();
        List<String> list=new ArrayList<>();
        list.add("hello");
        list.add("java");
        list.add("hello");
        list.add("world");
        //取得ArrayList的迭代器
        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println( iterator.next());
        }
        System.out.println("----------------");
        ListIterator<String> iterator1= list.listIterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        while(iterator1.hasPrevious()){
            System.out.println(iterator1.previous());
        }
        System.out.println("**********");
        Vector<String> vector=new Vector<>();
        vector.add("hello");
        vector.add("world");
        vector.add("change");
        vector.add("world");
        Enumeration<String> enumeration=vector.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

    }
}
