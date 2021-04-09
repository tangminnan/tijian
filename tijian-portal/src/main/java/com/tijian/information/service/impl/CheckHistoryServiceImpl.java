package com.tijian.information.service.impl;

import com.tijian.information.dao.CheckHistoryDao;
import com.tijian.information.domain.CheckHistoryDO;
import com.tijian.information.service.CheckHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CheckHistoryServiceImpl implements CheckHistoryService {
	@Autowired
	private CheckHistoryDao checkHistoryDao;
	
	@Override
	public CheckHistoryDO get(Long id){
		return checkHistoryDao.get(id);
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
	public CheckHistoryDO getByIdentityCard(String identityCard) {
		return checkHistoryDao.getByIdentityCard(identityCard);
	}

	@Override
	public CheckHistoryDO getByUserId(Long userId) {
		return checkHistoryDao.getByUserId(userId);
	}

}
