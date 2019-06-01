package com.yootk.vo;

import java.io.Serializable;

public class Address implements Serializable {
    private Long adid;
    private String mid;
    private  Integer dflag;
    //1，收件人
    private String receiver ;
    //2，联系电话
    private  String phone ;
    //3,省份
    private Long pid ;
    //4,城市
    private Long cid ;
    //5,详细地址
    private String addr;


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

    public Integer getDflag() {
        return dflag;
    }

    public void setDflag(Integer dflag) {
        this.dflag = dflag;
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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Address{" +
                "adid=" + adid +
                ", mid='" + mid + '\'' +
                ", dflag=" + dflag +
                ", receiver='" + receiver + '\'' +
                ", phone='" + phone + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                ", addr='" + addr + '\'' +
                '}';
    }
}
