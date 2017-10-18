package com.jdjr.es.service.impl;

import com.google.common.base.Objects;
import com.jdjr.constants.SysConst;
import com.jdjr.es.dao.EsEnterpriseInfoDao;
import com.jdjr.es.entity.EsEnterpriseInfo;
import com.jdjr.es.repository.EsEnterpriseInfoRepository;
import com.jdjr.es.service.EsEnterpriseInfoService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EsEnterpriseInfoServiceImpl implements EsEnterpriseInfoService {

    @Autowired
    private EsEnterpriseInfoRepository esEnterpriseInfoRepository;

    @Autowired
    private EsEnterpriseInfoDao esEnterpriseInfoDao;

    @Override
    public boolean add(EsEnterpriseInfo esEnterpriseInfo) {
        esEnterpriseInfoRepository.save(esEnterpriseInfo);
        return false;
    }

    @Override
    public boolean batchAdd(List<EsEnterpriseInfo> esEnterpriseInfos) {
        esEnterpriseInfoRepository.save(esEnterpriseInfos);
        return false;
    }

    @Override
    public List<EsEnterpriseInfo> findByenterpriseAbbrLike(String enterpriseName) {
        // Query
        FuzzyQueryBuilder fuzzy = QueryBuilders.fuzzyQuery("name_c", enterpriseName);
        // 最大编辑距离
//        fuzzy.fuzziness(Fuzziness.ONE);
        // 公共前缀
//        fuzzy.prefixLength(0);
        WildcardQueryBuilder wildcard = QueryBuilders.wildcardQuery("name_c", "*" + enterpriseName + "*");
        TermQueryBuilder termQuery = QueryBuilders.termQuery("name_c", enterpriseName);
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("name_c", enterpriseName);
        return esEnterpriseInfoDao.findEsEnterpriseInfoByQuery(SysConst.INDEX, SysConst.ENTERPRISE_INFO, matchQuery);
//        return esEnterpriseInfoRepository.findByName_cLike(enterpriseName);
    }

    @Override
    public List<EsEnterpriseInfo> findByNameC(String name_c) {
        MatchQueryBuilder matchQuery = QueryBuilders.matchPhraseQuery("name_c", "\"" + name_c + "\"");
        List<EsEnterpriseInfo> list = esEnterpriseInfoDao.findEsEnterpriseInfoByQuery(SysConst.INDEX, SysConst.ENTERPRISE_INFO, matchQuery);
        List<EsEnterpriseInfo> result = list.stream()
                .filter(esEnterpriseInfo -> Objects.equal(esEnterpriseInfo.getName_c(),name_c))
                .collect(Collectors.toList());
        return result;
    }
}
