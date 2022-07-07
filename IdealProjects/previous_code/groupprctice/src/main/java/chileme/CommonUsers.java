package chileme;

import chileme.Users;

import java.util.Scanner;

public class CommonUsers implements Users {
    //普通用户类
    //注册功能
    Scanner scan = new Scanner(System.in);
    public void logon() {
        System.out.println("请设置用户名");
        String Usename = scan.next();
        System.out.println("请设置密码");
        String Usepassword = scan.next();
        System.out.println("请设置送货地址");
        String Useaddress= scan.next();
        System.out.println("请设置电话号码");
        String Usetelephone = scan.next();
    }

    //登陆功能
    public void login() {
        System.out.println("登陆成功");

    }
}
