package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.bean.RxJavaStudentBean;
import com.example.lql.testdemo.utils.LogUtils;

import java.util.ArrayList;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 类描述：rxjava
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {

    Button Create_Button;//基本语法
    Button Thread_Button;//线程的变换
    TextView Thread_tv;//线程的变换

    Button Func_button;//转换(map)
    TextView Func_tv;//转换
    Button Flatmap_button;//转换(flatmap)


    Subscriber<String> mSubsrciber;
    Observable mObservable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        initView();
    }

    private void initView() {
        //基本语法的写法
        Create_Button = (Button) findViewById(R.id.create_button);
        Create_Button.setOnClickListener(this);

        //线程的变换
        Thread_Button = (Button) findViewById(R.id.thread_button);
        Thread_Button.setOnClickListener(this);
        //线程效果
        Thread_tv = (TextView) findViewById(R.id.thread_tv);

        //转换
        Func_button = (Button) findViewById(R.id.func_button);
        Func_button.setOnClickListener(this);
        //转换
        Func_tv = (TextView) findViewById(R.id.func_tv);
        //转换（flatmap）
        Flatmap_button = (Button) findViewById(R.id.flatmap_button);
        Flatmap_button.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_button:
                createRx();
                break;
            case R.id.thread_button:
                setThread();
                break;
            case R.id.func_button:
                setFunc();
                break;
            case R.id.flatmap_button:
                setFlatmap();
                break;
        }
    }


    /**
     * 基本使用方法：
     * 1、创建观察者  Observer或者Subsrciber
     * 2、创建被观察者  ObServable
     * 3、把观察者和被观察者绑定在一起
     * mObservable.subscribe(mObserver);
     * mObservable.subscribe(mSubsrciber);
     */
    private void createRx() {

        /**
         * 创建观察者（两种方式，下边有共同点和不同点）
         */
        Observer<String> mObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                LogUtils.Loge("onCompleted()完成啦");
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.Loge("onError()真倒霉，出错了：" + e.toString());
            }

            @Override
            public void onNext(String s) {
                LogUtils.Loge("onNext()咦，发生变化了呢，快看一看！" + s);
            }
        };


        /**
         *  Subsrciber 和 Observer 的基本使用方法是一样的，实际上，
         *  如果使用Observer,RxJavag会先把ObServer转换成Subsrciber再使用
         *
         *  不同点
         *  1、onStart():  这个是Subsrciber的方法，在subsrciber开始，还未发送之前调用，可以做一些数据重置等工作，
         *  但是他是在子线程里边，不能直接操作UI布局。
         *
         *  2、unsubsrciber():用于取消订阅，取消之后，就不在接收事件。在操作之前一般先用mSubsrciber.
         *  isUnsubscribed()来判断状态。可以在onStop(),onDestroy()方法中调用，起到以后不再使用的作用，
         *  用来接触引用关系，一避免发生内存泄漏。
         *
         */


        mSubsrciber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtils.Loge("onCompleted()完成啦,我是Subseriber");
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.Loge("onError()出错啦,我是Subseriber" + e.toString());
            }

            @Override
            public void onNext(String s) {
                LogUtils.Loge("onNext()咦，发生变化了呢，快看一看！,我是Subseriber" + s);
            }

            @Override
            public void onStart() {
                super.onStart();
                LogUtils.Loge("onStart()我又一个开始的方法！但是我是在子线程，不能直接做UI操作吆！我是Subseriber");
            }
        };


        /**
         * 在这里创建被观察者
         */

        mObservable = Observable.create(new OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onNext("rxJava");
                subscriber.onNext("I");
                subscriber.onError(new Throwable("网络异常了"));
                subscriber.onNext("am");
                subscriber.onNext("Millet");
                //记住这里发送完之后要有一个完成的操作
                subscriber.onCompleted();
                subscriber.onNext("后边的数据观察者就接收不到了");
                subscriber.onNext("后边的数据观察者就接收不到了");
            }
        });


        /**
         * 上边的写法太麻烦了？换成下边的写法试试啊
         * 如果需要传递一个ArrayList过去的话 ，用just方法比较合适
         */

        ArrayList<String> mList1 = new ArrayList<>();
        Observable observable = Observable.just("Hi", "RxJava", "I", "am", "Millet", "!");
        //传递一个集合或者数组
