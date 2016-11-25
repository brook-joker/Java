package com.badminton.test;

import com.badminton.main.Main;
import org.junit.Test;

/**
 * Created by maqiang on 16/10/15.
 */
public class MainTest {

    /**
     * 测试作业中给出的示例
     * @throws Exception
     */
    @Test
    public void generateSummary() throws Exception {
        String test1 = "2016-06-02 20:00~22:00 7";
        String test2 = "2016-06-03 09:00~12:00 14";
        String test3 = "2016-06-04 14:00~17:00 22";
        String test4 = "2016-06-05 19:00~22:00 3";
        String test5 = "2016-06-06 12:00~15:00 15";
        String test6 = "2016-06-07 15:00~17:00 12";
        String test7 = "2016-06-08 10:00~13:00 19";
        String test8 = "2016-06-09 16:00~18:00 16";
        String test9 = "2016-06-10 20:00~22:00 5";
        String test10 = "2016-06-11 13:00~15:00 11";
        System.out.println(Main.generateSummary(test1));
        System.out.println(Main.generateSummary(test2));
        System.out.println(Main.generateSummary(test3));
        System.out.println(Main.generateSummary(test4));
        System.out.println(Main.generateSummary(test5));
        System.out.println(Main.generateSummary(test6));
        System.out.println(Main.generateSummary(test7));
        System.out.println(Main.generateSummary(test8));
        System.out.println(Main.generateSummary(test9));
        System.out.println(Main.generateSummary(test10));
    }
    /**
     * 测试根据人数分配的场地是否符合要求
     *
     * @throws Exception
     */
    @Test
    public void getVenues() throws Exception {
        //边界1:当人数少于4个人时
        System.out.println("参加人数为: 1"+" 场地预订为:"+Main.getVenues(1));
        //边界2:当人数等于4个人时
        System.out.println("参加人数为: 4"+" 场地预订为:"+Main.getVenues(4));
        //边界3:当人数在6到12人之间,不包括12人
        System.out.println("参加人数为: 7"+" 场地预订为:"+Main.getVenues(7));
        //边界4:当人数在12人到24人之间
        //在边界4的条件下,对6取余数的情况小于4
        System.out.println("参加人数为: 12"+" 场地预订为:"+Main.getVenues(12));
        //在边界4的条件下,对6取余数的情况大于等于4"参加人数为: 1"+"场地预订为:"+
        System.out.println("参加人数为: 23"+" 场地预订为:"+Main.getVenues(23));
        //边界5:当人数大于24人时
        System.out.println("参加人数为: 29"+" 场地预订为:"+Main.getVenues(29));
    }
    /**
     * 测试在一个时间段内的场馆的花费
     *  1.周一至周五的收费标准
     *    9:00 ~ 12:00  30/时
     *    12:00 ~ 18:00 50/时
     *    18:00 ~ 20:00 80/时
     *    20:00 ~ 22:00 60/时
     *  2.周六及周日的收费标准
     *    9:00 ~ 12:00  40/时
     *    12:00 ~ 18:00 50/时
     *    18:00 ~ 22:00 60/时
     *
     *  以下多组时间段测试正常
     * @throws Exception
     */
    @Test
    public void getSingleVienusCost() throws Exception {
        //正常时间段测试
        String test1 = "9:00~12:00";
        String test2 = "12:00~18:00";
        String test3 = "18:00~20:00";
        String test4 = "20:00~22:00";
        //特殊时间段
        String test5 = "10:00~13:00";
        String test6 = "10:00~19:00";
        String test7 = "10:00~21:00";
        String test8 = "15:00~19:00";
        String test9 = "15:00~21:00";
        String test10 = "19:00~21:00";

        //周三
        int week1 = 3;
        //周六
        int week2 = 6;

        System.out.println("周一至周五的情况如下:");
        System.out.println(test1+" 花费为: "+Main.getSingleVienusCost(test1,week1));
        System.out.println(test2+" 花费为: "+Main.getSingleVienusCost(test2,week1));
        System.out.println(test3+" 花费为: "+Main.getSingleVienusCost(test3,week1));
        System.out.println(test4+" 花费为: "+Main.getSingleVienusCost(test4,week1));
        System.out.println(test5+" 花费为: "+Main.getSingleVienusCost(test5,week1));
        System.out.println(test6+" 花费为: "+Main.getSingleVienusCost(test6,week1));
        System.out.println(test7+" 花费为: "+Main.getSingleVienusCost(test7,week1));
        System.out.println(test8+" 花费为: "+Main.getSingleVienusCost(test8,week1));
        System.out.println(test9+" 花费为: "+Main.getSingleVienusCost(test9,week1));
        System.out.println(test10+" 花费为: "+Main.getSingleVienusCost(test10,week1));

        System.out.println("周六至周日的情况如下:");
        System.out.println(test1+" 花费为: "+Main.getSingleVienusCost(test1,week2));
        System.out.println(test2+" 花费为: "+Main.getSingleVienusCost(test2,week2));
        System.out.println(test3+" 花费为: "+Main.getSingleVienusCost(test3,week2));
        System.out.println(test4+" 花费为: "+Main.getSingleVienusCost(test4,week2));
        System.out.println(test5+" 花费为: "+Main.getSingleVienusCost(test5,week2));
        System.out.println(test6+" 花费为: "+Main.getSingleVienusCost(test6,week2));
        System.out.println(test7+" 花费为: "+Main.getSingleVienusCost(test7,week2));
        System.out.println(test8+" 花费为: "+Main.getSingleVienusCost(test8,week2));
        System.out.println(test9+" 花费为: "+Main.getSingleVienusCost(test9,week2));
        System.out.println(test10+" 花费为: "+Main.getSingleVienusCost(test10,week2));
    }
}