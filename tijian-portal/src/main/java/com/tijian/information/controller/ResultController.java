package com.tijian.information.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tijian.information.domain.*;
import com.tijian.information.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ResultController {

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
    private CheckHistoryService checkHistoryService;
    @Autowired
    private OctService octService;
    @Autowired
    private TijianDataService tijianDataService;
    /**
     * 获取用户的基本信息
     * @return
     */
    @GetMapping("/getUserInfo")
    public Map<String,Object> getUserInfo(Long  userId){
        UserDO userDO = userDOService.get(userId);
        CheckHistoryDO checkHistoryDO = checkHistoryService.getByUserId(userId);
        if(checkHistoryDO!=null){
            userDO.setCheckId(checkHistoryDO.getId());
            userDO.setSingleChecks(checkHistoryDO.getSingleChecks());
        }
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if(userDO==null){
            resultMap.put("code",-1);
            resultMap.put("msg","没有此用户的数据");
            resultMap.put("data",null);
        }else{
            //获取需要检查的项目
            resultMap.put("code",0);
            resultMap.put("msg","获取数据成功");
            resultMap.put("data",userDO);
        }
        return resultMap;
    }

    /**
     *  保存检查数据
     * @return
     */
    @PostMapping("/saveTiJianData")
    @Transactional
    public Map<String,Object> saveTiJianData(TijianDataDO tijianDataDO){
        tijianDataDO.setAddTime(new Date());
        int result = tijianDataService.save(tijianDataDO);
        Map<String,Object> resultMap = new HashMap<>();
        if(result>0){
            resultMap.put("code",0);
            resultMap.put("msg","数据保存成功！");
            resultMap.put("data",null);
        }else{
            resultMap.put("code",-1);
            resultMap.put("msg","数据保存失败！");
            resultMap.put("data",null);
        }
        return resultMap;
    }

    /**
     * 保存身高体重检查情况
     * @return
     */
//    @PostMapping("/saveHeightWeight")
//    @Transactional
//    public Map<String,Object> saveHeightWeight(HeightweightDO heightweightDO){
//        heightweightDO.setAddTime(new Date());
//        int result = heightweightService.save(heightweightDO);
//        if(result>0){
//            CheckHistoryDO checkHistoryDO = checkHistoryService.get(heightweightDO.getCheckId());
//            checkHistoryDO.setProcess(checkHistoryDO.getProcess()+1);
//            String[] singleChecks = checkHistoryDO.getSingleChecks().split(",");
//            if(checkHistoryDO.getProcess()>=singleChecks.length)
//                checkHistoryDO.setStatus(1);
//            checkHistoryService.update(checkHistoryDO);
//        }
//        Map<String,Object> resultMap = new HashMap<>();
//        if(result>0){
//            resultMap.put("code",0);
//            resultMap.put("msg","身高体重保存成功！");
//            resultMap.put("data",null);
//        }else{
//            resultMap.put("code",-1);
//            resultMap.put("msg","身高体重保存失败！");
//            resultMap.put("data",null);
//        }
//        return resultMap;
//    }

    /**
     * 保存血压重检查情况
     * @return
     */
//    @PostMapping("/saveBloodPressure")
//    @Transactional
//    public Map<String,Object> saveBloodPressure(BloodPressureDO bloodPressureDO){
//        bloodPressureDO.setAddTime(new Date());
//        int result = bloodPressureService.save(bloodPressureDO);
//        if(result>0){
//            CheckHistoryDO checkHistoryDO = checkHistoryService.get(bloodPressureDO.getCheckId());
//            checkHistoryDO.setProcess(checkHistoryDO.getProcess()+1);
//            String[] singleChecks = checkHistoryDO.getSingleChecks().split(",");
//            if(checkHistoryDO.getProcess()>=singleChecks.length)
//                checkHistoryDO.setStatus(1);
//            checkHistoryService.update(checkHistoryDO);
//        }
//        Map<String,Object> resultMap = new HashMap<>();
//        if(result>0){
//            resultMap.put("code",0);
//            resultMap.put("msg","血压检查保存成功！");
//            resultMap.put("data",null);
//        }else{
//            resultMap.put("code",-1);
//            resultMap.put("msg","血压检查保存失败！");
//            resultMap.put("data",null);
//        }
//        return resultMap;
//    }

    /**
     * 保存眼压检查情况
     * @return
     */
//    @PostMapping("/saveEyePressure")
//    @Transactional
//    public Map<String,Object> saveEyePressure(EyePressureDO eyePressureDO){
//        eyePressureDO.setAddTime(new Date());
//        int result = eyePressureService.save(eyePressureDO);
//        if(result>0){
//            CheckHistoryDO checkHistoryDO = checkHistoryService.get(eyePressureDO.getCheckId());
//            checkHistoryDO.setProcess(checkHistoryDO.getProcess()+1);
//            String[] singleChecks = checkHistoryDO.getSingleChecks().split(",");
//            if(checkHistoryDO.getProcess()>=singleChecks.length)
//                checkHistoryDO.setStatus(1);
//            checkHistoryService.update(checkHistoryDO);
//        }
//        Map<String,Object> resultMap = new HashMap<>();
//        if(result>0){
//            resultMap.put("code",0);
//            resultMap.put("msg","眼压检查保存成功！");
//            resultMap.put("data",null);
//        }else{
//            resultMap.put("code",-1);
//            resultMap.put("msg","眼压检查保存失败！");
//            resultMap.put("data",null);
//        }
//        return resultMap;
//    }

    /**
     * 保存欧宝检查情况
     * @return
     * {
     *     "userId":11,
     *     "img":[
     *       "img1",
     *       "img2",
     *       "img3",
     *       "img4",
     *     ]
     * }
     */
//    @PostMapping("/saveOuBao")
//    @Transactional
//    public Map<String,Object> saveOuBao(@RequestBody JSONObject jsonObject){
//        Integer userId = jsonObject.getInteger("userId");
//        Long checkId = jsonObject.getLong("checkId");
//        JSONArray limg = jsonObject.getJSONArray("limg");
//        String ls = limg.toJSONString();
//        JSONArray rimg = jsonObject.getJSONArray("rimg");
//        String rs = rimg.toJSONString();
//        OubaoDO oubaoDO = new OubaoDO();
//        oubaoDO.setUserId(userId);
//        oubaoDO.setLimg(ls);
//        oubaoDO.setRimg(rs);
//        oubaoDO.setCheckId(checkId);
//        oubaoDO.setAddTime(new Date());
//        int result = oubaoService.save(oubaoDO);
//        if(result>0){
//            CheckHistoryDO checkHistoryDO = checkHistoryService.get(checkId);
//            checkHistoryDO.setProcess(checkHistoryDO.getProcess()+1);
//            String[] singleChecks = checkHistoryDO.getSingleChecks().split(",");
//            if(checkHistoryDO.getProcess()>=singleChecks.length)
//                checkHistoryDO.setStatus(1);
//            checkHistoryService.update(checkHistoryDO);
//        }
//        Map<String,Object> resultMap = new HashMap<>();
//        if(result>0){
//            resultMap.put("code",0);
//            resultMap.put("msg","欧宝检查保存成功！");
//            resultMap.put("data",null);
//        }else{
//            resultMap.put("code",-1);
//            resultMap.put("msg","欧宝检查保存失败！");
//            resultMap.put("data",null);
//        }
//        return resultMap;
//    }

    /**
     * 保存欧宝检查情况
     * @return
     * {
     *     "userId":11,
     *     "img":[
     *       "img1",
     *       "img2",
     *       "img3",
     *       "img4",
     *     ],
     *     "pdf":[
     *        "img1",
     *       "img2",
     *       "img3",
     *       "img4",
     *
      *      ],
     *      "original":[
     *       "img1",
     *       "img2",
     *       "img3",
     *       "img4",
     *     ]
     * }
     */
//    @PostMapping("/saveOCT")
//    @Transactional
//    public Map<String,Object> saveOCT(@RequestBody JSONObject jsonObject){
//        Integer userId = jsonObject.getInteger("userId");
//        Long checkId = jsonObject.getLong("checkId");
//        JSONArray jsonpdf = jsonObject.getJSONArray("pdf");
//        String pdf = jsonpdf.toJSONString();
//        JSONArray jsonimg = jsonObject.getJSONArray("img");
//        String img = jsonimg.toJSONString();
//        JSONArray jsonoriginal = jsonObject.getJSONArray("original");
//        String original = jsonoriginal.toJSONString();
//        OctDO octDO = new OctDO();
//        octDO.setUserId(userId);
//        octDO.setPdf(pdf);
//        octDO.setOriginal(original);
//        octDO.setImg(img);
//        octDO.setCheckId(checkId);
//        octDO.setAddTime(new Date());
//        int result = octService.save(octDO);
//        if(result>0){
//            CheckHistoryDO checkHistoryDO = checkHistoryService.get(checkId);
//            checkHistoryDO.setProcess(checkHistoryDO.getProcess()+1);
//            String[] singleChecks = checkHistoryDO.getSingleChecks().split(",");
//            if(checkHistoryDO.getProcess()>=singleChecks.length)
//                checkHistoryDO.setStatus(1);
//            checkHistoryService.update(checkHistoryDO);
//        }
//        Map<String,Object> resultMap = new HashMap<>();
//        if(result>0){
//            resultMap.put("code",0);
//            resultMap.put("msg","OCT检查保存成功！");
//            resultMap.put("data",null);
//        }else{
//            resultMap.put("code",-1);
//            resultMap.put("msg","OCT检查保存失败！");
//            resultMap.put("data",null);
//        }
//        return resultMap;
//    }
}