//        observable=Observable.just(mList1);
        //会依次调用
//        subscriber.onNext("Hi");
//        subscriber.onNext("RxJava");
//        subscriber.onNext("I");
//        subscriber.onNext("am");
//        subscriber.onNext("Millet");
//        subscriber.onNext("!");
//        //记住这里发送完之后要有一个完成的操作
//        subscriber.onCompleted();


        /**
         * 有或者这样写
         */
        String[] wodrs = {"Hi", "RxJava", "I", "am", "Millet", "!"};
        ArrayList<String> mList = new ArrayList();
        mList.add("Hi");
        mList.add("RxJava");
        mList.add("I");
        mList.add("am");
        Observable observable1 = Observable.from(wodrs);
//         observable1 = Observable.from(mList);
        //会依次调用
//        subscriber.onNext("Hi");
//        subscriber.onNext("RxJava");
//        subscriber.onNext("I");
//        subscriber.onNext("am");
//        subscriber.onNext("Millet");
//        subscriber.onNext("!");
//        //记住这里发送完之后要有一个完成的操作
//        subscriber.onCompleted();


        /**
         * 这里是订阅操作
         */
        mObservable.subscribe(mObserver);


        //三种方式创建被观察者的方式

        /**
         * 三种创建被观察者的方式
         * 1、普通方式，虽然写起来很繁琐，但是比较容易控制
         * 2、just方式和from方式，写起来很简单，但是会自动执行观察者的onCompleted方法，然后观察者就不会再接收
         * 事件了，比较适合在所有的数据都拿到了，准备好了，最后调用。
         * 3、普通方式，在连续发送多次数据的时候，只要执行了subscriber.onCompleted()方法，就不会接收当前发送
         * 组的消息，再次发送的时候，会再接收。
         */


        mObservable.subscribe(mSubsrciber);
