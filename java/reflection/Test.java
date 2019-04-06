package Day.reflection;

//        1.使用反射重构之前的简单工厂模式
interface IFruit{
    void eat();
}
class Apple implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat an apple");
    }
}
class Orange implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat an orange");
    }
}
class Factory{
    private Factory(){
    }
    public static IFruit getInstance(String fruitName) {
        IFruit fruit=null;
        try {
            fruit=  (IFruit) Class.forName(fruitName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}

public class Test {
    public static void main(String[] args){
        IFruit f=Factory.getInstance("Day.reflection.Orange");
        f.eat();
    }
}
