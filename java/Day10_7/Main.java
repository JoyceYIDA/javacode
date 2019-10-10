package AAA.Day10_7;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author yida
 */

////public class Main{
////    public static void main(String[] args) {
////        Scanner in=new Scanner(System.in);
////        int n=in.nextInt();
////        System.out.println(fun(n));
////    }
////    public static int fun(int n){
////        if (n==0) return 0;
////        if (n==2) return 1;
////        if (n==3) return 2;
////        if (n==4) return 4;
////        int count=1;
////        while(n>4){
////            count=count*3;
////        }
////    }
////}
//
//public class Main{
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        System.out.println(fun(n));
//    }
//    public static int fun(int n){
//        if (n==0) return n;
//        if (n==2||n==3){
//            return n-1;
//        }
//        if (n==4) return n;
//        int count=1;
//        while(n>4){
//            count=count*3;
//            n=n-3;
//        }
//        return  count*n;
//    }
//}

public class Main{
    private static final String[] results={
            "该用户名已存在","密码格式错误","请输入正确的手机号码","注册成功"
    };
    private static final HashSet<String> set=new HashSet<>();
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        set.add("zhangsan");
        set.add("lisi");
        String name=in.next();
        String password=in.next();
        String phone =in.next();
        int result =fun(name,password,phone);
        System.out.println(results[result]);
    }
    private static int fun(String name,String password,String phone){
        if (set.contains(name)) return 0;
        if (password.length()<8||password.length()>16){
            return 1;
        }else {
            for (int i=0;i<password.length();i++){
                if ((password.charAt(i)>='0'&&password.charAt(i)<='9')||
                        (password.charAt(i)>='A'&&password.charAt(i)<='Z')||
                        (password.charAt(i)>='a'&&password.charAt(i)<='z')){

                }else{
                    return 1;
                }
            }
        }
        if (phone.length()!=11){
            return 2;
        }else {
            if (phone.charAt(0)!='1'){
                return 2;
            }
        }
        return 3;
    }
}