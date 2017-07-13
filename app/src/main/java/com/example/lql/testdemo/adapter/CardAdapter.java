package com.example.lql.testdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;
import com.example.lql.testdemo.utils.gildeUtils.GlideApp;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;
import com.view.jameson.library.CardAdapterHelper;

import java.util.ArrayList;

import jameson.io.library.util.ToastUtils;

/**
 * Created by jameson on 8/30/16.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
//    private List<Integer> mList = new ArrayList<>();
//    private CardAdapterHelper mCardAdapterHelper = new CardAdapterHelper();
//
//    public CardAdapter(List<Integer> mList) {
//        this.mList = mList;
//    }

    private CardAdapterHelper mCardAdapterHelper = new CardAdapterHelper();

    private Context mContext;

    public CardAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<String> mList = new ArrayList<>();

    public void setList(ArrayList<String> mDataList) {
        mList.clear();
        mList.addAll(mDataList);
        notifyDataSetChanged();
    }

    private OnItemClickListener mClick;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        mClick = mOnItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_card_item, parent, false);
        mCardAdapterHelper.onCreateViewHolder(parent, itemView);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        mCardAdapterHelper.onBindViewHolder(holder.itemView, position, getItemCount());

        if (TextUtils.isEmpty(mList.get(position))) {
            //清空旧数据的引用
            GlideApp.with(mContext).clear(holder.mImageView);
            //当资源为空时候，设置默认图片
            holder.mImageView.setImageResource(R.drawable.loading);
        } else {//开启一个图片加载
            GlidePicUtils.LoadImg(mContext, holder.mImageView, mList.get(position));
        }

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.show(holder.mImageView.getContext(), "" + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImageView;

        public ViewHolder(final View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

    }

}
