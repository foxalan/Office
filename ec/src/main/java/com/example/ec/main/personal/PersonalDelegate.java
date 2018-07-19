package com.example.ec.main.personal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.core.app.AccountManager;
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

public class PersonalDelegate extends BottomItemDelegate  {

    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }

    private RecyclerView rvSettings;


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        rvSettings = $(R.id.rv_personal_setting);


    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean("STATE_SAVE_IS_HIDDEN");

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("STATE_SAVE_IS_HIDDEN", isHidden());
    }
}
