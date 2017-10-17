package com.jdjr.constants;

public class SysConst {
    public static final String INDEX = "jdjr";
    public static final String ENTERPRISE_INFO = "enterprise_info";

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
