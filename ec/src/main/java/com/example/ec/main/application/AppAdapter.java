package com.example.ec.main.application;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.example.ec.R;
import com.example.ui.banner.BannerCreator;
import com.example.ui.recycler.ItemType;
import com.example.ui.recycler.MultipleFields;
import com.example.ui.recycler.MultipleItemEntity;
import com.example.ui.recycler.MultipleRecyclerAdapter;
import com.example.ui.recycler.MultipleViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alan
 *         Date  2018/7/19.
 *         Function :
 *         Issue :
 */

public class AppAdapter extends MultipleRecyclerAdapter {

    /**
     * 确保初始化一次Banner，防止重复Item加载
     */
    private boolean mIsInitBanner = false;

    protected AppAdapter(List<MultipleItemEntity> data) {
        super(data);

        addItemType(ItemType.BANNER, R.layout.item_banner);
        addItemType(ItemType.TEXT, R.layout.normal_item_text);
        addItemType(ApplicationType.TYPE_GRID, R.layout.item_application_grid);

    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {

        switch (holder.getItemViewType()) {
            case ItemType.BANNER:
                final ArrayList<Integer> bannerImages;
                if (!mIsInitBanner) {
                    bannerImages = entity.getField(MultipleFields.BANNERS);
                    Log.e("office",bannerImages.size()+"=============================");
                    final ConvenientBanner<Integer> convenientBanner = holder.getView(R.id.banner_recycler_item_org);
                    BannerCreator.setDefaultInteger(convenientBanner, bannerImages, this);
                    mIsInitBanner = true;
                }
                break;
            case ItemType.TEXT:
                AppCompatTextView textView = holder.getView(R.id.item_text);
                String text = entity.getField(MultipleFields.TEXT);
                textView.setText(text);
                break;
            case ApplicationType.TYPE_GRID:
                AppCompatTextView gridText = holder.getView(R.id.item_app_text);
                AppCompatImageView gridImg = holder.getView(R.id.item_app_icon);

                String textGrid = entity.getField(MultipleFields.APP_GRID_TEXT);
                int imgGrid = entity.getField(MultipleFields.APP_GRID_IMG);

                gridImg.setImageResource(imgGrid);
                gridText.setText(textGrid);

                break;
            default:
                break;
        }
    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return getData().get(position).getField(MultipleFields.SPAN_SIZE);
    }
}
