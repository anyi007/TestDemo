package com.example.lql.testdemo.ui.activity.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.MyStatusBarUtil;

/**
 * 类描述：关于我们
 * 作  者：Admin or 李小米
 * 时  间：2017/9/27
 * 修改备注：
 */
public class AboutUsActivity extends AppCompatActivity {
    private LinearLayout top_ly;//整个布局
    private LinearLayout back_ly;//返回按钮
    private TextView title_tv;//标题
    private LinearLayout title_save_ly;//保存按钮


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyStatusBarUtil.setStatusColor(AboutUsActivity.this, getResources().getColor(R.color.shop_select4));
        setContentView(R.layout.activity_aboutus);
        top_ly = (LinearLayout) findViewById(R.id.top_ly);
        top_ly.setBackgroundResource(R.color.shop_select4);
        back_ly = (LinearLayout) findViewById(R.id.top_back_ly);
        title_save_ly = (LinearLayout) findViewById(R.id.top_right_ly);
        title_tv = (TextView) findViewById(R.id.top_title_tv);

        title_tv.setText("About This");
        title_save_ly.setVisibility(View.INVISIBLE);

        back_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


}
