package com.example.lql.testdemo.adapter.shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.bean.shop.CommodityBean;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;

import java.util.ArrayList;

/**
 * 类描述：商城模块--》分类右侧recyclerview
 * 作  者：Admin or 李小米
 * 时  间：2017/10/3
 * 修改备注：
 */
public class ShopClassFragmentRightAdapter extends RecyclerView.Adapter<ShopClassFragmentRightAdapter.ViewHolder> {

    private Context mContext;

    public ShopClassFragmentRightAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<CommodityBean> mList = new ArrayList<>();

    public void setList(ArrayList<CommodityBean> mDataList) {
        mList.clear();
        mList.addAll(mDataList);
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
        return new ShopClassFragmentRightAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_shop_class_right_fragment, parent, false));
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
        holder.ClassName.setText(mList.get(position).getCommodityName() + "");
        GlidePicUtils.LoadImg(mContext, holder.mImageView, mList.get(position).getCommodityPic().split(",")[0]);

    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView ClassName;
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ClassName = (TextView) itemView.findViewById(R.id.item_shop_name);
            mImageView = (ImageView) itemView.findViewById(R.id.item_shop_img);
        }
    }
}
