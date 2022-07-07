import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URLDecoder;
import java.util.List;

public class MyTest2 {
    public static void main(String[] args) throws Exception {
        String  path = URLDecoder.decode(MyReader.class.getResource("/new1.xml").getPath(),"UTF-8");
        SAXReader sm = new SAXReader();
        Document ls =sm.read(new File(path));
         Element tt = ls.getRootElement();
        System.out.println(tt.getName());
        // 元素集合接受
        List <Element>list  = tt.elements();
        for (int i = 0; i < list.size(); i++) {
            //得到每个元素的属性和值
            Element  ms= list.get(i);
            System.out.println(ms.getName()+":"+ms.attribute("name").getValue());
            //获得元素的子元素
            List<Element> lsi = ms.elements();
            for (int j = 0; j < lsi.size(); j++) {
                //拿取每一个值  并输入属性和值
                Element ooi = lsi.get(j);
                System.out.println(ooi.getName()+":"+ooi.attribute("name").getValue());
            }
        }
    }
}
