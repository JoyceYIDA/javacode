//public class Day14{
//        public static void main(String[] args){
//        String str="1a2345678";
//        System.out.println(isNumber(str)?"字符串由数字组成":"字符串中有非数字成员");
//    }
//    public static boolean isNumber(String str){//一般而言如果方法返回boolean类型，往往以is。。。（）来命名
//        char[]data=str.toCharArray();
//        for(int i=0;i<data.length;i++){
//            if(data[i]<'0'||data[i]>'9'){
//                return false;
//            }
//        }
//    return true;
//    }
//}
class Person{
    private String name;
    public String getName(){
        return name;//显示继承
    }
    public void setName(String name){
        this.name=name;
    }
}
class Student extends Person{
    public void fun(){
        System.out.println(getName());
    }
}
public class Day14{
    public static void main(String[] args){
        Student student=new Student();
        student.setName("seven");
        System.out.println(student.getName());
        student.fun();
    }
}