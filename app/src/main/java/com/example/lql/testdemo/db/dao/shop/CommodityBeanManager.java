package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.CommodityBean;
import com.example.lql.testdemo.db.gen.CommodityBeanDao;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.List;

/**
 * 类描述：商品表
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class CommodityBeanManager {

    private static CommodityBeanDao mCommodityBeanDao;

    private static CommodityBeanDao getmCommodityBeanDao() {
        if (mCommodityBeanDao == null) {
            mCommodityBeanDao = DBManager.getInstance().getDaoSession().getCommodityBeanDao();
        }
        return mCommodityBeanDao;
    }


    /**
     * 添加商品
     */

    public static void AddCommodity(CommodityBean commodityBean) {
        getmCommodityBeanDao();
        mCommodityBeanDao.insert(commodityBean);
    }


    /**
     * 查询某个商品详情
     * @param id
     * @return
     */
    public static CommodityBean getCommodityById(long id) {
        getmCommodityBeanDao();
        return mCommodityBeanDao.load(id);
    }


    /**
     * 查询全部商品
     */
    public static List<CommodityBean> LoadAll() {
        getmCommodityBeanDao();
        return mCommodityBeanDao.loadAll();
    }


    /**
     * 查询热门商品
     */
    public static List<CommodityBean> LoadHotCom() {
        getmCommodityBeanDao();
        return mCommodityBeanDao.queryBuilder().
                where(CommodityBeanDao.Properties.HotCommodity.eq(true)).
                list();
    }


    /**
     * 按照分类查询商品
     */
    public static List<CommodityBean> LoadCommodityByType(Long CommodityTypeId) {
        getmCommodityBeanDao();
        return mCommodityBeanDao.queryBuilder().
                where(CommodityBeanDao.Properties.CommodityTypeId.eq(CommodityTypeId)).
                list();
    }

    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getmCommodityBeanDao();
        mCommodityBeanDao.deleteAll();
    }


}
