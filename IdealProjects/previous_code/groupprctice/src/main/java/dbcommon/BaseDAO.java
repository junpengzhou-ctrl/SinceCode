package dbcommon;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {
    private Connection coon;
    private PreparedStatement pstat;
    private ResultSet rs;

    public  BaseDAO(){
        coon = Dbutil.getConnection();
    }
    public  int update(String sql, Object[] params){
        int count = 0;
        try {
            pstat = coon.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstat.setObject(i+1,params[i]);
            }
            count = pstat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  count;
    }


    public  ResultSet query(String sql, Object[] params){
          rs = null;
        try {
            pstat = coon.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstat.setObject(i+1,params[i]);
            }
            rs = pstat.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rs;
    }


}
