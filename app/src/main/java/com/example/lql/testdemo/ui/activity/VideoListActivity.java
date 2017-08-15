package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.VideoListAdapter;
import com.example.lql.testdemo.ui.BaseActivity;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 类描述：视频播放列表
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class VideoListActivity extends BaseActivity {

    VideoListAdapter mVideoListAdapter;
    private fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard jiecaoPlayer;
    private android.support.v7.widget.RecyclerView videorecycle;

    //    http://v.sports.qq.com/#/cover/p0i26tdodybwxm6/s0024o4mngn
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videolist);
        initView();
    }

    private void initView() {
        this.videorecycle = (RecyclerView) findViewById(R.id.video_recycle);
        this.jiecaoPlayer = (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);
    }
}
