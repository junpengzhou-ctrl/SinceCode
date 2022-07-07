import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URLDecoder;

public class MyTest {
    public static void main(String[] args)throws Exception {
        //创建一个解析器工厂
        DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder bu = builder.newDocumentBuilder();
        //用解析器来读文件 文件名
        Document document = bu.parse("new1.xml");
       String ss =  document.getNodeName();
        System.out.println(ss);
       NodeList os =  document.getChildNodes();
        for (int i = 0; i < os.getLength(); i++) {
              Node s = os.item(i);
            System.out.println(s.getNodeName());
            NodeList sss = s.getChildNodes();
            for (int j = 0; j <sss.getLength(); j++) {
                Node is = sss.item(j);
                if (!is.getNodeName().equals("#text")) {
                    System.out.println(is.getNodeName());
                    NamedNodeMap  ssss= is.getAttributes();
                    System.out.println(ssss.getNamedItem("name"));
                    NodeList wo = is.getChildNodes();
                    for (int k = 0; k < wo.getLength(); k++) {
                        Node node = wo.item(k);
                        if (!node.getNodeName().equals("#text")) {
                            System.out.println(node.getNodeName());
                            NamedNodeMap cs = node.getAttributes();
                            System.out.println(cs.getNamedItem("name"));
                        }
                    }
                }
            }
        }




    }
}
