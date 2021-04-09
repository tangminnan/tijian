package com.tijian.information.dao;

import com.tijian.information.domain.ComboMealDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 套餐表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-24 15:40:43
 */
@Mapper
public interface ComboMealDao {

	ComboMealDO get(Long id);
	
	List<ComboMealDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ComboMealDO comboMeal);
	
	int update(ComboMealDO comboMeal);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
