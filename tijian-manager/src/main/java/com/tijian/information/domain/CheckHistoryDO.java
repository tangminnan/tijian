package com.tijian.information.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 检查记录表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-25 14:46:10
 */
public class CheckHistoryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//用户id
	private Long userId;
	//金额总计
	private BigDecimal totalAmount;
	//实际支付金额
	private BigDecimal yingfuAmount;
	//检查时间
	private Date addTime;
	//检查项目
	private String singleChecks;
	//身份证号
	private String identityCard;
	//用户名
	private String name;
	//检查是否完成  0=检查未完成   1=检查完成
	private Integer status;
	//检查进度
	private Integer process;

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
	 * 设置：检查项目
	 */
	public void setSingleChecks(String singleChecks) {
		this.singleChecks = singleChecks;
	}
	/**
	 * 获取：检查项目
	 */
	public String getSingleChecks() {
		return singleChecks;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getYingfuAmount() {
		return yingfuAmount;
	}

	public void setYingfuAmount(BigDecimal yingfuAmount) {
		this.yingfuAmount = yingfuAmount;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getProcess() {
		return process;
	}

	public void setProcess(Integer process) {
		this.process = process;
	}
}
