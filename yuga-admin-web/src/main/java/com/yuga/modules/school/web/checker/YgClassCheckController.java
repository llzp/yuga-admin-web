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
import com.yuga.modules.school.entity.checker.YgClassCheck;
import com.yuga.modules.school.service.checker.YgClassCheckService;

/**
 * 巡查情况Controller
 * @author 曾康
 * @version 2016-10-23
 */
@Controller
@RequestMapping(value = "${adminPath}/school/checker/ygClassCheck")
public class YgClassCheckController extends BaseController {

	@Autowired
	private YgClassCheckService ygClassCheckService;
	
	@ModelAttribute
	public YgClassCheck get(@RequestParam(required=false) String id) {
		YgClassCheck entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ygClassCheckService.get(id);
		}
		if (entity == null){
			entity = new YgClassCheck();
		}
		return entity;
	}
	
	@RequiresPermissions("school:checker:ygClassCheck:view")
	@RequestMapping(value = {"list", ""})
	public String list(YgClassCheck ygClassCheck, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<YgClassCheck> page = ygClassCheckService.findPage(new Page<YgClassCheck>(request, response), ygClassCheck); 
		model.addAttribute("page", page);
		return "modules/school/checker/ygClassCheckList";
	}

	@RequiresPermissions("school:checker:ygClassCheck:view")
	@RequestMapping(value = "form")
	public String form(YgClassCheck ygClassCheck, Model model) {
		model.addAttribute("ygClassCheck", ygClassCheck);
		return "modules/school/checker/ygClassCheckForm";
	}

	@RequiresPermissions("school:checker:ygClassCheck:edit")
	@RequestMapping(value = "save")
	public String save(YgClassCheck ygClassCheck, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ygClassCheck)){
			return form(ygClassCheck, model);
		}
		ygClassCheckService.save(ygClassCheck);
		addMessage(redirectAttributes, "保存巡查情况成功");
		return "redirect:"+Global.getAdminPath()+"/school/checker/ygClassCheck/?repage";
	}
	
	@RequiresPermissions("school:checker:ygClassCheck:edit")
	@RequestMapping(value = "delete")
	public String delete(YgClassCheck ygClassCheck, RedirectAttributes redirectAttributes) {
		ygClassCheckService.delete(ygClassCheck);
		addMessage(redirectAttributes, "删除巡查情况成功");
		return "redirect:"+Global.getAdminPath()+"/school/checker/ygClassCheck/?repage";
	}

}