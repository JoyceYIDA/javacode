package AAA.Day9_26;

import java.util.Scanner;

/**
 * @author yida
 */



public class Main {
/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            System.out.println(defangIPaddr(s));
        }
    }

    /**
     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
        char c=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            c=str.charAt(i);
            if(c>= 'A'&&c<='Z'){
                char r= (char) (c+32);
                sb.append(r);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
