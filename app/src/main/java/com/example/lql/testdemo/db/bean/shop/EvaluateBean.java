package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：评价表
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class EvaluateBean {

    Long UserId;//用户id
    Long CommodityId;//商品id
    Long Time;//时间
    String Content;//评价内容
    public String getContent() {
        return this.Content;
    }
    public void setContent(String Content) {
        this.Content = Content;
    }
    public Long getTime() {
        return this.Time;
    }
    public void setTime(Long Time) {
        this.Time = Time;
    }
    public Long getCommodityId() {
        return this.CommodityId;
    }
    public void setCommodityId(Long CommodityId) {
        this.CommodityId = CommodityId;
    }
    public Long getUserId() {
        return this.UserId;
    }
    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }
    @Generated(hash = 653296050)
    public EvaluateBean(Long UserId, Long CommodityId, Long Time, String Content) {
        this.UserId = UserId;
        this.CommodityId = CommodityId;
        this.Time = Time;
        this.Content = Content;
    }
    @Generated(hash = 1614781969)
    public EvaluateBean() {
    }

    @Override
    public String toString() {
        return "EvaluateBean{" +
                "UserId=" + UserId +
                ", CommodityId=" + CommodityId +
                ", Time=" + Time +
                ", Content='" + Content + '\'' +
                '}';
    }
}
