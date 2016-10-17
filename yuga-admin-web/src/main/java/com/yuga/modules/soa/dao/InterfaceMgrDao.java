/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.soa.dao;

import com.yuga.common.persistence.CrudDao;
import com.yuga.common.persistence.annotation.MyBatisDao;
import com.yuga.modules.soa.entity.InterfaceMgr;

/**
 * 接口管理DAO接口
 * @author 曾康
 * @version 2016-01-16
 */
@MyBatisDao
public interface InterfaceMgrDao extends CrudDao<InterfaceMgr> {
	public void updateEnable(String id, String enable);
}