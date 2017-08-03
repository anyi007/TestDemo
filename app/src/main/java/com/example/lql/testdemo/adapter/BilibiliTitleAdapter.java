package com.example.lql.testdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.PublicStaticData;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;

import java.util.ArrayList;

/**
 * 类描述：仿照bilibili的title
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class BilibiliTitleAdapter extends RecyclerView.Adapter<BilibiliTitleAdapter.BilibiliTitleViewHolder> {

    private Context mContext;

    public BilibiliTitleAdapter(Context mContext) {
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
    public BilibiliTitleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BilibiliTitleAdapter.BilibiliTitleViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_bilibili_title, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(final BilibiliTitleViewHolder holder, final int position) {
        if (mClick != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClick.onItemClick(holder.itemView, position);
                }
            });
        }


        if (PublicStaticData.selectId == position) {
            holder.bottomView.setBackgroundResource(R.color.color_fff);
        } else {
            holder.bottomView.setBackgroundResource(R.color.color_bilibili);
        }

        holder.title.setText(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class BilibiliTitleViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView bottomView;

        public BilibiliTitleViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_bilibili_title);
            bottomView = (TextView) itemView.findViewById(R.id.item_bilibili_view);
        }
    }
}
