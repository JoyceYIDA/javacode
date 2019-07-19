package CJuly.Day7_16;

/**
 * 最近的公共祖先
 */
//public class Main {
//    public static void main(String[] args) {
//    System.out.println(getLCA(2,3));
//}
//    public static int getLCA(int a,int b){
//        while(a!=b){
//            if(a>b){
//                a/=2;
//            }else{
//                b/=2;
//            }
//        }
//        return a;
//    }
//}
/**
 * 空格替换
 */
public class Main{
    public String replaceSpace(String initString,int length) {
        if (initString == null || initString.length() <= 0) {
            return initString;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = initString.charAt(i);
            if(c==' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}