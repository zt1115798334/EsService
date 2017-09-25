package com.jdjr.es.repository;



import com.jdjr.es.entity.EsEnterpriseInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsEnterpriseInfoRepository extends ElasticsearchRepository<EsEnterpriseInfo, String> {

//    List<EsEnterpriseInfo> findByName_c(String name_c);
}
