package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.adapter.RecyclerviewAdapter;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;

import java.util.ArrayList;

public class GildeActivity extends AppCompatActivity implements View.OnClickListener{

    private android.widget.Button button1;
    private android.widget.Button button2;
    private android.widget.Button button3;
    private android.widget.Button button4;
    private android.widget.Button button5;
    private android.support.v7.widget.RecyclerView recycler;
    private ImageView image_test;

    ArrayList<String> ImageUrl=new ArrayList<>();

    RecyclerviewAdapter mRecyclerviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gilde);

        initView();
    }

    private void initView() {

        this.recycler = (RecyclerView) findViewById(R.id.recycler);
        this.button5 = (Button) findViewById(R.id.button5);
        this.button4 = (Button) findViewById(R.id.button4);
        this.button3 = (Button) findViewById(R.id.button3);
        this.button2 = (Button) findViewById(R.id.button2);
        this.button1 = (Button) findViewById(R.id.button1);
        this.image_test = (ImageView) findViewById(R.id.image_test);

        initData();

        this.button5.setOnClickListener(this);
        this.button4.setOnClickListener(this);
        this.button3.setOnClickListener(this);
        this.button2.setOnClickListener(this);
        this.button1.setOnClickListener(this);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerviewAdapter = new RecyclerviewAdapter(this);
        mRecyclerviewAdapter.setList(ImageUrl);
        recycler.setAdapter(mRecyclerviewAdapter);
    }


    private void initData(){
        ImageUrl.add("https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E5%8A%A8%E6%BC%AB%20%E5%A5%B3%E7%94%9F&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&cs=429351181,3900973201&os=1790687650,1938582348&simid=4194081858,812918789&pn=5&rn=1&di=124945301140&ln=1961&fr=&fmq=1389861203899_R&fm=&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&hs=2&oriquery=%E5%8A%A8%E6%BC%AB%E5%9B%BE%E7%89%87&objurl=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201506%2F19%2F20150619192119_CJtBa.jpeg&rpstart=0&rpnum=0&adpicid=0");
        ImageUrl.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1661456672,1683407123&fm=23&gp=0.jpg");
        ImageUrl.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2125798313,3617904366&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2125798313,3617904366&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=937163445,3488361803&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2814668520,3879798443&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3486270674,2735969811&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2526294787,2662696903&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2996161206,875233122&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1237156471,3379658227&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3368137567,499971484&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1432940548,2394616942&fm=11&gp=0.jpg");
        ImageUrl.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2140587368,3565680957&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1099088262,117351606&fm=23&gp=0.jpg");
        ImageUrl.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3794460176,4024934649&fm=23&gp=0.jpg");
        ImageUrl.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3285368183,1463281467&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=57366344,3622627970&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3518784915,2097068762&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3862502646,2954337234&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=115490337,18002442&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=658942109,1131260206&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4226839710,3972161866&fm=26&gp=0.jpg");
        ImageUrl.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4103913655,1635398791&fm=23&gp=0.jpg");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1://单张图片
                image_test.setVisibility(View.VISIBLE);
                GlidePicUtils.LoadImg(GildeActivity.this , image_test , ImageUrl.get(19) );
                break;
            case R.id.button2://圆角图片
                image_test.setVisibility(View.VISIBLE);
                GlidePicUtils.LoadRoundImg(GildeActivity.this , image_test , ImageUrl.get(20) , 5);
                break;
            case R.id.button3://圆形图片
                image_test.setVisibility(View.VISIBLE);
                GlidePicUtils.LoadCircleImg(GildeActivity.this , image_test , ImageUrl.get(21));
                break;
            case R.id.button4://资源文件
                image_test.setVisibility(View.VISIBLE);
                GlidePicUtils.LoadRequest(GildeActivity.this , image_test , R.drawable.test);
                break;
            case R.id.button5://recyclerview
                image_test.setVisibility(View.GONE);
                recycler.setVisibility(View.VISIBLE);
                break;

        }
    }

}
