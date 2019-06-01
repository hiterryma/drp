package com.yootk.vo;

import java.io.Serializable;

public class Storage_apply_details implements Serializable {
    //详情ID，自动增长
    private Long sadid ;
    //要出入库的商品ID
    private Long gid ;
    //要出入库的商品名称（避免多表查询）
    private String name ;
    //出入库商品数量（仓库当前保存量的增减）
    private Integer num ;
    //商品的总价（单价 * 数量）
    private Double price ;
    //商品的总重量（重量 * 数量）
    private Double weight ;

    public Long getSadid() {
        return sadid;
    }

    public void setSadid(Long sadid) {
        this.sadid = sadid;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Storage_apply_details{" +
                "sadid=" + sadid +
                ", gid=" + gid +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
