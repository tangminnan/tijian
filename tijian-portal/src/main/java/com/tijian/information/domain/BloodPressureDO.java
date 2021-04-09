package com.tijian.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 血压检查
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 11:22:58
 */
public class BloodPressureDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//用户id
	private Long userId;
	//检查时间
	private Date addTime;
	//收缩压
	private Double systolicPressure;
	//舒张压
	private Double diastolicPressure;
	//脉搏
	private Double pulse;
	//平均值
	private Double avg;
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
	 * 设置：收缩压
	 */
	public void setSystolicPressure(Double systolicPressure) {
		this.systolicPressure = systolicPressure;
	}
	/**
	 * 获取：收缩压
	 */
	public Double getSystolicPressure() {
		return systolicPressure;
	}
	/**
	 * 设置：舒张压
	 */
	public void setDiastolicPressure(Double diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}
	/**
	 * 获取：舒张压
	 */
	public Double getDiastolicPressure() {
		return diastolicPressure;
	}
	/**
	 * 设置：脉搏
	 */
	public void setPulse(Double pulse) {
		this.pulse = pulse;
	}
	/**
	 * 获取：脉搏
	 */
	public Double getPulse() {
		return pulse;
	}
	/**
	 * 设置：平均值
	 */
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	/**
	 * 获取：平均值
	 */
	public Double getAvg() {
		return avg;
	}

	public Long getCheckId() {
		return checkId;
	}

	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}
}
