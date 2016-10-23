/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.school.service.checker;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuga.common.persistence.Page;
import com.yuga.common.service.CrudService;
import com.yuga.modules.school.entity.checker.YgClassCheck;
import com.yuga.modules.school.dao.checker.YgClassCheckDao;

/**
 * 巡查情况Service
 * @author 曾康
 * @version 2016-10-23
 */
@Service
@Transactional(readOnly = true)
public class YgClassCheckService extends CrudService<YgClassCheckDao, YgClassCheck> {

	public YgClassCheck get(String id) {
		return super.get(id);
	}
	
	public List<YgClassCheck> findList(YgClassCheck ygClassCheck) {
		return super.findList(ygClassCheck);
	}
	
	public Page<YgClassCheck> findPage(Page<YgClassCheck> page, YgClassCheck ygClassCheck) {
		return super.findPage(page, ygClassCheck);
	}
	
	@Transactional(readOnly = false)
	public void save(YgClassCheck ygClassCheck) {
		super.save(ygClassCheck);
	}
	
	@Transactional(readOnly = false)
	public void delete(YgClassCheck ygClassCheck) {
		super.delete(ygClassCheck);
	}
	
}