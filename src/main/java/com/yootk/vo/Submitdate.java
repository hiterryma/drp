package com.yootk.vo;

import java.io.Serializable;
import java.util.Date;
//订单日期表的VO类
public class Submitdate implements Serializable {
    private Long sdateid ;
    private Long said ;
    private Date submit_date ;
    public Long getSdateid() {
        return sdateid;
    }

    public void setSdateid(Long sdateid) {
        this.sdateid = sdateid;
    }

    public Long getSaid() {
        return said;
    }

    public void setSaid(Long said) {
        this.said = said;
    }

    public Date getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(Date submit_date) {
        this.submit_date = submit_date;
    }

    @Override
    public String toString() {
        return "Submitdate{" +
                "sdateid=" + sdateid +
                ", said=" + said +
                ", submit_date=" + submit_date +
                '}';
    }
}
