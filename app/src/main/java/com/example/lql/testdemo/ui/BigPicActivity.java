package com.example.lql.testdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.PicGridAdapter;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/6/21.
 */

public class BigPicActivity  extends AppCompatActivity {

    private GridView gv_pics;
    private ArrayList<String> picsList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigpic);
        gv_pics = (GridView) findViewById(R.id.gv_pics);
        initPics();
        // 设置GridView的适配器
        PicGridAdapter adapter = new PicGridAdapter(picsList, BigPicActivity.this);
        gv_pics.setAdapter(adapter);
        gv_pics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(BigPicActivity.this, PhotoDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("photos", picsList);
                intent.putExtras(bundle);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });
    }

    /**
     * 加载GridView的几张图片
     */
    private void initPics() {
        picsList.add("http://g.hiphotos.baidu.com/zhidao/pic/item/80cb39dbb6fd526616bf1d96a918972bd507369f.jpg");
        picsList.add("http://i1.hdslb.com/video/44/44aaafda3a3b58345d6788990b7cffac.jpg");
        picsList.add("http://img3.duitang.com/uploads/item/201509/23/20150923142544_ANiv8.jpeg");
        picsList.add("http://img3.duitang.com/uploads/item/201307/16/20130716192747_xSzXX.jpeg");
        picsList.add("http://c.hiphotos.baidu.com/zhidao/pic/item/a8773912b31bb0510a0a938e357adab44aede06e.jpg");
    }

}
