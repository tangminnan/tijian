package com.tijian.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tijian.information.dao.BloodPressureDao;
import com.tijian.information.domain.BloodPressureDO;
import com.tijian.information.service.BloodPressureService;



@Service
public class BloodPressureServiceImpl implements BloodPressureService {
	@Autowired
	private BloodPressureDao bloodPressureDao;
	
	@Override
	public BloodPressureDO get(Long id){
		return bloodPressureDao.get(id);
	}
	
	@Override
	public List<BloodPressureDO> list(Map<String, Object> map){
		return bloodPressureDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bloodPressureDao.count(map);
	}
	
	@Override
	public int save(BloodPressureDO bloodPressure){
		return bloodPressureDao.save(bloodPressure);
	}
	
	@Override
	public int update(BloodPressureDO bloodPressure){
		return bloodPressureDao.update(bloodPressure);
	}
	
	@Override
	public int remove(Long id){
		return bloodPressureDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return bloodPressureDao.batchRemove(ids);
	}
	
}
