package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.CollectionBean;
import com.example.lql.testdemo.db.gen.CollectionBeanDao;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.List;

/**
 * 类描述：商城模块---》收藏表
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class CollectionBeanManager {

    private static CollectionBeanDao collectionBeanDao;

    private static CollectionBeanDao getCollectionBeanDao() {
        if (collectionBeanDao == null) {
            collectionBeanDao = DBManager.getInstance().getDaoSession().getCollectionBeanDao();
        }
        return collectionBeanDao;
    }

    /**
     * 添加收藏
     */

    public static void AddCollection(CollectionBean mCollection) {
        getCollectionBeanDao();

        collectionBeanDao.insert(mCollection);
    }


    /**
     * 取消收藏（删除）
     *
     * @param UserId      用户id
     * @param CommodityId 商品id
     */
    public static void DeleteColl(Long UserId, Long CommodityId) {
        getCollectionBeanDao();
        CollectionBean unique = collectionBeanDao.queryBuilder().
                where(CollectionBeanDao.Properties.UserId.eq(UserId)).
                where(CollectionBeanDao.Properties.CommodityId.eq(CommodityId))
                .unique();
        collectionBeanDao.delete(unique);
    }


    /**
     * 查询某个用户的收藏商品  返回一个list
     *
     * @param UserId 用户id
     * @return 该用户收藏的全部商品
     */
    public static List<CollectionBean> LoadAllByUserId(Long UserId) {
        getCollectionBeanDao();

        return collectionBeanDao.queryBuilder().
                where(CollectionBeanDao.Properties.UserId.eq(UserId)).
                list();
    }


    /**
     * 查询某个商品某个用户收藏没有  返回一个boolean
     */

    public static boolean Collectioned(Long UserId, Long CommodityId) {
        getCollectionBeanDao();
        CollectionBean unique = collectionBeanDao.queryBuilder().
                where(CollectionBeanDao.Properties.UserId.eq(UserId)).
                where(CollectionBeanDao.Properties.CommodityId.eq(CommodityId))
                .unique();
        return unique == null ? false : true;
    }


    /**
     * 删除全部
     */
    public  static void DeleteAll() {
        getCollectionBeanDao();
        collectionBeanDao.deleteAll();
    }


}
