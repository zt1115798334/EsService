package com.zt;

import com.jdjr.es.entity.EsEnterpriseInfo;
import com.jdjr.es.service.EsEnterpriseInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EsTest extends BaseTests {

    @Autowired
    private EsEnterpriseInfoService esEnterpriseInfoService;

    @Test
    public void testAdd() {
        EsEnterpriseInfo esEnterpriseInfo = new EsEnterpriseInfo();
        esEnterpriseInfo.setDel_flag("ADD");
        esEnterpriseInfo.setInvestor_type(1);
        esEnterpriseInfo.setName("张通");
        esEnterpriseInfo.setName_c("北京联合信贷集团总部");
        esEnterpriseInfo.setProperty1("123456");
        esEnterpriseInfoService.add(esEnterpriseInfo);
    }
}
