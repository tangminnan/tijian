package com.tijian.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tijian.information.dao.SingleCheckDao;
import com.tijian.information.domain.SingleCheckDO;
import com.tijian.information.service.SingleCheckService;



@Service
public class SingleCheckServiceImpl implements SingleCheckService {
	@Autowired
	private SingleCheckDao singleCheckDao;
	
	@Override
	public SingleCheckDO get(Long id){
		return singleCheckDao.get(id);
	}
	
	@Override
	public List<SingleCheckDO> list(Map<String, Object> map){
		return singleCheckDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return singleCheckDao.count(map);
	}
	
	@Override
	public int save(SingleCheckDO singleCheck){
		return singleCheckDao.save(singleCheck);
	}
	
	@Override
	public int update(SingleCheckDO singleCheck){
		return singleCheckDao.update(singleCheck);
	}
	
	@Override
	public int remove(Long id){
		return singleCheckDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return singleCheckDao.batchRemove(ids);
	}
	
}
