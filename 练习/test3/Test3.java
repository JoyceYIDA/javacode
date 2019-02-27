//
//import java.util.Scanner;
///**
// * 测试获得键盘输入
// */
//
//public class Test3 {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("请输入名字：");
//        String name=scanner.nextLine();
//        System.out.println("请输入你的爱好");
//        String favor=scanner.next();
//        System.out.println("请输入你的年龄");
//        int age=scanner.nextInt();
//
//        System.out.println("*******************");
//        System.out.println(name+"喜欢"+favor);
//        System.out.println("今天是你来到地球的"+age*365+"天");
//    }
//}


/**
 *定义一个表示性别的多例类
 */
class Sex {
    private String title;
    public static final int MALE_FLAG = 1;
    public static final int FEMALE_FLAG = 2;
    private static final Sex MALE = new Sex("男");
    private static final Sex FEMALE = new Sex("男");

    private Sex(String title) {
        this.title = title;
    }

    public static Sex getInstance(int flag) {
        switch (flag) {
            case MALE_FLAG:
                return MALE;
            case FEMALE_FLAG:
                return FEMALE;
            default:
                return null;
        }
    }
}
    public class Test3{
        public static void main(String[] args) {
            Sex male=Sex.getInstance(Sex.MALE_FLAG);
            System.out.println(male);
        }
}