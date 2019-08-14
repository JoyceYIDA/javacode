package Sort;

import java.util.Random;

/**
 * @author yida
 */
public class heapSort {
    public static void heapSort(int[] arr){
        if(arr.length<2){
            return;
        }
        //构造初始堆
        for(int i=(arr.length-1-1)/2;i>=0;i--){
            heap(arr,i,arr.length-1);
        }
        //交换最大值和根节点
        for(int i=0;i<arr.length-1;i++){
            swap(arr,0,arr.length-1-i);
            heap(arr,0,arr.length-1-i-1);
        }
    }
    public static void heap(int[] arr,int start,int end){
        int temp=arr[start];
        for(int i=start*2+1;i<=end;i++){
            if(i<end&&arr[i]<arr[i+1]){
                i++;//此时i保存的是左右孩子的最大值
            }
            if(arr[i]>temp){
                arr[start]=arr[i];
                start=i;
            }else if(arr[i]<temp){
                break;
            }
        }
        arr[start]=temp;
    }
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int[] arr=new int[100];
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(100);
        }
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"/");
        }
    }
}
