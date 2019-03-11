package czy;

import czy.Sequence;

import javax.xml.soap.Node;

public class DoubleLinkedList implements Sequence {

    private int size;
    private Node head;
    private Node tail;


    public DoubleLinkedList(){
    }

    public class Node{
        Object data;
        Node next;
        Node prev;
        public Node(Object data){
            this.data=data;
        }
        public Node(Object data,Node next,Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }


    @Override
    public void add(Object data) {
        Node newNode=new Node(data,null,tail);
        if(head==null){
            head=newNode;
        }else{
            tail.next=newNode;
        }
        tail=newNode;
        size++;
    }

    @Override
    public boolean remove(int index) {
        rangeCheck(index);
        //当前要删除的节点
        Node cur=node(index);
        Node p=cur.prev;
        Node n=cur.next;
        if(p==null){
            head=cur.next;
        }else{//有前驱节点
            p.next=cur.next;
        }if(n==null){
            tail=cur.prev;
        }else{
            n.prev=cur.prev;
        }
        size--;
        return true;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        Node node= node(index);
        return node.data;
    }

    @Override
    public boolean contains(Object data) {
        Node cur=head.next;
        if(data==null){
            for(int i=0;i<size;i++){
                cur=cur.next;
            }
        }
        return true;
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
        for(Node temp=head;head!=null;head=head.next){
            temp=null;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] datas=new Object[size];
        int i=0;
        for(Node temp=head;temp!=null;temp=temp.next){
            datas[i]=temp.data;
            i++;
        }
        return datas;
    }
    private void rangeCheck(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("索引下标不合法");
        }
    }
    public Node node(int index){
        Node temp=head;
        if(index<(size>>1)){
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
        }else {
            for (int i=0;i>index;i--) {
                temp=temp.prev;
            }
        }
        return  temp;
    }
}
