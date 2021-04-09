package com.tijian.information.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * OCT检查
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-04-07 13:52:19
 */
public class OctDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//用户id
	private Integer userId;
	//检查记录id
	private Integer checkId;
	//pdf文件路径
	private String pdf;
	//图片文件路径
	private String img;
	//原始文件路径
	private String original;
	//检查日期
	private Date addTime;
	//原始文件 图片形式
	private List<String> originalsimg = new ArrayList<>();
	//pdf文件 图片形式
	private List<String> pdfimg = new ArrayList<>();

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
	 * 设置：检查记录id
	 */
	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}
	/**
	 * 获取：检查记录id
	 */
	public Integer getCheckId() {
		return checkId;
	}
	/**
	 * 设置：pdf文件路径
	 */
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	/**
	 * 获取：pdf文件路径
	 */
	public String getPdf() {
		return pdf;
	}
	/**
	 * 设置：图片文件路径
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：图片文件路径
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：原始文件路径
	 */
	public void setOriginal(String original) {
		this.original = original;
	}
	/**
	 * 获取：原始文件路径
	 */
	public String getOriginal() {
		return original;
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

	public List<String> getOriginalsimg() {
		return originalsimg;
	}

	public void setOriginalsimg(List<String> originalsimg) {
		this.originalsimg = originalsimg;
	}

	public List<String> getPdfimg() {
		return pdfimg;
	}

	public void setPdfimg(List<String> pdfimg) {
		this.pdfimg = pdfimg;
	}
}
