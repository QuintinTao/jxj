package com.tencent.wxcloudrun.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal= Calendar.getInstance();
        cal.set(Calendar.YEAR, 2006);
        cal.set(Calendar.MONTH, 9);
        cal.set(Calendar.DAY_OF_MONTH, 3);
        cal.add(Calendar.DATE, -4);
        Date date=cal.getTime();
        System.out.println(df.format(date));
        cal.add(Calendar.YEAR, 4);
        date=cal.getTime();
        System.out.println(df.format(date));
    }
}
