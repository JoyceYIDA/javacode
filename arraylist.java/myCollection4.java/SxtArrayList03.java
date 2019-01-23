package yida.mycollexction;

import javax.management.RuntimeErrorException;

//自定义实现一个ArrayList
//增加泛型
//增加扩容
//增加get和set方法并检查索引是否合法
//增加remove方法
public class SxtArrayList03<E>{

    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY=10;

    //构造器构造
    public SxtArrayList03(){

        elementData =new Object[DEFALT_CAPACITY];//默认为10
    }

    public SxtArrayList03(int capacity){
        if(capacity<0){
            throw new RuntimeException("容器的容量不能为负数");
        }else if(capacity==0){
            elementData =new Object[DEFALT_CAPACITY];
        }else{
            elementData=new Object[capacity];
        }

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0?true:false;
    }

    public void add(E element){
        //什么时候扩容
        if(size==elementData.length){
            //怎么扩容,定义一个新数组
            Object[] newArray=new Object[elementData.length+(elementData.length<<1)];//10->15,注意优先级的问题
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData=newArray;
        }
        elementData[size++]=element;
    }
    //增加get和set方法

    public Object get(int index){

        checkRange(index);
        return (E)elementData[index];
    }

    public void set(E element,int index){
        checkRange(index);
        elementData[index]=element;
    }

    //get和set方法都需要检测，所以可以定义一个方法，都可以调用
    public void checkRange(int index){
        //索引合法判断
        if(index<0||index>size-1){
            //不合法索引,手动抛出一个异常
            throw new RuntimeException("请重新索引，该索引不合法："+index);
        }
    }

    public void remove(E element){

        //element和所有元素依次比较，获得第一个比较为true的返回
        for(int i=0;i<size;i++) {
            if (element.equals(get(i))) {//容器中所有的比较操作都是使用equals方法

                //将该元素移除
                remove(i);
            }
        }
    }

    public void remove(int index){

        //a,b,c,d,e->（移除d）a,b,d,e  原理也是数组拷贝
        int numberMoved=elementData.length-index-1;
        if(numberMoved>0) {
            System.arraycopy(elementData, index + 1, elementData, index, numberMoved);
//            elementData[size-1]=null;
//            size--;
        }
//        else{
//            elementData[size-1]=null;
//            size--;
//        }

        elementData[--size]=null;
    }


    //重写toString
    public String toString(){

        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(elementData[i]+",");
        }
//        sb.append("]");
//        为了避免出现[aa,bb,]
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }



    public static void main(String[] args) {
        SxtArrayList03 s1=new SxtArrayList03(20);

        for(int i=0;i<40;i++){
            s1.add("123"+i);
        }

        System.out.println(s1);
        s1.set("joyce",10);
        System.out.println(s1.get(10));

        s1.remove(3);
        s1.remove("1239");
        System.out.println(s1);//输出：[1230,1231,1232,1234,1235,1236,1237,1238,joyce,12311,12312,12313,12314,12315,12316,12317,12318,12319,12320,12321,12322,12323,12324,12325,12326,12327,12328,12329,12330,12331,12332,12333,12334,12335,12336,12337,12338,12339]

        System.out.println(s1.size);
        System.out.println(s1.isEmpty());
//       输出：38
//        false


    }
}