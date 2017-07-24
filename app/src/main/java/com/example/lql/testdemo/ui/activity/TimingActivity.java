package com.example.lql.testdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.bean.TimingBean;
import com.example.lql.testdemo.db.gen.TimingBeanDao;
import com.example.lql.testdemo.utils.MyStatusBarUtil;
import com.example.lql.testdemo.utils.ScreenUtils;
import com.example.lql.testdemo.utils.T;
import com.example.lql.testdemo.utils.TimingUtils.TimingUtils;
import com.example.lql.testdemo.utils.chooseDateUtils.DateUtils;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;
import com.example.lql.testdemo.utils.pickerview.lib.ArrayWheelAdapter;
import com.example.lql.testdemo.utils.pickerview.lib.WheelView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类描述：闹钟实现定时任务
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class TimingActivity extends AppCompatActivity implements View.OnClickListener {

    String type = "-1";
    private com.example.lql.testdemo.utils.pickerview.lib.WheelView hourwheel;
    private com.example.lql.testdemo.utils.pickerview.lib.WheelView minutewheel;
    private android.widget.TextView repeattime;
    private android.widget.LinearLayout repeatlayout;
    private android.widget.TextView deletebutton;
    private Toolbar timing_toolbar;
    TimingBeanDao timingBeanDao;
    String RepeatTime = "";
    ArrayList<String> hourList = new ArrayList<>();
    ArrayList<String> minuteList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing);
        MyStatusBarUtil.setStatusColor(this, getResources().getColor(R.color.colorAccent));


        timingBeanDao = DBManager.getInstance().getDaoSession().getTimingBeanDao();
        type = getIntent().getStringExtra("type");
        for (int i = 0; i < 10; i++) {
            hourList.add("0" + i);
            minuteList.add("0" + i);
        }

        for (int i = 10; i < 24; i++) {
            hourList.add(i + "");
        }
        for (int i = 10; i < 60; i++) {
            minuteList.add(i + "");
        }
        initView();

    }

    private void setData() {
        if (type.equals("-1")) {
            Date mDate = new Date();
            hourwheel.setCurrentItem(mDate.getHours());
            minutewheel.setCurrentItem(mDate.getMinutes());
            repeattime.setText("不重复");
            RepeatTime = "不重复";
        } else {
            getData();
        }
    }

    private void initView() {
        this.deletebutton = (TextView) findViewById(R.id.delete_button);
        this.timing_toolbar = (Toolbar) findViewById(R.id.timing_toolbar);
        this.repeatlayout = (LinearLayout) findViewById(R.id.repeat_layout);
        this.repeattime = (TextView) findViewById(R.id.repeat_time);
        this.minutewheel = (WheelView) findViewById(R.id.minute_wheel);
        this.hourwheel = (WheelView) findViewById(R.id.hour_wheel);
        //控制删除按钮的隐藏和显示
        deletebutton.setText(type.equals("-1") ? "添加闹钟" : "删除闹钟");
        //初始化toolbar
        timing_toolbar.setTitle(type.equals("-1") ? "添加闹钟" : "编辑闹钟");
        timing_toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.icon_back));
        timing_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        timing_toolbar.setTitleTextColor(getResources().getColor(R.color.color_fff));
        timing_toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));//背景色


        deletebutton.setOnClickListener(this);
        repeatlayout.setOnClickListener(this);
        hourwheel.setAdapter(new ArrayWheelAdapter<String>(hourList));
        minutewheel.setAdapter(new ArrayWheelAdapter<String>(minuteList));
        hourwheel.setItemsTextColor(0xFFFF4081);
        hourwheel.setLabel(getResources().getString(R.string.pickerview_hours));// 添加文字
        minutewheel.setLabel(getResources().getString(R.string.pickerview_minutes));// 添加文字
        hourwheel.TEXT_SIZE = (ScreenUtils.getScreenHeight(TimingActivity.this) / 200) * 8;
        minutewheel.TEXT_SIZE = (ScreenUtils.getScreenHeight(TimingActivity.this) / 200) * 8;

