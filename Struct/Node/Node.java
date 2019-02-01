package DataStruct;


//一个节点

public class Node {

    //节点内容
    int data;

    //下一个节点
    Node next;

    //构造方法
    public Node(int data){
        this.data=data;
    }

    //为节点追加节点

    public Node append(Node node){
       //当前节点
       Node currentNode=this;
       while(true){
           //取出下一个节点，赋给当前节点
           Node nextNode=currentNode.next;
           //如果下一个节点为null，也就是当前节点是最后一个节点
           if(nextNode==null){
               break;
           }
           currentNode=nextNode;
       }
       //把需要追加的节点追加到找的的当前节点的下一个节点
        currentNode.next=node;
       return this;
    }

    //取下一个节点
    public Node next(){
        return this.next;
    }
    //获取节点中的数据
    public int getData(){
        return this.data;
    }

    //当前节点是否是最后一个节点
    public boolean isLast(){
        return next==null;
    }

}
