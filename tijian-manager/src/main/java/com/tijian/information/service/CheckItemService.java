package com.tijian.information.service;

import com.tijian.information.domain.CheckItemDO;

import java.util.List;
import java.util.Map;

/**
 * 检查项目表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-04-21 11:18:40
 */
public interface CheckItemService {
	
	CheckItemDO get(Long id);
	
	List<CheckItemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CheckItemDO checkItem);
	
	int update(CheckItemDO checkItem);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    CheckItemDO getSub(Long id);

    void removeByParentId(Long id);
}
