package com.newer.util.sys;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间帮助类
 *
 * @author 卿超
 */
public class DataUtil {

    public static Date getNextDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        date = calendar.getTime();
        return date;
    }

}
