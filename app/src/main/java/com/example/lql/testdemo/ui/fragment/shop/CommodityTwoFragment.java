package com.example.lql.testdemo.ui.fragment.shop;

import android.os.Bundle;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;
import com.example.lql.testdemo.utils.commodityLoadMore.MyScrollView;
import com.example.lql.testdemo.utils.commodityLoadMore.PublicStaticClass;

/**
 * 类描述：商品详情右边的fragment
 * 作  者：Admin or 李小米
 * 时  间：2017/10/20
 * 修改备注：
 */
public class CommodityTwoFragment extends BaseFragment {

    public CommodityTwoFragment() {

    }

    private static CommodityTwoFragment mCommodityTwoFragment;

    public static CommodityTwoFragment getInstance() {
        if (mCommodityTwoFragment == null) {
            synchronized (CommodityTwoFragment.class) {
                if (mCommodityTwoFragment == null) {
                    mCommodityTwoFragment = new CommodityTwoFragment();
                }
            }
        }
        return mCommodityTwoFragment;
    }

    MyScrollView mMyScrollView;

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_commodity_two;
    }

    @Override
    protected void initData() {
//        EventBus.getDefault().register(this);

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mMyScrollView = (MyScrollView) rootView.findViewById(R.id.fragment_commodity_two_scro);
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
