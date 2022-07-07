package com.example.service;

import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.pojo.queryuser.QueryUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getuserList() {
        return userDao.getuserList();
    }

    @Override
    public PageInfo<User> getuserByName(QueryUser queryUser) {
        PageHelper.startPage(queryUser.getPageNum(),queryUser.getPageSize());
        PageInfo<User> userPageInfo = new PageInfo<User>(userDao.getuserByName(queryUser));
        return userPageInfo;
    }

    @Override
    public User getuserById(int userid) {
        return userDao.getuserById(userid);
    }

    @Override
    public boolean deleteUser(int userid) {
        int i = userDao.deleteUser(userid);
        if (i>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean addUser(User user) {
        int i = userDao.addUser(user);
        if (i>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean modeUser(User user) {
        int i = userDao.modeUser(user);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Integer> getAllId() {
        return userDao.getAllId();
    }
}
