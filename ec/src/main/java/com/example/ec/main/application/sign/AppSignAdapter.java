package com.example.ec.main.application.sign;

import android.annotation.SuppressLint;
import android.opengl.Visibility;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;

import com.example.core.util.date.DateUtil;
import com.example.ec.R;
import com.example.ec.main.application.ApplicationType;
import com.example.ui.recycler.MultipleFields;
import com.example.ui.recycler.MultipleItemEntity;
import com.example.ui.recycler.MultipleRecyclerAdapter;
import com.example.ui.recycler.MultipleViewHolder;

import java.util.List;

/**
 * @author alan
 *         Date  2018/7/20.
 *         Function :
 *         Issue :
 */

public class AppSignAdapter extends MultipleRecyclerAdapter {

    protected AppSignAdapter(List<MultipleItemEntity> data) {
        super(data);

        addItemType(ApplicationType.TYPE_SIGN_TIME, R.layout.item_app_sign_time);
        addItemType(ApplicationType.TYPE_SIGN_EVENT, R.layout.item_app_sign_event);

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {

        switch (entity.getItemType()) {
            case ApplicationType.TYPE_SIGN_TIME:

                AppCompatTextView mDefaultTime = holder.getView(R.id.item_tv_sign_time);
                mDefaultTime.setText(DateUtil.getCurrentTime()+"    "+DateUtil.getWeekOfDate());

                break;
            case ApplicationType.TYPE_SIGN_EVENT:

                int type  = entity.getField(MultipleFields.APP_SIGN_EVENT_TYPE);
                String time = entity.getField(MultipleFields.APP_SIGN_EVENT_TIME);
                boolean state = entity.getField(MultipleFields.APP_SIGN_EVENT_STATE);

                AppCompatTextView mTvState = holder.getView(R.id.item_tv_sign_state);
                mTvState.setVisibility(state?View.VISIBLE: View.GONE);
                mTvState.setText(type==0?"迟到":"早退");

                AppCompatTextView mTvTime = holder.getView(R.id.item_text_sign_event_time);
                mTvTime.setText(time);

                break;
            default:
                break;

        }
    }
}
