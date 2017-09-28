package com.example.lql.testdemo.utils.greendaoUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.lql.testdemo.db.gen.AddressBeanDao;
import com.example.lql.testdemo.db.gen.CollectionBeanDao;
import com.example.lql.testdemo.db.gen.CommodityBeanDao;
import com.example.lql.testdemo.db.gen.CommoditySizeBeanDao;
import com.example.lql.testdemo.db.gen.CommodityTypeBeanDao;
import com.example.lql.testdemo.db.gen.DaoMaster;
import com.example.lql.testdemo.db.gen.EvaluateBeanDao;
import com.example.lql.testdemo.db.gen.LogisticsBeanDao;
import com.example.lql.testdemo.db.gen.NoticeBeanDao;
import com.example.lql.testdemo.db.gen.OrderBeanDao;
import com.example.lql.testdemo.db.gen.ShoppingCartBeanDao;
import com.example.lql.testdemo.db.gen.TimingBeanDao;
import com.example.lql.testdemo.db.gen.UserBeanDao;

import org.greenrobot.greendao.database.Database;

/**
 * @author 小东
 * @version v1.0
 * @date 2017/2/28 10:00
 * @detail 数据库升级
 */
public class DBOpenHelper extends DaoMaster.OpenHelper {
    private static final String TAG = DBOpenHelper.class.getSimpleName();

    public DBOpenHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory) {
        super(context, dbName, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        //DBManager.getInstance().onUpgrade(db);
        /**
         * * 数据库版本号不能降低,会导致App无法安装(newVersion < oldVersion)
         * 循环数据库版本,更新各版本数据结构差异
         */
        if (newVersion > oldVersion) {
            MigrationHelper.getInstance().migrate(db, AddressBeanDao.class);
            MigrationHelper.getInstance().migrate(db, CollectionBeanDao.class);
            MigrationHelper.getInstance().migrate(db, CommoditySizeBeanDao.class);
            MigrationHelper.getInstance().migrate(db, CommodityTypeBeanDao.class);
            MigrationHelper.getInstance().migrate(db, CommodityBeanDao.class);
            MigrationHelper.getInstance().migrate(db, EvaluateBeanDao.class);
            MigrationHelper.getInstance().migrate(db, LogisticsBeanDao.class);
            MigrationHelper.getInstance().migrate(db, NoticeBeanDao.class);
            MigrationHelper.getInstance().migrate(db, OrderBeanDao.class);
            MigrationHelper.getInstance().migrate(db, ShoppingCartBeanDao.class);
            MigrationHelper.getInstance().migrate(db, TimingBeanDao.class);
            MigrationHelper.getInstance().migrate(db, UserBeanDao.class);
        }
    }
}
