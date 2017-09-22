package com.example.lql.testdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.bean.NBAVideoDataBean;
import com.example.lql.testdemo.bean.NBAVideoInfo;
import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 类描述：视频播放列表的适配器
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoListViewHolder> {
    String s1 = "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4";
    private Context mContext;

    public VideoListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<NBAVideoInfo> mList = new ArrayList<>();
    ArrayList<NBAVideoDataBean> mListInfo = new ArrayList<>();

    public void setList(ArrayList<NBAVideoInfo> mDataList) {
        mList.clear();
        mList.addAll(mDataList);
        notifyDataSetChanged();
    }

    public void setInfoList(ArrayList<NBAVideoDataBean> mDataList) {
        mListInfo.clear();
        mListInfo.addAll(mDataList);
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


        if (mList.get(position).vl.vi != null && mList.get(position).vl.vi.size() > 0) {
            String vid = mList.get(position).vl.vi.get(0).vid;
            LogUtils.Loge("vid" + vid);
            String vkey = mList.get(position).vl.vi.get(0).fvkey;
            LogUtils.Loge("vkey" + vkey);
            String url = mList.get(position).vl.vi.get(0).ul.ui.get(0).url + vid + ".mp4?vkey=" + vkey;

            holder.mJCVideoPlayerStandard.setUp(url, holder.mJCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, mList.get(position).vl.vi.get(0).ti);
        }

        holder.mTitle.setText(mListInfo.get(position).getTitle() + position);

        GlidePicUtils.LoadImg(mContext, holder.mJCVideoPlayerStandard.thumbImageView, mListInfo.get(position).getImgurl());


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
