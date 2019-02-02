package DataStruct;

public class SingleLinkedList implements  List{

    private Node head=new Node();//头结点，不存储数据
    private int size;//一共有几个结点

    public int size(){
        return size;
    }
    public Object get(int i){
        //和顺序表不同，从头索引
        Node p=head;
        for(int j=0;j<=i;j++){
            p=p.next;
        }
        return p.data;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean contains(Object e){
        return false;
    }

    public int indexOf(Object e){
        return 0;
    }

    public void add(int i,Object e){
        //如果i位置异常
//        if(i<0||i>size){
//            throw ("数组越界异常"+i);
//        }

        //找到前一个节点，从head节点开始
        Node p=head;
        for(int j=0;j<i;j++){
            p=p.next;
        }

        //创建一个节点
        //Node newNode=new Node(e);
        Node newNode=new Node();
        newNode.data=e;
        //newNode.next=null;

        //指明新节点的直接后继节点
        newNode.next=p.next;

        //指明新节点的直接前驱节点
        p.next=newNode;
        //每增加一个节点，size+1
        size++;
    }
    public void add(Object e){
        this.add(size,e);
    }
    public boolean addBefore(Object obj,Object e){
        return true;
    }

    public boolean addAfter(Object obj,Object e){
        return true;
    }
    public Object remove(int i){
        return null;
    }
    public Object replace(int i,Object e){
        return null;
    }
    public String toString(){
        if(size==0){
            return "[]";
        }
        StringBuilder sb=new StringBuilder('[');
        Node p=head.next;
        for(int i=0;i<size;i++){
            if(i!=size-1){
                sb.append(p.data+",");
            }else{
                sb.append(p.data);
            }
            //移动指针到下一个节点
            p=p.next;
        }
        sb.append(']');
        return sb.toString();
    }
}
