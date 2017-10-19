package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：购物车表
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class ShoppingCartBean {

    Long UserId;//用户id
    Integer Number;//    数量
    Long CommodityId;//    商品id
    Long CommoditySizeId;//规格的id

    public Long getCommodityId() {
        return this.CommodityId;
    }

    public void setCommodityId(Long CommodityId) {
        this.CommodityId = CommodityId;
    }

    public Integer getNumber() {
        return this.Number;
    }

    public void setNumber(Integer Number) {
        this.Number = Number;
    }

    public Long getUserId() {
        return this.UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    @Generated(hash = 1432753623)
    public ShoppingCartBean(Long UserId, Integer Number, Long CommodityId,
            Long CommoditySizeId) {
        this.UserId = UserId;
        this.Number = Number;
        this.CommodityId = CommodityId;
        this.CommoditySizeId = CommoditySizeId;
    }

    @Generated(hash = 1284272626)
    public ShoppingCartBean() {
    }

    @Override
    public String toString() {
        return "ShoppingCartBean{" +
                "UserId=" + UserId +
                ", Number=" + Number +
                ", CommodityId=" + CommodityId +
                '}';
    }

    public Long getCommoditySizeId() {
        return this.CommoditySizeId;
    }

    public void setCommoditySizeId(Long CommoditySizeId) {
        this.CommoditySizeId = CommoditySizeId;
    }
}
