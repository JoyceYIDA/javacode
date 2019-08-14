package Sort;

import java.util.Random;

/**
 * @author yida
 */
public class quickSort {
    public static void quickSort(int[] arr){
        int n=arr.length;
        if(n<2){
            return;
        }
        quickInit(arr,0,n-1);
    }
    private static void quickInit(int[] arr,int low,int high){

        //三数取中法
        threeMid(arr,low,high);
        //先做一次分区
        int part=partition(arr,low,high);
        //递归区域的左边和右边
        if(low<part-1){
            quickInit(arr,low,part-1);
        }
        if(high>part+1){
            quickInit(arr,part+1,high);
        }
    }
    private static int partition(int[] arr,int low,int high){
        //选取基准值
//        int randomIndex= (int) (Math.random()*(high-low+1)+low);
//        swap(arr,randomIndex,low);
        int key=arr[low];
        while(low<high){
            //防止越界
            while(low<high&&arr[high]>=key){
                high--;
            }
            //low和high相遇
            if(low==high){
                arr[low]=key;
                //找到位置了
                break;
            }else{
                arr[low]=arr[high];
            }
            while(low<high&&arr[low]<key){
                low++;
            }
            if(low==high){
                arr[high]=key;
                break;
            }else{
                arr[high]=arr[low];
            }
        }
        arr[low]=key;
        return low;
    }
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void threeMid(int[] arr,int low,int high){
        int mid=(low+high)>>>1;
        if(arr[low]>arr[mid]){
            swap(arr,low,mid);
        }
        if(arr[mid]>arr[high]){
            swap(arr,mid,high);
        }
        if(arr[low]>arr[high]){
            swap(arr,low,high);
        }
    }
    public static void main(String[] args) {
        int[] arr=new int[100];
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(100);
        }
        quickSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"/");
        }
    }
}
