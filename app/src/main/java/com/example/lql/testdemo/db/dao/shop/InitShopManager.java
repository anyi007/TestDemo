package com.example.lql.testdemo.db.dao.shop;

import android.content.Context;

import com.example.lql.testdemo.R;
import com.example.lql.testdemo.db.bean.shop.CommodityBean;
import com.example.lql.testdemo.db.bean.shop.CommodityTypeBean;
import com.example.lql.testdemo.db.bean.shop.NoticeBean;

import java.util.ArrayList;

/**
 * 类描述：商城数据初始化
 * 作  者：Admin or 李小米
 * 时  间：2017/9/25
 * 修改备注：
 */
public class InitShopManager {
    public static void InitShop(Context mContext) {

        //==========================删除全部数据====================================================

        AddressBeanManager.DeleteAll();
        CollectionBeanManager.DeleteAll();
        CommodityBeanManager.DeleteAll();
        CommoditySizeBeanManager.DeleteAll();
        CommodityTypeBeanManager.DeleteAll();
        EvaluateBeanManager.DeleteAll();
        LogisticsBeanManager.DeleteAll();
        NoticeBeanManager.DeleteAll();
        OrderBeanManager.DeleteAll();
        ShoppingCartBeanManager.DeleteAll();
        UserBeanManager.DeleteAll();


        //============================添加数据======================================================

        //初始化用户
        UserBeanManager.AddUser();

        //初始化公告
        ArrayList<String> NoticNameList = new ArrayList<>();
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle1));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle2));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle3));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle4));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle5));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle6));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle7));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle8));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle9));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle10));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle11));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle12));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle13));
        NoticNameList.add(mContext.getResources().getString(R.string.noticeTitle14));


        ArrayList<String> NoticContentList = new ArrayList<>();
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent1));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent2));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent3));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent4));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent5));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent6));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent7));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent8));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent9));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent10));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent11));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent12));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent13));
        NoticContentList.add(mContext.getResources().getString(R.string.noticeContent14));


        for (int i = 0; i < NoticNameList.size(); i++) {
            NoticeBean mNoticeBean = new NoticeBean();
            mNoticeBean.setNoticeId(null);
            mNoticeBean.setNoticeTitle(NoticNameList.get(i));
            mNoticeBean.setNoticeContent(NoticContentList.get(i));
            NoticeBeanManager.AddNotice(mNoticeBean);
        }


        //初始化商品分类
        ArrayList<String> CommodityTypeNameList = new ArrayList<>();
        CommodityTypeNameList.add("男装");
        CommodityTypeNameList.add("女装");
        CommodityTypeNameList.add("男鞋");

        CommodityTypeNameList.add("女鞋");
        CommodityTypeNameList.add("箱包手袋");
        CommodityTypeNameList.add("国际名牌");

        CommodityTypeNameList.add("美妆个护");
        CommodityTypeNameList.add("钟表珠宝");
        CommodityTypeNameList.add("手机数码");

        CommodityTypeNameList.add("电脑办公");
        CommodityTypeNameList.add("家用电器");
        CommodityTypeNameList.add("食品生鲜");

        CommodityTypeNameList.add("酒水饮料");
        CommodityTypeNameList.add("母婴用品");
        CommodityTypeNameList.add("玩具乐器");

        CommodityTypeNameList.add("医药保健");
        CommodityTypeNameList.add("户外运动");
        CommodityTypeNameList.add("汽车用品");

        CommodityTypeNameList.add("宠物生活");
        CommodityTypeNameList.add("家具厨具");
        CommodityTypeNameList.add("家具家装");

        for (int i = 0; i < CommodityTypeNameList.size(); i++) {
            CommodityTypeBean commodityTypeBean = new CommodityTypeBean();
            commodityTypeBean.setCommodityTypeId(null);
            commodityTypeBean.setCommodityTypeName(CommodityTypeNameList.get(i));
            CommodityTypeBeanManager.AddCommodityType(commodityTypeBean);
        }


        //初始化商品
        ArrayList<Long> CommodityTypeIdList = new ArrayList<>();
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("男装"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("女装"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("男鞋"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("女鞋"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("箱包手袋"));


        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("美妆个护"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("手机数码"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("电脑办公"));

        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("家用电器"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("食品生鲜"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("酒水饮料"));

        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("母婴用品"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("玩具乐器"));

        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("医药保健"));
        CommodityTypeIdList.add(CommodityTypeBeanManager.LoadId("户外运动"));




        //男装系类
        addCommodity1();
        //女装系类
        addCommodity2();
        //男鞋系类
        addCommodity3();
        //女鞋系类
        addCommodity4();
        //箱包手袋
        addCommodity5();
        //美妆个护
        addCommodity6();
        //钟表珠宝
        addCommodity7();
        //手机数码
        addCommodity8();
        //电脑办公
        addCommodity9();
        //家用电器
        addCommodity10();
        //食品生鲜
        addCommodity11();
        //酒水饮料
        addCommodity12();
        //母婴用品
        addCommodity13();
        //玩具乐器
        addCommodity14();
        //医药保健
        addCommodity15();
        //户外运动
        addCommodity16();


    }



    //户外运动
    private static void addCommodity16() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2056/252/2954275668/123350/7f3a018c/572062daN9f3048c5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2110/126/1900942557/99654/ef5f6de8/56e53c68N96fe04bb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2488/354/1942003574/98499/d64ee2ab/56e53c7dNabcd31a5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2392/337/1938843110/95470/bf1e9f42/56e53c94Nbf79cb2c.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize(null);
        mCommodityBean0.setCommodityDescribe("商品名称：百斯锐度数拍商品编号：2492589商品毛重：280.00g商品产地：福建石狮货号：6959898810526");
        mCommodityBean0.setCommodityName("百斯锐Bestray羽毛球拍5U全碳素男女羽拍 可拉30磅");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6058/19/2039729953/183751/da4a2a11/593a5851Ndbe9e3a1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3616/8/1953763628/185076/c3732c0b/5837de8bN8b5366bd.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3613/62/1890178475/47602/9bfaf0c0/5837de93Nc158a6d5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3898/218/18457294/125032/6a42e4a7/5837de86Nff3e6978.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize(null);
        mCommodityBean1.setCommodityDescribe("商品名称：川崎羽毛球拍商品编号：4027692商品毛重：460.00g商品产地：中国广东货号：KD-1羽毛球服务：穿线球拍材质：碳合金球拍重量：U（95g以上）羽毛球材质：鸭毛球拍打法：控球型（攻守兼备）分类：羽毛球拍羽毛球规格：3只装适用人群：通用");
        mCommodityBean1.setCommodityName("川崎(KAWASAKI)羽毛球拍超轻碳素对拍");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3481/164/2648895390/214784/72213509/585c821aN13f27f73.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3742/101/2674979622/52064/c536a046/585c8220N85b7cbd2.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3970/17/799184401/43316/fc58f17c/585c8229N5e013f5c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3130/363/4936803699/44404/1d39dbe2/585c8224N1de91bf2.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize(null);
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：川崎羽毛球商品编号：779866商品毛重：280.00g商品产地：中国广东货号：3300羽毛球服务：穿线球拍重量：3U(85-89g)球拍打法：控球型（攻守兼备）分类：羽毛球拍适用人群：通用球拍材质：全碳素");
        mCommodityBean2.setCommodityName("川崎KAWASAKI 全碳素羽毛球拍");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3205/63/6228979094/107874/f4691c45/58a2a32fN6b2d30c2.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3289/84/6347726144/163391/7610c74c/58a2a337N378350cc.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3196/86/6212350314/59432/f2cdfc8/58a2a33fNb3176950.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3205/63/6228979094/107874/f4691c45/58a2a32fN6b2d30c2.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize(null);
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：红双喜铝合金羽毛球拍含两拍三球半拍套商品编号：219337商品毛重：60.00g商品产地：中国上海货号：1020羽毛球服务：其它是否智能：否球拍材质：合金球拍重量：U（95g以上）球拍打法：控球型（攻守兼备）分类：羽毛球拍适用人群：通用羽毛球规格：其它");
        mCommodityBean3.setCommodityName("红双喜DHS羽毛球拍对拍套装铝合金羽拍");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2005/20/2739230181/107315/e9258189/57174a1dN158b0916.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2641/351/497692689/165696/5162a7e5/57174a6aN5aa75ab3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1906/223/2748913719/64283/4ec5451f/57174a72Nf4bdde67.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2833/341/494877627/123774/5a8196dd/57174a6eN044f0d52.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize(null);
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：红双喜羽毛球拍商品编号：849059商品毛重：380.00g商品产地：上海货号：E-TX202-2羽毛球服务：其它球拍重量：U（95g以上）球拍打法：控球型（攻守兼备）分类：羽毛球拍适用人群：通用球拍材质：合金\n");
        mCommodityBean4.setCommodityName("红双喜DHS羽毛球拍对拍");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2437/41/1111219327/881691/36c4cb41/567a44d0Nc08583dc.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3127/32/1510481701/924069/6fe23e26/57ce7061N809ada58.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2050/89/1144741830/923848/26066d26/567a44d7Nce5b9c52.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1915/12/1133676585/1036009/52b3bb60/567a44e4N58334fb6.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize(null);
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：斯伯丁74-221商品编号：1060746商品毛重：0.61kg商品产地：福建漳州货号：74-221/74-604Y篮球分类：室内篮球分类：篮球篮球材质：PU规格：7号/标准");
        mCommodityBean5.setCommodityName("斯伯丁Spalding 比赛篮球74-604Y 室内外PU耐磨7号nba蓝球0");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6007/301/969147836/487413/aa8a03d0/592ec8c5Nccf5b79f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6007/301/969147836/487413/aa8a03d0/592ec8c5Nccf5b79f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5749/188/2262692193/499067/61802f71/592ec8caNd51dce23.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5887/57/2226837888/494128/bb1e2298/592ec8d7N41f58bea.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize(null);
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：斯伯丁篮球商品编号：4295237商品毛重：0.62kg商品产地：福建货号：76-176Y篮球分类：通用分类：篮球篮球材质：PU规格：其它");
        mCommodityBean6.setCommodityName("spalding 斯伯丁 76-167Y NBA比赛用蓝球 PU材质室内外兼用 篮球");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t4768/100/76322352/441761/9f0938b8/58da2aa4N91983dd5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8947/285/283052467/230646/606c8f2c/59a517d9N1a1b0c87.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4981/120/73691877/543186/3564f1e1/58da2aa3N3b3734ac.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4276/68/3105258618/412819/71bdbce8/58da2aa4N854ec7a7.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize(null);
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：斯伯丁74-582商品编号：1315320商品毛重：390.00g商品产地：福建省货号：74-582篮球分类：通用分类：篮球篮球材质：PU规格：5号/青少年");
        mCommodityBean7.setCommodityName("斯伯丁 SPALDING 74-582Y 篮球 青少年儿童5号蓝球");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t1066/144/997280737/159412/c56f6f8e/55681ef3N7d30e1b4.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1138/230/1020715821/201142/8b6787e5/55681ef1N4a3a670c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1258/167/901719465/197413/37bd0680/55681ef3Nc91845d5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1066/144/997280737/159412/c56f6f8e/55681ef3N7d30e1b4.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize(null);
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：斯伯丁65-846Y 1号球商品编号：1577230商品毛重：200.00g商品产地：福建漳州货号：65-846Y篮球分类：室内篮球，室外篮球，街头篮球，通用分类：篮球篮球材质：PU规格：其它");
        mCommodityBean8.setCommodityName("Spalding 斯伯丁 65-846Y NBA 迷你儿童一号篮球 mini 珍藏纪念版 PU材质");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6283/218/144297807/768045/cdd8db16/593a462dN5e8ad37b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5653/8/3299975072/612579/dc86437c/593a463bN7445dd21.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6262/253/147823013/708654/8fc2ea62/593a4637N1e931a08.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5686/245/3328463161/658319/20ac781/593a463fN9cf684cc.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize(null);
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：斯伯丁74-108商品编号：1061034商品毛重：0.61kg商品产地：福建漳州货号：74-108/74-600Y篮球分类：室内篮球，室外篮球，街头篮球，通用分类：篮球篮球材质：PU规格：7号/标准");
        mCommodityBean9.setCommodityName("斯伯丁Spalding比赛篮球经典掌控74-600Y室内外7号PU蓝球");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("户外运动"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3613/326/2648009856/429083/a80632eb/585cdd98N15cecd82.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2656/43/556186732/200913/5efceef0/5719be9aNe57c6fbd.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3259/162/4970608138/371262/bf47e0b9/585cdda8Nb172c0f0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3913/163/784586661/357060/7b09125e/585cdda2N5b696408.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize(null);
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：斯伯丁spalding 74-570Y商品编号：1327433商品毛重：0.62kg商品产地：福建漳州货号：1篮球分类：通用分类：篮球篮球材质：PU规格：7号/标准");
        mCommodityBean10.setCommodityName("Spalding 斯伯丁 74-570Y NBA职业比赛用球 室内外兼用 PU材质 篮球");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //医药保健
    private static void addCommodity15() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5242/127/2442329141/155214/a9e5039d/591aaaf5N1c8e9ba0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5557/217/2449281722/154203/a6005578/591aab01Ne52cf128.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5233/41/2427295177/164129/1121866f/591aab05Ne5f025f1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5197/117/2417464061/223323/f1fda266/591aaaffN6e421284.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize(null);
        mCommodityBean0.setCommodityDescribe("商品名称：东阿阿胶300g商品编号：4979558商品毛重：0.86kg商品产地：中国山东分类：阿胶糕价位：300-499包装：礼盒装");
        mCommodityBean0.setCommodityName("东阿阿胶 桃花姬阿胶糕");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6406/102/2740256681/361847/d92744c0/5965c4c7N6d1f66ba.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5872/240/2313925931/275253/d97c4552/592fe84eN63e65640.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5935/253/1180446658/212161/4eaf7e20/592fe879N7e9b682b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5716/323/2355252021/377331/a5ce6f73/592fe861Nf4b5e8d4.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize(null);
        mCommodityBean1.setCommodityDescribe("商品名称：禾博士氨糖软骨素加钙片 1.0g/片*60片*4盒套装中老年商品编号：4301337商品毛重：1.0kg商品产地：广东省汕头市主要成分：氨糖蓝帽标识：保健食品（食健字）国产/进口：国产适用人群：中老年/老年产品剂型：片剂");
        mCommodityBean1.setCommodityName("禾博士（Dr．Herbs）氨糖软骨素钙片240片+维生素D");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9400/164/2196022093/338114/92467316/59c86f28N90d07f46.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7531/183/2588770467/165993/f3b3447b/59b24727Naed9f180.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8923/175/961735384/214949/4418a504/59b24730Nf272f5f0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7816/209/2617370493/132410/c56e183/59b2472dNe6ad50b2.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize(null);
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：成博士参花消渴茶3g*72袋商品编号：5042363商品毛重：0.512kg商品产地：鞍山高新区剂型：其他药品类型：中药症状：其他适用人群：成人适用类型：其他");
        mCommodityBean2.setCommodityName("成博士 参花消渴茶3g*72袋 适用于Ⅱ型糖尿病");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2593/270/2532381676/289486/75d8ad93/5768fef5N18145b3f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2797/144/2510436095/587231/5681cc66/5768ff64Nb660916e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2686/130/2544692140/452162/68979ad1/5768ff70N289a9918.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2602/104/2547124541/166690/89e884e8/5768ff22N8179517b.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize(null);
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：999感冒灵颗粒商品编号：3142374商品毛重：118.00g商品产地：惠州市货号：205020005剂型：颗粒药品类型：中药症状：鼻塞适应人群：不限适用类型：风热感冒，暑湿感冒");
        mCommodityBean3.setCommodityName("999（三九）感冒灵颗粒 10g*9袋");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2596/42/1404757586/461073/7fc43513/573d82bdNbda77bed.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2752/63/1409801085/295335/aabce0da/573d82c8N0c9cac28.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2590/105/1397786675/313082/1d07fa9b/573d82d2N5b6fc5ad.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2674/52/1405855333/288462/5f86b81e/573d82c4N35d19e72.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize(null);
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：钙尔奇60片商品编号：2811929商品毛重：150.00g商品产地：江苏苏州货号：206010057剂型：片剂症状：骨质疏松使用方法：吞服适用人群：成人适用类型：维矿物质缺乏症");
        mCommodityBean4.setCommodityName("金钙尔奇D 碳酸钙维D3元素片");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3265/127/5571494129/331056/8e192d9/58773ff4Ndf771e87.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3070/276/5616263383/262689/537409b5/58773fbcN09e0a54c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3970/84/1477180637/250285/d70d9338/58773ffaN2dcde3c0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3826/81/3081396801/206402/81380fc7/58774005N318501a6.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize(null);
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：老谷头人参礼盒商品编号：4258864商品毛重：370.00g商品产地：中国大陆参年份：3-5年分类：人参人参形状：整枝包装：礼盒装");
        mCommodityBean5.setCommodityName("老谷头 人参 全须白参 礼盒 ");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3061/129/1192199795/658145/326cb865/57c7f5d9N8e332b97.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3061/129/1192199795/658145/326cb865/57c7f5d9N8e332b97.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3019/90/1640269399/460710/93ea1cad/57c7f5dfN05cbeb27.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3145/254/1198954724/433384/43eded35/57c7f5e3N81d66025.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize(null);
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：森山铁皮枫斗60包冲剂纸盒装商品编号：1141758商品毛重：425.00g商品产地：浙江金华营养品种类：铁皮分类：枫斗铁皮种类：种植包装：礼盒装");
        mCommodityBean6.setCommodityName("森山 铁皮枫斗冲剂60包");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2998/196/2281930378/956093/44db01b8/57d60a8aN87d0c2c2.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3067/145/5263097552/332517/e0624600/586b19bbNc55faee6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3277/231/1870629437/1227436/db96eec4/57d60a97Nf50f95ec.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3124/193/1791039492/990196/ebfd41b/57d60a92Ncebda175.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize(null);
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：胡庆余堂石斛枫斗商品编号：3040361商品毛重：1.3kg商品产地：浙江乐清铁皮种类：种植营养品种类：铁皮分类：枫斗特产品类：乐清石斛包装：盒装");
        mCommodityBean7.setCommodityName("胡庆余堂 铁皮石斛 石斛 枫斗礼盒");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2818/318/3977834769/385446/fc82a4c0/57aad21fNfdf55218.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2818/318/3977834769/385446/fc82a4c0/57aad21fNfdf55218.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3112/216/195368076/303525/5200c2ab/57aad238N0a79869f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3121/212/202665242/417563/cdab8095/57aad226N3ccc2757.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize(null);
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：智灵通藻油DHA软胶囊商品编号：2711321商品毛重：100.00g商品产地：广东省广州市主要成分：DHA蓝帽标识：保健食品（食健字）国产/进口：国产适用人群：儿童产品剂型：软胶囊");
        mCommodityBean8.setCommodityName("智灵通迪儿DHA软胶囊婴幼儿型");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3988/158/879908554/84681/8f12617f/5860cfc9Nd91c27d4.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3988/158/879908554/84681/8f12617f/5860cfc9Nd91c27d4.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3226/22/5080083180/93638/e854926a/5860cfceNf9d9f1b3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3082/93/4987835063/88073/9d644c67/5860cfccN4a9bdb8c.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize(null);
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：汤臣倍健维生素C片（橘子味）120片 官方旗舰店 补充维生素C 保健品商品编号：1120008591店铺： 汤臣倍健旗舰店商品毛重：60.00g包装方式：普通装产品类型：片剂蓝帽标识：保健食品（食健字）国产/进口：国产价位：100-199元适用人群：成人主要成分：维生素C");
        mCommodityBean9.setCommodityName("汤臣倍健维生素C片（橘子味）120片");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("医药保健"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3184/345/4088621544/231112/46b15a8d/58009554N3a126d6e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3103/169/5728978995/208294/19fd2f42/587c3c0eNa74ea79e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3184/345/4088621544/231112/46b15a8d/58009554N3a126d6e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3145/212/5762217749/152306/35ace8aa/587c3c0eNc6ca7a43.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize(null);
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：【下单立减】汤臣倍健牛初乳加钙咀嚼片60片 官方旗舰店 增强免疫力 保健品商品编号：1032323500店铺： 汤臣倍健旗舰店商品毛重：72.00g货号：6940863603212蓝帽标识：保健食品（食健字）国产/进口：国产价位：100-199适用人群：儿童产品剂型：片剂");
        mCommodityBean10.setCommodityName("汤臣倍健牛初乳加钙咀嚼片60片");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //玩具乐器
    private static void addCommodity14() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5233/30/404523175/134535/4e8bfe20/58feb541Nd1cc44e0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4666/231/3478807561/107573/db05db9b/58feb542Nc95024e6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5296/102/410583139/191891/d75d7fa1/58feb540N4da171d5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5134/67/391633835/59003/43978116/58feb53fN30a6939d.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize(null);
        mCommodityBean0.setCommodityDescribe("商品名称：乐高10698商品编号：1339446商品毛重：1.6kg商品产地：详见产品中文标签货号：10698材质：塑料规格：小颗粒适用年龄：其它包装单位：桶装");
        mCommodityBean0.setCommodityName("乐高 经典创意系列 4岁-99岁 大号积木盒 10698 儿童 积木 玩具Lego");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9979/14/221899249/183606/eec5cd06/59c9308cNcfdb6802.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8227/326/2289503101/170394/118d1ca/59c930a5N9451a176.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8083/48/2273049957/204660/4684d5b0/59c930a4N2f0aedbd.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9979/14/221899249/183606/eec5cd06/59c9308cNcfdb6802.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize(null);
        mCommodityBean1.setCommodityDescribe("商品名称：新款手偶玩具卡通动物手偶嘴巴能动早教玩具子早教玩偶讲故事礼物 蓝驴商品编号：17150001851店铺： 英华欣母婴专营店商品毛重：150.00g商品产地：中国大陆货号：JKL66AMT00021材质：毛绒包装：其它适用年龄：0-6个月分类：其它");
        mCommodityBean1.setCommodityName("新款手偶玩具卡通动物手偶嘴巴能动早教玩具子早教玩偶讲故事礼物 蓝驴");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3361/334/1874280059/123834/bd68a712/5835167eN858f5f54.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3577/338/1726353520/90281/783025a6/58313cecN491275a9.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3682/323/1792869017/89959/6e3d391b/58313ceeN87f7d184.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3676/318/1674176724/96089/f1816278/58313cf0Ncf653361.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize(null);
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：【官方旗舰店】美嘉欣无人机专业航拍飞行器遥控飞机 无刷高清FPV航拍器玩具飞机 单电无航拍(无刷+18分钟飞行)商品编号：10871286456店铺： 美嘉欣无人机旗舰店商品毛重：2.5kg商品产地：中国大陆货号：小怪兽B3材质：塑料飞机种类：无人机适用年龄：14岁以上控制类型：无线遥控电源类型：充电通道：4通道是否带摄像头：是尺寸：30-50CM");
        mCommodityBean2.setCommodityName("美嘉欣无人机专业航拍飞行器遥控飞机 无刷高清FPV航拍器玩具飞机 单电无航拍(无刷+18分钟飞行)");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t4510/335/1319650095/174727/a217f477/58dcb3cdN2675d9fb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4222/337/3245230281/276432/338831d7/58dcb3e3Nb322d949.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4951/17/205324508/254240/a713e86e/58dcb3e4N8810d6c7.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4666/327/1340883309/153520/6eecf506/58dcb3e3Nc2c2b606.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize(null);
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：CASIO卡西欧电钢琴PX760 成人88键重锤 家用立式数码电子钢琴PX750升级款 PX760BK黑色全套+双人凳礼包商品编号：1023289998店铺： 世纪音缘乐器专营店商品毛重：42.0kg适用对象：家庭教学复音数：128音色：100种以下踏板：三踏板键数：88键支持智能设备：Android和iOS适用人群：通用键盘类型：重锤键盘");
        mCommodityBean3.setCommodityName("CASIO卡西欧电钢琴PX760 成人88键重锤 家用立式数码电子钢琴PX750升级款 PX760BK黑色全套+双人凳礼包");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t6628/133/600791265/109932/c81d9689/59423387N6b296bae.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2059/132/1896587859/274457/2a13d5/56e66bc7Ne89dd6ef.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2059/132/1896587859/274457/2a13d5/56e66bc7Ne89dd6ef.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6055/59/7252022968/355524/184f1444/597beb1cN6c9085ea.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize(null);
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：【品牌直销】雅得(ATTOP TOYS)阿凡达遥控飞机直升机儿童玩具摇控飞机无人机飞行器 713阿凡达舰载机商品编号：1154156640店铺： 雅得旗舰店商品毛重：1.0kg货号：YD-711/718/713材质：塑料飞机种类：直升机适用年龄：14岁以上控制类型：无线遥控电源类型：电池通道：3.5通道是否带摄像头：否尺寸：30CM以下");
        mCommodityBean4.setCommodityName("雅得(ATTOP TOYS)阿凡达遥控飞机直升机儿童玩具摇控飞机无人机飞行器 713阿凡达舰载机");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6025/170/7533050076/232597/3aad52f9/597ef272N1eb1fa4f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6025/170/7533050076/232597/3aad52f9/597ef272N1eb1fa4f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6115/304/7447262191/77174/3639fac6/597ef273Nc819af40.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6916/252/1253328202/89550/bbb52c/597ef271N4d4e487b.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize(null);
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：葡萄（putao）百变布鲁可系列 赛车积木玩具 拼装大颗粒 男女孩儿童益智拼插积木 遥控板商品编号：13973069997店铺： 葡萄官方旗舰店商品毛重：0.84kg商品产地：中国大陆材质：塑料规格：大颗粒适用年龄：4-12岁包装单位：盒装");
        mCommodityBean5.setCommodityName("葡萄（putao）百变布鲁可系列 赛车积木玩具 拼装大颗粒 男女孩儿童益智拼插积木");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5557/75/1889610887/111666/d4542518/5915b5a7N3cefd479.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5209/326/1964805985/337268/4beabcc7/5915b5a8N4984e8b6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5374/185/1864734383/252048/2f117ef3/5915b5a9N48a8428f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5173/273/1910344966/174440/2f2d9bbb/5915b5a3N828e2bdd.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize(null);
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：葡萄（putao）24色超轻粘土 AR黏土套装 无毒彩泥 橡皮泥 早教益智DIY玩具 搭配7块模具商品编号：12159893549店铺： 葡萄官方旗舰店商品毛重：1.0kg商品产地：中国大陆颜色数：24色分类：粘土适用年龄：4-6岁，7-14岁包装：礼品装");
        mCommodityBean6.setCommodityName("葡萄（putao）24色超轻粘土 AR黏土套装 无毒彩泥 橡皮泥 早教益智DIY玩具 搭配");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6898/159/2305989111/153132/5f822598/598ad155N9d34f422.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5683/6/9847820728/140338/27482886/598ad156N3a43c18b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5683/6/9847820728/140338/27482886/598ad156N3a43c18b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5749/125/9837284874/133765/f0c94917/598ad154N33ba586a.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize(null);
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：【免邮】葡萄（putao）三阶魔方 儿童启蒙益智早教玩具 葡萄魔方标准版 支持速拧商品编号：11171924327店铺： 葡萄官方旗舰店商品毛重：300.00g商品产地：中国大陆材质：塑料适用年龄：3-14岁种类：正方体阶数：三阶");
        mCommodityBean7.setCommodityName("葡萄（putao）三阶魔方 儿童启蒙益智早教玩具 葡萄魔方标准版 支持速");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5779/352/8117895909/70106/b47380bc/5976f8f2N8086874f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5893/314/8049811427/165414/6a5433cb/5976f8f3N2475ffdd.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6904/240/512575373/58551/78974789/5976f8f5N839862b6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7054/235/499330484/168998/d35931cd/5976f8f6Nfa1d65bd.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize(null);
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：葡萄（putao）编程机器人 智能教育机器人礼物 益智逻辑思维培养玩具 Paigo商品编号：12275963678店铺： 葡萄官方旗舰店商品毛重：0.87kg商品产地：中国大陆材质：塑料适用年龄：6-9岁控制类型：无线遥控电源类型：充电分类：智能机器人");
        mCommodityBean8.setCommodityName("葡萄（putao）编程机器人 智能教育机器人礼物 益智逻辑思维培养玩具 Paigo");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3274/296/7639814963/278337/88f56b81/58ba532bN1992d8c0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4135/190/847030375/278652/4be2fffa/58ba53daN52d7ce03.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4375/83/851824863/356777/8dd54615/58ba532fN7bf3ccab.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3922/141/972820866/264578/c4fa4c52/58ba5332N117c05e9.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize(null);
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：日本LIV HEART北极熊毛绒玩具大号长抱枕公仔玩偶送女孩生日礼物 夏季冰丝款 （冰丝款只生产L号） 单只L号商品编号：10351658546店铺： LIVHEART旗舰店商品毛重：0.96kg货号：28976适用年龄：3岁以下，3-6岁，7-14岁，14岁以上尺寸：40cm以上造型：动物分类：靠枕/抱枕填充物：其它面料：毛绒");
        mCommodityBean9.setCommodityName("日本LIV HEART北极熊毛绒玩具大号长抱枕公仔玩偶送女孩生日礼物 夏季冰丝款 ");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("玩具乐器"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9421/87/1221590465/342421/291ffbd3/59b63a87Nd055cea4.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7252/131/2896065279/338333/175ef034/59b63a9fN0d5d5e53.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8905/104/1190719673/294537/2b52e64e/59b63a99N7b913fff.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8659/177/1209906276/252318/95df09d2/59b63a9fNd7ba1eab.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize(null);
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：LIVHEART折叠收纳盒衣物整理箱内裤文胸衣服收纳箱家用储物盒布艺 卡其色商品编号：16509696725店铺： LIVHEART旗舰店商品毛重：39.00g材质：其它升数：40-49L风格：简约，条纹，卡通，波点，花卉，其它　分类：整理箱功能：可折叠个数：1个装\n");
        mCommodityBean10.setCommodityName("LIVHEART折叠收纳盒衣物整理箱内裤文胸衣服收纳箱家用储物盒布艺 卡其色");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //母婴用品
    private static void addCommodity13() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6121/86/1585018346/192262/d6b0d1f3/5934dd63N1ac37321.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2977/318/1000856466/146632/eff2f3e2/5770b86fNa6abbdf2.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2764/363/2745399753/237624/63b2a3fd/5770b877N2be7e246.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2608/297/2736543638/292411/c28da2c0/5770b873N1829dca2.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("900g,1200g");
        mCommodityBean0.setCommodityDescribe("商品名称：美素佳儿奶粉商品编号：1029507商品毛重：1.11kg商品产地：荷兰奶源产地：荷兰国产/进口：进口适用年龄：12-36个月包装单位：桶装配方：常规配方奶粉分类：牛奶粉净含量：801-1000g段位：3段");
        mCommodityBean0.setCommodityName("美素佳儿（Friso）金装幼儿配方奶粉 3段");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6082/158/1610790954/199050/8d7b86ca/5934dcb7N0f887719.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t3295/304/5699672378/385916/14160ef2/587d8621N30664d9a.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3109/310/5730183235/262521/271ad109/587d8628Nea7613f1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3301/33/5802670933/643786/666a84e3/587d862dN4ebec3bf.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("900g,1200g");
        mCommodityBean1.setCommodityDescribe("商品名称：美素佳儿奶粉商品编号：1029508商品毛重：1.12kg商品产地：荷兰奶源产地：荷兰国产/进口：进口适用年龄：6-12个月包装单位：桶装配方：常规配方奶粉分类：牛奶粉净含量：801-1000g段位：2段");
        mCommodityBean1.setCommodityName("美素佳儿（Friso）金装较大婴儿配方奶粉 2段（6-12个月婴幼儿适用）900克");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6634/319/342223389/258982/7e7898b4/593df676Nb24e120f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3094/132/5755128701/346756/300980ea/587d8721Nc9481aa3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4039/243/1539182620/595613/50d55d8/587d871cN3b021e43.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3205/275/5712981123/370066/c2ee393d/587d8728Nebc91ff4.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize("900g,1200g");
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：美素佳儿奶粉商品编号：1604139商品毛重：1.34kg商品产地：荷兰奶源产地：荷兰国产/进口：进口适用年龄：6-12个月包装单位：盒装配方：常规配方奶粉分类：牛奶粉净含量：1001-2000g段位：2段");
        mCommodityBean2.setCommodityName("美素佳儿（Friso）金装较大婴儿配方奶粉 2段（6-12个月婴幼儿适用）");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean3.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t8791/161/341084734/291524/206f9758/59a61941Ne26beab1.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t9292/222/332377219/277693/ec460c67/59a61968Ne88ac17d.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t8239/247/346922590/404489/d5797908/59a61971N7077f0af.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7420/239/2027384616/439676/fd2c9274/59a6197fNe7ffdf06.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize("900g,1200g");
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("");
        mCommodityBean3.setCommodityName("雅戈尔youngor 【DP免烫】 秋季男士长袖衬衫 商务休闲 蓝底黑白格 40");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3928/194/123986805/226569/55e36bd4/583e692dNfa8c2c00.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3964/191/151108449/255633/e07f196c/583e6930N6f303fd8.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3973/187/133815604/164089/3716a07/583e6935Nc0fbfc1f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3298/144/4344814648/166180/eac54c04/583e6938Na3be6ffd.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize("900g,1200g");
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：美素佳儿4段儿童奶粉商品编号：2168109商品毛重：1.335kg商品产地：荷兰奶源产地：荷兰国产/进口：进口适用年龄：其它包装单位：盒装配方：常规配方奶粉分类：牛奶粉净含量：1001-2000g段位：4段");
        mCommodityBean4.setCommodityName("美素佳儿（Friso）金装儿童配方奶粉 4段（3岁以上至6岁适用）1200克");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3139/276/2490018532/553810/d1f6e5ef/57e24e46N1f467864.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6019/231/1582426104/219768/ddc5ffa3/5934dda8N2f84e962.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3217/147/2551215317/338868/c742022f/57e24e54N72d8042d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3208/305/2506407924/347921/c05d/57e24e57N28c7951b.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize("900g,1200g");
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：美素佳儿奶粉商品编号：1016355商品毛重：1.35kg商品产地：荷兰奶源产地：荷兰国产/进口：进口适用年龄：12-36个月包装单位：盒装配方：常规配方奶粉分类：牛奶粉净含量：1001-2000g段位：3段");
        mCommodityBean5.setCommodityName("美素佳儿（Friso）金装幼儿配方奶粉 3段（1-3岁幼儿适用）1200克");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5962/86/1669726268/224725/ea4c0a07/5934d62dN12b2f104.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4105/276/1116720461/105406/69b1ac4/586b0e0bN27fb9f73.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4024/280/1088995790/116070/706c933e/586b0e0bNc544c441.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4051/318/1168348903/71655/b7c1b3a6/586b0e0cNad91fb17.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize("900g,1200g");
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：美素佳儿婴儿奶粉商品编号：2491010商品毛重：1.01kg商品产地：荷兰奶源产地：荷兰适用年龄：6-12个月国产/进口：进口配方：常规配方奶粉分类：牛奶粉段位：2段包装单位：桶装");
        mCommodityBean6.setCommodityName("美素佳儿（Friso Prestige) 皇家较大婴儿配方奶粉 2段");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6100/144/1602454122/358623/1cef9ecf/59350b94Naa5ff4a0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3304/72/4088585520/320728/f8a2fc7/583ce8ecNec6b5cce.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3337/111/2019093368/210158/dbb0ced0/583ce8fdN5f3fa4e0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3316/256/1996832507/182245/99ead2a8/583ce901N6cdc270d.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize("900g,1200g");
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：诺优能奶粉商品编号：831721商品毛重：0.89kg商品产地：荷兰奶源产地：荷兰国产/进口：进口适用年龄：12-36个月包装单位：桶装配方：常规配方奶粉分类：牛奶粉净含量：401-800g段位：3段");
        mCommodityBean7.setCommodityName("诺优能Nutrilon 幼儿配方奶粉3段(12-36个月适用)800g");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5899/180/2870107578/384688/c5dcecb1/59350c72N40543569.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3169/176/5745277588/371913/f9afb753/587c5e69N9c748671.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3964/191/1505508906/185721/9770c7a5/587c5e7aN340a76ce.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3181/197/5684018963/207225/d71a8e79/587c5e7fNbb87ce0e.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize("900g,1200g");
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：爱他美奶粉商品编号：4264348商品毛重：1.1kg商品产地：荷兰奶源产地：荷兰适用年龄：12-36个月国产/进口：进口配方：常规配方奶粉分类：牛奶粉段位：3段包装单位：桶装");
        mCommodityBean8.setCommodityName("爱他美白金版Aptamil 幼儿配方奶粉3段(12-36个月适用)900g(欧洲进口)");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5644/187/2867806559/386758/fab28998/59350c50Nfae30285.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3952/238/1522398706/359206/ae67e13a/587c5ebaN90db2590.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3907/242/1464782158/200559/39512509/587c5ec2Nc83f8653.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3172/77/5642826746/203868/13326adb/587c5ec5N39a23036.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize("900g,1200g");
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：爱他美奶粉商品编号：4264350商品毛重：1.1kg商品产地：荷兰奶源产地：荷兰适用年龄：其它国产/进口：进口配方：常规配方奶粉分类：牛奶粉段位：4段包装单位：桶装");
        mCommodityBean9.setCommodityName("爱他美白金版Aptamil 儿童配方奶粉4段(36-72个月适用)900g");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("母婴用品"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5938/337/1762435341/180983/3ad49ca3/5934fd8eNaf29ff61.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2497/145/2955605618/129015/d4b16fe8/56fa1113N130f3e17.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2488/286/2250348806/229590/5a884ccb/56fa1135Nb9e4f0ec.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1837/359/2894502856/190276/723aa43a/56fa112eNd57aae2d.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize("900g,1200g");
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：圣元奶粉商品编号：2584662商品毛重：1.1kg商品产地：山东青岛市货号：1112141奶源产地：法国国产/进口：国产适用年龄：12-36个月包装单位：桶装配方：常规配方奶粉分类：牛奶粉净含量：801-1000g段位：3段");
        mCommodityBean10.setCommodityName("圣元(Synutra)奶粉 优博58幼儿配方奶粉3段(12-36个月幼儿适用) 900克");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //酒水饮料
    private static void addCommodity12() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t7063/106/557904000/196693/4fa356af/5981ae19Na8300f06.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3151/361/1762182127/298758/6fa85fad/57d3c70dNa843639c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3238/45/1812344401/187732/56ec8665/57d3c70eNa7a0398c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3292/173/1723196188/100495/87faa8b5/57d3c70dNf346898d.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize(null);
        mCommodityBean0.setCommodityDescribe("商品名称：【聚加酒铺】西凤酒国宾缘 50度 浓香型白酒 婚宴用酒 喜庆红瓶 整箱500ml*6商品编号：10395141106店铺： 聚加酒类官方旗舰店商品毛重：1.3kg香型：浓香包装：单瓶容量：375mL-500mL度数：50度以上");
        mCommodityBean0.setCommodityName("【聚加酒铺】西凤酒国宾缘 50度 浓香型白酒 婚宴用酒 喜庆红瓶 整箱");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t556/2/39472867/158604/5e7f6bae/5448c8b6N1258e8b1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t598/269/45633629/71783/a74b1d8d/5448c8b7Nf396e60f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t544/11/35586080/154682/9c9dd7b2/5448c8b9N02dac59d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t592/4/33955176/165187/1862fc87/5448c8baNebdf0344.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize(null);
        mCommodityBean1.setCommodityDescribe("商品名称：京酒白酒商品编号：1233728商品毛重：7.38kg商品产地：四川宜宾度数：50度以上香型：浓香");
        mCommodityBean1.setCommodityName("五粮液股份公司出品 京酒 彩箱四代 年份老酒 52度浓香型白酒 整箱装 ");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t7630/71/1600695835/210714/5e8ad9d6/599e24edN93efe3e3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3193/317/8771065959/90727/227bdb7b/58c7a551N3946d0af.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3886/292/1957673013/77331/32ae4f8d/58c7a557N75399d40.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4321/118/1872504725/83156/d6dcfe6b/58c7a55cN7eaebb57.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize(null);
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：张裕葡萄酒商品编号：1477321商品毛重：8.74kg商品产地：中国口味：干型容量：376ml-750ml葡萄品种：赤霞珠（Cabernet Sauvignon）国产/进口：国产分类：红葡萄酒特性：礼盒馈赠包装单位：箱装");
        mCommodityBean2.setCommodityName("【京东超市】张裕（CHANGYU）红酒 特选级窖藏（圆筒装）干红葡萄酒");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t5173/37/452059071/247081/9d61a707/59000c67N80769ec0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4906/90/1282225963/124875/570011ad/58ef2229N6a76fc07.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4759/181/1310825457/131454/7667b2d8/58ef2225Nd89f14e1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4759/181/1310825457/131454/7667b2d8/58ef2225Nd89f14e1.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize(null);
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：翡马尔多 AOC 干红 圣曼尼商品编号：3029002商品毛重：1.78kg商品产地：法国口味：干型容量：376ml-750ml葡萄品种：梅洛（Merlot）国产/进口：进口分类：红葡萄酒特性：礼盒馈赠包装单位：礼盒装");
        mCommodityBean3.setCommodityName("法国进口红酒 波尔多AOC级 卡斯蒂永丘产区 翡马 圣曼尼酒庄干红葡萄酒 礼盒装");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3112/134/5115621432/95834/b503f0db/58638ea0N15b27938.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3937/1/967299606/66530/fcfbedde/58638ea1N0e1785a5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4018/341/966179923/104779/ec2b6196/58638ea0N110c5e2f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3148/184/5153195435/171403/6402a255/58638ea1N7a2013ac.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize(null);
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：长城葡萄酒商品编号：1030701商品毛重：2.72kg商品产地：河北沙城口味：干型容量：750ml以上葡萄品种：赤霞珠（Cabernet Sauvignon）国产/进口：国产分类：红葡萄酒特性：其它包装单位：瓶装");
        mCommodityBean4.setCommodityName("长城（GreatWall）红酒 桑干酒庄特级精选赤霞珠干红葡萄酒 ");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5644/66/2331071991/201661/187c1c43/592fdb89N227006a8.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6043/4/805334024/281648/ae81135d/592fdb92N0cca30a5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5956/344/1161510759/170986/573af009/592fdb91N3bd41b93.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t5779/321/2361217828/233425/5614d7eb/592fdb8aN130a8c60.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize(null);
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：石花来两口 42度浓香型小酒 湖北石花酒业粮食酒小酒 42%Vol.单瓶125ml*1商品编号：10006374551店铺： 石花酒类旗舰店商品毛重：250.00g香型：浓香包装：单瓶容量：375mL及以下度数：40-49度");
        mCommodityBean5.setCommodityName("石花来两口 42度浓香型小酒 湖北石花酒业粮食酒小酒 42%Vol.单瓶");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5881/29/1308578242/38853/da4cc825/5925610aN8f0c283c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6049/272/58445601/479093/f9542300/59255eb2Nb9a4c20b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5572/200/1287705494/80227/a98977ba/59256125N8337a3f7.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5572/200/1287705494/80227/a98977ba/59256125N8337a3f7.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize(null);
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：华都礼盒装商品编号：5187552商品毛重：5.95kg商品产地：中国大陆货号：6926152514629容量：375mL-500mL度数：50度以上包装：礼盒酿造工艺：液态法白酒香型：清香");
        mCommodityBean6.setCommodityName("华都 一起赢 北京二锅头 53度500ml *6瓶 礼盒装清香型白酒");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t10834/354/165446539/256634/7b3985b4/59c7d863N34302790.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5830/120/9229275641/149624/409aff7/5984141eN441dccb6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6844/76/1680518158/203944/21bb8549/59841426Na7a2507b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6073/190/7941253844/158882/185e2177/59841427N2c19e498.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize(null);
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("");
        mCommodityBean7.setCommodityName("AK童装轻复古梭织长裤1712508 卡其色");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2029/283/2541439431/422838/46353d1f/56e1231dN6ffccc6e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2122/178/2609440593/166066/fd05c6cc/56e1232cNcca0b4f1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2029/283/2541439431/422838/46353d1f/56e1231dN6ffccc6e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2122/178/2609440593/166066/fd05c6cc/56e1232cNcca0b4f1.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize(null);
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：五粮液五粮春 45度500ml 浓香型白酒商品编号：10172355344店铺： 酒悦久旗舰店商品毛重：1.25kg香型：浓香包装：单瓶容量：375mL-500mL度数：40-49度");
        mCommodityBean8.setCommodityName("五粮液五粮春 45度500ml 浓香型白酒");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t1165/152/1008050209/180467/64db5143/55645767N6d827d23.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1180/236/990889392/152989/ecdc551c/55645767N4113862f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1162/67/706629782/141262/4f589dcc/553e1011N13983e7e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1168/315/721016380/63139/c7be5ae9/553e1013N29b77197.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize(null);
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：八八坑道白酒商品编号：1589953商品毛重：7.49kg商品产地：台湾香型：清香包装：整箱容量：501mL-750mL度数：40-49度");
        mCommodityBean9.setCommodityName("台湾八八坑道高粱酒 典藏淡丽42度 整箱装 600ml*6瓶");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("酒水饮料"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8071/217/2200013071/493164/de04b6ec/59c738f2N5c9791a9.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8509/267/2192761090/212684/4a18c522/59c738f3N82b7c447.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8203/230/2142447600/310231/1a7ed38b/59c738f3N4c6efb85.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t10810/153/136826904/147780/ab6a4e70/59c73a0cN7e4ad798.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize(null);
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：牛栏山经典二锅头 黄瓷瓶清香型白酒 52度黄龙500ml 整箱装 53度经典二锅头 单瓶装商品编号：17069565260店铺： 聚鑫汇缘酒类专营店商品毛重：10.5kg商品产地：中国大陆容量：其它度数：50度以上包装：整箱酿造工艺：固态法白酒香型：清香");
        mCommodityBean10.setCommodityName("牛栏山经典二锅头 黄瓷瓶清香型白酒 52度黄龙500ml 整箱装 53度经典二锅头 单瓶装");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //食品生鲜
    private static void addCommodity11() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8719/75/239025048/431415/32fec738/59a3ca0eNb677d4bf.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8128/50/232234836/428670/e9382ada/59a3ca10Nc93ab29f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8902/72/233365647/276493/90edbe62/59a3ca12N86c2f12a.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8938/87/232703951/218115/5d54c33c/59a3ca13N146c2c35.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("500g,1000g,1500g");
        mCommodityBean0.setCommodityDescribe("商品名称：洽洽月饼礼盒302g商品编号：5395854商品毛重：0.66kg商品产地：江苏丹阳是否含糖：含糖口味：其它资质认证：其它加工工艺：烘烤类");
        mCommodityBean0.setCommodityName("洽洽 饼干糕点 中秋月饼礼盒 粽罐四枚装302g");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t4891/224/2421299573/101815/22a91962/58feb01fN17afefac.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5185/154/403780691/100588/ab6452ff/58feb026N7602650b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5167/110/397350832/125613/3e4d4466/58feb026N1d667514.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5374/67/400630741/110756/a398edeb/58feb021N361a0e18.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("500g,1000g,1500g");
        mCommodityBean1.setCommodityDescribe("商品名称：LU露怡曲奇饼干（礼盒装）480g商品编号：3445059商品毛重：0.83kg商品产地：法国国产/进口：进口适用场景：休闲娱乐包装：礼盒装饼干分类：曲奇饼干存储条件：常温分类：饼干包装单位：盒装");
        mCommodityBean1.setCommodityName("LU露怡曲奇饼干（礼盒装）480g");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2230/344/1564467731/174487/3e869078/566551d8N697d0ddf.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2440/298/1374345290/319974/1c73c437/569c7b70Nfb84892b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2434/290/1442471351/231873/9e32072/569c7b80N625d75c0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2275/116/1981827945/254867/83269aa1/569c7c15Na67a64e7.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize("500g,1000g,1500g");
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：多芙利240g商品编号：2142116商品毛重：280.00g商品产地：阿联酋迪拜货号：6291100604951口味：巧克力味产品产地：其它适用场景：节日，休闲娱乐，送礼，聚会，其它蛋糕糕点分类：西式糕点分类：蛋糕糕点包装：其它包装单位：盒装");
        mCommodityBean2.setCommodityName("Dofreeze 多芙利瑞士巧克力味蛋糕卷 240g");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t7516/308/1493970431/210931/84fb0f09/599d0ed2Ne7c58d7c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7489/176/1449168786/222195/54d33dc/599d0efcNdceb07eb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7357/124/1403718776/198439/d610f820/599d0ef6Nb5f427d5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7858/287/1472529432/169041/2f95982/599d0f28N7636d1fc.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize("500g,1000g,1500g");
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：伊利味可滋商品编号：4850335商品毛重：3.47kg商品产地：中国大陆资质认证：其它国产/进口：国产每箱规格：7-12包装单位：箱装是否含糖：含糖单件容量：201-400ml是否量贩：其它脂肪含量：其它净含量：240ml*12分类：风味奶适用人群：通用适用场景：其它");
        mCommodityBean3.setCommodityName("伊利 味可滋 香蕉牛奶240ml*12/盒 emoji版");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t8698/238/1221833486/92677/1f05f78/59b66c2cN5baf9969.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6898/300/1477015976/209149/eb8a93f3/5981adceN7d5ea7f9.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5890/89/9240605681/128419/ff0023b9/598434caNa009fe49.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8698/238/1221833486/92677/1f05f78/59b66c2cN5baf9969.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize("500g,1000g,1500g");
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：新希望酸奶商品编号：5332126商品毛重：1.44kg商品产地：河北保定资质认证：其它国产/进口：国产每箱规格：1-6包装单位：箱装是否含糖：含糖单件容量：201-400ml是否量贩：否脂肪含量：其它净含量：其它分类：酸奶适用人群：通用适用场景：日常");
        mCommodityBean4.setCommodityName("新希望 酸奶airsnow轻爱轻质感饮用型酸奶200g*6盒/箱");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5509/42/1905550905/168904/f83e9ed0/59159ea5Nc99d793f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5329/224/1918662711/142002/fd0d4fb5/59159ea6N7b509096.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5380/21/1855623016/163607/900cf77e/59159ea6N7c368948.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5320/17/1871245635/140864/2734e41a/59159ea7Nc95507bb.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize("500g,1000g,1500g");
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：山萃混合坚果商品编号：2990259商品毛重：1.035kg商品产地：北京通州口味：原味特性：其它豆类分类：其它国产/进口：国产分类：混合干果包装：其它　包装单位：其它");
        mCommodityBean5.setCommodityName("山萃 中粮 每日坚果 坚果炒货 休闲零食 混合坚果 礼盒 (25g*30包) 750g/盒");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6511/104/1383899980/157369/855bc2f0/5950c910N4e4e01ba.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6595/356/1382925362/214660/3587a2a5/5950c919N2a9f774c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6616/111/1399004390/170640/18932194/5950c91bNb5431023.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6070/268/3308879488/110221/d195f229/5950c91aNc25f2d10.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize("500g,1000g,1500g");
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：良品铺子榴莲商品编号：3637266商品毛重：50.00g商品产地：中国大陆产品产地：中国大陆包装：其它国产/进口：国产加工工艺：果干类分类：其它包装单位：袋装");
        mCommodityBean6.setCommodityName("良品铺子 榴莲干 冻干 蜜饯果干 新鲜水果干 零食小吃袋装36g");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t1867/296/331786404/139418/970cc453/5601359bNb62a429d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3520/153/992435832/251715/a6d22a61/5819827bNd51f44fd.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3520/153/992435832/251715/a6d22a61/5819827bNd51f44fd.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3733/9/999772551/480794/a7563f94/5819827cN56cbabc5.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize("500g,1000g,1500g");
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：三只松鼠_坚果大礼包985g 零食干果特产礼盒4罐装 舌尖全球版 商品编号：1073568778店铺： 三只松鼠旗舰店商品毛重：0.985kg口味：原味特性：带皮豆类分类：其它国产/进口：国产分类：其它　包装：礼盒装包装单位：其它　");
        mCommodityBean7.setCommodityName("三只松鼠_坚果大礼包985g 零食干果特产礼盒4罐装 舌尖全球版");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3814/312/3119857407/251045/cfd0006/58786b97N06f0b9b4.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3280/251/2078155301/140547/493519c/57d915c5N30bfe79a.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3058/295/5693040697/181485/31ad8e29/58786b9cNf8e18aef.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5635/305/4126277873/280193/c3f3dc31/594a340bN307a66a5.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize("500g,1000g,1500g");
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：沈大成 中华老字号花开富贵 传统糕点 糯米团子麻薯点心 休闲零食办公茶点礼盒装 花开富贵商品编号：11252680925店铺： 悠闲时刻食品专营店商品毛重：240.00g货号：902579资质认证：其它果冻形态：其它国产/进口：国产包装单位：袋装是否含糖：含糖果冻布丁分类：其它特性：其他口味：其他膨化食品：其它包装：礼盒装分类：其它豆类制品：其它");
        mCommodityBean8.setCommodityName("沈大成 中华老字号花开富贵 传统糕点 糯米团子麻薯点心 休闲零食办公茶点礼盒装 花开富贵");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5185/143/451355043/186552/ff243417/5900102bN8c2795e1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7933/273/1074814163/83724/163a9373/599a44c7Ne07d8de6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7282/301/1095584810/143543/4e14a170/599a44c7N330a9fba.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7687/324/1090003591/111938/942d63a7/599a44c7Need9e192.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize("500g,1000g,1500g");
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：沈大成 中华老字号诞生礼 嘿U墨鱼大福 蛋黄酥礼盒 麻薯糯米团子 传统糕点休闲零食办公茶点 蛋黄酥礼盒120g商品编号：12171332947店铺： 悠闲时刻食品专营店商品毛重：180.00g商品产地：中国大陆货号：903033资质认证：其它国产/进口：国产加工工艺：其它包装单位：盒装是否含糖：含糖口味：其它蛋糕糕点分类：中式糕点包装：礼盒装饼干分类：其它存储条件：常温分类：蛋糕糕点适用场景：送礼");
        mCommodityBean9.setCommodityName("沈大成 中华老字号诞生礼 嘿U墨鱼大福 蛋黄酥礼盒 麻薯糯米团子 传统糕点休闲零食办公茶点 蛋黄酥礼盒120g");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("食品生鲜"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t4729/288/216837423/235423/94617f54/58dcb071N457264e7.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t547/127/1202439976/83384/aafbdf5c/54bf68eeNa0f5331c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t466/158/1236780828/170769/73182c53/54bf68ecN557d9834.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4129/365/3209664453/140649/90f6026a/58dcb070N275862af.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize("500g,1000g,1500g");
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：哈氏 中华老字号手工糕点点心 纯奶蝴蝶酥花生排松仁酥杏桃酥胡桃排 盒装休闲零食办公茶点 小蝴蝶酥110g商品编号：1430552085店铺： 悠闲时刻食品专营店商品毛重：300.00g资质认证：其它国产/进口：国产加工工艺：烘烤类包装单位：盒装是否含糖：含糖口味：原味蛋糕糕点分类：中式糕点包装：礼盒装饼干分类：曲奇饼干存储条件：常温分类：蛋糕糕点适用场景：节日");
        mCommodityBean10.setCommodityName("哈氏 中华老字号手工糕点点心 纯奶蝴蝶酥花生排松仁酥杏桃酥胡桃排 盒装休闲零食办公茶点 小蝴蝶酥110g");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //家用电器
    private static void addCommodity10() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6475/226/2107256453/108947/e01cc435/595d9cf4N732a105e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6244/167/2517834367/30273/3a55723a/59634c5eN664ebad1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6349/98/2552452736/68669/e54d7372/59643333Nd648cc87.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6418/261/2541854280/36875/776537c4/59634c63Nf7ff4f7c.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("40,44,50,60");
        mCommodityBean0.setCommodityDescribe("商品名称：SHARPLCD-60SU465A商品编号：3755141商品毛重：25.5kg商品产地：中国大陆合约方案：爱奇艺视频合约观看距离：3-3.5米分辨率：超高清电视类型：4K超清电视，智能电视能效等级：二级能效屏幕尺寸：58-60英寸选购指数：10.0-8.0");
        mCommodityBean0.setCommodityName("夏普 (SHARP) LCD-60SU465A 60英寸4K超高清wifi智能网络液晶平板电视机");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t4252/43/3259960696/411912/6eb52b3/58dcc732N2bb6c270.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4651/328/513160669/112579/2207f7bc/58d0d99cN0b4acc20.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4549/365/499348198/82357/b0ab7330/58d0d9a1Nf673e610.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3253/70/9229255807/45846/dde7e748/58d0d9a5Nc866be90.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("40,44,50,60");
        mCommodityBean1.setCommodityDescribe("商品名称：小米小米电视4A 55英寸 标准版商品编号：4609652商品毛重：16.3kg商品产地：中国大陆观看距离：2.5-3米分辨率：超高清电视类型：4K超清电视，HDR，智能电视，互联网电视能效等级：三级能效屏幕尺寸：55英寸");
        mCommodityBean1.setCommodityName("小米（MI）小米电视4A 标准版 55英寸 ");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3373/57/264276553/35063/38ccbe09/580447adNc428f26c.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t7411/201/1244592544/202783/484878e5/599b92f5Nc93fd63d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3340/75/249323757/361894/c5364b78/580447b0N2ee4b64f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3373/57/264276553/35063/38ccbe09/580447adNc428f26c.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize("40,44,50,60");
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：索尼KD-55X7000D商品编号：3498623商品毛重：17.8kg商品产地：中国大陆观看距离：3-3.5米分辨率：超高清电视类型：4K超清电视，HDR，智能电视能效等级：三级能效屏幕尺寸：55英寸选购指数：10.0-8.0");
        mCommodityBean2.setCommodityName("索尼（SONY）KD-55X7000D 55英寸高清4K HDR 安卓6.0系统 智能液晶电视");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5572/58/2168295547/273143/c0895acf/592e9b89N008ee685.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5350/266/1637809699/126942/fa6eda18/5912cf17Nb3724304.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5218/256/1602614676/30269/cb183d23/5912cf1fNe6bf92af.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6703/92/129699860/28485/976c525c/593a0415Na38f4ae6.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize("40,44,50,60");
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：TCL55A950C商品编号：4749506商品毛重：19.0kg商品产地：中国大陆观看距离：3-3.5米分辨率：超高清电视类型：曲面电视，超薄电视，4K超清电视，HDR，智能电视，互联网电视，人工智能电视能效等级：三级能效屏幕尺寸：55英寸选购指数：10.0-8.0");
        mCommodityBean3.setCommodityName("TCL 55A950C 55英寸32核人工智能 HDR曲面超薄4K电视金属机身");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t4777/342/2121337615/205478/e69dd6c7/58f9baabN3786d2d5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5029/199/1060814970/53562/d97b72e6/58ec4ef4N67d369ff.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4624/343/2164023135/285934/48ff51b6/58ec4eedN4085776a.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4393/365/2940717475/423401/a82c0773/58f43a2eN90a244f6.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize("40,44,50,60");
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：飞利浦39PHF5092/T3商品编号：4839950商品毛重：7.5kg商品产地：中国大陆观看距离：2-2.5米分辨率：高清电视类型：智能电视，互联网电视能效等级：二级能效屏幕尺寸：39-40英寸选购指数：7.9-7.0");
        mCommodityBean4.setCommodityName("飞利浦（PHILIPS）39PHF5092/T3 39英寸 二级能效 丰富内容 海量应用 WIFI智能高清液晶电视机");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t4558/211/292368936/57822/8199cce/58cd062eNc16dfcb1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4366/207/2194088432/26996/7451938f/58cd062eN2fd599c8.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t3115/138/9013225235/27817/2b1a92e5/58cd062eN8d9975c3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4597/207/306374453/24049/b82e3639/58cd062eNb84ef042.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize("1匹,1.5匹,2匹");
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：格力KFR-50LW/50555FNhAd-A3（WIFI）商品编号：2942446商品毛重：64.5kg商品产地：中国大陆变频/定频：变频冷暖类型：冷暖空调产品特色：圆柱式空调，智能空调内机颜色：其他商品匹数：2匹能效等级：三级能效使用面积：20-30㎡空调类别：立柜式空调");
        mCommodityBean5.setCommodityName("格力（GREE）2匹 变频 静享 微联智能 冷暖圆柱柜机空调 ");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3265/243/8996491801/49181/84ea1da6/58ccfffcNd70c9a03.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4351/244/2222757513/22081/7d378d45/58ccfffcNa8c4fa25.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3259/42/9086692629/20608/5b9cfe28/58ccfffdNa7a41f14.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4480/130/291355225/19852/cc6e6f64/58ccfffcNd3167448.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize("1匹,1.5匹,2匹");
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：格力KFR-35GW/35592FNhDa-A3商品编号：1993092商品毛重：13.5kg商品产地：中国大陆变频/定频：变频冷暖类型：冷暖空调产品特色：变频空调，静音空调内机颜色：白色商品匹数：1.5匹能效等级：三级能效使用面积：15-20㎡空调类别：壁挂式空调");
        mCommodityBean6.setCommodityName("格力（GREE）正1.5匹 变频 品圆 冷暖 壁挂式空调 ");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6427/57/638085379/70059/4db79802/5943304dNeb81efcf.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3424/249/896271947/92259/81983393/5819773cN5541430c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3469/232/977004243/46687/aa7d552b/5819772bN7e7af752.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3895/214/1398339286/112412/d598e289/58758237N311805ea.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize("1匹,1.5匹,2匹");
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：奥克斯KFR-35GW/HFJ+3商品编号：1311928商品毛重：13.5kg商品产地：中国大陆变频/定频：定频冷暖类型：冷暖空调产品特色：自动清洁内机颜色：白色有花纹商品匹数：1.5匹能效等级：三级能效使用面积：15-20㎡空调类别：壁挂式空调");
        mCommodityBean7.setCommodityName("奥克斯（AUX）正1.5匹 冷暖 定速 空调挂机");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3037/347/1290968859/201366/7c1028a0/57c00194N9d0a54c6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3289/268/835093317/232098/5117db2f/57c001a5N37ef69e7.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3070/217/849280018/268625/b426ab80/57c001afNd9d06e57.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3211/75/849021803/300860/935f264f/57c001baN930529aa.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize("7公斤,10公斤,15公斤");
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：海尔EG8014HB39GU1商品编号：3130047商品毛重：79.0kg商品产地：中国大陆产品类型：洗烘一体洗涤容量：8kg能效等级：1 级颜色：金色深度：50.1-55cm宽度：55.1-60cm电机类型：变频（节能）高度：80.1-85cm排水类型：上排水特色推荐：筒自洁，智能APP，除菌，空气洗，快净洗，羊毛洗，羽绒洗，中途添衣\n");
        mCommodityBean8.setCommodityName("海尔（Haier) EG8014HB39GU1 8公斤变频洗烘一体滚筒洗衣机 蒸汽熨防皱烘干");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3934/269/1652008740/149190/4e5334b0/58842c79N7fb6d04e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4006/251/1663378501/150242/96f5159e/58842c8cNf121e44e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3127/164/5788770882/185384/7b340867/58842c81N3a294d0f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3949/284/1608550783/147095/bf1d10bb/58842c8dN338deb28.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize("7公斤,10公斤,15公斤");
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：美的MG70V30WDX商品编号：4361548商品毛重：66.0kg商品产地：中国大陆特色推荐：筒自洁，智能APP，除菌，羊毛洗深度：50cm及以下电机类型：变频（节能）洗涤容量：7kg能效等级：1 级排水类型：下排水产品类型：滚筒");
        mCommodityBean9.setCommodityName("美的（Midea）MG70V30WDX 7公斤智能变频滚筒洗衣机 时尚薄荷蓝门圈 除菌洗");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("家用电器"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t6037/259/2270009863/266600/7f322779/593e1fdaN28207ecb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6619/232/352187358/230691/24ea388/593e1fe9N94720078.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5656/237/3527603963/271809/a262e8d9/593e1fe9Ncbb67634.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5773/298/3510869061/160144/e8177a4d/593e1fe9N133837a8.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize("7公斤,10公斤,15公斤");
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：小天鹅TG80V60WDS商品编号：4344555商品毛重：76.0kg商品产地：中国大陆产品类型：滚筒洗涤容量：8kg能效等级：1 级颜色：银色深度：55.1-60cm宽度：55.1-60cm电机类型：变频（节能）高度：80.1-85cm排水类型：上排水特色推荐：筒自洁，智能APP，除菌");
        mCommodityBean10.setCommodityName("小天鹅（LittleSwan）TG80V60WDS 8公斤变频滚筒洗衣机（银色） wifi智能控制 LED显示屏 低噪音");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //电脑办公
    private static void addCommodity9() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t8830/106/1760940277/195595/5cf9412f/59bf2ef5N5ab7dc16.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4636/338/4612161128/181673/4838f0e1/591128f1Ndcd71fcb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4435/282/4563260745/360368/2c6c9fe8/591128f8Nd01fc6b3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4426/264/4613848204/82994/670a8c8/59112903N6ece208a.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("i3,i5,i7");
        mCommodityBean0.setCommodityDescribe("商品名称：联想拯救者R720商品编号：5025518商品毛重：4.13kg商品产地：中国大陆货号：80WW000FCD系统：Windows 10分辨率：全高清屏（1920×1080）厚度：20.0mm以上内存容量：8G显卡型号：GTX1050Ti游戏性能：发烧级待机时长：小于5小时处理器：Intel i5标准电压版特性：背光键盘显卡类别：高性能游戏独立显卡裸机重量：2-2.5kg硬盘容量：128G+1T分类：游戏本显存容量：4G屏幕尺寸：15.6英寸");
        mCommodityBean0.setCommodityName("联想(Lenovo)拯救者R720 15.6英寸游戏笔记本电脑");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t5905/289/585998020/255187/9e609cb8/59296840N5acd6fee.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5926/172/581660894/212752/6591bb5a/59296a18Naddf2688.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t5743/107/1767497516/52237/87aa9566/59296a35Nd161bbef.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5593/133/1759826092/264520/cfbf6306/59296a43N7e27eda3.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("i3,i5,i7");
        mCommodityBean1.setCommodityDescribe("商品名称：惠普暗影精灵III代商品编号：4274549商品毛重：3.96kg商品产地：中国大陆货号：2EF97PA系统：Windows 10厚度：20.0mm以上内存容量：8G分辨率：全高清屏（1920×1080）游戏性能：发烧级待机时长：9小时以上处理器：Intel i5标准电压版特性：背光键盘，其他显卡型号：GTX1050Ti裸机重量：大于2.5KG显卡类别：高性能游戏独立显卡显存容量：4G硬盘容量：128G+1T屏幕尺寸：15.6英寸");
        mCommodityBean1.setCommodityName("惠普（HP）暗影精灵III代 15.6英寸游戏笔记本电脑");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6010/228/97914964/141157/bd978e2a/5925afebNdf030dfb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5770/189/1371821305/111217/ffe029ae/5925afe8N881fc991.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6073/264/96562020/233222/d93a79bf/5925affaN70ebfb8f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5722/302/1320592383/80291/40df9b75/59256256Nf34e4824.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize("商品名称：戴尔灵越5675-R1GN8L商品编号：4088579商品毛重：14.6kg商品产地：中国大陆处理器：AMD内存容量：8G电脑用途：游戏为主硬盘容量：固态+机械显卡：GTX1060 3G/6G系统：Windows 10电脑形态：单主机");
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("i3,i5,i7");
        mCommodityBean2.setCommodityName("戴尔(DELL)灵越MAX·战5675-R1GN8L高性能游戏台式电脑主机");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6700/155/2098998076/156185/6cf95035/595dd5a5Nc3a7dab5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6745/31/148790854/81507/3d5db767/593a6402N25fdf18e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5785/100/3265431036/91615/54c85876/593a6407N94f0aeca.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5746/87/3375701106/86079/d964463d/593a6449Ncec7e514.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize("i3,i5,i7");
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：小米Air商品编号：4338107商品毛重：2.45kg商品产地：中国大陆系统：Windows 10厚度：10.0mm—15.0mm内存容量：8G分辨率：全高清屏（1920×1080）显卡型号：MX150待机时长：9小时以上处理器：Intel i5低功耗版特性：窄边框，背光键盘显卡类别：入门级游戏独立显卡裸机重量：1-1.5KG硬盘容量：256G固态显存容量：2G分类：轻薄本屏幕尺寸：13.3英寸");
        mCommodityBean3.setCommodityName("小米(MI)Air 13.3英寸全金属轻薄笔记本");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8995/210/1735780760/217499/bbba7b67/59c7d812Ne2ed104f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5890/89/9240605681/128419/ff0023b9/598434caNa009fe49.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5890/89/9240605681/128419/ff0023b9/598434caNa009fe49.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7060/201/1707043303/265328/e89017c8/598434cbN3b1f894e.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize("i3,i5,i7");
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("");
        mCommodityBean4.setCommodityName(" AK童装轻复古MA-1飞行夹克棒球领外套1704502");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5935/195/2108753717/176060/c849dcb6/593a49a3Nf9c2a052.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6577/32/146245829/54834/6c530ea5/593a49a3Nc4a97321.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5935/195/2108753717/176060/c849dcb6/593a49a3Nf9c2a052.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6577/32/146245829/54834/6c530ea5/593a49a3Nc4a97321.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize("i3,i5,i7");
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：AppleMQD32CH/A商品编号：5225346商品毛重：2.96kg商品产地：中国大陆系统：MAC厚度：10.0mm—15.0mm内存容量：其他分辨率：其他显卡型号：其他待机时长：9小时以上处理器：Intel 其他特性：背光键盘，其他显卡类别：集成显卡裸机重量：1-1.5KG硬盘容量：128G固态显存容量：其他分类：轻薄本，常规笔记本屏幕尺寸：13.3英寸");
        mCommodityBean5.setCommodityName("Apple MacBook Air 13.3英寸笔记本电脑 银色");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9070/70/2054938781/293914/226aa608/59c31f32Nce4c3861.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3397/249/989172622/143865/d4b4496d/5819a0ebNefd901bc.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3583/317/980681084/203783/c2af1196/5819a10bN2ea5c8e0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3679/73/932213322/257867/5f132611/5819a133N03021b26.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize("i3,i5,i7");
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：ThinkPadE470 c商品编号：3597549商品毛重：2.8kg商品产地：中国大陆系统：Windows 10厚度：20.0mm以上内存容量：8G分辨率：标准屏（1366×768）显卡型号：GT920M待机时长：5-7小时处理器：Intel i5低功耗版特性：其他显卡类别：入门级游戏独立显卡裸机重量：1.5-2kg硬盘容量：500G显存容量：2G分类：常规笔记本屏幕尺寸：14.0英寸");
        mCommodityBean6.setCommodityName("联想（ThinkPad） E470c（20H3A004CD）14英寸笔记本电脑");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t6379/334/1932354873/477834/bc55c1ff/595b5ccfN30e2e96f.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t6379/334/1932354873/477834/bc55c1ff/595b5ccfN30e2e96f.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t6187/101/1917564771/266155/d5b9be44/595b0a78N8ecd12dd.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t4108/197/953458196/317689/49d8e3e9/58637ee0N92538bf9.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize("i3,i5,i7");
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：华硕FX53VD商品编号：4257972商品毛重：4.25kg商品产地：中国大陆系统：Windows 10厚度：20.0mm以上内存容量：8G分辨率：全高清屏（1920×1080）游戏性能：发烧级待机时长：小于5小时处理器：Intel i7标准电压版特性：背光键盘显卡型号：GTX1050裸机重量：大于2.5KG显卡类别：高性能游戏独立显卡显存容量：4G硬盘容量：128G+1T屏幕尺寸：15.6英寸");
        mCommodityBean7.setCommodityName("华硕(ASUS) 飞行堡垒尊享版二代FX53VD 15.6英寸游戏笔记本电脑");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5935/195/2108753717/176060/c849dcb6/593a49a3Nf9c2a052.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6577/32/146245829/54834/6c530ea5/593a49a3Nc4a97321.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5935/195/2108753717/176060/c849dcb6/593a49a3Nf9c2a052.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6577/32/146245829/54834/6c530ea5/593a49a3Nc4a97321.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize("i3,i5,i7");
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：AppleMQD42CH/A商品编号：4335139商品毛重：2.98kg商品产地：中国大陆系统：MAC厚度：10.0mm—15.0mm内存容量：8G分辨率：其他显卡型号：其他待机时长：9小时以上处理器：Intel 其他特性：背光键盘显卡类别：集成显卡裸机重量：1-1.5KG硬盘容量：256G固态显存容量：其他分类：轻薄本，常规笔记本屏幕尺寸：13.3英寸");
        mCommodityBean8.setCommodityName("Apple MacBook Air 13.3英寸笔记本电脑 银色");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8632/364/1383752066/328035/f28639e2/59b8c020Ncc73d049.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7561/5/1439458416/220385/40f8c0eb/599d1071Nec9c2646.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7705/107/1450048706/260396/f6373fe1/599d1071N2288b088.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7486/107/1460907183/80124/4635c0ed/599d10d7Nf7e5514e.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize("i3,i5,i7");
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：联想轻薄商务笔记本电脑 Ideapad320-15 15英寸 A6-9220 超薄超极本商品编号：1647112203店铺： 联想华北授权专卖店商品毛重：1.8kg商品产地：中国大陆系统：Windows 8分辨率：标准屏（1366×768）厚度：10.0mm—15.0mm内存容量：8G显卡型号：AMD R5游戏性能：骨灰级待机时长：小于5小时处理器：AMD系列特性：其他显卡类别：高性能游戏独立显卡裸机重量：1.5-2kg硬盘容量：1T分类：轻薄本，常规笔记本显存容量：2G屏幕尺寸：15.6英寸");
        mCommodityBean9.setCommodityName("联想轻薄商务笔记本电脑 Ideapad320-15 15英寸 A6-9220 超薄超极本");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("电脑办公"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6625/343/1891525089/189224/2a0e07a1/5959d9f0N1702810a.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5734/249/5105355915/125845/5e08b668/5959d9f4N6bc85c45.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6730/342/1904616571/105378/7d6c382f/5959d9faNb0a9ade5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3814/126/1798836627/88829/77a555cd/583eb75dN851d39a3.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize("i3,i5,i7");
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：戴尔燃7000商品编号：4145246商品毛重：2.45kg商品产地：中国大陆系统：Windows 10分辨率：全高清屏（1920×1080）厚度：15.1mm—20.0mm内存容量：8G显卡型号：其他游戏性能：入门级待机时长：9小时以上处理器：Intel i5低功耗版特性：窄边框，背光键盘显卡类别：集成显卡裸机重量：1.5-2kg硬盘容量：256G固态分类：轻薄本，常规笔记本显存容量：其他屏幕尺寸：14.0英寸");
        mCommodityBean10.setCommodityName("戴尔DELL灵越燃7000 R1605G 14.0英寸轻薄窄边框笔记本电脑");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //手机数码
    private static void addCommodity8() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6772/233/657797415/68024/a71b8ebe/5978869eN9dae2c37.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5773/231/8242002528/28341/c375c68e/597886a6N0cacddb8.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5725/179/8283455548/26476/482f7e72/597886a2N5256898d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6883/92/694783906/14872/61d2b534/597886b8Nc04d2e8d.jpg");
        mCommodityBean0.setCommodityPrice(5329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("黑色,银色,红色");
        mCommodityBean0.setCommodityDescribe("商品名称：魅族魅族 PRO 7商品编号：4595061商品毛重：0.52kg商品产地：中国大陆系统：安卓（Android）购买方式：其他电池容量：3000mAh-3999mAh机身颜色：黑色热点：双卡双待，快速充电，指纹识别，Type-C，金属机身，后置双摄像头运行内存：4GB前置摄像头像素：1600万及以上后置摄像头像素：后置双摄像头，1200万-1999万机身内存：128GB");
        mCommodityBean0.setCommodityName("魅族 PRO 7 4GB+128GB ");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3637/275/652996370/280419/2a134044/58105e15N75fb0595.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3364/209/682238813/177412/e0a59882/58105e1cNfab816f2.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3766/68/687577971/180767/1d7762f3/58105e3bN2c1c857e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3697/87/647818434/172938/25a798fe/58105e19N58917f62.jpg");
        mCommodityBean1.setCommodityPrice(5399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("黑色,银色,红色");
        mCommodityBean1.setCommodityDescribe("商品名称：华为畅享6商品编号：3888216商品毛重：145.00g商品产地：中国大陆系统：安卓（Android）运行内存：3GB前置摄像头像素：500万-799万热点：双卡双待，指纹识别，拍照神器后置摄像头像素：1200万-1999万电池容量：4000mAh-5999mAh机身内存：16GB机身颜色：金色");
        mCommodityBean1.setCommodityName("华为 畅享6 金色 移动联通电信4G手机");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8296/51/1989672773/269004/d3a5b0b2/59c231aaNa05cd278.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9310/335/1997624505/131520/71a37b8b/59c231b7N171e1efd.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9262/12/1979348872/24113/39aac5f4/59c231b7N0b3c1caa.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9343/258/1966860916/31786/6489a699/59c231b8N5fd45abe.jpg");
        mCommodityBean2.setCommodityPrice(5299.00);
        mCommodityBean2.setCommoditySize("黑色,银色,红色");
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：三星Galaxy C8商品编号：5142365商品毛重：390.00g商品产地：中国大陆系统：安卓（Android）购买方式：其他电池容量：3000mAh-3999mAh机身颜色：黑色热点：双卡双待，指纹识别运行内存：3GB前置摄像头像素：1600万及以上后置摄像头像素：1200万-1999万机身内存：32GB");
        mCommodityBean2.setCommodityName("三星 Galaxy C8（SM-C7100）3GB+32GB 墨玉黑");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t7951/357/3030577771/71102/9c84b3c1/59b857f5N754efdeb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7612/119/2996638834/57065/2976873b/59b857f5N4a2a7dbf.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8611/12/1363603214/18886/bc9acd1a/59b857e2N0aa211a1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7597/8/2938908232/32134/24961e3a/59b857e5N08d357e6.jpg");
        mCommodityBean3.setCommodityPrice(5299.00);
        mCommodityBean3.setCommoditySize("黑色,银色,红色");
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：AppleiPhone 8商品编号：5180901商品毛重：400.00g商品产地：中国大陆系统：苹果（IOS）");
        mCommodityBean3.setCommodityName("Apple iPhone 8 (A1863) 256GB 金色");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8290/49/2122027131/131771/c54bd4aa/59c483deNa0c5443e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t10729/119/48685121/65319/1f1229ca/59c483e8N6838568e.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t9298/122/2097317618/58103/c5a8395/59c483f1N201f06e3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8164/121/2123934600/102932/c4544a6b/59c483e3N92569f72.jpg");
        mCommodityBean4.setCommodityPrice(5599.00);
        mCommodityBean4.setCommoditySize("黑色,银色,红色");
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：OPPOR11商品编号：5157847商品毛重：0.695kg商品产地：中国大陆系统：安卓（Android）购买方式：其他电池容量：3000mAh-3999mAh机身颜色：红色热点：骁龙芯片，双卡双待，快速充电，指纹识别，金属机身，拍照神器，女性手机，游戏手机，商务手机，后置双摄像头运行内存：6GB前置摄像头像素：1600万及以上后置摄像头像素：后置双摄像头，2000万及以上，1200万-1999万机身内存：128GB");
        mCommodityBean4.setCommodityName("OPPO R11王者荣耀周年庆限量版 热力红色 全网通6G+128G 双卡双待手机");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t5758/80/322736426/308217/1cd4b8df/591e99d6N7c1647a9.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5662/284/306435204/50042/16d20896/591e99daNe4a92ff3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5818/318/327021557/69462/b02462a1/591e99dbNfb1f8ed4.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5845/5/302146876/186680/a216c109/591e99d9N9fb78642.jpg");
        mCommodityBean5.setCommodityPrice(5199.00);
        mCommodityBean5.setCommoditySize("黑色,银色,红色");
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：HTCU11商品编号：4230493商品毛重：480.00g商品产地：中国大陆系统：安卓（Android）购买方式：其他电池容量：3000mAh-3999mAh机身颜色：银色热点：骁龙芯片，双卡双待，快速充电，指纹识别，Type-C，VoLTE，2K屏，拍照神器，支持NFC运行内存：4GB前置摄像头像素：1600万及以上后置摄像头像素：1200万-1999万机身内存：64GB");
        mCommodityBean5.setCommodityName("HTC U11 皎月银 4GB+64GB 移动联通电信全网通 双卡双待");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2971/15/167732091/93002/204c1016/574d9d9aNe4e6fa7a.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2920/171/144222170/131350/c1c96d47/574d9da2N21d6be00.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2920/186/160834924/168036/4d4c09f2/574d9dadN1edbbf57.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2854/180/1901228929/247331/b4295f95/574d9db1N905b85d6.jpg");
        mCommodityBean6.setCommodityPrice(5369.00);
        mCommodityBean6.setCommoditySize("黑色,银色,红色");
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：小米手环2商品编号：2857483商品毛重：95.00g商品产地：中国大陆腕带材质：塑胶兼容性：Android防水：生活防水");
        mCommodityBean6.setCommodityName("小米（MI）小米手环2 智能运动");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6655/218/369012870/166198/6b4e20ba/593e3ab9Nfe640f0b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6418/208/379066524/106977/87b4acc/593e3ac3N27dd2130.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5821/103/3557829351/190917/fac8e2a5/593e3acbN0bf5ea23.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6025/139/2268802260/202629/5402fab9/593e4cb3N8466207b.jpg");
        mCommodityBean7.setCommodityPrice(5299.00);
        mCommodityBean7.setCommoditySize("黑色,银色,红色");
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：华为荣耀手环商品编号：4255683商品毛重：80.00g商品产地：中国大陆腕带材质：塑胶运动识别：跑步，游泳防水：50米及以上兼容性：其他待机时间：30天屏幕类型：带屏幕");
        mCommodityBean7.setCommodityName("荣耀手环3 碳晶黑 标准版");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t4753/139/2433188483/98570/215c60ea/58ff0c52Na6380717.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5032/120/2408835489/77277/2c97886e/58ff0c52N5ab1c23c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4924/207/2408006313/66508/a109ea40/58ff0c53N47d1c94c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5287/202/408681038/89374/e76151b5/58ff0c53Na8bb9adf.jpg");
        mCommodityBean8.setCommodityPrice(5238.00);
        mCommodityBean8.setCommoditySize("黑色,银色,红色");
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：索尼RX100 M3商品编号：1148061商品毛重：0.52kg商品产地：中国无锡颜色：黑色");
        mCommodityBean8.setCommodityName("索尼（SONY） DSC-RX100 M3 黑卡数码相机");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n1/s546x546_jfs/t1750/268/1445235274/147099/1213f869/55ebf2eeN12826552.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t1792/187/1399303424/121677/47e09ea6/55ebf2efNf93faf6e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2266/158/69771403/92766/129b84b4/55ebf2efN1bc03e10.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2452/229/66100024/88138/8a7da502/55ebf2efNe4a9480d.jpg");
        mCommodityBean9.setCommodityPrice(5148.00);
        mCommodityBean9.setCommoditySize("黑色,银色,红色");
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：理光GR II商品编号：1871645商品毛重：0.65kg商品产地：中国大陆像素：0-2000万特点：大底卡片，经典复古颜色：黑色");
        mCommodityBean9.setCommodityName("理光（Ricoh）GR II WIFI NFC 手机控制 超凡画质，忠实再现");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("手机数码"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2827/364/665315281/97230/2a1a2ab3/57218758Nc74212b3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2848/259/703437295/94625/a3c513de/57218760N42371072.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2848/259/703437295/94625/a3c513de/57218760N42371072.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2638/270/729491278/88516/4971e597/57218763N529176c7.jpg");
        mCommodityBean10.setCommodityPrice(2199.00);
        mCommodityBean10.setCommoditySize("黑色,银色,红色");
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：索尼RX10 III商品编号：2744203商品毛重：1.61kg商品产地：中国大陆颜色：黑色");
        mCommodityBean10.setCommodityName("索尼（SONY） DSC-RX10 III 超长焦黑卡数码相机等效");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //钟表珠宝
    private static void addCommodity7() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6013/54/5705920346/172867/fe58e01e/596dc6caNfd363dc7.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5635/342/6983981006/129083/ea1b6607/596dc6cbNda795616.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5965/41/5841409227/289075/7957f1f1/596dc6ccNb11efd58.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5821/218/6945174291/323974/f3b59f38/596dc6ccN280c588c.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean0.setCommodityDescribe("商品名称：卡西欧简约指针男表商品编号：2907690商品毛重：160.00g商品产地：中国/泰国/日本等人群：男士风格：时尚，极简防水：50米表盘：圆形表扣：折叠扣表径：41-43mm表壳：其它表底：不透底功能：其它机芯：石英表带：其它");
        mCommodityBean0.setCommodityName("卡西欧(CASIO)手表 指针系列 简约三针石英男表");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6019/78/5687134800/171807/6af59267/596daffdN90f81dba.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5734/236/5374370255/91939/5346a03e/595da491Ne2189f5e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5971/192/4115597402/105892/56b6d971/595da491Nfb3c5608.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6751/67/2087089821/176922/cc296b8/595da492N8961ae31.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean1.setCommodityDescribe("商品名称：卡西欧石英男表商品编号：195632商品毛重：130.00g商品产地：日本/泰国/中国等人群：男士风格：商务，休闲，时尚防水：50米表盘：圆形表壳：其它机芯：石英功能：日期显示，星期显示，其它表底：不透底表带：其它");
        mCommodityBean1.setCommodityName("卡西欧(CASIO)手表 ANALOGUE系列石英男表");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6874/251/1998612099/87639/171f1496/59880afcN4876134d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6919/103/2020153646/34865/bcbdabc5/59880afcN82a23100.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6085/49/8287077213/80923/f252dc57/59880afcN60591b18.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5668/45/9439421140/95256/84145203/59880afdNb4a4889f.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：卡西欧手表商品编号：3510669商品毛重：90.00g商品产地：中国/泰国/日本等货号：LTH-1060GL-1APF人群：女士风格：休闲，时尚，极简防水：30米功能：日期显示机芯：石英表带：其它");
        mCommodityBean2.setCommodityName("卡西欧（CASIO）手表 Analogue大众指针系列简约女表");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t4348/151/1480098748/177193/12b6d79d/58c27c63N40bd0adc.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4255/144/1500222847/152520/b9f940db/58c27c64Nfcf3d74d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4345/146/1494556837/111071/e4ea1978/58c27c63Nb0a55f4b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4252/99/1512076066/49332/6b28ceef/58c27c63Nb712aceb.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：欧米茄机械男表商品编号：4606356商品毛重：2.38kg商品产地：瑞士风格：商务，休闲防水：30米");
        mCommodityBean3.setCommodityName("欧米茄(OMEGA)手表 碟飞系列机械男表");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8995/210/1735780760/217499/bbba7b67/59c7d812Ne2ed104f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5890/89/9240605681/128419/ff0023b9/598434caNa009fe49.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5890/89/9240605681/128419/ff0023b9/598434caNa009fe49.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7060/201/1707043303/265328/e89017c8/598434cbN3b1f894e.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("");
        mCommodityBean4.setCommodityName(" AK童装轻复古MA-1飞行夹克棒球领外套1704502");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5008/285/2423752646/237182/a8eb5aba/58ff0a4dNb887d623.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5008/285/2423752646/237182/a8eb5aba/58ff0a4dNb887d623.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4537/189/3557093996/267583/95cd0e6b/58ff0a68N4249ae8a.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5257/221/401348672/262957/32270f21/58ff0a69N8462274b.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：欧米茄机械女表商品编号：4606346商品毛重：1.52kg商品产地：瑞士防水：30米功能：日期显示风格：时尚人群：女士");
        mCommodityBean5.setCommodityName("欧米茄(OMEGA)手表 碟飞系列机械女表");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/g15/M08/0A/15/rBEhWlMYI0IIAAAAAAHA7EULTJEAAJirwLBrHEAAcEE539.jpg," +
                "https://img14.360buyimg.com/n0/g15/M08/0A/15/rBEhWFMYI0MIAAAAAAGacpIhrOYAAJirwMkuFMAAZqK627.jpg," +
                "https://img14.360buyimg.com/n0/g15/M08/0A/15/rBEhWFMYI0UIAAAAAAG9vsFMlqUAAJirwOV-bEAAb3W198.jpg," +
                "https://img14.360buyimg.com/n0/g15/M08/0A/15/rBEhWFMYI0QIAAAAAAFMVndvmjIAAJirwNrJuEAAUxu455.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：欧米茄机械男表商品编号：976123商品毛重：1.02kg商品产地：瑞士人群：男士风格：商务功能：日期显示防水：300米表盘：圆形表扣：折叠扣表带：不锈钢");
        mCommodityBean6.setCommodityName("欧米茄(OMEGA)手表 海马系列机械男表");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t730/44/39517649/83758/18bbf946/54800d57N805d80b6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t625/117/722315137/57775/b6a58d12/54800d58N24cd22a2.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t745/46/55710302/152256/ff0a9bf/54800d5aNf0dacf27.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t691/15/716040200/74173/4ea51d1d/54800d59N69f21c26.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：欧米茄时尚女表商品编号：858267商品毛重：1.35kg商品产地：瑞士人群：女士功能：其它表带：其它表扣：蝴蝶扣防水：100米表盘：圆形机芯：石英风格：时尚");
        mCommodityBean7.setCommodityName("欧米茄(OMEGA)手表 星座系列时尚女表");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2743/15/448183399/250375/5a592c9b/57147511N075e1943.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2098/61/2699960386/207327/c160a999/5714751bN8742ee09.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2251/271/2670030989/401605/eae892e3/57147522Nb224b3c0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2434/22/2703310221/122125/eeeef886/5714751eN9326822f.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：欧米茄机械男表商品编号：2575784商品毛重：2.53kg商品产地：瑞士人群：男士表带：其它防水：100米表盘：圆形表径：36-40mm表壳：钢功能：其它机芯：自动机械风格：其它");
        mCommodityBean8.setCommodityName("欧米茄(OMEGA)手表 尊霸系列机械男表");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8755/150/1216147926/148391/639798ff/59b67534N9fc2ba61.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8113/206/1253924872/198456/34216483/59b67522Nb72c88d0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9283/250/1221613154/330561/a814948e/59b67532N81d408e0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9364/217/1233882104/186935/1c72a994/59b67529N28e92af6.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：唯路时石英男士手表商品编号：3625122商品毛重：230.00g商品产地：广东深圳人群：男士风格：商务，休闲，时尚防水：30米表盘：圆形表扣：其它表径：36-40mm表壳：不锈钢表底：不透底功能：日期显示机芯：石英表带：牛皮");
        mCommodityBean9.setCommodityName("唯路时(JONAS&VERUS)手表 简尚 石英象牙白盘皮带男表");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("钟表珠宝"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5797/185/3901179062/159833/b41a460f/5966d0c0N650608a5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6373/181/2477574399/195874/d27a88e9/5962d601N04c23573.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5944/318/4450692997/298021/1acda2d7/5962d607Na370b56e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6049/75/4343594029/179532/cae30e96/5962d605N87fdf7d5.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize("钢带黑盘,钢带白盘,皮带白盘,皮带黑盘");
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：丹尼尔惠灵顿石英女表商品编号：2368948商品毛重：240.00g商品产地：广东深圳风格：休闲，运动，时尚，极简表底：不透底防水：30米表盘：圆形机芯：石英表带：其它");
        mCommodityBean10.setCommodityName("丹尼尔惠灵顿（DanielWellington）手表");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //美妆个护
    private static void addCommodity6() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2257/235/407319201/136906/c0d5a66e/5609e23bNd7c14b82.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t2425/163/445280485/217488/9fd3655/5609e1dbN16104af1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2131/244/434307328/233906/df7e9dd/5609e1daN39414047.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2257/235/407319201/136906/c0d5a66e/5609e23bNd7c14b82.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize(null);
        mCommodityBean0.setCommodityDescribe("商品名称：倍加洁（PEROACT）薄荷香型牙膏120g商品编号：1186814872店铺： 倍加洁官方旗舰店商品毛重：100.00g货号：T101分类：其它适用人群：普通人群刷毛分类：其它");
        mCommodityBean0.setCommodityName("倍加洁（PEROACT）薄荷香型牙膏120g");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6496/204/2253869984/230603/a993970c/595f01aaNa6525e6e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5761/18/5391927478/122636/5eb9b811/595f01b2Na77ce3db.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5740/285/5454380823/110118/6e552f9e/595f01b8N104c5de1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5944/235/4202035493/161147/d599e4d7/595f01b5N936f2129.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize(null);
        mCommodityBean1.setCommodityDescribe("商品名称：雪肌精洁肤油商品编号：4447923商品毛重：360.00g商品产地：日本适合肤质：混合性适用部位：脸部分类：卸妆油");
        mCommodityBean1.setCommodityName("雪肌精 SEKKISEI 柔护洁肤油");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3190/53/5978735671/501547/ddfbc1b3/58993b87Neace4f4f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3982/22/1828768990/254641/363f9ec1/58993b92N6eae9d1e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3277/95/5972785547/229316/de986387/58993b8dN17a453d3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3190/53/5978735671/501547/ddfbc1b3/58993b87Neace4f4f.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize(null);
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：雪肌精BB霜商品编号：4380034商品毛重：50.00g商品产地：日本适合肤质：混合性分类：BB霜/CC霜功效：提亮肤色，隔离，美白，防晒颜色：其它");
        mCommodityBean2.setCommodityName("雪肌精 SEKKISEI BB霜（水润型）");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3853/233/2407013702/176391/e68e736b/58abdd77Nc0e4dc8d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3967/298/2557339741/116236/cdfde307/58abdd82Ne34aa11b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3079/131/6683348174/110079/cb9e0457/58abdd85N6ef77c96.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3943/277/2576116663/131579/336114b2/58abdd7dNbf398b67.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize(null);
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：千纤草保湿套装商品编号：4449664商品毛重：1.3kg商品产地：扬州适合肤质：所有肤质功效：补水，保湿，深层清洁性别：通用分类：组合装产品产地：中国大陆");
        mCommodityBean3.setCommodityName("千纤草 深层清洁保湿套装");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3484/74/1899741666/154298/7edf0cc1/58366e0cN77f8d2c0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3460/63/1967542126/80417/3fad803b/58366e28N8c73e910.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3604/215/1901588994/105278/c3921961/58366e22Nc0c01dd5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3358/197/1802259330/103156/7ef5b535/58366e2fN9b526a53.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize(null);
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：千纤草护肤套装商品编号：4116286商品毛重：0.6kg商品产地：扬州适合肤质：所有肤质功效：细致毛孔，其它性别：通用分类：组合装产品产地：中国大陆");
        mCommodityBean4.setCommodityName("千纤草补水护肤套装");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5677/122/1421491210/137228/8ec4d495/59268967N68c21000.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5623/162/1460401848/134669/d23a8e00/59268968Nd7f39d9d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5884/350/1466515095/162620/e8594e1a/59268968N0d008952.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6034/31/199002677/89316/fcd5191f/59268967N1ebc28eb.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize(null);
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：千纤草洁面套装商品编号：5069718商品毛重：300.00g商品产地：扬州适合肤质：所有肤质功效：保湿，深层清洁性别：通用分类：组合装产品产地：中国大陆");
        mCommodityBean5.setCommodityName("千纤草氨基酸温和清洁2件套");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5677/122/1421491210/137228/8ec4d495/59268967N68c21000.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5623/162/1460401848/134669/d23a8e00/59268968Nd7f39d9d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5884/350/1466515095/162620/e8594e1a/59268968N0d008952.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6034/31/199002677/89316/fcd5191f/59268967N1ebc28eb.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize(null);
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：YSL圣罗兰香水女士淡香精/淡香水 YSL巴黎情窦淡香水 50ml商品编号：1992622570店铺： 当然购美妆商品毛重：150.00g商品产地：法国包装：礼品套装香调：花果香调净含量：其它分类：淡香水EDT性别：女适用场景：日常，约会，party聚会");
        mCommodityBean6.setCommodityName("YSL圣罗兰香水女士淡香精/淡香水 YSL巴黎情窦淡香水");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6019/1/7515331340/431109/69ce8758/597ffa07Ndfdf0f0f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5629/350/2585909293/365783/fcc9fe0b/59322f73Nd8955552.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5713/295/2590960110/273548/73ecec05/59322fcbN59974072.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5962/79/1435027321/325197/6f1c3c6d/59322f74Nf316d205.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize(null);
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：阿迪达斯沐浴露男士洗发沐浴洗护二合一组合装250ml*3瓶（10种组合任选） 按摩舒爽+运动舒缓+清风男士商品编号：12898693676店铺： 阿迪达斯专营店商品毛重：0.7kg功效：滋养，爽肤香型：清香型净含量：500ml-750ml性别：男适用人群：成人分类：沐浴乳/露");
        mCommodityBean7.setCommodityName("阿迪达斯沐浴露男士洗发沐浴洗护二合一组合装");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5719/93/357984297/209304/dc3de051/591edbb9N60c846c0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5851/81/357710798/188553/c6c3f9a9/591edbc8N4f1c94c6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5851/81/357710798/188553/c6c3f9a9/591edbc8N4f1c94c6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5830/3/355918297/282929/7b8a7736/591edbcdN2a6b647e.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize(null);
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：追风发蜡商品编号：5120890商品毛重：130.00g商品产地：中国大陆广东省发型：通用分类：发蜡/发泥");
        mCommodityBean8.setCommodityName("追风追风强力造型植萃发蜡100g");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8173/43/671632149/320135/e970061c/59acc0daNbf2dd94d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8788/75/654180460/313164/f20be49f/59acc0deN127a455b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7447/77/2326434408/344522/7f06353f/59acc0ddNbb9e2259.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7657/195/2330732255/316406/ce2bca77/59acc0e5Ne9751b9e.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize(null);
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：海飞丝洗发露商品编号：5433248商品毛重：0.83kg商品产地：太仓功效：去屑，清爽净含量：401ml-750ml性别：男适用人群：成人适合发质：所有发质");
        mCommodityBean9.setCommodityName("海飞丝 H&S 男士去屑洗发露劲感净透");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("美妆个护"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8557/166/423124168/206606/5c0840b/59a834e2N33bbc73c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9133/150/446150388/288950/e1ad7b28/59a83503N354c3281.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8380/176/458522336/257098/b3794e52/59a834faN5d854d0f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7528/274/2094856631/275124/b24deb26/59a8350eN78d52c42.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize(null);
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：海飞丝洗发露商品编号：206764商品毛重：0.85kg商品产地：广州/天津功效：深层修护，滋养净含量：401ml-750ml性别：通用适用人群：所有人群适合发质：干性");
        mCommodityBean10.setCommodityName("海飞丝去屑洗发水柔润滋养型");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //箱包手袋
    private static void addCommodity5() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6064/13/5711405626/222050/89477ddf/596dadc7Nf5cc7757.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6055/61/5640948853/239660/eddd9187/596dadceN388e8755.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6025/93/5676731750/178224/6e8778ad/596dadd7Nacc4c081.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5830/354/6913546008/239660/eddd9187/596dadcfNa13d1c82.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("12寸,14寸,15寸");
        mCommodityBean0.setCommodityDescribe("商品名称：法国LEXON乐上12电脑包air11苹果14笔记本Macbook内胆包pro13皮套15 灰色 air/pro retina 13.3英寸商品编号：12260664625店铺： 二诺箱包专营店商品毛重：400.00g货号：6004风格：欧美时尚外料材质：涤纶开袋方式：拉链颜色：黑色防水强度：防水尺寸：14.1英寸-15英寸里料质地：涤纶分类：内胆包适用人群：青少年适用场景：上下班");
        mCommodityBean0.setCommodityName("法国LEXON乐上12电脑包air11苹果14笔记本Macbook内胆包pro");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8545/41/2215577592/170216/d12215cd/59c87a32Nbb4bef8c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2287/30/2889114421/237666/17c0da92/571ed1ccNcdccb832.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2302/95/2892808682/656976/ed048116/571ed1d2N4dab5d11.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2614/23/644265133/175073/56993bfc/571ed1d3Nd09edeb4.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("红色,蓝色,绿色,黑色,浅灰色");
        mCommodityBean1.setCommodityDescribe("商品名称：JESSIEJANE及简女包单肩包1223休闲简约小方包真皮牛皮女士斜挎包 红色商品编号：10260150315店铺： jessie&jane旗舰店商品毛重：200.00g货号：TMJ15FF1223箱包硬度：硬风格：OL职业开袋方式：拉链颜色：黑色内部结构：证件袋有无夹层：有里料材质：涤纶是否可折叠：否适用场景：商务流行元素：其它图案：纯色大小：小材质：牛皮外形：方盒形箱包外袋种类：内贴袋提拎部件类型：软把附属肩带：单根适用人群：青年上市时间：2016秋季");
        mCommodityBean1.setCommodityName("JESSIEJANE及简女包单肩包1223休闲简约小方包真皮牛皮女士斜挎包");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);


        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9124/330/2175591677/131831/667980c/59c87a38N92f769a7.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2149/232/1345840123/148874/9943ccb8/5697768cNf32e2c85.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2170/102/2118311287/175795/aabb8b42/56977697N24bee147.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2299/76/1359284430/1030332/2384870f/56977696N2f848e1f.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize("红色,蓝色,绿色,黑色,浅灰色");
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：JESSIE&JANE及简女包双肩包2017欧美时尚简约水桶包1225女士背包女款小书包 军绿色商品编号：10113909423店铺： jessie&jane旗舰店商品毛重：0.52kg货号：TMJ16SF1225箱包硬度：软风格：日韩风范开袋方式：抽带容纳电脑尺寸：10英寸以下颜色：黑色材质：涤纶大小：中里料材质：涤纶是否可折叠：是适用场景：休闲流行元素：褶皱图案：纯色防水类型：无防水有无夹层：有提拎部件类型：软把内部结构：电脑插袋外形：购物袋形箱包外袋种类：内贴袋附属肩带：双根适用人群：青年上市时间：2016秋季");
        mCommodityBean2.setCommodityName("JESSIE&JANE及简女包双肩包2017欧美时尚简约水桶包1225女士背包女款小书包 ");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t10741/338/188109000/143614/a026de27/59c87a3eN4698481a.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2956/322/1920669471/246786/a40ac762/5796d783N60ab0cc7.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2287/144/1642621063/160878/20b7fef0/56caabebNaa88857e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2221/356/2249985057/390402/7243550f/56caabeaNae438761.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize("红色,蓝色,绿色,黑色,浅灰色");
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：JESSIE&JANE及简 女包单肩包2017经典时尚简约购物袋1009女士手提包包 米白色商品编号：10132627784店铺： jessie&jane旗舰店商品毛重：0.72kg货号：TMJ15FF1009箱包硬度：软风格：欧美开袋方式：其它颜色：白色内部结构：证件袋有无夹层：无里料材质：PU是否可折叠：否适用场景：休闲流行元素：其它图案：纯色大小：小材质：PU外形：竖款方形箱包外袋种类：内贴袋提拎部件类型：软把附属肩带：双根适用人群：青年上市时间：2016秋季");
        mCommodityBean3.setCommodityName("JESSIE&JANE及简 女包单肩包2017经典时尚简约购物袋1009女士手提包包");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9016/275/2252436064/148707/7cae05f6/59c87a22Nc6db2010.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5992/99/6212876629/108668/a582fcdd/59702152Ne712f59b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5905/64/6201349992/170214/def2955/59702182N1ca2f74f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6130/308/6021467175/227499/29d30101/59702153N2caabdfc.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize("红色,蓝色,绿色,黑色,浅灰色");
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：【新】JESSIE&JANE及简2017秋冬新款手提斜挎包2081时尚牛皮女包 玫瑰红色商品编号：14226227057店铺： jessie&jane旗舰店商品毛重：400.00g货号：J27F1272081箱包硬度：软风格：其它开袋方式：锁扣颜色：其它内部结构：手机袋，拉链暗袋有无夹层：无里料材质：织物是否可折叠：否适用场景：休闲流行元素：其它图案：其它大小：小材质：牛皮外形：其它箱包外袋种类：挖袋提拎部件类型：软把附属肩带：单根适用人群：青年上市时间：2017夏季");
        mCommodityBean4.setCommodityName("JESSIE&JANE及简2017秋冬新款手提斜挎包2081时尚牛皮女包");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);


        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8836/257/2232394743/131854/bb89ca40/59c87a30Ne86f2300.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4459/106/2419836044/121022/a72fc22/58ef628bN34915666.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4876/307/1316365565/175720/9a64c844/58ef628cN96facff9.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4957/275/1329285264/354842/29adda7b/58ef628bN413dc67a.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize("红色,蓝色,绿色,黑色,浅灰色");
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：JESSIE&JANE及简女包单肩包1850迷你简约包包2017春夏新款时尚牛皮真皮斜挎包 肉粉商品编号：11976486336店铺： jessie&jane旗舰店商品毛重：500.00g货号：J27F1271850箱包硬度：硬风格：欧美开袋方式：拉链颜色：黑色内部结构：证件袋有无夹层：无里料材质：涤纶是否可折叠：否适用场景：休闲流行元素：其它图案：纯色大小：小材质：牛皮外形：其它箱包外袋种类：内贴袋提拎部件类型：软把附属肩带：单根适用人群：青年上市时间：2017夏季");
        mCommodityBean5.setCommodityName("JESSIE&JANE及简女包单肩包1850迷你简约包包2017春夏新款时尚牛皮真皮斜挎包");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8242/305/2238006769/117389/46573aaf/59c87a40N8fe7bd20.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5059/164/1282368045/92713/7aa1c362/58ef6062Nbe5327c5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4882/312/1321745400/173460/57047c29/58ef6064N51c88c51.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4549/290/2255865441/285277/31e49b75/58ef6063N13fb77a7.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize("红色,蓝色,绿色,黑色,浅灰色");
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：JESSIEJANE及简女包双肩包欧美简约时尚背包1863真皮牛皮女士小书包包 浅灰色商品编号：11976373230店铺： jessie&jane旗舰店商品毛重：500.00g货号：J27F1271863箱包硬度：软风格：欧美开袋方式：拉链容纳电脑尺寸：10英寸以下颜色：黑色材质：牛皮大小：小里料材质：涤纶是否可折叠：否适用场景：休闲流行元素：其它图案：纯色防水类型：无防水有无夹层：有提拎部件类型：软把内部结构：证件袋外形：其它箱包外袋种类：内贴袋附属肩带：双根适用人群：青年上市时间：2017夏季");
        mCommodityBean6.setCommodityName("JESSIEJANE及简女包双肩包欧美简约时尚背包1863真皮牛皮女士小书包包");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3061/313/5810806995/235000/ccdda4f0/587f1cf9N4219a7cb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3652/231/701635409/278359/4976a0a9/58116225N0eccd8bb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3538/345/696283667/352496/3e43cf80/58116227N7f66abfc.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4120/342/2553743841/185379/5714fbb0/58d26601N3faae5ef.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize("红色,蓝色,绿色,黑色,浅灰色");
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：【国际名品】高尔夫GOLF柔软头层牛皮男士钱包真牛皮多卡位短款钱夹竖款/横款钱包礼盒 黑色 3页13卡位商品编号：1309628067店铺： GOLF高尔夫旗舰店商品毛重：100.00g货号：Q4BV93123T材质：牛皮颜色：黑色闭合方式：敞口款式：短款内部结构：拉链格分类：短款钱包适用人群：青年钱夹折数：2折");
        mCommodityBean7.setCommodityName("高尔夫GOLF柔软头层牛皮男士钱包真牛皮多卡位短款钱夹竖款/横款钱包礼盒 ");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2977/324/2066245144/369427/1c7de5cc/579b11b2N40cf47f5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3091/221/1447649919/137162/f710b42c/57cd4cbeNaf2fec59.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3163/11/1461377274/198150/afcb2495/57cd4cbeN16aa9e2e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3088/226/1456314533/223900/8c49e65f/57cd4cbfN6b5b3ca9.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize("红色,蓝色,绿色,黑色,浅灰色");
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：高尔夫GOLF男士钱包短款真皮多卡位钱包男横款钱包礼盒头层牛皮钱夹多功能钱包 款式1磨砂头层牛皮 啡色商品编号：10481595219店铺： GOLF高尔夫旗舰店商品毛重：100.00g商品产地：中国大陆货号：Q6BV97632T材质：牛皮颜色：黑色闭合方式：敞口款式：短款内部结构：卡位，零钱位，证件位分类：钱包礼盒适用人群：青年钱夹折数：2折");
        mCommodityBean8.setCommodityName("高尔夫GOLF男士钱包短款真皮多卡位钱包男横款钱包礼盒头层牛皮钱夹多功能钱包 ");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3214/136/1169291947/102419/686e5420/57c783e9Nd8df5028.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3082/358/1158039676/49752/d2a00c8a/57c783e8N06df91e1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3091/160/1176974590/148125/659cf26b/57c783e7Nfd845d60.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3250/25/1151303651/116475/7a72d273/57c783ecNb775258b.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize("红色,蓝色,绿色,黑色,浅灰色");
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：高尔夫GOLF头层牛皮男士长款钱包多卡位拉链钱夹轻薄时尚多功能可装手机 黑色商品编号：11868790601店铺： GOLF高尔夫旗舰店商品毛重：210.00g货号：Q6BV87012T1材质：牛皮颜色：黑色闭合方式：拉链款式：长款内部结构：零钱位分类：长款钱包适用人群：青年钱夹折数：2折");
        mCommodityBean9.setCommodityName("高尔夫GOLF头层牛皮男士长款钱包多卡位拉链钱夹轻薄时尚多功能可装手机 ");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("箱包手袋"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t7699/13/1736138884/317940/f8b11ded/59a0d22bN2f82c66d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8731/247/101275393/416787/28c4b7fe/59a0d23fN5cc664c7.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9286/252/99335489/272355/c2345d4c/59a0d23bN54913fe1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8893/240/97876387/302896/beabdce0/59a0d23bN00d4e45f.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize("红色,蓝色,绿色,黑色,浅灰色");
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：稻草人男士钱包礼盒时尚商务钱包男头层牛皮短款钱夹礼盒礼品 黑色MLH010-01 横款商品编号：15749900884店铺： 稻草人男包旗舰店商品毛重：260.00g商品产地：中国大陆货号：MLH010-01材质：牛皮颜色：黑色闭合方式：敞口款式：横款内部结构：卡位，证件位分类：钱包礼盒适用人群：青年钱夹折数：1折");
        mCommodityBean10.setCommodityName("稻草人男士钱包礼盒时尚商务钱包男头层牛皮短款钱夹礼盒礼品");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //女鞋系类
    private static void addCommodity4() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6694/194/1944107092/34258/ea5e90b4/595b6c04N3ac2061d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6541/253/2021602687/25100/79fada72/595b6c06Ne685ea60.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5833/340/5168245035/32198/703a9729/595b6c05N994bc6bc.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6682/315/1952654616/19675/df3e9e05/595b6bf8Nb56bbe08.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean0.setCommodityDescribe("商品名称：BASTO/百思图2017秋季新品漆牛皮蝴蝶结尖头方跟浅口女单鞋TH521CQ7 深兰色 36商品编号：13650884517店铺： 百丽集团官方旗舰店商品毛重：1.0kg货号：TH521CQ7尺码：36帮面材质：头层牛皮风格：甜美开口深度：浅口<7流行元素：蝴蝶结内里材质：猪皮闭合方式：套脚皮质特征：漆皮鞋跟形状：方跟鞋底材质：橡胶底鞋头：尖头图案：条纹跟高：低跟<3制作工艺：胶粘鞋上市时间：2017秋季");
        mCommodityBean0.setCommodityName("BASTO/百思图2017秋季新品漆牛皮蝴蝶结尖头方跟浅口女单鞋");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5827/317/6253612189/26299/ad135091/5968935cN49196afb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5908/257/5093910234/24458/60d604c2/59689369Nf75b7bce.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6073/11/4998242862/19435/1dd0e205/5968936aN1fd31e7e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6073/11/4998242862/19435/1dd0e205/5968936aN1fd31e7e.jpg");
        mCommodityBean1.setCommodityPrice(329.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean1.setCommodityDescribe("商品名称：Belle/百丽2017秋优雅时尚羊绒皮金属大环扣女单鞋09001CQ7 黑色 37商品编号：13979815524店铺： 百丽集团官方旗舰店商品毛重：1.0kg货号：09001CQ7尺码：34，35，36，37，38，39鞋头：尖头风格：简约跟高：高跟6-8内里材质：猪皮闭合方式：套脚开口深度：浅口<7鞋跟形状：细跟鞋底材质：复合底流行元素：金属装饰图案：纯色帮面材质：羊皮制作工艺：胶粘鞋上市时间：2017秋季");
        mCommodityBean1.setCommodityName("Belle/百丽2017秋优雅时尚羊绒皮金属大环扣女单鞋09001CQ7");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);


        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6400/110/2564991447/33699/69877c72/5962e0c4Na3baff62.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6502/334/2453013086/29479/fef82262/5962e0caN24d41e93.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5587/307/9191797481/344813/b71e70c5/59842565Nd11815a4.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6472/197/2495696943/32345/e6a88a88/5962e0cbN83f23be3.jpg");
        mCommodityBean2.setCommodityPrice(329.00);
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean2.setCommodityDescribe("商品名称：Belle/百丽2017新款秋季羊皮女绒面毛球时尚绑带尖头平跟浅口鞋单鞋55023CQ7 杏色 36商品编号：13819599036店铺： 百丽官方旗舰店商品毛重：1.0kg货号：55023CQ7尺码：36鞋头：尖头风格：甜美跟高：低跟<3内里材质：猪皮闭合方式：系带开口深度：浅口<7鞋跟形状：方跟鞋底材质：复合底流行元素：脚环绑带图案：纯色帮面材质：羊皮制作工艺：胶粘鞋上市时间：2017秋季");
        mCommodityBean2.setCommodityName("Belle/百丽2017新款秋季羊皮女绒面毛球时尚绑带尖头平跟浅口鞋单鞋");
        mCommodityBean2.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t4519/328/1197459469/273737/b2a49570/58da0c34Nf80490e6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4831/216/66025911/191764/85f40e9a/58da0c35Na2a48cc2.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4711/315/1172382492/223583/46907edd/58da0c36N4c925f12.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4129/328/3074692211/487225/91f22b83/58da0c36Nfbc8ec3f.jpg");
        mCommodityBean3.setCommodityPrice(329.00);
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean3.setCommodityDescribe("商品名称：Bata拔佳 17春季平底单鞋女舒适真皮女鞋百搭休闲鞋女 浅金色556-8641 38商品编号：11780732532店铺： Bata旗舰店商品毛重：1.0kg货号：556-641尺码：37鞋头：圆头风格：日系跟高：平跟内里材质：猪皮闭合方式：套脚开口深度：浅口<7鞋跟形状：平跟鞋底材质：橡胶底图案：纯色流行元素：蝴蝶结制作工艺：胶粘鞋上市时间：2017春季");
        mCommodityBean3.setCommodityName("Bata拔佳 17春季平底单鞋女舒适真皮女鞋百搭休闲鞋女");
        mCommodityBean3.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean3);


        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t982/108/1052149926/39018/1d268fac/556dbd51N8fdab0e5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1594/113/267562350/51323/c58f1ba/556dbd52Nef562a11.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1528/223/281751330/41917/ba556a8d/556dbd53Nbcc0fb54.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t1618/133/262148525/39452/6f1995b/556dbd53N76e69173.jpg");
        mCommodityBean4.setCommodityPrice(329.00);
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean4.setCommodityDescribe("商品名称：席派 2017夏季沙滩鞋亮片夹脚人字拖女厚底高跟凉拖鞋坡跟防滑凉鞋 日常外出拖鞋女 665 黑色 38商品编号：1585992174店铺： 席派旗舰店商品毛重：250.00g货号：大都市-665帮面材质：PU风格：韩版鞋跟形状：坡跟鞋底材质：泡沫款式：人字拖图案：纯色适用对象：青年（16-44岁）制作工艺：胶粘鞋适合场合：日常");
        mCommodityBean4.setCommodityName("席派 2017夏季沙滩鞋亮片夹脚人字拖女厚底高跟凉拖鞋坡跟防滑凉鞋");
        mCommodityBean4.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean4);


        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9019/209/898121186/374358/ee73b2e8/59b0d146Nd8bbbf3f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7807/162/1248246963/345160/744335be/599bcad2N2ea24307.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7666/353/1261476716/323755/a9b1222d/599bcf5eNb395f0e4.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7633/319/1319191564/508574/e4c1387f/599bcb6cN30e45330.jpg");
        mCommodityBean5.setCommodityPrice(329.00);
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean5.setCommodityDescribe("商品名称：酷趣coqui 秋冬新款亲子棉拖鞋男女防滑地板厚底保暖鞋小鸟可爱卡通居家鞋 粉色（妈妈款） 38-39商品编号：15537787011店铺： 酷趣旗舰店商品毛重：500.00g货号：1763/1764/1768尺码：34帮面材质：其它风格：公主流行元素：拼色适用对象：青年（16-44岁）鞋跟形状：平跟鞋底材质：橡胶上市时间：2017秋季图案：拼色制作工艺：缝制鞋款式：包头适合场合：居家");
        mCommodityBean5.setCommodityName("酷趣coqui 秋冬新款亲子棉拖鞋男女防滑地板厚底保暖鞋小鸟可爱卡通居家鞋");
        mCommodityBean5.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean5);


        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3151/155/2527656256/415455/737f7464/57e37a31N0c08456b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3238/182/2569141712/219299/3e600643/57e37a2cN44d14205.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3079/124/2596529202/292801/5269a755/57e37a2eN890032d1.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3103/17/2600503743/318393/9aadf0d2/57e37a33N4a03ae27.jpg");
        mCommodityBean6.setCommodityPrice(329.00);
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean6.setCommodityDescribe("商品名称：粗跟短靴女圆头防水台中跟马丁靴及裸靴2016秋冬季新款后拉链女靴子英伦时尚短筒靴 黑色 37商品编号：10711193891店铺： 富祥达鞋类专营店商品毛重：1.0kg商品产地：中国大陆货号：6138尺码：35，36，37，38，39，40帮面材质：PU风格：英伦流行元素：纯色内里材质：人造短毛绒闭合方式：套筒皮质特征：软面皮鞋跟形状：粗跟鞋底材质：橡胶底鞋头：圆头制作工艺：胶粘鞋跟高：中跟3-5");
        mCommodityBean6.setCommodityName("粗跟短靴女圆头防水台中跟马丁靴及裸靴2016秋冬季新款后拉链女靴子英伦时尚短筒靴");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);


        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3808/161/3601670583/162032/d8d9ec68/589b2438Nc9d624fc.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3247/63/6146043364/161501/f6eee10/589b2438Nfbe83a7d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3283/277/6101563072/85594/37906b82/589b2435N57ecb94c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3910/62/1882304980/194022/a9088803/589b243dN0d1c9284.jpg");
        mCommodityBean7.setCommodityPrice(329.00);
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean7.setCommodityDescribe("商品名称：雅诗莱雅 新款网纱露趾粗跟高跟凉鞋女时尚柳钉鱼嘴鞋圆头浅口单鞋 3048 黑色 35商品编号：11292102018店铺： 富祥达鞋类专营店商品毛重：1.0kg商品产地：中国大陆货号：雅诗3048帮面材质：绒面风格：公主闭合方式：套脚皮质特征：软面皮鞋底材质：橡胶底图案：纯色制作工艺：胶粘鞋尺码：34跟高：中跟3-5内里材质：人造革开口深度：深口鞋跟形状：粗跟适用对象：青年（16-44岁）鞋头：鱼嘴低帮鞋款式：单鞋颜色分类：黑色，其他流行元素：铆钉上市时间：2017春季");
        mCommodityBean7.setCommodityName("雅诗莱雅 新款网纱露趾粗跟高跟凉鞋女时尚柳钉鱼嘴鞋圆头浅口单鞋");
        mCommodityBean7.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3808/217/2630845062/432445/bd8c89c3/58622eb9N8a7f4556.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3808/217/2630845062/432445/bd8c89c3/58622eb9N8a7f4556.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3091/144/5001804930/372744/5eebaf6f/58622eb4N6c575510.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4021/48/928772525/271315/8ebe3c2b/58622eb5N0899d719.jpg");
        mCommodityBean8.setCommodityPrice(329.00);
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean8.setCommodityDescribe("商品名称：莱卡金顿性感尖头高跟鞋2017春季新款单鞋女纯色浅口鞋细跟高跟休闲鞋一字扣婚鞋6193 红色 37商品编号：11190139264店铺： 富祥达鞋类专营店商品毛重：1.0kg商品产地：中国大陆货号：莱卡6193帮面材质：磨砂皮风格：通勤闭合方式：一字式扣带皮质特征：磨砂皮鞋底材质：橡胶底图案：纯色制作工艺：胶粘鞋尺码：34跟高：高跟6-8内里材质：人造革开口深度：浅口<7鞋跟形状：细跟适用对象：青年（16-44岁）鞋头：尖头低帮鞋款式：单鞋颜色分类：黑色，其他流行元素：浅口上市时间：2017春季");
        mCommodityBean8.setCommodityName("莱卡金顿性感尖头高跟鞋2017春季新款单鞋女纯色浅口鞋细跟高跟休闲鞋一字扣婚鞋");
        mCommodityBean8.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean8);


        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5929/37/3570942163/104403/72ef0d59/595460d2Nef6796f0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3925/362/1595114316/344298/2c6f4852/587f1c2cN0d11f4b4.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4060/53/2018646756/284878/764e8450/58a12e88Ne53a5774.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3829/176/3335689261/304080/a12bba/58843171N2e2dffe1.jpg");
        mCommodityBean9.setCommodityPrice(329.00);
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean9.setCommodityDescribe("商品名称：热风女鞋小白鞋低帮鞋系带时尚休闲鞋H14W7110【此鞋大一码】 04白色 36偏大一码商品编号：11010102192店铺： 热风官方旗舰店商品毛重：1.0kg货号：H14W7110尺码：38鞋头：圆头风格：学院鞋帮：低帮鞋流行元素：交叉绑带内里材质：布面闭合方式：系带皮质特征：软面皮开口深度：深口鞋底材质：橡胶底帮面材质：超纤图案：纯色颜色分类：白色制作工艺：胶粘鞋上市时间：2017春季");
        mCommodityBean9.setCommodityName("热风女鞋小白鞋低帮鞋系带时尚休闲鞋");
        mCommodityBean9.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean9);


        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女鞋"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3787/93/2215020707/317650/d9329ef7/584e6055Nd66cd2f9.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3577/236/2285302720/370030/6dd8f77c/584e6056N4aced2a9.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t3052/245/4602769012/361349/7ec2a3e3/584e6069Nac2c03f4.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3343/175/2396188053/365635/d4a9392d/584e6058N8dd5fc06.jpg");
        mCommodityBean10.setCommodityPrice(329.00);
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommoditySize("36,37,38，39,40,41,42");
        mCommodityBean10.setCommodityDescribe("商品名称：萧萧布落2017春季韩版ulzzang运动鞋女学生潮原宿跑步板鞋厚底鞋百搭小白鞋休闲鞋潮 白色 40商品编号：11118209713店铺： 素衣霓裳服饰专营店商品毛重：500.00g货号：肖邦1631帮面材质：PU风格：休闲鞋帮：低帮鞋闭合方式：系带皮质特征：软面皮鞋底材质：橡胶底图案：纯色制作工艺：胶粘鞋尺码：37流行元素：其它内里材质：布面开口深度：浅口<7适用对象：青年鞋头：圆头颜色分类：黑色，白色款式：板鞋上市时间：2017春季");
        mCommodityBean10.setCommodityName("萧萧布落2017春季韩版ulzzang运动鞋女学生潮原宿跑步板鞋厚底鞋百搭小白鞋休闲鞋潮");
        mCommodityBean10.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //男鞋系类
    private static void addCommodity3() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2644/78/1370713640/252158/cbcc181e/573a93a8Nb69a6cd8.jpg," +
                "https://img14.360buyimg.com/n1/s546x546_jfs/t2899/90/1291399602/214068/94ce0bc4/573a93a9N65f76035.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2902/85/1303549619/157773/5132397b/573a93a8N5e724dc8.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2902/85/1303549619/157773/5132397b/573a93a8N5e724dc8.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean0.setCommodityDescribe("商品名称：耐克男鞋 2017春季新款Kobe科比曼巴简版2代战靴外场低帮耐磨篮球鞋818953 DF 818952-005 42商品编号：10354947090店铺： 幸运叶子旗舰店商品毛重：1.0kg货号：884445-006尺码：42热门购：战靴款式：低帮适用人群：男士上市时间：2017年春季");
        mCommodityBean0.setCommodityName("耐克男鞋 2017春季新款Kobe科比曼巴简版2代战靴外场低帮耐磨篮球鞋");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8431/320/2125845618/416675/ed21c499/59c4bd83N87035afe.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7282/310/387108815/216107/53b8b4c/599262efN569a332a.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7807/19/523587512/521137/55366164/59944599Naa46d6ca.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7726/8/367649694/222211/3748fd4e/599262f1N62eb3d14.jpg");
        mCommodityBean1.setCommodityPrice(329.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean1.setCommodityDescribe("商品名称：阿迪达斯男鞋跑鞋子 2017秋冬新款运动鞋缓震透气休闲小椰子跑步鞋BW0539 BW0539/17秋新款 小椰子 41/255商品编号：1183582310店铺： 幸运叶子旗舰店商品毛重：1.0kg货号：BW0539适合路面：跑道上市时间：2017冬季选购热点：经典款尺码：40.5功能科技：缓冲，避震，透气，轻质，其它适用人群：男士场合：运动闭合方式：系带");
        mCommodityBean1.setCommodityName("阿迪达斯男鞋跑鞋子 2017秋冬新款运动鞋缓震透气休闲小椰子跑步鞋");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);


        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t2629/184/1859667687/76644/dda7b367/574d2f2dN5217072b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2884/76/1861520842/92811/9102152e/574d2f2fN81ed6c38.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2908/142/1865332637/86756/dfe70974/574d2f2eN25f1a393.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2938/64/137461217/87571/15d1c695/574d2f2eN7e6c271b.jpg");
        mCommodityBean2.setCommodityPrice(329.00);
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean2.setCommodityDescribe("商品名称：adidas阿迪达斯男鞋运动篮球鞋 B72868 AQ7301 B72868 40商品编号：10387988305店铺： 胜道运动旗舰店商品毛重：500.00g货号：B72868 AQ7301尺码：41热门购：经典款款式：中帮适用人群：男士上市时间：2016秋季");
        mCommodityBean2.setCommodityName("adidas阿迪达斯男鞋运动篮球鞋");
        mCommodityBean2.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t7897/160/2486217329/317277/80f13020/59b0ce23Nfe04b4ad.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9181/149/887454317/294776/64044750/59b0ce1dNb0cccfb6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t8113/194/885271712/245531/c7446bc3/59b0ce28N7c97ab3b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7939/334/2532372622/361074/88766999/59b0ce1fN5400571b.jpg");
        mCommodityBean3.setCommodityPrice(329.00);
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean3.setCommodityDescribe("商品名称：耐克881444-010商品编号：5411140商品毛重：1.0kg商品产地：越南货号：910209-051适用人群：男士热门购：高帮，战靴，飞人，实战，气垫，外场，经典款功能：减震，耐磨，防滑款式：高帮上市时间：2017秋季");
        mCommodityBean3.setCommodityName("耐克 NIKE 男子 乔丹鞋 JORDAN B. FLY X 篮球鞋");
        mCommodityBean3.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean3);


        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5905/118/5704584023/214263/600a64fd/596da595Nca751aa5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6052/241/5715946137/84903/1ee6a1d4/596da597N77592d93.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5719/44/6950847733/168658/dfa373d5/596da598N8b007ba6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5878/338/6981125604/437297/b2856bb0/596da597N697361cb.jpg");
        mCommodityBean4.setCommodityPrice(329.00);
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean4.setCommodityDescribe("商品名称：阿迪达斯BY4467商品编号：4506843商品毛重：0.92kg商品产地：中国大陆货号：BY4467款式：中帮适用人群：男士上市时间：2017秋季");
        mCommodityBean4.setCommodityName("阿迪达斯ADIDAS 2017秋季 男子 Explosive Bounce 篮球鞋");
        mCommodityBean4.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean4);


        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6100/197/5646832894/286070/af8ecbd/596da625N42f8ba23.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6019/152/5660696326/125873/673fc8/596da622Nbeed7ed3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6097/172/5715466459/266837/ab40ea06/596da626N8a187c67.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5608/321/6913497246/500257/61e375ad/596da61cNcae672b4.jpg");
        mCommodityBean5.setCommodityPrice(329.00);
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean5.setCommodityDescribe("商品名称：阿迪达斯BY4492商品编号：4506895商品毛重：1.05kg商品产地：中国大陆货号：BY4492款式：中帮适用人群：男士上市时间：2017秋季");
        mCommodityBean5.setCommodityName("阿迪达斯ADIDAS 2017秋季 男子 Crazy Explosive TD 篮球鞋");
        mCommodityBean5.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean5);


        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t6403/187/2117998964/174169/1db6db68/595dbd19N6ef9a256.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6385/257/2101386793/182528/b7cdb23a/595dbd22Nd456edce.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5959/272/4128447439/83080/bb20f2b3/595dbd20N97ba7e26.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6754/12/2165474912/375232/63462283/595dbd26N829c8824.jpg");
        mCommodityBean6.setCommodityPrice(329.00);
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean6.setCommodityDescribe("商品名称：阿迪达斯B42387商品编号：4532999商品毛重：1.18kg商品产地：中国大陆货号：B42387热门购：经典款适用人群：男士款式：低帮上市时间：2017年春季");
        mCommodityBean6.setCommodityName("ADIDAS阿迪达斯 男子 篮球鞋");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);


        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3658/250/1854149034/191941/eae967f9/58354559N00e25ee9.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3595/356/1887117285/203050/f72a5625/58354564N93e3dc66.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3517/275/1909268952/154393/46bcfbcf/58354569N3e2f3fc0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t3715/352/1872697526/145430/ae0be1a7/5835456eN42e389f5.jpg");
        mCommodityBean7.setCommodityPrice(329.00);
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean7.setCommodityDescribe("商品名称：New BalanceMRT580MS商品编号：3813840商品毛重：0.86kg商品产地：中国货号：MRT580MS适合路面：跑道，公路，小道上市时间：2016冬季选购热点：经典款尺码：44功能科技：缓冲，避震，透气，轻质适用人群：中性场合：休闲，运动，竞赛闭合方式：系带");
        mCommodityBean7.setCommodityName("New Balance（NB）MRT580MS 运动鞋580 男女款 复古鞋情侣鞋");
        mCommodityBean7.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t5809/109/5774185326/244043/c3780d33/5963129dNebfc9605.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6043/311/4025444529/207056/dbddef91/596312cfN62840ebf.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6196/304/2431931947/201788/7fcf7b7f/596312d3Nfda22e78.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5755/327/5632311253/213002/bac9914e/596312daNb7b257bd.jpg");
        mCommodityBean8.setCommodityPrice(329.00);
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean8.setCommodityDescribe("商品名称：乔丹XM3570261商品编号：4450995商品毛重：0.88kg商品产地：福建货号：XM3570261适合路面：跑道，公路，小道上市时间：2017秋季选购热点：气垫尺码：42功能科技：避震适用人群：男士场合：运动闭合方式：系带");
        mCommodityBean8.setCommodityName("乔丹 男鞋跑步鞋气垫减震耐磨运动鞋");
        mCommodityBean8.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean8);


        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t7321/9/3130101499/191724/8112e20f/59ba5185N101c1606.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4678/246/1927229112/135930/217f6dd/58e88798N46112c88.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4543/254/1944949960/126925/e5678d67/58e88796N0629cd5e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7357/69/2312892679/574158/38f9f0c0/59ad2120Nd69ae7e7.jpg");
        mCommodityBean9.setCommodityPrice(329.00);
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean9.setCommodityDescribe("商品名称：双星M9082商品编号：4035927商品毛重：500.00g商品产地：中国大陆货号：M9082尺码：42功能科技：缓冲，避震场合：休闲适用人群：男士上市时间：2017年夏季");
        mCommodityBean9.setCommodityName("双星跑步鞋男春夏季新款网面透气软底减震慢跑鞋休闲运动鞋");
        mCommodityBean9.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean9);


        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男鞋"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9061/300/347485820/192365/c5174c4b/59a6237cNdb443e0f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9223/145/106217246/469249/565d93f4/59a0e990N7fa1b8fb.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7675/215/1406584141/463140/b6f5f53/599cf277N01e214a5.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2677/334/3746360324/283701/499f4ad9/57996104N12f21e48.jpg");
        mCommodityBean10.setCommodityPrice(329.00);
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommoditySize("39,40,41,42,43,44,45");
        mCommodityBean10.setCommodityDescribe("商品名称：特步男鞋运动鞋跑步鞋男夏秋季透气旅游鞋烽火韩版潮流复古休闲旅游鞋慢跑鞋子 9589 黑红/皮面 42商品编号：1257881158店铺： 领投运动专营店商品毛重：1.0kg货号：986419119589适合路面：跑道上市时间：2017秋季选购热点：烽火鞋尺码：39功能科技：缓冲，避震，透气，轻质适用人群：男士场合：运动闭合方式：系带");
        mCommodityBean10.setCommodityName("特步男鞋运动鞋跑步鞋男夏秋季透气旅游鞋烽火韩版潮流复古休闲旅游鞋慢跑鞋子 ");
        mCommodityBean10.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //女装系类
    private static void addCommodity2() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean0.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t10618/323/139545265/176529/8fb6644c/59c687e8Nf0eeb1f8.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6025/323/7280831254/267426/7abb68a8/597c49abNd16f5a34.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7042/19/1007983881/242089/2c812dbc/597c49b4N3d0634e0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5986/198/7347256965/173601/503ee424/597c49a8Nacd780e9.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean0.setCommodityDescribe("商品名称：OSA欧莎2017秋装新款女装时尚百搭弹力收腰长袖连衣裙C13020 浅粉色 M商品编号：14612034107店铺： osa品牌服饰旗舰店商品毛重：400.00g货号：S117C13020腰型：高腰风格：OL通勤领型：立领适用年龄：25-29周岁图案：纯色人群：亲子裙型：A字裙流行元素：口袋衣门襟：套头面料：其它组合形式：单件袖型：常规版型：修身型袖长：九分袖裙长：中裙分类：其它尺码：S上市时间：2017秋季");
        mCommodityBean0.setCommodityName("OSA欧莎2017秋装新款女装时尚百搭弹力收腰长袖连衣裙");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean1.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9442/11/2171320526/139700/80f60e31/59c6880bN9da2afe3.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6877/310/1004256684/447688/a8962ae8/597c49ebN03479971.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5686/72/8630356126/453948/8abf31b2/597c49e8N33600ac7.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6937/157/1036095953/122948/69a1730f/597c49eaNa41995e8.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean1.setCommodityDescribe("商品名称：OSA欧莎2017秋装新款女装做旧破洞修身牛仔裤女C53012 白色 S商品编号：14612055644店铺： osa品牌服饰旗舰店商品毛重：400.00g货号：S117C53012腰型：高腰版型：修身型厚度：薄款面料分类：其它颜色：白色系适用年龄：25-29周岁裤长：长裤裤型：其它工艺：做旧弹力：无弹力上市时间：2017秋季");
        mCommodityBean1.setCommodityName("OSA欧莎2017秋装新款女装做旧破洞修身牛仔裤");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean2.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t10756/136/62228007/187340/f74b554d/59c6876aN65c8148e.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4177/317/894518617/291637/87517e56/58ba72c9N8915dfdd.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4210/296/881570279/239965/9adf1cf5/58ba72ccN2f11d36b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t4282/130/910844302/133870/9a234940/58ba72d1N6f678648.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：欧莎2017春装新款女装系带圆领甜美通勤荷叶袖衬衫 桃粉色 XXL商品编号：11501704472店铺： osa品牌服饰旗舰店商品毛重：400.00g货号：S117A12007尺码：S版型：直筒型厚度：适中领型：圆领流行元素：荷叶边颜色：粉色系材质：其它衣门襟：单排扣袖长：七分袖袖型：荷叶袖衣长：常规款上市时间：2017春季");
        mCommodityBean2.setCommodityName("欧莎2017春装新款女装系带圆领甜美通勤荷叶袖衬衫");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean3.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8530/231/2088347108/434276/fba3272d/59c4a736Nb014efbf.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9445/250/2150020349/444172/2390864d/59c4a733Nbf718834.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7534/210/3824356932/454734/1d1c1b6a/59c4a72cN17af022f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t9523/224/50857297/456776/282de821/59c4a722N26190754.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：⑩OSA欧莎2017冬装新款女装 百搭连帽保暖御寒短款羽绒服D20003 深蓝色 S商品编号：16976331318店铺： osa品牌服饰旗舰店商品毛重：400.00g货号：S117D20003含绒量：50%-70%袖型：其它风格：OL通勤厚度：常规领型：连帽流行元素：其它充绒量：100g(含)-150g(不含)面料：其它袖长：长袖衣门襟：拉链适用年龄：25-29周岁衣长：短款图案：其它填充物：白鸭绒版型：直筒型上市时间：2017冬季");
        mCommodityBean3.setCommodityName("OSA欧莎2017冬装新款女装 百搭连帽保暖御寒短款羽绒服0");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean4.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t8452/38/435598586/513452/ac17ee46/59a7e783N7b0424df.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7735/353/2068850288/425681/fdba9e0a/59a7e81dN6cdf0054.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t8416/286/430248248/140072/58506065/59a7e82cN1d50814a.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7735/353/2068850288/425681/fdba9e0a/59a7e81dN6cdf0054.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：爱爱丸（AIAIWAN）2017秋装新款卫衣女外套韩版学生韩版宽松白色连帽WY170806 米色 均码商品编号：16023238184店铺： 爱爱丸旗舰店商品毛重：1.0kg商品产地：中国大陆货号：WY170806风格：甜美厚度：适中领型：连帽穿着方式：套头颜色：白色系材质：棉适用年龄：18-24周岁图案：字母尺码：均码衣长：常规款流行元素：其它组合形式：单件袖型：其它版型：宽松型衣门襟：套头袖长：长袖内胆类型：其它上市时间：2017秋季");
        mCommodityBean4.setCommodityName(" 爱爱丸（AIAIWAN）2017秋装新款卫衣女外套韩版学生韩版宽松白色连帽");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean5.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t7429/112/1115435274/351128/8b3efa73/599a7a94Ne2fa9ced.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7882/131/1100161170/261828/5220ead1/599a7c84Nb3aa48d3.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7213/224/1117808948/337062/8daea11f/599a7c88N9c91d4a9.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7435/145/1113111416/316661/df68589d/599a7c80Nddc6d6a8.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：悠画 2017秋季新款韩版连衣裙一字领露肩碎花雪纺女喇叭袖A字打底裙子 杏色 M商品编号：11244131244店铺： 悠画瑞丰专卖店商品毛重：300.00g货号：LYQ50504-LYQ50505腰型：中腰风格：简约领型：一字领颜色：其它适用年龄：25-29周岁图案：其它人群：轻熟女裙型：不规则流行元素：其它版型：修身型面料：棉组合形式：单件衣门襟：套头袖型：常规袖长：七分袖裙长：中长裙分类：其它尺码：M上市时间：2017秋季");
        mCommodityBean5.setCommodityName("悠画 2017秋季新款韩版连衣裙一字领露肩碎花雪纺女喇叭袖A字打底裙子");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean6.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t5629/303/1101185956/302948/6eb1438e/5923c003N9469a6d1.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t5890/308/1118323812/304940/ecf80d58/5923c028N0269c5f9.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t5764/269/1070032834/295101/dcaed3b7/5923c025Nfb801dfa.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t5698/148/1094419066/228203/db95562e/5923c02bNb701e280.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：悠画 2017夏装新款牛仔裤女韩版破洞翻边九分跨裤紧身百搭小脚裤 蓝色 26商品编号：11871158743店铺： 悠画瑞丰专卖店商品毛重：300.00g货号：K52401尺码：28版型：宽松型类型：牛仔裤流行元素：简约面料分类：棉弹牛仔布裤长：九分裤颜色：多色厚度：适中腰型：其它裤型：其它上市时间：2017夏季");
        mCommodityBean6.setCommodityName("悠画 2017夏装新款牛仔裤女韩版破洞翻边九分跨裤紧身百搭小脚裤");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean7.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t6592/57/1228580174/110655/8e4fc321/594c6a9eNd63368db.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t5713/13/4424117367/102371/f98a187f/594c6a9fN721152cf.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t5590/13/4291926029/102260/f22650ce/594c6a9fN342e7a8e.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t6001/206/3018848761/95694/4abcfe61/594c6aa0Nbe0539e2.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：堡晟连衣裙商品编号：4417491商品毛重：500.00g商品产地：浙江杭州货号：HMQY1859尺码：S风格：简约流行元素：其它面料：聚酯纤维颜色：多色人群：少女版型：修身型裙长：中裙腰型：中腰裙型：A字裙上市时间：2017夏季");
        mCommodityBean7.setCommodityName("堡晟 2017女装夏A字裙短袖中长款A型松紧腰套头一字领通勤连衣裙 ");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean8.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t7999/290/2258670752/183979/c6c6cd55/59c86478Ne1591daf.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6799/304/360002938/358701/c8291dcf/59759422Naf7ae255.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7012/304/362895946/418290/a23e02c8/59759423N0128e551.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6994/297/369761418/352437/909873a8/59759422N72535ed5.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：片断2017新款秋季谷波纹理长款A摆毛衣套头衫 藏青 S商品编号：14398949024店铺： 片断服饰旗舰店商品毛重：100.00g货号：632074050尺码：S，M，L，XL袖型：常规袖风格：小清新，简约厚度：适中领型：圆领流行元素：其它衣长：中长款颜色：多色系袖长：长袖衣门襟：套头适用年龄：25-29周岁版型：宽松型图案：波点材质：腈纶/化纤款式：套头上市时间：2017秋季");
        mCommodityBean8.setCommodityName("片断2017新款秋季谷波纹理长款A摆毛衣套头衫");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean9.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t10948/224/187975801/226055/695dec71/59c863d0N935d8831.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6055/198/2864960189/385067/67d5ef2b/59487a86N27f37b16.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6268/308/999132199/355078/5523927c/59487a8dN4fd649a0.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6268/308/999132199/355078/5523927c/59487a8dN4fd649a0.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：片断2017新款女夏t恤肌理针织短袖T恤纯棉女装 象牙白 S商品编号：13298426900店铺： 片断服饰旗舰店商品毛重：100.00g货号：P7A123200T03尺码：其它袖型：常规袖上市时间：2017夏季颜色：多色系领型：圆领流行元素：印花袖长：短袖面料：棉/丝光棉");
        mCommodityBean9.setCommodityName("片断2017新款女夏t恤肌理针织短袖T恤纯棉女装");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("女装"));
        mCommodityBean10.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t3334/192/2243144847/297777/c0c9153e/5848b9b2Naf390acc.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2593/225/1467298491/491484/dc9ca380/573fe2f9N7645ee84.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2884/311/1452234012/476646/6bd12afd/573fe2faN66ede59c.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t2668/268/1466031790/444454/443ae632/573fe2fbN091b2f2b.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize("M,S,XL,L,XS");
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：敬酒服新娘短款结婚旗袍裙中式礼服宴会晚礼服蕾丝修身红色长款连衣裙 包肩长款 M商品编号：10369584559店铺： 姿采人生旗舰店商品毛重：0.6kg货号：Q8029尺码：S厚度：适中领型：立领流行元素：蕾丝颜色：红色系材质：蕾丝礼服摆型：鱼尾礼服类型：敬酒服腰型：中腰类型：礼服上市时间：2016夏季");
        mCommodityBean10.setCommodityName("敬酒服新娘短款结婚旗袍裙中式礼服宴会晚礼服蕾丝修身红色长款连衣裙");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }

    //男装系类
    private static void addCommodity1() {
        CommodityBean mCommodityBean0 = new CommodityBean();
        mCommodityBean0.setCommodityId(null);
        mCommodityBean0.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean0.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t8899/193/1857371508/155013/67bdefb8/59c0da81N6f9247ef.jpg,http://img14.360buyimg.com/n0/jfs/t9256/26/1928848198/86299/be338b2a/59c0ddfcN137fa7ff.jpg,http://img14.360buyimg.com/n0/jfs/t3274/265/8789581621/159438/299a00f8/58ca3a84Nb5a39e8b.jpg,http://img14.360buyimg.com/n0/jfs/t4294/209/2021861566/223145/81d7940b/58ca3a87Nf397042f.jpg");
        mCommodityBean0.setCommodityPrice(329.00);
        mCommodityBean0.setStock(300);
        mCommodityBean0.setCommoditySize("38,39,40,41,42,43,44,45");
        mCommodityBean0.setCommodityDescribe("商品名称：雅戈尔youngor 【DP免烫】秋季男士长袖衬衫 商务休闲 白色 42商品编号：11375023852店铺： 雅戈尔官方旗舰店商品毛重：500.00g货号：YLDP10171BJA人群：青年版型：标准型主要材质：棉领型：方领面料分类：其它袖长：长袖颜色：白色图案：纯色基础风格：商务绅士风格：商务休闲上市时间：2017春季适用场景：上班");
        mCommodityBean0.setCommodityName("雅戈尔youngor 【DP免烫】秋季男士长袖衬衫 商务休闲 白色");
        mCommodityBean0.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean0);


        CommodityBean mCommodityBean1 = new CommodityBean();
        mCommodityBean1.setCommodityId(null);
        mCommodityBean1.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean1.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t7774/191/1419542128/191323/5f6b7433/599d0db5N5fad1d6f.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7273/220/1420915833/166470/166aba4b/599d0db8Nb1925e89.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7765/197/1439951643/251212/773431b8/599d0db9N947dab02.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7924/116/1479408090/190715/573a1b47/599d0db9Nbc1f2e93.jpg");
        mCommodityBean1.setCommodityPrice(399.00);
        mCommodityBean1.setStock(300);
        mCommodityBean1.setCommoditySize("38,39,40,41,42,43,44,45");
        mCommodityBean1.setCommodityDescribe("商品名称：雅戈尔youngor 【桑蚕丝】 秋季男士长袖衬衫 商务休闲 白底蓝条 38商品编号：14734307141店铺： 雅戈尔官方旗舰店商品毛重：500.00g货号：YLTS12543HJA人群：青年版型：标准型厚度：常规领型：尖领（常规）颜色：白色面料分类：其它袖长：长袖图案：条纹基础风格：商务绅士风格：商务正装适用季节：秋季主要材质：棉上市时间：2016秋季适用场景：其它　");
        mCommodityBean1.setCommodityName("雅戈尔youngor 【桑蚕丝】 秋季男士长袖衬衫 商务休闲 白底蓝条 38");
        mCommodityBean1.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean1);

        CommodityBean mCommodityBean2 = new CommodityBean();
        mCommodityBean2.setCommodityId(null);
        mCommodityBean2.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean2.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t8791/161/341084734/291524/206f9758/59a61941Ne26beab1.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t9292/222/332377219/277693/ec460c67/59a61968Ne88ac17d.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t8239/247/346922590/404489/d5797908/59a61971N7077f0af.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7420/239/2027384616/439676/fd2c9274/59a6197fNe7ffdf06.jpg");
        mCommodityBean2.setCommodityPrice(299.00);
        mCommodityBean2.setCommoditySize("38,39,40,41,42");
        mCommodityBean2.setStock(300);
        mCommodityBean2.setCommodityDescribe("商品名称：雅戈尔youngor 【DP免烫】 秋季男士长袖衬衫 商务休闲 蓝底黑白格 40商品编号：15276519878店铺： 雅戈尔官方旗舰店商品毛重：500.00g货号：YLDP16109FBA人群：青年版型：标准型厚度：常规领型：其它颜色：蓝色面料分类：色织布袖长：长袖图案：其它基础风格：商务绅士风格：商务正装适用季节：秋季主要材质：棉上市时间：往季适用场景：上班");
        mCommodityBean2.setCommodityName("雅戈尔youngor 【DP免烫】 秋季男士长袖衬衫 商务休闲 蓝底黑白格 40");
        mCommodityBean2.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean2);


        CommodityBean mCommodityBean3 = new CommodityBean();
        mCommodityBean3.setCommodityId(null);
        mCommodityBean3.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean3.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t8791/161/341084734/291524/206f9758/59a61941Ne26beab1.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t9292/222/332377219/277693/ec460c67/59a61968Ne88ac17d.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t8239/247/346922590/404489/d5797908/59a61971N7077f0af.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7420/239/2027384616/439676/fd2c9274/59a6197fNe7ffdf06.jpg");
        mCommodityBean3.setCommodityPrice(299.00);
        mCommodityBean3.setCommoditySize("38,39,40,41,42");
        mCommodityBean3.setStock(300);
        mCommodityBean3.setCommodityDescribe("商品名称：雅戈尔youngor 【DP免烫】 秋季男士长袖衬衫 商务休闲 蓝底黑白格 40商品编号：15276519878店铺： 雅戈尔官方旗舰店商品毛重：500.00g货号：YLDP16109FBA人群：青年版型：标准型厚度：常规领型：其它颜色：蓝色面料分类：色织布袖长：长袖图案：其它基础风格：商务绅士风格：商务正装适用季节：秋季主要材质：棉上市时间：往季适用场景：上班");
        mCommodityBean3.setCommodityName("雅戈尔youngor 【DP免烫】 秋季男士长袖衬衫 商务休闲 蓝底黑白格 40");
        mCommodityBean3.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean3);

        CommodityBean mCommodityBean4 = new CommodityBean();
        mCommodityBean4.setCommodityId(null);
        mCommodityBean4.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean4.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t8995/210/1735780760/217499/bbba7b67/59c7d812Ne2ed104f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5890/89/9240605681/128419/ff0023b9/598434caNa009fe49.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5890/89/9240605681/128419/ff0023b9/598434caNa009fe49.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t7060/201/1707043303/265328/e89017c8/598434cbN3b1f894e.jpg");
        mCommodityBean4.setCommodityPrice(599.00);
        mCommodityBean4.setCommoditySize("110,120,130,140,150,160");
        mCommodityBean4.setStock(300);
        mCommodityBean4.setCommodityDescribe("商品名称：AK童装轻复古MA-1飞行夹克棒球领外套1704502 军绿色 140商品编号：14820771949店铺： AK官方旗舰店商品毛重：300.00g货号：1704502上市时间：2017夏季适用性别：男童适用年龄：3-6岁，6-9岁，9-12岁衣门襟：拉链适用季节：春秋分类：夹克/皮衣款式：短款安全等级：B类");
        mCommodityBean4.setCommodityName(" AK童装轻复古MA-1飞行夹克棒球领外套1704502");
        mCommodityBean4.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean4);

        CommodityBean mCommodityBean5 = new CommodityBean();
        mCommodityBean5.setCommodityId(null);
        mCommodityBean5.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean5.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9061/327/2216249710/244571/42cfb83f/59c7d858N4059df44.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5716/257/9319922315/311972/fe14fafa/59841187Nbe696d65.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5584/356/9200786831/415555/d90559ba/5984116aN1e9a6dd2.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5707/256/9279399696/300069/89ef0132/5984116cN53041371.jpg");
        mCommodityBean5.setCommodityPrice(199.00);
        mCommodityBean5.setCommoditySize("120,130,140,150,160");
        mCommodityBean5.setStock(300);
        mCommodityBean5.setCommodityDescribe("商品名称：AK童装2017夏季新款复古印花短袖T恤1700520 铁锈红 130商品编号：14815900095店铺： AK官方旗舰店商品毛重：300.00g货号：1700520风格：休闲是否带帽子：无袖长：短袖适用性别：男童适用年龄：3-6岁，6-9岁，9-12岁面料：棉布适用季节：夏季图案：其它安全等级：B类上市时间：2017夏季");
        mCommodityBean5.setCommodityName("AK童装2017夏季新款复古印花短袖T恤1700520");
        mCommodityBean5.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean5);

        CommodityBean mCommodityBean6 = new CommodityBean();
        mCommodityBean6.setCommodityId(null);
        mCommodityBean6.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean6.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t9739/18/172723895/202354/fe6c1b7d/59c7d846N882ac16d.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5857/176/9224072402/211708/c4417c67/598425a7Nbdb3d3a2.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5878/263/9203616862/167850/afcc8ba0/5984259aNeeb9503f.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6877/275/1661236381/390808/5cf982e9/59842596N889e26b6.jpg");
        mCommodityBean6.setCommodityPrice(369.00);
        mCommodityBean6.setCommoditySize("120,130,140,150,160");
        mCommodityBean6.setStock(300);
        mCommodityBean6.setCommodityDescribe("商品名称：AK童装轻复古全棉双腿袋短卫裤1714512 军绿色 130商品编号：14816224488店铺： AK官方旗舰店商品毛重：300.00g货号：1714512风格：休闲裤门襟：皮筋面料：纯棉裤长：短裤适用性别：男童适用年龄：3-6岁，6-9岁，9-12岁裤腰：中腰适用季节：春秋季分类：卫裤安全等级：B类上市时间：2017夏季");
        mCommodityBean6.setCommodityName("AK童装轻复古全棉双腿袋短卫裤1714512");
        mCommodityBean6.setHotCommodity(true);
        CommodityBeanManager.AddCommodity(mCommodityBean6);

        CommodityBean mCommodityBean7 = new CommodityBean();
        mCommodityBean7.setCommodityId(null);
        mCommodityBean7.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean7.setCommodityPic("https://img14.360buyimg.com/n0/jfs/t10834/354/165446539/256634/7b3985b4/59c7d863N34302790.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t5830/120/9229275641/149624/409aff7/5984141eN441dccb6.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6844/76/1680518158/203944/21bb8549/59841426Na7a2507b.jpg," +
                "https://img14.360buyimg.com/n0/jfs/t6073/190/7941253844/158882/185e2177/59841427N2c19e498.jpg");
        mCommodityBean7.setCommodityPrice(299.00);
        mCommodityBean7.setCommoditySize("120,130,140,150,160");
        mCommodityBean7.setStock(300);
        mCommodityBean7.setCommodityDescribe("商品名称：AK童装轻复古梭织长裤1712508 卡其色 150商品编号：14818602648店铺： AK官方旗舰店商品毛重：300.00g货号：1712508风格：休闲适用年龄：3-6岁，6-9岁，9-12岁裤门襟：其它面料：纯棉裤腰：中腰适用性别：男童裤长：长裤是否可开档：不开档适用季节：春秋季分类：休闲裤安全等级：B类上市时间：2017夏季");
        mCommodityBean7.setCommodityName("AK童装轻复古梭织长裤1712508 卡其色");
        mCommodityBean7.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean7);


        CommodityBean mCommodityBean8 = new CommodityBean();
        mCommodityBean8.setCommodityId(null);
        mCommodityBean8.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean8.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t8056/245/2023536686/643734/70c57224/59c38c5cN9ccb4d04.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t9544/239/17614800/522993/bf7eb26/59c38c5eN35b6d273.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t9547/242/15334748/648194/d84719b8/59c38c54Nfadc9313.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t10912/241/16705001/812008/c9c75c16/59c38c63Nc5ecb62e.jpg");
        mCommodityBean8.setCommodityPrice(238.00);
        mCommodityBean8.setCommoditySize("S,M,XL,2XL,3XL");
        mCommodityBean8.setStock(300);
        mCommodityBean8.setCommodityDescribe("商品名称：马克华菲潮牌(Reshake)牛仔外套男复古牛仔夹克青年学生牛仔衣外套潮 蓝色 S商品编号：16931721050店铺： 亚尔逊服饰专营店商品毛重：0.6kg商品产地：中国大陆货号：HG317111017701风格：青春休闲厚度：常规领型：翻领颜色：蓝色口袋设计：侧缝插袋适用季节：秋季适用场景：休闲人群：青年下摆设计：直下摆主要材质：棉流行元素：简约图案：纯色面料分类：牛仔布版型：修身型袖型：收口袖衣门襟：单排扣尺码：M基础风格：青春流行工艺：水洗衣长：短款上市时间：2017秋季");
        mCommodityBean8.setCommodityName("马克华菲潮牌(Reshake)牛仔外套男复古牛仔夹克青年学生牛仔衣外套潮");
        mCommodityBean8.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean8);

        CommodityBean mCommodityBean9 = new CommodityBean();
        mCommodityBean9.setCommodityId(null);
        mCommodityBean9.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean9.setCommodityPic("http://img14.360buyimg.com/n1/s546x546_jfs/t7954/161/2145697908/518601/67967b4e/59a8c905N9e77a9d9.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t8458/120/474475503/722796/29bb6f56/59a8c90cN9025e040.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7798/210/2125782485/701957/e3ea3921/59a8c8fcNdcbc8c1b.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t8374/135/452181301/413494/cfc3b667/59a8c90eN55e57777.jpg");
        mCommodityBean9.setCommodityPrice(148.00);
        mCommodityBean9.setCommoditySize("S,M,XL,2XL,3XL");
        mCommodityBean9.setStock(300);
        mCommodityBean9.setCommodityDescribe("商品名称：花花公子贵宾夹克男秋季新款男装纯色外套男休闲夹克NGDN2919 黑色 M商品编号：16047700488店铺： 亚尔逊服饰专营店商品毛重：0.6kg商品产地：中国大陆货号：NGDN2919风格：青春休闲厚度：常规领型：立领颜色：黑色口袋设计：侧缝插袋适用季节：秋季适用场景：休闲人群：青年下摆设计：其它　主要材质：涤纶流行元素：简约图案：纯色面料分类：其它　版型：修身型袖型：收口袖衣门襟：前中拉链门襟尺码：M基础风格：青春流行工艺：免烫衣长：短款上市时间：2017秋季");
        mCommodityBean9.setCommodityName("花花公子贵宾夹克男秋季新款男装纯色外套男休闲夹克");
        mCommodityBean9.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean9);

        CommodityBean mCommodityBean10 = new CommodityBean();
        mCommodityBean10.setCommodityId(null);
        mCommodityBean10.setCommodityTypeId(CommodityTypeBeanManager.LoadId("男装"));
        mCommodityBean10.setCommodityPic("http://img14.360buyimg.com/n0/jfs/t7423/251/1681410606/214692/11e42402/599e9b09N0fa5a5ab.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7753/279/1695235748/253140/d5bb873d/599e9b09N564652e3.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t7750/330/1668642795/207886/2460d425/599e9af7N5cb44da0.jpg," +
                "http://img14.360buyimg.com/n0/jfs/t8377/277/3974926/134186/d5a67198/599e9b17N82a113c7.jpg");
        mCommodityBean10.setCommodityPrice(99.00);
        mCommodityBean10.setCommoditySize("S,M,XL,2XL,3XL");
        mCommodityBean10.setStock(300);
        mCommodityBean10.setCommodityDescribe("商品名称：稻草人（MEXICAN）夹克男士外套连帽修身字母中长款夹克WLZPJK6603 蓝色 M商品编号：15653162004店铺： 亚尔逊服饰专营店商品毛重：0.6kg商品产地：中国大陆货号：WLZPJK6603风格：青春休闲厚度：常规领型：立领颜色：黑色口袋设计：侧缝插袋适用季节：秋季适用场景：休闲人群：青年版型：修身型主要材质：涤纶流行元素：简约面料分类：其它　衣长：中长款袖型：收口袖衣门襟：前中拉链门襟尺码：M基础风格：青春流行工艺：水洗下摆设计：其它　上市时间：2017秋季");
        mCommodityBean10.setCommodityName("稻草人（MEXICAN）夹克男士外套连帽修身字母中长款夹克");
        mCommodityBean10.setHotCommodity(false);
        CommodityBeanManager.AddCommodity(mCommodityBean10);
    }


}
