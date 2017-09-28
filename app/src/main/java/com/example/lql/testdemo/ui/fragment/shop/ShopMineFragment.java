package com.example.lql.testdemo.ui.fragment.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.dao.shop.InitShopManager;
import com.example.lql.testdemo.ui.BaseFragment;
import com.example.lql.testdemo.ui.activity.shop.AboutUsActivity;
import com.example.lql.testdemo.utils.T;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class ShopMineFragment extends BaseFragment implements View.OnClickListener {

    LinearLayout OrderLy;//订单
    LinearLayout CollectionLy;//我的收藏
    LinearLayout EvaluateLy;//我的评论
    LinearLayout AddressLy;//地址管理
    LinearLayout BalanceLy;//余额
    LinearLayout InitializationLy;//初始化数据
    LinearLayout AboutUsLy;//关于我们

    TextView UserNameTv;

    public ShopMineFragment() {

    }

    private static ShopMineFragment mMineFragment;

    public static ShopMineFragment getInstance() {
        if (mMineFragment == null) {
            mMineFragment = new ShopMineFragment();
        }
        return mMineFragment;
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_shop_mine;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        OrderLy = (LinearLayout) rootView.findViewById(R.id.ly_order);
        CollectionLy = (LinearLayout) rootView.findViewById(R.id.ly_collection);
        EvaluateLy = (LinearLayout) rootView.findViewById(R.id.ly_evaluate);
        AddressLy = (LinearLayout) rootView.findViewById(R.id.ly_address);
        BalanceLy = (LinearLayout) rootView.findViewById(R.id.ly_balance);
        InitializationLy = (LinearLayout) rootView.findViewById(R.id.ly_initialization);
        AboutUsLy = (LinearLayout) rootView.findViewById(R.id.ly_about);
        UserNameTv = (TextView) rootView.findViewById(R.id.tv_user);


        OrderLy.setOnClickListener(this);
        CollectionLy.setOnClickListener(this);
        EvaluateLy.setOnClickListener(this);
        AddressLy.setOnClickListener(this);
        BalanceLy.setOnClickListener(this);
        InitializationLy.setOnClickListener(this);
        AboutUsLy.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ly_order://我的订单

                break;
            case R.id.ly_collection://我的收藏

                break;
            case R.id.ly_evaluate://我的评论

                break;
            case R.id.ly_address://地址管理

                break;
            case R.id.ly_balance://余额

                break;
            case R.id.ly_initialization://初始化数据
                InitShopManager.InitShop(getActivity());
                T.shortToast(getActivity(), "初始化完成");
                break;
            case R.id.ly_about://关于我们
                startActivity(new Intent(getActivity(), AboutUsActivity.class));
                break;
            default:
                break;
        }
    }
}
