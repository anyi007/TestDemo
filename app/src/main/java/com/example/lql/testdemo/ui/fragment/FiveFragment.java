package com.example.lql.testdemo.ui.fragment;

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

}
