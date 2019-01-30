package DataStruct;

public class MyStack {
    //栈的底层使用数组存储数据
    int[] elements;

    public MyStack(){

        elements=new int[0];
    }
    //压入元素
    public void push(int element){
        //创建一个新数组
        int[] newArr=new int[elements.length+1];

        //把原数组内容复制到新数组中
        for(int i=0;i<elements.length;i++) {
            newArr[i] = elements[i];
        }

        //把添加的新元素放入新数组
        newArr[elements.length]=element;

        //新数组替换旧数组
        elements=newArr;
    }

    //取出栈顶元素
    public int pop(){

        //取最后一个元素，栈可能是空，长度为0，所以如果为-1就会出现异常
        if(elements.length==0){
            throw new RuntimeException("stack is empty");
        }

        //取出最后一个元素
        int element=elements[elements.length-1];

        //创建一个新数组，长度-1
        int[] newArr=new int[elements.length-1];

        //原数组中除了最后一个元素，其他元素都放入新的数组中
        for(int i=0;i<elements.length-1;i++){
            newArr[i]=elements[i];
        }
        elements=newArr;
        //返回栈顶元素
        return element;
    }

    //查看栈顶元素
    public int peek(){
        if(elements.length==0){
            throw new RuntimeException("stack is empty");
        }
        return elements[elements.length-1];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }
}
