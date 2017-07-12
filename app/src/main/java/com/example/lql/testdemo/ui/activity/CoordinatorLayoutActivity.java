package com.example.lql.testdemo.ui.activity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.TestTextViewAdapter;
import com.example.lql.testdemo.utils.CollapsingToolbarLayoutState;
import com.example.lql.testdemo.utils.MyStatusBarUtil;
import com.example.lql.testdemo.utils.RecyclerView.DividerListItemDecoration;
import com.example.lql.testdemo.utils.RecyclerView.MyDecoration;
import com.example.lql.testdemo.utils.T;

import java.util.ArrayList;

/**
 * 类描述：CoordinatorLayout的使用
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class CoordinatorLayoutActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar coordinatortoolbar;
    private android.support.v7.widget.RecyclerView coordinatorrecycler;
    private android.support.design.widget.FloatingActionButton coordinatorfloatingactionbutton;
    TestTextViewAdapter mTestTextViewAdapter;
    ArrayList<String> mList = new ArrayList<>();
    AppBarLayout mAppBarLayout;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    ImageView mImageView;
    private CollapsingToolbarLayoutState state;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
//        MyStatusBarUtil.setStatusColor(this, getResources().getColor(R.color.colorPrimary));
        initView();
    }

    private void initView() {
        this.coordinatorfloatingactionbutton = (FloatingActionButton) findViewById(R.id.coordinator_floatingactionbutton);
        this.coordinatorrecycler = (RecyclerView) findViewById(R.id.coordinator_recycler);
        this.coordinatortoolbar = (Toolbar) findViewById(R.id.coordinator_toolbar);
        this.mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        this.mImageView = (ImageView) findViewById(R.id.iv_coordinator_head);
        this.mAppBarLayout = (AppBarLayout) findViewById(R.id.coordinator_appBar);

        mCollapsingToolbarLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        MyStatusBarUtil.setStatusTransparent(CoordinatorLayoutActivity.this, false);//图片沉浸
        setSupportActionBar(coordinatortoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        coordinatortoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        for (int i = 0; i < 30; i++) {
            mList.add("小米" + i);
        }

        this.mImageView.setImageResource(R.drawable.testpic);

        mCollapsingToolbarLayout.setTitle("楚梦瑶");
        mCollapsingToolbarLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        // 没收缩时的字体颜色,显示在ToolBar后的字体颜色
//        mCollapsingToolbarLayout.setExpandedTitleTextColor();
//        mCollapsingToolbarLayout.setCollapsedTitleTextColor();


        coordinatorrecycler.setLayoutManager(new LinearLayoutManager(this));
        coordinatorrecycler.addItemDecoration(new DividerListItemDecoration(this, MyDecoration.HORIZONTAL_LIST));
        mTestTextViewAdapter = new TestTextViewAdapter(CoordinatorLayoutActivity.this);
        mTestTextViewAdapter.setList(mList);
        coordinatorrecycler.setAdapter(mTestTextViewAdapter);

        coordinatorfloatingactionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coordinatorfloatingactionbutton.setBackgroundTintList(ColorStateList.valueOf(0xffFF4081));
                T.shortToast(CoordinatorLayoutActivity.this, "按钮");
            }
        });

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {


//                if (verticalOffset == 0) {
//                    LogUtils.Loge("111111111");
//                    //展开状态
//                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
//                        state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
//                        mCollapsingToolbarLayout.setTitle("展开状态");//设置title为EXPANDED
//                        MyStatusBarUtil.setStatusTransparent(CoordinatorLayoutActivity.this, false);//图片沉浸
//                    }
//                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
//                    LogUtils.Loge("222222222");
//                    //收缩状态
//                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
//                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
//
//                        mCollapsingToolbarLayout.setTitle("闭合状态");//设置title显示
//                        //设置纯色沉浸
//                        MyStatusBarUtil.setStatusColor(CoordinatorLayoutActivity.this, getResources().getColor(R.color.colorAccent));
//                    }
//                } else {
//                    LogUtils.Loge("3333333333");
//
//                    if (state == CollapsingToolbarLayoutState.COLLAPSED) {
//                        //收缩-----》中间---》展开
//                        mCollapsingToolbarLayout.setTitle(" 打开打开");//设置title为EXPANDED
//                        MyStatusBarUtil.setStatusTransparent(CoordinatorLayoutActivity.this, false);//图片沉浸
//                    } else if (state == CollapsingToolbarLayoutState.EXPANDED) {
//                        //展开---》中间   -----》收缩
//                        mCollapsingToolbarLayout.setTitle("关闭关闭 ");//设置title显示
//                        //设置纯色沉浸
//                        MyStatusBarUtil.setStatusColor(CoordinatorLayoutActivity.this, getResources().getColor(R.color.colorAccent));
//                    }
//
//                    state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
//                }
            }
        });


    }
}
