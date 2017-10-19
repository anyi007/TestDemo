package com.example.lql.testdemo.utils.popup;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.ScreenUtils;
import com.example.lql.testdemo.utils.T;

import java.util.ArrayList;

/**
 * 类描述：下拉选择
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class PopupUtils {

    private static int ListIndex = -1;
    static PopupWindow popupWindow;
    public static final int CENTER = 0;
    public static final int BOTTOM = 1;
    public static final int VIEW_BOTTOM = 2;


    public static boolean IsShow() {
        if (popupWindow == null) {
            return false;
        } else {
            return popupWindow.isShowing();
        }
    }

    /**
     * @param mList          数据源
     * @param mActivity      上下文
     * @param parent         点击的哪个view
     * @param windowLoaction 显示的位置   0:中间  1：底部   2：控件下边
     * @param mpopupCallBack 回调
     */
    public static void showListPopupWindow(ArrayList<String> mList, final Activity mActivity, View parent, final int windowLoaction, final popupCallBack mpopupCallBack) {

        if (mList == null || mList.size() == 0) {
            T.shortToast(mActivity, "暂无数据");
            mpopupCallBack.PopupCallBack(-1);
            return;
        }
        ListPopupAdapter mListPopupAdapter = new ListPopupAdapter(mActivity);
        mListPopupAdapter.setList(mList);
        View contentView = LayoutInflater.from(mActivity).inflate(R.layout.popup_list_layout, null);

        ListView listView = (ListView) contentView.findViewById(R.id.popup_list);
        TextView cancelTv = (TextView) contentView.findViewById(R.id.cancel_popup);
        listView.setAdapter(mListPopupAdapter);

        popupWindow = new PopupWindow(contentView);
        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mpopupCallBack.PopupCallBack(-1);
                popupWindow.dismiss();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LogUtils.Loge("点击了第" + position + "个");
                if (mpopupCallBack != null) {
                    ListIndex = position;
                    mpopupCallBack.PopupCallBack(position);
                    popupWindow.dismiss();
                }
            }
        });

        popupWindow.setAnimationStyle(R.style.ActionSheetDialogAnimation);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        // 软键盘不会挡着popupwindow
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        // 设置菜单显示的位置
        switch (windowLoaction) {
            //在屏幕中央
            case CENTER:
                //设置宽度
                popupWindow.setWidth(ScreenUtils.getScreenWidth(mActivity) / 3);
//                //设置高度
                if (mList.size() < 7) {
                    popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                } else {
                    popupWindow.setHeight(ScreenUtils.getScreenHeight(mActivity) / 3);
                }
                //设置位置
                popupWindow.showAtLocation(parent, Gravity.CENTER, 0, 0);
                break;
            //在屏幕底部
            case BOTTOM:
                //设置宽度
                popupWindow.setWidth(ScreenUtils.getScreenWidth(mActivity));
//                //设置高度
                if (mList.size() > 3) {
                    popupWindow.setHeight(ScreenUtils.getScreenHeight(mActivity) / 3);
                } else {
                    popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                }
                popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
                break;
            //在控件下面
            case VIEW_BOTTOM:
                //设置宽度
                popupWindow.setWidth(ScreenUtils.getScreenWidth(mActivity) / 3);
                //设置高度
                if (mList.size() > 3) {
                    popupWindow.setHeight(ScreenUtils.getScreenHeight(mActivity) / 3);
                } else {
                    popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                }
                popupWindow.showAsDropDown(parent);
                break;
        }

        // 监听菜单的关闭事件
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mpopupCallBack.PopupCallBack(ListIndex);
            }
        });

//        // 监听触屏事件
//        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View arg0, MotionEvent arg1) {
//                if (popupWindow.isShowing()) {
//                    mpopupCallBack.PopupCallBack(-1);
//                    popupWindow.dismiss();
//                    return true;
//                }
//                return false;
//            }
//        });
    }

    public static void hindPopup() {
        if (null != popupWindow) {
            popupWindow.dismiss();
        }
    }

    /**
     * popupwindow 消失后的回调
     */
    public interface popupCallBack {
        void PopupCallBack(int index);
    }


}
