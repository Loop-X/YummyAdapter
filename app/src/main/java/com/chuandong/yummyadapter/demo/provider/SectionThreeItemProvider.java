package com.chuandong.yummyadapter.demo.provider;

import android.content.Context;

import com.chuandong.yummyadapter.demo.adapter.DemoAdapter;
import com.chuandong.yummyadapter.lib.BaseItemProvider;
import com.chuandong.yummyadapter.lib.BaseViewHolder;
import com.chuandong.yummyadapter.lib.IndexPath;
import com.chuandong.yummyadapter.R;

import java.util.ArrayList;
import java.util.List;

public class SectionThreeItemProvider extends BaseItemProvider<List<String>, BaseViewHolder> {

    private List<String> titles = new ArrayList<>();

    public SectionThreeItemProvider(Context context) {
        super(context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_section_three;
    }

    @Override
    public void onBind(BaseViewHolder holder, IndexPath indexPath) {
        holder.setText(R.id.tv_title, titles.get(indexPath.getRow()));
    }

    @Override
    public void setData(List<String> data) {
        titles = data;
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
}
