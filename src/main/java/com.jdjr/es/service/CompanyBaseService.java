package com.jdjr.es.service;


import com.jdjr.es.entity.CompanyBase;

import java.util.List;

public interface CompanyBaseService {

    List<CompanyBase> findByCompanyNameLike(String companyName);

    List<CompanyBase> findByCompanyName(String companyName);
}
