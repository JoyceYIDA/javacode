package Day5;

import javax.xml.soap.Node;

interface Link{

    int size();
    void add(Object obj);
    boolean remove(Object obj);
    Object set(int index,Object obj);
    Object get(int index);
    boolean contains(Object obj);
    Object[] toArray();
    void printLink();
    void clear();
}
class LinkImpl implements Link{

    //链表的属性：长度；头节点，尾节点
    private int size;
    private Node head;
    private Node last;

//    内部类；方便外部类与他的私有域的访问
    private class Node{
        private Node prev;
        private Object data;
        private Node next;

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(Object obj) {
        //定义一个中间变量存储当前节点
        Node temp=this.last;
//        将数据封装为节点等待插入
        Node newNode=new Node(temp,obj,null);
        this.last=newNode;
        if(head==null){
            this.head=newNode;
        }else{
            temp.next=newNode;//要先判断头结点是否为空；防止抛出空指针异常
        }
        size++;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj==null){
            for(Node temp=head;temp!=null;temp=temp.next){
                if(temp.data==null){
                    //移除
                    unLink(temp);
                    return true;
                }
            }
        }else{
            for(Node temp=head;temp!=null;temp=temp.next){
                if(obj.equals(temp.data)){
                    //移除
                    unLink(temp);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object obj) {
        if(checkIndex(index)==false){
            return "您要查找的下标不存在";
        }
        Object old=node(index).data;
        node(index).data=obj;
        return old;
    }

    @Override
    public Object get(int index) {
        if(checkIndex(index)==false){
            return "您查找的下标不存在";
        }
        return node(index).data;
    }

    @Override
    public boolean contains(Object obj) {
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data.equals(obj)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        int i=0;
        Object[] arr=new Object[size];
        for(Node temp=head;temp!=null;temp=temp.next){
            arr[i++]=temp.data;
        }
        return arr;
    }

    @Override
    public void printLink() {
        Object[] arr=this.toArray();
        for(Object temp:arr){
            System.out.print(temp+"、");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for(Node temp=head;temp!=null;){
            Node flag=temp.next;//保存值
            temp.prev=temp.next=temp=null;
            temp=flag;
            size--;
        }
    }
    //根据下标找到节点
    private Node node(int index){
        if(index<(size>>1)){
            Node temp=head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp;
        }
        Node temp=last;
        for(int i=size-1;i>index;i--){
            temp=temp.prev;
        }
        return temp;
    }
    private boolean checkIndex(int index){

        return index<size-1&&index>0;
    }
    private void unLink(Node node){
        //真正的移除操作
        Node prev=node.prev;
        Node next=node.next;
        if(node.prev==null) {
            //当前节点为头结点
            head = node.next;
        }else{
        }
    }
}


public class DoubleLinked {
    public static void main(String[] args) {
        Link link=new LinkImpl();
        link.add(3);
        link.add(6);
        link.add(9);
        link.add(7);
        link.add(2);
        System.out.println(link.size());
        link.printLink();

//        link.clear();
//        System.out.println(link.size());
        System.out.println(link.get(2));
        System.out.println(link.get(6));
        System.out.println(link.contains(4));
    }
}
