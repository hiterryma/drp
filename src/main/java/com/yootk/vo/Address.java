package com.yootk.vo;

import java.io.Serializable;

public class Address implements Serializable {
    private Long adid;
    private String mid;
    private Integer cid;
    private Integer pid;
    private String addr;
    private String receiver;
    private String phone;
    private Integer dflag;

    public Long getAdid() {
        return adid;
    }

    public void setAdid(Long adid) {
        this.adid = adid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDflag() {
        return dflag;
    }

    public void setDflag(Integer dflag) {
        this.dflag = dflag;
    }

    public Address() {
    }
}