//        hourwheel.addChangingListener(new OnWheelChangedListener() {
//            @Override
//            public void onChanged(WheelView wheel, int oldValue, int newValue) {
//
//            }
//        });
//        minutewheel.addChangingListener(new OnWheelChangedListener() {
//            @Override
//            public void onChanged(WheelView wheel, int oldValue, int newValue) {
//
//            }
//        });

        setData();
    }


    private void getData() {
        TimingBean load = timingBeanDao.queryBuilder().where(TimingBeanDao.Properties.MyTimingId.eq(type)).build().unique();
        hourwheel.setCurrentItem(load.getHour());
        minutewheel.setCurrentItem(load.getMinute());
        repeattime.setText("每周" + load.getRepeatTime());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.delete_button:
                if (deletebutton.getText().toString().contains("添加")) {
                    int ClockId = makeId();

                    timingBeanDao.insert(new TimingBean(null, ClockId, hourwheel.getCurrentItem(), minutewheel.getCurrentItem()
                            , RepeatTime, true));
                    if (RepeatTime.contains("一") || RepeatTime.contains("二") || RepeatTime.contains("三")
                            || RepeatTime.contains("四") || RepeatTime.contains("五") || RepeatTime.contains("六")
                            || RepeatTime.contains("日")) {
                        if (RepeatTime.contains("一")) {
//                            Long EqId, Long SonEqId, int SonEqType, boolean IsNeedDo
                            TimingUtils.setClock(TimingActivity.this, 1, hourwheel.getCurrentItem(),
                                    minutewheel.getCurrentItem(), 1, ClockId, "");
                        }
                        if (RepeatTime.contains("二")) {
                            TimingUtils.setClock(TimingActivity.this, 1, hourwheel.getCurrentItem(), minutewheel.getCurrentItem(), 2, ClockId, "");
                        }
                        if (RepeatTime.contains("三")) {
                            TimingUtils.setClock(TimingActivity.this, 1, hourwheel.getCurrentItem(), minutewheel.getCurrentItem(), 3, ClockId, "");
                        }
                        if (RepeatTime.contains("四")) {
                            TimingUtils.setClock(TimingActivity.this, 1, hourwheel.getCurrentItem(), minutewheel.getCurrentItem(), 4, ClockId, "");
                        }
                        if (RepeatTime.contains("五")) {
                            TimingUtils.setClock(TimingActivity.this, 1, hourwheel.getCurrentItem(), minutewheel.getCurrentItem(), 5, ClockId, "");
                        }
                        if (RepeatTime.contains("六")) {
                            TimingUtils.setClock(TimingActivity.this, 1, hourwheel.getCurrentItem(), minutewheel.getCurrentItem(), 6, ClockId, "");
                        }
                        if (RepeatTime.contains("日")) {
                            TimingUtils.setClock(TimingActivity.this, 1, hourwheel.getCurrentItem(), minutewheel.getCurrentItem(), 7, ClockId, "");
                        }
                    } else {
                        TimingUtils.setClock(TimingActivity.this, 0, hourwheel.getCurrentItem(), minutewheel.getCurrentItem(), DateUtils.getMonthDayWeekNmuber(), ClockId, "");
                    }

                } else {
                    //删除按钮
                    timingBeanDao.delete(timingBeanDao.queryBuilder().where(TimingBeanDao.Properties.MyTimingId.eq(type)).build().unique());
                    T.shortToast(TimingActivity.this, "删除成功");
                    finish();
                }
                break;
            case R.id.repeat_layout:
                //选择重复
                Intent mIntent = new Intent(TimingActivity.this, TimingChooseDayActivity.class);
                mIntent.putExtra("RepeatTime", RepeatTime);
                startActivityForResult(mIntent, 0);
                break;
        }


    }


    private int makeId() {
        int ClockId = (int) (1 + Math.random() * (10000));
        if (CheckId(ClockId)) {
            makeId();
        }
        return ClockId;
    }

    /**
     * 检测有没有这个id
     *
     * @param ChokeId 生成的随机号
     * @return
     */
    private boolean CheckId(int ChokeId) {
        boolean IsHave = false;
        List<TimingBean> timingBeanList = timingBeanDao.queryBuilder().
                where(TimingBeanDao.Properties.MyTimingId.eq(ChokeId)).list();
        for (int j = 0; j < timingBeanList.size(); j++) {
            if (ChokeId == timingBeanList.get(j).getMyTimingId()) {
                IsHave = true;
                break;
            }
        }
        return IsHave;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) { //resultCode为回传的标记，我在B中回传的是RESULT_OK
            case RESULT_OK:
                Bundle b = data.getExtras(); //data为B中回传的Intent
                RepeatTime = b.getString("RepeatTime");//str即为回传的值
                repeattime.setText("每周" + RepeatTime);
                break;
            default:
                break;
        }
    }

}
