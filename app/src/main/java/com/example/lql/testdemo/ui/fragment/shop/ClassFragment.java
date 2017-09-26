package com.example.lql.testdemo.ui.fragment.shop;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class ClassFragment extends BaseFragment {
    public ClassFragment() {

    }

    private static ClassFragment mClassFragment;

    public static ClassFragment getInstance() {
        if (mClassFragment == null) {
            mClassFragment = new ClassFragment();
        }
        return mClassFragment;
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_shop_class;
    }

}
