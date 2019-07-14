package BJuly.Day7_13;

import java.util.*;


//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String str = sc.nextLine();
//            List<Character> list1=new ArrayList<>();
//            List<Integer> list2=new ArrayList<>();
//            for(int i=65;i<=90;i++){
//                char c= (char) (i+'0');
//                list1.add(c);
//            }
//            for(int i=0;i<str.length())
//        }
//    }
//            find(str);
//        }
//    }
//    public static void find(String str){
//        Map<Integer,Integer> map=new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        for(int i=0;i<str.length();i++){
//            int k=str.charAt(i)-'0';
//            if(k>64&&k<91){
//                if(map.containsKey(k)){
//                    map.put(k,map.get(k)+1);
//                }else{
//                    map.put(k,0);
//                }
//            }
//        }
//        Iterator iterator=map.keySet().iterator();
//        while(iterator.hasNext()){
//            Integer a= (Integer) iterator.next();
//            System.out.println((a+'0')+":"+map.get(a));
//        }
//    }
//}
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String sixteen=sc.nextLine();
            /**
             * substring 截取字符串是左右全开的开区间
             */
            String num=sixteen.substring(2,sixteen.length());
            Stack<Integer> stack=new Stack<>();
            int res=0;
            for(int i=0;i<num.length();i++){
                int t=num.charAt(i)-'0';
                if(t>16){
                    t=t-7;
                }
                stack.push(t);
            }
            int j=0;
            while(!stack.isEmpty()){
                int x=stack.pop();
                res= (int) (res+x*Math.pow(16,j));
                j++;
            }
            System.out.println(res);
        }
    }
}