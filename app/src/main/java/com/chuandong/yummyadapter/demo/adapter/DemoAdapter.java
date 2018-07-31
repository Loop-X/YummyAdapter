package com.chuandong.yummyadapter.demo.adapter;

import android.content.Context;

import com.chuandong.yummyadapter.demo.provider.SectionOneItemProvider;
import com.chuandong.yummyadapter.demo.provider.SectionThreeItemProvider;
import com.chuandong.yummyadapter.demo.provider.SectionTwoItemProvider;
import com.chuandong.yummyadapter.demo.model.Article;
import com.chuandong.yummyadapter.demo.model.User;
import com.chuandong.yummyadapter.lib.BaseAdapter;
import com.chuandong.yummyadapter.lib.BaseItemProvider;

import java.util.List;

public class DemoAdapter extends BaseAdapter {

    private SectionOneItemProvider mProviderSectionOne;
    private SectionTwoItemProvider mProviderSectionTwo;
    private SectionThreeItemProvider mProviderSectionThree;

    public DemoAdapter(Context context) {
        super(context);

        mProviderSectionOne = new SectionOneItemProvider(context);
        mProviderSectionTwo = new SectionTwoItemProvider(context);
        mProviderSectionThree = new SectionThreeItemProvider(context);

        finishInitialize();
    }

    public void setSectionOneData(List<User> newData) {
        mProviderSectionOne.setData(newData);
    }

    public void setSectionTwoData(List<Article> newDate) {
        mProviderSectionTwo.setData(newDate);
    }

    public void setSectionThreeData(List<String> newDate) {
        mProviderSectionThree.setData(newDate);
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProviders(mProviderSectionOne,
                mProviderSectionTwo,
                mProviderSectionThree);
    }

}
