package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.OrderBean;
import com.example.lql.testdemo.db.gen.OrderBeanDao;
import com.example.lql.testdemo.utils.FinalData;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.List;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 * 说  明：未付款  可以取消订单
 * 完成了订单可以评价商品（评价的是商品，不能评价订单）
 * 已经取消的订单可以重新购买
 */
public class OrderBeanManager {

    private static OrderBeanDao orderBeanDao;

    private static OrderBeanDao getOrderBeanDao() {
        if (orderBeanDao == null) {
            orderBeanDao = DBManager.getInstance().getDaoSession().getOrderBeanDao();
        }
        return orderBeanDao;
    }

    /**
     * 添加订单
     */
    public static void AddOrder(OrderBean orderBean) {
        getOrderBeanDao();
        orderBeanDao.insert(orderBean);
    }

    /**
     * 查询某个状态的订单
     */
    public static List<OrderBean> LoadAll(int type) {
        getOrderBeanDao();
        if (type == FinalData.ALLSTATE) {
            return orderBeanDao.loadAll();
        } else {
            return orderBeanDao.queryBuilder().where(OrderBeanDao.Properties.OrderState.eq(type)).list();
        }
    }


    /**
     * 查询某一个订单
     */
    public static OrderBean LoadById(Long OrderId) {
        getOrderBeanDao();
        return orderBeanDao.queryBuilder().where(OrderBeanDao.Properties.OrderId.eq(OrderId)).unique();
    }

    /**
     * 取消订单
     * <p>
     * <p>
     * 可是从未付款状态取消
     */
    public static void CancelOrder(Long OrderId) {
        getOrderBeanDao();
        OrderBean unique = orderBeanDao.queryBuilder().where(OrderBeanDao.Properties.OrderId.eq(OrderId)).unique();
        if (unique != null) {
            unique.setOrderState(FinalData.CANCEL);
            orderBeanDao.update(unique);
        }
    }


    /**
     * 修改订单状态
     * <p>
     * 未付款---》待收货
     */
    public static void UnPayToGoodsReceipt(Long OrderId) {
        getOrderBeanDao();
        OrderBean unique = orderBeanDao.queryBuilder().where(OrderBeanDao.Properties.OrderId.eq(OrderId)).unique();
        if (unique != null) {
            unique.setOrderState(FinalData.UNGOODSRECEIPT);
            orderBeanDao.update(unique);
        }
    }

    /**
     * 修改订单状态
     * <p>
     * 待收货---》已完成
     */
    public static void GoodsReceiptToComplete(Long OrderId) {
        getOrderBeanDao();
        OrderBean unique = orderBeanDao.queryBuilder().where(OrderBeanDao.Properties.OrderId.eq(OrderId)).unique();
        if (unique != null) {
            unique.setOrderState(FinalData.COMPLETE);
            orderBeanDao.update(unique);
        }
    }


    /**
     * 修改订单状态
     * <p>
     * 已经取消----》待付款
     */
    public static void CancelToUnPay(Long OrderId) {
        getOrderBeanDao();
        OrderBean unique = orderBeanDao.queryBuilder().where(OrderBeanDao.Properties.OrderId.eq(OrderId)).unique();
        if (unique != null) {
            unique.setOrderState(FinalData.UNPAID);
            orderBeanDao.update(unique);
        }
    }


    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getOrderBeanDao();
        orderBeanDao.deleteAll();
    }

}
