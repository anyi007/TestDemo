package com.example.lql.testdemo.retrofit;

import com.example.lql.testdemo.bean.UserFavoriteListBeanForRetrofit;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * 类描述：
 * 作  者：李清林
 * 时  间：2017/8/16.
 * 修改备注：
 */

public interface TestApi {

    /**
     * post请求
     *
     * @param Userid
     * @param type
     * @param page
     * @param rows
     * @return
     */
    @POST("usercenter/UserFavoriteList")
    @FormUrlEncoded
    Call<UserFavoriteListBeanForRetrofit> UserFavoriteList(@Field("Userid") String Userid, @Field("type") String type, @Field("page") String page, @Field("rows") String rows);

    /**
     * get请求
     *
     * @return
     */
    @GET("/")
    Call<String> getBaidu();


    /**
     * 上传一张图
     *
     * @param description
     * @param file
     * @return
     */
    @POST("usercenter/Upload")
    @Multipart
//    Call<String> Upload(@Part MultipartBody.Part photo,@Part("pic1") RequestBody pic1, @Part("pic2") RequestBody pic2);
    Call<ResponseBody> upload(@Part("description") RequestBody description, @Part MultipartBody.Part file);



    //// TODO: 2017/8/17  修改接口名称
    /**
     * 多文件上传
     *
     * @param description
     * @param imgs1
     * @param imgs2
     * @param imgs3
     * @param imgs4
     * @return
     */
    @POST("usercenter/Upload")
    @Multipart
    Call<ResponseBody> uploadFiles(@Part("filename") String description,
                                   @Part("file\"; filename=\"img1.png") RequestBody imgs1,
                                   @Part("file\"; filename=\"img2.png") RequestBody imgs2,
                                   @Part("file\"; filename=\"img3.png") RequestBody imgs3,
                                   @Part("file\"; filename=\"img4.png") RequestBody imgs4
    );

//// TODO: 2017/8/17  修改接口名称
    /**
     * post上传参数带文件
     */









//    这里@MultiPart的意思就是允许多个@Part了，我们这里使用了3个@Part，第一个我们准备上传个文件，使用了MultipartBody.Part类型，其余两个均为简单的键值对。
//    @Multipart
//    @POST("register")
//    Call<User> registerUser(@Part MultipartBody.Part photo, @Part("username") RequestBody username, @Part("password") RequestBody password);

    /**
     *  说一下post请求和get请求的方法
     *  先说两个请求的方式，get方式是为了请求数据，post方式是为了给后台提交数据
     *  所以在get请求的时候，传递参数的时候使用@Query()关键字，
     *  而在post请求的时候应该使用@Field()关键字，这里需要注意，在post的请求使用@Field()关键字的时候，一定要在@POST下边加上 @FormUrlEncoded
     *
     *
     *  现在，可能有人会说，那就是还有使用post请求的时候还有可能不适用@Field()关键字呗
     *  是的，在post请求中，也可以使用@Query()关键字，这样也能请求到数据，这时候用不需要再@POST下边加上 @FormUrlEncoded
     *  也就是说 @FormUrlEncoded  和@Field() 是同时出现的
     *
     */


    /**
     * 这里说一下啥时候使用@Path()关键字
     * 在一个后台接口方法中，有一个方法名称是
     * usercenter/UserFavoriteList
     * 另一个方法名称是
     * NewUsercenter/UserFavoriteList
     * 这个如果分开写，就是这样的：
     *
     *     @POST("usercenter/UserFavoriteList")
     *     Call<UserFavoriteListBeanForRetrofit> UserFavoriteList(@Query("Userid") String Userid, @Query("type") String type, @Query("page") String page, @Query("rows") String rows);
     *
     *     @POST("NewUsercenter/UserFavoriteList")
     *     Call<UserFavoriteListBeanForRetrofit> UserFavoriteList(@Query("Userid") String Userid, @Query("type") String type, @Query("page") String page, @Query("rows") String rows);
     *
     * 会发现两个分浪费，有点冗余。所以用path关键字，这样写：
     *
     *    @POST("{name}/UserFavoriteList")
     *     Call<UserFavoriteListBeanForRetrofit> UserFavoriteList(@Path(name) String ClassNme,@Query("Userid") String Userid, @Query("type") String type, @Query("page") String page, @Query("rows") String rows);
     *
     * 然后在使用的时候，就把方法名在第一个参数里边传进来
     *
     */

}
