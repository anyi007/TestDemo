package com.example.lql.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lql.testdemo.ui.activity.BigPicActivity;
import com.example.lql.testdemo.ui.activity.BilibiliActivity;
import com.example.lql.testdemo.ui.activity.CoordinatorLayoutActivity;
import com.example.lql.testdemo.ui.activity.EventBusActivity;
import com.example.lql.testdemo.ui.activity.FloatingactionButtonActivity;
import com.example.lql.testdemo.ui.activity.GildeActivity;
import com.example.lql.testdemo.ui.activity.HotwordsActivity;
import com.example.lql.testdemo.ui.activity.MyHRecycleActivity;
import com.example.lql.testdemo.ui.activity.RecyclerviewCardGalleryActivity;
import com.example.lql.testdemo.ui.activity.RetrofitActivity;
import com.example.lql.testdemo.ui.activity.RxJavaActivity;
import com.example.lql.testdemo.ui.activity.SeekbarActivity;
import com.example.lql.testdemo.ui.activity.ShimmerlayoutActivity;
import com.example.lql.testdemo.ui.activity.SideslipActivity;
import com.example.lql.testdemo.ui.activity.SweetAlertDialogActivity;
import com.example.lql.testdemo.ui.activity.TimingListActivity;
import com.example.lql.testdemo.ui.activity.VideoListActivity;
import com.example.lql.testdemo.utils.chooseDateUtils.DateUtils;
import com.example.lql.testdemo.utils.chooseDateUtils.OnoptionsUtils;
import com.example.lql.testdemo.utils.pickerview.TimePopupWindow;

import java.util.Date;

import static com.example.lql.testdemo.R.id.choose_time_button;


/**
 * 在页面中没有展示出来的部分：
 * 1、全局异常监听（使用查看Application）
 * 2、GreenDao的使用（在闹钟部分有）
 */

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
    private android.widget.Button RecyclerviewCardGalleryButton;
    private android.widget.Button FloatingactionButton;
    private android.widget.Button TimingButton;
    private android.widget.Button BilibiliButton;
    private android.widget.Button SetviewButton;
    private android.widget.Button RxJavaButton;
    private android.widget.Button RetrofitButton;
    private android.widget.Button RecyclerviewButton;
    private android.widget.Button EventBusButton;


//    MoveImageview mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {


//        mImageView = (MoveImageview) findViewById(R.id.setView_img);


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

        //Recyclerview实现一个画廊效果
        this.RecyclerviewCardGalleryButton = (Button) findViewById(R.id.recyclerviewCardGallery_button);
        this.RecyclerviewCardGalleryButton.setOnClickListener(this);

        //一个好看的FloatingactionButton，能弹出来几个按钮
        this.FloatingactionButton = (Button) findViewById(R.id.floatingaction_button);
        this.FloatingactionButton.setOnClickListener(this);

        //闹钟实现定时任务
        this.TimingButton = (Button) findViewById(R.id.timing_button);
        this.TimingButton.setOnClickListener(this);

        //bilibili排行页面
        this.BilibiliButton = (Button) findViewById(R.id.bilibili_button);
        this.BilibiliButton.setOnClickListener(this);


        //动态设置veiw的距离
        this.SetviewButton = (Button) findViewById(R.id.setview_button);
        this.SetviewButton.setOnClickListener(this);

        //RxJava
        this.RxJavaButton = (Button) findViewById(R.id.rxJava_button);
        this.RxJavaButton.setOnClickListener(this);

        //Retrofit
        this.RetrofitButton = (Button) findViewById(R.id.retrofit_button);
        this.RetrofitButton.setOnClickListener(this);

        //横向的recyclerview
        this.RecyclerviewButton = (Button) findViewById(R.id.recyclerview_button);
        this.RecyclerviewButton.setOnClickListener(this);

        //事件总线
        this.EventBusButton = (Button) findViewById(R.id.EventBus_button);
        this.EventBusButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.glide_button://glide4.x
                startActivity(new Intent(MainActivity.this, GildeActivity.class));
                break;

            case R.id.hotwords_button://热词搜索+商品规格单选
                startActivity(new Intent(MainActivity.this, HotwordsActivity.class));
                break;

            case R.id.seekbar_button://改变一下seekbar的背景颜色
                startActivity(new Intent(MainActivity.this, SeekbarActivity.class));
                break;

            case choose_time_button://选择时间
                OnoptionsUtils.showDateSelect(MainActivity.this, choose_time_Button, new TimePopupWindow.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {
                        choose_time_Button.setText(DateUtils.format(date));
                    }
                });
                break;

            case R.id.Dialog_button://一个对话框
                startActivity(new Intent(MainActivity.this, SweetAlertDialogActivity.class));
                break;

            case R.id.shimmerlayout_button://加载过程中的布局闪光效果
                startActivity(new Intent(MainActivity.this, ShimmerlayoutActivity.class));
                break;

            case R.id.bigpic_button://查看大图
                startActivity(new Intent(MainActivity.this, BigPicActivity.class));
                break;

            case R.id.sideslip_button: //list侧滑
                startActivity(new Intent(MainActivity.this, SideslipActivity.class));
                break;

            case R.id.CoordinatorLayout_button: //CoordinatorLayout
                startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity.class));
                break;

            case R.id.videolist_button: //视频列表
                startActivity(new Intent(MainActivity.this, VideoListActivity.class));
                break;

            case R.id.recyclerviewCardGallery_button://Recyclerview实现一个画廊效果
                startActivity(new Intent(MainActivity.this, RecyclerviewCardGalleryActivity.class));
                break;

            case R.id.floatingaction_button: //一个好看的FloatingactionButton，能弹出来几个按钮
                startActivity(new Intent(MainActivity.this, FloatingactionButtonActivity.class));
                break;

            case R.id.timing_button://闹钟实现定时任务
                startActivity(new Intent(MainActivity.this, TimingListActivity.class));
                break;

            case R.id.bilibili_button://bilibili排行页面
                startActivity(new Intent(MainActivity.this, BilibiliActivity.class));
                break;

            case R.id.setview_button://动态设置veiw的距离


                break;

            case R.id.rxJava_button: //RxJava
                startActivity(new Intent(MainActivity.this, RxJavaActivity.class));
                break;

            case R.id.retrofit_button://Retrofit网络请求框架
                startActivity(new Intent(MainActivity.this, RetrofitActivity.class));
                break;

            case R.id.recyclerview_button://横向的recyclerview
                startActivity(new Intent(MainActivity.this, MyHRecycleActivity.class));
                break;

            case R.id.EventBus_button://事件总线
                startActivity(new Intent(MainActivity.this, EventBusActivity.class));
                break;

        }
    }


    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
