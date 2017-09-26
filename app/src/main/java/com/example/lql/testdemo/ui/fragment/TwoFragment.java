package com.example.lql.testdemo.ui.fragment;


import android.support.v4.app.Fragment;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends BaseFragment {


    public TwoFragment() {
        // Required empty public constructor
    }

    private static TwoFragment twoFragment;

    public static TwoFragment getInstance() {
        if (twoFragment == null) {
            twoFragment = new TwoFragment();
        }
        return twoFragment;
    }



    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_two;
    }

}
