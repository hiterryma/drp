package com.yootk.vo;

import java.io.Serializable;
import java.util.Date;

public class CustomerRecord implements Serializable {
    private Long crid ;
    private String cmid ;
    private Date cdate ;
    private Long criid ;
    private String note ;
    private String cuid ;
    private String title ;

    public Long getCrid() {
        return crid;
    }

    public void setCrid(Long crid) {
        this.crid = crid;
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Long getCriid() {
        return criid;
    }

    public void setCriid(Long criid) {
        this.criid = criid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CustomerRecord{" +
                "crid=" + crid +
                ", cmid='" + cmid + '\'' +
                ", cdate=" + cdate +
                ", criid=" + criid +
                ", note='" + note + '\'' +
                ", cuid='" + cuid + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
