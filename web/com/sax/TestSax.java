package com.sax;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * SAXParser是一个抽象类继承Object
 * 工厂模式
 * SAX解析xml文件（重点：事件处理方式）
 *   1）需要解析器对象：SAXParser
 *   2）解析xml文件
 *   3）绑定事件
 */
public class TestSax {
    public static void main(String[] args) throws Exception {
        SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
        //解析xml文件
//        parser.parse(TestSax.class.getClassLoader().getResourceAsStream("contact.xml"),new MyDefaultHandler1());
        /**
         * 时间三要素
         *   1）事件源：解析resource下的contact.xml
         *   2）事件监听器：编写一个事件处理程序DefaultHandler
         *         自定义一个类继承自DefaultHandler，重写方法
         *         遇到开始标签触发一个方法，遇到文本内容触发一个方法
         *   3）
         */
    }
}
