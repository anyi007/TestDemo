package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：收藏
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class CollectionBean   {

    Long UserId;//用户id
    Long CommodityId;//商品id
    Long Time;//时间
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
    @Generated(hash = 696711394)
    public CollectionBean(Long UserId, Long CommodityId, Long Time) {
        this.UserId = UserId;
        this.CommodityId = CommodityId;
        this.Time = Time;
    }
    @Generated(hash = 1423617684)
    public CollectionBean() {
    }


    @Override
    public String toString() {
        return "CollectionBean{" +
                "UserId=" + UserId +
                ", CommodityId=" + CommodityId +
                ", Time=" + Time +
                '}';
    }



}
