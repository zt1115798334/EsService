package com.jdjr.es.dao;

import com.jdjr.es.entity.CompanyBase;
import com.jdjr.es.entity.CompanyInvestor;
import org.elasticsearch.index.query.QueryBuilder;

import java.util.List;

public interface CompanyDao {

    List<CompanyInvestor> findCompanyInvestorByQuery(String index, String type, QueryBuilder query);

    List<CompanyBase> findCompanyBaseByQuery(String index, String type, QueryBuilder query);
}
