package wuhobin.service;

import com.github.pagehelper.PageInfo;
import wuhobin.pojo.User;
import wuhobin.pojo.query.UserQuery;

import java.util.List;

public interface UserService {
    // 查询所有用户
    public List<User> listUser();


    // 根据用户名来查询用户  并分页展示
    public PageInfo<User> listUserByName(UserQuery userQuery);

    //根据id删除用户
    public boolean deleteUserById(Integer id);

    // 根据id查询用户
    public User queryUserById(Integer id);

    // 修改用户
    public boolean updateUser(User user);

    // 新增用户
    public boolean addUser(User user);

}
