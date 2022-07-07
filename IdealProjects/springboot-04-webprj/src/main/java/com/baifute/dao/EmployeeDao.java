package com.baifute.dao;

import com.baifute.pojo.DepartMent;
import com.baifute.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    private DepartMentDao departMentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1,new Employee(1,"小张","888888@qq.com",new Date(),0
                             ,new DepartMent(1,"后勤部")));
        employees.put(2,new Employee(2,"小王","777777@qq.com",new Date(),1
                ,new DepartMent(2,"教学部")));
        employees.put(3,new Employee(3,"小蔡","666666@qq.com",new Date(),0
                ,new DepartMent(3,"市场部")));
        employees.put(4,new Employee(4,"小周","555555@qq.com",new Date(),1
                ,new DepartMent(4,"运营部")));
        employees.put(5,new Employee(5,"小陆","444444@qq.com",new Date(),0
                ,new DepartMent(5,"研发部")));
    }

    //查询所有员工
    public Collection<Employee> getAllEmployees(){
        return employees.values();
    }
    //根据ID查询员工
    public Employee getEmployeeId(Integer employeeid){
        return employees.get(employeeid);
    }
    //增加一个员工
    public Integer initid = 6;
    public void addEmployee(Employee employee){
        if (employee.getId() == null){
            employee.setId(initid++);
        }
        //根据员工的部门id 找部门  部门关联外键
        employee.setDepartment(departMentDao.getDepartmentById(employee.getDepartment().getDepartmentid()));
        employee.setBirth(new Date());
        employees.put(employee.getId(),employee);


    }

    //删除一个员工
    public void deleteEmployee(Integer id){
        employees.remove(id);
    }



}
