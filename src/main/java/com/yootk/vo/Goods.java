package com.yootk.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Goods implements Serializable {
	private Long gid ; //商品编号
	private String name ;//商品名称
	private Long wiid; //商品对应的分类
	private Long stid; //上品对应的子分类
	private Double price ;//商品价格
	private Double weight ;//商品重量
	private String photo ; //图片
	private String note ; //商品信息描述
	private Date lastin; //最后一次进货时间
	private Integer stornum;//商品的整体存储数量
	private String recorder;//商品信息记录的用户id
	private Integer deflag;//删除标记，0未删除，1已删除

	public Long getWiid() {
		return wiid;
	}

	public void setWiid(Long wiid) {
		this.wiid = wiid;
	}

	public Long getStid() {
		return stid;
	}

	public void setStid(Long stid) {
		this.stid = stid;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getLastin() {
		return lastin;
	}

	public void setLastin(Date lastin) {
		this.lastin = lastin;
	}

	public Integer getStornum() {
		return stornum;
	}

	public void setStornum(Integer stornum) {
		this.stornum = stornum;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public Integer getDeflag() {
		return deflag;
	}

	public void setDeflag(Integer deflag) {
		this.deflag = deflag;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
