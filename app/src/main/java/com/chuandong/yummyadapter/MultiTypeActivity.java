package com.chuandong.yummyadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chuandong.yummyadapter.demo.adapter.DemoAdapter;
import com.chuandong.yummyadapter.demo.model.Article;
import com.chuandong.yummyadapter.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class MultiTypeActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DemoAdapter mAdapter;

    private List<User> mUserList;
    private List<Article> mArticleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type);

        mAdapter = new DemoAdapter(this);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        prepareTestData();

        List<String> titlesSectionThree = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            titlesSectionThree.add("Section 3 Item " + i);
        }

        mAdapter.setSectionOneData(mUserList);
        mAdapter.setSectionTwoData(mArticleList);
        mAdapter.setSectionThreeData(titlesSectionThree);
    }

    public void prepareTestData() {
        mUserList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mUserList.add(new User("User " + i, i % 2 == 0));
        }

        mArticleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mArticleList.add(new Article("Article " + i));
        }
    }
}
