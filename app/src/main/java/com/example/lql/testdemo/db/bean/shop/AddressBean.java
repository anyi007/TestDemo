package com.example.lql.testdemo.db.bean.shop;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 类描述：收获地址表
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
@Entity
public class AddressBean   {

    @Id
    Long AddressId;//地址id
    Long UserId;//用户id
    String UserName; //联系人
    String Province;//省（这样写是想在购物的时候，定位，如果没有默认地址，就选择当前城市的收货地址）
    String City;//市
    String Area;//区
    String DetailedAddress;//详细地址
    String Phone;//电话
    boolean DefaultAddress;//轻松购（默认地址）
    public boolean getDefaultAddress() {
        return this.DefaultAddress;
    }
    public void setDefaultAddress(boolean DefaultAddress) {
        this.DefaultAddress = DefaultAddress;
    }
    public String getPhone() {
        return this.Phone;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    public String getDetailedAddress() {
        return this.DetailedAddress;
    }
    public void setDetailedAddress(String DetailedAddress) {
        this.DetailedAddress = DetailedAddress;
    }
    public String getArea() {
        return this.Area;
    }
    public void setArea(String Area) {
        this.Area = Area;
    }
    public String getCity() {
        return this.City;
    }
    public void setCity(String City) {
        this.City = City;
    }
    public String getProvince() {
        return this.Province;
    }
    public void setProvince(String Province) {
        this.Province = Province;
    }
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
    public Long getAddressId() {
        return this.AddressId;
    }
    public void setAddressId(Long AddressId) {
        this.AddressId = AddressId;
    }
    @Generated(hash = 1998286806)
    public AddressBean(Long AddressId, Long UserId, String UserName,
            String Province, String City, String Area, String DetailedAddress,
            String Phone, boolean DefaultAddress) {
        this.AddressId = AddressId;
        this.UserId = UserId;
        this.UserName = UserName;
        this.Province = Province;
        this.City = City;
        this.Area = Area;
        this.DetailedAddress = DetailedAddress;
        this.Phone = Phone;
        this.DefaultAddress = DefaultAddress;
    }
    @Generated(hash = 30780671)
    public AddressBean() {
    }


    @Override
    public String toString() {
        return "AddressBean{" +
                "AddressId=" + AddressId +
                ", UserId=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", Province='" + Province + '\'' +
                ", City='" + City + '\'' +
                ", Area='" + Area + '\'' +
                ", DetailedAddress='" + DetailedAddress + '\'' +
                ", Phone='" + Phone + '\'' +
                ", DefaultAddress=" + DefaultAddress +
                '}';
    }


}
