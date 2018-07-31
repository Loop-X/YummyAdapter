package com.chuandong.yummyadapter.demo.adapter;

import android.content.Context;

import com.chuandong.yummyadapter.demo.provider.HorizontalItemProvider;
import com.chuandong.yummyadapter.demo.model.User;
import com.chuandong.yummyadapter.lib.BaseAdapter;
import com.chuandong.yummyadapter.lib.BaseItemProvider;

import java.util.List;

public class HorizontalAdapter extends BaseAdapter {

    private HorizontalItemProvider mProvider;

    public HorizontalAdapter(Context context) {
        super(context);

        mProvider = new HorizontalItemProvider(context);

        finishInitialize();
    }

    public void setData(List<User> newData) {
        mProvider.setData(newData);
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProviders(mProvider);
    }
}
