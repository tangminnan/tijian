package com.tijian.information.service;

import com.tijian.information.domain.CheckHistoryDO;

import java.util.List;
import java.util.Map;

/**
 * 检查记录表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-25 14:46:10
 */
public interface CheckHistoryService {
	
	CheckHistoryDO get(Long id);
	


	int save(CheckHistoryDO checkHistory);
	
	int update(CheckHistoryDO checkHistory);
	


    CheckHistoryDO getByIdentityCard(String identityCard);

    CheckHistoryDO getByUserId(Long userId);
}
