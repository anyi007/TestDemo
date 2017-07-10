package com.example.lql.testdemo.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.lql.testdemo.R;
import com.example.lql.testdemo.bean.SideslipBean;

import java.util.ArrayList;

/**
 * 类描述：list侧滑  仿QQ
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */

public class SideslipActivity extends AppCompatActivity {
    SwipeMenuListView mSwipeMenuListView;
    TestAdapter mTestAdapter;
    ArrayList<SideslipBean> mList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sideslip);
        initView();
    }

    private void initView() {

        for (int i = 0; i < 100; i++) {
            SideslipBean mBean = new SideslipBean();
            mBean.setName("小米" + i);
            mBean.setFlag(false);
            mList.add(mBean);
        }

        mTestAdapter = new TestAdapter(SideslipActivity.this);
        mTestAdapter.setList(mList);

        mSwipeMenuListView = (SwipeMenuListView) findViewById(R.id.sideslip_list);
        mSwipeMenuListView.setAdapter(mTestAdapter);

        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                switch (menu.getViewType()) {
                    case 0:
                        initmeun0(menu);
                        break;
                    case 1:
                        initmeun1(menu);
                        break;
                }
            }
        };
        // set creator
        mSwipeMenuListView.setMenuCreator(creator);

        // step 2. listener item click event
        mSwipeMenuListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

                switch (index) {
                    case 0:
                        // open
                        SideslipBean name1 = mList.get(position);
                        mList.remove(position);
                        if (name1.isFlag()) {
                            name1.setFlag(false);
                            mList.add(name1);
                        } else {
                            name1.setFlag(true);
                            mList.add(0, name1);
                        }
                        mTestAdapter.setList(mList);
                        mTestAdapter.notifyDataSetChanged();
                        mSwipeMenuListView.setCloseInterpolator(new BounceInterpolator());
                        break;
                    case 1:
                        // delete
                        mList.remove(position);
                        mTestAdapter.setList(mList);
                        mTestAdapter.notifyDataSetChanged();
                        break;
                }
//                return false;
                return true;
            }
        });

    }

    private void initmeun0(SwipeMenu menu) {
        // create "open" item
        SwipeMenuItem openItem = new SwipeMenuItem(
                getApplicationContext());
        // set item background
        openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                0xCE)));
        // set item width
        openItem.setWidth(dp2px(90));
        // set item title
        openItem.setTitle("取消置顶");
        // set item title fontsize
        openItem.setTitleSize(18);
        // set item title font color
        openItem.setTitleColor(Color.WHITE);
        // add to menu
        menu.addMenuItem(openItem);

        // create "delete" item
        SwipeMenuItem deleteItem = new SwipeMenuItem(
                getApplicationContext());
        deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                0x3F, 0x25)));
        deleteItem.setWidth(dp2px(90));
        deleteItem.setTitle("删除");
        menu.addMenuItem(deleteItem);
    }


    private void initmeun1(SwipeMenu menu) {
        // create "open" item
        SwipeMenuItem openItem = new SwipeMenuItem(
                getApplicationContext());
        // set item background
        openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                0xCE)));
        // set item width
        openItem.setWidth(dp2px(90));
        // set item title
        openItem.setTitle("置顶");
        // set item title fontsize
        openItem.setTitleSize(18);
        // set item title font color
        openItem.setTitleColor(Color.WHITE);
        // add to menu
        menu.addMenuItem(openItem);

        // create "delete" item
        SwipeMenuItem deleteItem = new SwipeMenuItem(
                getApplicationContext());
        deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                0x3F, 0x25)));
        deleteItem.setWidth(dp2px(90));
        deleteItem.setTitle("删除");
        menu.addMenuItem(deleteItem);
    }


    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }


    class TestAdapter extends BaseAdapter {

        private Context mContext;

        public TestAdapter(Context mContext) {
            this.mContext = mContext;
        }

        ArrayList<SideslipBean> mListString = new ArrayList<>();

        public void setList(ArrayList<SideslipBean> mDataList) {
            mListString.clear();
            mListString.addAll(mDataList);
            notifyDataSetChanged();
            Log.e("###", mListString.size() + "csdn");
        }


        @Override
        public int getViewTypeCount() {
            // menu type count
            return 2;
        }

        @Override
        public int getItemViewType(int position) {

            // current menu type
            return mListString.get(position).isFlag() ? 0 : 1;
        }


        @Override
        public int getCount() {
            return mListString.size();
        }

        @Override
        public Object getItem(int i) {
            return mListString.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.item_sideslip, null);
            }
            TextView sideslip_list_tv = (TextView) view.findViewById(R.id.sideslip_list_tv);
            sideslip_list_tv.setText(mListString.get(i).getName());
            return view;
        }
    }


}
