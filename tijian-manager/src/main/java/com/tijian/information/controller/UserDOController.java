package com.tijian.information.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tijian.common.utils.PageUtils;
import com.tijian.common.utils.Query;
import com.tijian.common.utils.R;
import com.tijian.common.utils.xss.BarCodeUtils;
import com.tijian.information.domain.UserDO;
import com.tijian.information.service.UserDOService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 用户信息表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-24 10:38:50
 */
 
@Controller
@RequestMapping("/information/user")
public class UserDOController {
	@Autowired
	private UserDOService userService;
	
	@GetMapping()
	@RequiresPermissions("information:user:user")
	String User(){
	    return "information/user/user";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:user:user")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserDO> userList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:user:add")
	String add(){
	    return "information/user/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:user:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UserDO user = userService.get(id);
		model.addAttribute("user", user);
	    return "information/user/edit";
	}

	@ResponseBody
	@GetMapping("/getUserInfo")
	public Map<String,Object> getUserInfo(String identityCard){
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("identityCard",identityCard.trim());
		List<UserDO> userDOS = userService.list(paramsMap);
		Map<String,Object> map = new HashMap<>();
		if(userDOS.size()>0){
			map.put("code",0);
			map.put("userDO",userDOS.get(0));
		}else{
			map.put("code",-1);
			map.put("userDO",null);
		}
		return map;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:user:add")
	public R save( UserDO user){
		user.setIdentityCard(user.getIdentityCard().trim());
		user.setPhone(user.getPhone().trim());
		Map<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("identityCard",user.getIdentityCard());
		List<UserDO> list = userService.list(paramsMap);
		if(list.size()>0)
			return R.error("身份证号已存在");
		paramsMap.remove("identityCard");
		paramsMap.put("phone",user.getPhone());
		list = userService.list(paramsMap);
		if(list.size()>0)
			return R.error("手机号已存在");
		user.setAddTime(new Date());
		if(userService.save(user)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:user:edit")
	public R update( UserDO user){
		user.setPhone(user.getPhone().trim());
		Map<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("phone",user.getPhone());
		List<UserDO> list = userService.list(paramsMap);
		for(UserDO userDO:list){
			if(!userDO.getIdentityCard().equals(user.getIdentityCard())){
				return R.error("手机号已存在");
			}
		}
		userService.update(user);
		return R.ok();
	}

	/**
	 *  批量导入检查项
	 * @return
	 */
	@GetMapping("importcheck")
	public String importcheck(Model model){
		return "/information/user/importcheck";
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:user:remove")
	public R remove( Long id){
		if(userService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:user:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userService.batchRemove(ids);
		return R.ok();
	}

	@GetMapping("/erweima/{id}")
	public String erweima(@PathVariable("id") Long id,Model model){
        UserDO userDO = userService.get(id);
        model.addAttribute("userDO",userDO);
		String code = BarCodeUtils.generateBarCode128(id.toString(), 10.0, 0.3, true, true);//条形码
		model.addAttribute("QRCode","data:image/png;base64,"+code);
		return "/information/user/TxCode";
	}
	
}
