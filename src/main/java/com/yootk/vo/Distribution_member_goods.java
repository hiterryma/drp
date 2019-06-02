package com.yootk.vo;

import java.io.Serializable;

public class Distribution_member_goods implements Serializable {
    private Long dmgid ;
    private Long dmid ;
    private Long gid ;

    public Long getDmgid() {
        return dmgid;
    }

    public void setDmgid(Long dmgid) {
        this.dmgid = dmgid;
    }

    public Long getDmid() {
        return dmid;
    }

    public void setDmid(Long dmid) {
        this.dmid = dmid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "Distribution_member_goods{" +
                "dmgid=" + dmgid +
                ", dmid=" + dmid +
                ", gid=" + gid +
                '}';
    }
}
