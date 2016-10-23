/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.school.dao.checker;

import com.yuga.common.persistence.CrudDao;
import com.yuga.common.persistence.annotation.MyBatisDao;
import com.yuga.modules.school.entity.checker.YgClassCheck;

/**
 * 巡查情况DAO接口
 * @author 曾康
 * @version 2016-10-23
 */
@MyBatisDao
public interface YgClassCheckDao extends CrudDao<YgClassCheck> {
	
}