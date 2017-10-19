package com.example.lql.testdemo.ui.fragment.shop;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.shop.ShopClassFragmentAdapter;
import com.example.lql.testdemo.db.bean.shop.CommodityTypeBean;
import com.example.lql.testdemo.db.dao.shop.CommodityTypeBeanManager;
import com.example.lql.testdemo.eventBus.ShopClassIdMessage;
import com.example.lql.testdemo.ui.BaseFragment;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：商城模块--》分类页面
 * 使用recyclerview+Fragment来实现，页面间的传递使用EventBus来传递事件
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class ShopClassFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    ArrayList<CommodityTypeBean> mCommodityTypeBeanArrayList = new ArrayList<>();
    ShopClassFragmentAdapter mShopClassFragmentAdapter;


    public ShopClassFragment() {

    }

    private static ShopClassFragment mClassFragment;

    public static ShopClassFragment getInstance() {
        if (mClassFragment == null) {
            mClassFragment = new ShopClassFragment();
        }
        return mClassFragment;
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_shop_class;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        ShopClassRightFragment instance = ShopClassRightFragment.getInstance();

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.shop_class_left_recy);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mShopClassFragmentAdapter = new ShopClassFragmentAdapter(getActivity());
        mShopClassFragmentAdapter.setList(mCommodityTypeBeanArrayList);
        mShopClassFragmentAdapter.setNumber(0);
        mRecyclerView.setAdapter(mShopClassFragmentAdapter);

        getChildFragmentManager().beginTransaction().add(R.id.shop_class_left_fragment, instance).commit();
        getData();


        mShopClassFragmentAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mShopClassFragmentAdapter.setNumber(position);
                EventBus.getDefault().post(new ShopClassIdMessage(mCommodityTypeBeanArrayList.get(position).getCommodityTypeId() + ""));
            }
        });

    }


    private void getData() {
        List<CommodityTypeBean> commodityTypeBeen = CommodityTypeBeanManager.LoadAll();
        if (commodityTypeBeen != null && commodityTypeBeen.size() != 0) {
            mCommodityTypeBeanArrayList.addAll(commodityTypeBeen);
            mShopClassFragmentAdapter.setList(mCommodityTypeBeanArrayList);

            EventBus.getDefault().postSticky(new ShopClassIdMessage(mCommodityTypeBeanArrayList.get(0).getCommodityTypeId() + ""));
        }
    }

}
