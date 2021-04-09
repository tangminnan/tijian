package com.tijian.information.service;

import com.tijian.information.domain.BloodPressureDO;

import java.util.List;
import java.util.Map;

/**
 * 血压检查
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 11:22:58
 */
public interface BloodPressureService {
	
	BloodPressureDO get(Long id);
	
	List<BloodPressureDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BloodPressureDO bloodPressure);
	
	int update(BloodPressureDO bloodPressure);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
