package com.tijian.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tijian.information.dao.OctDao;
import com.tijian.information.domain.OctDO;
import com.tijian.information.service.OctService;



@Service
public class OctServiceImpl implements OctService {
	@Autowired
	private OctDao octDao;
	
	@Override
	public OctDO get(Integer id){
		return octDao.get(id);
	}
	

	

	
	@Override
	public int save(OctDO oct){
		return octDao.save(oct);
	}
	
	@Override
	public int update(OctDO oct){
		return octDao.update(oct);
	}
	

	
}
