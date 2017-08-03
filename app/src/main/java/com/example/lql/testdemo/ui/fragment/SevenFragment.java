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
public class SevenFragment extends Fragment {


    public SevenFragment() {
        // Required empty public constructor
    }
    
    private static SevenFragment sevenFragment;

    public static SevenFragment getInstance() {
        if (sevenFragment == null) {
            sevenFragment = new SevenFragment();
        }
        return sevenFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seven, container, false);
    }

}
