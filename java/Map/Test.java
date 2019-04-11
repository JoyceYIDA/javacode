package Day.Map;

import java.util.*;

//public class Test {
//    public static void main(String[] args) {
//        Map<Integer, String> map=new HashMap<>();
//        map.put(1,"hello");
//        map.put(1,"Hello");
//        map.put(3,"world");
//        map.put(2,"and");
//        map.put(null,"java");
////        map.get(null,"yida");
//        map.put(5,null);
//        //当key值重复，再次put变为相应的value的更新操作
//        System.out.println(map.get(1));
//        System.out.println(map.get(666));
//        System.out.println("map的数据"+map);
//        System.out.println("map的数据数量"+map.size());
//        System.out.println("获取key=5的值"+map.get(5));
//        System.out.println("********");
//        //取得当前Map中所有的Key值
//        // 迭代器
//        Set<Integer> keySet=map.keySet();
//        Iterator<Integer> iterator=keySet.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println("************");
//        //输出Map集合
//        Set<Map.Entry<Integer,String>> set=map.entrySet();
//        Iterator<Map.Entry<Integer,String>> iterator1=set.iterator();
//        while(iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }
//
//    }
//}
//自定义的类作为Key，系统类作为value
class Person{
    private Integer age;
    private String name;


    Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(age, person.age) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(age, name);
    }
}
public class Test{
    public static void main(String[] args) {
        Map<Person,String> map=new HashMap<>();
        Person per1=new Person(18,"张三");
        Person per2=new Person(20,"李四");
        map.put(per1,"是一名程序员");
        map.put(per2,"是一名学生");
        System.out.println(map.get(new Person(18,"张三")));
        Set<Map.Entry<Person,String>> set=map.entrySet();
        Iterator<Map.Entry<Person,String>> iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
