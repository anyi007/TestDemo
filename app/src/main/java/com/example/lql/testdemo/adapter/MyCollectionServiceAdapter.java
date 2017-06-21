package com.example.lql.testdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.bean.UserFavoriteListBean;
import com.example.lql.testdemo.utils.T;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;

import java.util.ArrayList;

/**
 * Created by LQL on 2016/11/29.   我收藏的服务
 */

public class MyCollectionServiceAdapter extends  RecyclerView.Adapter<MyCollectionServiceAdapter.MyViewHolder>{
   private Context mContext;

   public MyCollectionServiceAdapter(Context mContext) {
       this.mContext = mContext;
   }

   ArrayList<UserFavoriteListBean.DataBean> mList=new ArrayList<>();

   public void setList(ArrayList<UserFavoriteListBean.DataBean> mDataList){
       mList.clear();
       mList.addAll(mDataList);
       notifyDataSetChanged();
   }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder=new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_collection_service,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.item_collection_service_name_tv.setText(mList.get(position).getName());
        holder.item_collection_service_price_tv.setText("￥"+mList.get(position).getPrice());
        holder.item_collection_service_number_tv.setText("月销量："+mList.get(position).getCount());
        holder.item_collection_service_cancel_tv.setOnClickListener(new MyClick(position));
        GlidePicUtils.LoadImg(mContext ,  holder.item_collection_service_img , mList.get(position).getImgurl());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class MyClick implements View.OnClickListener{

        private int index;

        public MyClick(int index) {
            this.index = index;
        }

        @Override
        public void onClick(View view) {
            T.shortToast(mContext,"取消失败");
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView item_collection_service_name_tv;//工作室名称
        TextView item_collection_service_price_tv;//价格
        TextView item_collection_service_number_tv;//月销量

        TextView item_collection_service_cancel_tv;//取消收藏（可点击）
        ImageView item_collection_service_img;//工作室头像



        public MyViewHolder(View itemView) {
            super(itemView);
            item_collection_service_name_tv= (TextView) itemView.findViewById(R.id.item_collection_service_name_tv);
            item_collection_service_price_tv= (TextView) itemView.findViewById(R.id.item_collection_service_price_tv);
            item_collection_service_number_tv= (TextView) itemView.findViewById(R.id.item_collection_service_number_tv);
            item_collection_service_cancel_tv= (TextView) itemView.findViewById(R.id.item_collection_service_cancel_tv);

            item_collection_service_img= (ImageView) itemView.findViewById(R.id.item_collection_service_img);

        }
    }
}