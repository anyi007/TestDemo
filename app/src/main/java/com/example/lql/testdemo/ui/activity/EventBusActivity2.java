package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.eventBus.FourthMessage;
import com.example.lql.testdemo.eventBus.MessageEvent;
import com.example.lql.testdemo.eventBus.SecondMessage;
import com.example.lql.testdemo.eventBus.ThirdMessage;

import org.greenrobot.eventbus.EventBus;

/**
 * 类描述：事件总线
 * 作  者：Admin or 李小米
 * 时  间：2017/9/22
 * 修改备注：
 */

/**
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
public class EventBusActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button test_button1;
    Button test_button2;
    Button test_button3;
    Button test_button4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus2);

        initView();
    }

    private void initView() {
        test_button1 = (Button) findViewById(R.id.test_button1);
        test_button2 = (Button) findViewById(R.id.test_button2);
        test_button3 = (Button) findViewById(R.id.test_button3);
        test_button4 = (Button) findViewById(R.id.test_button4);

        test_button1.setOnClickListener(this);
        test_button2.setOnClickListener(this);
        test_button3.setOnClickListener(this);
        test_button4.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.test_button1:
                EventBus.getDefault().post(new MessageEvent("事件总线的demo"));
                finish();
                break;
            case R.id.test_button2:
                EventBus.getDefault().post(new SecondMessage("第二个消息"));
                finish();
                break;
            case R.id.test_button3:
                EventBus.getDefault().postSticky(new ThirdMessage("第三个消息，粘性消息"));
                finish();
                break;
            case R.id.test_button4:
                EventBus.getDefault().post(new FourthMessage("第四个消息"));
                finish();
                break;
            default:
                break;
        }
    }
}
