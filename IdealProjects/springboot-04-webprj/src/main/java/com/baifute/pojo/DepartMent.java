package com.baifute.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data                 //生成对应的方法
@AllArgsConstructor  //生成有参构造
@NoArgsConstructor   //生成无参构造
public class DepartMent {
    private Integer departmentid;
    private String departmentname;
}
