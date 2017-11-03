package com.example.lql.testdemo.ui.fragment.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.shop.ShopHomeFragmentAdapter;
import com.example.lql.testdemo.db.bean.shop.CommodityBean;
import com.example.lql.testdemo.db.bean.shop.NoticeBean;
import com.example.lql.testdemo.db.dao.shop.CommodityBeanManager;
import com.example.lql.testdemo.db.dao.shop.NoticeBeanManager;
import com.example.lql.testdemo.ui.BaseFragment;
import com.example.lql.testdemo.ui.activity.shop.CommodityDetailsActivity;
import com.example.lql.testdemo.ui.activity.shop.NoticeListActivity;
import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;
import com.example.lql.testdemo.veiw.SwitchViewGroup;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * 类描述：商城模块---》首页
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class ShopHomeFragment extends BaseFragment {
    LRecyclerView mLRecyclerView;
    LRecyclerViewAdapter mLRecyclerViewAdapter;
    ShopHomeFragmentAdapter mShopHomeFragmentAdapter;

    ArrayList<CommodityBean> mCommodityBeanArrayList = new ArrayList<>();
    String pic1 = "https://img13.360buyimg.com/da/jfs/t8800/339/2334724795/102131/d8207111/59cb1f19Nd1d83f95.jpg";
    String pic2 = "https://img11.360buyimg.com/da/jfs/t5464/106/472798610/142359/66551a05/58ffffc8Naea1f2a2.jpg";
    String pic3 = "https://img10.360buyimg.com/da/jfs/t6820/298/2308078487/205126/bb146e27/598abe88N80fb9275.jpg";
    String pic4 = "https://img12.360buyimg.com/babel/jfs/t10852/284/437237991/115878/cc8049c6/59cf21a8N65cb34b3.jpg";
    String pic5 = "https://img20.360buyimg.com/da/jfs/t9163/71/400427467/41277/8dbf5f28/59a7a48aN7a42d3fe.jpg";

    ArrayList<String> bagList = new ArrayList<>();

    SwitchViewGroup mSwitchViewGroup;
    BGABanner mContentBanner;
    View headView;

    public ShopHomeFragment() {

    }

    private static ShopHomeFragment mHomeFragment;

    public static ShopHomeFragment getInstance() {
        if (mHomeFragment == null) {
            mHomeFragment = new ShopHomeFragment();
        }
        return mHomeFragment;
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_shop_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mLRecyclerView = (LRecyclerView) rootView.findViewById(R.id.main_fragment_recy);
        headView = LayoutInflater.from(getActivity()).inflate(R.layout.head_shop_homefragment, null);
        mSwitchViewGroup = (SwitchViewGroup) headView.findViewById(R.id.switchViewGroup);
        mContentBanner = (BGABanner) headView.findViewById(R.id.banner_main_depth);
        mLRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mShopHomeFragmentAdapter = new ShopHomeFragmentAdapter(getActivity());
        mShopHomeFragmentAdapter.setList(mCommodityBeanArrayList);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mShopHomeFragmentAdapter);
        mLRecyclerViewAdapter.addHeaderView(headView);
        mLRecyclerView.setAdapter(mLRecyclerViewAdapter);
        getHotData();
        getNotic();
        getBagData();


        mLRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent mIntent = new Intent(getActivity(), CommodityDetailsActivity.class);
                mIntent.putExtra("commodityId", mCommodityBeanArrayList.get(position).getCommodityId());
                startActivity(mIntent);
            }
        });
    }


    /**
     * 获取热门商品
     */
    private void getHotData() {
        List<CommodityBean> commodityBeen = CommodityBeanManager.LoadHotCom();
        if (commodityBeen != null) {
            mCommodityBeanArrayList.addAll(commodityBeen);
            mShopHomeFragmentAdapter.setList(mCommodityBeanArrayList);
        }
    }

    /**
     * 获取公告数据
     */
    private void getNotic() {
        List<NoticeBean> noticeBeen = NoticeBeanManager.LoadAll();
        if (noticeBeen != null) {

            if (mSwitchViewGroup != null) {
                mSwitchViewGroup.addData(noticeBeen);
                mSwitchViewGroup.startScroll();
                mSwitchViewGroup.setOnClickTabListener(new SwitchViewGroup.OnClickTabListener() {
                    @Override
                    public void onClickTab(int index) {
                        //每个条目的点击事件
                        startActivity(new Intent(getActivity(), NoticeListActivity.class));
                    }
                });
                LogUtils.Loge(noticeBeen.size() + "noticeBeen");
            }
        }
    }

    /**
     * 顶部轮播图数据
     */
    private void getBagData() {
        bagList.clear();
        bagList.add(pic1);
        bagList.add(pic2);
        bagList.add(pic3);
        bagList.add(pic4);
        bagList.add(pic5);
        ArrayList<String> mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        mContentBanner.setData(bagList, mList);
        mContentBanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                GlidePicUtils.LoadImg(getActivity(), itemView, model);
            }
        });

        mContentBanner.setDelegate(new BGABanner.Delegate<ImageView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
//                Toast.makeText(banner.getContext(), "点击了" + position, Toast.LENGTH_SHORT).show();
                Log.e("###", "点击了" + position);
            }
        });
    }


}
