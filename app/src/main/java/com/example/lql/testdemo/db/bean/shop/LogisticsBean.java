package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：物流信息表
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class LogisticsBean {
    Long OrderId;//订单号
    Long Time;//    时间
    String Describe;//    描述
    public String getDescribe() {
        return this.Describe;
    }
    public void setDescribe(String Describe) {
        this.Describe = Describe;
    }
    public Long getTime() {
        return this.Time;
    }
    public void setTime(Long Time) {
        this.Time = Time;
    }
    public Long getOrderId() {
        return this.OrderId;
    }
    public void setOrderId(Long OrderId) {
        this.OrderId = OrderId;
    }
    @Generated(hash = 1214026444)
    public LogisticsBean(Long OrderId, Long Time, String Describe) {
        this.OrderId = OrderId;
        this.Time = Time;
        this.Describe = Describe;
    }
    @Generated(hash = 1526887395)
    public LogisticsBean() {
    }

    @Override
    public String toString() {
        return "LogisticsBean{" +
                "OrderId=" + OrderId +
                ", Time=" + Time +
                ", Describe='" + Describe + '\'' +
                '}';
    }
}
