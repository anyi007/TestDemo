package com.example.lql.testdemo.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SevenFragment extends BaseFragment {


    public SevenFragment() {
        // Required empty public constructor
    }
    
    private static SevenFragment sevenFragment;

    public static SevenFragment getInstance() {
        if (sevenFragment == null) {
            sevenFragment = new SevenFragment();
        }
        return sevenFragment;
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_seven;
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

}
