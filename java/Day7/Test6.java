package Day7;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;



//实例方法不能调用超类的实例方法；不能直接调用超类的类方法；不能直接调用其他类的实例方法*********可以直接调用本类的类方法

//输入一个字符串str，输出字符串中连续最长的数字串
public class Test6{

    public static String number(String str){
        //创建一个StringBuilder对象，可以追加元素，是数字就追加；追加完转为字符串；
        // 再创建一个新字符串，作为保存最大的数字串，临时数字串的长度大于最大数字串长度时
        // 就把临时字符串的内容引用传递给最大数字串；最终返回最大数字串 如果下一个字符不是数字，
        // 就把临时StringBuilder对象清空
        StringBuilder tempSB=new StringBuilder();
        String maxStr=new String();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(isNumber(c)){
                //是数字就追加到临时数字串
                tempSB.append(c);
                String tempStr=tempSB.toString();
                if(tempStr.length()>maxStr.length()){
                    maxStr=tempStr;
                }
            }else{
                tempSB.setLength(0);
            }
        }
        return maxStr;
    }
    public static boolean isNumber(char c){
        return c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||
                c=='8'||c=='9'||c=='0';
    }
//    public static void main(String[] args) throws Exception {
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            String str=scanner.nextLine();
//            //最大数字串串长度
//            int max=0;
//            //计数器记下数字字符串的长度
//            int count=0;
//            //记录数字串的最后一个数字的位置
//            int end=0;
//            //遍历字符串
//            for(int i=0;i<str.length();i++){
//                char c=str.charAt(i);
//                //字符串中的某个字符为数字，计数器就+1；
//                if(isNumber(c)){
//                    count++;
//                    //当前数字串长度大于之前之前记录最大字符串长度
//                    if(max<count){
//                        max=count;
//                        end=i;
//                    }
//                }else{
//                    count=0;
//                }
//            }
//            System.out.println(str.substring(end-max+1,end+1));
//        }
//        String str="abc128888834der23456s77789632nm54";
//        System.out.println(number(str));

//    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String str=scanner.nextLine();
            System.out.println(number(str));
        }
    }
}



//传入一个字符串和字符串长度，判断其是否是一个合法的括号串（字符串里可能包含其他类型字符）
//public class Test6 {
//    public static boolean chkParenthesis(String A, int n) {
//
//        Stack<Character> stack=new Stack<>();
//        //遍历字符串
//        for(int i=0;i<n;i++){
//            char c=A.charAt(i);
//            if(c=='('){
//                stack.push(c);
//            }
//            if(c==')'){
//                if(stack.isEmpty()){
//                    return false;
//                }
//                stack.pop();
//            }
//
//        }
//        if(stack.isEmpty()){
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        String str="()aaa)";
//        System.out.println(chkParenthesis(str,str.length()));
//    }
//}
