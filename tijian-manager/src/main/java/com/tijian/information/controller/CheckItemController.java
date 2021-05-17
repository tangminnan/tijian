package com.tijian.information.controller;

import java.util.*;

import com.tijian.common.utils.PageUtils;
import com.tijian.common.utils.Query;
import com.tijian.common.utils.R;
import com.tijian.common.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tijian.information.domain.CheckItemDO;
import com.tijian.information.service.CheckItemService;
/**
 * 检查项目表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-04-21 11:18:40
 */
 
@Controller
@RequestMapping("/information/checkItem")
public class CheckItemController {
	@Autowired
	private CheckItemService checkItemService;
	
	@GetMapping()
	@RequiresPermissions("information:checkItem:checkItem")
	String CheckItem(){
	    return "information/checkItem/checkItem";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:checkItem:checkItem")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("parentId",0);
        Query query = new Query(params);
		List<CheckItemDO> checkItemList = checkItemService.list(query);
		int total = checkItemService.count(query);
		PageUtils pageUtils = new PageUtils(checkItemList, total);
		return pageUtils;
	}

	@ResponseBody
	@GetMapping("/listSub")
	@RequiresPermissions("information:checkItem:checkItem")
	public List<CheckItemDO> listSub(Long parentId){
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("parentId",parentId);
		List<CheckItemDO> checkItemList = checkItemService.list(paramsMap);
		return checkItemList;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:checkItem:add")
	String add(){
	    return "information/checkItem/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:checkItem:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CheckItemDO checkItem = checkItemService.get(id);
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("parentId",id);
		List<CheckItemDO> checkItemDOS = checkItemService.list(paramsMap);
		checkItem.setCheckItemDOS(checkItemDOS);
		model.addAttribute("checkItem", checkItem);
	    return "information/checkItem/edit";
	}


	@GetMapping("/editSub/{id}")
	@RequiresPermissions("information:checkItem:edit")
	String editSub(@PathVariable("id") Long id,Model model){
		CheckItemDO checkItem = checkItemService.getSub(id);
		model.addAttribute("checkItem", checkItem);
		return "information/checkItem/editSub";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:checkItem:add")
	@Transactional
	public R save( CheckItemDO checkItem){
		Map<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("parentItem",checkItem.getParentItem().trim());
		List<CheckItemDO> checkItemDOS = checkItemService.list(paramsMap);
		if(checkItemDOS.size()>0){
			return R.error(-1,"检查项目已经存在");
		}
		paramsMap.remove("parentItem");paramsMap.put("pin",checkItem.getPin().trim());
		checkItemDOS = checkItemService.list(paramsMap);
		if(checkItemDOS.size()>0){
			return R.error(-1,"拼音代码已经存在");
		}
		Set<String> set = new HashSet<>();
		for(String str :checkItem.getList()){
			if(StringUtils.isNotBlank(str))
				set.add(str.trim());
		}
		if(set.size()==0){
			return R.error(-1,"检查细项不能为空");
		}
        checkItem.setParentItem(checkItem.getParentItem().trim());
		checkItem.setPin(checkItem.getPin().trim());
		checkItem.setParentId(0L);
		checkItem.setDeleteFlag(0);
		checkItem.setAddTime(new Date());
		if(checkItemService.save(checkItem)>0){//保存检查项目
			for(String str :set){
				CheckItemDO checkItemDO = new CheckItemDO();
				checkItemDO.setParentId(checkItem.getId());
				checkItemDO.setAddTime(new Date());
				checkItemDO.setDeleteFlag(0);
				checkItemDO.setChildrenItem(str);
				checkItemService.save(checkItemDO);
			}
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:checkItem:edit")
	@Transactional
	public R update( CheckItemDO checkItem){
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("parentItem",checkItem.getParentItem().trim());
		List<CheckItemDO> checkItemDOS = checkItemService.list(paramsMap);
		for(CheckItemDO checkItemDO :checkItemDOS){
			if(checkItemDO.getId()!=checkItem.getId())
				return R.error(-1,"检查项目已经存在");
		}
		paramsMap.remove("parentItem");paramsMap.put("pin",checkItem.getPin().trim());
		checkItemDOS = checkItemService.list(paramsMap);
		for(CheckItemDO checkItemDO :checkItemDOS){
			if(checkItemDO.getId()!=checkItem.getId())
				return R.error(-1,"拼音代码已经存在");
		}
		Set<String> set = new HashSet<>();
		for(String str :checkItem.getList()){
			if(StringUtils.isNotBlank(str))
				set.add(str.trim());
		}
		if(set.size()==0){
			return R.error(-1,"检查细项不能为空");
		}
		checkItem.setParentItem(checkItem.getParentItem().trim());
		checkItem.setPin(checkItem.getPin().trim());
		if(checkItemService.update(checkItem)>0){
			checkItemService.removeByParentId(checkItem.getId());
			for(String str :set){
				CheckItemDO checkItemDO = new CheckItemDO();
				checkItemDO.setParentId(checkItem.getId());
				checkItemDO.setAddTime(new Date());
				checkItemDO.setDeleteFlag(0);
				checkItemDO.setChildrenItem(str);
				checkItemService.save(checkItemDO);
			}
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:checkItem:remove")
	public R remove( Long id){
		CheckItemDO checkItemDO = checkItemService.get(id);
		Long parentId = checkItemDO.getParentId();
		if(checkItemService.remove(id)>0){
			Map<String,Object> paramsMap = new HashMap<>();
			paramsMap.put("parentId",parentId);
			List<CheckItemDO> checkItemDOS = checkItemService.list(paramsMap);
			if(checkItemDOS.size()==0)
				checkItemService.remove(parentId);
		  return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:checkItem:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		checkItemService.batchRemove(ids);
		return R.ok();
	}
	
}
