package com.tijian.information.dao;

import com.tijian.information.domain.BloodPressureDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 血压检查
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 11:22:58
 */
@Mapper
public interface BloodPressureDao {

	BloodPressureDO get(Long id);
	
	List<BloodPressureDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BloodPressureDO bloodPressure);
	
	int update(BloodPressureDO bloodPressure);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
