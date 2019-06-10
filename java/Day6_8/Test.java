package Day6_8;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        int i=0;
        long res=0;
        long tt=0;
        while(i<30){
            res=res+10000;
            tt= (long) (tt+Math.pow(2,i-1));
            i++;
        }
        System.out.println(res);
        System.out.println(tt);
    }

//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        if(scanner.hasNext()) {
//            String s = scanner.nextLine();
//            int n = scanner.nextInt();
//            System.out.println(method(s,n));
//
//        }
//
//    }
//    public static String method(String s,int n){
//        int res=0;
//        int temp=0;
//        for (int i = 0; i <= s.length()-n; i++) {
//            int count = 0;
//            for (int j = i; j < i+n; j++) {
//                if (s.charAt(j)=='G'||s.charAt(j)=='C')
//                    count++;
//            }
//            if (count > temp){
//                res = i;
//                temp = count;
//            }
//        }
//        return s.substring(res,res+n);
//    }

//    public static String method(String s,int n){
//        String result=new String();
//        String temp=new String();
//        String s1=new String();
//        int i=0;
//        int r=0;
//        while(i<s.length()){
//            if((s.charAt(i)=='C'||s.charAt(i)=='G')&&i+n<s.length()){
//                result=s.substring(i,i+n);
//                r=count(result);
//                break;
//            }
//            i++;
//        }
//        int j=i+1;
//        while(j<s.length()){
//            if((s.charAt(j)=='C'||s.charAt(j)=='G')&&j+n<s.length()){
//                temp=s.substring(j,j+n);
//                int t=count(temp);
//                if(r<t){
//                    result=temp;
//                }
//            }
//            j++;
//        }
//        return result;
//    }
//    private static int count(String str){
//        int count=0;
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i)=='C'||str.charAt(i)=='G'){
//                count++;
//            }
//        }
//        return count;
//    }
}
