package com.badminton.main;

import com.badminton.tools.BadmintonCourtPrice;
import com.badminton.tools.Date;
import java.util.Scanner;

/**
 * Created by maqiang on 16/10/14.
 */
public class Main {

    private static String mDate;
    private static String mTime;
    private static int mPersons;
    private static int mIncome;
    private static int mPay;
    private static int mProfit;
    private static int mTotalIncome = 0;
    private static int mTotalPay = 0;
    private static int mTotalProfit = 0;
    private static final String error = "错误的输入";

    public static String generateSummary(String input){
        //先判断输入是否正确
        if (input==null||input.length()<24){
            return error;
        }
        String[] res = input.split(" ");
        //二次判断
        if (res.length<3){
            return error;
        }

        mDate = res[0];
        mTime = res[1];
        mPersons = Integer.valueOf(res[2]);
        String result = "";
        if (mPersons<4){
            mIncome = 0;
            mPay = 0;
            mProfit = 0;
            result = mDate+" "+mTime+" +"+mIncome+" -"+mPay+" "+mProfit;

        }else {
            mIncome = mPersons*30;
            mTotalIncome+=mIncome;
            mPay = getSingleVienusCost(mTime,getWeek(mDate))*getVenues(mPersons);
            mTotalPay+=mPay;
            mProfit = mIncome - mPay;
            mTotalProfit+=mProfit;
            if (mProfit>0){
                result = mDate + " " + mTime + " +" + mIncome + " -" + mPay + " +" + mProfit;
            }else {
                result = mDate + " " + mTime + " +" + mIncome + " -" + mPay + " " + mProfit;
            }
        }

        return result;
    }

    /**
     * 根据人数计算需要的场地数
     * @param persons
     * @return
     */
    public static int getVenues(int persons){
        int result = persons/6;
        int residue = persons%6;
        int venues = 0;
        if (result==0){
            if (residue<4){
                venues = 0;
            }else {
                venues = 1;
            }
        }else if(result==1){
            venues = 2;
        }else if(1<result&&result<4){
            if (residue>=4){
                venues = result+1;
            }else {
                venues = result;
            }
        }else {
            venues = result;
        }
        return venues;
    }

    public static int getWeek(String date){
        String[] dates = date.split("-");
        return Date.getWeek(Integer.valueOf(dates[0]),Integer.valueOf(dates[1]),Integer.valueOf(dates[2]));
    }

    public static int getSingleVienusCost(String time,int week){
        String[] times = time.split("~");
        //计算开始时间 比如20:00~22:00
        //转化为 startTime = 2000; endTime = 2200
        int startTime = Integer.valueOf(times[0].replace(":",""));
        int endTime = Integer.valueOf(times[1].replace(":",""));
        int cost = 0;
        //在这里只考虑特殊情况
        if (BadmintonCourtPrice.calculatePrice(startTime,endTime,week)==-1){
            //在这里讨论所有可能
            if (startTime>=900&&startTime<1200){
                //在9点到12点之间开始 超过了12点结束的情况
                if (endTime>1200){
                    cost+=(1200-startTime)/100*BadmintonCourtPrice.calculatePrice(startTime,1200,week);
                    //结束时间在12点和18点之间
                    if (endTime<=1800){
                        cost+=(endTime-1200)/100*BadmintonCourtPrice.calculatePrice(1200,endTime,week);
                    }else if (endTime<=2000){
                        //结束时间在18点和20点之间
                        cost+=(1800-1200)/100*BadmintonCourtPrice.calculatePrice(1200,1800,week);
                        cost+=(endTime-1800)/100*BadmintonCourtPrice.calculatePrice(1800,endTime,week);
                    }else if (endTime<=2200){
                        //结束时间在20点和22点之间
                        cost+=(1800-1200)/100*BadmintonCourtPrice.calculatePrice(1200,1800,week);
                        cost+=(2000-1800)/100*BadmintonCourtPrice.calculatePrice(1800,2000,week);
                        cost+=(endTime-2000)/100*BadmintonCourtPrice.calculatePrice(2000,endTime,week);
                    }else {
                        //特殊情况下 超过22点的话取22点极限值来计算
                        cost+=(1800-1200)/100*BadmintonCourtPrice.calculatePrice(1200,1800,week);
                        cost+=(2000-1800)/100*BadmintonCourtPrice.calculatePrice(1800,2000,week);
                        cost+=(2200-2000)/100*BadmintonCourtPrice.calculatePrice(endTime,2000,week);
                    }
                }else {
                    //9点到12点正常范围内
                    cost+=(endTime-startTime)/100*BadmintonCourtPrice.calculatePrice(startTime,endTime,week);
                }
            }else if(startTime>=1200&&startTime<1800){
                //在12点到18点之间开始的
                if (endTime>1800){
                    //在18点以后结束的
                    if (endTime<=2000){
                        //结束时间在18点和20点之间
                        cost+=(1800-startTime)/100*BadmintonCourtPrice.calculatePrice(startTime,1800,week);
                        cost+=(endTime-1800)/100*BadmintonCourtPrice.calculatePrice(1800,endTime,week);
                    }else if (endTime<=2200){
                        //结束时间在20点和22点之间
                        cost+=(1800-startTime)/100*BadmintonCourtPrice.calculatePrice(startTime,1800,week);
                        cost+=(2000-1800)/100*BadmintonCourtPrice.calculatePrice(1800,2000,week);
                        cost+=(endTime-2000)/100*BadmintonCourtPrice.calculatePrice(2000,endTime,week);
                    }else {
                        //特殊情况下 超过22点的话取22点极限值来计算
                        cost+=(1800-startTime)/100*BadmintonCourtPrice.calculatePrice(startTime,1800,week);
                        cost+=(2000-1800)/100*BadmintonCourtPrice.calculatePrice(1800,200,week);
                        cost+=(2200-2000)/100*BadmintonCourtPrice.calculatePrice(2000,endTime,week);
                    }
                }else {
                    //12点到18点正常范围
                    cost+=(endTime-startTime)/100*BadmintonCourtPrice.calculatePrice(startTime,endTime,week);
                }
            }else if(startTime>=1800&&startTime<2000){
                //在18点到20点之间开始的
                if (endTime>2000){
                    cost+=(2000-startTime)/100*BadmintonCourtPrice.calculatePrice(startTime,2000,week);
                    cost+=(endTime-2000)/100*BadmintonCourtPrice.calculatePrice(2000,endTime,week);
                }else {
                    cost+=(endTime-startTime)/100*BadmintonCourtPrice.calculatePrice(startTime,endTime,week);
                }
            } else {
                return 0;
            }
        }else{
            cost+=(endTime-startTime)/100*BadmintonCourtPrice.calculatePrice(startTime,endTime,week);
        }
        return cost;

    }

    /**
     * 输入结束的话 多按一次回车即可
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            if (str!=null&&str.length()>1) {
                System.out.println(generateSummary(str));
            }else {
                System.out.println("Total Income: "+mTotalIncome);
                System.out.println("Total Payment: "+mTotalPay);
                System.out.println("Profit: "+mTotalProfit);
                mTotalIncome = 0;
                mTotalPay = 0;
                mTotalProfit = 0;
            }
        }

    }
}
