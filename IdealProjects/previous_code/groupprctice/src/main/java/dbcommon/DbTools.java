package dbcommon;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具类
 */
public class DbTools {
    private static BaseDAO bdao = new BaseDAO();

    /**
     * 用户的增删改
     */
    public  static  int update(String sql, Object [] params){
        return bdao.update(sql,params);
    }
    //增删改方法重载
    public  static  int update(String sql){
        return  update(sql,new Object[]{});
    }

    /**
     * 查询结果类型转换
     * @param sql 预处理语句
     * @param cls 预处理参数
     * @param <T> 对象类型信息
     * @return
     */
    public  static  <T>List<T> change (String sql,Class cls){
        return change(sql,new Object[]{},cls);
    }
    public static <T>List<T> change(String sql,Object[]params,Class cls){
        ResultSet rs = bdao.query(sql,params);
        List<T> list = new ArrayList<>();
        try {
            while (rs.next()){
                //使用类型信息new对象
                Object obj = cls.newInstance();
                //使用反射的属性填充对象属性
                Field [] fields =cls.getDeclaredFields();
                for (Field field:fields){
                    field.setAccessible(true);
                    field.set(obj,rs.getObject(field.getName()));
                }
                list.add((T)obj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
    //对付查询语句只获得唯一的值
    public  static  Object uniqueQuery(String sql){
        return uniqueQuery(sql,new Object[]{});
    }

    public  static  Object uniqueQuery(String sql,Object[] params){
       ResultSet rs = bdao.query(sql,params);
       Object res = null;
        try {
            if (rs.next()){
                res  = rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  res;
    }
}
