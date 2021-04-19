package com.chothuenhatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chothuenhatro.entity.ProductEntity;
import com.chothuenhatro.repository.custom.ProductRepositoryCustom;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, ProductRepositoryCustom {

}
