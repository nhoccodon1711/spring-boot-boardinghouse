package com.chothuenhatro.repository.custom;

import java.util.List;

import com.chothuenhatro.builder.UserSearchBuilder;
import com.chothuenhatro.entity.UserEntity;

public interface UserRepositoryCustom {
    List<UserEntity> findByCondition(UserSearchBuilder userSearchBuilder);
    List<UserEntity> findStaffs();
}
