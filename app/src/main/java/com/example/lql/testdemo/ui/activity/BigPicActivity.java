package com.example.lql.testdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.PicGridAdapter;
import com.example.lql.testdemo.ui.BaseActivity;
import com.example.lql.testdemo.utils.MyStatusBarUtil;
import com.example.lql.testdemo.utils.T;

import java.util.ArrayList;

/**
 * 类描述：一个查看图片的
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class BigPicActivity extends BaseActivity {

    private GridView gv_pics;
    private ArrayList<String> picsList = new ArrayList<>();
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bigpic);

        gv_pics = (GridView) findViewById(R.id.gv_pics);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_test);

        mToolbar.setTitle(R.string.title_activity_bigpic);//设置标题
        mToolbar.setTitleTextColor(getResources().getColor(R.color.color_fff));//标题颜色文字

//        mToolbar.setSubtitle("subtitle");//子标题
//        mToolbar.setSubtitleTextColor(getResources().getColor(R.color.wheel_timebtn_pre));//子标题颜色文字
//        mToolbar.setTitleMargin(30, 0, 0, 0);//标题边缘距离
//
//        mToolbar.setLogo(R.drawable.nba_logo);//logo
//        mToolbar.setLogoDescription("asd");

        MyStatusBarUtil.setStatusColor(this, getResources().getColor(R.color.colorAccent));

        mToolbar.setNavigationIcon(R.drawable.icon_back);//左侧返回
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));//背景色
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T.shortToast(BigPicActivity.this, "finish");
                finish();
            }
        });


        mToolbar.inflateMenu(R.menu.toolbar_menu);//设置右上角的填充菜单

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_bgimmerse_1:
                        T.shortToast(BigPicActivity.this, "1");
                        break;
                    case R.id.menu_bgimmerse_2:
                        T.shortToast(BigPicActivity.this, "2");
                        break;
                    case R.id.menu_bgimmerse_3:
                        T.shortToast(BigPicActivity.this, "3");
                        break;
                    case R.id.menu_bgimmerse_search:
                        T.shortToast(BigPicActivity.this, "4");
                        break;
                }
                return true;
            }
        });
//        setSupportActionBar(mToolbar);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initPics();
        // 设置GridView的适配器
        PicGridAdapter adapter = new PicGridAdapter(picsList, BigPicActivity.this);
        gv_pics.setAdapter(adapter);
        gv_pics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(BigPicActivity.this, PhotoDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("photos", picsList);
                intent.putExtras(bundle);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });
    }

    /**
     * 加载GridView的几张图片
     */
    private void initPics() {
        picsList.add("http://g.hiphotos.baidu.com/zhidao/pic/item/80cb39dbb6fd526616bf1d96a918972bd507369f.jpg");
        picsList.add("http://i1.hdslb.com/video/44/44aaafda3a3b58345d6788990b7cffac.jpg");
        picsList.add("http://img3.duitang.com/uploads/item/201509/23/20150923142544_ANiv8.jpeg");
        picsList.add("http://img3.duitang.com/uploads/item/201307/16/20130716192747_xSzXX.jpeg");
        picsList.add("http://c.hiphotos.baidu.com/zhidao/pic/item/a8773912b31bb0510a0a938e357adab44aede06e.jpg");
    }


//    collapseActionView()方法：折叠当前展开的View
//    dismissPopupMenus()方法：关闭当前显示的菜单，包括overflow和子菜单
//    generateLayoutParams(AttributeSet attrs)方法：根据提供的属性值获取到新的布局参数
//    getContentInsetEnd()方法：获取结束位置的内容
//    getContentInsetLeft()方法：获取左边的内容
//    getContentInsetRight()方法：获取右边内容
//    getContentInsetStart()方法： 获取开始位置的内容
//    getLogo()方法：获取logo
//    getLogoDescription()方法：获取Toolbarlogo的描述信息
//    getMenu()方法：获取menu
//    getNavigationContentDescription()方法：获取导航描述信息
//    getNavigationIcon()方法：获取导航图标
//    getOverflowIcon()方法：获取到overflow的icon
//    getSubtitle()方法：获取到Toolbar的子标题
//    hasExpandedActionView()方法：检测是否有展开的View
//    inflateMenu(int resId)方法：将menu资源inflate到toolbar里面
//    isOverflowMenuShowing()方法：检查是否有显示menu
//    onHoverEvent(MotionEvent ev)方法：处理toolbar的悬停事件
//    onRtlPropertiesChanged(int layoutDirection)方法：文本对齐方式
//    onTouchEvent(MotionEvent ev)方法：处理触摸事件
//    setContentInsetsAbsolute(int contentInsetLeft, int contentInsetRight)方法：设置toolbar绝对位置内容
//    setContentInsetsRelative(int contentInsetStart, int contentInsetEnd)方法：设置toolbar相对位置内容
//    setLogo(int resId)方法、setLogo(Drawable drawable)方法：设置toolbar的logo
//    setLogoDescription(int resId)方法、
//    setLogoDescription(CharSequence description)方法：设置logo的描述信息
//    setNavigationContentDescription(int resId)方法、
//    setNavigationContentDescription(CharSequence description)方法：设置导航按钮的描述信息
//    setNavigationIcon(Drawable icon)方法、
//    setNavigationIcon(int resId)方法：设置导航按钮的图标
//    setNavigationOnClickListener(View.OnClickListener listener)方法：设置导航按钮的监听事件
//    setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener listener)方法：设置menu条目的点击事件
//    setOverflowIcon(Drawable icon)方法：设置overflow的icon
//    setPopupTheme(int resId)方法：设置弹出式菜单的theme setSubtitle(int resId)方法、
//    setSubtitle(CharSequence subtitle)方法：设置toolbar的子标题
//    setSubtitleTextAppearance(Context context, int resId)方法：设置子标题文本的样式
//    setSubtitleTextColor(int color)方法：设置子标题文本颜色 setTitle(int resId)方法、
//    setTitle(CharSequence title)方法：设置toolbar的标题
//    setTitleTextAppearance(Context context, int resId)方法：设置toolbar标题文本样式
//    setTitleTextColor(int color)方法：设置标题颜色
//    showOverflowMenu()方法：显示overflow
}
