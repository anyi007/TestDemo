package com.example.lql.testdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.PublicStaticData;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;

import java.util.ArrayList;


/**
 * 类描述：横向滑动的recyclerview  这个数据比较多
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class MyMoreHRecycleAdapter extends RecyclerView.Adapter<MyMoreHRecycleAdapter.ViewHolder> {

    public static final int FIRST_STICKY_VIEW = 1;
    public static final int HAS_STICKY_VIEW = 2;
    public static final int NONE_STICKY_VIEW = 3;

    private ArrayList<String> mList = new ArrayList<>();
    private Context mContext;

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mClick;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        mClick = mOnItemClickListener;
    }

    public MyMoreHRecycleAdapter(Context context) {
        mContext = context;
    }


    public void setList(ArrayList<String> mListData) {
        mList.clear();
        mList.addAll(mListData);
        notifyDataSetChanged();
    }

    @Override
    public MyMoreHRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder mViewHolder = new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_morehrecycler, parent, false));
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyMoreHRecycleAdapter.ViewHolder holder, int position) {
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
//        holder.itemView.setContentDescription(mList.get(position / 10));
//        if (position == 0) {
//            holder.mHeadView.setVisibility(View.VISIBLE);
//            holder.itemView.setTag(FIRST_STICKY_VIEW);
//        } else {
//            if (!mList.get(position).equals(mList.get(position - 1))) {
//                holder.mHeadView.setVisibility(View.VISIBLE);
//                holder.itemView.setTag(HAS_STICKY_VIEW);
//            } else {
//                holder.mHeadView.setVisibility(View.GONE);
//                holder.itemView.setTag(NONE_STICKY_VIEW);
//            }
//        }


    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        TextView mHeadView;
        LinearLayout mBottomView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_textview_hrev1);
            mHeadView = (TextView) itemView.findViewById(R.id.head_ly);
            mBottomView = (LinearLayout) itemView.findViewById(R.id.bottom_ly);
        }
    }
}
