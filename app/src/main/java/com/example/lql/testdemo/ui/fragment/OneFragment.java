package com.example.lql.testdemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lql.testdemo.R;

/**
 * Created by Admin on 2017/7/25.
 */

public class OneFragment extends Fragment {

    public OneFragment() {
    }

    private static OneFragment oneFragment;

    public static OneFragment getInstance() {
        if (oneFragment == null) {
            oneFragment = new OneFragment();
        }
        return oneFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }
}
