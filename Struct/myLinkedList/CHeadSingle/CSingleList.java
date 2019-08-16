package myLinkedList.CHeadSingle;

import myLinkedList.SingleList.ILinked;

/**
 * @author yida
 */
public class CSingleList<E> implements ILinked<E> {
    class Node{
        E data;
        Node next;
        public Node(){
            this.data=null;
        }
        public Node(E e){
            this.data=e;
        }
    }

    private Node head;

    public CSingleList(){
        //不带参数的构造来初始化头结点，头结点没有data
        //根据循环单链表的性质，初始化头结点，头结点的next应该是他自己
        this.head=new Node();
        this.head.next=head;
    }

    /**
     * 在单链表头结点后面添加
     * @param data
     */
    @Override
    public void addFirst(E data) {
        Node node=new Node(data);
        node.next=this.head.next;
        this.head.next=node;
    }

    @Override
    public void addLast(E data) {
        Node node=new Node(data);
        Node cur=this.head;
        while (cur.next!=this.head){
            cur=cur.next;
        }
        node.next=this.head;
        cur.next=node;
    }

    @Override
    public int size() {
        int count=0;
        Node cur=this.head.next;
        while (cur!=this.head){
            count++;
            cur=cur.next;
        }
        return count;
    }

    @Override
    public void clear() {
        while (this.head.next!=this.head){
            Node node=this.head.next;
            this.head.next=node.next;
            node.next=null;
        }
    }

    @Override
    public boolean addIndex(int index, E data) {
        Node node=new Node(data);
        checkIndex(index);
        Node cur=this.head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        node.next=cur.next;
        cur.next=node;
        return true;
    }

    private void checkIndex(int index){
        if(index<0||index>size()){
            throw new IndexOutOfBoundsException("下标非法");
        }
    }

    @Override
    public boolean contains(E e) {
        Node cur=this.head.next;
        while(cur!=this.head){
            if(e.equals(cur.data)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    @Override
    public E delete(E e) {
        //找到前驱节点
        Node prev=findPrev(e);
        if(prev==null){
            throw new UnsupportedOperationException("找不到e");
        }
        E oldData=null;
        Node deleteNode=prev.next;
        oldData=deleteNode.data;
        prev.next=deleteNode.next;
        return oldData;
    }
    private Node findPrev(E e){
        Node prev=this.head;
        while(prev.next!=this.head){
            if(e.equals(prev.next.data)){
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }

    @Override
    public void removeAll(E e) {
        Node prev=this.head;
        Node cur=prev.next;
        while (cur!=this.head){
            if(e.equals(cur.data)){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
    }

    @Override
    public void print() {
        Node cur=this.head.next;
        while (cur!=this.head){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
