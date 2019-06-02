package com.yootk.vo;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    private Long oid;
    private String mid;
    private Integer adid;
    private Date subdate;
    private double price;
    private String note;
    public Orders(){}
    public Orders(Long oid, String mid, Integer adid, Date subdate, double price, String note) {
        this.oid = oid;
        this.mid = mid;
        this.adid = adid;
        this.subdate = subdate;
        this.price = price;
        this.note = note;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public Date getSubdate() {
        return subdate;
    }

    public void setSubdate(Date subdate) {
        this.subdate = subdate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
