package Heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 基于数组实现的二叉堆
 * @param <E>
 */
public class Heap<E> {
    //实现任意类的大小比较
    private Comparator<E> comparator;
    //基于数组实现的二叉堆
    private E[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY=10;

    public Heap(){
        this(DEFAULT_CAPACITY,null);
    }
    /**
     * 把任意数组整理为堆
     * 1.add()
     * 2.从最后一个非叶子节点[arr.length-1]开始siftDown，直到根节点为止（因为叶子结点没有子节点，满足天然的堆的性质）
     * 最后一个叶子结点的父节点：[(arr.length-1-1)/2]{会比方法1快近一倍，效率较高}
     */
    public Heap(int initialCapacity){
        this(initialCapacity,null);
    }

    /**
     * heapify 将任意数组变为堆
     * 从最后一个非叶子节点开始进行siftdown操作，直到根节点为止（叶子结点没有子节点，天然满足堆的性质）
     * 堆的add一直在上浮，时间复杂度会较高
     * @param arr 任意数组
     */
    public Heap(E[] arr){
        elementData= (E[]) new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            elementData[i]=arr[i];
        }
        //找到最后一个叶子结点的父节点---最后一个非叶子节点

        size=elementData.length;

        for(int i=(arr.length-1-1)/2;i>=0;i--){
            siftDown(i);
        }
    }

    /**
     * 从外部传入一个比较器和有初始容量的数组
     * 和treeMap(有序）相似
     * @param initialCapacity
     * @param comparator
     */
    public Heap(int initialCapacity,Comparator<E> comparator){
        this.elementData= (E[]) new Object[initialCapacity];
        this.comparator=comparator;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){

        return size==0;
    }

    /**
     * 添加元素:默认在数组的末尾添加；此时添加的元素可能会破坏堆的定义
     * @param e
     */
    public void add(E e){
        //先判断是否扩容
        if(size==elementData.length){
            grow();
        }
        elementData[size++]=e;
        //再上浮;当前最后一个元素上浮
        siftUp(size-1);

    }
    private void grow(){
        int oldCap=elementData.length;
        //旧数组小于64就扩容为原来的两倍，否则就扩容为原来的1.5倍
        int newCap=oldCap+((oldCap<64)?oldCap:oldCap>>1);
        if(newCap>Integer.MAX_VALUE-8){
            throw new IndexOutOfBoundsException("数组容量太大");
        }
        elementData=Arrays.copyOf(elementData,newCap);
    }

    /**
     * 查找堆中的最大值
     * @return
     */
    public E findMax(){
        if(isEmpty())
            throw new IndexOutOfBoundsException("heap is empty");
        return elementData[0];
    }

    /**
     * 取出堆的最大值
     * @return
     */
    public E extractMax(){
        E result=findMax();
        //取出后要删除最大元素
        //交换堆顶元素与最后一个元素的位置
        swap(0,size-1);
        elementData[--size]=null;
        //下沉：从根节点开始
        siftDown(0);
        return  result;
    }
    /**
     *上浮操作：调整当前节点在堆中的位置
     * @param index
     */
    private void siftUp(int index){
        //终止条件：当年节点上浮到根节点；并且当前父节点的值小于于当前节点
        while(index>0&&compare(elementData[parentIndex(index)],elementData[index])<0){
            //交换当前节点的父节点的值与当前结点的值
            swap(index,parentIndex(index));
            index=parentIndex(index);
        }
    }
    private void swap(int indexA,int indexB){
        E temp=elementData[indexA];
        elementData[indexA]=elementData[indexB];
        elementData[indexB]=temp;
    }

    /**
     * 下沉操作
     * 终止条件：沉到叶子结点或者当前节点
     * @param index
     */
    private void siftDown(int index){
        while (leftChildIndex(index)<size){
            int j=leftChildIndex(index);//j保存当前节点左孩子下标
            //判断左孩子大还是右孩子大
            if(j+1<size){
                //此时有右孩子
                if(compare(elementData[j],elementData[j+1])<0){
                    //j指向了右孩子索引的下标；
                    j++;
                }
            }
            //elementData[j]此时一定是左右孩子最大值
            if(compare(elementData[index],elementData[j])>0){
                break;
            }
            swap(index,j);
            //循环继续向下继续
            index=j;
        }
    }

    /**
     * 比较两个元素的大小
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1,E e2){
        if(comparator==null){
            //此时将E转为compareable接口的子类
            return ((Comparable<E>)e1).compareTo(e2);
        }
        return comparator.compare(e1,e2);
    }

    /**
     * 取得父节点、左孩子、右孩子的下标
     */
    private int leftChildIndex(int index){

        return 2*index+1;
    }
    private int rightChildIndex(int index){

        return 2*index+2;
    }
    private int parentIndex(int index){
        if(index==0){
            throw new IllegalArgumentException("该节点没有父节点");
        }
        return (index-1)/2;
    }


    /**
     * 将堆顶元素替换为新元素
     *
     * 1.extractMax()、add() 复杂度较高
     *  2.siftDown()
     * @param e 替换的新元素
     * @return 之前的堆顶元素
     */
    public E replace(E e){
        E result=findMax();
        elementData[0]=e;
        siftDown(0);
        return result;
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(E e:elementData){
            if(e!=null) {
                sb.append(e + "、");
            }
        }
        return sb.toString();
    }
    public int getSize(){
        return this.size;
    }
}
