package com.chuandong.yummyadapter.demo.provider;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chuandong.yummyadapter.demo.adapter.DemoAdapter;
import com.chuandong.yummyadapter.demo.adapter.HorizontalAdapter;
import com.chuandong.yummyadapter.demo.model.User;
import com.chuandong.yummyadapter.lib.BaseItemProvider;
import com.chuandong.yummyadapter.lib.BaseViewHolder;
import com.chuandong.yummyadapter.lib.IndexPath;
import com.chuandong.yummyadapter.R;

import java.util.List;

public class SectionOneItemProvider extends BaseItemProvider<List<User>, BaseViewHolder> {

    private HorizontalAdapter mHorizontalAdapter;

    public SectionOneItemProvider(Context context) {
        super(context);

        mHorizontalAdapter = new HorizontalAdapter(mContext);
    }

    @Override
    public int getLayout() {
        return R.layout.item_section_one;
    }

    @Override
    public void onBind(BaseViewHolder holder, IndexPath indexPath) {
        RecyclerView recyclerView = holder.getView(R.id.recycler_view_horizontal);

        // Set Horizontal RecyclerView
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(mHorizontalAdapter);
    }

    @Override
    public void setData(List<User> data) {
        mHorizontalAdapter.setData(data);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}


