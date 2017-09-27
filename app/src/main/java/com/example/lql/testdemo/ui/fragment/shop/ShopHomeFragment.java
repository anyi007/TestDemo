package com.example.lql.testdemo.ui.fragment.shop;

import android.os.Bundle;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * 类描述：商城模块---》首页
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class ShopHomeFragment extends BaseFragment {

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

    }


}
