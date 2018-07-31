package com.chuandong.yummyadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_multi_type:
                this.startActivity(new Intent(this, MultiTypeActivity.class));
                break;
            case R.id.btn_empty_view:
                this.startActivity(new Intent(this, EmptyViewActivity.class));
                break;
            case R.id.btn_load_more:
                this.startActivity(new Intent(this, MultiTypeLoadMoreActivity.class));
                break;
        }
    }
}
