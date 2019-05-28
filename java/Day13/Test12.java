package Day13;

import java.util.*;



public class Test12 {

    //循环数组a[N],要求每隔两个数删掉一个数；
    // 到末尾循环至开头继续进行直到最后一个数被删除

    //递归出口：数组中没有元素

    public static int delect(int[] a){
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<a.length;i++){
            queue.add(a[i]);
        }
        while(queue.size()!=1){
            int count=2;
            while ((count--)!=0){
                int temp=queue.peek();
                queue.poll();
                queue.add(temp);
            }
            queue.poll();
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] a=new int[n];
            int[] temp=new int[n];
            if(n>1000){
                n=999;
            }
            int N=0;
            for(int i=0;i<n;i++){
                temp[i]=N;
                N++;
            }
            for(int i=0;i<n;i++){
                a[i]=temp[i];
            }
            System.out.println(delect(a));
        }
    }


    //找出n个数中最小的k个


//    private static List find(List list,int k){
//        if(k<list.size()){
//            List list1=new ArrayList();
//            for(int i=0;i<k;i++){
//                list1.add(list.get(i));
//            }
//            return list1;
//        }else{
//            return list;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            String str=scanner.nextLine();
//            String[] strArr=str.split(" ",1000);
//            List<Integer> list=new ArrayList<>();
//            for(int i=0;i<strArr.length;i++){
//                list.add(Integer.valueOf(strArr[i]));
//            }
//            int k= list.get(list.size()-1);
//            list.remove(list.size()-1);
//            Collections.sort(list);
//            for(Object i:find(list,k)){
//                System.out.print(i+" ");
//            }
//        }
//    }
}
