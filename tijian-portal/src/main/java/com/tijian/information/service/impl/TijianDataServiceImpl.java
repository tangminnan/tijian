package com.tijian.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tijian.information.dao.TijianDataDao;
import com.tijian.information.domain.TijianDataDO;
import com.tijian.information.service.TijianDataService;



@Service
public class TijianDataServiceImpl implements TijianDataService {
	@Autowired
	private TijianDataDao tijianDataDao;
	
	@Override
	public TijianDataDO get(Long id){
		return tijianDataDao.get(id);
	}
	
	@Override
	public List<TijianDataDO> list(Map<String, Object> map){
		return tijianDataDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tijianDataDao.count(map);
	}
	
	@Override
	public int save(TijianDataDO tijianData){
		return tijianDataDao.save(tijianData);
	}
	
	@Override
	public int update(TijianDataDO tijianData){
		return tijianDataDao.update(tijianData);
	}
	
	@Override
	public int remove(Long id){
		return tijianDataDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tijianDataDao.batchRemove(ids);
	}
	
}
