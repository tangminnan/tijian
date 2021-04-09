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

import com.tijian.information.domain.HeightweightDO;
import com.tijian.information.service.HeightweightService;

/**
 * 身高体重表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 10:47:55
 */
 
@Controller
@RequestMapping("/information/heightweight")
public class HeightweightController {
	@Autowired
	private HeightweightService heightweightService;
	
	@GetMapping()
	@RequiresPermissions("information:heightweight:heightweight")
	String Heightweight(){
	    return "information/heightweight/heightweight";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:heightweight:heightweight")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<HeightweightDO> heightweightList = heightweightService.list(query);
		int total = heightweightService.count(query);
		PageUtils pageUtils = new PageUtils(heightweightList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:heightweight:add")
	String add(){
	    return "information/heightweight/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:heightweight:edit")
	String edit(@PathVariable("id") Long id,Model model){
		HeightweightDO heightweight = heightweightService.get(id);
		model.addAttribute("heightweight", heightweight);
	    return "information/heightweight/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:heightweight:add")
	public R save( HeightweightDO heightweight){
		if(heightweightService.save(heightweight)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:heightweight:edit")
	public R update( HeightweightDO heightweight){
		heightweightService.update(heightweight);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:heightweight:remove")
	public R remove( Long id){
		if(heightweightService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:heightweight:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		heightweightService.batchRemove(ids);
		return R.ok();
	}
	
}
