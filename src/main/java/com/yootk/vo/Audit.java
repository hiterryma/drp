package com.yootk.vo;

import java.io.Serializable;
import java.util.Date;

public class Audit implements Serializable {
    private Long audid ;
    private Long said ;
    //审核人
    private String aud_member ;
    //审核结果：0：拒绝  1：通过
    private Integer aud_result ;
    //审核日期
    private Date aud_date ;
    //审核信息
    private String aud_note ;

    public Long getAudid() {
        return audid;
    }

    public void setAudid(Long audid) {
        this.audid = audid;
    }

    public Long getSaid() {
        return said;
    }

    public void setSaid(Long said) {
        this.said = said;
    }

    public String getAud_member() {
        return aud_member;
    }

    public void setAud_member(String aud_member) {
        this.aud_member = aud_member;
    }

    public Integer getAud_result() {
        return aud_result;
    }

    public void setAud_result(Integer aud_result) {
        this.aud_result = aud_result;
    }

    public Date getAud_date() {
        return aud_date;
    }

    public void setAud_date(Date aud_date) {
        this.aud_date = aud_date;
    }

    public String getAud_note() {
        return aud_note;
    }

    public void setAud_note(String aud_note) {
        this.aud_note = aud_note;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "audid=" + audid +
                ", said=" + said +
                ", aud_member='" + aud_member + '\'' +
                ", aud_result=" + aud_result +
                ", aud_date=" + aud_date +
                ", aud_note='" + aud_note + '\'' +
                '}';
    }
}
