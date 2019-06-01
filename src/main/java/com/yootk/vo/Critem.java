package com.yootk.vo;

import java.io.Serializable;

public class Critem implements Serializable {
    private long criid ;
    private String title ;

    @Override
    public String toString() {
        return "Critem{" +
                "criid=" + criid +
                ", title='" + title + '\'' +
                '}';
    }

    public long getCriid() {
        return criid;
    }

    public void setCriid(long criid) {
        this.criid = criid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
