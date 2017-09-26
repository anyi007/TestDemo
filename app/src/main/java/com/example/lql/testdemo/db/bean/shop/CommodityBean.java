package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 类描述：商品表
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class CommodityBean   {


    @Id
    Long CommodityId;//商品id
    Long CommodityTypeId;//分类id
    String CommodityPic;//图片
    Double CommodityPrice;//价格
    Integer Stock;//库存
    String CommodityDescribe;//    商品描述
    String CommodityName;//名称
    String CommoditySize;//size
    boolean HotCommodity;//是否为热门商品

    public String getCommodityName() {
        return this.CommodityName;
    }
    public void setCommodityName(String CommodityName) {
        this.CommodityName = CommodityName;
    }
    public String getCommodityDescribe() {
        return this.CommodityDescribe;
    }
    public void setCommodityDescribe(String CommodityDescribe) {
        this.CommodityDescribe = CommodityDescribe;
    }
    public Integer getStock() {
        return this.Stock;
    }
    public void setStock(Integer Stock) {
        this.Stock = Stock;
    }
    public Double getCommodityPrice() {
        return this.CommodityPrice;
    }
    public void setCommodityPrice(Double CommodityPrice) {
        this.CommodityPrice = CommodityPrice;
    }
    public String getCommodityPic() {
        return this.CommodityPic;
    }
    public void setCommodityPic(String CommodityPic) {
        this.CommodityPic = CommodityPic;
    }
    public Long getCommodityTypeId() {
        return this.CommodityTypeId;
    }
    public void setCommodityTypeId(Long CommodityTypeId) {
        this.CommodityTypeId = CommodityTypeId;
    }
    public Long getCommodityId() {
        return this.CommodityId;
    }
    public void setCommodityId(Long CommodityId) {
        this.CommodityId = CommodityId;
    }
    @Generated(hash = 426907265)
    public CommodityBean(Long CommodityId, Long CommodityTypeId,
            String CommodityPic, Double CommodityPrice, Integer Stock,
            String CommodityDescribe, String CommodityName, String CommoditySize,
            boolean HotCommodity) {
        this.CommodityId = CommodityId;
        this.CommodityTypeId = CommodityTypeId;
        this.CommodityPic = CommodityPic;
        this.CommodityPrice = CommodityPrice;
        this.Stock = Stock;
        this.CommodityDescribe = CommodityDescribe;
        this.CommodityName = CommodityName;
        this.CommoditySize = CommoditySize;
        this.HotCommodity = HotCommodity;
    }
    @Generated(hash = 1829956951)
    public CommodityBean() {
    }


    @Override
    public String toString() {
        return "CommodityBean{" +
                "CommodityId=" + CommodityId +
                ", CommodityTypeId=" + CommodityTypeId +
                ", CommodityPic='" + CommodityPic + '\'' +
                ", CommodityPrice=" + CommodityPrice +
                ", Stock=" + Stock +
                ", CommodityDescribe='" + CommodityDescribe + '\'' +
                ", CommodityName='" + CommodityName + '\'' +
                '}';
    }
    public boolean getHotCommodity() {
        return this.HotCommodity;
    }
    public void setHotCommodity(boolean HotCommodity) {
        this.HotCommodity = HotCommodity;
    }
    public String getCommoditySize() {
        return this.CommoditySize;
    }
    public void setCommoditySize(String CommoditySize) {
        this.CommoditySize = CommoditySize;
    }



}
