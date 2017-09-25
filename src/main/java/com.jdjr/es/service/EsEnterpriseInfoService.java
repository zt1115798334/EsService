package com.jdjr.es.service;



import com.jdjr.es.entity.EsEnterpriseInfo;

import java.util.List;

public interface EsEnterpriseInfoService {

    boolean add(EsEnterpriseInfo esEnterpriseInfo);

    boolean batchAdd(List<EsEnterpriseInfo> esEnterpriseInfos);

    List<EsEnterpriseInfo> findByenterpriseAbbrLike(String enterpriseAbbr);

    List<EsEnterpriseInfo> findByNameC(String name_c);
}
