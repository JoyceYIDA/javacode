package Day.listAndGenericity;

import Day.listAndGenericity.ISequence;

import java.util.Arrays;

//   增加泛型
//       泛型：发生在类转型间的安全隐患
//       类或方法在定义时类型不确定，使用时才确定
public class SequenceArray<T> implements ISequence<T> {

        //创建一个数组
        private Object[] elementData;
        //设置数组默认值
        private final static int DEFAULT_CAPACITY=10;
        //
        private int size;
        //定义一个数组长度的最大值
        private final static int MAX_CAPACITY=Integer.MAX_VALUE-8;

        //无参构造
        public SequenceArray(){
            //初始化原始数组
            this.elementData=new Object[DEFAULT_CAPACITY];
        }
        //有参构造
        public SequenceArray(int capacity){
            if(capacity>=0){
                this.elementData=new Object[capacity];
            }
        }


        public void setElementData(Object[] elementData) {
            this.elementData = elementData;
        }

        @Override
        public void add(T data) {

            //先判断数组是否满了，满了就扩容,然后再把元素添加进数组
            ensureCapacity(size+1);
            //把元素放入当前数组的最后一个元素的后面
            elementData[size++]=data;

        }

        @Override
        public boolean remove(int index) {
            //先判断要删除的元素下标是否合法，然后把该下标的元素取出来后面的元素
            rangeCheck(index);
            Object oldData=elementData[index];
            int copySize=size-index-1;
            if(copySize>0){
                System.arraycopy(elementData,index+1,elementData,index,copySize);
                return true;
            }
            elementData[--size]=null;
            return false;
        }

        @Override
        public Object get(int index) {
            //先判断索引是否合法
            rangeCheck(index);
            return (T)elementData[index];
        }

        @Override
        public boolean contains(T data) {
            //判断是否有指定元素，使用equals方法比较内容是否相等
            //如果查找的元素是空，进行一次遍历
            if(data==null){
                for(int i=0;i<size;i++){
                    if(elementData[i]==null){
                        return true;
                    }
                }
            } else{//遍历，使用equals遍历
                for(int i=0;i<size;i++){
                    if(elementData[i].equals(data)){
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public Object set(int index, T newData) {
            rangeCheck(index);
            //先取得原来的值
            Object oldData= elementData[index];
            //替换成新的值
            elementData[index]=newData;
            return oldData;
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public void clear() {
            for(int i=0;i<size;i++){
                elementData[i]=null;
            }
            this.size=0;
        }

        @Override
        public Object[] toArray() {
            for(int i=0;i<elementData.length;i++){
                if(elementData[i]==null){
                    break;
                }
                System.out.print(elementData[i]+"、");
            }
            System.out.println();
            return this.elementData;
        }
        private void ensureCapacity(int cap){
            //判断数组容量是否够用，不能用size，因为size是真实存放的元素个数
            if(cap-elementData.length>0){
                //扩容
                grow(cap);
            }
        }
        private void grow(int cap){
            int oldCap=elementData.length;
            int newCap=oldCap<<1;
            if(newCap-cap<0){
                newCap=cap;
            }
            if(newCap-MAX_CAPACITY>0){
                throw new IndexOutOfBoundsException("数组超过了最大值！！！");
            }
            //扩容成功
            elementData= Arrays.copyOf(elementData,newCap);
        }
        private void rangeCheck(int index){
            if(index<0||index>size){
                throw new IndexOutOfBoundsException("索引下标不合法");
            }
        }
    }

