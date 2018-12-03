// //使用for循环打印乘法口诀表
//  public class Test{
//     public static void main(String[] args){
//         int x=1;
//         int y=1;
//         for(x=1;x<10;x++){
//             for(y=1;y<=x;y++){
//                 int z=x*y;
//                 System.out.print(y+"*"+x+"="+z+"\t");
//             }
//             System.out.println();
//         }
//     }
// }
// public class Test{
// public static void main(String[] args){
//    /*  int [] data=new int []{1,2,3,6};{
// for(int i=0;i<data.length;i++){ */
//     int [][]data=new int [][]{
//         {1,2,3},
//         {6,7,8},
//         {1,4,8}
//     };
//     for(int i=0;i<data.length;i++){
//         for(int j=0;j<data[i].length;j++){
//             System.out.print(data[i][j]+"、");
//         }
//     }
//    // System.out.println(data[i]);
// }
// }
// public class Test{
//     public static void main(String[] args){
//         int [] data=init();

//     }
//     public static int[] init(){
//         return new int []{1,2,3,4,5}
//     }
//     public static void printtest(int [] temp)
// }
//递归实现20！
public class Test{
    public static long math(int i){
        if(i==1)
        return 1;
        else
        return i*math(i-1);
    }
    public static void main(String[] args){
        int i=20;
        math(i);
        System.out.print(math(i));
    }
}