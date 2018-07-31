package com.chuandong.yummyadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.chuandong.yummyadapter.demo.adapter.DemoAdapter;

public class EmptyViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DemoAdapter mAdapter;
    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_view);

        mAdapter = new DemoAdapter(this);
        mContainer = findViewById(R.id.container);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setEmptyView(R.layout.item_no_content, mContainer);
        mAdapter.showEmptyView();

        // mAdapter.hideEmptyView(); // Hide emptyView if new data available
        // mAdapter.isEmptyViewShown();
    }
}
