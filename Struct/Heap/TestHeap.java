package Heap;

public class TestHeap {
    public static void main(String[] args) {
        Heap<Integer> heap=new Heap<Integer>();
        int[] data=new int[]{17,15,62,41,22,13,19,30,28,16};
        for(int i:data){
            heap.add(i);
        }
        //把任意一个数组整理成堆，使用add方法
        System.out.println(heap.getSize());
//        System.out.println(heap.replace(25));
////        heap.add(52);
////        heap.extractMax();
//        System.out.println(heap.findMax());
    }
}
