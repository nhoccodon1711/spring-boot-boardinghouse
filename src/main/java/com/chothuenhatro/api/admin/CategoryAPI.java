package com.chothuenhatro.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.chothuenhatro.dto.ProductCategoryDTO;
import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.service.IProductCategoryService;
import com.chothuenhatro.service.IProductService;

import java.util.List;

@RestController(value="categoryAPIOfAdmin")
public class CategoryAPI {

    @Autowired
    private IProductCategoryService productCategoryService;

    @PostMapping("/api/category")
    public ProductCategoryDTO saveProductCategory(@RequestBody ProductCategoryDTO ProductCategoryDTO) {
        productCategoryService.save(ProductCategoryDTO);
        return ProductCategoryDTO;
    }

    @DeleteMapping("/api/category")
    public void deleteProductCategory(@RequestBody List<Long> categoryIds) {
        if (!CollectionUtils.isEmpty(categoryIds)) {
            productCategoryService.delete(categoryIds);
        }
    }

    @PutMapping("api/category")
    public ProductCategoryDTO editProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO) {
        if (productCategoryDTO.getId() != null) {
            return productCategoryService.save(productCategoryDTO);
        }
        return null;
    }
}
