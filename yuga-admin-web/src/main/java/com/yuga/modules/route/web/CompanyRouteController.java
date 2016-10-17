/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.route.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yuga.common.config.Global;
import com.yuga.common.persistence.Page;
import com.yuga.common.utils.StringUtils;
import com.yuga.common.web.BaseController;
import com.yuga.modules.route.entity.CompanyRoute;
import com.yuga.modules.route.service.CompanyRouteService;

/**
 * 品牌IDController
 * @author zengk
 * @version 2016-01-15
 */
@Controller
@RequestMapping(value = "${adminPath}/route/")
public class CompanyRouteController extends BaseController {

	@Autowired
	private CompanyRouteService routeService;
	
	@ModelAttribute
	public CompanyRoute get(@RequestParam(required=false) String id) {
		CompanyRoute entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = routeService.get(id);
		}
		if (entity == null){
			entity = new CompanyRoute();
		}
		return entity;
	}
	
	@RequiresPermissions("route:companyRoute:view")
	@RequestMapping(value = {"list", ""})
	public String list(CompanyRoute companyRoute, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CompanyRoute> page = routeService.findPage(new Page<CompanyRoute>(request, response), companyRoute); 
		model.addAttribute("page", page);
		return "modules/route/companyRouteList";
	}

	/**
	 * 创建品牌ID
	 * @return
	 */
	@RequiresPermissions("route:companyRoute:view")
	@RequestMapping(value = "brandId")
	@ResponseBody
	public String createBrandId() {
		return routeService.generateBrandId();
	}
	
	@RequiresPermissions("route:companyRoute:view")
	@RequestMapping(value = "form")
	public String form(CompanyRoute companyRoute, Model model) {
		model.addAttribute("companyRoute", companyRoute);
		return "modules/route/companyRouteForm";
	}

	@RequiresPermissions("route:companyRoute:edit")
	@RequestMapping(value = "save")
	public String save(HttpServletRequest request, CompanyRoute companyRoute, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, companyRoute)){
			return form(companyRoute, model);
		}	
		routeService.save(companyRoute);
		addMessage(redirectAttributes, "保存品牌ID成功");
		return "redirect:"+Global.getAdminPath()+"/route/?repage";
	}
	
	@RequiresPermissions("route:companyRoute:edit")
	@RequestMapping(value = "delete")
	public String delete(CompanyRoute companyRoute, RedirectAttributes redirectAttributes) {
		routeService.delete(companyRoute);
		addMessage(redirectAttributes, "删除品牌ID成功");
		return "redirect:"+Global.getAdminPath()+"/route/?repage";
	}

}