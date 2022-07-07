package com.example.service;

import com.example.pojo.User;
import com.example.pojo.queryuser.QueryUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    //查询所有用户
    List<User> getuserList();


    // 用户名称模糊查询
    PageInfo<User> getuserByName(QueryUser queryUser);


    //根据用户id查询用户
    User getuserById(int userid);


    //删除一个用户
    boolean deleteUser(int userid);

    //增加一个用户
    boolean addUser(User user);


    boolean modeUser(User user);

    List<Integer> getAllId();

}
