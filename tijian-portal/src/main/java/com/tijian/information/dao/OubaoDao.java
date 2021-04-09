package com.tijian.information.dao;

import com.tijian.information.domain.OubaoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 欧宝检查
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 14:03:22
 */
@Mapper
public interface OubaoDao {

	OubaoDO get(Integer id);
	


	
	int save(OubaoDO oubao);
	
	int update(OubaoDO oubao);
	

}
