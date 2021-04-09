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

import com.tijian.information.domain.BloodPressureDO;
import com.tijian.information.service.BloodPressureService;

/**
 * 血压检查
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 11:22:58
 */
 
@Controller
@RequestMapping("/information/bloodPressure")
public class BloodPressureController {
	@Autowired
	private BloodPressureService bloodPressureService;
	
	@GetMapping()
	@RequiresPermissions("information:bloodPressure:bloodPressure")
	String BloodPressure(){
	    return "information/bloodPressure/bloodPressure";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:bloodPressure:bloodPressure")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BloodPressureDO> bloodPressureList = bloodPressureService.list(query);
		int total = bloodPressureService.count(query);
		PageUtils pageUtils = new PageUtils(bloodPressureList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:bloodPressure:add")
	String add(){
	    return "information/bloodPressure/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:bloodPressure:edit")
	String edit(@PathVariable("id") Long id,Model model){
		BloodPressureDO bloodPressure = bloodPressureService.get(id);
		model.addAttribute("bloodPressure", bloodPressure);
	    return "information/bloodPressure/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:bloodPressure:add")
	public R save( BloodPressureDO bloodPressure){
		if(bloodPressureService.save(bloodPressure)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:bloodPressure:edit")
	public R update( BloodPressureDO bloodPressure){
		bloodPressureService.update(bloodPressure);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:bloodPressure:remove")
	public R remove( Long id){
		if(bloodPressureService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:bloodPressure:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		bloodPressureService.batchRemove(ids);
		return R.ok();
	}
	
}
