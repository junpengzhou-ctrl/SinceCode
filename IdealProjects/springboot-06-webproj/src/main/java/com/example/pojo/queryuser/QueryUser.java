package com.example.pojo.queryuser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryUser {
    private Integer pageNum = 1;  //起始页
    private Integer pageSize = 7; //每页显示两条
    private String name;  //输入的用户名称模糊查询

}
