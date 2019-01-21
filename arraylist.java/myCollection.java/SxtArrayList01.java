package czy.mycollection;

//自定义实现一个ArrayList
public class SxtArrayList01 {

    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY=10;

    //构造器构造
    public SxtArrayList01(){
        elementData =new Object[DEFALT_CAPACITY];//默认为10
    }

    public SxtArrayList01(int capacity){
        elementData =new Object[capacity];
    }

    public void add(Object obj){
        elementData[size++]=obj;
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
        SxtArrayList01 s1=new SxtArrayList01(20);
        s1.add("aa");
        s1.add("bb");

        System.out.println(s1);
    }
}
