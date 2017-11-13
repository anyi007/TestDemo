package com.example.lql.testdemo.ui.activity.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.bean.shop.AddressBean;
import com.example.lql.testdemo.db.dao.shop.AddressBeanManager;
import com.example.lql.testdemo.utils.CheckStringEmptyUtils;
import com.example.lql.testdemo.utils.FinalData;
import com.example.lql.testdemo.utils.PreferenceUtils;
import com.example.lql.testdemo.utils.T;
import com.github.jdsjlzx.recyclerview.LRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/11/9.
 */

/**
 * 类描述：商城效果（地址管理，地址的list)
 * 作  者：Admin or 李小米
 * 时  间：2017/9/22
 * 修改备注：
 */
public class AddressListActivity extends AppCompatActivity implements View.OnClickListener {

    private com.github.jdsjlzx.recyclerview.LRecyclerView addressrecy;
    private LinearLayout top_ly;//整个布局
    private LinearLayout back_ly;//返回按钮
    private TextView title_tv;//标题
    private LinearLayout title_save_ly;//保存按钮
    private TextView title_save_tv;//右侧文字
    private ImageView title_add_img;//右侧图标


    ArrayList<AddressBean> mAddressList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addresslist);
        initView();
    }


    private void initView() {
        this.addressrecy = (LRecyclerView) findViewById(R.id.address_recy);
        top_ly = (LinearLayout) findViewById(R.id.top_ly);
        back_ly = (LinearLayout) findViewById(R.id.top_back_ly);
        title_save_ly = (LinearLayout) findViewById(R.id.top_right_ly);
        top_ly.setBackgroundColor(getResources().getColor(R.color.shop_select2));
        title_tv = (TextView) findViewById(R.id.top_title_tv);
        title_add_img = (ImageView) findViewById(R.id.top_add_img);
        title_save_tv = (TextView) findViewById(R.id.top_save_tv);
        title_tv.setText("地址管理");

        back_ly.setOnClickListener(this);
        title_save_ly.setOnClickListener(this);
        title_add_img.setVisibility(View.VISIBLE);
        title_save_tv.setVisibility(View.GONE);
        getAddressData();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_back_ly:
                finish();
                break;
            case R.id.top_right_ly://添加地址

                break;
            default:
                break;
        }
    }


    private void getAddressData() {
        String string = PreferenceUtils.getString(FinalData.USERID, "");
        if (CheckStringEmptyUtils.IsEmpty(string)) {
            T.shortToast(AddressListActivity.this, "用户id不能为空，去个人中心重置一下数据吧");
            return;
        }
        List<AddressBean> addressBeans = AddressBeanManager.LoadAllByUserId(Long.parseLong(string));
        mAddressList.clear();
        mAddressList.addAll(addressBeans);
    }
}
