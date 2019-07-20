package CJuly.Day7_17;

import java.util.Scanner;
import java.util.Stack;

//
//public class Main {
//    /**
//     * 二维数组的打印
//     * @param arr 二维数组
//     * @param n
//     * @return
//     * 从二维数组的最右上角开始打印，沿着对角线打印，
//     * 每次打印x是从最小的开始，y从最大的开始减小从(0,n-1)开始
//     * 横坐标+1，超出行数则打印结束
//     */
//    public static int[] arrayPrint(int[][] arr, int n) {
//        int len=n*n;
//        int[] print=new int[len];
//        int i=0;
//        int x=0;
//        int y=n;
//        while(x<n){
//            int x1=x;
//            int y1=y;
//            while(x1<n&&y1<n){
//                print[i++]=arr[x1++][y1++];
//            }
//            if(y>0){
//                y--;
//            }else{
//                x++;
//            }
//        }
//        return print;
//    }
//
//    public static void main(String[] args) {
//        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int n=arr[0].length;
//        int[] a=arrayPrint(arr,n);
//        for(int i=0;i<n*n;i++){
//            System.out.print(a[i]+"、");
//        }
//    }
//}


/**
 * 回文串
 * 长度为n的字符串，添加一个字符可以变成回文串，那么删除一个字符也能成为回文
 * 如果删除的是中间位置的字符的话，这个字符串本来就是回文，如果删除的是两端的字符的话
 * 那么长度为n-1的子串必有一个为回文
 */
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s=sc.nextLine();
            //去掉两端或者本身就是回文
            if(isPali(s.substring(0,s.length()-1))||isPali(s.substring(1,s.length()))||isPali(s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    /**
     * 判断字符串是否是回文
     * @param s
     * @return
     */
    public static boolean isPali(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}