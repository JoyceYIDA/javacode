package czy.mycollection;

//自定义实现一个ArrayList,增加了泛型
public class SxtArrayList02<E>{

    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY=10;

    //构造器构造
    public SxtArrayList02(){
        elementData =new Object[DEFALT_CAPACITY];//默认为10
    }

    public SxtArrayList02(int capacity){
        elementData =new Object[capacity];
    }

    public void add(E element){
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
        SxtArrayList02 s1=new SxtArrayList02(20);
        s1.add("aa");
        s1.add("bb");

        System.out.println(s1);
    }
}
