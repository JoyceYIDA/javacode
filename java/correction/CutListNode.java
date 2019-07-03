package AJuly.correction;



/**
 * 分割链表
 * 目的是将pHead链表中的值以小于x的在链表前面，大于等于x的在链表后面
 *
 * 定义两个链表，第一个链表表示小于x的结点，第二个链表表示大于等于x的结点
 */
public class CutListNode {
    public ListNode partition(ListNode pHead,int x){
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode cur=pHead;

        //定义两个链表,
        ListNode h1=new ListNode(-1);
        ListNode h2=new ListNode(-1);

        ListNode temp1=h1;
        ListNode temp2=h2;

        while(cur!=null){
            if(cur.val<x){
                temp1.next=new ListNode(cur.val);
                temp1=temp1.next;
            }else{
                temp2.next=new ListNode(cur.val);
                temp2=temp2.next;
            }
            cur=cur.next;
        }
        cur=h1;//第一个链表的头结点
        //循环遍历找到第一个链表的尾节点
        while(cur.next!=null&&cur.next.val!=-1){
            cur=cur.next;
        }
        cur.next=h2.next;
        return h1.next;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(8);
    }

}
