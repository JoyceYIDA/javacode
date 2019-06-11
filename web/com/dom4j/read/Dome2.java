package com.dom4j.read;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Dome2 {
    public static void main(String[] args) throws DocumentException {
        /**
         * 通过dom4j工具获取标签对象
         * 1）创建解析器对象
         * 2）读取文件 xml的document
         * 3）获取根标签对象
         */
        SAXReader reader=new SAXReader();
        Document doc=reader.read(Dome2.class.getClassLoader().getResource("contact.xml"));
        Element root=doc.getRootElement();
        /**
         * 获取标签的名称：通过节点的getName
         */
        System.out.println(root.getName());
        /**
         * 获取子标签:默认获取第一个子标签
         */
        Element con=root.element("contact");
        System.out.println(con);
        /**
         * 获取所有同名的子节点列表
         */
        List<Element> list=root.elements("contact");
        /**
         * 集合遍历：
         *    for-each
         *    for
         *    迭代器
         */
        for(Element element:list){
            System.out.println(element);
        }
        /**
         * 获取根节点下的孙节点标签：链式编程
         */
        Element element=root.element("contact").element("name");
        System.out.println(element);
    }
}
