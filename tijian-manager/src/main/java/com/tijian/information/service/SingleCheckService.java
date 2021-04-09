package com.tijian.information.service;

import com.tijian.information.domain.SingleCheckDO;

import java.util.List;
import java.util.Map;

/**
 * 单项表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-24 14:41:14
 */
public interface SingleCheckService {
	
	SingleCheckDO get(Long id);
	
	List<SingleCheckDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SingleCheckDO singleCheck);
	
	int update(SingleCheckDO singleCheck);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
