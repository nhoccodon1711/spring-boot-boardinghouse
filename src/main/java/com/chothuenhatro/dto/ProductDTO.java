package com.chothuenhatro.dto;

public class ProductDTO extends AbstractDTO {

    private String area;
    private String areaDescription;
    private String thumbnail;
    private String price;
    private String priceDescription;
    private String name;
    private String content;
    private String productCategory;
    private String code;
    private String address;
    private String provinceCity;
    private String district;
    private String street;
    private String ward;
    private String note;
    private String thumbnailBase64;
    private String thumbnailImageName;
    private String createdByConverted;
    private String phoneHost;
    private String codeProductCategoryConverted;

    public String getCodeProductCategoryConverted() {
        return codeProductCategoryConverted;
    }

    public void setCodeProductCategoryConverted(String codeProductCategoryConverted) {
        this.codeProductCategoryConverted = codeProductCategoryConverted;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceDescription() {
        return priceDescription;
    }

    public void setPriceDescription(String priceDescription) {
        this.priceDescription = priceDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvinceCity() {
        return provinceCity;
    }

    public void setProvinceCity(String provinceCity) {
        this.provinceCity = provinceCity;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getThumbnailBase64() {
        if (thumbnailBase64 != null) {
            return thumbnailBase64.split(",")[1];
        }
        return thumbnailBase64;
    }

    public void setThumbnailBase64(String thumbnailBase64) {
        this.thumbnailBase64 = thumbnailBase64;
    }

    public String getThumbnailImageName() {
        return thumbnailImageName;
    }

    public void setThumbnailImageName(String thumbnailImageName) {
        this.thumbnailImageName = thumbnailImageName;
    }

    public String getCreatedByConverted() {
        return createdByConverted;
    }

    public void setCreatedByConverted(String createdByConverted) {
        this.createdByConverted = createdByConverted;
    }

    public String getPhoneHost() {
        return phoneHost;
    }

    public void setPhoneHost(String phoneHost) {
        this.phoneHost = phoneHost;
    }
}
