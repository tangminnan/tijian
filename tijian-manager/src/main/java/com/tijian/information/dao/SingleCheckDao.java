package com.tijian.information.dao;

import com.tijian.information.domain.SingleCheckDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 单项表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-24 14:41:14
 */
@Mapper
public interface SingleCheckDao {

	SingleCheckDO get(Long id);
	
	List<SingleCheckDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SingleCheckDO singleCheck);
	
	int update(SingleCheckDO singleCheck);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
