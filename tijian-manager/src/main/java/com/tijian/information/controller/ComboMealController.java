package com.tijian.information.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tijian.common.utils.PageUtils;
import com.tijian.common.utils.Query;
import com.tijian.common.utils.R;
import com.tijian.information.domain.CheckItemDO;
import com.tijian.information.service.CheckItemService;
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

import com.tijian.information.domain.ComboMealDO;
import com.tijian.information.service.ComboMealService;

/**
 * 套餐表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-24 15:40:43
 */
 
@Controller
@RequestMapping("/information/comboMeal")
public class ComboMealController {
	@Autowired
	private ComboMealService comboMealService;
	@Autowired
	private CheckItemService checkItemService;
	
	@GetMapping()
	@RequiresPermissions("information:comboMeal:comboMeal")
	String ComboMeal(){
	    return "information/comboMeal/comboMeal";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:comboMeal:comboMeal")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ComboMealDO> comboMealList = comboMealService.list(query);
		int total = comboMealService.count(query);
		PageUtils pageUtils = new PageUtils(comboMealList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:comboMeal:add")
	String add(Model model){
		Map<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("parentId",0);
		List<CheckItemDO> singleCheckDOS=checkItemService.list(paramsMap);
		model.addAttribute("singleCheckDOS",singleCheckDOS);
	    return "information/comboMeal/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:comboMeal:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ComboMealDO comboMeal = comboMealService.get(id);
		model.addAttribute("comboMeal", comboMeal);
		Map<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("parentId",0);
		List<CheckItemDO> singleCheckDOS=checkItemService.list(paramsMap);
		model.addAttribute("singleCheckDOS",singleCheckDOS);
	    return "information/comboMeal/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:comboMeal:add")
	public R save(ComboMealDO comboMeal){
		comboMeal.setComboCode(comboMeal.getComboCode().trim());
		comboMeal.setComboName(comboMeal.getComboName().trim());
		Map<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("comboCode",comboMeal.getComboCode());
		List<ComboMealDO> list = comboMealService.list(paramsMap);
		if(list.size()>0)
			return R.error("套餐代码已存在");
		paramsMap.remove("comboCode");
		paramsMap.put("comboName",comboMeal.getComboName());
		list = comboMealService.list(paramsMap);
		if(list.size()>0)
			return R.error("套餐名称已存在");
		comboMeal.setAddTime(new Date());
		comboMeal.setDeleteFlag(0);
		if(comboMealService.save(comboMeal)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:comboMeal:edit")
	public R update( ComboMealDO comboMeal){
		comboMeal.setComboCode(comboMeal.getComboCode().trim());
		comboMeal.setComboName(comboMeal.getComboName().trim());
		Map<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("comboCode",comboMeal.getComboCode());
		List<ComboMealDO> list = comboMealService.list(paramsMap);
		for(ComboMealDO c :list){
			if(c.getId()!=comboMeal.getId())
				return R.error("套餐代码已存在");
		}
		paramsMap.remove("comboCode");
		paramsMap.put("comboName",comboMeal.getComboName());
		list = comboMealService.list(paramsMap);
		for(ComboMealDO c :list){
			if(c.getId()!=comboMeal.getId())
				return R.error("套餐名称已存在");
		}

		comboMealService.update(comboMeal);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:comboMeal:remove")
	public R remove( Long id){
		if(comboMealService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:comboMeal:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		comboMealService.batchRemove(ids);
		return R.ok();
	}
	
}
