package com.jdjr.es.service.impl;

import com.google.common.base.Objects;
import com.jdjr.constants.SysConst;
import com.jdjr.es.dao.CompanyDao;
import com.jdjr.es.entity.CompanyInvestor;
import com.jdjr.es.repository.CompanyInvestorRepository;
import com.jdjr.es.service.CompanyInvestorService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyInvestorServiceImpl implements CompanyInvestorService {

    private final static String TYPE = SysConst.COMPANY_INVESTOR_TYPE;
    private final static String INDEX = SysConst.COMPANY_INVESTOR_INDEX;

    @Autowired
    private CompanyInvestorRepository companyInvestorRepository;

    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<CompanyInvestor> findByenterpriseAbbrLike(String enterpriseName) {
        // Query
        FuzzyQueryBuilder fuzzy = QueryBuilders.fuzzyQuery("name_c", enterpriseName);
        // 最大编辑距离
//        fuzzy.fuzziness(Fuzziness.ONE);
        // 公共前缀
//        fuzzy.prefixLength(0);
        WildcardQueryBuilder wildcard = QueryBuilders.wildcardQuery("name_c", "*" + enterpriseName + "*");
        TermQueryBuilder termQuery = QueryBuilders.termQuery("name_c", enterpriseName);
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("name_c", enterpriseName);
        return companyDao.findCompanyInvestorByQuery(INDEX, TYPE, matchQuery);
    }

    @Override
    public List<CompanyInvestor> findByNameC(String name_c) {
        MatchQueryBuilder matchQuery = QueryBuilders.matchPhraseQuery("name_c", "\"" + name_c + "\"");
        List<CompanyInvestor> list = companyDao.findCompanyInvestorByQuery(INDEX, TYPE, matchQuery);
        List<CompanyInvestor> result = list.stream()
                .filter(companyInvestor -> Objects.equal(companyInvestor.getName_c(), name_c))
                .collect(Collectors.toList());
        return result;
    }
}
