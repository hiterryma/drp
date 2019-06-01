package com.yootk.vo;

import java.io.Serializable;

public class Province implements Serializable {

    private Long pid;
    private String title;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                '}';
    }
}
