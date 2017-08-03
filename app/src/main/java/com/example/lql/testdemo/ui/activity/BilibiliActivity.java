package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.SimpleFragmentPagerAdapter;
import com.example.lql.testdemo.ui.BaseActivity;
import com.example.lql.testdemo.ui.fragment.EightFragment;
import com.example.lql.testdemo.ui.fragment.FiveFragment;
import com.example.lql.testdemo.ui.fragment.FourFragment;
import com.example.lql.testdemo.ui.fragment.NineFragment;
import com.example.lql.testdemo.ui.fragment.OneFragment;
import com.example.lql.testdemo.ui.fragment.SevenFragment;
import com.example.lql.testdemo.ui.fragment.SixFragment;
import com.example.lql.testdemo.ui.fragment.TenFragment;
import com.example.lql.testdemo.ui.fragment.ThreeFragment;
import com.example.lql.testdemo.ui.fragment.TwoFragment;
import com.example.lql.testdemo.utils.MyStatusBarUtil;
import com.example.lql.testdemo.utils.PagerSlidingTabStrip;

import java.util.ArrayList;

/**
 * 类描述：bilibili的页面好漂亮啊
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class BilibiliActivity extends BaseActivity {

    Toolbar bilibilitooolbar;
    private android.support.v4.view.ViewPager bilibiliviewpager;
    private PagerSlidingTabStrip bilibiliTabs;


    SimpleFragmentPagerAdapter mSimpleFragmentPagerAdapter;
    private ArrayList<Fragment> list_fragment = new ArrayList<>();    //定义要装fragment的列表
    private ArrayList<String> list_title = new ArrayList<>();        //定义要装fragment的title列表

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyStatusBarUtil.setStatusColor(this, getResources().getColor(R.color.colorAccent));
        setContentView(R.layout.activity_bilibili);
        initView();
    }

    private void initView() {
        this.bilibiliviewpager = (ViewPager) findViewById(R.id.bilibili_viewpager);
        this.bilibilitooolbar = (Toolbar) findViewById(R.id.bilibili_toolbar);
//        this.bilibiliTitle = (RecyclerView) findViewById(R.id.bilibili_title);
        this.bilibiliTabs = (PagerSlidingTabStrip) findViewById(R.id.bilibili_tabs);


        list_fragment.add(OneFragment.getInstance());
        list_fragment.add(TwoFragment.getInstance());
        list_fragment.add(ThreeFragment.getInstance());
        list_fragment.add(FourFragment.getInstance());
        list_fragment.add(FiveFragment.getInstance());
        list_fragment.add(SixFragment.getInstance());
        list_fragment.add(SevenFragment.getInstance());
        list_fragment.add(EightFragment.getInstance());
        list_fragment.add(NineFragment.getInstance());
        list_fragment.add(TenFragment.getInstance());


        list_title.add("全站");
        list_title.add("番剧");
        list_title.add("动漫");
        list_title.add("国创");
        list_title.add("音乐");
        list_title.add("吐槽");
        list_title.add("舞蹈");
        list_title.add("游戏");
        list_title.add("科技");
        list_title.add("电子");


        mSimpleFragmentPagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this, list_fragment, list_title);
        bilibiliviewpager.setAdapter(mSimpleFragmentPagerAdapter);


        bilibilitooolbar.setTitle("bilibili的排行页面");
        bilibilitooolbar.setTitleTextColor(getResources().getColor(R.color.color_fff));
        bilibilitooolbar.setBackgroundColor(getResources().getColor(R.color.color_bilibili));//背景色
        bilibilitooolbar.setNavigationIcon(getResources().getDrawable(R.drawable.icon_back));
        bilibilitooolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        pstsIndicatorColor Color of the sliding indicator  滑动条的颜色
//        pstsUnderlineColor Color of the full-width line on the bottom of the view  滑动条所在的那个全宽线的颜色
//        pstsDividerColor Color of the dividers between tabs   每个标签的分割线的颜色
//        pstsIndicatorHeightHeight of the sliding indicator       滑动条的高度
//        pstsUnderlineHeight Height of the full-width line on the bottom of the view    滑动条所在的那个全宽线的高度
//        pstsDividerPadding Top and bottom padding of the dividers   分割线底部和顶部的填充宽度
//        pstsTabPaddingLeftRight Left and right padding of each tab   每个标签左右填充宽度
//        pstsScrollOffset Scroll offset of the selected tab
//        pstsTabBackground Background drawable of each tab, should be a StateListDrawable 每个标签的背景，应该是一个StateListDrawable
//        pstsShouldExpand If set to true, each tab is given the same weight, default false   如果设置为true，每个标签是相同的控件，均匀平分整个屏幕，默认是false
//        pstsTextAllCaps If true, all tab titles will be upper case, default true   如果为true，所有标签都是大写字母，默认为true
        bilibiliTabs.setTextColorResource(R.color.color_fff);
        bilibiliTabs.setTextSize(50);
        bilibiliTabs.setIndicatorColorResource(R.color.color_fff);
        bilibiliTabs.setUnderlineColorResource(R.color.color_bilibili);
        bilibiliTabs.setViewPager(bilibiliviewpager);

    }


}
