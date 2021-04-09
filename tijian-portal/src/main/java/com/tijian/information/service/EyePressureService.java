package com.tijian.information.service;

import com.tijian.information.domain.EyePressureDO;

import java.util.List;
import java.util.Map;

/**
 * 眼内压
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 11:49:19
 */
public interface EyePressureService {
	
	EyePressureDO get(Integer id);
	


	
	int save(EyePressureDO eyePressure);
	
	int update(EyePressureDO eyePressure);
	

}
