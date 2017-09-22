package com.example.lql.testdemo.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

import java.util.HashMap;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/12
 * 修改备注：
 */
public class VideoUtils {

    /** * 服务器返回url，通过url去获取视频的第一帧 * Android 原生给我们提供了一个MediaMetadataRetriever类 * 提供了获取url视频第一帧的方法,返回Bitmap对象 * *  @param videoUrl *  @return */
    public static Bitmap getNetVideoBitmap(String videoUrl) {
        Bitmap bitmap = null;

        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            //根据url获取缩略图
            retriever.setDataSource(videoUrl, new HashMap());
            //获得第一帧图片
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            retriever.release();
        }
        return bitmap;
    }

}
