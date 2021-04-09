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

import com.tijian.information.domain.OctDO;
import com.tijian.information.service.OctService;


/**
 * OCT检查
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-04-07 13:52:19
 */
 
@Controller
@RequestMapping("/information/oct")
public class OctController {
	@Autowired
	private OctService octService;
	
	@GetMapping()
	@RequiresPermissions("information:oct:oct")
	String Oct(){
	    return "information/oct/oct";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:oct:oct")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OctDO> octList = octService.list(query);
		int total = octService.count(query);
		PageUtils pageUtils = new PageUtils(octList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:oct:add")
	String add(){
	    return "information/oct/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:oct:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		OctDO oct = octService.get(id);
		model.addAttribute("oct", oct);
	    return "information/oct/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:oct:add")
	public R save( OctDO oct){
		if(octService.save(oct)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:oct:edit")
	public R update( OctDO oct){
		octService.update(oct);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:oct:remove")
	public R remove( Integer id){
		if(octService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:oct:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		octService.batchRemove(ids);
		return R.ok();
	}
	
}
