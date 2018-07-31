package com.chuandong.yummyadapter.demo.adapter;

import android.content.Context;

import com.chuandong.yummyadapter.demo.provider.SectionOneItemProvider;
import com.chuandong.yummyadapter.demo.provider.SectionTwoItemProvider;
import com.chuandong.yummyadapter.demo.model.Article;
import com.chuandong.yummyadapter.demo.model.User;
import com.chuandong.yummyadapter.lib.BaseAdapter;
import com.chuandong.yummyadapter.lib.BaseItemProvider;

import java.util.List;

public class MultiLoadMoreAdapter extends BaseAdapter {

    private SectionOneItemProvider mProviderSectionOne;
    private SectionTwoItemProvider mProviderSectionTwo;

    public MultiLoadMoreAdapter(Context context) {
        super(context);

        mProviderSectionOne = new SectionOneItemProvider(context);
        mProviderSectionTwo = new SectionTwoItemProvider(context);

        finishInitialize();
    }

    public void setSectionOneData(List<User> newData) {
        mProviderSectionOne.setData(newData);
    }

    public void setSectionTwoData(List<Article> newData) {
        mProviderSectionTwo.setData(newData);
    }

    public void addSectionTwoData(List<Article> moreData) {
        mProviderSectionTwo.addData(moreData);
        notifySectionMoreData(1, moreData.size());
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProviders(mProviderSectionOne, mProviderSectionTwo);
    }

}
