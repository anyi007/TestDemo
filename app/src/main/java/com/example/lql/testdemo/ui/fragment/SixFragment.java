package com.example.lql.testdemo.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lql.testdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SixFragment extends Fragment {


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_six, container, false);
    }

}
