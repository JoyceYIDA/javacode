package Day.test19;
////给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
////        如果有两个中间结点，则返回第二个中间结点。
//
//
////public class ListNode {
////    int val;
////    ListNode next;
////
////    ListNode(int x) {
////        val = x;
////    }
////}
////class Solution {
////    public ListNode middleNode(ListNode head) {
////        //快慢指针
////        ListNode slow=head;
////        ListNode fast=head;
////        while (fast!=null&&fast.next!=null){
////            fast=fast.next.next;
////            slow=slow.next;
////        }
////        return slow;
////    }
////}
//
//
//////删除链表中等于给定值 val 的所有节点。
////  public class ListNode {
////      int val;
////      ListNode next;
////      ListNode(int x) { val = x; }
////  }
////class Solution {
////      public ListNode removeElements(ListNode head, int val) {
////          if(head==null){
////              return null;
////          }
//////递归
////          ListNode res=removeElements(head.next,val);
////          if(head.val==val){
////              return res;
////          }else{
////              head.next=res;
////              return head;
////          }
////      }
////  }
//
//import java.util.Stack;
//
//////判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
////class Solution {
////    public boolean isPalindrome(int x) {
////////        x是负数就不可能是回文
//////        //        一个非0正整数的最后一位是0的话，也不可能是回文
//////
//////        if(x < 0 || (x % 10 == 0 && x != 0)) {
//////            return false;
//////        }
//////        int value = 0;
//////        while(x > value) {
//////            value = value * 10 + x % 10;
//////            x /= 10;
//////        }
//////        if(x==value||x==value/10){
//////            return true;
//////        }else {
//////            return false;
//////        }
////        String str=new StringBuilder(String.valueOf(x)).reverse().toString();
////        return str.equals((String.valueOf(x)).toString());
////    }
////}
//
////将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
////        输入：1->2->4, 1->3->4
////        输出：1->1->2->3->4->4
////public class ListNode {
////      int val;
////      ListNode next;
////      ListNode(int x) { val = x; }
////  }
////
////class Solution {
////    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
////        //先定义一个虚拟头结点
////        ListNode dummyHead=new ListNode(-1);
//////        把虚拟头结点先设置为当前节点作为中间变量
////        ListNode cur=dummyHead;
//////        先遍历l1和l2，比较节点的值，完成有序操作
////        while(l1!=null&&l2!=null){
////            if(l1.val<l2.val){
////                cur.next=l1;
////                cur=cur.next;
////                l1=l1.next;
////
////            }else{
////                cur.next=l2;
////                cur=cur.next;
////                l2=l2.next;
////            }
////        }
//////        只要任何一个连表空了，就直接连接另外一个链表
////        if(l1==null){
////            cur.next=l2;
////        }
////        if(l2==null){
////            cur.next=l1;
////        }
////        return dummyHead.next;
////    }
////}

//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//        不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

public class Practice{

    public int removeDuplicates(int[] nums) {
//        //原地修改：不能创建新数组
//        if(nums.length==0){
//            return 0;
//        }
//        int l=nums.length;
//        for(int i=0;i<l;i++){
//            for(int j=0;j<l;j++){
//                if(nums[i]==nums[j]){
//                    nums[j]=nums[j+1];
//                    l--;
//                }
//            }
//        }
//        return l;
//
        //快慢指针
        if(nums.length==0){
            return 0;
        }
        int slow=0;
        int fast=0;
        for(slow=1;slow<nums.length;slow++){
            if(nums[fast]!=nums[slow]){
                fast=fast+1;
                nums[fast]=nums[slow];
            }
        }
        return fast+1;
    }
}