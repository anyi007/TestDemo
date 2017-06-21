package com.example.lql.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lql.testdemo.ui.BigPicActivity;
import com.example.lql.testdemo.ui.GildeActivity;
import com.example.lql.testdemo.ui.HotwordsActivity;
import com.example.lql.testdemo.ui.SeekbarActivity;
import com.example.lql.testdemo.ui.ShimmerlayoutActivity;
import com.example.lql.testdemo.ui.SweetAlertDialogActivity;
import com.example.lql.testdemo.utils.chooseDateUtils.DateUtils;
import com.example.lql.testdemo.utils.chooseDateUtils.OnoptionsUtils;
import com.example.lql.testdemo.utils.pickerview.TimePopupWindow;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private android.widget.Button glidebutton;
    private android.widget.Button hotwords_button;
    private android.widget.Button seekbar_button;
    private android.widget.Button choose_time_button;
    private android.widget.Button Dialog_button;
    private android.widget.Button shimmerlayout_button;
    private android.widget.Button bigpic_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //glide4.x
        this.glidebutton = (Button) findViewById(R.id.glide_button);
        this.glidebutton.setOnClickListener(this);

        //热词搜索+商品规格单选
        this.hotwords_button = (Button) findViewById(R.id.hotwords_button);
        this.hotwords_button.setOnClickListener(this);

        //改变一下seekbar的背景颜色
        this.seekbar_button = (Button) findViewById(R.id.seekbar_button);
        this.seekbar_button.setOnClickListener(this);

        //选择时间
        this.choose_time_button = (Button) findViewById(R.id.choose_time_button);
        this.choose_time_button.setOnClickListener(this);

        //一个对话框
        this.Dialog_button = (Button) findViewById(R.id.Dialog_button);
        this.Dialog_button.setOnClickListener(this);

        //加载过程中的布局闪光效果
        this.shimmerlayout_button = (Button) findViewById(R.id.shimmerlayout_button);
        this.shimmerlayout_button.setOnClickListener(this);

        //加载过程中的布局闪光效果
        this.bigpic_button = (Button) findViewById(R.id.bigpic_button);
        this.bigpic_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.glide_button:
                startActivity(new Intent(MainActivity.this , GildeActivity.class));
                break;
            case R.id.hotwords_button:
                startActivity(new Intent(MainActivity.this , HotwordsActivity.class));
                break;
            case R.id.seekbar_button:
                startActivity(new Intent(MainActivity.this , SeekbarActivity.class));
                break;
            case R.id.choose_time_button:
                OnoptionsUtils.showDateSelect(MainActivity.this, choose_time_button, new TimePopupWindow.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {
                        choose_time_button.setText(DateUtils.format(date));
                    }
                });
                break;
            case R.id.Dialog_button:
                startActivity(new Intent(MainActivity.this , SweetAlertDialogActivity.class));
                break;
            case R.id.shimmerlayout_button:
                startActivity(new Intent(MainActivity.this , ShimmerlayoutActivity.class));
                break;
            case R.id.bigpic_button:
                startActivity(new Intent(MainActivity.this , BigPicActivity.class));
                break;
        }
    }
}
