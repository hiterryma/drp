package com.yootk.vo;

import java.util.Date;

public class News {
    private Long nid ;
    private String mid ;
    private String title ;
    private String abs ;
    private String photo ;
    private String note ;
    private int status ;
    private Date pubdate ;

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", mid='" + mid + '\'' +
                ", title='" + title + '\'' +
                ", abs='" + abs + '\'' +
                ", photo='" + photo + '\'' +
                ", note='" + note + '\'' +
                ", status=" + status +
                ", pubdate=" + pubdate +
                '}';
    }
}
