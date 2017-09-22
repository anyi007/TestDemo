package com.example.lql.testdemo.bean;

import java.util.List;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/13
 * 修改备注：
 */
public class NBAVideoIdBean {

    /**
     * code : 0
     * data : [{"type":"news","id":"20170912049360","column":"videos","needUpdate":"0"},{"type":"news","id":"20170912049355","column":"videos","needUpdate":"0"},{"type":"news","id":"20170912049347","column":"videos","needUpdate":"0"},{"type":"news","id":"20170912031774","column":"videos","needUpdate":"0"},{"type":"news","id":"20170720033948","column":"videos","needUpdate":"0"}]
     * version : 000ffeb068e794582b925479bde53d0e
     */

    private int code;
    private String version;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : news
         * id : 20170912049360
         * column : videos
         * needUpdate : 0
         */

        private String type;
        private String id;
        private String column;
        private String needUpdate;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public String getNeedUpdate() {
            return needUpdate;
        }

        public void setNeedUpdate(String needUpdate) {
            this.needUpdate = needUpdate;
        }
    }
}
