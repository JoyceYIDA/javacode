package myLinkedList.SingleList;

import myLinkedList.SingleList.ILinked;

/**
 * @author yida
 */
public class MySingleList<E> implements ILinked<E> {
    //内部类
    class Node{
        E data;
        Node next;
        public Node(){

        }
        public Node(E data){
            this.data=data;
        }
    }
    //头结点
    private Node head;

    public MySingleList(){
        //初始化
        this.head=null;
    }


    @Override
    public void addFirst(E data) {
        Node node=new Node(data);
        if(head==null){
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }
    }

    @Override
    public void addLast(E data) {
        Node node=new Node(data);
        Node cur=this.head;
        if(head==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }

    @Override
    public int size() {
        Node cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    /**
     * 清空结点
     */
    @Override
    public void clear() {
        while (this.head!=null){
            Node cur=this.head.next;
            this.head.next=null;
            this.head.data=null;
            this.head=cur;
        }
    }

    @Override
    public boolean addIndex(int index,E data) {
        //index位置的前驱节点
        Node node=new Node(data);
        Node prev=prevIndex(index);
        if(prev==null){
           addFirst(data);
        }else{
            node.next=prev.next;
            prev.next=node;
        }
        return true;
    }

    @Override
    public boolean contains(E data) {
        Node node=this.head;
        while(node!=null){
            if(node.data.equals(data)){
                return true;
            }
            node=node.next;
        }
        return false;
    }

    /**
     * 找到index-1的位置
     * @param index
     * @return
     */
    private Node prevIndex(int index){
        checkIndex(index);
        if(index==0){
            return null;
        }
        int count=0;//记录走的步数
        Node node=this.head;
        while (node.next!=null&&count<index-1){
            node=node.next;
            count++;
        }
        return node;
    }

    /**
     * 判断index的合法性
     * @param index
     */
    private void checkIndex(int index){
        if(index<0||index>size()){
            throw new IndexOutOfBoundsException("下标不合法！");
        }
    }

    @Override
    public E delete(E e) {
        Node pre=prevNode(e);
        E oldData;
        if(pre==null){
            throw new IndexOutOfBoundsException("要删除的结点没有前驱节点");
        }

        if(pre==this.head&&pre.data.equals(e)){
            oldData=this.head.data;
            this.head=this.head.next;
            return oldData;
        }
        Node deleteNode=pre.next;
        oldData=deleteNode.data;
        pre.next=deleteNode.next;

        return oldData;
    }

    private Node prevNode(E e){
        Node node=this.head;
        //判断是不是第一个结点
        if(node.data.equals(e)){
            return this.head;
        }
        //遍历单链表
        while(node.next!=null){
            if(e.equals(node.next.data)){
                return node;
            }
            node=node.next;
        }
        return null;
    }

    /**
     * 删除所有结点值为e的结点
     * @param e
     * @return
     */
    @Override
    public void removeAll(E e) {
        Node pre=this.head;
        Node cur=this.head.next;
        while (cur!=null){
            if(e.equals(cur.data)) {
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        if(e.equals(this.head.data)){
            this.head=this.head.next;
        }
    }

    @Override
    public void print() {
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+"、");
            cur=cur.next;
        }
        System.out.println();
    }
}
