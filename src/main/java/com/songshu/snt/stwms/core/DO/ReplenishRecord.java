package com.songshu.snt.stwms.core.DO;

import java.util.Date;

public class ReplenishRecord {
    private Long id;

    private String shopNo;

    private String productName;

    private String productGuid;

    private String productBarCode;

    private Integer applyNum;

    private Integer actualNum;

    private Integer replenishStatus;

    private String replenishOperator;

    private String remake;

    private Date replenishDatetime;

    private Date gmtCreate;

    private Date gmtModified;

    private String extAtt;

    private String creator;

    private String operator;

    private Integer rowStatus;

    private Integer rowVersion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductGuid() {
        return productGuid;
    }

    public void setProductGuid(String productGuid) {
        this.productGuid = productGuid == null ? null : productGuid.trim();
    }

    public String getProductBarCode() {
        return productBarCode;
    }

    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode == null ? null : productBarCode.trim();
    }

    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    public Integer getActualNum() {
        return actualNum;
    }

    public void setActualNum(Integer actualNum) {
        this.actualNum = actualNum;
    }

    public Integer getReplenishStatus() {
        return replenishStatus;
    }

    public void setReplenishStatus(Integer replenishStatus) {
        this.replenishStatus = replenishStatus;
    }

    public String getReplenishOperator() {
        return replenishOperator;
    }

    public void setReplenishOperator(String replenishOperator) {
        this.replenishOperator = replenishOperator == null ? null : replenishOperator.trim();
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake == null ? null : remake.trim();
    }

    public Date getReplenishDatetime() {
        return replenishDatetime;
    }

    public void setReplenishDatetime(Date replenishDatetime) {
        this.replenishDatetime = replenishDatetime;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getExtAtt() {
        return extAtt;
    }

    public void setExtAtt(String extAtt) {
        this.extAtt = extAtt == null ? null : extAtt.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Integer getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Integer rowStatus) {
        this.rowStatus = rowStatus;
    }

    public Integer getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Integer rowVersion) {
        this.rowVersion = rowVersion;
    }
}