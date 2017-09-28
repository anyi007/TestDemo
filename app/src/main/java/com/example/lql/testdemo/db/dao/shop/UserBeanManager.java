package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.UserBean;
import com.example.lql.testdemo.db.gen.UserBeanDao;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.List;

/**
 * 类描述：商城模块--》用户管理
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class UserBeanManager {
    private static UserBeanDao userBeanDao;

    private static UserBeanDao getUserBeanDao() {
        if (userBeanDao == null) {
            userBeanDao = DBManager.getInstance().getDaoSession().getUserBeanDao();
        }
        return userBeanDao;
    }


    /**
     * 添加一个用户
     */
    public static void AddUser() {
        getUserBeanDao();

        UserBean mUserBean = new UserBean();
        mUserBean.setUserId(null);
        mUserBean.setUserName("小米");
        mUserBean.setBalance(10000);

        userBeanDao.insert(mUserBean);
    }

    /**
     * 获取userBean
     *
     * @return
     */
    public static UserBean getUserBean() {
        getUserBeanDao();
        return userBeanDao.queryBuilder().where(UserBeanDao.Properties.UserName.eq("小米")).unique();
    }


    /**
     * 充值
     *
     * @param UserId 用户id
     * @param Money  充值金额
     */
    public static void Recharge(Long UserId, int Money) {
        getUserBeanDao();
        UserBean load = userBeanDao.load(UserId);
        load.setBalance(load.getBalance() + Money);
        userBeanDao.update(load);
    }


    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getUserBeanDao();
        userBeanDao.deleteAll();
    }

    public static List<UserBean> LoadAll() {
        getUserBeanDao();
        return userBeanDao.loadAll();
    }


}
