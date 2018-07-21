package com.example.ec.main.application.sign;

import com.example.ec.main.application.ApplicationType;
import com.example.ui.recycler.DataConverter;
import com.example.ui.recycler.ItemType;
import com.example.ui.recycler.MultipleFields;
import com.example.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;

/**
 * @author alan
 *         Date  2018/7/20.
 *         Function :
 *         Issue :
 */

public class AppSignDataConverter extends DataConverter {


    @Override
    public ArrayList<MultipleItemEntity> convert() {

        final MultipleItemEntity signTimeEntity = MultipleItemEntity.builder()
                .setField(MultipleFields.ITEM_TYPE, ApplicationType.TYPE_SIGN_TIME)
                .setField(MultipleFields.ID, 0)
                .build();

        ENTITIES.add(signTimeEntity);
        return ENTITIES;
    }
}
