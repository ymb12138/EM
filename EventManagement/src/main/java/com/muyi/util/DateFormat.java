package com.muyi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2020/10/21 0021.
 */
public class DateFormat {

    //date类型转string类型
    public static String DateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }
    //string类型转date类型
    public static Date StringToDate(String date) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.parse(date);
    }
}
