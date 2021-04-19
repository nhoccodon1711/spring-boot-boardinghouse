package com.chothuenhatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chothuenhatro.entity.ProductCategoryEntity;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
    ProductCategoryEntity findByCode(String code);
}
