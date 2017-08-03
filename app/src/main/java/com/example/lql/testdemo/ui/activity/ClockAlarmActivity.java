package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.gen.TimingBeanDao;
import com.example.lql.testdemo.ui.BaseActivity;
import com.example.lql.testdemo.utils.LogUtils;

/**
 * 类描述：闹钟时间到了之后在这个activity里边接收数据
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class ClockAlarmActivity extends BaseActivity {

    TimingBeanDao mTimingBeanDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clockalarm);
        LogUtils.Loge("ClockId:" + 111111111);
//        String message = this.getIntent().getStringExtra("msg");
//        int ClockId = this.getIntent().getIntExtra("ClockId", 0);//闹钟的id
//        LogUtils.Loge("ClockId:" + ClockId);
//        LogUtils.Loge("message:" + message);
//        mTimingBeanDao = DBManager.getInstance().getDaoSession().getTimingBeanDao();
//        List<TimingBean> timingBeanList = mTimingBeanDao.queryBuilder().
//                where(TimingBeanDao.Properties.MyTimingId.eq(ClockId)).
//                where(TimingBeanDao.Properties.IsOpen.eq(true)).list();
//        if (timingBeanList != null && timingBeanList.size() != 0) {
//            for (int i = 0; i < timingBeanList.size(); i++) {
//                LogUtils.Loge("闹钟响起来了" + timingBeanList.get(i).getHour()
//                        + timingBeanList.get(i).getMinute() + timingBeanList.get(i).getRepeatTime());
//            }
//        }
    }
}
