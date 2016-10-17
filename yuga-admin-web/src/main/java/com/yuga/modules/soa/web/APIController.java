/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.soa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuga.common.entities.KsmDTO;
import com.yuga.common.utils.StringUtil;
import com.yuga.common.utils.message.KSMMessage;
import com.yuga.common.web.BaseController;
import com.yuga.modules.route.entity.CompanyRoute;
import com.yuga.modules.route.service.CompanyRouteService;

/**
 * 接口管理Controller
 * @author 曾康
 * @version 2016-01-16
 */
@Controller
@RequestMapping(value = "${adminPath}/api")
public class APIController extends BaseController {

	@Autowired
	private CompanyRouteService routeService;
	
	/**
	 * 创建品牌ID
	 * @return
	 */
	@RequestMapping(value = "brand")
	@ResponseBody
	public KsmDTO getCompanyBrand(HttpServletRequest request, HttpServletResponse response, String brandId) {		
		CompanyRoute route = routeService.getByBrandId(brandId);
		if(route != null) {
			String contextStr =  request.getContextPath();
			String requestURL = request.getRequestURL().toString(); 
			String url = requestURL.substring(0, requestURL.indexOf(contextStr));
			CompanyRoute newRoute = (CompanyRoute)route.clone();
			if(route.getLogo() != null){
				String logoURL = url + route.getLogo().replace("|", "");
				newRoute.setLogo(logoURL); 
				return new KsmDTO(newRoute);
			}			
		} 
		return new KsmDTO(KSMMessage.FAILED, "please config a company id.");
	}
}