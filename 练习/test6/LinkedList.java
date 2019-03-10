package czy;

import javax.xml.soap.Node;

public class LinkedList implements Sequence{

    private int size;
    //创建一个虚拟头结点，这样每个节点都有头结点
    private Node dummyHead;

    public LinkedList(){

        this.dummyHead=new Node(null,null);
    }
    private class Node{
         Object data;
         Node next;
         public Node(Object data){
             this.data=data;
         }
         public Node(Object data,Node next){
             this.data=data;
             this.next=next;
         }
    }

    @Override
    public void add(Object data) {
        addLast(data);
    }

    @Override
    public boolean remove(int index) {
        rangeCheck(index);
        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node cur=node(index);
        prev.next=cur.next;
        cur.next=null;
        size--;
        return true;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        Node node=node(index);
        return node.data;
    }

    @Override
    public boolean contains(Object data) {
        Node cur=dummyHead.next;
        if(data==null){
            for(int i=0;i<size;i++){
                cur=cur.next;
                if(cur.data==null){
                    return true;
                }
            }
        }else{
            for(int i=0;i<size;i++){
                cur=cur.next;
                if((cur.data).equals(data)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {

        rangeCheck(index);
        Node oldNode=node(index);
        Object oldData=oldNode.data;
        oldNode.data=newData;
        return oldData;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void clear() {
        Node cur=dummyHead.next;
        for(int i=0;i<size;i++){
            cur=null;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data=new Object[size];
        int i=0;
        for(Node temp=dummyHead.next;temp!=null;temp=temp.next){
            data[i]=temp.data;
            i++;
        }
        return data;
    }
    private void rangeCheck(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("索引下标不合法");
        }
    }
    //头插法
    public void addFirst(Object data){
        Node newNode=new Node(data);
        dummyHead.next=newNode;
        newNode.next=dummyHead.next;
        size++;
    }
    //尾插法
    private void addLast(Object data){
        Node newNode=new Node(data);
        Node prev=dummyHead;
        for(int i=0;i<size;i++){
            prev=prev.next;
        }
        prev.next=newNode;
        newNode.next=null;
        size++;
    }
    //任意位置插入
    private void add(int index,Object data){
        rangeCheck(index);
        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node newNode=new Node(data);
        newNode.next=prev.next;
        prev.next=newNode;
        size++;
    }
    public Node node(int index) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        return cur;
    }
}
