package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.OverScrollViewPager;
import com.example.lql.testdemo.utils.gildeUtils.GlidePicUtils;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Admin on 2017/6/21.
 */

public class PhotoDetailActivity extends AppCompatActivity {
    private ArrayList<String> list_pics;
    OverScrollViewPager pager_detail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);


        pager_detail = (OverScrollViewPager) findViewById(R.id.pager_pic_detail);


        list_pics = getIntent().getExtras().getStringArrayList("photos");
        if (list_pics == null){
            finish();
        }
        int position = getIntent().getIntExtra("position", 0);
        PhotosAdapter adapter = new PhotosAdapter();
        pager_detail.setpagerCount(list_pics == null ? 0 : list_pics.size());
        pager_detail.setAdapter(adapter);
        pager_detail.setCurrentItem(position);
        pager_detail.setOffscreenPageLimit(3);
        pager_detail.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        pager_detail.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                pager_detail.updateCurrentIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    class PhotosAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return list_pics == null ? 0 : list_pics.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo_detail, container, false);
            PhotoView photo_detail = (PhotoView) view.findViewById(R.id.photo_detail_item);
            photo_detail.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    onBackPressed();
                }

                @Override
                public void onOutsidePhotoTap() {
                    onBackPressed();
                }
            });

            GlidePicUtils.LoadImg(PhotoDetailActivity.this , photo_detail , list_pics.get(position));
            container.addView(view);
            return view;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
