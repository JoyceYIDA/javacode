package pc;
//消费者类
//    多线程，如果商品的容器为空，就等待，唤醒生产者，让它进行生产，
//商品类
//   容器实现，可以用队列FIFO
//生产者类
//   设置一个最大值，超过这个值，生产者就停止生产，等待


import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.Scanner;

public class Test {
    public static void code1(){
                final Queue<Goods> queue=new LinkedList<>();
        final Integer MAX_Goods=10;

        //生产者
        final Producer producer=new Producer(queue,MAX_Goods, 1000L);
        //消费者
        final Consumer consumer=new Consumer(queue, 2500L);
//          单线程
        Thread producerThread1=new Thread(producer,"producer-1");
        Thread consumerThread1=new Thread(consumer,"consumer-1");

        producerThread1.start();
        consumerThread1.start();
//        生产者和消费者都是单线程，并且无时间间隔
//        模拟现实，速率问题
//        多线程
        for(int i=0;i<5;i++){
            new Thread(producer,"producer-"+i).start();
        }
        for(int i=0;i<8;i++){
            new Thread(consumer,"consumer-"+i).start();
        }
    }
    public static void code2(){
//        交互式输入
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入容量大小：");
        final Integer MAX_Goods=scanner.nextInt();

        System.out.println("请输入生产者数量：");
        final Integer producers=scanner.nextInt();

        System.out.println("请输入生产者速率(ms)：");
        final Long producerSpeed=scanner.nextLong();
        System.out.println("请输入消费者者数量：");
        final Integer consumers=scanner.nextInt();

        System.out.println("请输入消费者消费速率(ms)");
        final Long consumerSpeed=scanner.nextLong();
        final Queue<Goods> queue=new LinkedList<>();
        final Producer producer=new Producer(queue,MAX_Goods,producerSpeed);
        final Consumer consumer=new Consumer(queue,consumerSpeed);
        for(int i=0;i<producers;i++){
            new Thread(producer,"producer-"+i).start();
        }
        for (int i=0;i<consumers;i++){
            new Thread(consumer,"consumer-"+"i").start();
        }
    }
    public static void main(String[] args) {

        //问题：如何动态修改参数
//        1.容量
//        2.生产者和消费者线程
//        3.生产和消费速率
//
//          解决
//          1.命令行参数args[]
//        idea指定参数-Configuration-Program arguments指定参数，多个参数用空格分隔-Apply
//          2.通过控制台接收用户键盘输入
//          3.通过外部配置文件读取
        Properties properties=new Properties();
        try(InputStream inputStream= Test.class.getClassLoader()
                .getResourceAsStream("produce_consumer_init.properties")){
            properties.load(inputStream);

        }catch(IOException e){

        }
        final Integer MAX_Goods=Integer.parseInt(properties.getProperty("collection.max_capacity"));
        final Integer producers=Integer.parseInt(properties.getProperty("producer.number"));
        final Integer consumers=Integer.parseInt(properties.getProperty("consumer.number"));
        final long consumerSpeed=Long.parseLong(properties.getProperty("consumer.speed"));
        final long producerSpeed=Long.parseLong(properties.getProperty("producer.speed"));
        final Queue<Goods> queue=new LinkedList<>();
        final Producer producer=new Producer(queue,MAX_Goods,producerSpeed);
        final Consumer consumer=new Consumer(queue,consumerSpeed);
        for(int i=0;i<producers;i++){
            new Thread(producer,"producer-"+i).start();
        }
        for (int i=0;i<consumers;i++){
            new Thread(consumer,"consumer-"+"i").start();
        }
    }
}
