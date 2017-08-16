package com.example.lql.testdemo.bean;

import java.util.List;

/**
 * 类描述：RxJava转换Flatmap的bean
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class RxJavaStudentBean {

    private String Name;
    private List<CurriculumBean> CurriculumList;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<CurriculumBean> getCurriculumList() {
        return CurriculumList;
    }

    public void setCurriculumList(List<CurriculumBean> curriculumList) {
        CurriculumList = curriculumList;
    }

    public static class CurriculumBean {
        private String CurriculumName;

        public String getCurriculumName() {
            return CurriculumName;
        }

        public void setCurriculumName(String curriculumName) {
            CurriculumName = curriculumName;
        }
    }


}
