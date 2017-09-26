package com.example.lql.testdemo.ui.fragment;


import android.support.v4.app.Fragment;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class EightFragment extends BaseFragment {


    public EightFragment() {

    }

    private static EightFragment eightFragment;

    public static EightFragment getInstance() {
        if (eightFragment == null) {
                       eightFragment = new EightFragment();
        }
        return eightFragment;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_eight;
    }

}
