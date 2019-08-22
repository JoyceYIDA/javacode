package TimeFrame;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * @author yida
 */
public class Test{
    private JFrame jf;
    private JLabel label1;
    private JLabel label2;
    //构造
    public Test(){
        //创建窗体并定义标题
        jf=new JFrame("倒计时");
        //label1上提示倒计时内容
        label1=new JLabel("距离高考还有：");
        label2=new JLabel("");//显示剩余的时间
        jf.add(label1,BorderLayout.NORTH);//添加label1到窗体上方
        jf.add(label2,BorderLayout.CENTER);//添加label2到窗体中间
        //创建RefreshTimeThread
        Thread t=new RefreshTimeThread(new GregorianCalendar(2019,Calendar.OCTOBER,
                1,0,0,0));
        t.start();

    }
    public void show(){
        jf.setBounds(200,200,300,150);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Test().show();
    }

    /**
     * 内部类
     */
    class RefreshTimeThread extends Thread {
        private Calendar targetTime;
        private Test test;
        public RefreshTimeThread(Calendar targetTime) {
            this.targetTime=targetTime;
        }
        @Override
        public void run(){
            while (true){
                //创建GregorianCalendar对象，也就是当前时间
                Calendar todayTime=new GregorianCalendar();
                //定义long类型的seconds，表示剩余的秒数
                long seconds=(targetTime.getTimeInMillis()-todayTime.getTimeInMillis())/1000;
                if(seconds<=0){
                    //时间小于0就说明时间已经到了
                    label2.setText("时间到了！");
                    break;
                }
                int day=(int)(seconds/(24*60*60));
                int hour=(int)(seconds/(60*60)%24);
                int min=(int)(seconds/60%60);
                int sec=(int)(seconds%60);
                String str=day+"天"+hour+"小时"+min+"分钟"+sec+"秒";
                label2.setText(str);//刷新时间
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
