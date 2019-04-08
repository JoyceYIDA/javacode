package Day.ioStream;

import java.io.*;

class PrintUtil{
//    由外部传入要输入的目标终端
    private OutputStream out;
//    构造方法
    public PrintUtil(OutputStream out){
        this.out=out;
    }
    public void print(String str) throws IOException {
        this.out.write(str.getBytes());
    }
    public void println(String str) throws IOException {
        this.print(str+"    ");
    }
    public void print(int data) throws IOException {
        this.println(String.valueOf(data));
    }
    public void println(int data) throws IOException {
        this.println(String.valueOf(data));
    }
    public void print(double db) throws IOException {
        this.println(String.valueOf(db));
    }
    public void println(double db) throws IOException {
        this.println(String.valueOf(db));
    }
}

public class TestPrint {
//    public static void main(String[] args) throws IOException {
////        实例化对象
////        PrintUtil print=new PrintUtil(new FileOutputStream
////                (new File("F:"+File.separator+"笔记"+File.separator+"666.txt")));
////        使用打印流
//        PrintWriter pr= new PrintWriter(new FileOutputStream
//                (new File("F:"+File.separator+"笔记"+File.separator+"666.txt")));
//        pr.print("姓名:");
//        pr.print("Jackson");
//        pr.print("年龄");
//        pr.print(25);
//        pr.print("身高");
//        pr.print(174.80000000);
//        pr.close();
//    }
//    public static void main(String[] args) {
////        格式化字符串
//        String name="Jackson";
//        int age=26;
//        double height=174.800000;
//        String str=String.format("姓名:%s,年龄%d,工资%f",name,age,height);
//        System.out.println(str);
//    }
//    public static void main(String[] args) throws IOException {
//         OutputStream out=System.out;
//         out.write("12345,上山打老虎".getBytes());
//    }

//    public static void main(String[] args) throws IOException {
//        InputStream in=System.in;
////        创建一个有限长度字节数组存储数据
//        byte[] data=new byte[1024*1024];
//        System.out.println("请输入");
//        int temp=in.read(data);
//        System.out.println("输入的内容为"+new String(data,0,temp));
//    }
//    引入内存操作
    public static void main(String[] args) throws IOException {
         InputStream in=System.in;
         ByteArrayOutputStream bo=new ByteArrayOutputStream();
         byte[] data=new byte[1024];
        System.out.println("请输入");
        int value=-1;
        while((value=in.read(data))!=-1){
            bo.write(data,0,value);
            if(value<data.length){
                break;
            }
        }
        in.close();
        bo.close();
        System.out.println("输入的内容为"+new String(bo.toByteArray()));
    }
}

