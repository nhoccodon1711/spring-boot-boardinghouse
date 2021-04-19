package com.chothuenhatro.converter;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.entity.ProductEntity;
import com.chothuenhatro.entity.UserEntity;
import com.chothuenhatro.enums.DistrictsEnum;
import com.chothuenhatro.repository.UserRepository;

import java.util.Objects;

@Component
public class ProductConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public ProductDTO convertToDto (ProductEntity productEntity){
        ProductDTO result = modelMapper.map(productEntity, ProductDTO.class);
        if (!StringUtils.isNotBlank(result.getAddress())) {
            StringBuilder sb = new StringBuilder("");
            if (StringUtils.isNotBlank(productEntity.getStreet())) {
                sb.append(productEntity.getStreet() + ", ");
            }
            if (StringUtils.isNotBlank(productEntity.getWard())) {
                sb.append(productEntity.getWard() + ", ");
            }
            if (StringUtils.isNotBlank(productEntity.getDistrict())) {
                sb.append(DistrictsEnum.getDistrictName(productEntity.getDistrict()));
            }
            result.setAddress(sb.toString());
        }
        if (Objects.nonNull(productEntity.getProductCategory())) {
            result.setProductCategory(productEntity.getProductCategory().getName());
        }
        if (Objects.nonNull(productEntity.getArea())) {
            result.setArea(productEntity.getArea().toString());
        }
        if (Objects.nonNull(productEntity.getPrice())) {
            result.setPrice(productEntity.getPrice().toString());
        }
        if (Objects.nonNull(productEntity.getProductCategory())) {
            result.setProductCategory(productEntity.getProductCategory().getName());
        }
        UserEntity userEntity = userRepository.findOneByUserName(productEntity.getCreatedBy());
        if (Objects.nonNull(userEntity)) {
            result.setCreatedByConverted(userEntity.getFullName());
            result.setPhoneHost(userEntity.getPhone());
        }

        return result;
    }

    public ProductDTO convertToDtoforUpdate (ProductEntity productEntity){
        ProductDTO result = modelMapper.map(productEntity, ProductDTO.class);
        if (!StringUtils.isNotBlank(result.getAddress())) {
            StringBuilder sb = new StringBuilder("");
            if (StringUtils.isNotBlank(productEntity.getStreet())) {
                sb.append(productEntity.getStreet() + ", ");
            }
            if (StringUtils.isNotBlank(productEntity.getWard())) {
                sb.append(productEntity.getWard() + ", ");
            }
            if (StringUtils.isNotBlank(productEntity.getDistrict())) {
                sb.append(DistrictsEnum.getDistrictName(productEntity.getDistrict()));
            }
            result.setAddress(sb.toString());
        }
        if (Objects.nonNull(productEntity.getProductCategory())) {
            result.setProductCategory(productEntity.getProductCategory().getName());
        }
        if (Objects.nonNull(productEntity.getArea())) {
            result.setArea(productEntity.getArea().toString());
        }
        if (Objects.nonNull(productEntity.getPrice())) {
            result.setPrice(productEntity.getPrice().toString());
        }
        if (Objects.nonNull(productEntity.getProductCategory())) {
            result.setProductCategory(productEntity.getProductCategory().getCode());
        }
        UserEntity userEntity = userRepository.findOneByUserName(productEntity.getCreatedBy());
        if (Objects.nonNull(userEntity)) {
            result.setCreatedByConverted(userEntity.getFullName());
            result.setPhoneHost(userEntity.getPhone());
        }

        return result;
    }


    public ProductEntity convertToEntity (ProductDTO productDTO){
        ProductEntity result = modelMapper.map(productDTO, ProductEntity.class);
        return result;
    }
}
