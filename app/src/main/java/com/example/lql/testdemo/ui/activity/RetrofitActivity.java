package com.example.lql.testdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.bean.UserFavoriteListBeanForRetrofit;
import com.example.lql.testdemo.retrofit.TestApi;
import com.example.lql.testdemo.utils.ChoosePicUtil;
import com.example.lql.testdemo.utils.LogUtils;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

import static com.example.lql.testdemo.utils.ChoosePicUtil.MATCHING_CODE_CAMERA;


/**
 * 类描述：
 * 作  者：李清林
 * 时  间：2017/8/16.
 * 修改备注：
 */
public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {

    Button PostButton;
    Button GetButton;
    Button UploadButton;
    Button DownloadButton;

    ImageView img1, img2, img3;


    String DownLoadUrl = "https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk";
    int choosePicNumber = 0;


    File mFile1;
    File mFile2;
    File mFile3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        initView();
    }

    private void initView() {
//      post请求
        PostButton = (Button) findViewById(R.id.post_button);
        PostButton.setOnClickListener(this);
//      get请求
        GetButton = (Button) findViewById(R.id.get_button);
        GetButton.setOnClickListener(this);

        //上传文件
        UploadButton = (Button) findViewById(R.id.upload_button);
        UploadButton.setOnClickListener(this);

        //下载文件
        DownloadButton = (Button) findViewById(R.id.download_button);
        DownloadButton.setOnClickListener(this);


        //拍一张照片传上去
        img1 = (ImageView) findViewById(R.id.test_img1);
        img1.setOnClickListener(this);

        //拍一张照片传上去
        img2 = (ImageView) findViewById(R.id.test_img2);
        img2.setOnClickListener(this);


        //拍一张照片传上去
        img3 = (ImageView) findViewById(R.id.test_img3);
        img3.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.post_button:
                postMethod();
                break;
            case R.id.get_button:
                getMethod();
                break;
            case R.id.upload_button:
                uploadMethod();
                break;
            case R.id.download_button:
                getMethod();
                break;


            case R.id.test_img1:
                choosePicNumber = 1;
                ChoosePicUtil.startActivityFor(MATCHING_CODE_CAMERA, RetrofitActivity.this);
                break;

            case R.id.test_img2:
                choosePicNumber = 2;
                ChoosePicUtil.startActivityFor(MATCHING_CODE_CAMERA, RetrofitActivity.this);
                break;


            case R.id.test_img3:
                choosePicNumber = 3;
                ChoosePicUtil.startActivityFor(MATCHING_CODE_CAMERA, RetrofitActivity.this);
                break;


        }
    }

    /**
     * 文件下载
     */
    private void dowmloadMethod() {


    }

    /**
     * 文件上传
     */
    private void uploadMethod() {
        Retrofit retrofit = new Retrofit.Builder()
                //这里建议：- Base URL: 总是以/结尾；- @Url: 不要以/开头
                .baseUrl("https://www.51cnkicheck.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        TestApi testApi = retrofit.create(TestApi.class);


        // 创建 RequestBody，用于封装 请求RequestBody
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), mFile1);
        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body = MultipartBody.Part.createFormData("image", mFile1.getName(), requestFile);
        // 添加描述
        RequestBody description = RequestBody.create(MediaType.parse("multipart/form-data"), "hello, 这是文件描述");

        Call<ResponseBody> call = testApi.upload(description, body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                LogUtils.Loge(response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                LogUtils.Loge(t.toString());
            }
        });

    }


    private void postMethod() {
        Retrofit retrofit = new Retrofit.Builder()
                //这里建议：- Base URL: 总是以/结尾；- @Url: 不要以/开头
                .baseUrl("https://www.51cnkicheck.com/")
                //增加返回值为Gson的支持(以实体类返回) 需要加下边这个包才能用
//              compile 'com.squareup.retrofit2:converter-gson:2.0.2'
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TestApi testApi = retrofit.create(TestApi.class);
        final Call<UserFavoriteListBeanForRetrofit> call = testApi.UserFavoriteList("5085", "1", "1", "20");
        call.enqueue(new Callback<UserFavoriteListBeanForRetrofit>() {
            @Override
            public void onResponse(Call<UserFavoriteListBeanForRetrofit> call, Response<UserFavoriteListBeanForRetrofit> response) {
                LogUtils.Loge(response.body().getResultCode() + "code");
                LogUtils.Loge(response.body().getCount() + "count");
                LogUtils.Loge(response.body().getMsg());
                LogUtils.Loge(response.body().getData().toString());
            }

            @Override
            public void onFailure(Call<UserFavoriteListBeanForRetrofit> call, Throwable t) {
                LogUtils.Loge(t.toString());
            }
        });
    }


    private void getMethod() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl("https://baidu.com/")
                //增加返回值为String的支持  需要加下边这个包才能用
//              compile 'com.squareup.retrofit2:converter-scalars:2.3.0'
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        TestApi mTestApi = mRetrofit.create(TestApi.class);

        Call<String> call = mTestApi.getBaidu();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("===", "return:" + response.body().toString());
                LogUtils.Loge(response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                LogUtils.Loge(t.toString());
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String imagePath = ChoosePicUtil.getPathFromResult(requestCode, resultCode, data, RetrofitActivity.this);
        Log.e("DataModifyActivity", "onActivityResult: " + imagePath);

        GearImage(new File(imagePath));
    }

    private void GearImage(File file) {
        Luban.with(this)
                .load(file)                     //传人要压缩的图片
                .setCompressListener(new OnCompressListener() { //设置回调
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSuccess(File file) {
                        switch (choosePicNumber) {
                            case 1:
                                GlidePicUtils.LoadImg(RetrofitActivity.this, img1, file.getPath());
                                break;
                            case 2:
                                GlidePicUtils.LoadImg(RetrofitActivity.this, img2, file.getPath());
                                break;
                            case 3:
                                GlidePicUtils.LoadImg(RetrofitActivity.this, img3, file.getPath());
                                break;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                }).launch();    //启动压缩
    }
}
