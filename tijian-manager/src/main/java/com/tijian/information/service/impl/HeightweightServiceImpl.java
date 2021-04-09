package com.tijian.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tijian.information.dao.HeightweightDao;
import com.tijian.information.domain.HeightweightDO;
import com.tijian.information.service.HeightweightService;



@Service
public class HeightweightServiceImpl implements HeightweightService {
	@Autowired
	private HeightweightDao heightweightDao;
	
	@Override
	public HeightweightDO get(Long id){
		return heightweightDao.get(id);
	}
	
	@Override
	public List<HeightweightDO> list(Map<String, Object> map){
		return heightweightDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return heightweightDao.count(map);
	}
	
	@Override
	public int save(HeightweightDO heightweight){
		return heightweightDao.save(heightweight);
	}
	
	@Override
	public int update(HeightweightDO heightweight){
		return heightweightDao.update(heightweight);
	}
	
	@Override
	public int remove(Long id){
		return heightweightDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return heightweightDao.batchRemove(ids);
	}
	
}
