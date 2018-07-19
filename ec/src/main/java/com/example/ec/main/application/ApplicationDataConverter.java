package com.example.ec.main.application;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ec.R;
import com.example.ui.recycler.DataConverter;
import com.example.ui.recycler.ItemType;
import com.example.ui.recycler.MultipleFields;
import com.example.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alan
 *         Date  2018/7/19.
 *         Function :
 *         Issue :
 */

public class ApplicationDataConverter extends DataConverter {

    @Override
    public ArrayList<MultipleItemEntity> convert() {

        //banner
        final ArrayList<Integer> bannerImages = new ArrayList<>();
        int[] imageIds = {R.mipmap.ic_banner,R.mipmap.ic_banner};
        for (int i = 0; i < imageIds.length; i++) {
            bannerImages.add(imageIds[i]);
        }

        final MultipleItemEntity bannerEntity = MultipleItemEntity.builder()
                .setField(MultipleFields.ITEM_TYPE, ItemType.BANNER)
                .setField(MultipleFields.SPAN_SIZE, 4)
                .setField(MultipleFields.ID, 0)
                .setField(MultipleFields.BANNERS, bannerImages)
                .build();

        ENTITIES.add(bannerEntity);

        //个人办公
        final MultipleItemEntity personalOffice = MultipleItemEntity.builder()
                .setField(MultipleFields.ITEM_TYPE, ItemType.TEXT)
                .setField(MultipleFields.SPAN_SIZE, 4)
                .setField(MultipleFields.ID, 0)
                .setField(MultipleFields.TEXT, "个人办公")
                .build();

        ENTITIES.add(personalOffice);

        ArrayList<AppBean> appBeans = AppDataFactory.getPersonalList();
        for (int i = 0; i < appBeans.size(); i++) {
            AppBean appBean = appBeans.get(i);

            final MultipleItemEntity data = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, ApplicationType.TYPE_GRID)
                    .setField(MultipleFields.SPAN_SIZE, 1)
                    .setField(MultipleFields.ID, appBean.getId())
                    .setField(MultipleFields.APP_GRID_TEXT,appBean.getText() )
                    .setField(MultipleFields.APP_GRID_IMG,appBean.getImgId() )
                    .build();

            ENTITIES.add(data);

        }

        //协同办公
        final MultipleItemEntity coordination = MultipleItemEntity.builder()
                .setField(MultipleFields.ITEM_TYPE, ItemType.TEXT)
                .setField(MultipleFields.SPAN_SIZE, 4)
                .setField(MultipleFields.ID, 0)
                .setField(MultipleFields.TEXT, "协同办公")
                .build();

        ENTITIES.add(coordination);

        ArrayList<AppBean> appBeanList = AppDataFactory.getCoordination();
        for (int i = 0; i < appBeanList.size(); i++) {
            AppBean appBean = appBeanList.get(i);

            final MultipleItemEntity data = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, ApplicationType.TYPE_GRID)
                    .setField(MultipleFields.SPAN_SIZE, 1)
                    .setField(MultipleFields.ID, appBean.getId())
                    .setField(MultipleFields.APP_GRID_TEXT,appBean.getText() )
                    .setField(MultipleFields.APP_GRID_IMG,appBean.getImgId() )
                    .build();

            ENTITIES.add(data);

        }


        return ENTITIES;
    }
}
