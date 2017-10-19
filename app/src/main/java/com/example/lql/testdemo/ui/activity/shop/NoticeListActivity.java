package com.example.lql.testdemo.ui.activity.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.shop.NoticeListAdapter;
import com.example.lql.testdemo.db.bean.shop.NoticeBean;
import com.example.lql.testdemo.db.dao.shop.NoticeBeanManager;
import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.MyStatusBarUtil;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：商城模块---》公告页面
 * 作  者：Admin or 李小米
 * 时  间：2017/10/2
 * 修改备注：
 */
public class NoticeListActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView mRecyclerView;
    NoticeListAdapter mNoticeListAdapter;
    ArrayList<NoticeBean> mNoticeBeanArrayList = new ArrayList<>();


    private LinearLayout top_ly;//整个布局
    private LinearLayout back_ly;//返回按钮
    private TextView title_tv;//标题
    private LinearLayout title_save_ly;//保存按钮


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyStatusBarUtil.setStatusColor(NoticeListActivity.this, getResources().getColor(R.color.shop_select1));
        setContentView(R.layout.activity_notice_list);
        initView();
    }

    private void initView() {

        top_ly = (LinearLayout) findViewById(R.id.top_ly);
        back_ly = (LinearLayout) findViewById(R.id.top_back_ly);
        title_save_ly = (LinearLayout) findViewById(R.id.top_right_ly);
        title_tv = (TextView) findViewById(R.id.top_title_tv);
        top_ly.setBackgroundColor(getResources().getColor(R.color.shop_select1));
        title_tv.setText("公告");
        back_ly.setOnClickListener(this);

        title_save_ly.setVisibility(View.INVISIBLE);


        mRecyclerView = (RecyclerView) findViewById(R.id.notice_recy);
        mNoticeListAdapter = new NoticeListAdapter(this);
        mNoticeListAdapter.setList(mNoticeBeanArrayList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mNoticeListAdapter);
        getData();
        mNoticeListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent mIntent = new Intent(NoticeListActivity.this, NoticeActivity.class);
                mIntent.putExtra("noticeId", mNoticeBeanArrayList.get(position).getNoticeId());
                startActivity(mIntent);
            }
        });
    }


    private void getData() {
        List<NoticeBean> noticeBeen = NoticeBeanManager.LoadAll();
        LogUtils.Loge(noticeBeen.size()+"");
        if (noticeBeen != null) {
            mNoticeBeanArrayList.addAll(noticeBeen);
            mNoticeListAdapter.setList(mNoticeBeanArrayList);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_back_ly:
                finish();
                break;
            default:
                break;
        }
    }
}
