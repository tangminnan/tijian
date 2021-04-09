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
	public int save(HeightweightDO heightweight){
		return heightweightDao.save(heightweight);
	}
	
	@Override
	public int update(HeightweightDO heightweight){
		return heightweightDao.update(heightweight);
	}

}
