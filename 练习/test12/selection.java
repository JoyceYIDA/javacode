package czy;

public class selection {
    //选择排序：也是分已排序区间和未排序区间，每次从未排序区间找到最小元素，把它换到最前面；
    public static void main(String[] args) {
        int[] data=new int[] {5,3,4,2,5,6,9,7,1,-2};
        selectionSort(data);
        print(data);
    }
    public static void selectionSort(int[] data){
        int n=data.length;
        if(n<=1){
            return;
        }else{
            for(int i=0;i<n-1;++i){
                int minIndex=i;
                for(int j=i+1;j<n;++j){
                    if(data[j]<data[minIndex]){
                        minIndex=j;
                    }
                }
                int temp=data[i];
                data[i]=data[minIndex];
                data[minIndex]=temp;
            }
        }
    }
    public static void print(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
}
