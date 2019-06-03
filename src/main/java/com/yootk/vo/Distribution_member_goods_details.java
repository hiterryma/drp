package com.yootk.vo;

import java.io.Serializable;

public class Distribution_member_goods_details implements Serializable {
    private Long dmgdid ;
    private Long dmgid ;
    private int gnum ;

    public Long getDmgdid() {
        return dmgdid;
    }

    public void setDmgdid(Long dmgdid) {
        this.dmgdid = dmgdid;
    }

    public Long getDmgid() {
        return dmgid;
    }

    public void setDmgid(Long dmgid) {
        this.dmgid = dmgid;
    }

    public int getGnum() {
        return gnum;
    }

    public void setGnum(int gnum) {
        this.gnum = gnum;
    }

    @Override
    public String toString() {
        return "Distribution_member_goods_details{" +
                "dmgdid=" + dmgdid +
                ", dmgid=" + dmgid +
                ", gnum=" + gnum +
                '}';
    }
}
