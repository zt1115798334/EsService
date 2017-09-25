package com.jdjr.es.dao;

import com.jdjr.es.entity.EsEnterpriseInfo;
import org.elasticsearch.index.query.QueryBuilder;

import java.util.List;

public interface EsEnterpriseInfoDao {

    List<EsEnterpriseInfo> findEsEnterpriseInfoByQuery(String index, String type, QueryBuilder query);
}
