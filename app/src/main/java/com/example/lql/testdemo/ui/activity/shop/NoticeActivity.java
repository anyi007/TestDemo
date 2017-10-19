package com.example.lql.testdemo.ui.activity.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.bean.shop.NoticeBean;
import com.example.lql.testdemo.db.dao.shop.NoticeBeanManager;
import com.example.lql.testdemo.utils.MyStatusBarUtil;
import com.example.lql.testdemo.utils.T;

/**
 * 类描述：商城模块---》公告详情页面
 * 作  者：Admin or 李小米
 * 时  间：2017/10/2
 * 修改备注：
 */
public class NoticeActivity extends AppCompatActivity implements View.OnClickListener {

    NoticeBean mNoticeBean = null;
    WebView mWebView;
    ProgressBar pg1;
    private LinearLayout top_ly;//整个布局
    private LinearLayout back_ly;//返回按钮
    private TextView title_tv;//标题
    private LinearLayout title_save_ly;//保存按钮


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyStatusBarUtil.setStatusColor(NoticeActivity.this, getResources().getColor(R.color.shop_select1));
        setContentView(R.layout.activity_notice);
        initView();
        getData();
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.notice_webview);
        pg1 = (ProgressBar) findViewById(R.id.progressBar);
        top_ly = (LinearLayout) findViewById(R.id.top_ly);
        top_ly.setBackgroundColor(getResources().getColor(R.color.shop_select1));
        back_ly = (LinearLayout) findViewById(R.id.top_back_ly);
        title_save_ly = (LinearLayout) findViewById(R.id.top_right_ly);
        title_tv = (TextView) findViewById(R.id.top_title_tv);
        title_tv.setText("公告详情");
        back_ly.setOnClickListener(this);
        title_save_ly.setVisibility(View.INVISIBLE);
    }


    private void getData() {
        long noticeId = getIntent().getLongExtra("noticeId", -1);
        if (noticeId != -1) {
            mNoticeBean = NoticeBeanManager.LoadById(noticeId);

            mWebView.loadUrl(mNoticeBean.getNoticeContent());

            // 拿到网页设置对象,里面封装者各种对WebView的设置
            WebSettings settings = mWebView.getSettings();
            // 有的网页就是mei这些功能的,但是你得都给打开
            settings.setBuiltInZoomControls(true);  // 显示缩放按钮
            settings.setUseWideViewPort(true);  // 实现双击缩放
            settings.setJavaScriptEnabled(true);    // 支持js功能

            mWebView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    if (newProgress == 100) {
                        pg1.setVisibility(View.GONE);//加载完网页进度条消失
                    } else {
                        pg1.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                        pg1.setProgress(newProgress);//设置进度值
                    }

                }
            });

        } else {
            T.shortToast(this, "id没取到");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_back_ly:
                finish();
                break;
            default:
                break;
        }
    }
}
