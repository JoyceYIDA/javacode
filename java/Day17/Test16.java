package Day17;

import java.util.*;


//public class Test16 {
//    public static void count(List list){
//        for(int i=0;i<10;i++){
//            int count=0;
//            for(int j=0;j<list.size();j++){
//                if(list.get(j).equals(i)){
//                    count++;
//                }
//            }
//            if(count!=0) {
//                System.out.println(i+":"+count);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        List<Integer> list=new LinkedList<>();
//        while(scanner.hasNext()){
//            String str=scanner.nextLine();
//            for(int i=0;i<str.length();i++){
//                //字符转数字
//                int x=str.charAt(i)-'0';
//                list.add(x);
//            }
//            Collections.sort(list);
//            count(list);
//        }
//    }
//}


//public class Test16{
//
//    public static int[] multiply(int[] A) {
//
//    }
//
//    public static void main(String[] args) {
//        int[] arr=new int[]{1,2,3,4,5,6};
//        for(int i=0;i<arr.length;i++){
//            System.out.println(multiply(arr));
//        }
//    }
//}

//爬楼梯
class Solution {
    public int climbStairs(int n) {
        //递归
        if(n<4){
            return n;
        }else{
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }
}
public class Test16{
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.climbStairs(5));
    }
}

