package com.example.lql.testdemo.ui.fragment;


import android.support.v4.app.Fragment;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SixFragment extends BaseFragment {


    public SixFragment() {
        // Required empty public constructor
    }

    private static SixFragment sixFragment;

    public static SixFragment getInstance() {
        if (sixFragment == null) {
            sixFragment = new SixFragment();
        }
        return sixFragment;
    }
    


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_six;
    }

}
