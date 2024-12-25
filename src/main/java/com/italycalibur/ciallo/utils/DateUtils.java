package com.italycalibur.ciallo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 日期格式转换
 * @author dhr
 * @date 2024-12-25 上午10:14:04
 * @version 1.0
 */ 
public class DateUtils {
    public static String formatDate(Date source, SimpleDateFormat dateFormat) {
        return dateFormat.format(source);
    }

    public static SimpleDateFormat format(DateType type) {
        return new SimpleDateFormat(type.getValue());
    }

    public static int getYearsDifference(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);

        int yearsDifference = calendar2.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);

        if (yearsDifference < 0) {
            yearsDifference = -yearsDifference;
        }

        if (calendar2.get(Calendar.DAY_OF_YEAR) < calendar1.get(Calendar.DAY_OF_YEAR)) {
            yearsDifference--;
        }

        return yearsDifference;
    }

    public static int getYearsDifference(Date date) {
        return DateUtils.getYearsDifference(date, new Date());
    }

    @Getter
    @AllArgsConstructor
    public enum DateType {
        A("yyyy-MM-dd"),
        A1("yyyy-M-d"),
        A2("yyyy-MM"),
        A3("yyyy-M"),
        B("yyyy/MM/dd"),
        B1("yyyy/M/d"),
        B2("yyyy/MM/dd HH:mm:ss"),
        B3("yyyy/M/d HH:mm:ss"),
        C("yyyy-MM-dd HH:mm:ss"),
        C1("yyyy-M-d HH:mm:ss"),
        C2("yyyy-MM-dd HH:mm"),
        D("d-MMM"),
        D1("d-MMM-yyyy"),
        D2("d/MMM/yyyy"),
        D3("d/MMM/yyyy HH:mm:ss"),
        D4("MMM.dd,yyyy"),
        D5("MMM dd,yyyy"),
        E0("yyyy年M月d日"),
        E("yyyy年MM月dd"),
        E1("yyyy年MM月dd HH:mm:ss"),
        E2("yyyy年MM月dd日"),
        F("yyyy.MM.dd HH.mm"),
        F1("yyyyMMdd"),
        YE("yyyy"),
        YE1("yyyyMM");


        private final String value;
    }
}
