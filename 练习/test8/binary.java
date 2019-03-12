package czy;

public class binary {
    //折半插入排序；优化：寻找插入位置，从中间位置开始插入

    public static void main(String[] args) {
        int[] data=new int[] {5,3,4,2,5,6,9,7,1,-2};
        binarySort(data);
        print(data);
    }
    public static void binarySort(int[] data){
        int n=data.length;
        if(n<=1){
            return;
        }else{
            for(int i=0;i<n;i++){
                //把未排序的插入到已经有序的数组中，默认第一个元素有序，已经有序的数组区间就是high到low
                int high=i-1;
                int low=0;
                int j=i-1;
                int temp=data[i];
                while(high>=low){
                    //和区间的中间值比较，该值比中间值大的话就把区间向右移；
                    int mid=low+(high-low)/2;
                    if(temp>data[mid]){//保证排序的稳定性
                        low=mid+1;
                    }else{
                        high=high-1;
                    }
                }
                for(;j>=low;j--){
                    data[j+1]=data[j];
                }
                data[j+1]=temp;
            }
        }
    }
    public static void print(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
}
