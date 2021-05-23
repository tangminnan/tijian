package com.tijian.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 检查结果表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-05-23 09:58:55
 */
public class TijianDataDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//用户id
	private Long userId;
	//历史记录id
	private Long historyId;
	//检查项目
	private String singleChecks;
	//拼音代码
	private String pins;
	//检查结果
	private String result;
	//医生的建议
	private String suggest;
	//检查医生
	private String chector;
	//身份账号
	private String identityCard;
	//检查时间
	private Date addTime;

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
	 * 设置：历史记录id
	 */
	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}
	/**
	 * 获取：历史记录id
	 */
	public Long getHistoryId() {
		return historyId;
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
	/**
	 * 设置：拼音代码
	 */
	public void setPins(String pins) {
		this.pins = pins;
	}
	/**
	 * 获取：拼音代码
	 */
	public String getPins() {
		return pins;
	}
	/**
	 * 设置：检查结果
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 获取：检查结果
	 */
	public String getResult() {
		return result;
	}
	/**
	 * 设置：医生的建议
	 */
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	/**
	 * 获取：医生的建议
	 */
	public String getSuggest() {
		return suggest;
	}
	/**
	 * 设置：检查医生
	 */
	public void setChector(String chector) {
		this.chector = chector;
	}
	/**
	 * 获取：检查医生
	 */
	public String getChector() {
		return chector;
	}
	/**
	 * 设置：身份账号
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	/**
	 * 获取：身份账号
	 */
	public String getIdentityCard() {
		return identityCard;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
}
