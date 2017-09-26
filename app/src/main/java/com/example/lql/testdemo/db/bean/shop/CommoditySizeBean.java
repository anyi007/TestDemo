package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 类描述：商品规格表
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class CommoditySizeBean   {

    @Id
    Long CommoditySizeId;//规格id
    Long CommodityId;//商品id
    String CommoditySizeContent;//规格描述
    public String getCommoditySizeContent() {
        return this.CommoditySizeContent;
    }
    public void setCommoditySizeContent(String CommoditySizeContent) {
        this.CommoditySizeContent = CommoditySizeContent;
    }
    public Long getCommodityId() {
        return this.CommodityId;
    }
    public void setCommodityId(Long CommodityId) {
        this.CommodityId = CommodityId;
    }
    public Long getCommoditySizeId() {
        return this.CommoditySizeId;
    }
    public void setCommoditySizeId(Long CommoditySizeId) {
        this.CommoditySizeId = CommoditySizeId;
    }
    @Generated(hash = 1322293880)
    public CommoditySizeBean(Long CommoditySizeId, Long CommodityId,
            String CommoditySizeContent) {
        this.CommoditySizeId = CommoditySizeId;
        this.CommodityId = CommodityId;
        this.CommoditySizeContent = CommoditySizeContent;
    }
    @Generated(hash = 769154859)
    public CommoditySizeBean() {
    }


    @Override
    public String toString() {
        return "CommoditySizeBean{" +
                "CommoditySizeId=" + CommoditySizeId +
                ", CommodityId=" + CommodityId +
                ", CommoditySizeContent='" + CommoditySizeContent + '\'' +
                '}';
    }



}
