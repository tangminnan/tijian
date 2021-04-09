package com.tijian.information.service;

import com.tijian.information.domain.OctDO;

import java.util.List;
import java.util.Map;

/**
 * OCT检查
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-04-07 13:52:19
 */
public interface OctService {
	
	OctDO get(Integer id);
	
	List<OctDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OctDO oct);
	
	int update(OctDO oct);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
