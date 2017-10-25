package com.zt;

import com.jdjr.es.entity.CompanyBase;
import com.jdjr.es.entity.CompanyInvestor;
import com.jdjr.es.repository.CompanyBaseRepository;
import com.jdjr.es.repository.CompanyInvestorRepository;
import com.zt.utils.MyUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EsTest extends BaseTests {

    @Autowired
    private CompanyInvestorRepository companyInvestorRepository;

    @Autowired
    private CompanyBaseRepository companyBaseRepository;

    public static final List<String> company_nameLists = Arrays.asList(
            "高邮市宏大建筑安装工程有限公司",
            "江苏裕顺汽车电子传动科技有限公司",
            "南宁市赛吉经贸有限公司",
            "唐山曹妃甸区航宇土石方工程有限公司",
            "汕头市卡西猫电器有限公司",
            "沭阳县翔利贸易有限公司",
            "石家庄邢沧汽车贸易有限公司",
            "我的测试公司啊");

    @Test
    public void testAddInvestor() {
        CompanyInvestor companyInvestor = new CompanyInvestor();

        companyInvestor.setDel_flag("ADD");
        companyInvestor.setInvestor_type(1);
        companyInvestor.setName("张通");
        companyInvestor.setName_c("我的测试公司啊");
        companyInvestor.setProperty1("123456");

        CompanyInvestor companyInvestor1 = new CompanyInvestor();
        companyInvestor1.setDel_flag("ADD");
        companyInvestor1.setInvestor_type(2);
        companyInvestor1.setName("沭阳县翔利贸易有限公司");
        companyInvestor1.setName_c("我的测试公司啊");
        companyInvestor1.setProperty1("123456");
        companyInvestor1.setDel_flag("ADD");
        List<CompanyInvestor> companyInvestors = Arrays.asList(companyInvestor, companyInvestor1);
        companyInvestorRepository.save(companyInvestors);
    }

    @Test
    public void testAddBase() {
        List<CompanyBase> companyBases = IntStream.range(0, company_nameLists.size())
                .boxed()
                .map(i -> {
                    String companyName = company_nameLists.get(i);
                    CompanyBase companyBase = new CompanyBase();
                    companyBase.setCompany_name(companyName);
                    companyBase.setCompany_name_md5(MyUtils.getMd5(companyName));
                    return companyBase;
                }).collect(Collectors.toList());
        companyBaseRepository.save(companyBases);
    }
}
