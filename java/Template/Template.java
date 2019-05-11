package SingleThread;


//模板设计模式：
//        在编写代码时，要经常检查代码是否有问题，开闭原则是我们最常见最基本的原则。
//        开闭原则（OCP)：一个软件实体；比如类、模块、函数等，应该对扩展开放，对修改关闭。
//        设计模式的关键在于第三方的解耦操作；接触设计模式，首先找到第三方；模板设计模式的第三方就是模板类。
//        模板方法定义了一个算法的步骤，并允许子类为一个或者多个步骤提供具体实现。在方法中定义一个骨架，而将一些步骤延迟在子类中实现；可以使子类再不改变算法的前提下重新定义算法中的某些步骤。

import java.util.Scanner;

abstract class CaffeineBeverage{

    final void makingBeverage(){
        //核心流程；用fianl定义；防止被修改；强调封装性
        boilWater();
        brew();
        pourCup();
        if(customerDemand()==true) {
            addSth();
        }
    }
    final void boilWater(){
        System.out.println("将水烧开--------");
    }
    final void pourCup(){
        System.out.println("将饮料倒进杯子---------");
    }
    //提供给子类让其覆写；具体子类的具体步骤不一样
    abstract void brew();
    abstract void addSth();
    //钩子方法
    boolean customerDemand(){
        return true;
    }

}
class Coffer extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("冲泡咖啡");
    }

    @Override
    void addSth() {
        System.out.println("加奶或加糖");
    }
    //覆写钩子方法；强调了代码的扩展性
    boolean customerDemand(){

        String str=customerInit();
        if(str.equals("y")){
            return true;
        }else{
            return false;
        }
    }
    private String customerInit(){
        System.out.println("请问您需要加糖或奶吗？y/n");
        String str=null;
        Scanner scanner=new Scanner(System.in);
        str=scanner.nextLine();
        return str;
    }
}
class Tea extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("浸泡茶叶");
    }

    @Override
    void addSth() {
        System.out.println("加柠檬");
    }
}
public class Template {

    public static void main(String[] args) {
        //抽象类不能直接实例化对象；需要通过子类来实现
        CaffeineBeverage coffer=new Coffer();
        coffer.makingBeverage();
        System.out.println("------------------------------------------");
        CaffeineBeverage tea=new Tea();
        tea.makingBeverage();
    }
}

