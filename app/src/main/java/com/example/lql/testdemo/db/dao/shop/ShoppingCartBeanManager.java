package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.ShoppingCartBean;
import com.example.lql.testdemo.db.gen.ShoppingCartBeanDao;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class ShoppingCartBeanManager {

    private static ShoppingCartBeanDao shoppingCartBeanDao;

    private static ShoppingCartBeanDao getShoppingCartBeanDao() {
        if (shoppingCartBeanDao == null) {
            shoppingCartBeanDao = DBManager.getInstance().getDaoSession().getShoppingCartBeanDao();
        }
        return shoppingCartBeanDao;
    }

    /**
     * 添加购物车
     */
    public static void AddShopCart(ShoppingCartBean shoppingCartBean) {
        getShoppingCartBeanDao();
        shoppingCartBeanDao.insert(shoppingCartBean);
    }


    /**
     * 修改某个商品的数量（某个用户的）
     */
    public static void UpdateNmuber(Long UserId, Long CommodityId, int number) {
        getShoppingCartBeanDao();
        ShoppingCartBean unique = shoppingCartBeanDao.queryBuilder().
                where(ShoppingCartBeanDao.Properties.UserId.eq(UserId)).
                where(ShoppingCartBeanDao.Properties.CommodityId.eq(CommodityId)).
                unique();
        unique.setNumber(number);
        shoppingCartBeanDao.update(unique);
    }


    /**
     * 删除某个商品
     */
    public static void DeleteByCommodityId(Long UserId, Long CommodityId) {
        getShoppingCartBeanDao();
        ShoppingCartBean unique = shoppingCartBeanDao.queryBuilder().
                where(ShoppingCartBeanDao.Properties.UserId.eq(UserId)).
                where(ShoppingCartBeanDao.Properties.CommodityId.eq(CommodityId)).
                unique();
        shoppingCartBeanDao.delete(unique);
    }

    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getShoppingCartBeanDao();
        shoppingCartBeanDao.deleteAll();
    }

}
