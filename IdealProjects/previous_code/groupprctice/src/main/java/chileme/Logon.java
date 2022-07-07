package chileme;

import java.util.Scanner;

public class Logon implements Users {

    Scanner scan= new Scanner(System.in);
    public void logon() {
        System.out.println("快速注册");
        System.out.println("注册普通用户选择1 ；注册商家用户选择2");
    }

    public void login( ){ }
//用户类型选择方法
    public  int  UseType(int Type){
        if (Type==1){
            System.out.println("请设置用户名");
            String Usename = scan.next();
            System.out.println("请设置密码");
            String Usepassword = scan.next();
            return  1;
        }else if (Type==2){
            System.out.println("请设置用户名");
            String Usename1 = scan.next();
            System.out.println("请设置密码");
            String Usepassword1 = scan.next();
            return 2;
        }else return  0;
    }
}
