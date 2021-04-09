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

import com.tijian.information.domain.OubaoDO;
import com.tijian.information.service.OubaoService;


/**
 * 欧宝检查
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 14:03:22
 */
 
@Controller
@RequestMapping("/information/oubao")
public class OubaoController {
	@Autowired
	private OubaoService oubaoService;
	
	@GetMapping()
	@RequiresPermissions("information:oubao:oubao")
	String Oubao(){
	    return "information/oubao/oubao";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:oubao:oubao")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OubaoDO> oubaoList = oubaoService.list(query);
		int total = oubaoService.count(query);
		PageUtils pageUtils = new PageUtils(oubaoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:oubao:add")
	String add(){
	    return "information/oubao/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:oubao:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		OubaoDO oubao = oubaoService.get(id);
		model.addAttribute("oubao", oubao);
	    return "information/oubao/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:oubao:add")
	public R save( OubaoDO oubao){
		if(oubaoService.save(oubao)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:oubao:edit")
	public R update( OubaoDO oubao){
		oubaoService.update(oubao);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:oubao:remove")
	public R remove( Integer id){
		if(oubaoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:oubao:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		oubaoService.batchRemove(ids);
		return R.ok();
	}
	
}
