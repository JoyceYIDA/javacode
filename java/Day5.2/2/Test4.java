package Day5;

//public class Test4 {
//
//    public int findK(int[] arr, int n, int K) {
//        return findK(arr, 0, n - 1, K);
//    }
//
//    public int findK(int[] arr, int l, int r, int k) {
//        int q = partition(arr, l, r);
//        if (k == q - l + 1) {
//            return arr[q];
//        } else if (k < q - l + 1) {
//            return findK(arr, l, q - 1, k);
//        } else {
//            return findK(arr, q + 1, r, k - q + l - 1);
//        }
//    }
//    public int partition(int[] arr,int l,int r){
//        //定义一个基准值
//        int key=arr[l];
//        while(l<r) {
//            while (arr[r] <= key && r > l)
//                r--;
//            arr[l] = arr[r];
//            while (arr[l] >= key && l < r)
//                l++;
//            arr[r] = arr[l];
//        }
//        arr[l]=key;
//        return l;
//}
////public int partition(int[] a, int low, int high) {
////
////    int key = a[low];
////    while (low < high) {
////        while (low < high && a[high] <= key) high--;
////        a[low] = a[high];
////        while (low < high && a[low] >= key) low++;
////        a[high] = a[low];
////    }
////    a[low] = key;
////    return low;
////}
//    public static void main(String[] args) {
//        int[] arr=new int[]{1,9,4,6,3,7};
//        int n=arr.length;
//        Test4 test4=new Test4();
//        System.out.println(test4.findK(arr,n,2));
//    }
//}


//import java.util.Scanner;
//
//public class Test4{
//    public static boolean palindrome(String str){
//        //判断字符串是否是回文链表
//        if(str.length()==1){
//            return true;
//        }
//        int i=0;
//        int j=str.length()-1;
//        while(i<j){
//            if(str.charAt(i)!=str.charAt(j)){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        //输入
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("请输入两行字符串");
//        String s1=scanner.nextLine();
//        String s2=scanner.nextLine();
//        //最终输出次数
//        int count=0;
//        //将字符串2插入字符串1的策略是从第一个字目前插到最后一个字母后
//        for(int i=0;i<=s1.length();i++){
//            StringBuilder sb=new StringBuilder(s1);
//            sb.insert(i,s2);
//            String s3=sb.toString();
//            if(palindrome(s3)){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
//}

//public class SystemUtil{
//    public static boolean isAdmin(String userId){
//    return userId.toLowerCase()=="admin";
//    }
//    public static void main(String[] args){
//        System.out.println(isAdmin("Admin"));
//     **********输出false；因为==比较的是地址***********
//    }
//}


//public class Test4 {
//    public int aMethod(){
//        static int i = 0;
////     ***************方法中不能定义静态属性*************
//        i++;
//        return i;
//    }
//public static void main(String args[]){
//        Test4 test = new Test4();
//        test.aMethod();
//        int j = test.aMethod();
//        System.out.println(j);
//    }
//}