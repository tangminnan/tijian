package com.tijian.information.dao;

import com.tijian.information.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户信息表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-24 10:38:50
 */
@Mapper
public interface UserDODao {

	UserDO get(Long id);
	
	List<UserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserDO user);
	
	int update(UserDO user);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
