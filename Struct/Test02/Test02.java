package DataStruct;

public class Test02 {
    public static void main(String[] args) {
        //二分查找（效率高）缺陷是应用面不广
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9};//有顺序地排列
        int dst=0;
        //记录开始位置
        int begin=0;
        //记录结束位置
        int end=arr.length-1;
        //中间位置
        int mid=(begin+end)/2;
        //记录目标位置
        int index=-1;
        while(true){//循环查找
            //什么情况下没有要查找的元素
            //开始在结束的位置之后，或者重合
            if(begin>=end){
               index=-1;
            }

            //判断中间元素是不是目标元素
            if(arr[mid]==dst){
                index=mid;
                break;
            }else{
                //判断中间元素是不是比目标元素大
                if(arr[mid]>dst){
                   //把结束位置调整到中间位置的前一个位置
                   end=mid-1;
                }else{
                    begin=mid+1;
                }
                //取出新的中间位置
                mid=(begin+end)/2;
            }
        }
        System.out.println("index："+index);
    }
}

//        //线性查找
//
//        //目标数组
//        int[] arr=new int[]{2,3,4,5,6,7,8,9,0};
//        //目标元素
//        int dst=8;
//        //目标元素所在的下标
//        int index=-1;
//        //遍历数组
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]==dst){
//                index=i;
//                break;
//            }
//        }
//        //打印目标元素的下标
//        System.out.println("index:"+index);
//    }
//}
