package DS1;

public class LinkedStack<T> implements Stack<T> {
    private Node top;
    private int currentSize;
    public class Node{
        private T t;
        private Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

    }
    @Override
    public boolean push(T t) {
        //创建新节点
        Node newNode=new Node(t,null);
        if(top==null){
            top=newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
        currentSize++;
        return true;
    }

    @Override
    public T pop() {
        if(top==null){
            System.out.println("栈为空！！！");
        }
            T temp = top.t;
            top=top.next;
            currentSize--;
            return temp;
    }

    @Override
    public T peek() {
        return top.t;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }
}
