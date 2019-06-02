package com.yootk.vo;

import java.io.Serializable;

public class Distribution_details implements Serializable {
    private Long dsdid ;
    private Long gid ;
    private String name ;
    private Integer num ;
    private Double price ;
    private Integer status ;
    private Integer wid ;
    private String outmid ;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getDsdid() {
        return dsdid;
    }

    public void setDsdid(Long dsdid) {
        this.dsdid = dsdid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getOutmid() {
        return outmid;
    }

    public void setOutmid(String outmid) {
        this.outmid = outmid;
    }

    @Override
    public String toString() {
        return "Distribution_details{" +
                "dsdid=" + dsdid +
                ", gid=" + gid +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", status=" + status +
                ", wid=" + wid +
                ", outmid='" + outmid + '\'' +
                '}';
    }
}
