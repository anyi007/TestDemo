package com.example.lql.choosetime.pickerview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

import com.example.lql.choosetime.R;
import com.example.lql.choosetime.pickerview.lib.ScreenInfo;
import com.example.lql.choosetime.pickerview.lib.WheelTime;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间选择器
 *
 * @author Sai
 */
public class TimePopupWindow extends PopupWindow implements OnClickListener {
    public enum Type {
        ALL, YEAR_MONTH_DAY, YEAR_MONTH, HOURS_MINS, MONTH_DAY_HOUR_MIN, YEAR_MONTH_DAY_HOURS
    }// 五种选择模式，年月日时分，年月日，年月，时分，月日时分

    private View rootView; // 总的布局
    WheelTime wheelTime;
    private View btnSubmit, btnCancel;
    private static final String TAG_SUBMIT = "submit";
    private static final String TAG_CANCEL = "cancel";
    private OnTimeSelectListener timeSelectListener;

    public TimePopupWindow(Context context, Type type, int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
        super(context);
        this.setWidth(LayoutParams.FILL_PARENT);
        this.setHeight(LayoutParams.WRAP_CONTENT);
        this.setBackgroundDrawable(new BitmapDrawable());// 这样设置才能点击屏幕外dismiss窗口
        this.setOutsideTouchable(true);
        this.setAnimationStyle(R.style.ActionSheetDialogAnimation);

        LayoutInflater mLayoutInflater = LayoutInflater.from(context);
        rootView = mLayoutInflater.inflate(R.layout.pw_time, null);
        // -----确定和取消按钮
        btnSubmit = rootView.findViewById(R.id.btnSubmit);
        btnSubmit.setTag(TAG_SUBMIT);
        btnCancel = rootView.findViewById(R.id.btnCancel);
        btnCancel.setTag(TAG_CANCEL);
        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        // ----时间转轮
        final View timepickerview = rootView.findViewById(R.id.timepicker);
        ScreenInfo screenInfo = new ScreenInfo((Activity) context);
        wheelTime = new WheelTime(timepickerview, type);

        wheelTime.screenheight = screenInfo.getHeight();

        //默认选中当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        wheelTime.setPicker(year, month, day, hours, minute);
        setRange(startYear, startMonth, startDay, endYear, endMonth, endDay);
        setContentView(rootView);
    }

    /**
     * 设置可以选择的时间范围
     *
     * @param START_YEAR
     * @param END_YEAR
     */

    /**
     * 设置可以选择时间范围
     *
     * @param startYear  开始的年份
     * @param startMonth
     * @param startDay
     * @param endYear
     * @param endMonth
     * @param endDay
     */
    public void setRange(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
        WheelTime.setSTART_YEAR(startYear);
        WheelTime.setStartMonth(startMonth);
        WheelTime.setStartDay(startDay);

        WheelTime.setEND_YEAR(endYear);
        WheelTime.setEndMonth(endMonth);
        WheelTime.setEndDay(endDay);

//        WheelTime.setSTART_YEAR(2000);
//        WheelTime.setStartMonth(1);
//        WheelTime.setStartDay(10);
//
//        WheelTime.setEND_YEAR(2017);
//        WheelTime.setEndMonth(1);
//        WheelTime.setEndDay(15);
    }


    /**
     * 设置选中时间
     *
     * @param date
     */
    public void setTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null)
            calendar.setTimeInMillis(System.currentTimeMillis());
        else
            calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        wheelTime.setPicker(year, month, day, hours, minute);
    }

    /**
     * 指定选中的时间，显示选择器
     *
     * @param parent
     * @param gravity
     * @param x
     * @param y
     * @param date
     */
    public void showAtLocation(View parent, int gravity, int x, int y, Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null)
            calendar.setTimeInMillis(System.currentTimeMillis());
        else
            calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        wheelTime.setPicker(year, month, day, hours, minute);
        update();
        super.showAtLocation(parent, gravity, x, y);
    }

    public void showAtLocation(View parent, int gravity, int x, int y) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        wheelTime.setPicker(year, month, day, hours, minute);
        update();
        super.showAtLocation(parent, gravity, x, y);
    }

    /**
     * 设置是否循环滚动
     *
     * @param cyclic
     */
    public void setCyclic(boolean cyclic) {
        wheelTime.setCyclic(cyclic);
    }

    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        if (tag.equals(TAG_CANCEL)) {
            dismiss();
            return;
        } else {
            if (timeSelectListener != null) {
                try {
                    Date date = WheelTime.dateFormat.parse(wheelTime.getTime());
                    timeSelectListener.onTimeSelect(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            dismiss();
            return;
        }
    }

    public interface OnTimeSelectListener {
        public void onTimeSelect(Date date);
    }

    public void setOnTimeSelectListener(OnTimeSelectListener timeSelectListener) {
        this.timeSelectListener = timeSelectListener;
    }

}
