package com.example.lql.testdemo.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

public class FiveFragment extends BaseFragment {


    public FiveFragment() {
        // Required empty public constructor
    }

    private static FiveFragment fiveFragment;

    public static FiveFragment getInstance() {
        if (fiveFragment == null) {
            fiveFragment = new FiveFragment();
        }
        return fiveFragment;
    }



    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_five;
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

}
