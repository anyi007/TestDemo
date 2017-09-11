package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.MyHRecycleAdapter;
import com.example.lql.testdemo.utils.PublicStaticData;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;

import java.util.ArrayList;


/**
 * 类描述：横向滑动的recyclerview
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class MyHRecycleActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<String> mList = new ArrayList<>();
    MyHRecycleAdapter mMyHRecycleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhrecycle);
        mRecyclerView = (RecyclerView) findViewById(R.id.myrecycler);


        for (int i = 0; i < 15; i++) {
            mList.add("小米" + i);
        }


        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mMyHRecycleAdapter = new MyHRecycleAdapter(mList, MyHRecycleActivity.this);
        mRecyclerView.setAdapter(mMyHRecycleAdapter);

        mMyHRecycleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                PublicStaticData.selectId = position;
                mMyHRecycleAdapter.notifyDataSetChanged();
            }
        });

    }
}
