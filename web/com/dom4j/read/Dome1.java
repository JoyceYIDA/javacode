package com.dom4j.read;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j解析xml的基本使用
 * 1）创建dom4j的解析器对象
 * 2）读取xx.xml文件（url）路径：相对路径（classLader：类加载器读取文件）；绝对路径
 * 3）将文档输出
 *双击mavenProject中的package，将xml文件打包
 * targrt--classes反射得到的class文件
 *
 *
 */
public class Dome1 {
    public static void main(String[] args) throws DocumentException {
        /**1）创建dom4j解析器对象
         *   SAXReader是解析器
         */
        SAXReader reader=new SAXReader();
        /**
         * 2）读取配置文件
         *    获取class对象的方式
         *    1）Object.getClass()
         *    2)数据类型.calss属性
         *    3）Class.forName("全路径名称");[推荐方式]
         */
        Document doc=reader.read(Dome1.class.getClassLoader().getResource("contact.xml"));
        System.out.println(doc);
//        org.dom4j.tree.DefaultDocument@6d03e736 [Document: name file:/E:/Java%20Project/czy_develop/target/classes/contact.xml]
    }
}
