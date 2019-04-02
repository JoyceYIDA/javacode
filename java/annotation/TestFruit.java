package Day.annotation;

@FruitTarget
class FruitFactory{

    public static IFruit getFruitObject(){
//        1.通过if switch参数判断
//        2.通过class
//        3.通过自定义的方法，将参数配置到注解中
        FruitTarget ft=FruitFactory.class.getAnnotation(FruitTarget.class);
        Class cls=null;
        try {
            cls=Class.forName(ft.name());
            return (IFruit)cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
public class TestFruit {
    public static void main(String[] args) {

        IFruit f=FruitFactory.getFruitObject();
        if(f!=null){
            f.eat();
        }
    }
}
