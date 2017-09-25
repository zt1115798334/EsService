package com.jdjr.es.entity;

import com.jdjr.constants.SysConst;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = SysConst.INDEX, type = SysConst.ENTERPRISEINFO)
public class EsEnterpriseInfo implements Serializable {

    private static final long serialVersionUID = 9201034849892179274L;

    @Id
    private String id;

    @Field(index = FieldIndex.analyzed, type = FieldType.String, store = true, analyzer = "ik", searchAnalyzer = "ik")
//    @Field(index = FieldIndex.not_analyzed, type = FieldType.String, store = true)
    private String name_c;  //公司名称


    @Field(index = FieldIndex.not_analyzed, type = FieldType.String, store = true)
    private String property1;   //统一社会信用代码


    @Field(index = FieldIndex.not_analyzed, type = FieldType.Integer, store = true)
    private Integer investor_type;   //股东类型，1代表自然人，2代表非自然人


    @Field(index = FieldIndex.not_analyzed, type = FieldType.String, store = true)
    private String name;    //股东名称


    @Field(index = FieldIndex.not_analyzed, type = FieldType.String, store = true)
    private String del_flag; //"新增ADD 修改EDIT，删除DEL

    public EsEnterpriseInfo() {
    }

    public EsEnterpriseInfo(String name_c, String property1, Integer investor_type, String name, String del_flag) {
        this.name_c = name_c;
        this.property1 = property1;
        this.investor_type = investor_type;
        this.name = name;
        this.del_flag = del_flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_c() {
        return name_c;
    }

    public void setName_c(String name_c) {
        this.name_c = name_c;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public Integer getInvestor_type() {
        return investor_type;
    }

    public void setInvestor_type(Integer investor_type) {
        this.investor_type = investor_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
