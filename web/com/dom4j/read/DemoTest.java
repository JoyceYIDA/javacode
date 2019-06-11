package com.dom4j.read;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) throws Exception {
        /**
         * 读取contact.xml遇到contact标签将标签封装为contact联系人对象
         *
         * 1）自定义类Contact：联系人
         * 2）目的：读取contact标签，封装到Contact   List<Contact> list遍历
         */

        Document doc=new SAXReader().read(DemoTest.class.getClassLoader().getResource("contact.xml"));
        /**
         * 将contact对象封装到list集合中
         */
        List<Contact> list=new ArrayList<>();
        /**
         * 通过文档对象读取所有同名的contact标签对象
         */
        List<Element> conList=doc.getRootElement().elements("contact");
        for(Element ele:conList){
            Contact contact=new Contact();
            contact.setId(ele.attributeValue("id"));
            contact.setName(ele.elementText("name"));
            contact.setGender(ele.elementText("gender"));
            contact.setPhone(ele.elementText("phone"));
            contact.setEmail(ele.elementText("email"));
            contact.setAddress(ele.elementText("address"));

            list.add(contact);
        }
        //遍历list集合
        for(Contact contact:list){
            System.out.println(contact);
        }
    }
}
