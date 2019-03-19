package czy;

import java.util.Random;

//
//        快速排序：也是基于分治思想
//        从待排序数组中选取任意一个元素，称为分区点或者基准值，开始遍历数组；
//        比基准值大的数放在基准值的右边，比基准值小的放在基准值的左边
public class quick {
    public static void main(String[] args) {
//        int n=100000;
        int[] data=new int[]{-1,6,3,4,33,4,2,7,9,5,19};
//        int[] data=generatNearlySortArray(n,10);
        quickSort(data);
        print(data);

    }
    public static void quickSort(int[] data){
        long start=System.currentTimeMillis();
        int n=data.length;
        if(n<=1){
            return;
        }
        quickSortInternal(data,0,n-1);
        long end=System.currentTimeMillis();
        System.out.println("快速排序共耗时："+(end-start)+"毫秒");
    }
    private static void quickSortInternal(int[] data,int l,int r){
        if(l>=r){
            return;
        }
        int q=partition2(data,l,r);
        quickSortInternal(data,l,q-1);
        quickSortInternal(data,q+1,r);
    }
    private static int partition(int[] data,int l,int r){
        //定义一个基准；在近乎有序的数组中，选择基准值总是默认第一个数，快排的时间复杂度较高，退化为0（n^2)；
        //优化：随机选取基准值
        int randomIndex=(int)((Math.random()*(r-l+1))+l);
        int v=data[randomIndex];
        //定义一个变量指向最左边
        int i=l;
        //定义一个变量指向最右边
        int j=r;
        //开始遍历，当i和j相遇的时候就不再检索
        while(j>i){
            //j从右向左检索到比基准值小的数，就停止检索，从左边开始检索，检索到比基准值大的数，交换这两个数
            while(data[j]>=v&&i<j){//保证不能越界
                j--;
            }
            //不成立就说明这个数比基准数小；i开始从左检索
            while(data[i]<=v&&i<j){
                i++;
            }
            //交换
            swap(data,i,j);
        }
        swap(data,l,j);
        return j;
    }
    private static int partition2(int[] data,int l,int r){
        int randomIndex=(int)((Math.random()*(r-l+1))+l);
        swap(data,randomIndex,l);
        int v=data[l];
        int i=l+1;
        int j=r;
        while(true){
            while(data[i]<v&&i<=r){
                i++;
            }while(data[j]>v&&j>=l+1){
                j--;
            }
            if(i>j){
                break;
            }
            swap(data,i,j);
            i++;
            j--;
        }
        swap(data,l,j);
        return j;
    }
    private  static void swap(int[] data,int indexA,int indexB){
        int temp=data[indexA];
        data[indexA]=data[indexB];
        data[indexB]=temp;
    }
//    public static void quickSort(int[] data){
//        int n=data.length;
//        if(n<=1){
//            return;
//        }
//        quickSortInternal(data,0,n-1);
//    }
//    private static void quickSortInternal(int[] data,int l,int r){
//        if(l>=r){
//            return;
//        }
//        int q=partition(data,l,r);
//        quickSortInternal(data,l,q-1);
//        quickSortInternal(data,q+1,r);
//    }
//    private static int partition(int[] data,int l,int r){
//        //定义一个基准
//        int v=data[l];
//        //定义一个变量指向最左边
//        int i=l;
//        //定义一个变量指向最右边
//        int j=r;
//        //开始遍历，当i和j相遇的时候就不再检索
//        while(j>i){
//            //j从右向左检索到比基准值小的数，就停止检索，从左边开始检索，检索到比基准值大的数，交换这两个数
//            while(data[j]>=v&&i<j){//保证不能越界
//                j--;
//            }
//            //不成立就说明这个数比基准数小；i开始从左检索
//            while(data[i]<=v&&i<j){
//                i++;
//            }
//            //交换
//            swap(data,i,j);
//        }
//        swap(data,l,j);
//        return j;
//    }
//    private  static void swap(int[] data,int indexA,int indexB){
//        int temp=data[indexA];
//        data[indexA]=data[indexB];
//        data[indexB]=temp;
//    }
    public static void print(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
    public static int[] generatNearlySortArray(int n,int swapTimes){
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            //构造一个完全有序的数据集
            result[i]=i;
        }
        for(int i=0;i<swapTimes;i++){
            //随机选取范围内的两个索引下标进行交换
            Random random=new Random();
            int a=random.nextInt(n);
            int b=random.nextInt(n);
            swap(result,a,b);
        }
        return result;
    }
}
