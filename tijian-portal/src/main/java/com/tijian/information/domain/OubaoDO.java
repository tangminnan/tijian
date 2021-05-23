package com.tijian.information.domain;

import java.io.Serializable;
import java.util.Date;



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
	//本次检查记录id
	private Long checkId;
	//医生的建议
	private String suggest;
	//医生的姓名
	private String name;

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

	public Long getCheckId() {
		return checkId;
	}

	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
