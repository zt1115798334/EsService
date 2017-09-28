package com.jdjr.controller;

import com.alibaba.fastjson.JSONObject;
import com.jdjr.base.controller.BaseController;
import com.jdjr.beans.AjaxResult;
import com.jdjr.constants.SysConst;
import com.jdjr.es.entity.EsEnterpriseInfo;
import com.jdjr.es.service.EsEnterpriseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("es")
public class EsController extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(EsController.class);

    @Autowired
    private EsEnterpriseInfoService esEnterpriseInfoService;

    @RequestMapping(value = "esEnterprise", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult findEsEnterprise(@RequestParam("keyword") String keyword, @RequestParam("type") String type) {
        JSONObject result = new JSONObject();
        System.out.println("type = " + type);
        logger.info("type:{}", type);
        /**
         * 精确查询
         */
        if (SysConst.QueryType.EXACTQUERY.getCode().equals(type)) {
            List<EsEnterpriseInfo> es = esEnterpriseInfoService.findByNameC(keyword);
            result.put("result", es);
        }
        /**
         * 模糊查询
         */
        if (SysConst.QueryType.FUZZYQUERY.getCode().equals(type)) {
            List<EsEnterpriseInfo> es = esEnterpriseInfoService.findByenterpriseAbbrLike(keyword);
            result.put("result", es);
        }
        return success(result);
    }
}
