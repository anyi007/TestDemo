package com.example.lql.testdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.utils.hotWords.GoodsSpecView;
import com.example.lql.testdemo.utils.hotWords.TagViewGroup;

import java.util.ArrayList;
import java.util.List;


public class HotwordsActivity extends AppCompatActivity {

    TagViewGroup hot_keyword ;
    ArrayList<String> mList = new ArrayList<>();



    ArrayList<String> specValues1 = new ArrayList<>();
    ArrayList<String> specValues2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotwords);
        makeData();

        //热词
        hot_keyword = (TagViewGroup) findViewById(R.id.hot_keyword);
        TagViewGroup.UiConfig config = new TagViewGroup.UiConfig();
        config.setContainerPadding(0);
        config.setButtonTextColor(0xFF111111, 0xFF111111);
        config.setButtonBackgroundResource(R.drawable.hot_keyword_bg_selector);
        hot_keyword.setData(config, mList, new TagViewGroup.OnSelectedListener() {
            @Override
            public void onSelected(String name) {
                Toast.makeText(getBaseContext(), name, Toast.LENGTH_SHORT).show();
            }
        });

        GoodsSpecView goodsSpecView = (GoodsSpecView) findViewById(R.id.goods_spec);
        GoodsSpecView.SpecName specName1 = new GoodsSpecView.SpecName("尺码");
        for (String value1 : specValues1) {
            specName1.addValue(new GoodsSpecView.SpecValue(value1));
        }
        GoodsSpecView.SpecName specName2 = new GoodsSpecView.SpecName("颜色");
        for (String value2 : specValues2) {
            specName2.addValue(new GoodsSpecView.SpecValue(value2));
        }
        List<GoodsSpecView.SpecName> specNames = new ArrayList<>();
        specNames.add(specName1);
        specNames.add(specName2);
        goodsSpecView.setData(specNames, new GoodsSpecView.OnSelectedListener() {
            @Override
            public <N, V> void onSelected(N specName, V specValue) {
                Toast.makeText(getBaseContext(), specName + "--" + specValue, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void makeData(){
        for (int i = 100000; i <100010 ; i++) {
            mList.add("小米"+i);
        }


        specValues1.add("XS");
        specValues1.add("S");
        specValues1.add("M");
        specValues1.add("L");
        specValues1.add("XL");
        specValues1.add("XXL");
        specValues1.add("XXXL");


        specValues2.add("白色");
        specValues2.add("黑色");
        specValues2.add("黄绿色");
        specValues2.add("藏青");
        specValues2.add("蝴蝶蓝");

    }

}
