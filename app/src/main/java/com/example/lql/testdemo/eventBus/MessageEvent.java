package com.example.lql.testdemo.eventBus;

/**
 * 类描述：事件总线，传递一个事件
 * 作  者：Admin or 李小米
 * 时  间：2017/9/22
 * 修改备注：
 */
public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
