package com.example.lql.testdemo.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.CardAdapter;
import com.example.lql.testdemo.utils.T;
import com.view.jameson.library.CardScaleHelper;
import com.view.jameson.library.utils.BitmapUtils;
import com.view.jameson.library.utils.BlurBitmapUtils;
import com.view.jameson.library.utils.ViewSwitchUtils;

import java.util.ArrayList;

/**
 * 类描述：使用recyclerview实现一个画廊效果
 * 作  者：李清林
 * 时  间：2017.7.13
 * 修改备注：
 */
public class RecyclerviewCardGalleryActivity extends AppCompatActivity {

    private android.widget.ImageView blurView;
    private com.view.jameson.library.SpeedRecyclerView recyclerView;
    private android.support.design.widget.FloatingActionButton addbutton;
    CardAdapter mCardAdapter;
    private CardScaleHelper mCardScaleHelper = null;
    ArrayList<String> mList = new ArrayList<>();
    private int mLastPos = -1;
    private Runnable mBlurRunnable;
    Bitmap bitmap = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_cardgallery);
        initview();

    }

    private void initview() {
        this.addbutton = (FloatingActionButton) findViewById(R.id.add_button);
        this.recyclerView = (com.view.jameson.library.SpeedRecyclerView) findViewById(R.id.recyclerView);
        this.blurView = (ImageView) findViewById(R.id.blurView);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T.shortToast(RecyclerviewCardGalleryActivity.this, "添加房间");
            }
        });


        mList.add("http://pic46.nipic.com/20140819/7487939_224845528000_2.jpg");
        mList.add("http://cdn.duitang.com/uploads/item/201504/18/20150418H2112_LXniu.thumb.700_0.jpeg");
        mList.add("http://pic27.photophoto.cn/20130525/0005018338588465_b.jpg");
        mList.add("http://h.hiphotos.baidu.com/zhidao/pic/item/80cb39dbb6fd52660fa9fe7cad18972bd50736dc.jpg");
        mList.add("http://p2.gexing.com/qqpifu/20121001/1552/50694ba0e25a3.jpg");

        mList.add("http://pic46.nipic.com/20140819/7487939_224845528000_2.jpg");
        mList.add("http://cdn.duitang.com/uploads/item/201504/18/20150418H2112_LXniu.thumb.700_0.jpeg");
        mList.add("http://pic27.photophoto.cn/20130525/0005018338588465_b.jpg");
        mList.add("http://h.hiphotos.baidu.com/zhidao/pic/item/80cb39dbb6fd52660fa9fe7cad18972bd50736dc.jpg");
        mList.add("http://p2.gexing.com/qqpifu/20121001/1552/50694ba0e25a3.jpg");

        mList.add("http://pic46.nipic.com/20140819/7487939_224845528000_2.jpg");
        mList.add("http://cdn.duitang.com/uploads/item/201504/18/20150418H2112_LXniu.thumb.700_0.jpeg");
        mList.add("http://pic27.photophoto.cn/20130525/0005018338588465_b.jpg");
        mList.add("http://h.hiphotos.baidu.com/zhidao/pic/item/80cb39dbb6fd52660fa9fe7cad18972bd50736dc.jpg");
        mList.add("http://p2.gexing.com/qqpifu/20121001/1552/50694ba0e25a3.jpg");

        mCardAdapter = new CardAdapter(RecyclerviewCardGalleryActivity.this);
        mCardAdapter.setList(mList);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mCardAdapter);
        // mRecyclerView绑定scale效果
        mCardScaleHelper = new CardScaleHelper();
        mCardScaleHelper.setCurrentItemPos(0);
        mCardScaleHelper.attachToRecyclerView(recyclerView);

        initBlurBackground();
    }


    private void initBlurBackground() {
        blurView = (ImageView) findViewById(R.id.blurView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    notifyBackgroundChange();
                }
            }
        });

        notifyBackgroundChange();
    }


    private void notifyBackgroundChange() {
        if (mLastPos == mCardScaleHelper.getCurrentItemPos()) return;
        mLastPos = mCardScaleHelper.getCurrentItemPos();
        blurView.removeCallbacks(mBlurRunnable);

        mBlurRunnable = new Runnable() {
            @Override
            public void run() {
                bitmap = BitmapUtils.getBitmap(mList.get(mCardScaleHelper.getCurrentItemPos()));
                if (bitmap == null) {//如果拿不到bitmap,就设置一张默认的图片作为高斯模糊的背景图
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.testpic);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ViewSwitchUtils.startSwitchBackgroundAnim(blurView,
                                BlurBitmapUtils.getBlurBitmap(blurView.getContext(), bitmap, 20));
                    }
                });
            }
        };

        new Thread(mBlurRunnable).start();
        blurView.postDelayed(mBlurRunnable, 500);
    }


}
