package com.example.lql.testdemo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.ScreenUtils;
import com.example.lql.testdemo.utils.gildeUtils.GlideApp;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;

import java.util.List;

/**
 * Created by shiqkuangsan on 2016/9/13.
 */

/**
 * 图片查看主界面的GridView适配器
 */
public class PicGridAdapter extends BaseAdapter {

    private List<String> picsList;
    private Context context;

    public PicGridAdapter(List<String> picsList, Context context) {
        this.picsList = picsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return picsList == null ? 0 : picsList.size();
    }

    @Override
    public Object getItem(int position) {
        return picsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
           convertView = LayoutInflater.from(context).inflate(R.layout.item_img,null);
        }
        ImageView img= (ImageView) convertView.findViewById(R.id.item_img);

        LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) img.getLayoutParams(); //取控件textView当前的布局参数

        linearParams.height = (ScreenUtils.getScreenWidth(context)/3);// 控件的高强制设成20
        linearParams.width = linearParams.height;// 控件的宽强制设成30

        img.setLayoutParams(linearParams); //使设置好的布局参数应用到控件



        if(TextUtils.isEmpty(picsList.get(position))){
            //清空旧数据的引用
            GlideApp.with(context).clear(img);
            //当资源为空时候，设置默认图片
            img.setImageResource(R.drawable.loading);
        }else{//开启一个图片加载
            GlidePicUtils.LoadImg(context ,img , picsList.get(position));
        }

        return convertView;
    }

}
