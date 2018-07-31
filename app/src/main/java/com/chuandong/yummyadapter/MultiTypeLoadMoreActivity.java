package com.chuandong.yummyadapter;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chuandong.yummyadapter.demo.adapter.MultiLoadMoreAdapter;
import com.chuandong.yummyadapter.demo.model.Article;
import com.chuandong.yummyadapter.demo.model.User;
import com.chuandong.yummyadapter.lib.BaseAdapter;
import com.chuandong.yummyadapter.lib.DefaultLoadMoreView;
import com.chuandong.yummyadapter.lib.LoadMoreView;

import java.util.ArrayList;
import java.util.List;

public class MultiTypeLoadMoreActivity extends AppCompatActivity implements
        BaseAdapter.YummyAdapterLoadMoreListener {

    private RecyclerView mRecyclerView;
    private MultiLoadMoreAdapter mAdapter;

    private List<User> mUserList;
    private List<Article> mArticleList;

    private int mCurrentPage = 0;

    private final static int PAGE_SIZE = 10;
    private final static int TOTAL_COUNT = 35;
    private final static int TOTAL_PAGE_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type_load_more);

        mAdapter = new MultiLoadMoreAdapter(this);
        mAdapter.setLoadMoreListener(this);
        mAdapter.enableLoadMore(true); // Enable Load More

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        prepareTestData();

        mAdapter.setSectionOneData(mUserList);
        mAdapter.setSectionTwoData(mArticleList);
    }

    public void prepareTestData() {
        mUserList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mUserList.add(new User("User " + i, i % 2 == 0));
        }

        mArticleList = new ArrayList<>();
        for (int i = 0; i < PAGE_SIZE; i++) {
            mArticleList.add(new Article("Article " + i));
        }
    }

    public List<Article> getMoreData() {
        List<Article> newArticleList = new ArrayList<>();
        for (int i = 0; i < PAGE_SIZE; i++) {
            newArticleList.add(new Article("Article " + (10*mCurrentPage + i)));
        }
        return newArticleList;
    }

    @Override
    public void onLoadMore() {
        if (mCurrentPage < TOTAL_PAGE_COUNT) {
            mCurrentPage += 1;
            try {Thread.sleep(500);} catch (InterruptedException e) {}

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    mAdapter.addSectionTwoData(getMoreData());
                    mAdapter.loadMoreComplete();
                }
            });
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    mAdapter.loadMoreEnd(false);
                }
            });
        }
    }
}
