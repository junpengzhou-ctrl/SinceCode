package dbcommon;

import java.io.FileInputStream;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Dbutil {
    private  static  String DRIVER;
    private  static  String URL;
    private  static  String USERNAME;
    private  static  String PASSWORD;
    private  static Connection connection;
    private Dbutil(){}
    static {
        try {
            loadDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //读取java特殊的属性文件 填充所有的静态属性
    private  static  void loadDriver() throws  Exception{
        //加载配置文件
        //获取路径
        String path = URLDecoder.decode(Dbutil.class.getResource(
                "/driver.properties").getPath(),"UTF-8");
        System.out.println(path);
        //读取属性文件信息
        Properties pro = new Properties();
        pro.load(new FileInputStream(path));
        DRIVER = pro.getProperty("driver");
        URL= pro.getProperty("url");
        USERNAME = pro.getProperty("username");
        PASSWORD = pro.getProperty("password");
    }


public  static Connection getConnection(){
    try {
        if (connection==null){
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return connection;
   }
}
