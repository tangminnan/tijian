package com.tijian.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 眼内压
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 11:49:19
 */
public class EyePressureDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//用户id
	private Integer userId;
	//右眼眼内压
	private Double eyePressureOd;
	//左眼眼内压
	private Double eyePressureOs;
	//检查日期
	private Date addTime;

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
	/**
	 * 设置：右眼眼内压
	 */
	public void setEyePressureOd(Double eyePressureOd) {
		this.eyePressureOd = eyePressureOd;
	}
	/**
	 * 获取：右眼眼内压
	 */
	public Double getEyePressureOd() {
		return eyePressureOd;
	}
	/**
	 * 设置：左眼眼内压
	 */
	public void setEyePressureOs(Double eyePressureOs) {
		this.eyePressureOs = eyePressureOs;
	}
	/**
	 * 获取：左眼眼内压
	 */
	public Double getEyePressureOs() {
		return eyePressureOs;
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
}
