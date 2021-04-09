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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tijian.information.domain.EyePressureDO;
import com.tijian.information.service.EyePressureService;
/**
 * 眼内压
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 11:49:19
 */
 
@Controller
@RequestMapping("/information/eyePressure")
public class EyePressureController {
	@Autowired
	private EyePressureService eyePressureService;
	
	@GetMapping()
	@RequiresPermissions("information:eyePressure:eyePressure")
	String EyePressure(){
	    return "information/eyePressure/eyePressure";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:eyePressure:eyePressure")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<EyePressureDO> eyePressureList = eyePressureService.list(query);
		int total = eyePressureService.count(query);
		PageUtils pageUtils = new PageUtils(eyePressureList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:eyePressure:add")
	String add(){
	    return "information/eyePressure/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:eyePressure:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		EyePressureDO eyePressure = eyePressureService.get(id);
		model.addAttribute("eyePressure", eyePressure);
	    return "information/eyePressure/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:eyePressure:add")
	public R save( EyePressureDO eyePressure){
		if(eyePressureService.save(eyePressure)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:eyePressure:edit")
	public R update( EyePressureDO eyePressure){
		eyePressureService.update(eyePressure);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:eyePressure:remove")
	public R remove( Integer id){
		if(eyePressureService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:eyePressure:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		eyePressureService.batchRemove(ids);
		return R.ok();
	}
	
}
