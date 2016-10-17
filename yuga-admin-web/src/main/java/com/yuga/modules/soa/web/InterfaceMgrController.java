/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.soa.web;

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
import com.yuga.common.utils.CacheUtils;
import com.yuga.common.utils.StringUtils;
import com.yuga.common.web.BaseController;
import com.yuga.modules.route.service.CompanyRouteService;
import com.yuga.modules.soa.entity.InterfaceMgr;
import com.yuga.modules.soa.service.APIMgrService;
import com.yuga.modules.sys.interceptor.APIInterceptor;

/**
 * 接口管理Controller
 * @author 曾康
 * @version 2016-01-16
 */
@Controller
@RequestMapping(value = "${adminPath}/soa/interfaceMgr")
public class InterfaceMgrController extends BaseController {

	@Autowired
	private APIMgrService interfaceMgrService;
	
	@ModelAttribute
	public InterfaceMgr get(@RequestParam(required=false) String id) {
		InterfaceMgr entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = interfaceMgrService.get(id);
		}
		if (entity == null){
			entity = new InterfaceMgr();
		}
		return entity;
	}
	
	@RequiresPermissions("soa:interfaceMgr:view")
	@RequestMapping(value = {"list", ""})
	public String list(InterfaceMgr interfaceMgr, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<InterfaceMgr> page = interfaceMgrService.findPage(new Page<InterfaceMgr>(request, response), interfaceMgr); 
		model.addAttribute("page", page);
		return "modules/soa/interfaceMgrList";
	}

	@RequiresPermissions("soa:interfaceMgr:edit")
	@RequestMapping(value = {"refresh"})
	@ResponseBody
	public String refreshAPICache(){
		interfaceMgrService.refreshCache();
		return "ok";
	}
	
	@RequiresPermissions("soa:interfaceMgr:view")
	@RequestMapping(value = "form")
	public String form(InterfaceMgr interfaceMgr, Model model) {
		model.addAttribute("interfaceMgr", interfaceMgr);
		return "modules/soa/interfaceMgrForm";
	}

	@RequiresPermissions("soa:interfaceMgr:edit")
	@RequestMapping(value = "save")
	public String save(InterfaceMgr interfaceMgr, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, interfaceMgr)){
			return form(interfaceMgr, model);
		}
		interfaceMgrService.save(interfaceMgr);
		addMessage(redirectAttributes, "保存接口成功");		
		return "redirect:"+Global.getAdminPath()+"/soa/interfaceMgr/?repage";
	}
	
	@RequiresPermissions("soa:interfaceMgr:edit")
	@RequestMapping(value = "enable")
	public String enable(String id, String enable, Model model, RedirectAttributes redirectAttributes) {		
		interfaceMgrService.setEnable(id, enable);
		addMessage(redirectAttributes, "设置成功");		
		return "redirect:"+Global.getAdminPath()+"/soa/interfaceMgr/?repage";
	}
	
	@RequiresPermissions("soa:interfaceMgr:edit")
	@RequestMapping(value = "delete")
	public String delete(InterfaceMgr interfaceMgr, RedirectAttributes redirectAttributes) {
		interfaceMgrService.delete(interfaceMgr);
		addMessage(redirectAttributes, "删除接口成功");
		return "redirect:"+Global.getAdminPath()+"/soa/interfaceMgr/?repage";
	}

}