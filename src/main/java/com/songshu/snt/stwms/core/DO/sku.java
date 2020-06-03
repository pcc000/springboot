package com.songshu.snt.stwms.core.DO;

import java.math.BigDecimal;
import java.util.Date;

public class sku {
    private Long id;

    private String skuName;

    private Byte skuType;

    private String goodId;

    private Byte thePackageSku;

    private String queryPymCode;

    private String queryWbmCode;

    private String skuSubName;

    private String skuDescription;

    private String skuCode;

    private String shopNo;

    private Long itemId;

    private String productGuid;

    private String productBarCode;

    private String productCode;

    private String financialCode;

    private String taste;

    private String productSpec;

    private String bigUnit;

    private BigDecimal changeScale;

    private String smallUnit;

    private Integer qualityPeriod;

    private Integer minQualityPeriod;

    private String productLicense;

    private String productStandard;

    private String additive;

    private String burden;

    private String storageMode;

    private String netWeight;

    private String mainImage;

    private Integer skuStatus;

    private String skuLabel;

    private Byte saleChannel;

    private String canSaleUnit;

    private Integer saleNum;

    private Integer minSaleQuantity;

    private Integer maxSaleQuantity;

    private Integer lastCostPrice;

    private Integer costPrice;

    private Integer salePrice;

    private Integer memberPrice;

    private Integer groupPrice;

    private Integer suggestedRetailPrice;

    private BigDecimal vipDiscount;

    private Integer virtualInventory;

    private Integer lockInventory;

    private Date saleStart;

    private Date saleEnd;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer rowVersion;

    private Byte rowStatus;

    private Integer bizType;

    private String creator;

    private String operator;

    private Integer allocation;

    private Integer minOrderQuantity;

    private Integer minDisplayQuantity;

    private String allocateStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public Byte getSkuType() {
        return skuType;
    }

