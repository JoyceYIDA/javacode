package czy;

public class merge {
    //归并排序是非稳定性排序，是否稳定主要看代码的写法，用小于等于来保证稳定性
    //空间复杂度0（n），不是原地排序
    public static void main(String[] args) {
        int[] data=new int[] {5,3,4,2,5,6,9,7,1,-2};
        merge(data);
        print(data);
    }
    public static void merge(int[] data){
        int n=data.length;
        if(n<=1){
            return;
        }else {
            mergeInsert(data, 0,n-1);
        }
    }
    private static void mergeInsert(int[] data,int low,int high){
        int mid=low+(high-low)/2;
        if(high<=low){
            return;
        }
            mergeInsert(data,low,mid-1);
            mergeInsert(data,mid+1,high);
            mergeSort(data,low,mid,high);
    }
    private static void mergeSort(int[] data,int p,int q,int r){
        int i=p;
        int j=q+1;
        int k=0;
        int[] temp=new int[r-p+1];
        while(i<=q&&j<=r){
            //用小于等于来保证稳定性
            if(data[i]<=data[j]){
                temp[k++]=data[i++];
            }else{
                temp[k++]=data[j++];
            }
        }
        //判断两个数组中，那个数组还有元素
        int start=i;
        int end=q;
        if(j<=r){
            start=j;
            end=r;
        }
        //将剩余的数据拷贝回temp数组中
        while(start<=end){
            temp[k++]=data[start++];
        }
        //将temp中的数组拷贝回data[p....r]
        for(i=0;i<=r-p;i++){
            data[p+i]=temp[i];
        }
    }
    public static void print(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
}
