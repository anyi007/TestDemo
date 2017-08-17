package com.example.lql.testdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 2017/6/21.
 */

public class UserFavoriteListBeanForRetrofit {

    /**
     * Data : [{"Favoriteid":10841,"Id":5339,"Imgurl":"/Upload/img/20170216/ID20170216061257_主图01.jpg","Name":"学术圈充值卡 先充值后付款  ","Price":"10","count":5833,"Comment":0,"type":2},{"Favoriteid":10840,"Id":5340,"Imgurl":"/Upload/img/20170216/ID20170216070203_充值主图.png","Name":"检测速审充值卡 可定制金额 先充值后付款","Price":" 10 ","count":5833,"Comment":0,"type":1},{"Favoriteid":10839,"Id":5416,"Imgurl":"/Upload/img/20170316/ID20170316065747_DYJS201701.jpg","Name":"电源技术","Price":"100-500","count":null,"Comment":0,"type":3},{"Favoriteid":10838,"Id":5417,"Imgurl":"/Upload/img/20170316/ID20170316065952_DZQJ.jpg","Name":"电子器件","Price":"100-500","count":null,"Comment":0,"type":3},{"Favoriteid":10837,"Id":5414,"Imgurl":"/Upload/img/20170316/ID20170316065305_DLDZ201702.jpg","Name":"电力电子技术","Price":"100-500","count":null,"Comment":0,"type":3},{"Favoriteid":10836,"Id":5412,"Imgurl":"/Upload/img/20170316/ID20170316064747_JXGJ201605.jpg","Name":"大学教育科学","Price":"100-500","count":null,"Comment":0,"type":3},{"Favoriteid":10835,"Id":5410,"Imgurl":"/Upload/img/20170316/ID20170316064135_CBGJ.jpg","Name":"出版广角 ","Price":"100-500","count":null,"Comment":0,"type":3},{"Favoriteid":10834,"Id":5413,"Imgurl":"/Upload/img/20170316/ID20170316065031_DDDS201606.jpg","Name":"当代电视","Price":"100-500","count":null,"Comment":0,"type":3},{"Favoriteid":10833,"Id":5407,"Imgurl":"/Upload/img/20170316/ID20170316063048_BJYX.jpg","Name":"北京医学  投稿速审","Price":"100-1000","count":null,"Comment":0,"type":3},{"Favoriteid":10832,"Id":5406,"Imgurl":"/Upload/img/20170316/ID20170316045424_AHYY201701.jpg","Name":"安徽医药   投稿速审","Price":"100-1000","count":null,"Comment":0,"type":3},{"Favoriteid":10831,"Id":5372,"Imgurl":"/Upload/img/20170221/ID20170221124534_专业代写.jpg","Name":"专本硕博论文 职称论文 包修改包通过","Price":"100-500","count":null,"Comment":0,"type":3},{"Favoriteid":10830,"Id":5307,"Imgurl":"/Upload/img/20170221/ID20170221124250_主图.jpg","Name":"成人教育  快速直审","Price":"10-100","count":6301,"Comment":1,"type":3},{"Favoriteid":10829,"Id":5307,"Imgurl":"/Upload/img/20170221/ID20170221124250_主图.jpg","Name":"成人教育  快速直审","Price":"10-100","count":6301,"Comment":1,"type":3},{"Favoriteid":10828,"Id":5307,"Imgurl":"/Upload/img/20170221/ID20170221124250_主图.jpg","Name":"成人教育  快速直审","Price":"10-100","count":6301,"Comment":1,"type":3},{"Favoriteid":10819,"Id":5341,"Imgurl":"/Upload/img/20170216/ID20170216070256_充值主图.png","Name":"检测速审充值卡 可定制金额 先充值后付款","Price":"10-10000","count":null,"Comment":0,"type":3}]
     * ResultCode : 0
     * Msg : 获取成功！
     * count : -5
     */
    @SerializedName("ResultCode")
    private int ResultCode;
    @SerializedName("Msg")
    private String Msg;
    @SerializedName("count")
    private int count;
    @SerializedName("Data")
    private List<DataBean> Data;

    public int getResultCode() {
        return ResultCode;
    }

    public void setResultCode(int ResultCode) {
        this.ResultCode = ResultCode;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }


    @Override
    public String toString() {
        return "UserFavoriteListBean{" +
                "ResultCode=" + ResultCode +
                ", Msg='" + Msg + '\'' +
                ", count=" + count +
                ", Data=" + Data +
                '}';
    }

    public static class DataBean {
        /**
         * Favoriteid : 10841
         * Id : 5339
         * Imgurl : /Upload/img/20170216/ID20170216061257_主图01.jpg
         * Name : 学术圈充值卡 先充值后付款
         * Price : 10
         * count : 5833
         * Comment : 0
         * type : 2
         */
        @SerializedName("Favoriteid")
        private int Favoriteid;
        @SerializedName("Id")
        private int Id;
        @SerializedName("Imgurl")
        private String Imgurl;
        @SerializedName("Name")
        private String Name;
        @SerializedName("Price")
        private String Price;
        @SerializedName("count")
        private int count;
        @SerializedName("Comment")
        private int Comment;
        @SerializedName("type")
        private int type;

        public int getFavoriteid() {
            return Favoriteid;
        }

        public void setFavoriteid(int Favoriteid) {
            this.Favoriteid = Favoriteid;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getImgurl() {
            return Imgurl;
        }

        public void setImgurl(String Imgurl) {
            this.Imgurl = Imgurl;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getPrice() {
            return Price;
        }

        public void setPrice(String Price) {
            this.Price = Price;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getComment() {
            return Comment;
        }

        public void setComment(int Comment) {
            this.Comment = Comment;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }


        @Override
        public String toString() {
            return "DataBean{" +
                    "Favoriteid=" + Favoriteid +
                    ", Id=" + Id +
                    ", Imgurl='" + Imgurl + '\'' +
                    ", Name='" + Name + '\'' +
                    ", Price='" + Price + '\'' +
                    ", count=" + count +
                    ", Comment=" + Comment +
                    ", type=" + type +
                    '}';
        }
    }
}
