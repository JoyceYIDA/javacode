package com.sax;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler1 extends DefaultHandler {

    /**
     * 文档开始方法
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("MyDefaultHandler1.startDocument,文档开始了");
    }

    /**
     * 遇到开始标签触发
     * @param s
     * @param s1
     * @param s2
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        System.out.println("MyDefaultHandler1.startElement,开始标签");
    }

    /**
     * 文本内容
     * @param chars
     * @param i
     * @param i1
     * @throws SAXException
     */
    @Override
    public void characters(char[] chars, int i, int i1) {
        String content=new String(chars,i,i1);
    }

    /**
     * 结束标签
     * @param s
     * @param s1
     * @param s2
     * @throws SAXException
     */
    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        System.out.println("MyDefaultHandler1.startElement,结束标签");
    }
}
