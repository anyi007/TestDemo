package com.example.lql.testdemo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by Admin on 2017/8/3.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initData();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobclickAgent.setCatchUncaughtExceptions(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = null;
        if (0 != provideContentViewId()) {
            rootView = inflater.inflate(provideContentViewId(), container, false);
        }
        initView(rootView, savedInstanceState);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(getActivity());
    }

    /**
     * 引用布局
     *
     * @return 布局的resId
     */
    protected abstract int provideContentViewId();

    /**
     * 初始化Data
     */
    protected abstract void initData();

    /**
     * 初始化视图控件
     */
    protected abstract void initView(View rootView, Bundle savedInstanceState);




}
