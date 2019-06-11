package com.dom4j.write;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Dome1 {
    public static void main(String[] args) throws Exception {
        /**
         * 将document从内存输出到硬盘上并且携带指定的文件
         * 1)读contact.xml
         */
        Document doc=new SAXReader().read(Dome1.class.getClassLoader().getResource("contact.xml"));
        //使用XMLWrite对象
        /**
         * 创建一个OutPutStream
         *
         * 输出的细节：OutPutFormat对象：指定xml文件输出格式
         *
         */
        OutputStream out=new FileOutputStream("E:contact.xml");
        OutputFormat format=OutputFormat.createCompactFormat();//紧凑格式：部署上线：xml文件都会在一行，节省xml空间
        //设置输出的编码：
        format.setEncoding("utf-8");
        XMLWriter writer=new XMLWriter(out);
        writer.write(doc);
        writer.close();
    }
}
