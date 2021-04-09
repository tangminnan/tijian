package com.tijian.information.dao;

import com.tijian.information.domain.OctDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * OCT检查
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-04-07 13:52:19
 */
@Mapper
public interface OctDao {

	OctDO get(Integer id);
	

	

	
	int save(OctDO oct);
	
	int update(OctDO oct);
	

}
