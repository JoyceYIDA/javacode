package Day3;

//报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
//        1.     1
//        2.     11
//        3.     21
//        4.     1211
//        5.     111221
//        1 被读作  "one 1"  ("一个一") , 即 11。
//        11 被读作 "two 1s" ("两个一"）, 即 21。
//        21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
//        给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
//        注意：整数顺序将表示为一个字符串。
public class Test2 {
    public String countAndSay(int n) {
        //可以使用递归
        //递归出口：n==1的时候返回1；
        if (n == 1) {
            //将数字转为字符串
            String s = Integer.toString(n);
            return s;
        } else {

            String result = countAndSay(n - 1);
            //保存result的中间值s
            String s = new String(result);
            result = "";
            char num='1';
            //报数过程是读上个字符串里有几个几；遇到不同的字符就停止计数，所以要有一个计数器
            Integer count = 0;//因为后面要转换为字符串；所以用包装类
            String s1="";
            for (int i = s.length() - 1; i >= 0; i--) {
                char num1 = s.charAt(i);
                if (num1 == num) {
                    count++;
                } else {
                    if (count > 0) {
                        s1 = count.toString();
                    }
                    result = s1 + num + result;
                    num=num1;
                    count=1;//当遇到不一样的字符；计算器置为一开始新一轮的计数
                }
            }
            if(count>0){
                s1=count.toString();
            }
            return s1+num+result;
        }
    }

    public static void main(String[] args) {
        Test2 test2=new Test2();

        System.out.println(test2.countAndSay(5));
    }
}
