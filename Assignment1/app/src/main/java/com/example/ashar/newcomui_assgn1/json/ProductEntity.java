package com.example.ashar.newcomui_assgn1.json;

import java.util.List;

/**
 * Created by ashar on 15/2/17.
 */

public class ProductEntity
{


    private String searchURL;

    public String getSearchURL() {
        return searchURL;
    }

    public void setSearchURL(String searchURL) {
        this.searchURL = searchURL;
    }

    private identifier identifier;

    public com.example.ashar.newcomui_assgn1.json.basicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(com.example.ashar.newcomui_assgn1.json.basicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public com.example.ashar.newcomui_assgn1.json.merchandiseInfo getMerchandiseInfo() {
        return merchandiseInfo;
    }

    public void setMerchandiseInfo(com.example.ashar.newcomui_assgn1.json.merchandiseInfo merchandiseInfo) {
        this.merchandiseInfo = merchandiseInfo;
    }

    public com.example.ashar.newcomui_assgn1.json.identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(com.example.ashar.newcomui_assgn1.json.identifier identifier) {
        this.identifier = identifier;
    }

    private basicInfo basicInfo;
    private merchandiseInfo merchandiseInfo;
}
class identifier
{
    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    private String skuName;
    private String skuId;
}
class basicInfo
{
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    private String productCode;
    private String imageThumbnail;
}
class merchandiseInfo
{
    private String category3;

    public String getCategor1() {
        return category1;
    }

    public void setCategor1(String categor1) {
        this.category1 = categor1;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getSellingMeasure() {
        return sellingMeasure;
    }

    public void setSellingMeasure(String sellingMeasure) {
        this.sellingMeasure = sellingMeasure;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    private String category1;
    private String category2;
    private String sellingMeasure;
    private String brand;
    private String description;
    private String detailedDescription;


}