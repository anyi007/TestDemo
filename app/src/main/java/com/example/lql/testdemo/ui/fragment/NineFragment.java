package com.example.lql.testdemo.ui.fragment;


import android.support.v4.app.Fragment;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class NineFragment extends BaseFragment {


    public NineFragment() {
        // Required empty public constructor
    }


    private static NineFragment nineFragment;

    public static NineFragment getInstance() {
        if (nineFragment == null) {
            nineFragment = new NineFragment();
        }
        return nineFragment;
    }



    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_nine;
    }

}
