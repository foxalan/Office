package com.example.ec.main.application.sign;

/**
 * @author alan
 *         Date  2018/7/20.
 *         Function : 签到状态
 *         Issue :
 */

public class SignState {

    /**
     * 未做任何签到动作
     */
    public static final String SIGN_STATE_UN_SIGN = "un_sign";
    /**
     * 已签到但没有签退
     */
    public static final String SING_STATE_SING_UN_RETREAT ="un_retreat";
    /**
     * 签到和签退完成
     */
    public static final String SING_STATE_SING_FINISH="sign_finish";



    /**
     * 迟到
     */
    public static final String SIGN_ARRIVE_LATE="arrive_late";
    /**
     * 早退
     */
    public static final String SIGN_LEAVE_EARLY="leave_early";
    /**
     * 正常
     */
    public static final String SIGN_LEAVE_NORMAL="normal";


    public static final int SING_IN = 0;
    public static final int Retreat = 1;
}
