package com.tijian.information.controller;

import java.util.List;
import java.util.Map;

import com.tijian.common.utils.PageUtils;
import com.tijian.common.utils.Query;
import com.tijian.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tijian.information.domain.SingleCheckDO;
import com.tijian.information.service.SingleCheckService;


/**
 * 单项表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-24 14:41:14
 */
 
@Controller
@RequestMapping("/information/singleCheck")
public class SingleCheckController {
	@Autowired
	private SingleCheckService singleCheckService;
	
	@GetMapping()
	@RequiresPermissions("information:singleCheck:singleCheck")
	String SingleCheck(){
	    return "information/singleCheck/singleCheck";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:singleCheck:singleCheck")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SingleCheckDO> singleCheckList = singleCheckService.list(query);
		int total = singleCheckService.count(query);
		PageUtils pageUtils = new PageUtils(singleCheckList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:singleCheck:add")
	String add(){
	    return "information/singleCheck/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:singleCheck:edit")
	String edit(@PathVariable("id") Long id,Model model){
		SingleCheckDO singleCheck = singleCheckService.get(id);
		model.addAttribute("singleCheck", singleCheck);
	    return "information/singleCheck/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:singleCheck:add")
	public R save( SingleCheckDO singleCheck){
		if(singleCheckService.save(singleCheck)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:singleCheck:edit")
	public R update( SingleCheckDO singleCheck){
		singleCheckService.update(singleCheck);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:singleCheck:remove")
	public R remove( Long id){
		if(singleCheckService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:singleCheck:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		singleCheckService.batchRemove(ids);
		return R.ok();
	}

	/**
	 * 新增检查项目
	 * @return
	 */
	@GetMapping("/checkadd")
	public String checkadd(){
		return "information/singleCheck/checkadd";
	}
	
}
