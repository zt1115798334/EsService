package com.jdjr.es.repository;



import com.jdjr.es.entity.CompanyBase;
import com.jdjr.es.entity.CompanyInvestor;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CompanyBaseRepository extends ElasticsearchRepository<CompanyBase, String> {

}
