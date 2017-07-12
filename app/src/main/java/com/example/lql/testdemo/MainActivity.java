package com.example.lql.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lql.testdemo.ui.activity.BigPicActivity;
import com.example.lql.testdemo.ui.activity.CoordinatorLayoutActivity;
import com.example.lql.testdemo.ui.activity.GildeActivity;
import com.example.lql.testdemo.ui.activity.HotwordsActivity;
import com.example.lql.testdemo.ui.activity.SeekbarActivity;
import com.example.lql.testdemo.ui.activity.ShimmerlayoutActivity;
import com.example.lql.testdemo.ui.activity.SideslipActivity;
import com.example.lql.testdemo.ui.activity.SweetAlertDialogActivity;
import com.example.lql.testdemo.ui.activity.VideoListActivity;
import com.example.lql.testdemo.utils.chooseDateUtils.DateUtils;
import com.example.lql.testdemo.utils.chooseDateUtils.OnoptionsUtils;
import com.example.lql.testdemo.utils.pickerview.TimePopupWindow;

import java.util.Date;

import static com.example.lql.testdemo.R.id.choose_time_button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private android.widget.Button glidebutton;
    private android.widget.Button hotwordsButton;
    private android.widget.Button seekbarButton;
    private android.widget.Button choose_time_Button;
    private android.widget.Button DialogButton;
    private android.widget.Button shimmerlayoutButton;
    private android.widget.Button bigpicButton;
    private android.widget.Button SideslipButton;
    private android.widget.Button CoordinatorLayoutButton;
    private android.widget.Button VideolistButton;

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
        this.hotwordsButton = (Button) findViewById(R.id.hotwords_button);
        this.hotwordsButton.setOnClickListener(this);

        //改变一下seekbar的背景颜色
        this.seekbarButton = (Button) findViewById(R.id.seekbar_button);
        this.seekbarButton.setOnClickListener(this);

        //选择时间
        this.choose_time_Button = (Button) findViewById(choose_time_button);
        this.choose_time_Button.setOnClickListener(this);

        //一个对话框
        this.DialogButton = (Button) findViewById(R.id.Dialog_button);
        this.DialogButton.setOnClickListener(this);

        //加载过程中的布局闪光效果
        this.shimmerlayoutButton = (Button) findViewById(R.id.shimmerlayout_button);
        this.shimmerlayoutButton.setOnClickListener(this);

        //查看大图
        this.bigpicButton = (Button) findViewById(R.id.bigpic_button);
        this.bigpicButton.setOnClickListener(this);

        //list侧滑
        this.SideslipButton = (Button) findViewById(R.id.sideslip_button);
        this.SideslipButton.setOnClickListener(this);

        //CoordinatorLayout
        this.CoordinatorLayoutButton = (Button) findViewById(R.id.CoordinatorLayout_button);
        this.CoordinatorLayoutButton.setOnClickListener(this);

        //一个视频播放列表
        this.VideolistButton = (Button) findViewById(R.id.videolist_button);
        this.VideolistButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.glide_button:
                startActivity(new Intent(MainActivity.this, GildeActivity.class));
                break;
            case R.id.hotwords_button:
                startActivity(new Intent(MainActivity.this, HotwordsActivity.class));
                break;
            case R.id.seekbar_button:
                startActivity(new Intent(MainActivity.this, SeekbarActivity.class));
                break;
            case choose_time_button:
                OnoptionsUtils.showDateSelect(MainActivity.this, choose_time_Button, new TimePopupWindow.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {
                        choose_time_Button.setText(DateUtils.format(date));
                    }
                });
                break;
            case R.id.Dialog_button:
                startActivity(new Intent(MainActivity.this, SweetAlertDialogActivity.class));
                break;
            case R.id.shimmerlayout_button:
                startActivity(new Intent(MainActivity.this, ShimmerlayoutActivity.class));
                break;
            case R.id.bigpic_button:
                startActivity(new Intent(MainActivity.this, BigPicActivity.class));
                break;
            case R.id.sideslip_button:
                startActivity(new Intent(MainActivity.this, SideslipActivity.class));
                break;
            case R.id.CoordinatorLayout_button:
                startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity.class));
                break;
            case R.id.videolist_button:
                startActivity(new Intent(MainActivity.this, VideoListActivity.class));
                break;

        }
    }
}
