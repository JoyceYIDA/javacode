package DataStruct;

public class Node{

    Object data;//要存储的数据
    Node next;//内容

    //构造方法
    public Node(){

    }
    public Node(Object data){
        super();
        this.data=data;
    }
    public Node(Object data,Node next){
        super();
        this.data=data;
    }

    public Object getData(){
        return data;
    }
    public void setData(){

        this.data=data;
    }
    public Node getNext(){

        return next;
    }

}
