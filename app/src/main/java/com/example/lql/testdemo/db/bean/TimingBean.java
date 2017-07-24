package com.example.lql.testdemo.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：闹钟数据表
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
@Entity
public class TimingBean {
    @Id
    Long TimingId;
    Integer MyTimingId;//
    Integer Hour;//小时
    Integer Minute;//分钟
    String RepeatTime;//重复时间
    boolean IsOpen;//开关状态

    public boolean getIsOpen() {
        return this.IsOpen;
    }

    public void setIsOpen(boolean IsOpen) {
        this.IsOpen = IsOpen;
    }

    public String getRepeatTime() {
        return this.RepeatTime;
    }

    public void setRepeatTime(String RepeatTime) {
        this.RepeatTime = RepeatTime;
    }


    public Long getTimingId() {
        return this.TimingId;
    }

    public void setTimingId(Long TimingId) {
        this.TimingId = TimingId;
    }


    public Integer getMinute() {
        return this.Minute;
    }

    public void setMinute(Integer Minute) {
        this.Minute = Minute;
    }

    public Integer getHour() {
        return this.Hour;
    }

    public void setHour(Integer Hour) {
        this.Hour = Hour;
    }

   

    public void setMyTimingId(Integer MyTimingId) {
        this.MyTimingId = MyTimingId;
    }

    public Integer getMyTimingId() {
        return this.MyTimingId;
    }

    @Generated(hash = 1177501412)
    public TimingBean(Long TimingId, Integer MyTimingId, Integer Hour,
            Integer Minute, String RepeatTime, boolean IsOpen) {
        this.TimingId = TimingId;
        this.MyTimingId = MyTimingId;
        this.Hour = Hour;
        this.Minute = Minute;
        this.RepeatTime = RepeatTime;
        this.IsOpen = IsOpen;
    }

    @Generated(hash = 1771902821)
    public TimingBean() {
    }
}
