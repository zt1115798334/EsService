package com.jdjr.es.repository;



import com.jdjr.es.entity.CompanyInvestor;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CompanyInvestorRepository extends ElasticsearchRepository<CompanyInvestor, String> {

}
