package com.example.ec.main.application;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.example.core.delegate.bottom.BottomItemDelegate;
import com.example.ec.R;
import com.example.ec.main.application.sign.AppSignDelegate;
import com.example.ui.recycler.BaseDecoration;
import com.example.ui.recycler.MultipleFields;
import com.example.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;

/**
 * @author alan
 *         Date  2018/7/18.
 *         Function : 应用界面
 *         Issue :
 */

public class ApplicationDelegate extends BottomItemDelegate {

    private RecyclerView mRycApp;
    private AppAdapter appAdapter;
    private ArrayList<MultipleItemEntity> entityArrayList = new ArrayList<>();

    @Override
    public Object setLayout() {
        return R.layout.delegate_application;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        mRycApp = rootView.findViewById(R.id.ryc_app);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        entityArrayList.clear();
        entityArrayList = new ApplicationDataConverter().convert();
        appAdapter = new AppAdapter(entityArrayList);
        initRecyclerView();
    }

    private void initRecyclerView() {
        final GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
        mRycApp.setLayoutManager(manager);
        mRycApp.addItemDecoration
                (BaseDecoration.create(ContextCompat.getColor(getContext(), R.color.app_background), 2));

        mRycApp.setAdapter(appAdapter);
        mRycApp.addOnItemTouchListener(new SimpleClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                final MultipleItemEntity entity = (MultipleItemEntity) adapter.getData().get(position);
                int type = entity.getField(MultipleFields.ITEM_TYPE);
                if (type == ApplicationType.TYPE_GRID) {

                    int id = entity.getField(MultipleFields.ID);
                    switch (id) {
                        case 0:
                            getParentDelegate().getSupportDelegate().start(new AppSignDelegate());
                            break;
                        default:
                            break;
                    }
                }
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

            }

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }

            @Override
            public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }
}
