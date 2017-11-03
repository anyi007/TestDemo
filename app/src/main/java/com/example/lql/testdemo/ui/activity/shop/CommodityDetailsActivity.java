package com.example.lql.testdemo.ui.activity.shop;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.SimpleFragmentPagerAdapter;
import com.example.lql.testdemo.db.bean.shop.AddressBean;
import com.example.lql.testdemo.db.bean.shop.CommodityBean;
import com.example.lql.testdemo.db.bean.shop.UserBean;
import com.example.lql.testdemo.db.dao.shop.AddressBeanManager;
import com.example.lql.testdemo.db.dao.shop.CommodityBeanManager;
import com.example.lql.testdemo.db.dao.shop.UserBeanManager;
import com.example.lql.testdemo.ui.fragment.shop.CommodityOneFragment;
import com.example.lql.testdemo.ui.fragment.shop.CommodityTwoFragment;
import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.MyStatusBarUtil;
import com.example.lql.testdemo.utils.commodityLoadMore.PullUpToLoadMore;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;
import com.example.lql.testdemo.utils.hotWords.TagViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * 类描述：商品详情页面
 * 作  者：Admin or 李小米
 * 时  间：2017/10/19
 * 修改备注：
 */
public class CommodityDetailsActivity extends AppCompatActivity implements View.OnClickListener {


    private com.example.lql.testdemo.utils.commodityLoadMore.PullUpToLoadMore ptlm;
    private android.widget.ImageView commoditycollectionly;
    private android.widget.LinearLayout commoditycollectionllyt;
    private android.widget.LinearLayout commodityqqlyt;
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
    TextView mTagViewGroupTop;
    LinearLayout addressLy;

    RecyclerView mRecyclerView;//顶部的推荐


    TabLayout mTabLayout;
    ViewPager mViewPager;

    private SimpleFragmentPagerAdapter pagerAdapter;
    private ArrayList<Fragment> list_fragment = new ArrayList<>();                                //定义要装fragment的列表
    private ArrayList<String> list_title = new ArrayList<>();                                //定义要装fragment的列表
//    private CommodityOneFragment mOneFragment;              //商品详情fragment
//    private CommodityTwoFragment mTwoFragment;            //商品评价fragment

    Long commodityId;
    CommodityBean commodityById = null;
    String selectSize = "";


