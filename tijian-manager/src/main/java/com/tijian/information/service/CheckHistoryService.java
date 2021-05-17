package com.tijian.information.service;

import com.tijian.common.utils.R;
import com.tijian.information.domain.CheckHistoryDO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
	
	List<CheckHistoryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CheckHistoryDO checkHistory);
	
	int update(CheckHistoryDO checkHistory);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    CheckHistoryDO getByIdentityCard(String identityCard);

    R importcheck(MultipartFile file) throws IOException;
}
