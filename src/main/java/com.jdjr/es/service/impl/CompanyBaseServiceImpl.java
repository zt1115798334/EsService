package com.jdjr.es.service.impl;

import com.google.common.base.Objects;
import com.jdjr.constants.SysConst;
import com.jdjr.es.dao.CompanyDao;
import com.jdjr.es.entity.CompanyBase;
import com.jdjr.es.service.CompanyBaseService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyBaseServiceImpl implements CompanyBaseService {

    @Autowired
    private CompanyDao companyDao;

    private final static String TYPE = SysConst.COMPANY_BASE_TYPE;
    private final static String INDEX = SysConst.COMPANY_BASE_INDEX;

    @Override
    public List<CompanyBase> findByCompanyNameLike(String companyName) {
        // Query
        FuzzyQueryBuilder fuzzy = QueryBuilders.fuzzyQuery("company_name", companyName);
        // 最大编辑距离
//        fuzzy.fuzziness(Fuzziness.ONE);
        // 公共前缀
//        fuzzy.prefixLength(0);
        WildcardQueryBuilder wildcard = QueryBuilders.wildcardQuery("company_name", "*" + companyName + "*");
        TermQueryBuilder termQuery = QueryBuilders.termQuery("company_name", companyName);
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("company_name", companyName);
        return companyDao.findCompanyBaseByQuery(INDEX, TYPE, matchQuery);
    }

    @Override
    public List<CompanyBase> findByCompanyName(String companyName) {
        MatchQueryBuilder matchQuery = QueryBuilders.matchPhraseQuery("company_name", "\"" + companyName + "\"");
        List<CompanyBase> list = companyDao.findCompanyBaseByQuery(INDEX, TYPE, matchQuery);
        List<CompanyBase> result = list.stream()
                .filter(companyBase -> Objects.equal(companyBase.getCompany_name(), companyName))
                .collect(Collectors.toList());
        return result;
    }
}
