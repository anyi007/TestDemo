package com.example.lql.choosetime.pickerview.lib;

import android.content.Context;
import android.view.View;

import com.example.lql.choosetime.R;
import com.example.lql.choosetime.pickerview.TimePopupWindow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


public class WheelTime {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private View view;
    private WheelView wv_year;
    private WheelView wv_month;
    private WheelView wv_day;
    private WheelView wv_hours;
    private WheelView wv_mins;
    public int screenheight;

    //最开始的年月日时分
    int currentYear = 0;
//    int currentMonth = 0;
//    int currentDay = 0;
//    int currentH = 0;
//    int currentM = 0;

    private TimePopupWindow.Type type;
    private static int START_YEAR = 1990, END_YEAR = 2100;
    private static int START_MONTH = 1, END_MONTH = 12;
    private static int START_DAY = 1, END_DAY = 31;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public static int getSTART_YEAR() {
        return START_YEAR;
    }

    public static void setSTART_YEAR(int sTART_YEAR) {
        START_YEAR = sTART_YEAR;
    }

    public static int getEND_YEAR() {
        return END_YEAR;
    }

    public static void setEND_YEAR(int eND_YEAR) {
        END_YEAR = eND_YEAR;
    }


    public static int getStartMonth() {
        return START_MONTH;
    }

    public static void setStartMonth(int startMonth) {
        START_MONTH = startMonth;
    }

    public static int getEndMonth() {
        return END_MONTH;
    }

    public static void setEndMonth(int endMonth) {
        END_MONTH = endMonth;
    }

    public static int getStartDay() {
        return START_DAY;
    }

    public static void setStartDay(int startDay) {
        START_DAY = startDay;
    }

    public static int getEndDay() {
        return END_DAY;
    }

    public static void setEndDay(int endDay) {
        END_DAY = endDay;
    }

    public WheelTime(View view) {
        super();
        this.view = view;
        type = TimePopupWindow.Type.ALL;
        setView(view);
    }

    public WheelTime(View view, TimePopupWindow.Type type) {
        super();
        this.view = view;
        this.type = type;
        setView(view);
    }

    public void setPicker(int year, int month, int day) {
        this.setPicker(year, month, day, 0, 0);
    }

