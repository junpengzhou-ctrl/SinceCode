package chileme;

import chileme.Users;

import java.util.Scanner;

public class CommerceUsers implements Users {
    //商家用户类
    //注册功能
    Scanner scan = new Scanner(System.in);
    public void logon() {
        System.out.println("请设置用户名");
        String Usename = scan.next();
        System.out.println("请设置密码");
        String Usepassword = scan.next();

    }

    //登陆功能
    public void login() {
        System.out.println("登陆成功");

    }
}
