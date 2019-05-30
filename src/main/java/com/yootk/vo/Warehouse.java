package com.yootk.vo;
import java.io.Serializable;

public class Warehouse implements Serializable {
    //仓库ID，自动增长
    private Long wid;
    //仓库名称
    private String name;
    //仓库所在省份的编号
    private Long pid;
    //仓库所在城市的编号
    private Long cid;
    //仓库保存类型（通过witem表）
    private Long wiid;
    //仓库的地址，要求记录好省、城市、地址
    private String address;
    //仓库面积
    private Double area;
    //仓库保存的商品最大数量
    private Integer maximum;
    //仓库保存的当前商品数量
    private Integer currnum;
    //仓库的照片
    private String photo;
    //仓库信息说明
    private String note;
    //仓库的记录发布者
    private String recorder;
    //仓库管理员的用户编号
    private String admin;



    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getWiid() {
        return wiid;
    }

    public void setWiid(Long wiid) {
        this.wiid = wiid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public Integer getCurrnum() {
        return currnum;
    }

    public void setCurrnum(Integer currnum) {
        this.currnum = currnum;
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

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "wid=" + wid +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                ", wiid=" + wiid +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", maximum=" + maximum +
                ", currnum=" + currnum +
                ", photo='" + photo + '\'' +
                ", note='" + note + '\'' +
                ", recorder='" + recorder + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }
}
