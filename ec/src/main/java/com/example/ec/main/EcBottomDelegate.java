package com.example.ec.main;

import com.example.core.delegate.bottom.BaseBottomDelegate;
import com.example.core.delegate.bottom.BottomItemDelegate;
import com.example.core.delegate.bottom.BottomTabBean;
import com.example.core.delegate.bottom.ItemBuilder;
import com.example.ec.main.application.ApplicationDelegate;
import com.example.ec.main.discover.DiscoverDelegate;
import com.example.ec.main.dynamic.DynamicDelegate;
import com.example.ec.main.personal.PersonalDelegate;

import java.util.LinkedHashMap;

/**
 * @author alan
 *         Date  2018/6/5.
 *         Function :
 *         Issue :
 */

public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {

        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();

        items.put(new BottomTabBean("{fa-home}", "联系人"), new DiscoverDelegate());
        items.put(new BottomTabBean("{fa-sort}", "应用"), new ApplicationDelegate());
        items.put(new BottomTabBean("{fa-user}", "我"), new PersonalDelegate());
        return builder.addItems(items).build();
    }

    /**
     * 默认显示第一个页面
     * @return
     */
    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return 0xff33b5e5;
    }
}
