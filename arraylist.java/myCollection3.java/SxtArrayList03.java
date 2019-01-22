package czy.mycollection;

//自定义实现一个ArrayList
//增加泛型
// 增加扩容
public class SxtArrayList03<E>{

    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY=10;

    //构造器构造
    public SxtArrayList03(){
        elementData =new Object[DEFALT_CAPACITY];//默认为10
    }

    public SxtArrayList03(int capacity){
        elementData =new Object[capacity];
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
    }
}

