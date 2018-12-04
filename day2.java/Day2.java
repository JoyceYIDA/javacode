public class Day2{
  public static void main(String[] args){
      int[] intData=new int[]{1,5,3,4,2,7};
      char[] charData=new char []{'c','z','k','a','w'};
      java.util.Arrays.sort(intData);
      java.util.Arrays.sort(charData);//基本数据类型数组排序
      printArray(intData);
      printArray(charData);
  }
  public static void printArray(int[]arr){
      for(int i=0;i<arr.length;i++){
          System.out.println(arr[i]);
      }
      System.out.println();
  }
  //方法重载
public static void printArray(char[]arr){
    for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
    }
    System.out.println();
}
}