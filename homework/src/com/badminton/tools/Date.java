package com.badminton.tools;

import java.util.Calendar;

/**
 * Created by maqiang on 16/10/14.
 * 输入年月日获取星期几的日期类。
 */
public class Date {
    /**
     * 因为API中的星期排序是{星期天,星期一,星期二,星期三,星期四,星期五,星期六}
     * 所有当获取的int值为0时对应的是星期天,其他的话就是建一所对应的值
     * @param year
     * @param month
     * @param day
     * @return
     */
     public static int getWeek(int year,int month,int day){
         Calendar calendar = Calendar.getInstance();
         calendar.set(year,month-1,day);
         int res = calendar.get(Calendar.DAY_OF_WEEK);
         if (res == 0){
             res = 7;
         }else {
             res = res -1;
         }
        return res;
    }
}
