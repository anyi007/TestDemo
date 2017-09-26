package com.example.lql.testdemo.ui.fragment;


import android.support.v4.app.Fragment;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FourFragment extends BaseFragment {


    public FourFragment() {
        // Required empty public constructor
    }

    private static FourFragment fourFragment;

    public static FourFragment getInstance() {
        if (fourFragment == null) {
            fourFragment = new FourFragment();
        }
        return fourFragment;
    }



    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_four;
    }

}
