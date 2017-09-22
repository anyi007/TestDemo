package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSONObject;
import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.VideoListAdapter;
import com.example.lql.testdemo.bean.NBAVideoDataBean;
import com.example.lql.testdemo.bean.NBAVideoIdBean;
import com.example.lql.testdemo.bean.NBAVideoInfo;
import com.example.lql.testdemo.http.MOkCallBack;
import com.example.lql.testdemo.http.SendRequest;
import com.example.lql.testdemo.ui.BaseActivity;
import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.T;

import org.json.JSONException;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

import static com.example.lql.testdemo.utils.RecyclerView.IsBottom.isSlideToBottom;

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
    String s1 = "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4";

    ArrayList<NBAVideoIdBean.DataBean> mNBAVideoIdBeanList = new ArrayList<>();//总共两百条的id
    ArrayList<NBAVideoIdBean.DataBean> mNBAVideoIdBeanListChoose = new ArrayList<>();//请求的那一页的id
    ArrayList<NBAVideoDataBean> mNBAVideoDataBeanList = new ArrayList<>();//拿到视频的数据
    ArrayList<NBAVideoInfo> mList = new ArrayList<>();//真正的视频地址
    int Page = 1;
    int Rows = 10;

    LinearLayout loading;
    boolean up = false;//是向上还是向下  false向下  true:向上
    SwipeRefreshLayout mySwipeRefresh;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videolist);
        initView();
    }

    private void initView() {
        this.videorecycle = (RecyclerView) findViewById(R.id.video_recycle);
        this.jiecaoPlayer = (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);

        loading = (LinearLayout) findViewById(R.id.loading_ly);
        mySwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.mySwre);
        mySwipeRefresh.setColorSchemeResources(android.R.color.holo_red_light);
        //设置下拉刷新监听
        mySwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        up = true;
                        Page = 1;
                        getVoList(1);
                    }
                }, 0);
            }
        });


        videorecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy != 0) {
                    if (isSlideToBottom(recyclerView)) {
                        up = false;
                        Page++;
                        loading.setVisibility(View.VISIBLE);
                        getVoList(Page);
                    }
                }
            }
        });


        jiecaoPlayer.setUp(s1, jiecaoPlayer.SCREEN_LAYOUT_NORMAL, "视频标题");
        videorecycle.setLayoutManager(new LinearLayoutManager(this));
        mVideoListAdapter = new VideoListAdapter(this);
        mVideoListAdapter.setList(mList);
        mVideoListAdapter.setInfoList(mNBAVideoDataBeanList);
        videorecycle.setAdapter(mVideoListAdapter);
        getIdData();
    }

    /**
     * 先取到视频的id(两百条)
     */
    private void getIdData() {
        SendRequest.getHighlightVideoArticleIds(new MOkCallBack() {
            @Override
            public void onSuccess(String response) {
                Log.e("###onSuccess", response + "response");
                try {
                    NBAVideoIdBean roomListBean = JSONObject.parseObject(response, NBAVideoIdBean.class);
                    mNBAVideoIdBeanList.clear();
                    mNBAVideoIdBeanList.addAll(roomListBean.getData());
                    getVoList(1);
                } catch (Exception e) {
                    Log.e("###", e.toString() + "Throwable");
                    T.shortToast(VideoListActivity.this, getResources().getString(R.string.onFailure_string));
                }
            }

            @Override
            public void onFailure(Throwable e) {
                Log.e("###onFailure", e.toString() + "Throwable");
                T.shortToast(VideoListActivity.this, getResources().getString(R.string.onFailure_string));
            }
        });
    }


    /**
     * 分页去拿数据
     *
     * @param number 第几页  从1开始
     */
    private void getVoList(int number) {
        int start = (number - 1) * Rows;
        int end = start + Rows;

        if (start >= mNBAVideoIdBeanList.size() - 1) {
            T.shortToast(VideoListActivity.this, "没有更多内容了");
            return;
        }

        if (end > mNBAVideoIdBeanList.size()) {
            end = mNBAVideoIdBeanList.size();
        }

        mNBAVideoIdBeanListChoose.clear();
        String dataId = "";
        for (int i = start; i < end; i++) {
            dataId = dataId + mNBAVideoIdBeanList.get(i).getId() + ",";
            mNBAVideoIdBeanListChoose.add(mNBAVideoIdBeanList.get(i));
        }
        if (dataId.length() > 0) {
            dataId = dataId.substring(0, dataId.length() - 1);
        }

        LogUtils.Loge(dataId + "id");

        SendRequest.getNBAVideoData(dataId, new MOkCallBack() {
            @Override
            public void onSuccess(String response) {
                Log.e("###onSuccess", response + "response");
                if (response.contains("<html>")) {
                    T.shortToast(VideoListActivity.this, getResources().getString(R.string.ServiceError_string));
                    return;
                }
                try {
                    org.json.JSONObject jsonObject = new org.json.JSONObject(response);
                    org.json.JSONObject videoObject = new org.json.JSONObject(jsonObject.getString("data"));
                    if (up) {//如果是向上的，先把原来的数据清空
                        mList.clear();
                        mNBAVideoDataBeanList.clear();
                    }
                    for (int i = 0; i < mNBAVideoIdBeanListChoose.size(); i++) {
                        NBAVideoDataBean mNBADataBean = JSONObject.parseObject(videoObject.getString(mNBAVideoIdBeanListChoose.get(i).getId()), NBAVideoDataBean.class);
                        LogUtils.Loge("asd" + i + mNBADataBean.toString());
                        getUrl(mNBADataBean);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable e) {
                //停止刷新动画
                mySwipeRefresh.setRefreshing(false);
                loading.setVisibility(View.VISIBLE);
            }
        });
    }


    /**
     * 第三步，去拿真正的地址
     *
     * @return
     */
    private void getUrl(final NBAVideoDataBean mNBADataBean) {

        SendRequest.getNBAVideoRealUrl(mNBADataBean.getVid(), new MOkCallBack() {
            @Override
            public void onSuccess(String result) {
                if (result != null && !TextUtils.isEmpty(result)) {
                    String resp = result.replaceAll("QZOutputJson=", "").replaceAll(" ", "").replaceAll("\n", "");
                    if (resp.endsWith(";")) resp = resp.substring(0, resp.length() - 1);
//                    Logger.d("=====视频信息 ：" + resp);
                    NBAVideoInfo videoInfo = JSONObject.parseObject(resp, NBAVideoInfo.class);

                    mList.add(videoInfo);
                    mNBAVideoDataBeanList.add(mNBADataBean);
                    mVideoListAdapter.setInfoList(mNBAVideoDataBeanList);
                    mVideoListAdapter.setList(mList);
                }

                //停止刷新动画
                mySwipeRefresh.setRefreshing(false);
                loading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Throwable e) {
//停止刷新动画
                mySwipeRefresh.setRefreshing(false);
                loading.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


}
