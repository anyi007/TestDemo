package com.example.lql.testdemo.ui.activity.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.fragment.OneFragment;
import com.example.lql.testdemo.ui.fragment.TwoFragment;
import com.example.lql.testdemo.utils.MyStatusBarUtil;
import com.example.lql.testdemo.utils.commodityLoadMore.PullUpToLoadMore;
import com.example.lql.testdemo.utils.hotWords.TagViewGroup;

import java.util.ArrayList;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * 类描述：商品详情页面
 * 作  者：Admin or 李小米
 * 时  间：2017/10/19
 * 修改备注：
 */
public class CommodityDetailsActivity extends AppCompatActivity implements View.OnClickListener{


    private com.example.lql.testdemo.utils.commodityLoadMore.PullUpToLoadMore ptlm;
    private android.widget.ImageView commoditycollectionly;
    private android.widget.LinearLayout commoditycollectionllyt;
    private android.widget.LinearLayout commodityaddshopcar;
    private android.widget.LinearLayout commoditybuyimmediately;

    private LinearLayout top_ly;//整个布局
    private LinearLayout back_ly;//返回按钮
    private TextView title_tv;//标题
    private LinearLayout title_save_ly;//保存按钮
    private TextView title_save_tv;//右侧文字
    private ImageView title_add_img;//右侧图标


    BGABanner mBGABanner;
    TextView commodityName;
    TextView addressTv;
    TagViewGroup mTagViewGroup;
    LinearLayout addressLy;

    RecyclerView mRecyclerView;//顶部的推荐


    TabLayout mTabLayout;
    ViewPager mViewPager;


    private ArrayList<Fragment> list_fragment = new ArrayList<>();                                //定义要装fragment的列表
    private ArrayList<String> list_title = new ArrayList<>();                                //定义要装fragment的列表
    private OneFragment mOneFragment;              //热门推荐fragment
    private TwoFragment mTwoFragment;            //热门收藏fragment


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyStatusBarUtil.setStatusColor(CommodityDetailsActivity.this, getResources().getColor(R.color.shop_select1));
        setContentView(R.layout.activity_commodity_details);
        initView();
    }

    private void initView() {
        top_ly = (LinearLayout) findViewById(R.id.top_ly);
        back_ly = (LinearLayout) findViewById(R.id.top_back_ly);
        title_save_ly = (LinearLayout) findViewById(R.id.top_right_ly);
        title_tv = (TextView) findViewById(R.id.top_title_tv);
        title_add_img = (ImageView) findViewById(R.id.top_add_img);
        title_save_tv = (TextView) findViewById(R.id.top_save_tv);
        title_tv.setText("");
        back_ly.setOnClickListener(this);
        title_save_ly.setOnClickListener(this);
        title_add_img.setVisibility(View.INVISIBLE);

        this.commoditybuyimmediately = (LinearLayout) findViewById(R.id.commodity_buy_immediately);
        this.commodityaddshopcar = (LinearLayout) findViewById(R.id.commodity_add_shop_car);
        this.commoditycollectionllyt = (LinearLayout) findViewById(R.id.commodity_collection_llyt);
        this.commoditycollectionly = (ImageView) findViewById(R.id.commodity_collection_ly);
        this.ptlm = (PullUpToLoadMore) findViewById(R.id.ptlm);


        //第一个页面里边的
        mBGABanner = (BGABanner) findViewById(R.id.commodity_top_banner);
        commodityName = (TextView) findViewById(R.id.commodity_top_name);
        mTagViewGroup = (TagViewGroup) findViewById(R.id.commodity_top_size);
        addressTv = (TextView) findViewById(R.id.commodity_top_address);
        addressLy = (LinearLayout) findViewById(R.id.commodity_top_address_ly);
        mRecyclerView = (RecyclerView) findViewById(R.id.commodity_top_recy);


        //第二个页面的
        mTabLayout = (TabLayout) findViewById(R.id.commodity_bottom_tabs);
        mViewPager = (ViewPager) findViewById(R.id.commodity_bottom_viewpager);


        list_title.add("商品详情");
        list_title.add("商品评价");

    }

    @Override
    public void onClick(View view) {

    }
}
