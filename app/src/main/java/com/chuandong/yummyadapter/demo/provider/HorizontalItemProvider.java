package com.chuandong.yummyadapter.demo.provider;

import android.content.Context;
import android.widget.Toast;

import com.chuandong.yummyadapter.demo.model.User;
import com.chuandong.yummyadapter.lib.BaseItemProvider;
import com.chuandong.yummyadapter.lib.BaseViewHolder;
import com.chuandong.yummyadapter.lib.IndexPath;
import com.chuandong.yummyadapter.R;

import java.util.ArrayList;
import java.util.List;

public class HorizontalItemProvider extends BaseItemProvider<List<User>, BaseViewHolder> {

    private List<User> userList;

    public HorizontalItemProvider(Context context) {
        super(context);
        userList = new ArrayList<>();
    }

    @Override
    public int getLayout() {
        return R.layout.item_horizontal;
    }

    @Override
    public void onBind(BaseViewHolder holder, IndexPath indexPath) {

        User user = userList.get(indexPath.getRow());

        holder.setText(R.id.tv_user_name, user.getUserName());
        holder.setText(R.id.btn_follow, user.getFollowed() ? "Unfollow" : "Follow");
        holder.setClick(R.id.container, this, indexPath);
        holder.setClick(R.id.btn_follow, this, indexPath);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public void setData(List<User> newData) {
        userList = newData;
    }

    @Override
    public void onClick(BaseViewHolder holder, IndexPath indexPath, int viewId) {
        switch (viewId) {
            case R.id.container:
                Toast.makeText(mContext, "Click User " + indexPath.getRow(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_follow:
                User user = userList.get(indexPath.getRow());
                user.setFollowed(!user.getFollowed());

                if (user.getFollowed()) {
                    Toast.makeText(mContext, "Follow User " + indexPath.getRow(), Toast.LENGTH_SHORT).show();
                    holder.setText(R.id.btn_follow, "Unfollow");
                } else {
                    Toast.makeText(mContext, "Unfollow User " + indexPath.getRow(), Toast.LENGTH_SHORT).show();
                    holder.setText(R.id.btn_follow, "Follow");
                }
                break;
        }
    }
}
