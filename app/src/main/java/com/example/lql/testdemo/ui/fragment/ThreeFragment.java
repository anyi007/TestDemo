package com.example.lql.testdemo.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends BaseFragment {


    public ThreeFragment() {
        // Required empty public constructor
    }
    
    private static ThreeFragment threeFragment;

    public static ThreeFragment getInstance() {
        if (threeFragment == null) {
            threeFragment = new ThreeFragment();
        }
        return threeFragment;
    }



    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_three;
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

}
