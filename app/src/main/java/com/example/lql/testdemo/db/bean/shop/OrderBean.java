package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：订单表
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class OrderBean {
    @Id
    Long OrderId;   //订单id
    Integer OrderState;//    订单状态
    Double SumPrice;//    价格
    Long AddressId;//    收获地址id
//    Long LogisticsId;//物流id（不用物流id,查询物流的时候，用订单号去物流表里查询，然后排序）
    public Long getAddressId() {
        return this.AddressId;
    }
    public void setAddressId(Long AddressId) {
        this.AddressId = AddressId;
    }
    public Double getSumPrice() {
        return this.SumPrice;
    }
    public void setSumPrice(Double SumPrice) {
        this.SumPrice = SumPrice;
    }
    public Integer getOrderState() {
        return this.OrderState;
    }
    public void setOrderState(Integer OrderState) {
        this.OrderState = OrderState;
    }
    public Long getOrderId() {
        return this.OrderId;
    }
    public void setOrderId(Long OrderId) {
        this.OrderId = OrderId;
    }
    @Generated(hash = 108134094)
    public OrderBean(Long OrderId, Integer OrderState, Double SumPrice,
            Long AddressId) {
        this.OrderId = OrderId;
        this.OrderState = OrderState;
        this.SumPrice = SumPrice;
        this.AddressId = AddressId;
    }
    @Generated(hash = 1725534308)
    public OrderBean() {
    }


    @Override
    public String toString() {
        return "OrderBean{" +
                "OrderId=" + OrderId +
                ", OrderState=" + OrderState +
                ", SumPrice=" + SumPrice +
                ", AddressId=" + AddressId +
                '}';
    }
}
