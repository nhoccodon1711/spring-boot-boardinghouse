package com.chothuenhatro.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chothuenhatro.dto.ProductCategoryDTO;
import com.chothuenhatro.dto.UserDTO;
import com.chothuenhatro.entity.ProductCategoryEntity;
import com.chothuenhatro.entity.UserEntity;

@Component
public class ProductCategoryConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ProductCategoryDTO convertToDto (ProductCategoryEntity entity){
        ProductCategoryDTO result = modelMapper.map(entity, ProductCategoryDTO.class);
        return result;
    }

    public ProductCategoryEntity convertToEntity (ProductCategoryDTO dto){
        ProductCategoryEntity result = modelMapper.map(dto, ProductCategoryEntity.class);
        return result;
    }
}
