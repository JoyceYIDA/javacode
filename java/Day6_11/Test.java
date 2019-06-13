package Day6_11;

import java.util.Scanner;

public class Test {

//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            int month=scanner.nextInt();
//            System.out.println(getTotalCount(month));
//        }
//    }
//
//    /**
//     * 小兔子从第三个月开始每个月生一个小兔子
//     * 通过月份求出兔子的总数
//     * @param monthCount 月数
//     * @return 兔子的总数
//     */
//    public static int getTotalCount(int monthCount){
//        if(monthCount<3){
//            return 1;
//        }
//        //每个月的兔子总数是前一个月兔子总数+前两个月兔子总数
//        return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
//    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String data=scanner.nextLine();
            System.out.println(Decrypt(data));
        }
    }

    /**
     * 加密的办法：对消息原文中的每个字母，分别用该字母之后的第五个字母替换，
     * 其他字符不变，并且消息原文中的所有字母都是大写的。
     * 密码中的字母与原文中的字母对应关系如下：
     * 密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
     * 原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
     *
     * 前五个：密码字母-原文字母=-21；
     *
     * @param data 收到的密文
     * @return 解密后的明文
     */
    public static String Decrypt(String data){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<data.length();i++){
            char c=data.charAt(i);
            if(c==' '){
                sb.append(' ');
            }else{
                if(c-0>='A'-0&&c-0<'F'-0){
                    char h= (char) (c+21);
                    sb.append(h);
                }else {
                    char h = (char) (c - 5);
                    sb.append(h);
                }
            }
        }
        return sb.toString();
    }


}
