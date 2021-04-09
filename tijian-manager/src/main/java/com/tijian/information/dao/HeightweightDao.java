package com.tijian.information.dao;

import com.tijian.information.domain.HeightweightDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 身高体重表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 10:47:55
 */
@Mapper
public interface HeightweightDao {

	HeightweightDO get(Long id);
	
	List<HeightweightDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HeightweightDO heightweight);
	
	int update(HeightweightDO heightweight);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
