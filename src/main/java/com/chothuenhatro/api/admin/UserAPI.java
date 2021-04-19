package com.chothuenhatro.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.chothuenhatro.constant.SystemConstant;
import com.chothuenhatro.dto.PasswordDTO;
import com.chothuenhatro.dto.UserDTO;
import com.chothuenhatro.exception.MyException;
import com.chothuenhatro.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserAPI {

    @Autowired
    private IUserService userService;

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return userDTO;
    }

    @DeleteMapping
    public void deleteUser(@RequestBody List<Long> userIds) {
        if (!CollectionUtils.isEmpty(userIds)) {
            userService.delete(userIds);
        }
    }

    @PutMapping
    public void editUser(@RequestBody UserDTO userDTO) {
        if (userDTO.getId() != null) {
            userService.save(userDTO);
        }
    }

    @PutMapping("/change-password/{id}")
    public ResponseEntity<String> changePasswordUser(@PathVariable("id") long id, @RequestBody PasswordDTO passwordDTO) {
        try {
            userService.updatePassword(id, passwordDTO);
            return ResponseEntity.ok(SystemConstant.UPDATE_SUCCESS);
        } catch (MyException e) {
            //log
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PutMapping("/password/{id}/reset")
    public ResponseEntity<UserDTO> resetPassword(@PathVariable("id") long id) {
        return ResponseEntity.ok(userService.resetPassword(id));
    }

    @PutMapping("/profile/{username}")
    public ResponseEntity<UserDTO> updateProfileOfUser(@PathVariable("username") String username, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateProfileOfUser(username, userDTO));
    }
}
