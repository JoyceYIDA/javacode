package com.dom4j.write;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * document对象输出到硬盘上，目的修改、删除属性或标签
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        //删除节点（标签对象）
        //标签对象.detach()自杀
        //获取所有同名的contact标签对象

        Document doc=new SAXReader().read(Demo2.class.getClassLoader().getResource("contact.xml"));

        List<Element> list=doc.getRootElement().elements("contact");
        if(list!=null){
            for(Element element:list){
                if(element.attribute("id").getValue().equals("001")){
                    element.detach();
                    break;
                }
            }
        }

        OutputStream out=new FileOutputStream("e:/contact.xml");
        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter writer=new XMLWriter(out,format);
        writer.write(doc);
        writer.close();

    }
    private static void add() throws Exception{
        /**
         * 添加文档
         * 1）创建一个空文档
         *
         * 2）创建节点
         */
        Document doc=DocumentHelper.createDocument();
        Element eleCon=doc.addElement("contact-list");
        Element ele=doc.addElement("contact");
        ele.addAttribute("id","001");
        ele.addAttribute("name","张三");

    }
    private static void editor()throws Exception{
        /**
         * 修改：修改标签的属性或者文本内容
         * 先读文件
         */
        Document doc=new SAXReader().read(Demo2.class.getClassLoader().getResource("contact.xml"));

        //修改标签的属性
        Element element=doc.getRootElement().element("contact");
        Attribute attribute=element.attribute("id");
        attribute.setValue("003");

        Element gen=element.element("gender");
        gen.setText("nv");

        OutputStream out=new FileOutputStream("e:/contact.xml");
        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter writer=new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }
}
