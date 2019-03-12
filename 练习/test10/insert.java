package czy;

public class insert {
    //直接插入排序：时间复杂度为0(n^2);空间复杂度为O(1)。基于有序数组元素插入的。一次插排是稳定的，多次插排会破坏稳定性。
    //将待排序数组分为两个空间，已排序与待排序区间。
    public static void main(String[] args) {
        int[] data=new int[] {5,3,4,2,5,6,9,7,1,-2};
        insertSort(data);
        print(data);
    }
    public static void insertSort(int[] data){
        int n=data.length;
        if(n<=1){
            return;
        }else{
            for(int i=1;i<n;i++){
                int temp=data[i];
                int j=i-1;
                for(;j>=0;j--){
                    if(data[j]>temp){
                        data[j+1]=data[j];
                    }else{
                        break;
                    }
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
