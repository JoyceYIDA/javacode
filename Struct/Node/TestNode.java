package DataStruct;

import DataStruct.Node;

public class TestNode {

    public static void main(String[] args) {
        //创建节点
        Node n1=new Node(1);//此时节点内容为1，地址为Null
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        n1.append(n2).append(n3).append(n4);
        //取出下一个节点
        System.out.println(n1.next().next().getData());
        //判断节点是否为最后一个节点
        System.out.println(n1.next().next().next().isLast());
    }
}
