package com.example.lql.testdemo.adapter.shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.bean.shop.NoticeBean;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;

import java.util.ArrayList;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/10/3
 * 修改备注：
 */
public class NoticeListAdapter extends RecyclerView.Adapter<NoticeListAdapter.ViewHolder> {

    private Context mContext;

    public NoticeListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<NoticeBean> mList = new ArrayList<>();

    public void setList(ArrayList<NoticeBean> mDataList) {
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
        return new NoticeListAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_noticelist, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (mClick != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClick.onItemClick(view, position);
                }
            });
        }
        holder.title.setText(mList.get(position).getNoticeTitle());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_notive_title);
        }
    }
}
