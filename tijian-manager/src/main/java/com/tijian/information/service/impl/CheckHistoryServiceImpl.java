package com.tijian.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tijian.information.dao.CheckHistoryDao;
import com.tijian.information.domain.CheckHistoryDO;
import com.tijian.information.service.CheckHistoryService;



@Service
public class CheckHistoryServiceImpl implements CheckHistoryService {
	@Autowired
	private CheckHistoryDao checkHistoryDao;
	
	@Override
	public CheckHistoryDO get(Long id){
		return checkHistoryDao.get(id);
	}
	
	@Override
	public List<CheckHistoryDO> list(Map<String, Object> map){
		return checkHistoryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return checkHistoryDao.count(map);
	}
	
	@Override
	public int save(CheckHistoryDO checkHistory){
		return checkHistoryDao.save(checkHistory);
	}
	
	@Override
	public int update(CheckHistoryDO checkHistory){
		return checkHistoryDao.update(checkHistory);
	}
	
	@Override
	public int remove(Long id){
		return checkHistoryDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return checkHistoryDao.batchRemove(ids);
	}

	@Override
	public CheckHistoryDO getByIdentityCard(String identityCard) {
		return checkHistoryDao.getByIdentityCard(identityCard);
	}

}
