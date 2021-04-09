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
	public int save(EyePressureDO eyePressure){
		return eyePressureDao.save(eyePressure);
	}
	
	@Override
	public int update(EyePressureDO eyePressure){
		return eyePressureDao.update(eyePressure);
	}
	

}
