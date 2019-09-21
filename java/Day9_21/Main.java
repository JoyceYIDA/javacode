import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String str=sc.nextLine();
//            String[] strs=str.split(" ");
//
//        }
//    }
//}

//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String str=sc.nextLine();
//            String[] strs=str.split("-");
//            int m=0;
//            int d=0;
//            if(strs[1].charAt(0)=='0'){
//                m=Integer.parseInt(strs[1]);
//            }else{
//                m=Integer.parseInt(strs[1]);
//            }
//            if(strs[2].charAt(0)=='0'){
//                d=Integer.parseInt(strs[2].substring(1));
//            }else{
//                d=Integer.parseInt(strs[2]);
//            }
//            int y=Integer.parseInt(strs[0]);
//            int day=method(y,m,d);
//            System.out.println(day);
//        }
//    }
//    private static int method(int y,int m,int d){
//        int[] day={31,28,30,31,30,31,31,30,31,30,31};
//        if(y<=0||m<=0||m>12||d<=0||d>day[m-1]){
//            return -1;
//        }
//        if(y%4==0&&y%100!=0||y%4==0){
//            day[1]=29;
//        }
//        int sum=0;
//        for(int i=0;i<m-1;i++){
//            sum+=day[i];
//        }
//        return sum+d;
//    }
//}

//public class Main{
//    class ListNode{
//        ListNode next;
//        int val;
//        public ListNode(int val){
//            this.val=val;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            List<Integer> list=new LinkedList<>();
//            String s=sc.next();
//            if(s!="#"){
//                list.add(Integer.parseInt(s));
//            }
//
//        }
//    }
//}

//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String a=sc.nextLine();
//            String b=sc.nextLine();
//            System.out.println(method(a,b));
//        }
//    }
//    private static String method(String a,String b){
//        StringBuilder sb=new StringBuilder();
//        int[] arr1=getInt(a);
//        int[] arr2=getInt(b);
//        sb.append(arr1[0]*arr2[0]-arr1[1]*arr2[1]);
//        sb.append('+');
//        sb.append(arr1[0]+arr2[1]+arr1[1]*arr2[0]);
//        sb.append('i');
//        return sb.toString();
//    }
//    private static int[] getInt(String s){
//        int[] arr=new int[2];
//        StringBuilder sb=new StringBuilder();
//        StringBuilder sp=new StringBuilder();
//        int i=0;
//        while(s.charAt(i)!='+'){
//            sb.append(s.charAt(i++));
//        }
//        i++;
//        while (s.charAt(i) != 'i') {
//            sp.append(s.charAt(i++));
//        }
//        arr[0]=new Integer(sb.toString());
//        arr[1]=new Integer(sp.toString());
//        return arr;
//    }
//}

//
//
//
//public class Main{
//    public static void main(String[] args) {
//        int[] arr=new int[100];
//        Random random=new Random();
//        for(int i=0;i<100;i++){
//            arr[i]=random.nextInt(1000);
//        }
//        heapSort(arr);
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+"/");
//        }
//    }
//    public static void mergeSort(int[] arr){
//        int n=arr.length;
//        if(n<2){
//            return;
//        }
//        meger(arr,0,n-1);
//    }
//    private static void meger(int[] arr,int low,int high){
//        if(low>=high){
//            return;
//        }
//        int mid=low+(high-low)/2;
//        meger(arr,low,mid);
//        meger(arr,mid+1,high);
//        mergeInit(arr,low,high,mid);
//    }
//    private static void mergeInit(int[] arr,int low,int high,int mid){
//        //合并操作，需要开辟一个新数组
//        int[] temp=new int[arr.length];
//        int i=low;
//        int j=mid+1;
//        int k=0;
//        while(i<=mid&&j<=high){
//            //左右两边还有元素
//            if(arr[i]<=arr[j]){
//                temp[k++]=arr[i++];
//            }else{
//                temp[k++]=arr[j++];
//            }
//        }
//        //判断哪边还有元素
//        int start=i;
//        int end=mid;
//        if(j<=high){
//            //后半部分还有元素
//            start=j;
//            end=high;
//        }
//        while(start<=end){
//            temp[k++]=arr[start++];
//        }
//        for(i=0;i<high-low+1;i++){
//            arr[low+i]=temp[i];
//        }
//    }
//    public static void quickSort(int[] arr){
//        int n=arr.length;
//        if(n<2){
//            return;
//        }
//        quick(arr,0,n-1);
//    }
//    private static void quick(int[] arr,int low,int high){
//        if(low>=high){
//            return;
//        }
//        int less=low;
//        int more=high+1;
//        int i=low+1;
//        int key=arr[low];
//        while(i<more){
//            if(arr[i]<key){
//                swap(arr,i,less+1);
//                i++;
//                less++;
//            }else if(arr[i]==key){
//                i++;
//            }else{
//                swap(arr,i,more-1);
//                more--;
//            }
//        }
//        swap(arr,low,less);
//        quick(arr,low,less-1);
//        quick(arr,more,high);
//    }
//    private static void swap(int[] arr,int a,int b){
//        int temp=arr[a];
//        arr[a]=arr[b];
//        arr[b]=temp;
//    }
//    private static void heapSort(int[] arr){
//        for(int i=(arr.length-1-1)/2;i>=0;i--){
//            heap(arr,i,arr.length-1);
//        }
//        for(int i=0;i<arr.length-1;i++){
//            swap(arr,0,arr.length-1-i);
//            heap(arr,0,arr.length-1-i-1);
//        }
//    }
//    private static void heap(int[] arr,int start,int end){
//        int temp=arr[start];
//        for(int i=start*2+1;i<=end;i=i*2+1){
//            if(i<end&&arr[i]<arr[i+1]){
//                i++;//此时i保存的是左右孩子最大值
//            }
//            if(arr[i]>temp){
//                arr[start]=arr[i];
//                start=i;
//            }else if(arr[i]<temp){
//                break;
//            }
//        }
//        arr[start]=temp;
//    }
//}


