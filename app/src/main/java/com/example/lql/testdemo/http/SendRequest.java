package com.example.lql.testdemo.http;

import okhttp3.FormBody;

/**
 * 类描述：请求数据的方法
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class SendRequest {

    /**
     * 46、用户收藏列表
     *
     * @param type        1：服务2：工作室
     * @param mOkCallBack
     */
    public static void UserFavoriteList(String Userid, int type, int page, int rows, MOkCallBack mOkCallBack) {
        FormBody formBody = new FormBody.Builder()
                .add("Userid", Userid)
                .add("type", type + "")
                .add("page", page + "")
                .add("rows", rows + "")
                .build();
        OkHttpUtils.MyPost(formBody, MyUrl.UserFavoriteList, mOkCallBack);
    }
}
