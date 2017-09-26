package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class UserBean {

    @Id
    Long UserId;//用户id
    @NotNull
    String UserName;//    昵称
    Integer Balance;//  余额

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public Long getUserId() {
        return this.UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    @Generated(hash = 1161617188)
    public UserBean(Long UserId, @NotNull String UserName, Integer Balance) {
        this.UserId = UserId;
        this.UserName = UserName;
        this.Balance = Balance;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }

    public Integer getBalance() {
        return this.Balance;
    }

    public void setBalance(Integer Balance) {
        this.Balance = Balance;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "UserId=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", Balance=" + Balance +
                '}';
    }
}
