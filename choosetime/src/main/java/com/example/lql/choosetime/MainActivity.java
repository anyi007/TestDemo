package com.example.lql.choosetime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lql.choosetime.pickerview.TimePopupWindow;
import com.example.lql.choosetime.utils.DateUtils;
import com.example.lql.choosetime.utils.OnoptionsUtils;

import java.util.Date;


public class MainActivity extends AppCompatActivity {
    Button chooseTimeBtu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chooseTimeBtu = (Button) findViewById(R.id.chooseTimeBtu);
        chooseTimeBtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnoptionsUtils.showDateSelect(MainActivity.this, chooseTimeBtu, 2000, 10, 10, 2017, 11, 23, TimePopupWindow.Type.YEAR_MONTH, new TimePopupWindow.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {
                        chooseTimeBtu.setText(DateUtils.getYear(date) + "-" + DateUtils.getMonth(date));
                    }
                });
            }
        });
    }
}
