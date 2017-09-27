package com.example.lql.testdemo.ui.fragment.shop;

import android.os.Bundle;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class ShopCartFragment extends BaseFragment {
    public ShopCartFragment() {

    }

    private static ShopCartFragment mShopCartFragment;

    public static ShopCartFragment getInstance() {
        if (mShopCartFragment == null) {
            mShopCartFragment = new ShopCartFragment();
        }
        return mShopCartFragment;
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_shop_cart;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

    }



}
