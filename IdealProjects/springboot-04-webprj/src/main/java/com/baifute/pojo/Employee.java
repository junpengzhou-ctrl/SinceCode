package com.baifute.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data                 //生成对应的方法
@AllArgsConstructor  //生成有参构造
@NoArgsConstructor   //生成无参构造

public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Date birth;
    private Integer genter;

    private DepartMent department; //员工有自己所属的部门



}
