package com.example.lql.testdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.gildeUtils.GlideApp;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;

import java.util.ArrayList;

/**
 * 类描述：glide在recyclerview中使用
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class PicRecyclerviewAdapter extends  RecyclerView.Adapter<PicRecyclerviewAdapter.ViewHolder>{

    private Context mContext;

    public PicRecyclerviewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<String> mList=new ArrayList<>();

    public void setList(ArrayList<String> mDataList){
        mList.clear();
        mList.addAll(mDataList);
        notifyDataSetChanged();
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_gilde , parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.test_tv.setText("看左边的美女");

        if(TextUtils.isEmpty(mList.get(position))){
            //清空旧数据的引用
            GlideApp.with(mContext).clear(holder.test_img);
            //当资源为空时候，设置默认图片
            holder.test_img.setImageResource(R.drawable.loading);
        }else{//开启一个图片加载
            GlidePicUtils.LoadImg(mContext , holder.test_img ,mList.get(position) );
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView test_img;
        TextView test_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            test_img= (ImageView) itemView.findViewById(R.id.test_img);
            test_tv= (TextView) itemView.findViewById(R.id.test_tv);
        }
    }


}
