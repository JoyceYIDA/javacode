
import java.util.*;
//测试Collection接口中的方法
public class Test {
    public static void main(String[] args) {
        Collection<String>c=new ArrayList<>();

        System.out.println(c.size());
        System.out.println(c.isEmpty());
//         输出：0
//         true

        c.add("joyce");
        c.add("yida");
        System.out.println(c);
        System.out.println(c.size());
//        输出：[joyce, yida]
//        2

        System.out.println(c.contains("yida"));//是否包含某个对象，底层实现是equals方法
//        输出：   true

        Object[] objs=c.toArray();//转成Object数组
        System.out.println(objs);
//        输出:[Ljava.lang.Object;@1540e19d


        c.remove("yida");//移除，并非删除，这个对象本身还存在，只是从容器中移除出去了
        System.out.println(c);

        c.clear();
        System.out.println(c.size());
//        输出：0
    }
}

//    public static void main(String[] args) {
//
//        test02();
//    }
//
//        public static void test01(){
//
//        }
//        public static void test02(){
//            List<String> list01=new ArrayList<>();
////            List可以替换成Collection,因为List是Collection的子集和
//            list01.add("aa");
//            list01.add("bb");
//            list01.add("cc");
//
//            List<String> list02=new ArrayList<>();
//            list02.add("aa");
//            list02.add("dd");
//            list02.add("ee");
//
//            System.out.println("list01:"+list01);
////            输出：list01:[aa, bb, cc]；
////
////            list01.addAll(list02);
////            输出：list01:[aa, bb, cc, aa, dd, ee]
//
////            list01.removeAll(list02);
////            输出：list01:[bb, cc]
//
//            list01.retainAll(list02);
////            输出：list01:[aa]
//            System.out.println("list01:"+list01);
//            System.out.println(list01.containsAll(list02));
////            输出：false
//
//    }
//}