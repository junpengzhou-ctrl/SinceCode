package chileme;

import java.util.Scanner;

public class Eat {
    public static void main(String[] args) {
        //定义一个变量记录表里有几行数据
        int userno=1;
        int orderno=0;
        //定义三张表
        String[][]users=new String[10][6];
        String[][]foods=new String[3][5];
        String[][]orders=new String[100][7];
        //为表添加数据
        users[0][0]="1";users[0][1]="admin";users[0][2]="13000000001";
        users[0][3]="小行路16号";users[0][4]="123";users[0][5]="admin";
        foods[0][0]="1";foods[0][1]="馄饨";foods[0][2]="5";foods[0][3]="10";
        foods[1][0]="2";foods[1][1]="水饺";foods[1][2]="54";foods[1][3]="100";
        foods[2][0]="3";foods[2][1]="小笼包";foods[2][2]="10";foods[2][3]="1000";
        Scanner scan=new Scanner(System.in);
                //构造键盘扫描类
        //由于系统一直在使用除非用户选择退出
        for (;;){
            //是否继续登录开关变量
            boolean loginFlag=true;
            //记录用户登录的编号
            String currentUser="";
            //登录注册用户如果用户不能登录成功就一直登录
            do {
            //询问用户是否登录还是注册
            System.out.println("登录还是注册（登录输入1、注册输入2）");
            int regorlogin=scan.nextInt();
            //判断用户是选择的功能
            if (regorlogin==1){
                System.out.println("请输入您的用户名");
                String username=scan.next();
                System.out.println("请输入您的密码");
                String password=scan.next();
                //循环到表里面判断用户是否存在不存在就继续登
                for (int row=0;row< userno;row++){
                    if (users[row][1].equals(username)&&users[row][4].equals(password)){
                        loginFlag=false;
                        currentUser=users[row][0];//把用户编号存放当前用户变量中
                        break;
                    }
                }
                if (loginFlag){
                    System.out.println("您的用户名和密码错误，请重新输入");
                }
            }else{
                //注册新用户
                System.out.println("请输入用户名");
                users[userno][0]=userno+1+"";
                users[userno][1]=scan.next();
                System.out.println("请输入您的电话");
                users[userno][2]=scan.next();
                System.out.println("请输入您的送货地址");
                users[userno][3]=scan.next();
                System.out.println("请输入您的验证密码");
                users[userno][4]=scan.next();
                users[userno++][5]="normal";//为用户添加普通身份
            }
            }while(loginFlag);
            //根据用户的编号就可以查询到用户的其他信息
            //根据编号查询用户身份
            //由于编号使我们自己生成的，编号从1开始不断递增  所以根据用户编号就可以判断用户在表中是第几行
            //获取行数
            int row=Integer.parseInt(currentUser)-1;
            //根据用户的身份做事情 由于用户会不停的做很多事所以需要不断循环，除非用户提出我要退出
            do{
                if (users[row][5].equals("admin")){
                    //管理员身份
                    //打印管理员的功能菜单
                    System.out.println("管理员："+users[row][1]+",欢迎登陆");
                    System.out.println("请选择如下功能：");
                    System.out.println("1.查看送货订单");
                    System.out.println("2.退出系统");
                    int adminOpt=scan.nextInt();
                    if (adminOpt==1){
                        //把所有未送货的订单列出来
                        System.out.println("订单编号\t\t收货人姓名\t\t收货人地址\t\t收货人电话\t\t菜品名称\t\t菜品数量\t\t菜品单价\t\t总计金额");
                        //选择你要修改的订单
                        for (int rw=0;rw<orderno;rw++){
                            //只有未送货的订单才可以打印
                            if (orders[rw][5].equals("未送货")){
                                //找到收活人在users表的位置
                                int receivepos=Integer.parseInt(orders[rw][1])-1;
                                //找到对应菜品在foods表的位置
                                int foodpos=Integer.parseInt(orders[rw][2])-1;
                                //计算总价格
                                int price=Integer.parseInt(orders[rw][3])
                                        *Integer.parseInt(foods[foodpos][2]);
                                price=price>=50?price:price+6;
                                System.out.println(orders[rw][0]+"\t\t"+users[receivepos][1]+"\t\t"
                                        +users[receivepos][3]+"\t\t"+users[receivepos][2]+"\t\t"
                                        +foods[foodpos][1]+"\t\t"+orders[rw][3]
                                        +"\t\t"+foods[foodpos][2]+"\t\t"+price);

                            }
                        }
                        //选择你要修改的订单
                        System.out.println("请选择要送货的订单编号");
                        int odno=scan.nextInt();
                        orders[odno][5]="送货中";

                    }else{
                        //管理员用户选择了退出
                        System.out.println("bye");
                        break;
                    }
                }else{
                    //普通用户
                    //打印用户菜单
                    System.out.println("尊敬的"+users[row][1]+",请选择你的功能");
                    System.out.println("1.选择订单");
                    System.out.println("2.选择签单");
                    System.out.println("3.退出系统");
                    int customOpt=scan.nextInt();
                    if (customOpt==1){
                        //订餐
                        //列菜单
                        System.out.println("菜单编号\t\t菜单名称\t\t菜单单价\t\t点赞数");
                        for (int mu=0;mu<foods.length;mu++){
                            System.out.println(foods[mu][0]+"\t\t"+foods[mu][1]+"\t\t"
                                                +foods[mu][2]+"\t\t"+foods[mu][3]);
                        }
                        //用户选择菜品下单
                        System.out.println("请选择你的菜品");
                        String fdno=scan.next();
                        System.out.println("您希望购买几份");
                        String fdnum=scan.next();
                        System.out.println("请输入送货时间");
                        String time=scan.next();
                        //下单
                        orders[orderno][0]=orderno+1+"";
                        orders[orderno][1]=(row+1)+"";
                        orders[orderno][2]=fdno;
                        orders[orderno][3]=fdnum;
                        orders[orderno][4]=time;
                        orders[orderno++][5]="未送货";

                    }else if (customOpt==2){
                        //选择签单
                        //把所有未送货的订单列出来
                        System.out.println("订单编号\t\t收货人姓名\t\t收货人地址\t\t收货人电话\t\t菜品名称\t\t菜品数量\t\t菜品单价\t\t总计金额");
                        //选择你要修改的订单
                        for (int rw=0;rw<orderno;rw++){
                            //只有未送货的订单才可以打印
                            if (orders[rw][1].equals(row+1+"")&&!orders[row][5].equals("已签单")){
                                //找到收活人在users表的位置
                                int receivepos=Integer.parseInt(orders[rw][1])-1;
                                //找到对应菜品在foods表的位置
                                int foodpos=Integer.parseInt(orders[rw][2])-1;
                                //计算总价格
                                int price=Integer.parseInt(orders[rw][3])
                                        *Integer.parseInt(foods[foodpos][2]);
                                price=price>=50?price:price+6;
                                System.out.println(orders[rw][0]+"\t\t"+users[receivepos][1]+"\t\t"
                                        +users[receivepos][3]+"\t\t"+users[receivepos][2]+"\t\t"
                                        +foods[foodpos][1]+"\t\t"+orders[rw][3]
                                        +"\t\t"+foods[foodpos][2]+"\t\t"+price);
                            }
                        }
                        //用户选择订单号并签单
                        System.out.println("请选择要签单的订单号：");
                        int odno=scan.nextInt();
                        orders[odno-1][5]="已签单";
                        System.out.println("谢谢您的惠顾");
                    }else{
                        //退出系统
                        break;
                    }
                }
            }while(true);
        }
    }
}
