package com.example.lql.testdemo.utils.popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lql.testdemo.R;

import java.util.ArrayList;


/**
 * 类描述：
 * 作  者：LQL
 * 时  间：2017/4/6
 * 修改备注：
 */
public class ListPopupAdapter extends BaseAdapter {

    private ArrayList<String> mList=new ArrayList<>();

    private Context mContext;

    public ListPopupAdapter(Context context) {
        mContext = context;
    }

    public void setList(ArrayList<String> mDataList){
        mList.clear();
        mList.addAll(mDataList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_listpopup,null);
        }
        TextView item_listpopup_tv= (TextView) convertView.findViewById(R.id.item_listpopup_tv);
        item_listpopup_tv.setText(mList.get(position));
        return convertView;
    }
}
