package czy;

public class shell {
    //希尔排序：不是稳定性排序，是对直接插入排序的优化。

    public static void main(String[] args) {
        int[] data=new int[] {5,3,4,2,5,6,9,7,1,-2};
        shellSort(data);
        print(data);
    }
    public static void shellSort(int[] data){
        int n=data.length;
        if(n<=1){
            return;
        }else{
            int step=n/2;
            while(step>=1){
                for(int i=step;i<n;i++){
                    int temp=data[i];
                    int j=i-step;
                    for(;j>=0;j-=step){
                        if(temp<data[j]){
                            data[j+step]=data[j];
                        }
                        else{
                            break;
                        }
                    }
                    data[j+step]=temp;
                }
                step=step/2;
            }
        }
    }
    public static void print(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
}

