package DataStruct;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {

//        //添加新元素
//        //解决数组长度不可变的问题
//        int[] arr=new int[]{9,8,7};
//        System.out.println(Arrays.toString(arr));
//        //要加入数组的目标元素
//        int dst=6;
//        //创建一个新数组，长度是原数组长度+1；把原数组中的数据全部复制到新数组中；把目标元素加到新数组分的最后；把新数组替换原数组
//        int[] newArr=new int[arr.length+1];
//        for(int i=0;i<arr.length;i++){
//            newArr[i]=arr[i];
//        }
//        newArr[arr.length]=dst;
//        arr=newArr;
//        System.out.println(Arrays.toString(arr));

        //删除元素
        int[] arr=new int[]{1,2,3,4,5,6};
        int del=3;
        System.out.println(Arrays.toString(arr));
        //创建一个新数组，长度是原数组长度-1；复制原数组中除了要删除的那个元素的其他元素；新数组替换旧数组
        int[] newArr1=new int[arr.length-1];
        for(int i=0;i<newArr1.length;i++){
            if(i<del){
                newArr1[i]=arr[i];
            }else{
                newArr1[i]=arr[i+1];
            }
        }

        arr=newArr1;
        System.out.println(Arrays.toString(arr));


//        输出结果：[9, 8, 7]
//[9, 8, 7, 6]
//        [1, 2, 3, 4, 5, 6]
//[1, 2, 3, 5, 6]
//
//        //创建一个数组
//        int[] arr1 = new int[6];
//        //数据类型[] 数组名=new 数据类型[数组长度]；
//        //获取数组长度
//        int length1 = arr1.length;
//        System.out.println(length1);
//        //访问数组中的元素:数组名[下标],下标从0开始，最大长度为数组长度-1
//        //获取
//        System.out.println(arr1[0]);
//        //赋值
//        arr1[0]=99;
//        System.out.println(arr1[0]);
//        //遍历数组
//        for(int i=0;i<length1;i++){
//            System.out.println(arr1[i]);
//        }
//        //创建数组的同时为他赋值
//        int[] arr2=new int[]{22,88,33,66,50};
//        System.out.println("arr2的长度为"+arr2.length);
    }
}
