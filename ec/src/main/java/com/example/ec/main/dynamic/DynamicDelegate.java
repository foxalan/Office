package com.example.ec.main.dynamic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.core.delegate.bottom.BottomItemDelegate;
import com.example.ec.R;

import com.example.ui.recycler.BaseDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alan
 *         Date  2018/6/5.
 *         Function :
 *         Issue :
 */

public class DynamicDelegate extends BottomItemDelegate {

    private RecyclerView rvDynamic;

    @Override
    public Object setLayout() {
        return R.layout.delegate_dynamic;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

        rvDynamic = rootView.findViewById(R.id.ryc_dynamic);


    }
}
