package com.chothuenhatro.service;

import java.util.List;
import java.util.Map;

import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.dto.UserDTO;

public interface IProductService {
    List<ProductDTO> findAll();
    Map<String, String> getProductCategory();
    Map<String, String> getDistrict();
    Map<String, String> getAreas();
    Map<String, String> getPrices();
    List<ProductDTO> findByCondition(Map<String, String> params);
    ProductDTO findOne(Long buildingId);
    ProductDTO insert(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    List<ProductDTO> findByUser(Long userId);
    void delete(List<Long> productIds);
}
