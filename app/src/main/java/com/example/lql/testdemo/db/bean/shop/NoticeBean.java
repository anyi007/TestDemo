package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：商城模块公告表
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class NoticeBean {
    @Id
    Long NoticeId;//公告id
    String NoticeTitle;//公告标题
    String NoticeContent;//公告内容



    @Generated(hash = 1968056286)
    public NoticeBean(Long NoticeId, String NoticeTitle, String NoticeContent) {
        this.NoticeId = NoticeId;
        this.NoticeTitle = NoticeTitle;
        this.NoticeContent = NoticeContent;
    }



    @Generated(hash = 303198189)
    public NoticeBean() {
    }



    @Override
    public String toString() {
        return "NoticeBean{" +
                "NoticeId=" + NoticeId +
                ", NoticeTitle='" + NoticeTitle + '\'' +
                ", NoticeContent='" + NoticeContent + '\'' +
                '}';
    }



    public String getNoticeContent() {
        return this.NoticeContent;
    }



    public void setNoticeContent(String NoticeContent) {
        this.NoticeContent = NoticeContent;
    }



    public String getNoticeTitle() {
        return this.NoticeTitle;
    }



    public void setNoticeTitle(String NoticeTitle) {
        this.NoticeTitle = NoticeTitle;
    }



    public Long getNoticeId() {
        return this.NoticeId;
    }



    public void setNoticeId(Long NoticeId) {
        this.NoticeId = NoticeId;
    }
}
