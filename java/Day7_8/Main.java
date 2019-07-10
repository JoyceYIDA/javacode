package BJuly.Day7_8;

//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String str=sc.nextLine();
//            String[] arr=str.split(" ");
//            List<String> list=new ArrayList<>();
//            list.add(arr[0]);
//            for(int i=1;i<arr.length;i++){
//                list.add(arr[i]+" ");
//            }
//            Collections.reverse(list);
//            for(String list1:list){
//                System.out.print(list1);
//            }
//        }
//    }
//}


import sun.awt.datatransfer.DataTransferer;
/**
 * 给定一个文件路径，统计它出现的次数，而且只需文件名和出现错误出现的行数，
 * 首次出现为次数为1，并且只存储8条数据
 */
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Map<String,Integer> map=new LinkedHashMap<>();
        while(sc.hasNext()){
            String str=sc.nextLine();
            int id=str.lastIndexOf('\\');
            String fileName=id==-1?str:str.substring(id+1);
            int line=sc.nextInt();
            //统计频率：
            String key=fileName+" "+line;
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        List<Map.Entry<String,Integer>> list=new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        //只输出前8条
        int m=0;
        for(Map.Entry<String,Integer> mapping:list){
            if(m>=8){
                break;
            }
            String[] s=mapping.getKey().split(" ");
            String fileName=s[0];
            if(fileName.length()>16){
                fileName=fileName.substring(fileName.length()-16);
            }
            String n=s[1];
            Integer count=mapping.getValue();
            System.out.printf("%s %s %d%n",fileName,n,count);
            m++;
        }
    }
}