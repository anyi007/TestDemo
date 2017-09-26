package com.example.lql.testdemo.db.dao.shop;

import com.example.lql.testdemo.db.bean.shop.NoticeBean;
import com.example.lql.testdemo.db.gen.NoticeBeanDao;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;

import java.util.List;

/**
 * 类描述：公告
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class NoticeBeanManager {

    private static NoticeBeanDao noticeBeanDao;

    private static NoticeBeanDao getNoticeBeanDao() {
        if (noticeBeanDao == null) {
            noticeBeanDao = DBManager.getInstance().getDaoSession().getNoticeBeanDao();
        }
        return noticeBeanDao;
    }


    /**
     * 添加公告
     */
    public static void AddNotice(NoticeBean noticeBean) {
        getNoticeBeanDao();
        noticeBeanDao.insert(noticeBean);
    }

    /**
     * 查询全部
     */
    public static List<NoticeBean> LoadAll() {
        getNoticeBeanDao();
        return noticeBeanDao.loadAll();
    }

    /**
     * 按id查询某个公告
     */
    public static NoticeBean LoadById(Long NoticeId) {
        getNoticeBeanDao();
        return noticeBeanDao.queryBuilder().where(NoticeBeanDao.Properties.NoticeId.eq(NoticeId)).unique();
    }

    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getNoticeBeanDao();
        noticeBeanDao.deleteAll();
    }

}
