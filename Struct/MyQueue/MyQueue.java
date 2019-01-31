package DataStruct;

public class MyQueue {

    int[] elements;

    public MyQueue(){
        elements=new int[0];
    }

    //入队列
    public void add(int element){

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

    //出队列
    public int poll(){
        //那数组中第0个元素取出来
        int element=elements[0];
//        创建一个新数组
        int[] newArr=new int[elements.length-1];
        //复制原数组中的元素到新数组中
        for(int i=0;i<newArr.length;i++){
            newArr[i]=elements[i+1];
        }
        //替换数组
        elements=newArr;
        return element;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }

}
