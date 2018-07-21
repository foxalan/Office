package com.example.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.core.app.Latte;
import com.example.ui.R;
import com.example.ui.sign.ISignListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author alan
 *         Date  2018/7/20.
 *         Function :时间选择器，显示时间和状态
 *         Issue : 待优化
 */

public class TimerTextView extends LinearLayout implements View.OnClickListener {

    private Context context;
    private AppCompatTextView mTvSignState;
    private AppCompatTextView mTvSignTime;
    private boolean isBreak = false;

    private ISignListener signListener;

    public void setSignListener(ISignListener signListener) {
        this.signListener = signListener;
    }

    public TimerTextView(Context context) {
        this(context, null);
    }

    public TimerTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setOnClickListener(this);
        initView();
    }

    /**
     * 设置时间
     */

    private Timer timer;

    public void initTime() {
        if (timer == null) {
            timer = new Timer();
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Latte.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        if (mTvSignTime != null) {
                            mTvSignTime.setText(getCurrentTime());
                        }
                    }
                });
            }
        }, 0, 1000);


    }

    public void stopTime() {
        if (timer!=null){
            timer.cancel();
        }
    }

    private void initView() {
        View rootView = LayoutInflater.from(context).inflate(R.layout.layout_timer_sign, this, false);

        mTvSignState = rootView.findViewById(R.id.tv_sign_state);
        mTvSignTime = rootView.findViewById(R.id.tv_sign_time);
        addView(rootView);
    }

    public Date getCurrentDate() {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        return date;
    }

    public String getCurrentTime() {
        //     SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(getCurrentDate());
    }


    @Override
    public void onClick(View v) {
        if (signListener != null) {
            signListener.onAppSign(v, mTvSignState, getCurrentDate());
        }
    }


}
