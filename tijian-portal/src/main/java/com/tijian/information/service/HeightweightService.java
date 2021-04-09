package com.tijian.information.service;

import com.tijian.information.domain.HeightweightDO;

import java.util.List;
import java.util.Map;

/**
 * 身高体重表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-29 10:47:55
 */
public interface HeightweightService {
	
	HeightweightDO get(Long id);
	


	int save(HeightweightDO heightweight);
	
	int update(HeightweightDO heightweight);
	
}
