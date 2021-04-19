package com.chothuenhatro.service;

import org.springframework.data.domain.Pageable;

import com.chothuenhatro.dto.PasswordDTO;
import com.chothuenhatro.dto.UserDTO;
import com.chothuenhatro.exception.MyException;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<UserDTO> findAll();
    List<UserDTO> findByCondition(Map<String, String> params);
    UserDTO findOneByUserNameAndStatus(String name, int status);
    List<UserDTO> getUsers(String searchValue, Pageable pageable);
    int getTotalItems(String searchValue);
    UserDTO findOneByUserName(String userName);
    //UserDTO findUserById(long id);
    //UserDTO insert(UserDTO userDTO);
    UserDTO update(Long id, UserDTO userDTO);
    void updatePassword(long id, PasswordDTO userDTO) throws MyException;
    UserDTO resetPassword(long id);
    UserDTO updateProfileOfUser(String id, UserDTO userDTO);
    //void delete(long[] ids);
    UserDTO save(UserDTO userDTO);
    void delete(List<Long> userIds);
    UserDTO findUserById(Long id);
}
