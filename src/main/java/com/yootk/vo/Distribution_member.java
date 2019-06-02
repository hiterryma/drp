package com.yootk.vo;

import java.io.Serializable;

public class Distribution_member implements Serializable {
    private Long dmid ;
    private Long cuid ;
    private String salemid ;

    public Long getDmid() {
        return dmid;
    }

    public void setDmid(Long dmid) {
        this.dmid = dmid;
    }

    public Long getCuid() {
        return cuid;
    }

    public void setCuid(Long cuid) {
        this.cuid = cuid;
    }

    public String getSalemid() {
        return salemid;
    }

    public void setSalemid(String salemid) {
        this.salemid = salemid;
    }

    @Override
    public String toString() {
        return "Distribution_member{" +
                "dmid=" + dmid +
                ", cuid=" + cuid +
                ", salemid='" + salemid + '\'' +
                '}';
    }
}
