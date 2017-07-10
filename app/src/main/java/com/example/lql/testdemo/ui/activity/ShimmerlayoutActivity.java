package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.MyCollectionServiceAdapter;
import com.example.lql.testdemo.bean.UserFavoriteListBean;
import com.example.lql.testdemo.http.MOkCallBack;
import com.example.lql.testdemo.http.SendRequest;
import com.example.lql.testdemo.utils.T;
import com.google.gson.Gson;

import java.util.ArrayList;

import io.supercharge.shimmerlayout.ShimmerLayout;


/**
 * Created by Admin on 2017/6/21.
 */

public class ShimmerlayoutActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ShimmerLayout mShimmerLayout;
    MyCollectionServiceAdapter mMyCollectionServiceAdapter;

    ArrayList<UserFavoriteListBean.DataBean> mListService =new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmerlayout);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.shimmerlayout_recycler);
        mShimmerLayout = (ShimmerLayout) findViewById(R.id.shimmer_layout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMyCollectionServiceAdapter= new MyCollectionServiceAdapter(this);
        mMyCollectionServiceAdapter.setList(mListService);
        mRecyclerView.setAdapter(mMyCollectionServiceAdapter);
        getData();
    }


    private void getData() {
        mShimmerLayout.startShimmerAnimation();
        String Userid = "5085";

        SendRequest.UserFavoriteList(Userid, 1, 1, 20, new MOkCallBack() {
            @Override
            public void onSuccess(String response) {
                Log.e("###",response+"response");
//                mShimmerLayout.stopShimmerAnimation();
                if (response.contains("<html>")) {
                    T.shortToast(getApplicationContext(), "服务器异常");
                    return;
                }
                UserFavoriteListBean mCollectionServiceBean = new Gson().fromJson(response, UserFavoriteListBean.class);

//                UserFavoriteListBean mCollectionServiceBean= JSON.parseObject(response,UserFavoriteListBean.class);
                if(mCollectionServiceBean.getResultCode()==0){

                    mListService.addAll(mCollectionServiceBean.getData());
                    mMyCollectionServiceAdapter.setList(mListService);
                }else{
                    T.shortToast(getApplicationContext(),mCollectionServiceBean.getMsg());
                }

            }

            @Override
            public void onFailure(Throwable e) {
//                mShimmerLayout.stopShimmerAnimation();
                T.shortToast(getApplicationContext(), "亲，请检查网络");
            }
        });
    }


}
