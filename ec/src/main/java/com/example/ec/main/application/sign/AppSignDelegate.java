package com.example.ec.main.application.sign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.baidu.mapapi.map.MapView;
import com.example.core.app.AccountManager;
import com.example.core.delegate.LatteDelegate;
import com.example.core.util.date.DateUtil;
import com.example.ec.R;
import com.example.ec.main.application.ApplicationType;
import com.example.ui.recycler.BaseDecoration;
import com.example.ui.recycler.MultipleFields;
import com.example.ui.recycler.MultipleItemEntity;
import com.example.ui.sign.ISignListener;
import com.example.ui.widget.TimerTextView;

import java.util.Date;

/**
 * @author alan
 *         Date  2018/7/19.
 *         Function : 签到页面
 *         Issue :
 */

public class AppSignDelegate extends LatteDelegate implements ISignListener {

    private MapView mapView;
    private TimerTextView mTimerSign;
    private RecyclerView mRycSign;
    private AppSignAdapter appAdapter;
    private String currentState = SignState.SIGN_STATE_UN_SIGN;


    @Override
    public Object setLayout() {

        return R.layout.delegate_application_sign;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        mapView = rootView.findViewById(R.id.mv_location);
        mTimerSign = rootView.findViewById(R.id.timer_sign);
        mRycSign = rootView.findViewById(R.id.ryc_sign);

        mTimerSign.initTime();
        mTimerSign.setSignListener(this);

        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTimerSign!=null){
            mTimerSign.stopTime();
        }
    }

    private void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        appAdapter = new AppSignAdapter(new AppSignDataConverter().convert());
        mRycSign.setLayoutManager(manager);
        mRycSign.addItemDecoration
                (BaseDecoration.create(ContextCompat.getColor(getContext(), R.color.app_background), 2));
        mRycSign.setAdapter(appAdapter);
    }

    @Override
    public void onAppSign(View v, AppCompatTextView textView, Date date) {
        switch (currentState) {
            case SignState.SIGN_STATE_UN_SIGN:

                userSign(textView);
                break;
            case SignState.SING_STATE_SING_FINISH:

                break;
            case SignState.SING_STATE_SING_UN_RETREAT:

                break;
            default:
                break;
        }
    }

    /**
     * 用户签到
     */
    private void userSign(AppCompatTextView textView) {

        String signTime = DateUtil.getCurrentTime();
        boolean isArriveLate = DateUtil.isArriveLate(signTime);
        int type = SignState.SING_IN;

        appAdapter.getData().clear();
        final MultipleItemEntity signTimeEntity = MultipleItemEntity.builder()
                .setField(MultipleFields.ITEM_TYPE, ApplicationType.TYPE_SIGN_TIME)
                .setField(MultipleFields.ID, 0)
                .build();

        final MultipleItemEntity signEventEntity = MultipleItemEntity.builder()
                .setField(MultipleFields.ITEM_TYPE, ApplicationType.TYPE_SIGN_EVENT)
                .setField(MultipleFields.APP_SIGN_EVENT_TYPE,type)
                .setField(MultipleFields.APP_SIGN_EVENT_TIME,signTime)
                .setField(MultipleFields.APP_SIGN_EVENT_STATE,isArriveLate)
                .setField(MultipleFields.ID,1)
                .build();

        appAdapter.getData().add(signTimeEntity);
        appAdapter.getData().add(signEventEntity);


        for (int i = 0 ; i<appAdapter.getData().size();i++){
            appAdapter.notifyItemChanged(i);
        }

        AccountManager.setSignEventState(SignState.SING_STATE_SING_UN_RETREAT);

        currentState = AccountManager.getSignEventState();
        textView.setText("签退");
    }
}
