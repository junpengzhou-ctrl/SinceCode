import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URLDecoder;
import java.util.List;

public class MyReader {
    public static void main(String[] args)throws  Exception {
        //找文件的位置
        //URLDecoder.decode 为了防止找文件的路径中有中文
        String path = URLDecoder.decode(
                MyReader.class.getResource("/new1.xml").getPath()
                ,"UTF-8");

        SAXReader read =new SAXReader();
        Document dom = read.read(new File(path));
        Element root = dom.getRootElement();
        System.out.println(root.getName());
        List<Element>cms =  root.elements();
        for (int i = 0; i < cms.size() ; i++) {
            Element cm = cms.get(i);
            //获取元素的属性
            System.out.println(cms.get(i).getName()+":"+cm.attribute("students"));
           //获取元素的子元素
           List<Element> sg  = cm.elements();
           for (Element s:sg){
               //获取sg标签中的内容
               System.out.println(s.getTextTrim());
           }
        }


//        Document dom =DocumentHelper.parseText(path);
//        Element roots = dom.getRootElement();
//        System.out.println(root.getName());
//        System.out.println(path);

//        DocumentBuilderFactory  factory =DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document dom = builder.parse(path);
//        System.out.println(dom.getNodeName());// 节点名
//
//        Element is = dom.getElementById("ff");
//        System.out.println(is.getNodeTypeName());
//
        //按照标签名直接搜索所有的匹配标签
//        NodeList ss = dom.getElementsByTagName("new1");
//        for (int i = 0 ; i < ss.getLength(); i++) {
//            System.out.println(ss.item(i));
//        }
////
//        NodeList list =  dom.getChildNodes();
//        for (int i = 0; i < list.getLength(); i++) {
//            Node node = list.item(i);
//            System.out.println(node.getNodeName());
//            NodeList son = node.getChildNodes();
//            for(int j = 0;j<son.getLength();j++){
//                Node nd = son.item(j);
//                System.out.println(nd.getNodeName());
//                if (!nd.getNodeName().equals("#text")){
//                    System.out.println(nd.getNodeName());
//                    //获取标签的属性
//                    NamedNodeMap attrs= nd.getAttributes();
//                    System.out.println(attrs.getNamedItem("xh"));
////
//                    NodeList sgs = nd.getChildNodes();
//                    for (int k =0;k<sgs.getLength();k++){
//                         Node sg = sgs.item(k);
//                         if (!sg.getNodeName().equals("#text")){
//                             System.out.println(sg.getTextContent());
//                         }
//                    }
//                }
//            }
//        }
    }
}
