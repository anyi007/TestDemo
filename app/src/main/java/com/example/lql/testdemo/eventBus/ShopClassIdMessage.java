package com.example.lql.testdemo.eventBus;

/**
 * 类描述：商城模块--》分类传递分类id
 * 作  者：Admin or 李小米
 * 时  间：2017/10/3
 * 修改备注：
 */
public class ShopClassIdMessage {
    private long classTypeId;

    public ShopClassIdMessage(long classTypeId) {
        this.classTypeId = classTypeId;
    }

    public long getMessage() {
        return classTypeId;
    }

    public void setMessage(long message) {
        this.classTypeId = message;
    }
}
