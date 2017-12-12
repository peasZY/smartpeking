package com.lens.testdemo.domain;

import java.util.List;

public class NewsData {
    public int recode;
    public List<NewsMenuData> data;
    public List<Integer> extend;

    @Override
    public String toString() {
        return "NewsData{" +
                "data=" + data +
                '}';
    }

    public class NewsMenuData {
        public int id;
        public String title;
        public String url;
        public int type;
        public List<NewsTabData> children;

        @Override
        public String toString() {
            return "NewsMenuData{" +
                    "title='" + title + '\'' +
                    ", children=" + children +
                    '}';
        }
    }
    public class NewsTabData{
        public int id;
        public String title;
        public String url;
        public int type;

        @Override
        public String toString() {
            return "NewsTabData{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }

}
