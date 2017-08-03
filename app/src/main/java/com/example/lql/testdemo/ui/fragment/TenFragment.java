package com.example.lql.testdemo.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ten, container, false);
    }

}
