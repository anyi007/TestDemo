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
public class ShopMineFragment extends BaseFragment {
    public ShopMineFragment() {

    }

    private static ShopMineFragment mMineFragment;

    public static ShopMineFragment getInstance() {
        if (mMineFragment == null) {
            mMineFragment = new ShopMineFragment();
        }
        return mMineFragment;
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_shop_mine;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

    }




}
