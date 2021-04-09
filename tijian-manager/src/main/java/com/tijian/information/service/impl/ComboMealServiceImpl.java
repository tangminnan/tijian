package com.tijian.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tijian.information.dao.ComboMealDao;
import com.tijian.information.domain.ComboMealDO;
import com.tijian.information.service.ComboMealService;



@Service
public class ComboMealServiceImpl implements ComboMealService {
	@Autowired
	private ComboMealDao comboMealDao;
	
	@Override
	public ComboMealDO get(Long id){
		return comboMealDao.get(id);
	}
	
	@Override
	public List<ComboMealDO> list(Map<String, Object> map){
		return comboMealDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return comboMealDao.count(map);
	}
	
	@Override
	public int save(ComboMealDO comboMeal){
		return comboMealDao.save(comboMeal);
	}
	
	@Override
	public int update(ComboMealDO comboMeal){
		return comboMealDao.update(comboMeal);
	}
	
	@Override
	public int remove(Long id){
		return comboMealDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return comboMealDao.batchRemove(ids);
	}
	
}
