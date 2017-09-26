package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.CommoditySizeBean;
import com.example.lql.testdemo.db.gen.CommoditySizeBeanDao;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.List;

/**
 * 类描述：商品规格
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class CommoditySizeBeanManager {

    private static CommoditySizeBeanDao commoditySizeBeanDao;

    private static CommoditySizeBeanDao getCommoditySizeBeanDao() {
        if (commoditySizeBeanDao == null) {
            commoditySizeBeanDao = DBManager.getInstance().getDaoSession().getCommoditySizeBeanDao();
        }
        return commoditySizeBeanDao;
    }


    /**
     * 添加规格
     */
    public static void AddCommoditySize(CommoditySizeBean commoditySizeBean) {
        getCommoditySizeBeanDao();
        commoditySizeBeanDao.insert(commoditySizeBean);
    }

    /**
     * 查询规格
     */
    public static List<CommoditySizeBean> LoadByCommodityId(Long CommodityId) {
        getCommoditySizeBeanDao();
        return commoditySizeBeanDao.queryBuilder().where(CommoditySizeBeanDao.Properties.CommodityId.eq(CommodityId)).list();
    }

    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getCommoditySizeBeanDao();
        commoditySizeBeanDao.deleteAll();
    }


}
