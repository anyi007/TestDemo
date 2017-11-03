package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.MyHRecycleAdapter;
import com.example.lql.testdemo.adapter.MyMoreHRecycleAdapter;
import com.example.lql.testdemo.utils.PublicStaticData;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;

import java.util.ArrayList;


/**
 * 类描述：横向滑动的recyclerview
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class MyHRecycleActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView myrecycler2;
    ArrayList<String> mList = new ArrayList<>();
    MyHRecycleAdapter mMyHRecycleAdapter;
    MyMoreHRecycleAdapter mMyMoreHRecycleAdapter;

    TextView header_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhrecycle);
        mRecyclerView = (RecyclerView) findViewById(R.id.myrecycler);
        myrecycler2 = (RecyclerView) findViewById(R.id.myrecycler2);

        header_view = (TextView) findViewById(R.id.head_ly);

        for (int i = 0; i < 35; i++) {
            mList.add("小米" + i);
        }


        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mMyHRecycleAdapter = new MyHRecycleAdapter(MyHRecycleActivity.this);
        mMyHRecycleAdapter.setList(mList);
        mRecyclerView.setAdapter(mMyHRecycleAdapter);

        mMyHRecycleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                PublicStaticData.selectId = position;
                mMyHRecycleAdapter.notifyDataSetChanged();
            }
        });


        LinearLayoutManager  linearLayoutManager1 = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        myrecycler2.setLayoutManager(new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mMyMoreHRecycleAdapter = new MyMoreHRecycleAdapter(this);
        mMyMoreHRecycleAdapter.setList(mList);
        myrecycler2.setAdapter(mMyMoreHRecycleAdapter);
        mMyMoreHRecycleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                PublicStaticData.selectId = position;
                mMyHRecycleAdapter.notifyDataSetChanged();
            }
        });


//        myrecycler2.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//                View stickyInfoView=recyclerView.getChildAt(0);
//                if (stickyInfoView!=null && stickyInfoView.getContentDescription()!=null) {
//                    header_view.setText(String.valueOf(stickyInfoView.getContentDescription()));
//                }
//                View transInfoView=recyclerView.findChildViewUnder(header_view.getMeasuredWidth()/2, header_view.getMeasuredHeight()+1);
//                if (transInfoView!=null && transInfoView.getTag()!=null) {
//                    int tag= (int) transInfoView.getTag();
//                    int deltaY=transInfoView.getTop()-header_view.getMeasuredHeight();
//                    if (tag==MyMoreHRecycleAdapter.HAS_STICKY_VIEW) {
//                        if (transInfoView.getTop()>0) {
//                            header_view.setTranslationY(deltaY);
//                        }
//                        else {
//                            header_view.setTranslationY(0);
//                        }
//                    }
//                    else {
//                        header_view.setTranslationY(0);
//                    }
//                }
//            }
//        });
    }
}
