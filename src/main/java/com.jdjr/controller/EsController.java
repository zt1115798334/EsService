package com.jdjr.controller;

import com.alibaba.fastjson.JSONObject;
import com.jdjr.constants.SysConst;
import com.jdjr.es.entity.EsEnterpriseInfo;
import com.jdjr.es.service.EsEnterpriseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("es")
public class EsController {

    @Autowired
    private EsEnterpriseInfoService esEnterpriseInfoService;

    @RequestMapping(value = "esEnterprise", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject findEsEnterprise(@RequestParam("keyword") String keyword, @RequestParam("type") String type) {
        JSONObject result = new JSONObject();
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
        return result;
    }
}
