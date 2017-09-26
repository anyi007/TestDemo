package com.example.lql.testdemo.ui.fragment;


import android.support.v4.app.Fragment;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TenFragment extends BaseFragment {


    public TenFragment() {
        // Required empty public constructor
    }

    private static TenFragment tenFragment;

    public static TenFragment getInstance() {
        if (tenFragment == null) {
            tenFragment = new TenFragment();
        }
        return tenFragment;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_ten;
    }

}
