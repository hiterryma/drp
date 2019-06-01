package com.yootk.vo;

import java.io.Serializable;

public class Level implements Serializable {
    @Override
    public String toString() {
        return "Level{" +
                "lid=" + lid +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private Long lid ;
    private String title ;
}
