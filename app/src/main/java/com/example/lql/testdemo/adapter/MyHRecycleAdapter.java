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
 * 类描述：横向滑动的recyclerview
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class MyHRecycleAdapter extends RecyclerView.Adapter<MyHRecycleAdapter.ViewHolder> {

    private ArrayList<String> mList=new ArrayList<>();
    private Context mContext;

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mClick;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        mClick = mOnItemClickListener;
    }

    public MyHRecycleAdapter( Context context) {
//        mList = list;
        mContext = context;
    }


    public void setList(ArrayList<String> mListData) {
        mList.clear();
        mList.addAll(mListData);
        notifyDataSetChanged();
    }



    @Override
    public MyHRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder mViewHolder = new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_hrecycler, parent, false));
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyHRecycleAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
        //设置点击事件
        if (mClick != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mClick.onItemClick(holder.itemView, pos);
                }
            });
        }

        if (position == PublicStaticData.selectId) {
            holder.mTextView.setBackgroundResource(R.drawable.back_red);
            holder.mTextView.setTextColor(0xffffffff);
        } else {
            holder.mTextView.setBackgroundResource(R.drawable.back_white);
            holder.mTextView.setTextColor(0xff595959);
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_textview_hrev);
        }
    }
}
