package com.chothuenhatro.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chothuenhatro.builder.ProductSearchBuilder;
import com.chothuenhatro.builder.UserSearchBuilder;
import com.chothuenhatro.constant.SystemConstant;
import com.chothuenhatro.converter.UserConverter;
import com.chothuenhatro.dto.PasswordDTO;
import com.chothuenhatro.dto.UserDTO;
import com.chothuenhatro.entity.RoleEntity;
import com.chothuenhatro.entity.UserEntity;
import com.chothuenhatro.exception.MyException;
import com.chothuenhatro.repository.RoleRepository;
import com.chothuenhatro.repository.UserRepository;
import com.chothuenhatro.service.IUserService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> usersFound = userRepository.findStaffs();
        return usersFound.stream().map(userConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO userDTO) {
        UserEntity oldUser = new UserEntity();

        if (Objects.nonNull(userDTO)) {
            if (userDTO.getId() != null) {
                oldUser = userRepository.findById(userDTO.getId()).get();
            }
            UserEntity userEntity = userConverter.convertToEntity(userDTO);

            if (Objects.nonNull(oldUser) && StringUtils.isBlank(userDTO.getPassword())) {
                userEntity.setPassword(oldUser.getPassword());
            } else {
                userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            }
            RoleEntity role = roleRepository.findOneByCode("USER");
            userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
            userEntity.setStatus(1);

            return userConverter.convertToDto(userRepository.save(userEntity));
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(List<Long> userIds) {
        userRepository.findAllById(userIds).forEach(item -> userRepository.delete(item));
    }

    @Override
    public UserDTO findUserById(Long id) {
        UserEntity entity = userRepository.getOne(id);
        List<RoleEntity> roles = entity.getRoles();
        UserDTO userDTO = userConverter.convertToDto(entity);
        roles.forEach(item -> {
            userDTO.setRoleCode(item.getCode());
        });

        return userDTO;
    }

    @Override
    public List<UserDTO> findByCondition(Map<String, String> params) {

        UserSearchBuilder.Builder paramsValidated = new UserSearchBuilder.Builder();

        if (StringUtils.isNotBlank(params.get("fullName"))) {
            paramsValidated.setFullName(params.get("fullName"));
        }
        if (StringUtils.isNotBlank(params.get("phone"))) {
            paramsValidated.setPhone(params.get("phone"));
        }
        if (StringUtils.isNotBlank(params.get("email"))) {
            paramsValidated.setEmail(params.get("email"));
        }
        if (StringUtils.isNotBlank(params.get("userName"))) {
            paramsValidated.setUsername(params.get("userName"));
        }

        List<UserEntity> usersFound = userRepository.findByCondition(paramsValidated.build());
        return usersFound.stream().map(userConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO findOneByUserNameAndStatus(String name, int status) {
        return userConverter.convertToDto(userRepository.findOneByUserNameAndStatus(name, status));
    }

    @Override
    public List<UserDTO> getUsers(String searchValue, Pageable pageable) {
        Page<UserEntity> users = null;
        if (StringUtils.isNotBlank(searchValue)) {
            users = userRepository.findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(searchValue, searchValue, 0, pageable);
        } else {
            users = userRepository.findByStatusNot(0, pageable);
        }
        List<UserEntity> newsEntities = users.getContent();
        List<UserDTO> result = new ArrayList<>();
        for (UserEntity userEntity : newsEntities) {
            UserDTO userDTO = userConverter.convertToDto(userEntity);
            userDTO.setRoleCode(userEntity.getRoles().get(0).getCode());
            result.add(userDTO);
        }
        return result;
    }

    @Override
    public int getTotalItems(String searchValue) {
        int totalItem = 0;
        if (StringUtils.isNotBlank(searchValue)) {
            totalItem = (int) userRepository.countByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(searchValue, searchValue, 0);
        } else {
            totalItem = (int) userRepository.countByStatusNot(0);
        }
        return totalItem;
    }

    @Override
    public UserDTO findOneByUserName(String userName) {
        UserEntity userEntity = userRepository.findOneByUserName(userName);
        UserDTO userDTO = userConverter.convertToDto(userEntity);
        return userDTO;
    }

//    @Override
//    public UserDTO findUserById(long id) {
//        UserEntity entity = userRepository.findById(id).get();
//        List<RoleEntity> roles = entity.getRoles();
//        UserDTO dto = userConverter.convertToDto(entity);
//        roles.forEach(item -> {
//            dto.setRoleCode(item.getCode());
//        });
//        return dto;
//    }

//    @Override
//    @Transactional
//    public UserDTO insert(UserDTO newUser) {
//        RoleEntity role = roleRepository.findOneByCode("2");
//        UserEntity userEntity = userConverter.convertToEntity(newUser);
//        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
//        userEntity.setStatus(1);
//        userEntity.setPassword(passwordEncoder.encode(newUser.getPassword()));
//        return userConverter.convertToDto(userRepository.save(userEntity));
//    }

    @Override
    @Transactional
    public UserDTO update(Long id, UserDTO updateUser) {
        RoleEntity role = roleRepository.findOneByCode(updateUser.getRoleCode());
        UserEntity oldUser = userRepository.findById(id).get();
        UserEntity userEntity = userConverter.convertToEntity(updateUser);
        userEntity.setUserName(oldUser.getUserName());
        userEntity.setStatus(oldUser.getStatus());
        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
        userEntity.setPassword(oldUser.getPassword());
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public void updatePassword(long id, PasswordDTO passwordDTO) throws MyException {
        UserEntity user = userRepository.findById(id).get();
        if (passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPassword())
                && passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword())) {
            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            userRepository.save(user);
        } else {
            throw new MyException(SystemConstant.CHANGE_PASSWORD_FAIL);
        }
    }

    @Override
    @Transactional
    public UserDTO resetPassword(long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setPassword(passwordEncoder.encode(SystemConstant.PASSWORD_DEFAULT));
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserDTO updateProfileOfUser(String username, UserDTO updateUser) {
        UserEntity oldUser = userRepository.findOneByUserName(username);
        oldUser.setFullName(updateUser.getFullName());
        return userConverter.convertToDto(userRepository.save(oldUser));
    }

//    @Override
//    @Transactional
//    public void delete(long[] ids) {
//        for (Long item : ids) {
//            UserEntity userEntity = userRepository.findById(item).get();
//            userEntity.setStatus(0);
//            userRepository.save(userEntity);
//        }
//    }
}
