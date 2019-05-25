package Day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test0 {


    public boolean isValid(String s) {
//        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//        有效字符串需满足：
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串
        //先进后出：栈；并且括号的一半和另一半是一一对应的，那么就可以用map存储
        Stack<Character> stack=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        //括号一一对应，字符串长度如果是单数，那么就一定是false
        int i=s.length();
        if(i%2!=0||s.startsWith("}")||s.startsWith("]")||s.startsWith(")")){
            return false;
        }else if(s.equals("")){
            return true;
        }
        //遍历字符串，将字符串拆分成字符
         for(int j=0;j<i;j++){
            char k=s.charAt(j);
            if(map.containsValue(k)) {
                //如果map中的key中存在k；就将字符k压入栈
                stack.push(k);
                //否则就判断value里有没有k；如果字符串不为空，
                // 并且栈顶元素就是value对应的key值；那么就把栈顶元素pop出去
            }
            if(map.containsKey(k)){
                if((!stack.isEmpty())&&(stack.peek().equals(map.get(k)))){
                    stack.pop();
                }
            }
         }
         //遍历完，栈为空就说明
         if(!stack.isEmpty()) {
             return false;
         }else{
            return true;
         }
    }

    public static void main(String[] args) {
        Test0 test0=new Test0();
        boolean flag=test0.isValid("()[]{}");
        System.out.println(flag);
    }
}
