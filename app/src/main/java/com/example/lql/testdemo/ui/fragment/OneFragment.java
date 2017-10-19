package com.example.lql.testdemo.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseFragment;

/**
 * Created by Admin on 2017/7/25.
 */

public class OneFragment extends BaseFragment {

    TextInputLayout nameTL;
    TextInputLayout passwordTL;
    Button loginButton;

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
    protected int provideContentViewId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        nameTL = (TextInputLayout) rootView.findViewById(R.id.user_name_ly);

        passwordTL = (TextInputLayout) rootView.findViewById(R.id.user_password_ly);
        loginButton = (Button) rootView.findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameTL.getEditText().getText().toString().equals("")) {
                    nameTL.setError("请输入用户名");
                    nameTL.setErrorEnabled(true);
                    return;
                }

                if (passwordTL.getEditText().getText().toString().length() < 6) {
                    passwordTL.setError("密码错误");
                    passwordTL.setErrorEnabled(true);
                    return;

                }

                nameTL.setErrorEnabled(false);
                passwordTL.setErrorEnabled(false);

                Snackbar.make(loginButton, "登录成功", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void initData() {

    }
}
