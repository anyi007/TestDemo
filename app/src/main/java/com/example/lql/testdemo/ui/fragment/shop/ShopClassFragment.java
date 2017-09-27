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
public class ShopClassFragment extends BaseFragment {
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

    }



}
