package com.chuandong.yummyadapter.demo.provider;

import android.content.Context;
import android.widget.Toast;

import com.chuandong.yummyadapter.demo.adapter.DemoAdapter;
import com.chuandong.yummyadapter.demo.model.Article;
import com.chuandong.yummyadapter.lib.BaseItemProvider;
import com.chuandong.yummyadapter.lib.BaseViewHolder;
import com.chuandong.yummyadapter.lib.IndexPath;
import com.chuandong.yummyadapter.R;

import java.util.ArrayList;
import java.util.List;

public class SectionTwoItemProvider extends BaseItemProvider<List<Article>, BaseViewHolder> {

    private List<Article> articleList = new ArrayList<>();

    public SectionTwoItemProvider(Context context) {
        super(context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_section_two;
    }

    @Override
    public void onBind(BaseViewHolder holder, IndexPath indexPath) {
        holder.setText(R.id.tv_title, articleList.get(indexPath.getRow()).getTitle());
        holder.setClick(R.id.btn_section_two, this, indexPath);
        holder.setClick(R.id.container, this, indexPath);
    }

    @Override
    public void setData(List<Article> data) {
        articleList.clear();
        articleList = data;
    }

    @Override
    public void addData(List<Article> moreData) {
        articleList.addAll(moreData);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    @Override
    public void onClick(BaseViewHolder holder, IndexPath indexPath, int viewId) {
        switch (viewId) {
            case R.id.container:
                Toast.makeText(mContext, "Item " + articleList.get(indexPath.getRow()), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_section_two:
                Toast.makeText(mContext, "SubItem " + articleList.get(indexPath.getRow()), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
