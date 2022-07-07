package com.ruanjiandadao;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.lang.model.util.Elements;
import java.io.File;
import java.util.List;

public class DomTest {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();   //xml文档对象解析器
        Document read = saxReader.read(new File("basic\\XML\\dom.xml"));
        Element rootElement = read.getRootElement();
        List<Element> studentsElements = rootElement.elements("student");
        for (Element stu:studentsElements){
            Attribute id = stu.attribute("id");
            System.out.println(id.getValue());

            Element nameE = stu.element("name");
            String name = nameE.getText();
            System.out.println(name);

            Element ageE = stu.element("age");
            String age = ageE.getText();
            System.out.println(age);

        }


    }
}
