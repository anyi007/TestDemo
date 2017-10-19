package com.example.lql.testdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.ui.BaseActivity;
import com.example.lql.testdemo.utils.ScreenUtils;

/**
 * 类描述：测试页面
 * 作  者：Admin or 李小米
 * 时  间：2017/10/11
 * 修改备注：
 */
public class TestActivity extends BaseActivity {


    private android.widget.TextView testactivitytv1;
    private android.widget.Button testactivitybtu1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        this.testactivitybtu1 = (Button) findViewById(R.id.testactivity_btu1);
        this.testactivitytv1 = (TextView) findViewById(R.id.testactivity_tv1);
        testactivitybtu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) testactivitytv1.getLayoutParams(); //取控件textView当前的布局参数
                linearParams.height = (ScreenUtils.getScreenHeight(TestActivity.this) / 2);// 控件的高强制设成***
                testactivitytv1.setLayoutParams(linearParams); //使设置好的布局参数应用到控件
            }
        });
    }
}
