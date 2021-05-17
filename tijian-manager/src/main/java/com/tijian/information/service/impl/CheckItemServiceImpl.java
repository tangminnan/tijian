package com.tijian.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tijian.information.dao.CheckItemDao;
import com.tijian.information.domain.CheckItemDO;
import com.tijian.information.service.CheckItemService;



@Service
public class CheckItemServiceImpl implements CheckItemService {
	@Autowired
	private CheckItemDao checkItemDao;
	
	@Override
	public CheckItemDO get(Long id){
		return checkItemDao.get(id);
	}
	
	@Override
	public List<CheckItemDO> list(Map<String, Object> map){
		return checkItemDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return checkItemDao.count(map);
	}
	
	@Override
	public int save(CheckItemDO checkItem){
		return checkItemDao.save(checkItem);
	}
	
	@Override
	public int update(CheckItemDO checkItem){
		return checkItemDao.update(checkItem);
	}
	
	@Override
	public int remove(Long id){
		return checkItemDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return checkItemDao.batchRemove(ids);
	}

	@Override
	public CheckItemDO getSub(Long id) {
		return checkItemDao.getSub(id);
	}

	@Override
	public void removeByParentId(Long id) {
		checkItemDao.removeByParentId(id);
	}

}
