package com.jdjr.controller;

import com.alibaba.fastjson.JSONObject;
import com.jdjr.base.controller.BaseController;
import com.jdjr.beans.AjaxResult;
import com.jdjr.constants.SysConst;
import com.jdjr.es.entity.CompanyBase;
import com.jdjr.es.entity.CompanyInvestor;
import com.jdjr.es.service.CompanyBaseService;
import com.jdjr.es.service.CompanyInvestorService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/es")
public class EsController extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(EsController.class);

    @Autowired
    private CompanyInvestorService companyInvestorService;

    @Autowired
    private CompanyBaseService companyBaseService;

    @RequestMapping(value = "/searchCompanyInvestor", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult searchCompanyInvestor(@RequestParam("keyword") String keyword, @RequestParam("type") String type) {
        logger.info("参数信息：关键字：{}，类型:{}", keyword, type);
        JSONObject result = new JSONObject();
        if (StringUtils.isEmpty(keyword) ||
                StringUtils.isEmpty(type)) {
            return fail("参数不合法");
        }
        try {
            /**
             * 精确查询
             */
            if (SysConst.QueryType.EXACTQUERY.getCode().equals(type)) {
                List<CompanyInvestor> es = companyInvestorService.findByNameC(keyword);
                result.put("result", es);
            }
            /**
             * 模糊查询
             */
            if (SysConst.QueryType.FUZZYQUERY.getCode().equals(type)) {
                List<CompanyInvestor> es = companyInvestorService.findByenterpriseAbbrLike(keyword);
                result.put("result", es);
            }
        } catch(Exception e) {
            logger.error("查询ES服务，异常信息为:{}", e);
            return fail("操作失败");
        }
        return success(result);
    }

    @RequestMapping(value = "/searchCompanyBase", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult searchCompanyBase(@RequestParam("keyword") String keyword, @RequestParam("type") String type) {
        logger.info("参数信息：关键字：{}，类型:{}", keyword, type);
        JSONObject result = new JSONObject();
        if (StringUtils.isEmpty(keyword) ||
                StringUtils.isEmpty(type)) {
            return fail("参数不合法");
        }
        try {
            /**
             * 精确查询
             */
            if (SysConst.QueryType.EXACTQUERY.getCode().equals(type)) {
                List<CompanyBase> es = companyBaseService.findByCompanyName(keyword);
                result.put("result", es);
            }
            /**
             * 模糊查询
             */
            if (SysConst.QueryType.FUZZYQUERY.getCode().equals(type)) {
                List<CompanyBase> es = companyBaseService.findByCompanyNameLike(keyword);
                result.put("result", es);
            }
        } catch(Exception e) {
            logger.error("查询ES服务，异常信息为:{}", e);
            return fail("操作失败");
        }
        return success(result);
    }
}
