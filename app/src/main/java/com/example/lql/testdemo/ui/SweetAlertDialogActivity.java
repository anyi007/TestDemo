package com.example.lql.testdemo.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lql.testdemo.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Admin on 2017/6/20.
 */

public class SweetAlertDialogActivity extends AppCompatActivity implements View.OnClickListener {


    Button loading_dialog;
    private Button titledialog;
    private Button messagedialog;
    private Button errorydialog;
    private Button warningdialog;
    private Button successdialog;
    private Button headimgdialog;
    private Button submitdialog;
    private Button canceldialog;
    private Button submitswitchdialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_alert_dialog);


        initView();


    }

    private void initView() {
        loading_dialog = (Button) findViewById(R.id.loading_dialog);
        loading_dialog.setOnClickListener(this);

        //只显示标题
        this.titledialog = (Button) findViewById(R.id.title_dialog);
        titledialog.setOnClickListener(this);

        //只显示内容
        this.messagedialog = (Button) findViewById(R.id.message_dialog);
        messagedialog.setOnClickListener(this);

        //异常样式
        this.errorydialog = (Button) findViewById(R.id.errory_dialog);
        errorydialog.setOnClickListener(this);

        //警告样式
        this.warningdialog = (Button) findViewById(R.id.warning_dialog);
        warningdialog.setOnClickListener(this);

        //自定义头部图片
        this.headimgdialog = (Button) findViewById(R.id.headimg_dialog);
        headimgdialog.setOnClickListener(this);

        //成功样式
        this.successdialog = (Button) findViewById(R.id.success_dialog);
        successdialog.setOnClickListener(this);

        //确定对话框
        this.submitdialog = (Button) findViewById(R.id.submit_dialog);
        submitdialog.setOnClickListener(this);

        //取消对话框
        this.canceldialog = (Button) findViewById(R.id.cancel_dialog);
        canceldialog.setOnClickListener(this);

        //确认之后切换
        this.submitswitchdialog = (Button) findViewById(R.id.submit_switch_dialog);
        submitswitchdialog.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loading_dialog:
                SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("Loading");
                pDialog.setCancelable(true);
                pDialog.show();

//                resetCount()   //复位
//                isSpinning()  //旋转？
//                spin()        //自转？
//                stopSpinning()  //停止转动？
//                getProgress()   //当前进度？
//                setProgress(float progress)  //设置进度？
//                setInstantProgress(float progress)  //立即？
//                getCircleRadius()  //拿到半径
//                setCircleRadius(int circleRadius)  //设置半径
//                getBarWidth()  //拿到进度条的宽度
//                setBarWidth(int barWidth)  //设置进度条宽度
//                getBarColor()   //拿到当前颜色
//                setBarColor(int barColor)  //设置颜色
//                getRimWidth()   //边缘宽度
//                setRimWidth(int rimWidth)
//                getRimColor()   //边缘颜色
//                setRimColor(int rimColor)
//                getSpinSpeed()  //转动速度
//                setSpinSpeed(float spinSpeed)
                break;

            case R.id.title_dialog:
                new SweetAlertDialog(this)
                        .setTitleText("Here's a message!")
                        .show();
                break;


            case R.id.message_dialog:
                new SweetAlertDialog(this)
                        .setTitleText("Here's a message!")
                        .setContentText("It's pretty, isn't it?")
                        .show();
                break;

            case R.id.errory_dialog:
                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Something went wrong!")
                        .show();
                break;


            case R.id.warning_dialog:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .show();
                break;


            case R.id.headimg_dialog:
                new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("Sweet!")
                        .setContentText("Here's a custom image.")
                        .setCustomImage(R.drawable.loading)
                        .show();
                break;


            case R.id.success_dialog:
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Good job!")
                        .setContentText("You clicked the button!")
                        .show();
                break;


            case R.id.submit_dialog:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
                break;


            case R.id.cancel_dialog:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setCancelText("No,cancel plx!")
                        .setConfirmText("Yes,delete it!")
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                            }
                        })
                        .show();
                break;


            case R.id.submit_switch_dialog:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog
                                        .setTitleText("Deleted!")
                                        .setContentText("Your imaginary file has been deleted!")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            }
                        })
                        .show();
                break;

        }
    }



}
