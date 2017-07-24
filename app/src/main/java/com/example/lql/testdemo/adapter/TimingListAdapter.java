package com.example.lql.testdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.bean.TimingBean;
import com.example.lql.testdemo.db.gen.TimingBeanDao;
import com.example.lql.testdemo.utils.RecyclerView.OnItemClickListener;
import com.example.lql.testdemo.utils.TimingUtils.TimingUtils;
import com.example.lql.testdemo.utils.chooseDateUtils.DateUtils;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.ArrayList;

/**
 * 类描述：闹钟列表
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class TimingListAdapter extends RecyclerView.Adapter<TimingListAdapter.TimingListViewHolder> {

    TimingBeanDao mTimingBeanDao;
    private Context mContext;

    public TimingListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<TimingBean> mList = new ArrayList<>();

    public void setList(ArrayList<TimingBean> mDataList) {
        mList.clear();
        mList.addAll(mDataList);
        notifyDataSetChanged();
    }

    private OnItemClickListener mClick;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        mClick = mOnItemClickListener;
    }

//    item_timing_list

    @Override
    public TimingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TimingListAdapter.TimingListViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_timing_list, parent, false));
    }

    @Override
    public void onBindViewHolder(final TimingListViewHolder holder, final int position) {
        if (mClick != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClick.onItemClick(holder.itemView, position);
                }
            });
        }

        if (position == 0) {
            holder.add_layout.setVisibility(View.VISIBLE);
            holder.timing_layout.setVisibility(View.GONE);
        } else {
            holder.add_layout.setVisibility(View.GONE);
            holder.timing_layout.setVisibility(View.VISIBLE);
            String hour = mList.get(position - 1).getHour().toString().length() == 1 ? "0" + mList.get(position - 1).getHour().toString() :
                    mList.get(position - 1).getHour().toString();
            String min = mList.get(position - 1).getMinute().toString().length() == 1 ? "0" + mList.get(position - 1).getMinute().toString() :
                    mList.get(position - 1).getMinute().toString();
            holder.item_time.setText(hour + ":" + min);
            String RepeatTime = mList.get(position - 1).getRepeatTime();
            if (RepeatTime.contains("一") || RepeatTime.contains("二") || RepeatTime.contains("三")
                    || RepeatTime.contains("四") || RepeatTime.contains("五") || RepeatTime.contains("六")
                    || RepeatTime.contains("日")) {
                holder.item_repeat_time.setText("每周 " + mList.get(position - 1).getRepeatTime());
            } else {
                holder.item_repeat_time.setText("每周 " + mList.get(position - 1).getRepeatTime());
            }

            holder.mSwitch.setChecked(mList.get(position - 1).getIsOpen());
            holder.mSwitch.setOnClickListener(new SwitchClick(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }


    class SwitchClick implements View.OnClickListener {

        int index;

        public SwitchClick(int index) {
            this.index = index;
        }

        @Override
        public void onClick(View view) {
            if (mTimingBeanDao == null) {
                mTimingBeanDao = DBManager.getInstance().getDaoSession().getTimingBeanDao();
            }

            TimingBean unique = mTimingBeanDao.queryBuilder().
                    where(TimingBeanDao.Properties.MyTimingId.eq(mList.get(index).getMyTimingId())).
                    build().unique();
            if (mList.get(index).getIsOpen()) {
                //更改数据源
                mList.get(index).setIsOpen(false);
                //关闭闹钟
                TimingUtils.cancelAlarm(mContext, mList.get(index).getMyTimingId());
                //更改数据库数据
                unique.setIsOpen(false);
            } else {
                unique.setIsOpen(true);
                mList.get(index).setIsOpen(true);
                String RepeatTime = mList.get(index).getRepeatTime();
                int hour = mList.get(index).getHour();
                int minute = mList.get(index).getMinute();
                int ClockId = mList.get(index).getMyTimingId();
                if (RepeatTime.contains("一") || RepeatTime.contains("二") || RepeatTime.contains("三")
                        || RepeatTime.contains("四") || RepeatTime.contains("五") || RepeatTime.contains("六")
                        || RepeatTime.contains("日")) {
                    if (RepeatTime.contains("一")) {
                        TimingUtils.setClock(mContext, 1, hour, minute, 1, ClockId, "");
                    }
                    if (RepeatTime.contains("二")) {
                        TimingUtils.setClock(mContext, 1, hour, minute, 2, ClockId, "");
                    }
                    if (RepeatTime.contains("三")) {
                        TimingUtils.setClock(mContext, 1, hour, minute, 3, ClockId, "");
                    }
                    if (RepeatTime.contains("四")) {
                        TimingUtils.setClock(mContext, 1, hour, minute, 4, ClockId, "");
                    }
                    if (RepeatTime.contains("五")) {
                        TimingUtils.setClock(mContext, 1, hour, minute, 5, ClockId, "");
                    }
                    if (RepeatTime.contains("六")) {
                        TimingUtils.setClock(mContext, 1, hour, minute, 6, ClockId, "");
                    }
                    if (RepeatTime.contains("日")) {
                        TimingUtils.setClock(mContext, 1, hour, minute, 7, ClockId, "");
                    }
                } else {
                    TimingUtils.setClock(mContext, 0, hour, minute, DateUtils.getMonthDayWeekNmuber(), ClockId, "");
                }
            }

            mTimingBeanDao.update(unique);
            notifyDataSetChanged();
        }
    }


    class TimingListViewHolder extends RecyclerView.ViewHolder {
        LinearLayout add_layout;//添加布局
        LinearLayout timing_layout;//闹钟布局
        TextView item_time;//时间
        TextView item_repeat_time;//重复时间
        Switch mSwitch;//开关


        public TimingListViewHolder(View itemView) {
            super(itemView);
            add_layout = (LinearLayout) itemView.findViewById(R.id.add_layout);
            timing_layout = (LinearLayout) itemView.findViewById(R.id.timing_layout);
            item_time = (TextView) itemView.findViewById(R.id.item_time);
            item_repeat_time = (TextView) itemView.findViewById(R.id.item_repeat_time);
            mSwitch = (Switch) itemView.findViewById(R.id.item_open);
        }
    }


}
