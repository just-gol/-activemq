package com.qsqx.activemqdemo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RandomUtil {
    private static final String ODD_NUMBER = "0019990000";

    public static int getRandomNumber(){
        return  (int)((Math.random() * 9 + 1) * 1000000);
    }

    public static String getStatementNumber(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMM");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = dateTimeFormatter.format(localDateTime);
        return date+getRandomNumber(100,400)+RandomUtil.ODD_NUMBER+getRandomNumber(100,400);
    }

    public static int getRandomNumber(int min , int max) {
        boolean flag = true;
        Integer num = null;
        while (flag){
            num = (int)(Math.random() * 400);
            if (min < num && max <= 401){
                flag = false;
            }
        }
        return num;
    }
}