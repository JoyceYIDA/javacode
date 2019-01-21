
import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        test03();
    }
    public static void test03(){
        List<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println(list);
//        输出：[a, b, c, d]

        list.add(2,"yida");//在此处插入一个内容，后面的向后移
        System.out.println(list);
//        输出：[a, b, yida, c, d]

        list.remove(2);
        System.out.println(list);

        list.set(2,"joyce");//设置，后面的不变
        System.out.println(list);
//        输出：[a, b, joyce, d]

        System.out.println(list.get(2));

        list.add("c");
        list.add("b");
        list.add("a");
        System.out.println(list);

        System.out.println(list.indexOf("b"));
//        输出1；如果查找的字符串不存在则返回-1
        System.out.println(list.lastIndexOf("b"));
//        输出：5
    }
}
