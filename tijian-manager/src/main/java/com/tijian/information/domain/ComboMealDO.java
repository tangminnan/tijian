package com.tijian.information.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 套餐表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-24 15:40:43
 */
public class ComboMealDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//套餐代码
	private String comboCode;
	//套餐名称
	private String comboName;
	//应收金额
	private BigDecimal amountReceivable;
	//实收金额
	private BigDecimal amountReceived;
	//折扣
	private Double discount;
	//添加时间
	private Date addTime;
	//0 删除   1未删除
	private Integer deleteFlag;
	//检查项目
	private String singleCheck;

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
	 * 设置：套餐代码
	 */
	public void setComboCode(String comboCode) {
		this.comboCode = comboCode;
	}
	/**
	 * 获取：套餐代码
	 */
	public String getComboCode() {
		return comboCode;
	}
	/**
	 * 设置：套餐名称
	 */
	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	/**
	 * 获取：套餐名称
	 */
	public String getComboName() {
		return comboName;
	}
	/**
	 * 设置：应收金额
	 */
	public void setAmountReceivable(BigDecimal amountReceivable) {
		this.amountReceivable = amountReceivable;
	}
	/**
	 * 获取：应收金额
	 */
	public BigDecimal getAmountReceivable() {
		return amountReceivable;
	}
	/**
	 * 设置：实收金额
	 */
	public void setAmountReceived(BigDecimal amountReceived) {
		this.amountReceived = amountReceived;
	}
	/**
	 * 获取：实收金额
	 */
	public BigDecimal getAmountReceived() {
		return amountReceived;
	}
	/**
	 * 设置：折扣
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	/**
	 * 获取：折扣
	 */
	public Double getDiscount() {
		return discount;
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
	 * 设置：检查项目
	 */
	public void setSingleCheck(String singleCheck) {
		this.singleCheck = singleCheck;
	}
	/**
	 * 获取：检查项目
	 */
	public String getSingleCheck() {
		return singleCheck;
	}
}
