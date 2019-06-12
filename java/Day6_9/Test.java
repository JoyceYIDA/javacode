package Day6_9;

import java.util.*;

public class Test {

    //从一个字符串中找出字符串数组中的每个子串，有返回true，没有返回false，最终输出字符串数组。
//    public static boolean[] chkSubStr(String[] p, int n, String s) {
//        boolean[] res=new boolean[n];
//        for(int i=0;i<n;i++){
//            if(s.indexOf(p[i])<0){
//                res[i]=false;
//            }
//            else{
//                res[i]=true;
//            }
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        String[] p=new String[]{"a","b","c","d"};
//        String s="abc";
//        int n=p.length;
//        boolean[] res=chkSubStr(p,n,s);
//        for(int i=0;i<n;i++){
//            System.out.println(res[i]);
//        }
//    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int numPeople=scanner.nextInt();
            //排序策略
            int option=scanner.nextInt();

            List<Student> list=new ArrayList<>();
            for(int i=0;i<numPeople;i++){
                list.add(new Student(scanner.next(),scanner.nextInt()));
            }
            if(option==0){
                list.sort(((o1, o2) -> o2.score-o1.score));
            }else if(option==1){
                list.sort((o1, o2) -> o1.score-o2.score);
            }
            for(Student stu:list){
                System.out.println(stu.name+" "+stu.score);
            }
        }
    }
}
class Student{
    public String name;
    public int score;
    public Student(String name,int score){
        this.name=name;
        this.score=score;
    }
}




//       public static void main(String [] args){
//    Scanner sc = new Scanner(System.in);
//    while (sc.hasNext()) {
//        int n = sc.nextInt();
//        int order = sc.nextInt();
//        ArrayList<Integer> list = new ArrayList();
//        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < n; i++) {
//            String name = sc.next();
//            int score = sc.nextInt();
//            list.add(score);
//            map.put(name + " " + score, score);
//        }            Collections.sort(list);
//        if (order == 0)
//            Collections.reverse(list);
//        int pre = -1;
//        for (int i : list) {
//            if (pre == i)
//                continue;
//            for (String key : map.keySet())
//
//            if (map.get(key).equals(i))
//                System.out.println(key);
//            pre = i;
//        }
//    }
//       }
//}


//28
//1
//hsq 15
//ozslg 79
//ncttmtsphb 71
//a 39
//eiuyzsj 34
//nmlrokx 21
//pjizylo 90
//ec 45
//f 12
//sh 31
//fm 25
//ptprphubqk 29
//wxdiwv 0
//uhlcpjtxad 60
//w 20
//zwktbpun 70
//efzfkf 69
//v 31
//rsnrgtl 73
//do 76
//wt 56
//mcdwd 14
//ydrnoyd 37
//gmlfds 76
//zx 1
//dqx98
//gz 90
//kvbzrwrrjj 13






