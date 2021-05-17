package com.tijian.information.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 检查项目表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-04-21 11:18:40
 */
public class CheckItemDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//项目名称
	private String parentItem;
	//细项名称
	private String childrenItem;
	//价格
	private BigDecimal price;
	//添加时间
	private Date addTime;
	//0 删除   1未删除
	private Integer deleteFlag;
	//拼音
	private String pin;
	//父项目id
	private Long parentId;
	private List<String> list = new ArrayList<String>();
	List<CheckItemDO> checkItemDOS = new ArrayList<>();

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
	 * 设置：项目名称
	 */
	public void setParentItem(String parentItem) {
		this.parentItem = parentItem;
	}
	/**
	 * 获取：项目名称
	 */
	public String getParentItem() {
		return parentItem;
	}
	/**
	 * 设置：细项名称
	 */
	public void setChildrenItem(String childrenItem) {
		this.childrenItem = childrenItem;
	}
	/**
	 * 获取：细项名称
	 */
	public String getChildrenItem() {
		return childrenItem;
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
	/**
	 * 设置：父项目id
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父项目id
	 */
	public Long getParentId() {
		return parentId;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public List<CheckItemDO> getCheckItemDOS() {
		return checkItemDOS;
	}

	public void setCheckItemDOS(List<CheckItemDO> checkItemDOS) {
		this.checkItemDOS = checkItemDOS;
	}
}
