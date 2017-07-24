package com.example.lql.testdemo.utils.TimingUtils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.example.lql.testdemo.ui.activity.PlayAlarmAty;


/**
 * Created by nomasp on 2015/10/07.
 */
public class AlarmReceiver extends BroadcastReceiver {

    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("###", "闹钟执行了！");
        System.out.println("闹钟执行了！");
        String msg = intent.getStringExtra("msg");

        Long EqId = intent.getLongExtra("EqId", 0);
        Long SonEqId = intent.getLongExtra("SonEqId", 0);
        int SonEqType = intent.getIntExtra("SonEqType", 0);
        boolean IsNeedDo = intent.getBooleanExtra("IsNeedDo", false);


        int ClockId = intent.getIntExtra("ClockId", 0);
        Long intervalMillis = intent.getLongExtra("intervalMillis", 0);

        if (intervalMillis != 0 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TimingUtils.setAlarmTime(context, System.currentTimeMillis() + intervalMillis, intent);
        }

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.cancel(PendingIntent.getBroadcast(context, getResultCode(),
                new Intent(context, AlarmReceiver.class), 0));


        Intent i = new Intent(context, PlayAlarmAty.class);
        i.putExtra("ClockId", ClockId);
        i.putExtra("msg", msg);
        i.putExtra("EqId", EqId);
        i.putExtra("SonEqId", SonEqId);
        i.putExtra("SonEqType", SonEqType);
        i.putExtra("IsNeedDo", IsNeedDo);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);


    }


}
