package myLinkedList.DoubleList;

import myLinkedList.SingleList.ILinked;

/**
 * @author yida
 */
public class DoubleLinked<E> implements ILinked<E> {
    class Node{
        E data;
        Node prev;
        Node next;
        public Node(E data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    private Node head;
    private Node last;
    public DoubleLinked(){
        this.head=null;
        this.last=null;
    }

    @Override
    public void addFirst(E data) {
        Node node=new Node(data);
        //第一次插入
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else{
            node.next=this.head;
            node.next.prev=node;
            this.head=node;
        }
    }

    @Override
    public void addLast(E data) {
        Node node=new Node(data);
        if(this.head==null){
            this.last=node;
            this.head=node;
        }else{
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
    }

    @Override
    public int size() {
        int count=0;
        Node node=this.head;
        while (node!=null){
            count++;
            node=node.next;
        }
        return count;
    }

    @Override
    public void clear() {
        Node cur=null;
        while (this.head!=null){
            this.head.next=null;
            this.head.prev=null;
            this.head=cur;
        }
        this.last=null;
    }

    @Override
    public boolean addIndex(int index, E data) {
        if(index==0){
            addFirst(data);
            return true;
        }
        if(index==size()){
            addLast(data);
        }
        Node node=new Node(data);
        Node cur=findNode(index);

        node.next=cur;
        node.prev=cur.prev;
        cur.prev.next=node;
        cur.prev=node;

        return true;
    }
    private Node findNode(int index){
        checkIndex(index);
        Node cur=this.head;
        int count=0;
        while (count<index){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    private void checkIndex(int index){
        if(index<0||index>size()){
            throw new IndexOutOfBoundsException("坐标不合法");
        }
    }

    @Override
    public boolean contains(E data) {
        Node cur=this.head;
        while(cur!=null){
            if(data.equals(cur.data)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    @Override
    public E delete(E data) {
        Node cur=this.head;
        while (cur!=null){
            if(data.equals(cur.data)){
                E oldData=cur.data;
                //删除的结点是头结点
                if(cur==this.head){
                    this.head=this.head.next;
                    this.head.prev=null;
                }else{
                    if(cur.next!=null) {
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }else{
                        cur.prev.next=null;
                    }
                }
                return oldData;
            }
            cur=cur.next;
        }
        return null;
    }

    @Override
    public void removeAll(E data) {
        Node cur=this.head;
        while (cur!=null){
            if(data.equals(cur.data)){
                E oldData=cur.data;
                //删除的结点是头结点
                if(cur==this.head){
                    this.head=this.head.next;
                    this.head.prev=null;
                }else{
                    if(cur.next!=null) {
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }else{
                        cur.prev.next=null;
                    }
                }
            }
            cur=cur.next;
        }
    }

    @Override
    public void print() {
        Node cur=this.head;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
