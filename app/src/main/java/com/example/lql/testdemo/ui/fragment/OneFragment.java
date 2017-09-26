package com.example.lql.testdemo.ui.fragment;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * Created by Admin on 2017/7/25.
 */

public class OneFragment extends BaseFragment {

    public OneFragment() {
    }

    private static OneFragment oneFragment;

    public static OneFragment getInstance() {
        if (oneFragment == null) {
            oneFragment = new OneFragment();
        }
        return oneFragment;
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_one;
    }
}
