package Test;


//public class Test {
//    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        int val = 2;
//        Test test=new Test();
//        System.out.println(test.removeElement(nums,val));
//    }
//
//    //给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
////不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
////元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//    public int removeElement(int[] nums, int val) {
//        if(nums.length==0){
//            return 0;
//        }
//        int n=0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]!=val){
//                nums[n]=nums[i];
//                n++;
//            }
//        }
//        nums=new int[n];
//        return n;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Test test=new Test();
//        System.out.println(test.strStr("",""));
//    }
////    实现 strStr() 函数。
////    给定一个 haystack 字符串和一个 needle 字符串，
////    在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1
////当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//    public int strStr(String haystack, String needle) {
//        if (needle == null) {
//            return 0;
//        } else if (haystack == null && needle != null) {
//            return -1;
//        } else if (haystack == null && needle == null) {
//            return 0;
//        } else {
//            char[] hs = haystack.toCharArray();
//            char[] nl = needle.toCharArray();
//            for (int i = 0; i < hs.length - nl.length + 1; i++) {
//                //haystack中某个字符和needle的第一个字符相等才能继续向下比较
//                if (nl[0]==hs[i]) {
//                    //从needle的第二个字符开始比较
//                    int j = 0;
//                    for (; j < nl.length; j++) {
//                        if (i + j >= hs.length || hs[i + j] != nl[j]) {
//                            break;
//                        }
//                    }
//                    if (j == nl.length) {
//                        return i;
//                    }
//                }
//            }
//            return -1;
//        }
//    }
//}

//import java.util.HashMap;

//罗马数字转整数
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

////因为是一一对应关系，所以可以用映射来解决
//public class Test{
//    public static void main(String[] args) {
//        Test test=new Test();
//            int q=test.romanToInt("XC");
//        System.out.println(q);
//    }
//    public int romanToInt(String s) {
//        int res=0;
//        if(s==null||s.length()<1){
//            return 0;
//        }
//        HashMap<String,Integer> hashMap=new HashMap<>();
//        hashMap.put("I",1);
//        hashMap.put("V",5);
//        hashMap.put("X",10);
//        hashMap.put("L",50);
//        hashMap.put("C",100);
//        hashMap.put("D",500);
//        hashMap.put("M",1000);
//        //取出目标字符串中的每个字母
//        // java.lang.String.charAt() 方法返回指定索引处的char值。
//        // 索引范围是从0到length() - 1。
//        // 此方法返回这个字符串的指定索引处的char值。第一个char值的索引为0.
//        for(int i=0;i<s.length();i++){
//            res=res+hashMap.get(s.charAt(i)+"");
//            if(i!=0&&hashMap.get(s.charAt(i)+"")>hashMap.get(s.charAt(i-1)+"")){
//                res=res-(hashMap.get(s.charAt(i-1)+"")<<1);
//            }
//        }
//        return res;
//    }
//}


//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
// 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//        你可以假设数组中无重复元素。

public class Test{
    public static void main(String[] args) {
        Test test=new Test();
        int[] data=new int[]{1,3,5,9};
        System.out.println(test.searchInsert(data,7));
    }
    public int searchInsert(int[] nums, int target) {
        //数组有序，可以二分查找
        int l=0;
        int r=nums.length;
        for(int i=0;i<nums.length;i++){
            //小于第一个元素就返回0；大于最后一个元素就返回数组长度；
            // 等于数组中的任意一个元素就返回该元素下标；如果前面分支都没走，就说明数组中不存在目标元素
            if(target<nums[0]){
                return 0;
            }else if(target>nums[nums.length-1]){
                return nums.length;
            }else if(target==nums[i]){
                return i;
            }else{
                while(r>l){
                    int mid=l+(r-l)/2;
                    if(target<nums[mid]){
                        r=mid-1;
                    }else if(target>nums[mid]){
                        l=mid+1;
                    }else{
                        return mid+1;
                    }
                }
            }
        }
        return l;
    }
}