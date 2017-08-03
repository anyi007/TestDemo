package com.example.lql.testdemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_five, container, false);
    }

}
