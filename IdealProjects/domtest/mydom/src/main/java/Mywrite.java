import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

//使用DOM解析XML文件
public class Mywrite {
    //收藏信息， xml 对应的Document 对象
    private Document document;

    //获得DOM树， 获得Document对象
    public  void  getDom() {
        try {
            try {
                //获得解析器工厂
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //new Instance()方法
                //根据解析器工厂获得解析器
                DocumentBuilder builder = factory.newDocumentBuilder();
                // 解析器来解析xml文件获得document对象
                document = builder.parse("new1.xml") ;        //parse 意为解析。
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        //获取手机品牌以及型号相关信息
     public void showInfo( ) {
         NodeList brands = document.getElementsByTagName("Brand");
         //遍历brands,从中拿出每一个Brand节点
         for (int i = 0; i < brands.getLength(); i++) {
             Node node = brands.item(i);
             // 将每一个node变成元素Element
             Element element = (Element) node;
             String brandName = element.getAttribute("name");  //拿属性值
             System.out.println(brandName);

             //继续查找，找每个Brand的子节点出来
             NodeList types = element.getChildNodes();
             for (int j = 0; j < types.getLength(); j++) {
                 Node typeNode = types.item(j);
                 //判断该子节点是否为元素节点
                 if (typeNode.getNodeType()==Node.ELEMENT_NODE){
                     Element typeEle = (Element)typeNode;
                     System.out.println(
                             "\t"+typeEle.getAttribute("name"));
                 }
             }
         }
     }

     //为XML文件添加元素
    public void  addEle(){
        //(1)创建<Brand>
        Element brand =document.createElement("Brand");
        brand.setAttribute("name","三星");
        //<Type name ="三星"/>
        Element type = document.createElement("Type");
        type.setAttribute("name","NOTE2");
        //将Type 作为Brand 的子元素
        brand.appendChild(type);
        //将Brand 放到PhoneInfo中去
        document.getElementsByTagName("PhoneInfo").item(0).appendChild(brand);
         saveXML("d:/");
    }

         //保存xml文件(借助转换器 )
     public  void  saveXML(String path){
        //转换器工厂
         TransformerFactory factory = TransformerFactory.newInstance();
         try {
             try {
                 //转换器
                 Transformer transformer = factory.newTransformer();
                 DOMSource source = new DOMSource(document);
                 OutputStream out =new FileOutputStream(path);
                 StreamResult result = new StreamResult(new OutputStreamWriter(out));
                 transformer.transform(source,result);
             } catch (TransformerConfigurationException e) {
                 e.printStackTrace();
             }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (TransformerException e) {
             e.printStackTrace();
         }


     }
    public static void main(String[] args) {
        Mywrite wr = new Mywrite();
        wr.getDom();;
        wr.addEle();
        wr.showInfo();

    }

}
