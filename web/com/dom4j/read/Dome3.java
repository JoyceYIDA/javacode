package com.dom4j.read;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用dom4j获取属性对象
 * 获取属性的亲提，获取属性的前提，获取属性对应的标签对象
 */
public class Dome3 {
    /**
     * 1)获取document对象
     */
    public static void main(String[] args) throws DocumentException {

        Document doc = new SAXReader().read(Dome3.class.getClassLoader().getResource("contact.xml"));
        /**
         * 需求id=“001”属性值
         * 获取contact标签对象
         * 方式一：通过属性名称获取属性值
         */
        Element con=doc.getRootElement().element("contact");
        String value=con.attributeValue("id");
        System.out.println("id="+value);
        /**
         * 方式二：通过属性对象来获取属性名称和属性值
         * getName()/getValue()
         */
        Attribute attr=con.attribute("id");
        String idname=attr.getName();
        String idValue=attr.getValue();
        System.out.println(idname+" "+idValue);

        /**
         * 通过dom4j来获取文本内容
         *    包含换行和空格（可以解析出来）
         *    获取文本内容前提是获取文本内容对应的标签对象
         */
        Element name=doc.getRootElement().element("contact").element("name");
        /**
         * 方式一：通过标签对象.getText()
         */
        String text=name.getText();
        System.out.println(text);
        /**
         * 方式二：通过父标签对象的elementText（“子节点名称”）：获取子节点文本内容。
         * 推荐使用方式二
         */
        String name1=con.elementText("name");
        System.out.println(name1);
        String gender=con.elementText("gender");
        System.out.println(gender);
    }

}
