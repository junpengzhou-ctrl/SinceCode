package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * 读取file.txt获取文件的内容
 */
public class ReadFileInfo {
    public  StringBuffer getContext(){

        StringBuffer sb =null;
        //获取文件的路径
        try {
            sb = new StringBuffer();
            String path = URLDecoder.decode(
                    ReadFileInfo.class.getResource("/Writer.txt").getPath()
            ,"UTF-8");

            BufferedReader br = new BufferedReader(new FileReader(path));
            String tmp = "";
            while (( tmp=br.readLine())!=null){
               // ctx +=tmp;
                sb.append(" "+tmp);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }



}
