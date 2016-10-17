/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.route.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuga.common.persistence.Page;
import com.yuga.common.service.CrudService;
import com.yuga.common.utils.CacheUtils;
import com.yuga.modules.route.dao.CompanyRouteDao;
import com.yuga.modules.route.entity.CompanyRoute;
import com.yuga.modules.route.utils.StringUtil;

/**
 * 软路由Service
 * @author zengk
 * @version 2016-01-15
 */
@Service
@Transactional(readOnly = true)
public class CompanyRouteService extends CrudService<CompanyRouteDao, CompanyRoute> {

	@Autowired
	CompanyRouteDao routeDao;
	
	final public static String CACHE_COMPANY_BRAND = "CACHE_COMPANY_BRAND";
	
	public CompanyRoute get(String id) {
		return super.get(id);
	}
	
	public CompanyRoute getByBrandId(String brandId) {
		CompanyRoute route = (CompanyRoute) CacheUtils.get(CACHE_COMPANY_BRAND, brandId);
		//放入缓存中
		if(route == null){
			route = routeDao.getByBrandId(brandId);
			CacheUtils.put(CACHE_COMPANY_BRAND, brandId, route);
		}
		return route;
	}
	public List<CompanyRoute> findList(CompanyRoute companyRoute) {
		return super.findList(companyRoute);
	}
	
	public Page<CompanyRoute> findPage(Page<CompanyRoute> page, CompanyRoute companyRoute) {
		return super.findPage(page, companyRoute);
	}
	
	@Transactional(readOnly = false)
	public void save(CompanyRoute companyRoute) {
		super.save(companyRoute);
	}
	
	@Transactional(readOnly = false)
	public void delete(CompanyRoute companyRoute) {
		super.delete(companyRoute);
	}
	
	/**
	 * 创建品牌ID
	 * @param brandId
	 * @return
	 */
	public String generateBrandId(){
		String brandId = StringUtil.createBrandId();
		int count = routeDao.selectBrandId(brandId);
		while(count > 0){
			count = routeDao.selectBrandId(brandId);
			brandId = StringUtil.createBrandId();
		}
		return brandId;
	}
	
}