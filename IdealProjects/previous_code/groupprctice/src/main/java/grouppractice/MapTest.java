package grouppractice;

import java.util.HashMap;
import java.util.Scanner;

//英文名称 <> 姓名性别
public class MapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Tom","唐姆:性别：男");
        map.put("Vivan","李伟:性别：女");
        map.put("Luna","卢那:性别：女");
        map.put("Seven","沈文:性别：男");
        map.put("Hebe","周赫:性别：男");
        map.put("Bing","陈彬:性别：男");
        map.put("Jason","吴桀:性别：男");

         map.forEach((o, o2) -> {
             System.out.println(o+"对应的姓名是"+o2);
         });

        System.out.println("请输入你要查找的学员英文名");
        Scanner scan =new Scanner(System.in);

        String stus =scan.next();
        if (map.containsKey(stus)){
            System.out.println("您找的学员找到了！");
               Object k =stus;
            System.out.println(map.get(k));

        }  else {
            System.out.println("对不起，没找到您要找的学员");
        }
       
    }
}
