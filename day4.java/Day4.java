//使用构造方法设置对象属性
class Person{
    private String name;
    private int age;

     public Person(String n,int i){
         name=n;
         setAge(i);//小驼峰
     } 
     public void setName(String n){
         name=n;
     }
     public String getName(){
         return name;
     }
     public void setAge(int i){
        if(i>0&&i<200){//判断年龄的合法性 年龄不可能为负，一个人的年龄应该不会大于200
        age=i;
        }
        else{
            age=0;
        }
    }
    public int getAge(){
        return age;
    }
    public void getPersonInfo(){
        System.out.println("姓名："+name+",年龄："+age);
    }
}
public class Day4{
    public static void main(String[] args){
        Person person=new Person("张三",-100);
        person.getPersonInfo();
    }//构造方法的调用和对象内存分配几乎是同步完成的，所以可以用构造方法来为类中的属性进行初始化操作
}