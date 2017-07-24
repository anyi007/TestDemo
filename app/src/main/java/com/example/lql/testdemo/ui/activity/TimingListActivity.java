package com.example.lql.testdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.TimingListAdapter;
import com.example.lql.testdemo.db.bean.TimingBean;
import com.example.lql.testdemo.db.gen.TimingBeanDao;
import com.example.lql.testdemo.utils.RecyclerView.DividerListItemDecoration;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：闹钟列表
 * 作  者：李清林
 * 时  间：2017.7.18
 * 修改备注：
 */
public class TimingListActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    TimingListAdapter mTimingListAdapter;

    ArrayList<TimingBean> mList = new ArrayList<>();
    TimingBeanDao timingBeanDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing_list);
        timingBeanDao = DBManager.getInstance().getDaoSession().getTimingBeanDao();
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.timing_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTimingListAdapter = new TimingListAdapter(TimingListActivity.this);
        mTimingListAdapter.setList(mList);
        mRecyclerView.addItemDecoration(new DividerListItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mTimingListAdapter);
        getDate();

        mTimingListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent mIntent = new Intent(TimingListActivity.this, TimingActivity.class);
                mIntent.putExtra("type", position == 0 ? "-1" : mList.get(position - 1).getMyTimingId() + "");
                startActivity(mIntent);
            }
        });
    }

    private void getDate() {
        List<TimingBean> timingBeen = timingBeanDao.loadAll();
        mList.clear();
        if (timingBeen != null && timingBeen.size() != 0) {
            mList.addAll(timingBeen);
        }
        mTimingListAdapter.setList(mList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDate();
    }
}
