package com.chothuenhatro.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chothuenhatro.builder.ProductSearchBuilder;
import com.chothuenhatro.converter.ProductConverter;
import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.dto.RoleDTO;
import com.chothuenhatro.dto.UserDTO;
import com.chothuenhatro.entity.ProductCategoryEntity;
import com.chothuenhatro.entity.ProductEntity;
import com.chothuenhatro.entity.UserEntity;
import com.chothuenhatro.enums.AreaEnum;
import com.chothuenhatro.enums.DistrictsEnum;
import com.chothuenhatro.enums.PriceEnum;
import com.chothuenhatro.repository.ProductCategoryRepository;
import com.chothuenhatro.repository.ProductRepository;
import com.chothuenhatro.repository.UserRepository;
import com.chothuenhatro.service.IProductService;
import com.chothuenhatro.utils.UploadFileUtils;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private UploadFileUtils uploadFileUtils;

    @Override
    public List<ProductDTO> findAll() {
        List<ProductEntity> productFound = productRepository.findAll();
        return productFound.stream().map(productConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Map<String, String> getProductCategory() {
        Map<String, String> result = new HashMap<>();
        List<ProductCategoryEntity> categoriesFound = productCategoryRepository.findAll();
        categoriesFound.stream().forEach(category -> {
            result.put(category.getCode(), category.getName());
        });
        return result;
    }

    @Override
    public Map<String, String> getDistrict() {
        Map<String, String> result = new HashMap<>();
        Stream.of(DistrictsEnum.values()).forEach(district -> {
            result.put(district.name(), district.getDistrictValue());
        });
        return result;
    }

    @Override
    public Map<String, String> getAreas() {
        Map<String, String> result = new HashMap<>();
        Stream.of(AreaEnum.values()).forEach(area -> {
            result.put(area.name(), area.getAreaValue());
        });
        return result;
    }

    @Override
    public Map<String, String> getPrices() {
        Map<String, String> result = new HashMap<>();
        Stream.of(PriceEnum.values()).forEach(price -> {
            result.put(price.name(), price.getPriceValue());
        });
        return result;
    }

    @Override
    public List<ProductDTO> findByCondition(Map<String, String> params) {
        ProductSearchBuilder.Builder paramsValidated = new ProductSearchBuilder.Builder();

        if (StringUtils.isNotBlank(params.get("area"))) {
            paramsValidated.setArea(params.get("area"));
        }
        if (StringUtils.isNotBlank(params.get("price"))) {
            paramsValidated.setPrice(params.get("price"));
        }
        if (StringUtils.isNotBlank(params.get("productCategory"))) {
            paramsValidated.setProductCategory(params.get("productCategory"));
        }
        if (StringUtils.isNotBlank(params.get("district"))) {
            paramsValidated.setDistrict(params.get("district"));
        }

        List<ProductEntity> productsFound = productRepository.findByCondition(paramsValidated.build());
        List<ProductDTO> result = productsFound.stream().map(productConverter::convertToDto).collect(Collectors.toList());

        return result;
    }

    @Override
    public ProductDTO findOne(Long productId) {
        Optional<ProductEntity> productFound = productRepository.findById(productId);
        return productConverter.convertToDtoforUpdate(productFound.get());
    }

    @Override
    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        ProductEntity newProduct = productConverter.convertToEntity(productDTO);
        newProduct.setProductCategory(productCategoryRepository.findByCode(productDTO.getProductCategory()));
        saveThumbnail(productDTO, newProduct);

        return productConverter.convertToDto(productRepository.save(newProduct));
    }

    @Override
    @Transactional
    public ProductDTO update(ProductDTO productDTO) {
        ProductEntity oldProduct = productRepository.findById(productDTO.getId()).get();
        ProductEntity updateProduct = productConverter.convertToEntity(productDTO);

        updateProduct.setThumbnail(oldProduct.getThumbnail());
        updateProduct.setProductCategory(productCategoryRepository.findByCode(productDTO.getProductCategory()));
        saveThumbnail(productDTO, updateProduct);

        return productConverter.convertToDto(productRepository.save(updateProduct));
    }

    @Override
    public List<ProductDTO> findByUser(Long userId) {
        Optional<UserEntity> userFound = userRepository.findById(userId);
        return productRepository.findProductByUser(userFound.get()).
                stream().map(productConverter::convertToDto).
                collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(List<Long> productIds) {
        productRepository.findAllById(productIds).forEach(item -> productRepository.delete(item));
    }

    private void saveThumbnail(ProductDTO productDTO, ProductEntity productEntity) {
        String path = "/product/" + productDTO.getThumbnailImageName();
        if (productDTO.getThumbnailBase64() != null) {
            if (productEntity.getThumbnail() != null) {
                if (!path.equals(productEntity.getThumbnail())) {
                    File file = new File("C://home/boardinghouse" + productEntity.getThumbnail());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(productDTO.getThumbnailBase64().getBytes());
            uploadFileUtils.writeOrUpdate(path, bytes);
            productEntity.setThumbnail(path);
        }
    }
}
