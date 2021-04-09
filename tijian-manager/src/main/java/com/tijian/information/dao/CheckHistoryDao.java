package com.tijian.information.dao;

import com.tijian.information.domain.CheckHistoryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 检查记录表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-25 14:46:10
 */
@Mapper
public interface CheckHistoryDao {

	CheckHistoryDO get(Long id);
	
	List<CheckHistoryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CheckHistoryDO checkHistory);
	
	int update(CheckHistoryDO checkHistory);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    CheckHistoryDO getByIdentityCard(String identityCard);
}
