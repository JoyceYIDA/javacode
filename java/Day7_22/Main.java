package DJuly.Day7_22;

import java.util.*;

/**
 * 以非字母字符为分隔符逆置字符串，然后将非字母字符转换为空格（比如AB_1A--AB A）
 * case通过率90%
 * 思路：遍历每个字符，如果遇到字母，就将他存储在list中，遇到非字母时，把list中存储的字符变为字符串，然后把字符串放进栈中
 * 放进栈后要清空list，因为list要进行下一轮字母的存储；找到最后一个非字母字符后，list中的数据没有输出，
 * 要判断一下list中是否还有数据，如果还有，就将它作为一个字符串放进栈中，然后将它清空
 * 最终将栈中元素输出
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int len = s.length();
            Stack<String> stack = new Stack<>();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c > 122 || c < 65) {
                    StringBuilder sb=new StringBuilder();
                    for(int j=0;j<list.size();j++){
                        sb.append(list.get(j));
                    }
                    stack.push(sb.toString());
                    list.clear();
                }else{
                    list.add(c);
                }
            }
            if(!list.isEmpty()){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<list.size();j++){
                    sb.append(list.get(j));
                }
                stack.push(sb.toString());
                list.clear();
            }
            while (!stack.isEmpty()) {

                System.out.print(stack.pop());
            }
        }
    }
}
