package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.ui.BaseActivity;
import com.example.lql.testdemo.utils.T;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * 类描述：动画效果的FloatingactionButton
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class FloatingactionButtonActivity extends BaseActivity {
    private com.getbase.floatingactionbutton.FloatingActionButton actiona;
    private com.getbase.floatingactionbutton.FloatingActionButton actionb;
    private com.getbase.floatingactionbutton.FloatingActionsMenu multipleactions;


//    <!--fab_addButtonColorNormal  背景颜色-->
//    <!--fab_addButtonColorPressed  按下的颜色-->
//    <!--fab_addButtonPlusIconColor  中间的加号颜色-->
//    <!--fab_expandDirection  设置出现的方向-->
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floatingaction_button);
        initView();
    }

    private void initView() {
        this.multipleactions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        this.actionb = (FloatingActionButton) findViewById(R.id.action_b);
        this.actiona = (FloatingActionButton) findViewById(R.id.action_a);

        FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
        actionC.setTitle("新出来的");
        actionC.setIcon(R.drawable.test2);
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T.shortToast(FloatingactionButtonActivity.this, "新出来的");
            }
        });


        actiona.setTitle("添加房间");
        actiona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T.shortToast(FloatingactionButtonActivity.this, "添加房间");
            }
        });

        actionb.setTitle("添加设备");
        actionb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T.shortToast(FloatingactionButtonActivity.this, "添加设备");
            }
        });


//        multipleactions.addButton(actiona);
//        multipleactions.addButton(actionb);
        multipleactions.addButton(actionC);
    }

}
