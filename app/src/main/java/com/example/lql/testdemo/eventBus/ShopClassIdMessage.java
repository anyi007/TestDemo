package com.example.lql.testdemo.eventBus;

/**
 * 类描述：商城模块--》分类传递分类id
 * 作  者：Admin or 李小米
 * 时  间：2017/10/3
 * 修改备注：
 */
public class ShopClassIdMessage {
    private String classTypeId;

    public ShopClassIdMessage(String classTypeId) {
        this.classTypeId = classTypeId;
    }

    public String getMessage() {
        return classTypeId;
    }

    public void setMessage(String message) {
        this.classTypeId = message;
    }
}
