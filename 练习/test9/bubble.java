package czy;

public class bubble {
    //冒泡排序时间复杂度为0(n^2);空间复杂度为O(1),是稳定性排序，也是原地排序。
    //只操作相邻的两个元素，优化：设置标志位，若在某次循环结束后发现无元素调换就说明已经有序，就可以跳出循环。

    public static void main(String[] args) {
        int[] data=new int[] {5,3,4,2,5,6,9,7,1,-2};
        bubbleSort(data);
        print(data);
    }

    public static void bubbleSort(int[] data){
        int n=data.length;
        if(n<=1){
            return;
        }else{
            for(int i=0;i<n;i++){
                boolean flag=false;
                for(int j=0;j<n-i-1;j++){
                    if(data[j]>data[j+1]){
                        flag=true;
                        int temp=data[j];
                        data[j]=data[j+1];
                        data[j+1]=temp;
                    }
                }
                if(!flag){
                    break;
                }
            }
        }
    }
    public static void print(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
}
