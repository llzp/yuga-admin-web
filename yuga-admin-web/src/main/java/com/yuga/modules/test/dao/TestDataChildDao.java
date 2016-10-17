/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.test.dao;

import com.yuga.common.persistence.CrudDao;
import com.yuga.common.persistence.annotation.MyBatisDao;
import com.yuga.modules.test.entity.TestDataChild;

/**
 * 一对多DAO接口
 * @author 测试
 * @version 2016-03-31
 */
@MyBatisDao
public interface TestDataChildDao extends CrudDao<TestDataChild> {
	
}