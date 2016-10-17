/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.route.entity;

import org.hibernate.validator.constraints.Length;

import com.yuga.common.persistence.DataEntity;

/**
 * 软路由Entity
 * 
 * @author zengk
 * @version 2016-01-15
 */
public class CompanyRoute extends DataEntity<CompanyRoute> {

	private static final long serialVersionUID = 1L;
	private String logo; // logo地址
	private String subtitle; // 显示子标题
	private String version; // 版本号
	private String ipaddr; // 转发IP
	private String comment; // 备注信息
	private String brandId; // 品牌ID
	private String enable; // 是否启用
	private String enableSyncERP; // 是否同步ERP
	private String extraConfig;//额外配置，用json数据节点
	public CompanyRoute() {
		super();
	}
	public String getExtraConfig() {
		return extraConfig;
	}

	public void setExtraConfig(String extraConfig) {
		this.extraConfig = extraConfig;
	}

	public String getEnableSyncERP() {
		return enableSyncERP;
	}

	public void setEnableSyncERP(String enableSyncERP) {
		this.enableSyncERP = enableSyncERP;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public CompanyRoute(String id) {
		super(id);
	}

	@Length(min = 0, max = 4, message = "logo地址长度必须介于 0 和4 之间")
	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	@Length(min = 0, max = 500, message = "logo地址长度必须介于 0 和 500 之间")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Length(min = 0, max = 30, message = "显示子标题长度必须介于 0 和 30 之间")
	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@Length(min = 0, max = 10, message = "版本号长度必须介于 0 和 10 之间")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Length(min = 0, max = 30, message = "转发IP长度必须介于 0 和 30 之间")
	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	@Length(min = 0, max = 255, message = "备注信息长度必须介于 0 和 255 之间")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}