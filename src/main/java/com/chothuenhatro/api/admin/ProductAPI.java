package com.chothuenhatro.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.service.IProductService;

import java.util.List;

@RestController(value="productAPIOfAdmin")
public class ProductAPI {

    @Autowired
    private IProductService productService;

    @PostMapping("/api/product")
    public ProductDTO saveBuilding(@RequestBody ProductDTO productDTO) {
        if (productDTO.getId() != null) {
            productService.update(productDTO);
        } else {
            productService.insert(productDTO);
        }
        return productDTO;
    }

    @DeleteMapping("/api/product")
    public void deleteProduct(@RequestBody List<Long> productIds) {
        if (!CollectionUtils.isEmpty(productIds)) {
            productService.delete(productIds);
        }
    }
}
