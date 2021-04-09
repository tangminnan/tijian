package com.tijian.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tijian.information.dao.OubaoDao;
import com.tijian.information.domain.OubaoDO;
import com.tijian.information.service.OubaoService;



@Service
public class OubaoServiceImpl implements OubaoService {
	@Autowired
	private OubaoDao oubaoDao;
	
	@Override
	public OubaoDO get(Integer id){
		return oubaoDao.get(id);
	}
	

	

	
	@Override
	public int save(OubaoDO oubao){
		return oubaoDao.save(oubao);
	}
	
	@Override
	public int update(OubaoDO oubao){
		return oubaoDao.update(oubao);
	}
	

	
}
