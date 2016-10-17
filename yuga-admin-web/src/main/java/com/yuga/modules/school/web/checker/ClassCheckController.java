/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.school.web.checker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yuga.common.config.Global;
import com.yuga.common.persistence.Page;
import com.yuga.common.web.BaseController;
import com.yuga.common.utils.StringUtils;
import com.yuga.modules.school.entity.checker.ClassCheck;
import com.yuga.modules.school.service.checker.ClassCheckService;

/**
 * 巡查信息Controller
 * @author 曾康
 * @version 2016-10-17
 */
@Controller
@RequestMapping(value = "${adminPath}/school/checker/classCheck")
public class ClassCheckController extends BaseController {

	@Autowired
	private ClassCheckService classCheckService;
	
	@ModelAttribute
	public ClassCheck get(@RequestParam(required=false) String id) {
		ClassCheck entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = classCheckService.get(id);
		}
		if (entity == null){
			entity = new ClassCheck();
		}
		return entity;
	}
	
	@RequiresPermissions("school:checker:classCheck:view")
	@RequestMapping(value = {"list", ""})
	public String list(ClassCheck classCheck, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ClassCheck> page = classCheckService.findPage(new Page<ClassCheck>(request, response), classCheck); 
		model.addAttribute("page", page);
		return "modules/school/checker/classCheckList";
	}

	@RequiresPermissions("school:checker:classCheck:view")
	@RequestMapping(value = "form")
	public String form(ClassCheck classCheck, Model model) {
		model.addAttribute("classCheck", classCheck);
		return "modules/school/checker/classCheckForm";
	}

	@RequiresPermissions("school:checker:classCheck:edit")
	@RequestMapping(value = "save")
	public String save(ClassCheck classCheck, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, classCheck)){
			return form(classCheck, model);
		}
		classCheckService.save(classCheck);
		addMessage(redirectAttributes, "保存巡查信息成功");
		return "redirect:"+Global.getAdminPath()+"/school/checker/classCheck/?repage";
	}
	
	@RequiresPermissions("school:checker:classCheck:edit")
	@RequestMapping(value = "delete")
	public String delete(ClassCheck classCheck, RedirectAttributes redirectAttributes) {
		classCheckService.delete(classCheck);
		addMessage(redirectAttributes, "删除巡查信息成功");
		return "redirect:"+Global.getAdminPath()+"/school/checker/classCheck/?repage";
	}

}