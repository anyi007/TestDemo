package com.example.lql.testdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lql.testdemo.R;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/7/10.
 */

public class TestTextViewAdapter extends RecyclerView.Adapter<TestTextViewAdapter.MyViewHolder> {


    private Context mContext;

    public TestTextViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<String> mList = new ArrayList<>();

    public void setList(ArrayList<String> mDataList) {
        mList.clear();
        mList.addAll(mDataList);
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TestTextViewAdapter.MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_gilde, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.test_tv);
        }
    }
}
