package com.chothuenhatro.builder;

public class ProductSearchBuilder {

    private String area;
    private String price;
    private String productCategory;
    private String provinceCity;
    private String district;
    private String street;

    public String getArea() {
        return area;
    }

    public String getPrice() {
        return price;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProvinceCity() {
        return provinceCity;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public ProductSearchBuilder(Builder builder) {
        this.area = builder.area;
        this.district = builder.district;
        this.price = builder.price;
        this.productCategory = builder.productCategory;
        this.provinceCity = builder.provinceCity;
        this.street = builder.street;
    }

    public static class Builder {

        private String area;
        private String price;
        private String productCategory;
        private String provinceCity;
        private String district;
        private String street;

        public Builder setArea(String area) {
            this.area = area;
            return this;
        }

        public Builder setPrice(String price) {
            this.price = price;
            return this;
        }

        public Builder setProductCategory(String productCategory) {
            this.productCategory = productCategory;
            return this;
        }

        public Builder setProvinceCity(String provinceCity) {
            this.provinceCity = provinceCity;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public ProductSearchBuilder build() {
            return new ProductSearchBuilder(this);
        }
    }
}
