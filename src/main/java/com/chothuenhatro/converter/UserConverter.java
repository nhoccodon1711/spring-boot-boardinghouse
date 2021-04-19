package com.chothuenhatro.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chothuenhatro.dto.UserDTO;
import com.chothuenhatro.entity.RoleEntity;
import com.chothuenhatro.entity.UserEntity;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);

        if (entity.getStatus() == 1) {
            result.setStatusConverted("Đang làm việc");
        } else {
            result.setStatusConverted("Đã nghỉ việc");
        }
        return result;
    }

    public UserDTO convertToDtoForAdmin (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);

        if (entity.getStatus() == 1) {
            result.setStatusConverted("Đang làm việc");
        } else {
            result.setStatusConverted("Đã nghỉ việc");
        }

        return result;
    }

    public UserEntity convertToEntity (UserDTO dto){
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }
}
