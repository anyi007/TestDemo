package com.example.lql.testdemo.ui.activity.shop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.fragment.shop.ShopCartFragment;
import com.example.lql.testdemo.ui.fragment.shop.ShopClassFragment;
import com.example.lql.testdemo.ui.fragment.shop.ShopHomeFragment;
import com.example.lql.testdemo.ui.fragment.shop.ShopMineFragment;
import com.example.lql.testdemo.utils.MyStatusBarUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：商城效果（购物车+分类列表+价格筛选+商品详情）
 * 作  者：Admin or 李小米
 * 时  间：2017/9/22
 * 修改备注：
 */
public class ShopMainActivity extends AppCompatActivity {
    BottomNavigationView bottomnavigation;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private Fragment openEdFragment = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyStatusBarUtil.setStatusColor(this, getResources().getColor(R.color.shop_select1));
        setContentView(R.layout.activity_shopmain);
        this.bottomnavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        initFragment();
        initBottom();
        switchFragment(0);
    }

    private void initBottom() {
        bottomnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_main:
                        bottomnavigation.setItemBackgroundResource(R.color.shop_select1);
                        MyStatusBarUtil.setStatusColor(ShopMainActivity.this, getResources().getColor(R.color.shop_select1));
                        switchFragment(0);
                        break;
                    case R.id.menu_class:
                        bottomnavigation.setItemBackgroundResource(R.color.shop_select2);
                        MyStatusBarUtil.setStatusColor(ShopMainActivity.this, getResources().getColor(R.color.shop_select2));
                        switchFragment(1);
                        break;
                    case R.id.menu_cart:
                        bottomnavigation.setItemBackgroundResource(R.color.shop_select4);
                        MyStatusBarUtil.setStatusColor(ShopMainActivity.this, getResources().getColor(R.color.shop_select4));
                        switchFragment(2);
                        break;
                    case R.id.menu_mine:
                        bottomnavigation.setItemBackgroundResource(R.color.shop_select3);
                        MyStatusBarUtil.setStatusColor(ShopMainActivity.this, getResources().getColor(R.color.shop_select3));
                        switchFragment(3);
                        break;
                }
                return true;
            }
        });
        bottomnavigation.setSelectedItemId(R.id.menu_main);
    }


    private void initFragment() {
        mFragmentList.clear();
        mFragmentList.add(ShopHomeFragment.getInstance());
        mFragmentList.add(ShopClassFragment.getInstance());
        mFragmentList.add(ShopCartFragment.getInstance());
        mFragmentList.add(ShopMineFragment.getInstance());
    }


    /**
     * @param index 切换页面
     */
    private void switchFragment(int index) {
        if (openEdFragment == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.shop_main_content, mFragmentList.get(index)).commit();
            openEdFragment = mFragmentList.get(index);
        } else {
            if (!openEdFragment.equals(mFragmentList.get(index))) {
                if (mFragmentList.get(index).isAdded()) {
                    getSupportFragmentManager().beginTransaction().hide(openEdFragment).show(mFragmentList.get(index)).commit();
                    openEdFragment = mFragmentList.get(index);
                } else {
                    getSupportFragmentManager().beginTransaction().hide(openEdFragment).add(R.id.shop_main_content, mFragmentList.get(index)).commit();
                    openEdFragment = mFragmentList.get(index);
                }
            }
        }
    }

}
