package com.tijian.information.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 欧宝检查
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 14:03:22
 */
public class OubaoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//用户id
	private Integer userId;
	//左眼图片
	private String limg;
	//右眼图片
	private String rimg;
	//检查日期
	private Date addTime;
	List<String> llist = new ArrayList<>();
	List<String> rlist = new ArrayList<>();

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUserId() {
		return userId;
	}

	public String getLimg() {
		return limg;
	}

	public void setLimg(String limg) {
		this.limg = limg;
	}

	public String getRimg() {
		return rimg;
	}

	public void setRimg(String rimg) {
		this.rimg = rimg;
	}

	/**
	 * 设置：检查日期
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：检查日期
	 */
	public Date getAddTime() {
		return addTime;
	}

	public List<String> getLlist() {
		return llist;
	}

	public void setLlist(List<String> llist) {
		this.llist = llist;
	}

	public List<String> getRlist() {
		return rlist;
	}

	public void setRlist(List<String> rlist) {
		this.rlist = rlist;
	}
}