    /**
     * @Description: 弹出日期时间选择器
     */
    public void setPicker(final int year, final int month, int day, int h, int m) {


        // 添加大小月月份并将其转换为list,方便之后的判断
        String[] months_big = {"1", "3", "5", "7", "8", "10", "12"};
        String[] months_little = {"4", "6", "9", "11"};

        final List<String> list_big = Arrays.asList(months_big);
        final List<String> list_little = Arrays.asList(months_little);

        Context context = view.getContext();
        // 年
        wv_year = (WheelView) view.findViewById(R.id.year);
        wv_year.setAdapter(new NumericWheelAdapter(START_YEAR, END_YEAR));// 设置"年"的显示数据
        wv_year.setLabel(context.getString(R.string.pickerview_year));// 添加文字
        wv_year.setCurrentItem(0);// 初始化时显示的数据


        // 月
        wv_month = (WheelView) view.findViewById(R.id.month);
        wv_month.setAdapter(new NumericWheelAdapter(START_MONTH, 12));
        wv_month.setLabel(context.getString(R.string.pickerview_month));
        wv_month.setCurrentItem(0);


        // 日
        wv_day = (WheelView) view.findViewById(R.id.day);
        wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 31));
        // 判断大小月及是否闰年,用来确定"日"的数据
        if (list_big.contains(String.valueOf(START_MONTH))) {
            wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 31));
        } else if (list_little.contains(String.valueOf(START_MONTH))) {
            wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 30));
        } else {
            // 闰年
            if ((START_YEAR % 4 == 0 && START_YEAR % 100 != 0) || START_YEAR % 400 == 0)
                wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 29));
            else
                wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 28));
        }
        wv_day.setLabel(context.getString(R.string.pickerview_day));
        wv_day.setCurrentItem(0);

        wv_hours = (WheelView) view.findViewById(R.id.hour);
        wv_hours.setAdapter(new NumericWheelAdapter(0, 23));
        wv_hours.setLabel(context.getString(R.string.pickerview_hours));// 添加文字
        wv_hours.setCurrentItem(0);

        wv_mins = (WheelView) view.findViewById(R.id.min);
        wv_mins.setAdapter(new NumericWheelAdapter(0, 59));
        wv_mins.setLabel(context.getString(R.string.pickerview_minutes));// 添加文字
        wv_mins.setCurrentItem(0);

        // 添加"年"监听
        OnWheelChangedListener wheelListener_year = new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                int year_num = newValue + START_YEAR;
                currentYear = newValue;
                //先设置月
                if (year_num == START_YEAR) {
                    wv_month.setAdapter(new NumericWheelAdapter(START_MONTH, 12));
                    wv_month.setCurrentItem(0);
                    //然后根据大小月，设置天数
                    if (list_big
                            .contains(String.valueOf(wv_month.getCurrentItem() + START_MONTH))) {
                        wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 31));
                    } else if (list_little.contains(String.valueOf(wv_month
                            .getCurrentItem() + START_MONTH))) {
                        wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 30));
                    } else {
                        if ((year_num % 4 == 0 && year_num % 100 != 0)
                                || year_num % 400 == 0) {
                            wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 29));
                        } else {
                            wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 28));
                        }
                    }
                    wv_day.setCurrentItem(0);
                } else if (year_num == END_YEAR) {
                    wv_month.setAdapter(new NumericWheelAdapter(1, END_MONTH < 12 ? END_MONTH : 12));
                    wv_month.setCurrentItem(0);
                    //判断最后一个月是不是1月
                    if (END_MONTH != 1) {
                        //那么1月份的天数一定是1-31天
                        wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                        wv_day.setCurrentItem(0);
                    } else {
                        //那么1月份的天数一定是1-31天
                        wv_day.setAdapter(new NumericWheelAdapter(1, END_DAY < 31 ? END_DAY : 31));
                        wv_day.setCurrentItem(0);
                    }
                } else {
                    //不是开始的年份，不是结束的年份，月份就是从1月到12月
                    wv_month.setAdapter(new NumericWheelAdapter(1, 12));
                    wv_month.setCurrentItem(0);
                    //那么1月份的天数一定是1-31天
                    wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                    wv_day.setCurrentItem(0);
                }
            }
        };
        // 添加"月"监听
        OnWheelChangedListener wheelListener_month = new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                int month_num = newValue + 1;
                int year_num = currentYear + START_YEAR;
                if (year_num == START_YEAR) {//开始年份
                    if (month_num == START_MONTH) {//还是开始的月份
                        //然后根据大小月，设置天数
                        if (list_big.contains(String.valueOf(wv_month.getCurrentItem() + START_MONTH))) {
                            wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 31));
                        } else if (list_little.contains(String.valueOf(wv_month.getCurrentItem() + START_MONTH))) {
                            wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 30));
                        } else {
                            if ((year_num % 4 == 0 && year_num % 100 != 0)
                                    || year_num % 400 == 0) {
                                wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 29));
                            } else {
                                wv_day.setAdapter(new NumericWheelAdapter(START_DAY, 28));
                            }
                        }
                        wv_day.setCurrentItem(0);
                    } else {//不是开始的月份
                        //然后根据大小月，设置天数
                        if (list_big
                                .contains(String.valueOf(wv_month.getCurrentItem() + START_MONTH))) {
                            wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                        } else if (list_little.contains(String.valueOf(wv_month
                                .getCurrentItem() + START_MONTH))) {
                            wv_day.setAdapter(new NumericWheelAdapter(1, 30));
                        } else {
                            if ((year_num % 4 == 0 && year_num % 100 != 0)
                                    || year_num % 400 == 0) {
                                wv_day.setAdapter(new NumericWheelAdapter(1, 29));
                            } else {
                                wv_day.setAdapter(new NumericWheelAdapter(1, 28));
                            }
                        }
                        wv_day.setCurrentItem(0);
                    }
                } else if (year_num == END_YEAR) {//结束年份
                    if (month_num == END_MONTH) {//还是结束的月份
                        int lastday = END_DAY;
                        //然后根据大小月，设置天数
                        if (list_big
                                .contains(String.valueOf(wv_month.getCurrentItem() + 1))) {
                            lastday = lastday < 31 ? lastday : 31;

                        } else if (list_little.contains(String.valueOf(wv_month
                                .getCurrentItem() + 1))) {
                            lastday = lastday < 30 ? lastday : 30;
                        } else {
                            if ((year_num % 4 == 0 && year_num % 100 != 0)
                                    || year_num % 400 == 0) {
                                lastday = lastday < 29 ? lastday : 29;
                            } else {
                                lastday = lastday < 28 ? lastday : 28;
                            }
                        }
                        wv_day.setAdapter(new NumericWheelAdapter(1, lastday));
                        wv_day.setCurrentItem(0);
                    } else {//不是结束的月份
                        //然后根据大小月，设置天数
                        if (list_big
                                .contains(String.valueOf(wv_month.getCurrentItem() + 1))) {
                            wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                        } else if (list_little.contains(String.valueOf(wv_month
                                .getCurrentItem() + 1))) {
                            wv_day.setAdapter(new NumericWheelAdapter(1, 30));
                        } else {
                            if ((year_num % 4 == 0 && year_num % 100 != 0)
                                    || year_num % 400 == 0) {
                                wv_day.setAdapter(new NumericWheelAdapter(1, 29));
                            } else {
                                wv_day.setAdapter(new NumericWheelAdapter(1, 28));
                            }
                        }
                        wv_day.setCurrentItem(0);
                    }
                } else {
                    //然后根据大小月，设置天数
                    if (list_big
                            .contains(String.valueOf(wv_month.getCurrentItem() + 1))) {
                        wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                    } else if (list_little.contains(String.valueOf(wv_month
                            .getCurrentItem() + 1))) {
                        wv_day.setAdapter(new NumericWheelAdapter(1, 30));
                    } else {
                        if ((year_num % 4 == 0 && year_num % 100 != 0)
                                || year_num % 400 == 0) {
                            wv_day.setAdapter(new NumericWheelAdapter(1, 29));
                        } else {
                            wv_day.setAdapter(new NumericWheelAdapter(1, 28));
                        }
                    }
                    wv_day.setCurrentItem(0);
                }

            }
        };
        wv_year.addChangingListener(wheelListener_year);
        wv_month.addChangingListener(wheelListener_month);

        // 根据屏幕密度来指定选择器字体的大小(不同屏幕可能不同)
        int textSize = 0;
        switch (type) {
            case ALL:
                textSize = (screenheight / 200) * 3;
                break;
            case YEAR_MONTH_DAY:
                textSize = (screenheight / 200) * 4;
                wv_hours.setVisibility(View.GONE);
                wv_mins.setVisibility(View.GONE);
                break;
            case HOURS_MINS:
                textSize = (screenheight / 200) * 4;
                wv_year.setVisibility(View.GONE);
                wv_month.setVisibility(View.GONE);
                wv_day.setVisibility(View.GONE);
                break;
            case MONTH_DAY_HOUR_MIN:
                textSize = (screenheight / 200) * 3;
                wv_year.setVisibility(View.GONE);
                break;
            case YEAR_MONTH_DAY_HOURS:
                textSize = (screenheight / 200) * 5;
                wv_mins.setVisibility(View.GONE);
                break;
            case YEAR_MONTH:
                textSize = (screenheight / 200) * 4;
                wv_day.setVisibility(View.GONE);
                wv_hours.setVisibility(View.GONE);
                wv_mins.setVisibility(View.GONE);
                break;
        }

        wv_day.TEXT_SIZE = textSize;
        wv_month.TEXT_SIZE = textSize;
        wv_year.TEXT_SIZE = textSize;
        wv_hours.TEXT_SIZE = textSize;
        wv_mins.TEXT_SIZE = textSize;

    }

    /**
     * 设置是否循环滚动
     *
     * @param cyclic
     */
    public void setCyclic(boolean cyclic) {
        wv_year.setCyclic(cyclic);
        wv_month.setCyclic(cyclic);
        wv_day.setCyclic(cyclic);
        wv_hours.setCyclic(cyclic);
        wv_mins.setCyclic(cyclic);
    }

    public String getTime() {
        StringBuffer sb = new StringBuffer();
        sb.append((wv_year.getCurrentItem() + START_YEAR)).append("-")
                .append((wv_month.getCurrentItem() + 1)).append("-")
                .append((wv_day.getCurrentItem() + 1)).append(" ")
                .append(wv_hours.getCurrentItem()).append(":")
                .append(wv_mins.getCurrentItem());
        return sb.toString();
    }
}
