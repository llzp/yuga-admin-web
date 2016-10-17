/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.soa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuga.common.persistence.Page;
import com.yuga.common.service.CrudService;
import com.yuga.common.utils.CacheUtils;
import com.yuga.modules.route.service.CompanyRouteService;
import com.yuga.modules.soa.dao.InterfaceMgrDao;
import com.yuga.modules.soa.entity.InterfaceMgr;
import com.yuga.modules.sys.interceptor.APIInterceptor;

/**
 * 接口管理Service
 * @author 曾康
 * @version 2016-01-16
 */
@Service
@Transactional(readOnly = true)
public class APIMgrService extends CrudService<InterfaceMgrDao, InterfaceMgr> {
	
	private static Logger log = LoggerFactory.getLogger(APIMgrService.class);
		
	@Autowired
	private InterfaceMgrDao mgrDao;
	
	public InterfaceMgr get(String id) {
		return super.get(id);
	}
	
	/**
	 * 清除缓存
	 */
	public void refreshCache(){
		CacheUtils.removeAll(APIInterceptor.CACHE_INTERFACE_MGR);
		CacheUtils.removeAll(CompanyRouteService.CACHE_COMPANY_BRAND);
		log.info("刷新缓存完毕");
	}
	
	public void setEnable(String id, String enable){
		mgrDao.updateEnable(id, enable);
	}
	
	public List<InterfaceMgr> findList(InterfaceMgr interfaceMgr) {
		return super.findList(interfaceMgr);
	}
	
	public List<InterfaceMgr> findAllList(){
		return mgrDao.findAllList(null);
	}
	
	public Page<InterfaceMgr> findPage(Page<InterfaceMgr> page, InterfaceMgr interfaceMgr) {
		return super.findPage(page, interfaceMgr);
	}
	
	@Transactional(readOnly = false)
	public void save(InterfaceMgr interfaceMgr) {
		super.save(interfaceMgr);
	}
	
	@Transactional(readOnly = false)
	public void delete(InterfaceMgr interfaceMgr) {
		super.delete(interfaceMgr);
	}
	
}