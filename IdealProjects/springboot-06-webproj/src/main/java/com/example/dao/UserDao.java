package com.example.dao;

import com.example.pojo.queryuser.QueryUser;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper    //这个注解表示了mybatis 的一个mapper类
@Repository
public interface UserDao {
    //查询所有用户
    List<User> getuserList();


    // 用户名称模糊查询
    List<User> getuserByName(QueryUser queryUser);


    //根据用户id查询用户
    User getuserById(int userid);


    //删除一个用户
    int deleteUser(int userid);

    //增加一个用户
    int addUser(User user);


    int modeUser(User user);

    //获取数据标中所有的的用户id
    List<Integer> getAllId();
}
