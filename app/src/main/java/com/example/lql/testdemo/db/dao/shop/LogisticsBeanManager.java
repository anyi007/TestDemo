package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.LogisticsBean;
import com.example.lql.testdemo.db.gen.LogisticsBeanDao;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.List;

/**
 * 类描述：物流
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class LogisticsBeanManager {

    private static LogisticsBeanDao logisticsBeanDao;

    private static LogisticsBeanDao getLogisticsBeanDao() {
        if (logisticsBeanDao == null) {
            logisticsBeanDao = DBManager.getInstance().getDaoSession().getLogisticsBeanDao();
        }
        return logisticsBeanDao;
    }


    /**
     * 添加物流
     */
    public static void AddLogistic(LogisticsBean logisticsBean) {
        getLogisticsBeanDao();
        logisticsBeanDao.insert(logisticsBean);
    }

    /**
     * 查询物流信息  按订单号  返回一个list
     */
    public static List<LogisticsBean> LoadByOrderId(Long OrderId) {
        getLogisticsBeanDao();
        return logisticsBeanDao.queryBuilder().where(LogisticsBeanDao.Properties.OrderId.eq(OrderId)).list();
    }

    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getLogisticsBeanDao();
        logisticsBeanDao.deleteAll();
    }


}