    public void setSkuType(Byte skuType) {
        this.skuType = skuType;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public Byte getThePackageSku() {
        return thePackageSku;
    }

    public void setThePackageSku(Byte thePackageSku) {
        this.thePackageSku = thePackageSku;
    }

    public String getQueryPymCode() {
        return queryPymCode;
    }

    public void setQueryPymCode(String queryPymCode) {
        this.queryPymCode = queryPymCode == null ? null : queryPymCode.trim();
    }

    public String getQueryWbmCode() {
        return queryWbmCode;
    }

    public void setQueryWbmCode(String queryWbmCode) {
        this.queryWbmCode = queryWbmCode == null ? null : queryWbmCode.trim();
    }

    public String getSkuSubName() {
        return skuSubName;
    }

    public void setSkuSubName(String skuSubName) {
        this.skuSubName = skuSubName == null ? null : skuSubName.trim();
    }

    public String getSkuDescription() {
        return skuDescription;
    }

    public void setSkuDescription(String skuDescription) {
        this.skuDescription = skuDescription == null ? null : skuDescription.trim();
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getFinancialCode() {
        return financialCode;
    }

    public void setFinancialCode(String financialCode) {
        this.financialCode = financialCode == null ? null : financialCode.trim();
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste == null ? null : taste.trim();
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec == null ? null : productSpec.trim();
    }

    public String getBigUnit() {
        return bigUnit;
    }

    public void setBigUnit(String bigUnit) {
        this.bigUnit = bigUnit == null ? null : bigUnit.trim();
    }

    public BigDecimal getChangeScale() {
        return changeScale;
    }

    public void setChangeScale(BigDecimal changeScale) {
        this.changeScale = changeScale;
    }

    public String getSmallUnit() {
        return smallUnit;
    }

    public void setSmallUnit(String smallUnit) {
        this.smallUnit = smallUnit == null ? null : smallUnit.trim();
    }

    public Integer getQualityPeriod() {
        return qualityPeriod;
    }

    public void setQualityPeriod(Integer qualityPeriod) {
        this.qualityPeriod = qualityPeriod;
    }

    public Integer getMinQualityPeriod() {
        return minQualityPeriod;
    }

    public void setMinQualityPeriod(Integer minQualityPeriod) {
        this.minQualityPeriod = minQualityPeriod;
    }

    public String getProductLicense() {
        return productLicense;
    }

    public void setProductLicense(String productLicense) {
        this.productLicense = productLicense == null ? null : productLicense.trim();
    }

    public String getProductStandard() {
        return productStandard;
    }

    public void setProductStandard(String productStandard) {
        this.productStandard = productStandard == null ? null : productStandard.trim();
    }

    public String getAdditive() {
        return additive;
    }

    public void setAdditive(String additive) {
        this.additive = additive == null ? null : additive.trim();
    }

    public String getBurden() {
        return burden;
    }

    public void setBurden(String burden) {
        this.burden = burden == null ? null : burden.trim();
    }

    public String getStorageMode() {
        return storageMode;
    }

    public void setStorageMode(String storageMode) {
        this.storageMode = storageMode == null ? null : storageMode.trim();
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight == null ? null : netWeight.trim();
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public Integer getSkuStatus() {
        return skuStatus;
    }

    public void setSkuStatus(Integer skuStatus) {
        this.skuStatus = skuStatus;
    }

    public String getSkuLabel() {
        return skuLabel;
    }

    public void setSkuLabel(String skuLabel) {
        this.skuLabel = skuLabel == null ? null : skuLabel.trim();
    }

    public Byte getSaleChannel() {
        return saleChannel;
    }

    public void setSaleChannel(Byte saleChannel) {
        this.saleChannel = saleChannel;
    }

    public String getCanSaleUnit() {
        return canSaleUnit;
    }

    public void setCanSaleUnit(String canSaleUnit) {
        this.canSaleUnit = canSaleUnit == null ? null : canSaleUnit.trim();
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getMinSaleQuantity() {
        return minSaleQuantity;
    }

    public void setMinSaleQuantity(Integer minSaleQuantity) {
        this.minSaleQuantity = minSaleQuantity;
    }

    public Integer getMaxSaleQuantity() {
        return maxSaleQuantity;
    }

    public void setMaxSaleQuantity(Integer maxSaleQuantity) {
        this.maxSaleQuantity = maxSaleQuantity;
    }

    public Integer getLastCostPrice() {
        return lastCostPrice;
    }

    public void setLastCostPrice(Integer lastCostPrice) {
        this.lastCostPrice = lastCostPrice;
    }

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(Integer memberPrice) {
        this.memberPrice = memberPrice;
    }

    public Integer getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(Integer groupPrice) {
        this.groupPrice = groupPrice;
    }

    public Integer getSuggestedRetailPrice() {
        return suggestedRetailPrice;
    }

    public void setSuggestedRetailPrice(Integer suggestedRetailPrice) {
        this.suggestedRetailPrice = suggestedRetailPrice;
    }

    public BigDecimal getVipDiscount() {
        return vipDiscount;
    }

    public void setVipDiscount(BigDecimal vipDiscount) {
        this.vipDiscount = vipDiscount;
    }

    public Integer getVirtualInventory() {
        return virtualInventory;
    }

    public void setVirtualInventory(Integer virtualInventory) {
        this.virtualInventory = virtualInventory;
    }

    public Integer getLockInventory() {
        return lockInventory;
    }

    public void setLockInventory(Integer lockInventory) {
        this.lockInventory = lockInventory;
    }

    public Date getSaleStart() {
        return saleStart;
    }

    public void setSaleStart(Date saleStart) {
        this.saleStart = saleStart;
    }

    public Date getSaleEnd() {
        return saleEnd;
    }

    public void setSaleEnd(Date saleEnd) {
        this.saleEnd = saleEnd;
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

    public Integer getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Integer rowVersion) {
        this.rowVersion = rowVersion;
    }

    public Byte getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Byte rowStatus) {
        this.rowStatus = rowStatus;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
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

    public Integer getAllocation() {
        return allocation;
    }

    public void setAllocation(Integer allocation) {
        this.allocation = allocation;
    }

    public Integer getMinOrderQuantity() {
        return minOrderQuantity;
    }

    public void setMinOrderQuantity(Integer minOrderQuantity) {
        this.minOrderQuantity = minOrderQuantity;
    }

    public Integer getMinDisplayQuantity() {
        return minDisplayQuantity;
    }

    public void setMinDisplayQuantity(Integer minDisplayQuantity) {
        this.minDisplayQuantity = minDisplayQuantity;
    }

    public String getAllocateStatus() {
        return allocateStatus;
    }

    public void setAllocateStatus(String allocateStatus) {
        this.allocateStatus = allocateStatus == null ? null : allocateStatus.trim();
    }
}