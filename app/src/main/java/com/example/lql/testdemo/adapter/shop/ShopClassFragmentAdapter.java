package com.example.lql.testdemo.adapter.shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.bean.shop.CommodityTypeBean;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;

import java.util.ArrayList;

/**
 * 类描述：商城模块--》分类左侧recyclerview
 * 作  者：Admin or 李小米
 * 时  间：2017/10/3
 * 修改备注：
 */
public class ShopClassFragmentAdapter extends RecyclerView.Adapter<ShopClassFragmentAdapter.ViewHolder> {

    private Context mContext;
    private int index = 0;

    public ShopClassFragmentAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<CommodityTypeBean> mList = new ArrayList<>();

    public void setList(ArrayList<CommodityTypeBean> mDataList) {
        mList.clear();
        mList.addAll(mDataList);
        notifyDataSetChanged();
    }

    public void setNumber(int mIndex) {
        index = mIndex;
        notifyDataSetChanged();
    }

    private OnItemClickListener mClick;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        mClick = mOnItemClickListener;
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShopClassFragmentAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_shop_class_fragment, parent, false));
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

        holder.ClassName.setTextColor(mContext.getResources().getColor(position == index ? R.color.shop_select2 : R.color.color_333));
        holder.ClassName.setText(mList.get(position).getCommodityTypeName() + "");
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView ClassName;

        public ViewHolder(View itemView) {
            super(itemView);
            ClassName = (TextView) itemView.findViewById(R.id.item_shop_class_name);
        }
    }
}
