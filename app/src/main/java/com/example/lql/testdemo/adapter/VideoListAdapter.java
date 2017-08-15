package com.example.lql.testdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 类描述：视频播放列表的适配器
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoListViewHolder> {

    private Context mContext;

    public VideoListAdapter(Context mContext) {
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
    public VideoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoListAdapter.VideoListViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_video_list, parent, false));
    }

    @Override
    public void onBindViewHolder(VideoListViewHolder holder, final int position) {
        if (mClick != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClick.onItemClick(view, position);
                }
            });
        }

        holder.mTitle.setText("这里是标题" + position);



    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class VideoListViewHolder extends RecyclerView.ViewHolder {

        JCVideoPlayerStandard mJCVideoPlayerStandard;
        TextView mTitle;

        public VideoListViewHolder(View itemView) {
            super(itemView);
            mJCVideoPlayerStandard = (JCVideoPlayerStandard) itemView.findViewById(R.id.item_jiecao_Player);
            mTitle = (TextView) itemView.findViewById(R.id.item_title);
        }
    }
}
