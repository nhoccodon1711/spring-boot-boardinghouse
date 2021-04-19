package com.chothuenhatro.service;

import java.util.List;

import com.chothuenhatro.dto.ProductCategoryDTO;

public interface IProductCategoryService {
    List<ProductCategoryDTO> findAll();
    ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO);
    ProductCategoryDTO findOne(Long categoryId);
    void delete(List<Long> categoryIds);
}
