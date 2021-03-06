package com.tijian.system.controller;

import com.tijian.information.domain.CheckItemDO;
import com.tijian.information.domain.ComboMealDO;
import com.tijian.information.domain.SingleCheckDO;
import com.tijian.information.service.CheckItemService;
import com.tijian.information.service.ComboMealService;
import com.tijian.information.service.SingleCheckService;
import io.swagger.models.auth.In;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tijian.common.annotation.Log;
import com.tijian.common.controller.BaseController;
import com.tijian.common.domain.FileDO;
import com.tijian.common.domain.Tree;
import com.tijian.common.service.FileService;
import com.tijian.common.utils.MD5Utils;
import com.tijian.common.utils.R;
import com.tijian.common.utils.ShiroUtils;
import com.tijian.system.domain.MenuDO;
import com.tijian.system.service.MenuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MenuService menuService;
	@Autowired
	FileService fileService;
	@Autowired
	private ComboMealService comboMealService;
	@Autowired
	private CheckItemService checkItemService;
	@GetMapping({ "/", "" })
	String welcome(Model model) {

		return "redirect:/login";
	}

	@Log("请求访问主页")
	@GetMapping({ "/index" })
	String index(Model model) {
		List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
		model.addAttribute("menus", menus);
		model.addAttribute("name", getUser().getName());
		FileDO fileDO = fileService.get(getUser().getPicId());
		if(fileDO!=null&&fileDO.getUrl()!=null){
			if(fileService.isExist(fileDO.getUrl())){
				model.addAttribute("picUrl",fileDO.getUrl());
			}else {
				model.addAttribute("picUrl","/img/xinshinengn.png");
			}
		}else {
			model.addAttribute("picUrl","/img/photo_s.jpg");
		}
		model.addAttribute("username", getUser().getUsername());
		return "index_v1";
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}

	@Log("登录")
	@PostMapping("/login")
	@ResponseBody
	R ajaxLogin(String username, String password) {

		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return R.ok();
		} catch (AuthenticationException e) {
			return R.error("用户或密码错误");
		}
	}

	@GetMapping("/logout")
	String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}

	@GetMapping("/main")
	String main(Model model) {
		List<ComboMealDO> comboMealDOS = comboMealService.list(new HashMap<>());
		model.addAttribute("comboMealDOS",comboMealDOS);
		Map<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("parentId",0);
		List<CheckItemDO> singleCheckDOS=checkItemService.list(paramsMap);
		model.addAttribute("singleCheckDOS",singleCheckDOS);
		return "main";
	}

}
