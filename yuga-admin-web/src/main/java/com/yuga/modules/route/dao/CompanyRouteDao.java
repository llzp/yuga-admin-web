/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.route.dao;

import com.yuga.common.persistence.CrudDao;
import com.yuga.common.persistence.annotation.MyBatisDao;
import com.yuga.modules.route.entity.CompanyRoute;

/**
 * 软路由DAO接口
 * @author zengk
 * @version 2016-01-15
 */
@MyBatisDao
public interface CompanyRouteDao extends CrudDao<CompanyRoute> {
	public int selectBrandId(String brandId);
	public CompanyRoute getByBrandId(String brandId);
}