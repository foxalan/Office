package com.example.ui.sign;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.util.Date;

/**
 * @author alan
 *         Date  2018/7/20.
 *         Function : 签到
 *         Issue :
 */

public interface ISignListener {

    /**
     * Sign回调 要改变TextView ，要获取Date
     * @param v
     * @param textView
     * @param date
     */
    void onAppSign(View v, AppCompatTextView textView,Date date);

}
