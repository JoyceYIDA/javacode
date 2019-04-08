package Day.ioStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

//  使用内存流将输入的字符串转换成大写

public class TeatMemory {
    public static void main(String[] args) throws IOException {
        String str="hello world";
//        实例化对象
        ByteArrayInputStream in=new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream out= new ByteArrayOutputStream();
        int len=-1;
        while((len=in.read())!=-1){
            out.write(Character.toUpperCase(len));
        }
        System.out.println(out);
        in.close();
        out.close();
//        发生了IO操作，但是没有文件产生
    }
}
