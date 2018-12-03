//Java数组章节练习题
public class ArrayUtils{

//     //1.计算数组中最大值
    // public static int arrayMaxElement(int[] data){
    //     int max=data[0];
    //     for(int i=0;i<data.length;i++){
    //         if(max<data[i]){
    //          max=data[i];
    //         }
    //     }
    //     return max;
    // }
    
    // // //2.计算数组中最小值
    // // public static int arrayMinElement(int[] data){
    //     int min=data[0];
    //     for(int i=0;i<data.length;i++){
    //         if(min>data[i]){
    //             min=data[i];
    //         }
    //     }
    //     return min;
    // }
    
    
    // //3.计算数组值之和
    // public static int arrayElementSum(int[] data){
    //     int sum=0;
    //     for(int i=0;i<data.length;i++){
    //      sum=sum+data[i];
    //     }
    //     return sum;
    // }
    
    // //4.数组拼接
    // // A {1,3,5,7,9} B {2,4,6,8,10} -> {1,3,5,7,9,2,4,6,8,10}
    // public static int[] arrayJoin(int[] a, int[] b){
    //     int len=a.length+b.length;
    //     int []arr=new int[len];
    //     for(int i=0;i<a.length;i++){
    //         arr[i]=a[i];
    //     }
    //     for(int i=a.length;i<arr.length;i++){
    //         arr[i]=b[i-a.length];
    //     }
    //     return arr;
    // }

    // // 5.数组截取
    // // [start, end)
    // // A {1,3,5,7,9} ->(A,1,3) > {3,5}
    // public static int[] arraySub(int[] data, int start , int end){
    //     int []arr=new int [end-start];
    //     for(int i=start;i<=end-start;i++){
    //         arr[i-start]=data[i];
    //     }
    //     return arr;
    // }
    
    // //6.数组打印
    // public static void printArray(int[] data){
    //     for(int i=0;i<data.length;i++){
    //         System.out.print(data[i]);
    //     }
    // }
    
    // 7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
public static void printReversal(int[] data){
        int []arr=new int[data.length];
        for( int i=0;i<data.length;i++){
            arr[i]=data[data.length-i];
         System.out.print(arr[i]);
        }
    }
    
    public static void main(String[] args){
            int [] data1=new int []{1,3,5,7,9};
               int [] data2=new int []{2,4,6,8,10};
                // printArray(data1);
                // printArray(data2);
                // System.out.print(arrayMaxElement(data1));
                // System.out.print(arrayMinElement(data1));
                // System.out.print(arrayElementSum(data2));
                // int [] ret=arrayJoin(data1,data2);
                //   printArray(ret);
                // int []ret=arraySub(data1, 1, 3);
                // printArray(ret);
                 printReversal(data1);
            }
}