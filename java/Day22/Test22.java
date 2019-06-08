package Day22;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Test22 {

    //洗牌，需要洗2n张牌，将牌分为两堆；1--n和n+1--2n
    /*这个洗牌其实就是把好比123456分成两份，123和456，然后先放把123放进
   大小为6的vec中：变成1_2_3_，再把456反向放入，变成142536，这就是一次
   洗牌的过程。
   */

//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        //洗牌的数据数组
//        int T=scanner.nextInt();
//        while (T-->0){
//            //数字个数的一半n
//            //洗牌次数k
//            int n=scanner.nextInt();
//            int k=scanner.nextInt();
//            int[] arr=new int[2*n];
//            for(int i=0;i<arr.length;i++){
//                int temp=i+1;
//                for (int j=0;j<k;j++){
//                    if(temp<=n){
//                        temp=2*temp-1;
//                    }else{
//                        temp=2*(temp-n);
//                    }
//                }
//                arr[temp-1]=scanner.nextInt();
//            }
//            if(arr.length>0){
//                System.out.print(arr[0]);
//            }
//            for(int i=1;i<2*n;i++){
//                System.out.print(" "+arr[i]);
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;i++){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            List<Integer> list=new ArrayList<>();
            List<Integer> leftList=new ArrayList<>();
            List<Integer> rightList=new ArrayList<>();

            for(int j=0;i<2*n;i++){
                list.add(scanner.nextInt());
            }
            //把牌分成两半放进两个list
            for(int x=0;x<k;x++){
                leftList.clear();
                rightList.clear();

                for(int j=0;j<n;j++){
                    leftList.add(list.get(j));
                }
                for(int j=n;i<2*n;i++){
                    rightList.add(list.get(j));
                }
                list.clear();
                for(int j=0;j<n;j++){
                    list.add(leftList.get(j));
                    list.add(rightList.get(j));
                }
            }
            System.out.println(list.toString().
                    replace("[","")
                    .replace("]","")
                    .replace(",",""));
        }
        scanner.close();
    }
}


//    //读入N名学生的成绩，将获得某一给定分数的学生人数输出
//
//    public static int sameAch(String s,String ach){
//        String[] strs=s.split(" ");
//        int count=0;
//        for(int i=0;i<strs.length;i++){
//            if(strs[i].equals(ach)){
//                count++;
//            }
//        }
//        return count;
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int N = scanner.nextInt();
//            if(N==0){
//                break;
//            }
//            String s=scanner.nextLine();
//            String s1=scanner.nextLine();
//            String s2=scanner.nextLine();
//            System.out.println(sameAch(s1,s2));
//        }
//    }
//}
