package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import java.util.List;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 17:06/2018/7/3
 *    Copyright: houruhou
 *    Desc:
 * </pre>
 */
public class ModelData {
    String type;
    String title;
    List<SubData> subdatas;

    public ModelData(String type, String title) {
        this.type = type;
        this.title = title;
    }

    public void setSubdatas(List<SubData> subdatas) {
        this.subdatas = subdatas;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public List<SubData> getSubdatas() {
        return subdatas;
    }

    static class SubData {
        String subImgUrl;
        String subTitle;

        public String getSubImgUrl() {
            return subImgUrl;
        }

        public void setSubImgUrl(String subImgUrl) {
            this.subImgUrl = subImgUrl;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }
    }
}
