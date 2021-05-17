package com.tijian.information.dao;

import com.tijian.information.domain.CheckItemDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 检查项目表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-04-21 11:18:40
 */
@Mapper
public interface CheckItemDao {

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
