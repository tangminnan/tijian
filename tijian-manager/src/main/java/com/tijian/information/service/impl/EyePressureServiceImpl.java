package com.tijian.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tijian.information.dao.EyePressureDao;
import com.tijian.information.domain.EyePressureDO;
import com.tijian.information.service.EyePressureService;



@Service
public class EyePressureServiceImpl implements EyePressureService {
	@Autowired
	private EyePressureDao eyePressureDao;
	
	@Override
	public EyePressureDO get(Integer id){
		return eyePressureDao.get(id);
	}
	
	@Override
	public List<EyePressureDO> list(Map<String, Object> map){
		return eyePressureDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return eyePressureDao.count(map);
	}
	
	@Override
	public int save(EyePressureDO eyePressure){
		return eyePressureDao.save(eyePressure);
	}
	
	@Override
	public int update(EyePressureDO eyePressure){
		return eyePressureDao.update(eyePressure);
	}
	
	@Override
	public int remove(Integer id){
		return eyePressureDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return eyePressureDao.batchRemove(ids);
	}
	
}
