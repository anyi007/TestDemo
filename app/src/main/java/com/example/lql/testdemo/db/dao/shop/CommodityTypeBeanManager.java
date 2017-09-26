package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.CommodityTypeBean;
import com.example.lql.testdemo.db.gen.CommodityTypeBeanDao;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.List;

/**
 * 类描述：商品分类
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class CommodityTypeBeanManager {

    private static CommodityTypeBeanDao commodityTypeBeanDao;

    private static CommodityTypeBeanDao getCommodityTypeBeanDao() {
        if (commodityTypeBeanDao == null) {
            commodityTypeBeanDao = DBManager.getInstance().getDaoSession().getCommodityTypeBeanDao();
        }
        return commodityTypeBeanDao;
    }


    /**
     * 添加分类
     */
    public static void AddCommodityType(CommodityTypeBean commodityTypeBean) {
        getCommodityTypeBeanDao();
        commodityTypeBeanDao.insert(commodityTypeBean);
    }

    /**
     * 按分类名称查询分类id
     *
     * @param Name
     * @return
     */
    public static Long LoadId(String Name) {
        getCommodityTypeBeanDao();
        return commodityTypeBeanDao.queryBuilder().where(CommodityTypeBeanDao.Properties.CommodityTypeName.eq(Name)).unique().getCommodityTypeId();
    }

    /**
     * 查询全部分类
     */
    public static List<CommodityTypeBean> LoadAll() {
        getCommodityTypeBeanDao();
        return commodityTypeBeanDao.loadAll();
    }


    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getCommodityTypeBeanDao();
        commodityTypeBeanDao.deleteAll();
    }

}
