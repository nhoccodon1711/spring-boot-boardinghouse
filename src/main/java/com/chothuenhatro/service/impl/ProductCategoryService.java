package com.chothuenhatro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chothuenhatro.converter.ProductCategoryConverter;
import com.chothuenhatro.dto.ProductCategoryDTO;
import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.entity.ProductCategoryEntity;
import com.chothuenhatro.entity.ProductEntity;
import com.chothuenhatro.repository.ProductCategoryRepository;
import com.chothuenhatro.service.IProductCategoryService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService implements IProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductCategoryConverter productCategoryConverter;

    @Override
    public List<ProductCategoryDTO> findAll() {
        List<ProductCategoryEntity> categoriesFound = productCategoryRepository.findAll();
        return categoriesFound.stream().map(productCategoryConverter::convertToDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO) {
        if (Objects.nonNull(productCategoryDTO)) {
            ProductCategoryEntity productCategoryEntity = productCategoryConverter.convertToEntity(productCategoryDTO);

            return productCategoryConverter.convertToDto(productCategoryRepository.save(productCategoryEntity));
        }
        return null;
    }

    public ProductCategoryDTO findOne(Long categoryId) {
        Optional<ProductCategoryEntity> categoryFound = productCategoryRepository.findById(categoryId);
        return productCategoryConverter.convertToDto(categoryFound.get());
    }

    @Override
    @Transactional
    public void delete(List<Long> categoryIds) {
        productCategoryRepository.findAllById(categoryIds).forEach(item -> productCategoryRepository.delete(item));
    }
}
