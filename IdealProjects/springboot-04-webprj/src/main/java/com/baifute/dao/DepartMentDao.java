package com.baifute.dao;

import com.baifute.pojo.DepartMent;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartMentDao {
    //初始化数据 模拟数据库的数据
    private static Map<Integer, DepartMent> departments = null;
    static {
        departments = new HashMap<Integer, DepartMent>();
        departments.put(1,new DepartMent(1,"后勤部"));
        departments.put(2,new DepartMent(2,"教学部"));
        departments.put(3,new DepartMent(3,"市场部"));
        departments.put(4,new DepartMent(4,"运营部"));
        departments.put(5,new DepartMent(5,"研发部"));
    }
    //获得所有部门
    public Collection<DepartMent> getAllDepartMent(){
        return departments.values();
    }

    //通过ID获得部门
    public DepartMent getDepartmentById(Integer departmentid){
        return departments.get(departmentid);
    }


}
