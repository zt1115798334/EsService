package com.jdjr.es.service;



import com.jdjr.es.entity.CompanyInvestor;

import java.util.List;

public interface CompanyInvestorService {

    List<CompanyInvestor> findByenterpriseAbbrLike(String enterpriseAbbr);

    List<CompanyInvestor> findByNameC(String name_c);
}
