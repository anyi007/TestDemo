package com.example.lql.testdemo.application;

import android.app.Activity;
import android.app.Application;

import com.example.lql.testdemo.utils.AppConstant;
import com.example.lql.testdemo.utils.PublicStaticData;
import com.example.lql.testdemo.utils.greendaoUtils.DBManager;


/**
 * 类描述：初始化数据
 * 作  者：李清林
 * 时  间：2017.7.18
 * 修改备注：
 */
public class MyApplication extends Application {

    private static MyApplication mContext;

    public synchronized static MyApplication getInstance() {
        if (mContext == null) {
            mContext = new MyApplication();
        }
        return mContext;
    }

    @Override
    public void onCreate() {
        getInstance();
        //初始化数据库
        DBManager.getInstance().init(this);
        PublicStaticData.mySharedPreferences = getSharedPreferences(AppConstant.PREFRENCE_NAME, Activity.MODE_PRIVATE);//初始化PreferencesUtils
        super.onCreate();
    }


}
