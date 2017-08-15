package com.example.lql.testdemo.veiw;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.ScreenUtils;

/**
 * Created by Admin on 2017/8/7.
 */

public class MoveImageview extends ImageView {

    float lastX;
    float lastY;

    public MoveImageview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastX = event.getRawX();
//                lastY = event.getRawY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//
////                layout(left, top, right, bottom);
//                LogUtils.Loge("aaaaaaaaaa");
//                layout(300, 300, 300, 300);
//                break;
//            case MotionEvent.ACTION_UP:
//
//                break;
//        }
//        return super.onTouchEvent(event);
//
//    }
//

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = event.getRawY();
                lastY = event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) ((int) event.getRawX() - lastX);
                int dy = (int) ((int) event.getRawY() - lastY);

                int left = getLeft() + dx;
                int top = getTop() + dy;
                int right = getRight() + dx;
                int bottom = getBottom() + dy;


//                距离左边   left    距离右边    屏幕宽度-距离左边-图形的宽度

                if (left < 0) {
                    left = 0;
                    right = left + getWidth();
                }
                if (right > ScreenUtils.getScreenWidth(getContext())) {
                    right = ScreenUtils.getScreenWidth(getContext());
                    left = right - getWidth();
                }


                if (top < 0) {
                    top = 0;
                    bottom = top + getHeight();
                }
                if (bottom > ScreenUtils.getScreenHeight(getContext())) {
                    bottom = ScreenUtils.getScreenHeight(getContext());
                    top = bottom - getHeight();
                }
                LogUtils.Loge("left1:" + left + "top1:" + top + "right1:" + right + "bottom1:" + bottom);
//                layout(left, top, right, bottom);
                layout(300, 300, 300, 300);


                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
//                int dx1 = (int) ((int) event.getRawX() - lastX);
//                int dy1 = (int) ((int) event.getRawY() - lastY);
//
//                int left1 = getLeft() + dx1;
//                int top1 = getTop() + dy1;
//                int right1 = getRight() + dx1;
//                int bottom1 = getBottom() + dy1;
//
//                LogUtils.Loge("getWidth():" + getWidth() + "ScreenUtils" + ScreenUtils.getScreenWidth(getContext()));
//                if (left1 > (ScreenUtils.getScreenWidth(getContext()) - left1 - getWidth())) {
//                    right1 = 0;
//                    left1 = ScreenUtils.getScreenWidth(getContext()) - getWidth();
//                } else {
//                    left1 = 0;
//                    right1 = getWidth();
//                }
//
//
//                if (top1 < 0) {
//                    top1 = 0;
//                    bottom1 = top1 + getHeight();
//                }
//                if (bottom1 > ScreenUtils.getScreenHeight(getContext())) {
//                    bottom1 = ScreenUtils.getScreenHeight(getContext());
//                    top1 = bottom1 - getHeight();
//                }
//
//                LogUtils.Loge("left1:" + left1 + "top1:" + top1 + "right1:" + right1 + "bottom1:" + bottom1);
//                layout(left1, top1, right1, bottom1);

                break;
            default:
                break;
        }
        return true;
    }
}