//        observable.subscribe(mSubsrciber);
//        observable1.subscribe(mSubsrciber);


    }


    /**
     * 这里说一下线程的切换
     * 在不指定线程的时候，观察者和被观察值是在同一个线程中完成的
     * 但是如果我们想要被观察者必须要在子线程中完成的时候（比如耗时操作、网络请求等等）
     * 同时观察者还要去完成一些更新UI的操作，这时候我们就要指定观察者和被观察者的线程，就是线程调度问题。
     * 如果需要线程调度，就使用调度器Scheduler来操作。
     * <p>
     * 1、Schedulers.immediate(): 直接在当前线程运行，相当于不指定线程。这是默认的 Scheduler。
     * <p>
     * 2、 Schedulers.newThread(): 总是启用新线程，并在新线程执行操作。
     * <p>
     * 3、Schedulers.io(): I/O 操作（读写文件、读写数据库、网络信息交互等）所使用的 Scheduler。
     * 行为模式和 newThread() 差不多，区别在于 io() 的内部实现是是用一个无数量上限的线程池，可以重用空闲的线程，
     * 因此多数情况下 io() 比 newThread() 更有效率。不要把计算工作放在 io() 中，可以避免创建不必要的线程。
     * <p>
     * 4、Schedulers.computation(): 计算所使用的 Scheduler。这个计算指的是 CPU 密集型计算，
     * 即不会被 I/O 等操作限制性能的操作，例如图形的计算。
     * 这个 Scheduler 使用的固定的线程池，大小为 CPU 核数。
     * 不要把 I/O 操作放在 computation() 中，否则 I/O 操作的等待时间会浪费 CPU。
     * <p>
     * 5、AndroidSchedulers.mainThread()：这个是android 专有的，它指定的操作将在 Android 主线程运行。
     */
    private void setThread() {
        //创建观察者
        final Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                LogUtils.Loge(s);
                Thread_tv.setText(s);
            }
        };

        //创建被观察者
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Observable<String> observable = Observable.create(new OnSubscribe<String>() {
                @Override
                public void call(Subscriber<? super String> subscriber) {
                    subscriber.onNext("我好了");
                }
            })
                    .subscribeOn(Schedulers.io())//指定被观察者在子线程中
                    .observeOn(AndroidSchedulers.mainThread());//指观察者在主线程中

                observable.subscribe(subscriber);
            }
        }.start();

    }


    /**
     * 转换操作：两个关键字
     * 1、map：这个是一对一的转换，把一个int-->float--->String 然后把String告诉观察者
     * 2、flatMap：这个明天再继续！
     */
    private void setFunc() {
        //创建观察者
        final Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                LogUtils.Loge(s);
                Func_tv.setText(s);
            }
        };

        Observable<String> observable = Observable.create(new OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
            }
        }).map(new Func1<Integer, Float>() {
            @Override
            public Float call(Integer integer) {
                return integer * 1.0f;
            }
        }).map(new Func1<Float, String>() {
            @Override
            public String call(Float s) {
                return s + "我好了呢";
            }
        });
        observable.subscribe(subscriber);
    }


    ArrayList<RxJavaStudentBean> mRxJavaStudentBeen = new ArrayList<>();


    /**
     * 这里说转换的第二个关键字flatmap
     * 先说使用场景，这里用扔物线博客中的例子
     * 现在有一个学生的bean,然后这个学生的bean中有一个课程的bean
     * 每个学生有好多个课程，所以学生的课程就是一个list，现在要便利咱们班所有的学生的所有的课程名称
     * <p>
     * 这种方式一般只有在需要二次遍历的时候才能用到
     */
    private void setFlatmap() {
        mRxJavaStudentBeen.clear();
        makeData();
        //创建观察者
        final Subscriber subscriber = new Subscriber<RxJavaStudentBean.CurriculumBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(RxJavaStudentBean.CurriculumBean s) {
                LogUtils.Loge(s.getCurriculumName());
            }
        };


        Observable.from(mRxJavaStudentBeen)
                .flatMap(new Func1<RxJavaStudentBean, Observable<RxJavaStudentBean.CurriculumBean>>() {
                    @Override
                    public Observable<RxJavaStudentBean.CurriculumBean> call(RxJavaStudentBean rxJavaStudentBean) {
                        return Observable.from(rxJavaStudentBean.getCurriculumList());
                    }
                }).subscribe(subscriber);

    }


    /**
     * 转换flatmap需要的数据
     */
    private void makeData() {
        RxJavaStudentBean mRxBean1 = new RxJavaStudentBean();
        RxJavaStudentBean mRxBean2 = new RxJavaStudentBean();
        RxJavaStudentBean mRxBean3 = new RxJavaStudentBean();
        RxJavaStudentBean mRxBean4 = new RxJavaStudentBean();
        ArrayList<RxJavaStudentBean.CurriculumBean> curriculumBeanArrayList = new ArrayList<>();
        RxJavaStudentBean.CurriculumBean curriculumBean1 = new RxJavaStudentBean.CurriculumBean();
        RxJavaStudentBean.CurriculumBean curriculumBean2 = new RxJavaStudentBean.CurriculumBean();
        RxJavaStudentBean.CurriculumBean curriculumBean3 = new RxJavaStudentBean.CurriculumBean();
        RxJavaStudentBean.CurriculumBean curriculumBean4 = new RxJavaStudentBean.CurriculumBean();
        curriculumBean1.setCurriculumName("数学");
        curriculumBean2.setCurriculumName("英语");
        curriculumBean3.setCurriculumName("语文");
        curriculumBean4.setCurriculumName("体育");
        curriculumBeanArrayList.add(curriculumBean1);
        curriculumBeanArrayList.add(curriculumBean2);
        curriculumBeanArrayList.add(curriculumBean3);
        curriculumBeanArrayList.add(curriculumBean4);

        mRxBean1.setName("小米");
        mRxBean1.setCurriculumList(curriculumBeanArrayList);

        mRxBean2.setName("二猪");
        mRxBean2.setCurriculumList(curriculumBeanArrayList);

        mRxBean3.setName("大猪");
        mRxBean3.setCurriculumList(curriculumBeanArrayList);

        mRxBean4.setName("小红哥");
        mRxBean4.setCurriculumList(curriculumBeanArrayList);

        mRxJavaStudentBeen.add(mRxBean1);
        mRxJavaStudentBeen.add(mRxBean2);
        mRxJavaStudentBeen.add(mRxBean3);
        mRxJavaStudentBeen.add(mRxBean4);
    }


    @Override
    protected void onDestroy() {
        //在onDestory()方法中，取消订阅
        if (mSubsrciber.isUnsubscribed()) {
            mSubsrciber.unsubscribe();
        }
        super.onDestroy();
    }
}
