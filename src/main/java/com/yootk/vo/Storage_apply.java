package com.yootk.vo;

import java.io.Serializable;

public class Storage_apply implements Serializable {
    //出入库申请ID，自动增长
    private Long said ;
    //出入库申请标题
    private String title ;
    //要出入库仓库所在省份ID
    private Long pid ;
    //要出入库仓库所在城市ID
    private Long cid ;
    //出入库商品分类
    private Long wiid ;
    //要出入库仓库编号
    private Long wid ;
    //出入库信息的完整介绍
    private String note ;
    //审核状态。0：未审核、1：已审核
    private Integer status ;
    //审核用户的id，申请单创建后是没有审核用户的，自由提交之后，交给财务部的入库审核人员审核之后，记录下审核人员的id
    private String appmid ;


    public Long getSaid() {
        return said;
    }

    public void setSaid(Long said) {
        this.said = said;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAppmid() {
        return appmid;
    }

    public void setAppmid(String appmid) {
        this.appmid = appmid;
    }

    @Override
    public String toString() {
        return "Storage_apply{" +
                "said=" + said +
                ", title='" + title + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                ", wiid=" + wiid +
                ", wid=" + wid +
                ", note='" + note + '\'' +
                ", status=" + status +
                ", appmid='" + appmid + '\'' +
                '}';
    }
}
