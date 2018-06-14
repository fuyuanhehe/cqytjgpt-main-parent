package com.ccttic.util.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CCtticDateUtils {
    /**
     * 说明：format日期数据，返回字符串
     * */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static String presentDay(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date());
    }

    public static String presentDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date());
    }
}
