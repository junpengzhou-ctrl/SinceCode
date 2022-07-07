package com.mozhoudonglu;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateMethod {
    public static void main(String[] args) {
        /*
        打印时间
         */
        Date date = new Date();
        System.out.println(date);

        /*
        日期转字符串
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dat = simpleDateFormat.format(date);
        System.out.println(dat);

           /*
    字符串转日期
     */
        String dt = "2020-12-17 20:30:04";    //下面有时分秒上面一定要带上时分秒
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(simpleDateFormat1.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }

      /*
      输出本月最后一天
       */
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);


    }


}
