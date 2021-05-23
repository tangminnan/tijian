package com.tijian.information.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.tijian.common.utils.PageUtils;
import com.tijian.common.utils.Query;
import com.tijian.common.utils.R;
import com.tijian.common.utils.xss.BarCodeUtils;
import com.tijian.information.domain.*;
import com.tijian.information.service.*;
import javafx.util.converter.BigDecimalStringConverter;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 检查记录表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-03-25 14:46:10
 */
 
@Controller
@RequestMapping("/information/checkHistory")
public class CheckHistoryController {
	@Autowired
	private CheckHistoryService checkHistoryService;
	@Autowired
	private UserDOService userDOService;
	@Autowired
	private HeightweightService heightweightService;
	@Autowired
	private BloodPressureService bloodPressureService;
	@Autowired
	private EyePressureService eyePressureService;
	@Autowired
	private OubaoService oubaoService;
	@Autowired
	private OctService octService;
	
	@GetMapping("/{id}")
	String CheckHistory(@PathVariable("id") Long userId,Model model){
		model.addAttribute("userId",userId);
	    return "information/checkHistory/checkHistory";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CheckHistoryDO> checkHistoryList = checkHistoryService.list(query);
		int total = checkHistoryService.count(query);
		PageUtils pageUtils = new PageUtils(checkHistoryList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "information/checkHistory/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id,Model model){
		CheckHistoryDO checkHistory = checkHistoryService.get(id);
		model.addAttribute("checkHistory", checkHistory);
	    return "information/checkHistory/edit";
	}
	
	/**
	 * 保存
	 * identityCard,name,birthday,sex,age,check,totalPrice,yingfuPrice
	 */
	@ResponseBody
	@PostMapping("/save")
	@Transactional
	public R save(Long  userId,String phone,
				  String identityCard, String name, String birthday,
				  Integer sex, String age, String check, String itemcheck,BigDecimal totalPrice, BigDecimal yingfuPrice){
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("identityCard",identityCard.trim());
		List<UserDO> userDOS = userDOService.list(paramsMap);
		if(userDOS.size()==0){//新增用户数据
			UserDO userDO = new UserDO();
			userDO.setIdentityCard(identityCard.trim());
			userDO.setName(name);
			userDO.setAddTime(new Date());
			userDO.setPhone(phone);
			getUserDO(userDO,identityCard,birthday,sex,age);
			userDOService.save(userDO);
			userId=userDO.getId();
		}
		if(userId!=null) {
			CheckHistoryDO checkHistoryDO = new CheckHistoryDO();
			checkHistoryDO.setAddTime(new Date());
			checkHistoryDO.setTotalAmount(totalPrice);
			checkHistoryDO.setYingfuAmount(yingfuPrice);
			checkHistoryDO.setPins(check);
			checkHistoryDO.setSingleChecks(itemcheck);
			checkHistoryDO.setUserId(userId);
			checkHistoryDO.setIdentityCard(identityCard);
			checkHistoryDO.setProcess(0);
			checkHistoryDO.setStatus(0);
			int result= checkHistoryService.save(checkHistoryDO);
			if(result>0) {
	//			return R.ok(String.valueOf(checkHistoryDO.getId()));
				String code = BarCodeUtils.generateBarCode128(checkHistoryDO.getUserId().toString(), 10.0, 0.3, true, true);//条形码
				return R.ok(String.valueOf("data:image/png;base64,"+code));

			}
		}

		return R.error();
	}

	/**
	 * 浏览器打印费用单
	 * @return
	 */
	@GetMapping("/print")
	public String print(Long id,Model model){
		CheckHistoryDO checkHistoryDO = checkHistoryService.get(id);
		String name = checkHistoryDO.getName();
		model.addAttribute("name",name);
		model.addAttribute("identityCard",checkHistoryDO.getIdentityCard());
		model.addAttribute("totalAmount",checkHistoryDO.getTotalAmount());
		model.addAttribute("yingfuAmount",checkHistoryDO.getYingfuAmount());
		model.addAttribute("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(checkHistoryDO.getAddTime()));
		String pin = checkHistoryDO.getSingleChecks();
		if(pin.contains("SHENGAOTIZHONG")) pin=pin.replace("SHENGAOTIZHONG","身高体重");
		if(pin.contains("XUEYA")) pin=pin.replace("XUEYA","血压");
		if(pin.contains("OUBAO")) pin=pin.replace("OUBAO","欧宝检查");
		if(pin.contains("OCT")) pin=pin.replace("OCT","OCT检查");
		if(pin.contains("YANYA")) pin=pin.replace("YANYA","眼压检查");
		model.addAttribute("pin", Arrays.asList(pin.split(",")));
		String code = BarCodeUtils.generateBarCode128(checkHistoryDO.getUserId().toString(), 10.0, 0.3, true, true);//条形码
		model.addAttribute("QRCode","data:image/png;base64,"+code);
		return "/information/checkHistory/feiyongdan";
	}

	/**
	 * 浏览器打印指引单
	 * @return
	 */
	@GetMapping("/zhiyindanprint")
	public String zhiyindanprint(String identityCard,Model model){
		CheckHistoryDO checkHistoryDO = checkHistoryService.getByIdentityCard(identityCard);
		String name = checkHistoryDO.getName();
		model.addAttribute("name",name);
		model.addAttribute("identityCard",checkHistoryDO.getIdentityCard());
		model.addAttribute("totalAmount",checkHistoryDO.getTotalAmount());
		model.addAttribute("yingfuAmount",checkHistoryDO.getYingfuAmount());
		model.addAttribute("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(checkHistoryDO.getAddTime()));
		String pin = checkHistoryDO.getSingleChecks();
		if(pin.contains("SHENGAOTIZHONG")) pin=pin.replace("SHENGAOTIZHONG","身高体重");
		if(pin.contains("XUEYA")) pin=pin.replace("XUEYA","血压");
		if(pin.contains("OUBAO")) pin=pin.replace("OUBAO","欧宝检查");
		if(pin.contains("OCT")) pin=pin.replace("OCT","OCT检查");
		if(pin.contains("YANYA")) pin=pin.replace("YANYA","眼压检查");
		model.addAttribute("pin", Arrays.asList(pin.split(",")));
		String code = BarCodeUtils.generateBarCode128(checkHistoryDO.getUserId().toString(), 10.0, 0.3, true, true);//条形码
		model.addAttribute("QRCode","data:image/png;base64,"+code);
		return "/information/checkHistory/zhiyindan";
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( CheckHistoryDO checkHistory){
		checkHistoryService.update(checkHistory);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(checkHistoryService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Long[] ids){
		checkHistoryService.batchRemove(ids);
		return R.ok();
	}

	private static void getUserDO(UserDO userDO,String identityCard ,String birthday,Integer sex, String age){
		if(identityCard==null || "".equals(identityCard))
			return;
		//370983  198601021377
		if(birthday==null || "".equals(birthday)){
			birthday=identityCard.substring(6,14);
		}
		Date mybirthday=null;
		try {
			mybirthday = new SimpleDateFormat("yyyyMMdd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(sex==null || sex==0){
			String num=identityCard.substring(17,18);
			int s = Integer.parseInt(num);
			sex= s%2==0?2:1;
		}
		if(age==null || "".equals(age)){
			age = String.valueOf((new Date().getTime()-mybirthday.getTime())/1000/60/60/24/365);
		}
		userDO.setBirthday(mybirthday);
		userDO.setSex(sex);
		userDO.setAge(age);
	}

	/**
	 * 浏览器查看报告
	 * @return
	 */
	@GetMapping("/lookReportAtBrowser/{id}/{userId}")
	public String lookReportAtBrowser(Model model,@PathVariable("id") Long id,@PathVariable("userId") Long userId){
		UserDO userDO = userDOService.get(userId);

		model.addAttribute("userDO",userDO);
		Map<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("checkId",id);
		List<HeightweightDO> heightweightDOS = heightweightService.list(paramsMap);
		model.addAttribute("heightweightDO",heightweightDOS.size()>0?heightweightDOS.get(0):new HeightweightDO());
		List<BloodPressureDO> bloodPressureDOS = bloodPressureService.list(paramsMap);
		model.addAttribute( "bloodPressureDO",bloodPressureDOS.size()>0?bloodPressureDOS.get(0):new BloodPressureDO());
		List<EyePressureDO> eyePressureDOS = eyePressureService.list(paramsMap);
		model.addAttribute("eyePressureDO",eyePressureDOS.size()>0?eyePressureDOS.get(0):new EyePressureDO());
		List<OubaoDO> oubaoDOS=oubaoService.list(paramsMap);
		if(oubaoDOS.size()>0){
			OubaoDO oubaoDO=oubaoDOS.get(0);
			if(oubaoDO.getLimg()!=null)
				oubaoDO.setLlist(JSONObject.parseArray(oubaoDO.getLimg(),String.class));
			if(oubaoDO.getRimg()!=null)
				oubaoDO.setRlist(JSONObject.parseArray(oubaoDO.getRimg(),String.class));
			model.addAttribute("oubaoDO",oubaoDO);
		}else{
			model.addAttribute("oubaoDO",new OubaoDO());
		}
		List<OctDO> octDOS = octService.list(paramsMap);
		if(octDOS.size()>0){
			OctDO octDO = octDOS.get(0);
			if(octDO.getOriginal()!=null)//原始文件
				octDO.setOriginalsimg(JSONObject.parseArray(octDO.getOriginal(),String.class));
			if(octDO.getPdf()!=null)//pdf文件
				octDO.setPdfimg(JSONObject.parseArray(octDO.getPdf(),String.class));
			model.addAttribute("octDO",octDO);
		}else{
			model.addAttribute("octDO",new OctDO());
		}
		return "/information/checkHistory/report";

	}

	/**
	 *  批量导入检查
	 */
	@PostMapping("importcheck")
	@ResponseBody
	public R importcheck(MultipartFile file) throws IOException {
		return checkHistoryService.importcheck(file);
	}
	
}
