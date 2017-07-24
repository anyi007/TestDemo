package com.example.lql.testdemo.utils.TimingUtils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Build;

import com.example.lql.testdemo.utils.T;


/**
 * Created by Admin on 2017/7/20.
 */

public class TimingUtils {

    public static void setAlarmTime(Context context, long timeInMillis, Intent intent) {

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent sender = PendingIntent.getBroadcast(context, intent.getIntExtra("ClockId", 0),
                intent, PendingIntent.FLAG_CANCEL_CURRENT);
        int interval = (int) intent.getLongExtra("intervalMillis", 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            am.setExact(AlarmManager.RTC_WAKEUP, timeInMillis, sender);
        }
//        am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMillis, interval, sender);
    }

    /**
     * 周期闹钟
     *
     * @param mContext
     * @param flag     0：一次性闹钟  1：每周重复一次
     * @param Hour
     * @param Min
     * @param week     周几   1-7（周一到周日）
     * @param ClockId  闹钟id
     * @param msg      提示信息
     */
    public static void setClock(Context mContext, int flag, int Hour, int Min, int week, int ClockId, String msg) {
        long intervalMillis = 0;
        if (flag != 0) {
            intervalMillis = 24 * 3600 * 1000 * 7;
//            intervalMillis = 60 * 1000;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get
                (Calendar.DAY_OF_MONTH), Hour, Min, 0);

        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);

        Intent mIntent = new Intent(mContext, AlarmReceiver.class);
        mIntent.putExtra("ClockId", ClockId);
        mIntent.putExtra("intervalMillis", intervalMillis);
        mIntent.putExtra("msg", msg);
        PendingIntent broadcast = PendingIntent.getBroadcast(mContext, ClockId, mIntent,  PendingIntent
                .FLAG_CANCEL_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calMethod(week, calendar.getTimeInMillis()), broadcast);
        } else {
            if (flag == 0) {
                alarmManager.set(AlarmManager.RTC_WAKEUP, calMethod(week, calendar.getTimeInMillis()), broadcast);
            } else {
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calMethod(week, calendar.getTimeInMillis()), intervalMillis, broadcast);
            }
        }

        T.shortToast(mContext, "设置成功");
    }

    /**
     * 关闭某个闹钟
     *
     * @param mContext
     * @param id
     */
    public static void cancelAlarm(Context mContext, int id) {
        Intent intent = new Intent(mContext, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(mContext, id, intent, PendingIntent
                .FLAG_CANCEL_CURRENT);
        AlarmManager am = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        am.cancel(pi);
    }


    /**
     * @param weekflag 传入的是周几
     * @param dateTime 传入的是时间戳（设置当天的年月日+从选择框拿来的时分秒）
     * @return 返回起始闹钟时间的时间戳
     */
    private static long calMethod(int weekflag, long dateTime) {
        long time = 0;
        //weekflag == 0表示是按天为周期性的时间间隔或者是一次行的，weekfalg非0时表示每周几的闹钟并以周为时间间隔
        if (weekflag != 0) {
            Calendar c = Calendar.getInstance();
            int week = c.get(Calendar.DAY_OF_WEEK);
            if (1 == week) {
                week = 7;
            } else if (2 == week) {
                week = 1;
            } else if (3 == week) {
                week = 2;
            } else if (4 == week) {
                week = 3;
            } else if (5 == week) {
                week = 4;
            } else if (6 == week) {
                week = 5;
            } else if (7 == week) {
                week = 6;
            }

            if (weekflag == week) {
                if (dateTime > System.currentTimeMillis()) {
                    time = dateTime;
                } else {
                    time = dateTime + 7 * 24 * 3600 * 1000;
                }
            } else if (weekflag > week) {
                time = dateTime + (weekflag - week) * 24 * 3600 * 1000;
            } else if (weekflag < week) {
                time = dateTime + (weekflag - week + 7) * 24 * 3600 * 1000;
            }
        } else {
            if (dateTime > System.currentTimeMillis()) {
                time = dateTime;
            } else {
                time = dateTime + 24 * 3600 * 1000;
            }
        }
        return time;
    }


}
