package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.EvaluateBean;
import com.example.lql.testdemo.db.gen.EvaluateBeanDao;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.List;

/**
 * 类描述：评论
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class EvaluateBeanManager {
    private static EvaluateBeanDao evaluateBeanDao;

    private static EvaluateBeanDao getEvaluateBeanDao() {
        if (evaluateBeanDao == null) {
            evaluateBeanDao = DBManager.getInstance().getDaoSession().getEvaluateBeanDao();
        }
        return evaluateBeanDao;
    }

    /**
     * 添加评论
     */
    public static void AddEvaluate(EvaluateBean evaluateBean) {
        getEvaluateBeanDao();
        evaluateBeanDao.insert(evaluateBean);
    }

    /**
     * 查询某个商品的评论
     */
    public static List<EvaluateBean> LoadByCommodityId(Long CommodityId) {
        getEvaluateBeanDao();
        return evaluateBeanDao.queryBuilder().where(EvaluateBeanDao.Properties.CommodityId.eq(CommodityId)).list();
    }

    /**
     * 查询某个用户的评论
     */
    public static List<EvaluateBean> LoadByUserId(Long UserId) {
        getEvaluateBeanDao();
        return evaluateBeanDao.queryBuilder().where(EvaluateBeanDao.Properties.UserId.eq(UserId)).list();
    }


    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getEvaluateBeanDao();
        evaluateBeanDao.deleteAll();
    }

}
