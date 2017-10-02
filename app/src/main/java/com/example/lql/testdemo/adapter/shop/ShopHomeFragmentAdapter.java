package com.example.lql.testdemo.adapter.shop;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.bean.shop.CommodityBean;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;
import com.example.lql.testdemo.utils.ScreenUtils;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;

import java.util.ArrayList;

/**
 * 类描述：商城首页的adapter
 * 作  者：Admin or 李小米
 * 时  间：2017/10/2
 * 修改备注：
 */
public class ShopHomeFragmentAdapter extends RecyclerView.Adapter<ShopHomeFragmentAdapter.ViewHolder> {


    private Context mContext;

    public ShopHomeFragmentAdapter(Context mContext) {
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShopHomeFragmentAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_shophome_fragment, parent, false));
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

        String[] split = mList.get(position).getCommodityPic().split(",");
        if (split != null && split.length != 0) {
            GlidePicUtils.LoadImg(mContext, holder.comImg, split[0]);
        }
        holder.moneyTv.setText("￥" + mList.get(position).getCommodityPrice());
        holder.nameTv.setText(mList.get(position).getCommodityName());

        GridLayoutManager.LayoutParams linearParams = (GridLayoutManager.LayoutParams) holder.homeLy.getLayoutParams(); //取控件textView当前的布局参数
        linearParams.width = (ScreenUtils.getScreenWidth(mContext)) / 2 - 10;// 控件的宽强制设成30
        holder.homeLy.setLayoutParams(linearParams); //使设置好的布局参数应用到控件

        LinearLayout.LayoutParams linearParams1 = (LinearLayout.LayoutParams) holder.comImg.getLayoutParams(); //取控件textView当前的布局参数
        linearParams1.width = (ScreenUtils.getScreenWidth(mContext)) / 2 - 10;// 控件的宽强制设成30
        linearParams1.height = linearParams1.width;// 控件的宽强制设成30
        holder.comImg.setLayoutParams(linearParams1); //使设置好的布局参数应用到控件

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout homeLy;
        ImageView comImg;
        TextView moneyTv;
        TextView nameTv;

        public ViewHolder(View itemView) {
            super(itemView);
            homeLy = (LinearLayout) itemView.findViewById(R.id.item_home_fragment_ly);
            comImg = (ImageView) itemView.findViewById(R.id.item_home_fragment_img);
            moneyTv = (TextView) itemView.findViewById(R.id.item_home_fragment_money);
            nameTv = (TextView) itemView.findViewById(R.id.item_home_fragment_name);
        }
    }
}
