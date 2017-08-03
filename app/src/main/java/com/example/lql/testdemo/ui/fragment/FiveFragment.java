package com.example.lql.testdemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lql.testdemo.R;

public class FiveFragment extends Fragment {


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
