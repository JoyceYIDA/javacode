package Day.genericSet;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class AscAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge()-o2.getAge();
    }
}
class DesAgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o2.getAge()-o1.getAge();
    }
}


public class TestSet {
    public static void code1(){
        Set<String> set=new HashSet<>();
        //无序存储
        set.add("你好");
        set.add("HELLO");
        set.add("Hello");
        set.add("HELLO");
        set.add(null);
        System.out.println(set);
        System.out.println("-------------------");
        Set<String> set1=new TreeSet<>();
        set1.add("HELLO");
        set1.add("你好");
        set1.add("HELLO");
        set1.add("hello");
        set1.add(null);
        System.out.println(set1);
    }
    public static void main(String[] args) {
        System.out.println("--------------------");
        Set<Person> set2=new TreeSet<>(new AscAgeComparator());
        set2.add(new Person(20,"Joyce"));
        set2.add(new Person(18,"yida"));
        set2.add(new Person(20,"Joyce"));
        System.out.println(set2);
        Person per1=new Person(18,"张三");
        Person per2=new Person(18,"张三");
        System.out.println(per1.equals(per2));
    }
}
