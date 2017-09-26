package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：商品分类表（大类）
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class CommodityTypeBean {
    @Id
    Long CommodityTypeId;//分类id
    String CommodityTypeName;//分类名称

    public String getCommodityTypeName() {
        return this.CommodityTypeName;
    }

    public void setCommodityTypeName(String CommodityTypeName) {
        this.CommodityTypeName = CommodityTypeName;
    }

    public Long getCommodityTypeId() {
        return this.CommodityTypeId;
    }

    public void setCommodityTypeId(Long CommodityTypeId) {
        this.CommodityTypeId = CommodityTypeId;
    }

    @Generated(hash = 1120115684)
    public CommodityTypeBean(Long CommodityTypeId, String CommodityTypeName) {
        this.CommodityTypeId = CommodityTypeId;
        this.CommodityTypeName = CommodityTypeName;
    }

    @Generated(hash = 1879344467)
    public CommodityTypeBean() {
    }

    @Override
    public String toString() {
        return "CommodityTypeBean{" +
                "CommodityTypeId=" + CommodityTypeId +
                ", CommodityTypeName='" + CommodityTypeName + '\'' +
                '}';
    }
}
