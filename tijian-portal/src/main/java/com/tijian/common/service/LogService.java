package com.tijian.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tijian.common.domain.LogDO;
import com.tijian.common.domain.PageDO;
import com.tijian.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
