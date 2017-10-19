package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.AddressBean;
import com.example.lql.testdemo.db.gen.AddressBeanDao;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.List;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class AddressBeanManager {

    private static AddressBeanDao addressBeanDao;


    private static AddressBeanDao getAddressBeanDao() {
        if (addressBeanDao == null) {
            addressBeanDao = DBManager.getInstance().getDaoSession().getAddressBeanDao();
        }
        return addressBeanDao;
    }

    /**
     * 添加一个收货地址
     */
    public static void AddAddress(AddressBean mAddressBean) {
        getAddressBeanDao();
        addressBeanDao.insert(mAddressBean);
    }


    /**
     * 设置默认地址
     *
     * @param UserId
     * @param AddressId
     */
    public static void SetDefaultAddress(Long UserId, Long AddressId) {
        getAddressBeanDao();
        List<AddressBean> list = addressBeanDao.queryBuilder().
                where(AddressBeanDao.Properties.UserId.eq(UserId)).
                where(AddressBeanDao.Properties.DefaultAddress.eq(true)).
                list();
        if (list != null && list.size() != 0) {
            for (AddressBean mAddressBean :
                    list) {
                mAddressBean.setDefaultAddress(false);
                addressBeanDao.update(mAddressBean);
            }
        }

        AddressBean unique = addressBeanDao.queryBuilder().
                where(AddressBeanDao.Properties.AddressId.eq(AddressId))
                .unique();
        unique.setDefaultAddress(true);
        addressBeanDao.update(unique);
    }


    /**
     * 查询某个用户的全部地址
     *
     * @param UserId 用户id
     * @return 该用户的全部地址
     */
    public static List<AddressBean> LoadAllByUserId(Long UserId) {
        getAddressBeanDao();
        List<AddressBean> list = addressBeanDao.queryBuilder().
                where(AddressBeanDao.Properties.UserId.eq(UserId)).
                list();
        return list;
    }


    /**
     * 删除地址
     *
     * @param AddressId
     */
    public static void DeleteAddress(Long AddressId) {
        getAddressBeanDao();
        addressBeanDao.deleteByKey(AddressId);
    }


    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getAddressBeanDao();
        addressBeanDao.deleteAll();
    }


}
