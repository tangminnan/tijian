package com.tijian.information.service.impl;

import com.tijian.common.utils.R;
import com.tijian.common.utils.StringUtils;
import com.tijian.information.dao.UserDODao;
import com.tijian.information.domain.UserDO;
import com.tijian.system.config.ExcelUtils;
import com.tijian.system.dao.UserDao;
import org.apache.poi.ss.usermodel.*;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.tijian.information.dao.CheckHistoryDao;
import com.tijian.information.domain.CheckHistoryDO;
import com.tijian.information.service.CheckHistoryService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class CheckHistoryServiceImpl implements CheckHistoryService {
	@Autowired
	private CheckHistoryDao checkHistoryDao;
	@Autowired
	private UserDODao userDao;
	
	@Override
	public CheckHistoryDO get(Long id){
		return checkHistoryDao.get(id);
	}
	
	@Override
	public List<CheckHistoryDO> list(Map<String, Object> map){
		return checkHistoryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return checkHistoryDao.count(map);
	}
	
	@Override
	public int save(CheckHistoryDO checkHistory){
		return checkHistoryDao.save(checkHistory);
	}
	
	@Override
	public int update(CheckHistoryDO checkHistory){
		return checkHistoryDao.update(checkHistory);
	}
	
	@Override
	public int remove(Long id){
		return checkHistoryDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return checkHistoryDao.batchRemove(ids);
	}

	@Override
	public CheckHistoryDO getByIdentityCard(String identityCard) {
		return checkHistoryDao.getByIdentityCard(identityCard);
	}

	@Transactional
	@Override
	public R importcheck(MultipartFile file) throws IOException {
		InputStream in = null;
		Workbook book = null;
		if (file != null) {
			in = file.getInputStream();
			book = ExcelUtils.getBook(file);
			Sheet sheet = book.getSheetAt(0);
			Row row;
			//判断导入的Excel中是否有未填项
			for (int a = 1; a <= sheet.getLastRowNum(); a++) {
				row = sheet.getRow(a);
				String name = ExcelUtils.getCellFormatValue(row.getCell((short) 0),CellType.STRING);
				String phone = ExcelUtils.getCellFormatValue(row.getCell((short) 1),CellType.STRING);
				String identityCard = ExcelUtils.getCellFormatValue(row.getCell((short) 2),CellType.STRING);
				String singleChecks = ExcelUtils.getCellFormatValue(row.getCell((short) 3),CellType.STRING);
				String pins = ExcelUtils.getCellFormatValue(row.getCell((short) 4),CellType.STRING);
				String age = ExcelUtils.getCellFormatValue(row.getCell((short) 5),CellType.STRING);
				String sex = ExcelUtils.getCellFormatValue(row.getCell((short) 6),CellType.STRING);
				String nation = ExcelUtils.getCellFormatValue(row.getCell((short) 7),CellType.STRING);
				String birthday = ExcelUtils.getCellFormatValue(row.getCell((short) 8),CellType.FORMULA);
				if(StringUtils.isBlank(identityCard) || StringUtils.isBlank(singleChecks)
						|| StringUtils.isBlank(pins)) continue;
				UserDO userDO = new UserDO();
				userDO.setName(name);
				userDO.setPhone(phone);
				userDO.setIdentityCard(identityCard);
				userDO.setAge(age);
				userDO.setSex(sex==null?0:sex=="男"?1:2);
				userDO.setNation(nation);
				userDO.setAddTime(new Date());
				Date b=null;
				if(birthday!=null)
					try {
						b=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				userDO.setBirthday(b);
				Map<String,Object> paramsMap = new HashMap<>();
				paramsMap.put("identityCard",identityCard.trim());
				List<UserDO> list = userDao.list(paramsMap);
				if(list.size()>0){
					userDO.setId(list.get(0).getId());
					userDao.update(userDO);
				}else
					userDao.save(userDO);
				CheckHistoryDO checkHistoryDO = new CheckHistoryDO();
				checkHistoryDO.setPins(pins);
				checkHistoryDO.setSingleChecks(singleChecks);
				checkHistoryDO.setAddTime(new Date());
				checkHistoryDO.setUserId(userDO.getId());
				checkHistoryDO.setStatus(0);
				checkHistoryDO.setProcess(0);
				checkHistoryDO.setIdentityCard(identityCard);
				checkHistoryDao.save(checkHistoryDO);
			}


		}
		return R.ok();
	}
}
