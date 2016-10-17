/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.soa.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuga.common.persistence.DataEntity;

/**
 * 接口管理Entity
 * @author 曾康
 * @version 2016-01-16
 */
public class InterfaceMgr extends DataEntity<InterfaceMgr> {
	
	private static final long serialVersionUID = 1L;
	private String type;		// 接口类型
	private String enable;		// 是否启用
	private String url;		// 接口地址
	private String comment;		// 备注信息
	private Date starttime;		// 有效开始时间
	private Date endtime;		// 结束时间
	
	public InterfaceMgr() {
		super();
	}

	public InterfaceMgr(String id){
		super(id);
	}

	@Length(min=0, max=10, message="接口类型长度必须介于 0 和 10 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=500, message="备注信息长度必须介于 0 和 500 之间")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Length(min=0, max=11, message="是否启用长度必须介于 0 和 11 之间")
	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	@Length(min=0, max=255, message="接口地址长度必须介于 0 和 255 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
}