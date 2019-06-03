package Day18;

import java.sql.PreparedStatement;

public class Test17 {

//    public static int[] exchangeAB(int[] AB) {
//        AB[0]=AB[1]+AB[0];
//        AB[1]=AB[0]-AB[1];
//        AB[0]=AB[0]-AB[1];
//        return AB;
//    }


    public String[] getGray(int n) {
        //n位格雷码是由n-1位的第一位加上1或者0生成的
//        //递归出口n=1
//        if(n==1){
//            String[] strs={"0","1"};
//        }
//        String[] strs=getGray(n-1);
//        int size=strs.length*2;
        String[] strs=null;
        if(n==1){
            strs=new String[]{"0","1"};
        }else{
            String[] strs1=getGray(n-1);
            strs=new String[2*strs1.length];
            for(int i=0;i<strs.length;i++){
                strs[i]="0"+strs1[i];
                strs[strs.length-1-i]="1"+strs1[i];
            }
        }
        return strs;
    }

    public static void main(String[] args) {
//        int[] arr=new int[]{1,2,3};
//        int[] b=exchangeAB(arr);
//        for(int i=0;i<b.length;i++){
//            System.out.println(b[i]);
//        }

    }
}

