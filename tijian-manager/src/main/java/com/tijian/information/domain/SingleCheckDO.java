package com.tijian.information.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 单项表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-24 14:41:14
 */
public class SingleCheckDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//单项名称
	private String singleName;
	//价格
	private BigDecimal price;
	//添加时间
	private Date addTime;
	//0 删除   1未删除
	private Integer deleteFlag;
	//拼音
	private String pin;

	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：单项名称
	 */
	public void setSingleName(String singleName) {
		this.singleName = singleName;
	}
	/**
	 * 获取：单项名称
	 */
	public String getSingleName() {
		return singleName;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：添加时间
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * 设置：0 删除   1未删除
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	/**
	 * 获取：0 删除   1未删除
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * 设置：拼音
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}
	/**
	 * 获取：拼音
	 */
	public String getPin() {
		return pin;
	}
}
