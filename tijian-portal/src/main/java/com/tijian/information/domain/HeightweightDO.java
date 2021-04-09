package com.tijian.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 身高体重表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 10:47:55
 */
public class HeightweightDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//用户id
	private Long userId;
	//检查时间
	private Date addTime;
	//身高
	private Double height;
	//体重1
	private Double weight;
	//体重指数
	private String bi;
	//本次检查记录id
	private Long checkId;

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
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：检查时间
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：检查时间
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * 设置：身高
	 */
	public void setHeight(Double height) {
		this.height = height;
	}
	/**
	 * 获取：身高
	 */
	public Double getHeight() {
		return height;
	}
	/**
	 * 设置：体重1
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * 获取：体重1
	 */
	public Double getWeight() {
		return weight;
	}
	/**
	 * 设置：体重指数
	 */
	public void setBi(String bi) {
		this.bi = bi;
	}
	/**
	 * 获取：体重指数
	 */
	public String getBi() {
		return bi;
	}

	public Long getCheckId() {
		return checkId;
	}

	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}
}
