

 class PerA{
    public PerA(){
        System.out.println("1.父类构造方法");
    }
    {
        System.out.println("2.父类非静态代码块");
    }
    static{
        System.out.println("3.父类静态代码块");
    }
}
 class PerB extends PerA{
    //构造方法
    public PerB(){
        System.out.println("4.子类构造方法");
    }
    {
        System.out.println("5.子类非静态代码块");
    }
    static{
        System.out.println("6.子类静态代码块");
    }
}
public class Day8{
    public static void main(String[] args){
        System.out.println("--------------");
        new PerB();
        new PerB();
        System.out.println("**************");
}
 }