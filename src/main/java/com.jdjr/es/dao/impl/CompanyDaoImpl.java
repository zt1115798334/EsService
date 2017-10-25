package com.jdjr.es.dao.impl;

import com.jdjr.es.dao.CompanyDao;
import com.jdjr.es.entity.CompanyBase;
import com.jdjr.es.entity.CompanyInvestor;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<CompanyInvestor> findCompanyInvestorByQuery(String index, String type, QueryBuilder query) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(query)
                .withIndices(index)
                .withTypes(type)
                .build();
        List<CompanyInvestor> result = elasticsearchTemplate.queryForList(searchQuery, CompanyInvestor.class);
        return result;
    }

    @Override
    public List<CompanyBase> findCompanyBaseByQuery(String index, String type, QueryBuilder query) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(query)
                .withIndices(index)
                .withTypes(type)
                .build();
        List<CompanyBase> result = elasticsearchTemplate.queryForList(searchQuery, CompanyBase.class);
        return result;
    }
}
