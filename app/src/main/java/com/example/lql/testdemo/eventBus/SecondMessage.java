package com.example.lql.testdemo.eventBus;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/22
 * 修改备注：
 */
public class SecondMessage {
    private String message;

    public SecondMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
