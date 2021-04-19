package com.chothuenhatro.repository.custom;

import java.util.List;
import java.util.Map;

import com.chothuenhatro.builder.ProductSearchBuilder;
import com.chothuenhatro.entity.ProductEntity;
import com.chothuenhatro.entity.UserEntity;

public interface ProductRepositoryCustom {
    List<ProductEntity> findByCondition(ProductSearchBuilder productSearchBuilder);
    List<ProductEntity> findProductByUser(UserEntity userEntity);
}