//#include<iostream>
//        #include<vector>
//        using namespace std;
//        int NoRec_GetMax(vector<int>arr,int len)
//        {
//        int* max=new int[len];
//        max[0]=arr[0];
//        max
//        }
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            int[][] arr=new int[n][n];
//            for(int i=0;i<n;i++){
//                for(int j=0;j<n;j++){
//                    arr[i][j]=sc.nextInt();
//                }
//            }
//            int[] maxS=new int[n];
//            for(int i=0;i<n;i++){
//                maxS[i]=arr[i][0];
//            }
//            int k=0;
//            for(int i=0;i<arr.length;i++){
//                int max=arr[i][0];
//                for(int j=1;j<arr[0].length;j++){
//                    if(max>0){
//                        max=max+arr[i][j];
//                    }else{
//                        max=arr[i][j];
//                    }
//                    maxS[k]=(max<maxS[k])?maxS[k]:max;
//                }
//                k++;
//            }
//            int res=0;
//            for(int i=0;i<n;i++){
//                res+=maxS[i];
//            }
//            System.out.println(res);
//        }
//    }
//}


//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String s=sc.nextLine();
//        StringBuilder sb=new StringBuilder();
//
//        for(int i=0;i<s.length();i++){
//            char r=0;
//            int n=0;
//            char c=s.charAt(i);
//            if(c=='['){
//                r=s.charAt(i+1);
//            }else if(c>'0'&&c<'9'){
//                n=c;
//            }else {
//                while (n >= 0) {
//                    sb.append(c);
//                    n--;
//                }
//            }
//        }
//        System.out.println(sb.toString());
//    }
//}

//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String s=sc.nextLine();
//            String[] ss=s.split(",");
//            int[] arr=new int[ss.length];
//            for(int i=0;i<ss.length;i++){
//                arr[i]=Integer.parseInt(ss[i]);
//            }
//            boolean res=method(arr);
//            if(res==true){
//                System.out.println(1);
//            }else{
//                System.out.println(0);
//            }
//        }
//    }
//    private static boolean method(int[] arr){
//        if(arr.length==0){
//            return true;
//        }
//        if(arr.length==1){
//            return true;
//        }
//        int res=0;
//        for(int i=1;i<arr.length;i++){
//            if(res>1){
//                return false;
//            }
//            if(arr[i]<arr[i-1]){
//                res++;
//                if(i-1>0&&arr[i-2]>arr[i]){
//                    arr[i]=arr[i-1];
//                }else{
//                    arr[i-1]=arr[i];
//                }
//            }
//        }
//        return res<=1;
//    }
//}

//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String s=sc.nextLine();
//            System.out.println(method(s));
//        }
//    }
//    public static String method(String s){
//        StringBuilder sb=new StringBuilder("$");
//        for(int i=0;i<s.length();i++){
//            sb.append('#');
//            sb.append(s.charAt(i));
//        }
//        sb.append('#');
//        sb.append('@');
//        int r=0;
//        int mid=0;
//        int len=sb.length();
//        int[] p=new int[len];
//        for(int i=1;i<len-1;i++){
//            while(sb.charAt(i-(p[i]+1))==sb.charAt(i+(p[i]+1)))
//                p[i]++;
//            if(i+p[i]>r) {
//                mid = i;
//                r = i + p[i];
//            }
//        }
//        int longest=0;
//        int index=0;
//        for(int i=1;i<p.length;i++){
//            if(p[i]>longest){
//                longest=p[i];
//                index=i;
//            }
//        }
//        return s.substring((index-longest)/2,(index+longest)/2);
//    }
//}

public class Main{
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int max=sc.nextInt();
        for(int i=1;i<=max;i++){
            list.add(i);
        }
        method(list,0,max-1);
    }
    private static void method(List<Integer> list,int start,int end){
        if(start==end){
            for(Integer e:list){
                System.out.print(e+" ");
            }
            System.out.println();
        }else{
            for(int i=start;i<=end;i++){
                swap(list,start,i);
                method(list,start+1,end);
                swap(list,start,i);
            }
        }
    }
    private static void swap(List<Integer> list,int i,int j){
        Integer t=list.get(i);
        list.set(i,list.get(j));
        list.set(j,t);
    }
}






















