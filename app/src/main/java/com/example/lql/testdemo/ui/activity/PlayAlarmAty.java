package com.example.lql.testdemo.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.ScreenUtils;

/**
 * Created by nomasp on 2015/10/07.
 */
public class PlayAlarmAty extends Activity {

    String msg;
    int ClockId;
    private TextView message;
    private TextView canle;
    private TextView submit;
    LinearLayout dialogly;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_alarm);
        msg = getIntent().getStringExtra("msg");
        ClockId = getIntent().getIntExtra("ClockId", 0);
        initView();
    }


    protected void initView() {
        this.submit = (TextView) findViewById(R.id.submit_tv);
        this.canle = (TextView) findViewById(R.id.canle_tv);
        this.message = (TextView) findViewById(R.id.message_tv);
        this.dialogly = (LinearLayout) findViewById(R.id.dialog_ly);

        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) dialogly.getLayoutParams(); //取控件textView当前的布局参数

        linearParams.width = ScreenUtils.getScreenWidth(PlayAlarmAty.this) / 10 * 8;// 控件的宽强制设成30

        dialogly.setLayoutParams(linearParams); //使设置好的布局参数应用到控件

        message.setText("时间到了！");

        canle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
