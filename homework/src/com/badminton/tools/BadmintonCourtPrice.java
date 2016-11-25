package com.badminton.tools;

/**
 * Created by maqiang on 16/10/14.
 */
public class BadmintonCourtPrice {

    //周一到周五的羽毛球馆价格表
    //9:00~12:00
    private static final int mNineToTwelve_Normal = 30;
    //12:00~18:00
    private static final int mTwelveToEighteenth_Normal = 50;
    //18:00~20:00
    private static final int mEighteenthToTwenty_Normal = 80;
    //20:00~22:00
    private static final int mTwentyTotwenty_Two_Normal = 60;

    //周六及周日
    //9:00~12:00
    private static final int mNineToTwelve_Weekend = 40;
    //12:00~18:00
    private static final int mTwelveToEighteenth_Weekend = 50;
    //18:00~20:00
    private static final int mEighteenthToTwenty_Two_Weekend = 60;

    /**
     * 时间段对应的单价
     * @param startTime
     * @param endTime
     * @param week
     * @return
     */
    public static int calculatePrice(int startTime,int endTime,int week){
        if (week>5){
            // 9点至12点
            if (startTime>=900&&endTime<=1200){
                return mNineToTwelve_Weekend;
            }else if (startTime>=1200&&endTime<=1800){
                return mTwelveToEighteenth_Weekend;
            }else if (startTime>=1800&&endTime<=2200){
                return mEighteenthToTwenty_Two_Weekend;
            }else {
                return -1;
            }
        }else {
            if (startTime>=900&&endTime<=1200){
                return mNineToTwelve_Normal;
            }else if (startTime>=1200&&endTime<=1800){
                return mTwelveToEighteenth_Normal;
            }else if (startTime>=1800&&endTime<=2000){
                return mEighteenthToTwenty_Normal;
            }else if (startTime>=2000&&endTime<=2200){
                return mTwentyTotwenty_Two_Normal;
            }else {
                return -1;
            }
        }
    }
}
