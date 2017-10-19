package com.example.lql.testdemo.ui.fragment.shop;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.shop.ShopClassFragmentRightAdapter;
import com.example.lql.testdemo.db.bean.shop.CommodityBean;
import com.example.lql.testdemo.db.dao.shop.CommodityBeanManager;
import com.example.lql.testdemo.eventBus.ShopClassIdMessage;
import com.example.lql.testdemo.ui.BaseFragment;
import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：商城模块右侧
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class ShopClassRightFragment extends BaseFragment {
    public ShopClassRightFragment() {

    }

    private static ShopClassRightFragment mClassFragment;

    public static ShopClassRightFragment getInstance() {
        if (mClassFragment == null) {
            mClassFragment = new ShopClassRightFragment();
        }
        return mClassFragment;
    }

    ArrayList<CommodityBean> mCommodityBeanArrayList = new ArrayList<>();

    RecyclerView mRecyclerView;

    ShopClassFragmentRightAdapter mShopClassFragmentRightAdapter;

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_shop_class_right;
    }

    @Override
    protected void initData() {
//        //注册事件
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.class_right_recy);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mShopClassFragmentRightAdapter = new ShopClassFragmentRightAdapter(getActivity());
        mShopClassFragmentRightAdapter.setList(mCommodityBeanArrayList);
        mRecyclerView.setAdapter(mShopClassFragmentRightAdapter);
        mShopClassFragmentRightAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMoonEvent(ShopClassIdMessage messageEvent) {
        LogUtils.Loge("收到的id:" + messageEvent.getMessage());
        getData(Long.parseLong(messageEvent.getMessage()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    private void getData(Long ClassTypeId) {
        List<CommodityBean> commodityBeen = CommodityBeanManager.LoadCommodityByType(ClassTypeId);
        mCommodityBeanArrayList.clear();
        mCommodityBeanArrayList.addAll(commodityBeen);
        mShopClassFragmentRightAdapter.setList(mCommodityBeanArrayList);
    }
}
