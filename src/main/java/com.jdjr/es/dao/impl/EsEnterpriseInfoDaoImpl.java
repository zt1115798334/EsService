package com.jdjr.es.dao.impl;

import com.jdjr.es.dao.EsEnterpriseInfoDao;
import com.jdjr.es.entity.EsEnterpriseInfo;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EsEnterpriseInfoDaoImpl implements EsEnterpriseInfoDao {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<EsEnterpriseInfo> findEsEnterpriseInfoByQuery(String index, String type, QueryBuilder query) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(query)
                .withIndices(index)
                .withTypes(type)
                .build();
        List<EsEnterpriseInfo> result = elasticsearchTemplate.queryForList(searchQuery, EsEnterpriseInfo.class);
        return result;
    }
}
