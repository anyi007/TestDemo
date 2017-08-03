package com.example.lql.testdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseActivity;
import com.example.lql.testdemo.utils.MyStatusBarUtil;

/**
 * 类描述：选择重复周期
 * 作  者：李清林
 * 时  间：2017.7.18
 * 修改备注：
 */
public class TimingChooseDayActivity extends BaseActivity implements View.OnClickListener {

    private android.support.v7.widget.Toolbar choosedaytoolbar;
    private android.widget.ImageView choosedayday0;
    private android.widget.LinearLayout choosedayday0ly;
    private android.widget.ImageView choosedayday1;
    private android.widget.LinearLayout choosedayday1ly;
    private android.widget.ImageView choosedayday2;
    private android.widget.LinearLayout choosedayday2ly;
    private android.widget.ImageView choosedayday3;
    private android.widget.LinearLayout choosedayday3ly;
    private android.widget.ImageView choosedayday4;
    private android.widget.LinearLayout choosedayday4ly;
    private android.widget.ImageView choosedayday5;
    private android.widget.LinearLayout choosedayday5ly;
    private android.widget.ImageView choosedayday6;
    private android.widget.LinearLayout choosedayday6ly;
    private android.widget.TextView savebutton;

    String RepeatTime = "";

    String IntentRepeatTime = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing_chooseday);
        MyStatusBarUtil.setStatusColor(this, getResources().getColor(R.color.colorAccent));
        IntentRepeatTime = getIntent().getStringExtra("RepeatTime");
        initView();
    }

    private void initView() {
        this.savebutton = (TextView) findViewById(R.id.save_button);
        this.choosedayday6ly = (LinearLayout) findViewById(R.id.chooseday_day6_ly);
        this.choosedayday6 = (ImageView) findViewById(R.id.chooseday_day6);
        this.choosedayday5ly = (LinearLayout) findViewById(R.id.chooseday_day5_ly);
        this.choosedayday5 = (ImageView) findViewById(R.id.chooseday_day5);
        this.choosedayday4ly = (LinearLayout) findViewById(R.id.chooseday_day4_ly);
        this.choosedayday4 = (ImageView) findViewById(R.id.chooseday_day4);
        this.choosedayday3ly = (LinearLayout) findViewById(R.id.chooseday_day3_ly);
        this.choosedayday3 = (ImageView) findViewById(R.id.chooseday_day3);
        this.choosedayday2ly = (LinearLayout) findViewById(R.id.chooseday_day2_ly);
        this.choosedayday2 = (ImageView) findViewById(R.id.chooseday_day2);
        this.choosedayday1ly = (LinearLayout) findViewById(R.id.chooseday_day1_ly);
        this.choosedayday1 = (ImageView) findViewById(R.id.chooseday_day1);
        this.choosedayday0ly = (LinearLayout) findViewById(R.id.chooseday_day0_ly);
        this.choosedayday0 = (ImageView) findViewById(R.id.chooseday_day0);
        this.choosedaytoolbar = (Toolbar) findViewById(R.id.chooseday_toolbar);

        choosedayday0ly.setOnClickListener(this);
        choosedayday1ly.setOnClickListener(this);
        choosedayday2ly.setOnClickListener(this);
        choosedayday3ly.setOnClickListener(this);
        choosedayday4ly.setOnClickListener(this);
        choosedayday5ly.setOnClickListener(this);
        choosedayday6ly.setOnClickListener(this);
        savebutton.setOnClickListener(this);

        choosedaytoolbar.setNavigationIcon(getResources().getDrawable(R.drawable.icon_back));
        choosedaytoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        choosedaytoolbar.setTitleTextColor(getResources().getColor(R.color.color_fff));
        choosedaytoolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));//背景色
        choosedaytoolbar.setTitle("选择重复周期");
        setView();
    }


    private void setView() {
        if (IntentRepeatTime.contains("日")) {
            choosedayday0.setVisibility(View.VISIBLE);
        }
        if (IntentRepeatTime.contains("一")) {
            choosedayday1.setVisibility(View.VISIBLE);
        }
        if (IntentRepeatTime.contains("二")) {
            choosedayday2.setVisibility(View.VISIBLE);
        }
        if (IntentRepeatTime.contains("三")) {
            choosedayday3.setVisibility(View.VISIBLE);
        }
        if (IntentRepeatTime.contains("四")) {
            choosedayday4.setVisibility(View.VISIBLE);
        }
        if (IntentRepeatTime.contains("五")) {
            choosedayday5.setVisibility(View.VISIBLE);
        }
        if (IntentRepeatTime.contains("六")) {
            choosedayday6.setVisibility(View.VISIBLE);
        }

    }


    public void save() {
        Intent intent = new Intent();
        intent.putExtra("RepeatTime", RepeatTime.substring(0, RepeatTime.length() - 1));
        setResult(RESULT_OK, intent); //intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
        finish();//此处一定要调用finish()方法
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chooseday_day6_ly:
                choosedayday6.setVisibility(choosedayday6.getVisibility() == View.VISIBLE ?
                        View.INVISIBLE : View.VISIBLE);
                break;
            case R.id.chooseday_day5_ly:
                choosedayday5.setVisibility(choosedayday5.getVisibility() == View.VISIBLE ?
                        View.INVISIBLE : View.VISIBLE);
                break;
            case R.id.chooseday_day4_ly:
                choosedayday4.setVisibility(choosedayday4.getVisibility() == View.VISIBLE ?
                        View.INVISIBLE : View.VISIBLE);
                break;
            case R.id.chooseday_day3_ly:
                choosedayday3.setVisibility(choosedayday3.getVisibility() == View.VISIBLE ?
                        View.INVISIBLE : View.VISIBLE);
                break;
            case R.id.chooseday_day2_ly:
                choosedayday2.setVisibility(choosedayday2.getVisibility() == View.VISIBLE ?
                        View.INVISIBLE : View.VISIBLE);
                break;
            case R.id.chooseday_day1_ly:
                choosedayday1.setVisibility(choosedayday1.getVisibility() == View.VISIBLE ?
                        View.INVISIBLE : View.VISIBLE);
                break;
            case R.id.chooseday_day0_ly:
                choosedayday0.setVisibility(choosedayday0.getVisibility() == View.VISIBLE ?
                        View.INVISIBLE : View.VISIBLE);
                break;

            case R.id.save_button:
                if (choosedayday0.getVisibility() == View.VISIBLE) {
                    RepeatTime = RepeatTime + "日、";
                }
                if (choosedayday1.getVisibility() == View.VISIBLE) {
                    RepeatTime = RepeatTime + "一、";
                }
                if (choosedayday2.getVisibility() == View.VISIBLE) {
                    RepeatTime = RepeatTime + "二、";
                }
                if (choosedayday3.getVisibility() == View.VISIBLE) {
                    RepeatTime = RepeatTime + "三、";
                }
                if (choosedayday4.getVisibility() == View.VISIBLE) {
                    RepeatTime = RepeatTime + "四、";
                }
                if (choosedayday5.getVisibility() == View.VISIBLE) {
                    RepeatTime = RepeatTime + "五、";
                }
                if (choosedayday6.getVisibility() == View.VISIBLE) {
                    RepeatTime = RepeatTime + "六、";
                }
                save();
                break;
        }
    }
}
