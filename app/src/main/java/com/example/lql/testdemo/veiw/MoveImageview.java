package com.example.lql.testdemo.veiw;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.ScreenUtils;

import static com.example.lql.testdemo.utils.ScreenUtils.getStatusHeight;

/**
 * Created by Admin on 2017/8/7.
 */

public class MoveImageview extends ImageView {



    float lastX;
    float lastY;

    public MoveImageview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    int TitleBarHeight=0;
    public void setTitleBarHeight(int mTitleBarHeight){
        TitleBarHeight=mTitleBarHeight;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = event.getX();
                lastY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) (x - lastX);
                int dy = (int) (y - lastY);

                int left = getLeft() + dx;
                int top = getTop() + dy;
                int right = getRight() + dx;
                int bottom = getBottom() + dy;

////            距离左边   left    距离右边    屏幕宽度-距离左边-图形的宽度
//
                if (left < 0) {
                    left = 0;
                    right = getWidth();
                }

                if (right > ScreenUtils.getScreenWidth(getContext())) {
                    right = ScreenUtils.getScreenWidth(getContext());
                    left = right - getWidth();
                }

                if (top < 0) {
                    top = 0;
                    bottom = top + getHeight();
                }

                LogUtils.Loge("TitleBarHeight:"+TitleBarHeight);
                int i = ScreenUtils.getScreenHeight(getContext())- getStatusHeight(getContext())-TitleBarHeight;

                if (bottom > i) {
                    bottom = i;
                    top = bottom - getHeight();
                }
                layout(left, top, right, bottom);
                break;
            default:
                break;
        }
        return true;
    }



}
