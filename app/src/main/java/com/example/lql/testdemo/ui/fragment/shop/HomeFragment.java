package com.example.lql.testdemo.ui.fragment.shop;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * 类描述：商城模块---》首页
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class HomeFragment extends BaseFragment {

    public HomeFragment() {

    }

    private static HomeFragment mHomeFragment;

    public static HomeFragment getInstance() {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        return mHomeFragment;
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_shop_main;
    }
}
