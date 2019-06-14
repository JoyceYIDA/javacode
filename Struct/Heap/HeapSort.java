package Heap;

import java.util.Random;

/**
 * 堆排序
 * 时间复杂度O(nlogn)
 * 空间复杂度O(n)
 *
 *
 */
public class HeapSort {

    public static void heapSort1(Integer[] arr){
        //将数组调整成堆
        long start=System.currentTimeMillis();
        Heap<Integer> heap=new Heap<>(arr);
        //从最后一个位置开始
        for(int i=arr.length-1;i>0;i--){
            arr[i]=heap.extractMax();
        }
        long end=System.currentTimeMillis();
        System.out.println("堆排序一共耗时"+(end-start)+"ms");
    }

    /**
     * 原地堆排
     * 1.任意数组-->完全二叉树
     * 2.Heapify-->完全二叉树-->堆
     * @param arr
     *
     * 不断从当前堆的堆顶->数组末尾
     * 再将交换后的数组Heapify
     */
    public static void heapSort2(Integer[] arr){
        //将数组变为堆，但是不使用堆
        int length=arr.length;
        //从最后一个非叶子结点开始
        for(int i=(length-1-1)/2;i>=0;i--){
            //siftdown
            //每次siftdown一定能保证一个元素在堆的最终位置
            siftDown(arr,length,i);
        }
        //依次将最大值换到数组末尾
        for(int i=length-1;i>=0;i--){
            swap(arr,i,0);
            siftDown(arr,i,0);
        }
    }
    private static void swap(Integer[] arr,int indexA,int indexB){
        int temp=arr[indexA];
        arr[indexA]=arr[indexB];
        arr[indexB]=temp;
    }

    /**
     *
     * @param arr 数组
     * @param n 需要调整的长度
     * @param k 调整的位置
     */
    private static void siftDown(Integer[] arr,int n,int k){
        //最后一个左孩子索引超过n就终止
        while(2*k+1 < n){
            int j=2*k+1;
            //取出左右孩子最大值
            if(j+1<n){
                if(arr[j].compareTo(arr[j+1])<0){
                    j++;
                }
            }
            // arr[j]一定是左右孩子的最大值
            if(arr[k]>arr[j]){
                break;
            }
            swap(arr,k,j);
            k=j;//继续交换
        }
    }





    public static void main(String[] args) {
        int n=100;
        Random random=new Random();
        Integer[] data=new Integer[n];
        for(int i=0;i<n;i++){
            data[i]=random.nextInt(1000);
        }
//        heapSort1(data);
//        for(int temp:data){
//            System.out.print(temp+"、");
//        }
        heapSort2(data);
        for(int temp:data){
            System.out.print(temp+"、");
        }
    }
}
