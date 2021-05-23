package com.tijian.information.service;

import com.tijian.information.domain.TijianDataDO;

import java.util.List;
import java.util.Map;

/**
 * 检查结果表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-05-23 09:58:55
 */
public interface TijianDataService {
	
	TijianDataDO get(Long id);
	
	List<TijianDataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TijianDataDO tijianData);
	
	int update(TijianDataDO tijianData);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
