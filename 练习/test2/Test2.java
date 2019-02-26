
//代理模式：两个子类共同实现一个接口，其中一个子类负责真实业务实现，另一个子类安成辅助操作。

//定义行为
interface  IBuy{
    void buyBuyBuy();
}
//真实主题类
class RealSubject implements IBuy{
    @Override
    public void buyBuyBuy() {
        System.out.println("买一件商品");
    }
}
//代理类
class ProxySubject implements  IBuy{
    //传入真实主题类，也就是真实操作由真实主题类完成，比如买东西代购，付钱的人是买家
    private IBuy buyer;//传入接口对象，而不是真实主题类对象；代理不能只对一个客户服务，传入接口就方便实现
    public ProxySubject(IBuy buyer){
        this.buyer=buyer;
    }


    public void beforeBuy(){
        System.out.println("排队");
    }

    public void buyBuyBuy() {
        this.beforeBuy();
        //真实主题类完成真实操作
        this.buyer.buyBuyBuy();
        this.afterBuy();
    }

    public void afterBuy(){
        System.out.println("发快递");
    }
}

public class Test2 {
    public static void main(String[] args) {
        IBuy buyer=new ProxySubject(new RealSubject());//客户端中new的是一个代理类，如果new的是真实主题类就只有买家的操作，代理类也覆写了真实操作
        buyer.buyBuyBuy();
    }
}
