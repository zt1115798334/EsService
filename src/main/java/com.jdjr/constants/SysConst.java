package com.jdjr.constants;

public class SysConst {
    public static final String COMPANY_INVESTOR_INDEX = "dmt_risk_ic_company_investor_i_d";
    public static final String COMPANY_INVESTOR_TYPE = "dmt_risk_ic_company_investor_i_d";

    public static final String COMPANY_BASE_INDEX = "dmt_risk_ic_company_base_i_d";
    public static final String COMPANY_BASE_TYPE = "dmt_risk_ic_company_base_i_d";

    public enum QueryType {

        FUZZYQUERY("fuzzy", "模糊查询"),
        EXACTQUERY("exact", "精确查询");

        private String code;
        private String name;

        QueryType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

    }
}
