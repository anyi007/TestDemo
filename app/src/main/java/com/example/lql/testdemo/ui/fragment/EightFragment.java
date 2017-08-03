package com.example.lql.testdemo.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lql.testdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EightFragment extends Fragment {


    public EightFragment() {
        // Required empty public constructor
    }

    private static EightFragment eightFragment;

    public static EightFragment getInstance() {
        if (eightFragment == null) {
                       eightFragment = new EightFragment();
        }
        return eightFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eight, container, false);
    }

}
