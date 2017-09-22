package com.example.lql.testdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.eventBus.FourthMessage;
import com.example.lql.testdemo.eventBus.MessageEvent;
import com.example.lql.testdemo.eventBus.SecondMessage;
import com.example.lql.testdemo.eventBus.ThirdMessage;
import com.example.lql.testdemo.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 类描述：事件总线
 * 作  者：Admin or 李小米
 * 时  间：2017/9/22
 * 修改备注：
 * <p>
 * EventBus3.0有以下四种ThreadMode：
 * <p><p>
 * POSTING（默认）：如果使用事件处理函数指定了线程模型为POSTING，那么该事件在哪个线程发布出来的，
 * 事件处理函数就会在这个线程中运行，也就是说发布事件和接收事件在同一个线程。在线程模型为POSTING的事件处理函数中尽量避免执行耗时操作，
 * 因为它会阻塞事件的传递，甚至有可能会引起ANR。
 * <p><p>
 * MAIN:事件的处理会在UI线程中执行。事件处理时间不能太长，长了会ANR的。
 * <p><p>
 * BACKGROUND：如果事件是在UI线程中发布出来的，那么该事件处理函数就会在新的线程中运行，如果事件本来就是子线程中发布出来的，
 * 那么该事件处理函数直接在发布事件的线程中执行。在此事件处理函数中禁止进行UI更新操作。
 * <p><p>
 * ASYNC：无论事件在哪个线程发布，该事件处理函数都会在新建的子线程中执行，同样，此事件处理函数中禁止进行UI更新操作。
 */


/**
 * 注意的细节：
 * 1、在传递消息的时候，要保证接受消息的activity或者fragment已经存在，并且要已经注册过事件了，
 * 不能把消息传递到一个新的activity里边或者fragment中
 * <p>
 * 2、设置消息拦截：POSTING只有在默认状态下才能拦截消息，优先级高的可以拦截，阻止消息继续向下传递
 */

public class EventBusActivity extends AppCompatActivity {

    Button test_button;
    TextView test_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
//        //注册事件
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        test_button = (Button) findViewById(R.id.test_button);
        test_tv = (TextView) findViewById(R.id.test_tv1);
        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventBusActivity.this, EventBusActivity2.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent) {
        test_tv = (TextView) findViewById(R.id.test_tv1);
        test_tv.setText(messageEvent.getMessage());
    }

    /**
     * 用priority来设置接收消息的优先级 一般0-100之间
     * 拦截消息的时候 要用ThreadMode.POSTING 才能拦截
     *
     * @param message
     */
    @Subscribe(threadMode = ThreadMode.POSTING, priority = 100)
    public void SecondEvent(SecondMessage message) {
        LogUtils.Loge("优先级100");
        test_tv = (TextView) findViewById(R.id.test_tv1);
        test_tv.setText(message.getMessage() + "优先级100");
//        拦截消息的时候 要用ThreadMode.POSTING 才能拦截
        EventBus.getDefault().cancelEventDelivery(message);//优先级高的订阅者可以终止事件往下传递
    }


    /**
     * 用priority来设置接收消息的优先级 一般0-100之间
     *
     * @param message
     */
    @Subscribe(threadMode = ThreadMode.MAIN, priority = 10)
    public void SecondEvent1(SecondMessage message) {
        LogUtils.Loge("优先级10");
        test_tv = (TextView) findViewById(R.id.test_tv1);
        test_tv.setText(message.getMessage() + "优先级10");
    }


    /**
     * sticky设置接收粘性消息
     *
     * @param message
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void ThirdEvent(ThirdMessage message) {
        LogUtils.Loge("粘性消息");
        test_tv = (TextView) findViewById(R.id.test_tv1);
        test_tv.setText(message.getMessage() + "粘性消息");
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void FourthEvent(FourthMessage message) {
        LogUtils.Loge("发送的普通消息");
        test_tv = (TextView) findViewById(R.id.test_tv1);
        test_tv.setText(message.getMessage() + "普通消息");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册事件
        EventBus.getDefault().unregister(this);
    }
}