    ArrayList<CommodityBean> commodityBeanArrayList = new ArrayList<>();//为你推荐


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyStatusBarUtil.setStatusColor(CommodityDetailsActivity.this, getResources().getColor(R.color.shop_select2));
        setContentView(R.layout.activity_commodity_details);
        initView();

    }

    private void initView() {
        top_ly = (LinearLayout) findViewById(R.id.top_ly);
        back_ly = (LinearLayout) findViewById(R.id.top_back_ly);
        title_save_ly = (LinearLayout) findViewById(R.id.top_right_ly);
        top_ly.setBackgroundColor(getResources().getColor(R.color.shop_select2));
        title_tv = (TextView) findViewById(R.id.top_title_tv);
        title_add_img = (ImageView) findViewById(R.id.top_add_img);
        title_save_tv = (TextView) findViewById(R.id.top_save_tv);
        title_tv.setText("商品详情");
        back_ly.setOnClickListener(this);
//        title_save_ly.setOnClickListener(this);
        title_save_ly.setVisibility(View.INVISIBLE);

        this.commoditybuyimmediately = (LinearLayout) findViewById(R.id.commodity_buy_immediately);
        this.commodityaddshopcar = (LinearLayout) findViewById(R.id.commodity_add_shop_car);
        this.commoditycollectionllyt = (LinearLayout) findViewById(R.id.commodity_collection_llyt);
        this.commodityqqlyt = (LinearLayout) findViewById(R.id.commodity_qq_ly);
        this.commoditycollectionly = (ImageView) findViewById(R.id.commodity_collection_ly);
        this.ptlm = (PullUpToLoadMore) findViewById(R.id.ptlm);


        commodityqqlyt.setOnClickListener(this);
        //第一个页面里边的
        mBGABanner = (BGABanner) findViewById(R.id.commodity_top_banner);
        commodityName = (TextView) findViewById(R.id.commodity_top_name);
        mTagViewGroup = (TagViewGroup) findViewById(R.id.commodity_top_size);
        mTagViewGroupTop = (TextView) findViewById(R.id.commodity_top_size_top);
        addressTv = (TextView) findViewById(R.id.commodity_top_address);
        addressLy = (LinearLayout) findViewById(R.id.commodity_top_address_ly);
        mRecyclerView = (RecyclerView) findViewById(R.id.commodity_top_recy);


        //第二个页面的
        mTabLayout = (TabLayout) findViewById(R.id.commodity_bottom_tabs);
        mViewPager = (ViewPager) findViewById(R.id.commodity_bottom_viewpager);


        list_title.add("商品详情");
        list_title.add("商品评价");

        list_fragment.add(CommodityOneFragment.getInstance());
        list_fragment.add(CommodityTwoFragment.getInstance());


        pagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this, list_fragment, list_title);
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        commodityId = getIntent().getLongExtra("commodityId", -1);


        commodityById = CommodityBeanManager.getCommodityById(commodityId);

        setView();
    }

    private void setView() {
        if (commodityById != null) {
            //设置图片
            String[] split = commodityById.getCommodityPic().split(",");
            ArrayList<String> mPicList = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                mPicList.add(split[i]);
            }

            ArrayList<String> mList = new ArrayList<>();
            for (int i = 0; i < mPicList.size(); i++) {
                mList.add("");
            }

            mBGABanner.setData(mPicList, mList);
            mBGABanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
                @Override
                public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                    GlidePicUtils.LoadImg(CommodityDetailsActivity.this, itemView, model);
                }
            });

            //设置名称和价格
            String commoditynameStr = "￥" + commodityById.getCommodityPrice() + "  " + commodityById.getCommodityName();
            SpannableString spannableString = new SpannableString(commoditynameStr);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#FF0000"));
            spannableString.setSpan(foregroundColorSpan, 0, (commodityById.getCommodityPrice() + "").length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

            commodityName.setText(spannableString);

            //设置规格
            if (commodityById.getCommoditySize() != null) {
                String[] splitSize = commodityById.getCommoditySize().split(",");
                ArrayList<String> mSizeList = new ArrayList<>();
                for (int i = 0; i < splitSize.length; i++) {
                    mSizeList.add(splitSize[i]);
                }
                TagViewGroup.UiConfig config = new TagViewGroup.UiConfig();
                config.setContainerPadding(0);
                config.setButtonTextColor(0xFF111111, 0xFF111111);
                config.setButtonBackgroundResource(R.drawable.hot_keyword_bg_selector);

                mTagViewGroup.setData(config, mList, new TagViewGroup.OnSelectedListener() {
                    @Override
                    public void onSelected(String name) {
//                        Toast.makeText(getBaseContext(), name, Toast.LENGTH_SHORT).show();
                        selectSize = name;
                    }
                });
            } else {
                mTagViewGroup.setVisibility(View.GONE);
                mTagViewGroupTop.setVisibility(View.GONE);
            }

            //收获地址
            UserBean userBean = UserBeanManager.getUserBean();
            List<AddressBean> addressBeen = AddressBeanManager.LoadAllByUserId(userBean.getUserId());
            if (addressBeen != null && addressBeen.size() != 0) {
                boolean m = false;
                for (int i = 0; i < addressBeen.size(); i++) {
                    if (addressBeen.get(i).getDefaultAddress()) {
                        m = true;
                        addressTv.setText("配送至：" + addressBeen.get(i).getCity() + addressBeen.get(i).getArea() + addressBeen.get(i).getDetailedAddress());
                    }
                }

                if (!m) {
                    addressTv.setText("配送至：" + addressBeen.get(0).getCity() + addressBeen.get(0).getArea() + addressBeen.get(0).getDetailedAddress());
                }
            } else {
                addressTv.setText("请添加收货地址");
            }


            //为你推荐
            List<CommodityBean> commodityBeen = CommodityBeanManager.LoadCommodityByType(commodityById.getCommodityTypeId());

            for (int i = 0; i < commodityBeen.size(); i++) {
                if (commodityBeen.get(i).getCommodityId() != commodityById.getCommodityTypeId()) {
                    commodityBeanArrayList.add(commodityBeen.get(i));
                }
            }

//            int number = commodityBeanArrayList.size();
//            mRecyclerView.setLayoutManager(new GridLayoutManager(this, number));
//            mRecyclerView.setAdapter(new );

        } else {
            LogUtils.Loge("没有这个商品：" + commodityId);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commodity_qq_ly:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mqq://im/chat?chat_type=crm&uin=1538818231")));
                break;
            case R.id.top_back_ly:
                finish();
                break;

            default:
                break;
        }
    }


}
