package BJuly.Day7_9;

//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String str=sc.nextLine();
//            String p=str.split(" ")[0];
//            String a=str.split(" ")[1];
//            System.out.println(method(p,a));
//        }
//    }
//    public static String method(String str,String str1){
//
//        String[] arr=str.split("\\.");
//        String[] arr1=str1.split("\\.");
//        long galleon=Long.parseLong(arr[0]);
//        int sickle=Integer.parseInt(arr[1]);
//        int knut=Integer.parseInt(arr[2]);
//        long galleon1=Long.parseLong(arr1[0]);
//        int sickle1=Integer.parseInt(arr1[1]);
//        int knut1=Integer.parseInt(arr1[2]);
//        if(knut>knut1){
//            knut1=knut1+19;
//            sickle1--;
//        }
//        int resK=knut1-knut;
//
//        if(sickle>sickle1){
//            sickle1=sickle1+17;
//            galleon1--;
//        }
//        int resS=sickle1-sickle;
//        long resG=galleon1-galleon;
//        if(resG>0){
//            return resG+"."+resS+"."+resK;
//        }else{
//            return method(str1,str);
//        }
//    }
//}


import java.util.Scanner;

public class Main{
    /**
     * 在霍格沃茨找零钱
     * 进制转换的问题
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] strP=sc.next().split("\\.");
        String[] strA=sc.next().split("\\.");
        //将字符串转换成数值类型
        Long[] longP=new Long[3];
        Long[] longA=new Long[3];
        for(int i=0;i<3;i++){
            longP[i]=Long.parseLong(strP[i]);
            longA[i]=Long.parseLong(strA[i]);
        }
        //将全部单位转为纳特（knut）
        long pk=toKnut(longP[0],longP[1],longP[2]);
        long ak=toKnut(longA[0],longA[1],longA[2]);
        long temp=ak-pk;
        if(temp<0){
            System.out.print("-");
            temp=temp*(-1);
        }
        System.out.println(toPrint(temp));
    }

    /**
     * 定义一个方法将所有的单位都转换成最小的knut
     * @param gal
     * @param sic
     * @param knu
     * @return
     */
    private static long toKnut(long gal,long sic,long knu){
        return 29*(17*gal+sic)+knu;
    }
    private static String toPrint(long res){
        StringBuilder sb=new StringBuilder();
        sb.append((res/(17*29))+".");
        sb.append((res%(17*29)/29)+".");
        sb.append(res%(17*29)%29);
        return sb.toString();
    }
}


//import java.util.Scanner;
//
//public class Main {
//    /**
//     * 2的个数
//     *
//     * 每十位数里会出现一个2.但是2X 是例外，会多出现10个2，也就是每百位数里会出现20个2。但2XX是个例外，会多出现100个2
//     * 以此类推，可以根据n的值直接得到2的个数。
//     * @param n 整数
//     * @return 0-这个数中2出现的个数
//     */
//    public static int countNumberOf2s(int n) {
//        int count=0;//计数器
//        int fa=1;//从低位到高位计算2的个数
//        int low=0;//屏蔽掉低位
//        int cur=0;//当前计算位数的值
//        int high=0;//计算高位
//        while(n/fa!=0){
//            low=n-(n/fa)*fa;
//            cur=(n/fa)%10;
//            high=n/(fa*10);
//
//            switch(cur){
//                case 0:
//                case 1:
//                    count+=high*fa;
//                    break;
//                case 2:
//                    count+=high*fa+low+1;
//                default:
//                    count+=(high+1)*fa;
//                    break;
//            }
//            fa*=10;
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(countNumberOf2s(221));
//    }
//}

