package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.view.Window;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.ScreenUtils;
import com.example.lql.testdemo.veiw.MoveImageview;

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/6
 * 修改备注：
 */
public class MyViewActivity extends AppCompatActivity {

    private com.example.lql.testdemo.veiw.MoveImageview myviewmove;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myview);

        this.myviewmove = (MoveImageview) findViewById(R.id.myview_move);

        //动态设置headerview的大小，给headerview添加一个观察树
        ViewTreeObserver viewTreeObserver = myviewmove.getViewTreeObserver();
        //当veiw被加载完成之后，调用该方法回调，这时候去设置veiw的大小
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                myviewmove.setTitleBarHeight(getTitleBarHeight()<0?0:getTitleBarHeight());
            }
        });
    }

    public int getTitleBarHeight(){
         ActionBar ab=getSupportActionBar();
        int titleBarHeight =0;
        if(ab!=null) titleBarHeight = ab.getHeight();
        LogUtils.Loge(titleBarHeight+"contentViewTop");
        return titleBarHeight;
    }


}
