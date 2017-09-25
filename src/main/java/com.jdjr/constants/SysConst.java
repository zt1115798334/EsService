package com.jdjr.constants;

public class SysConst {
    /**
     * 默认每页记录数
     */
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int DEFAULT_PAGE_NUMBER = 1;

    /**
     * 默认批处理大小
     */
    public static final int DEFAULT_BATCH_SIZE = 200;

    public static final String INDEX = "jdjr";
    public static final String ARTICLE = "article";
    public static final String ENTERPRISEINFO = "enterprise_info";

    public enum QueryType {

        FUZZYQUERY("Fuzzy", "模糊查询"),
        EXACTQUERY("Exact", "精确查询");

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
