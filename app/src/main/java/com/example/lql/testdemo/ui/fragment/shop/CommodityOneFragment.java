package com.example.lql.testdemo.ui.fragment.shop;

import android.os.Bundle;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;
import com.example.lql.testdemo.utils.commodityLoadMore.MyScrollView;
import com.example.lql.testdemo.utils.commodityLoadMore.PublicStaticClass;

/**
 * 类描述：商品详情左边的fragment
 * 作  者：Admin or 李小米
 * 时  间：2017/10/20
 * 修改备注：
 */
public class CommodityOneFragment extends BaseFragment {

    public CommodityOneFragment() {

    }

    private static CommodityOneFragment mCommodityOneFragment;

    public static CommodityOneFragment getInstance() {
        if (mCommodityOneFragment == null) {
            synchronized (CommodityOneFragment.class) {
                if (mCommodityOneFragment == null) {
                    mCommodityOneFragment = new CommodityOneFragment();
                }
            }
        }
        return mCommodityOneFragment;
    }


    MyScrollView mMyScrollView;


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_commodity_one;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mMyScrollView= (MyScrollView) rootView.findViewById(R.id.fragment_commodity_one_scro);
        mMyScrollView.setScrollListener(new MyScrollView.ScrollListener() {
            @Override
            public void onScrollToBottom() {

            }

            @Override
            public void onScrollToTop() {

            }

            @Override
            public void onScroll(int scrollY) {
                if (scrollY == 0) {
                    PublicStaticClass.IsTop = true;
                } else {
                    PublicStaticClass.IsTop = false;
                }
            }

            @Override
            public void notBottom() {

            }

        });
    }

}
