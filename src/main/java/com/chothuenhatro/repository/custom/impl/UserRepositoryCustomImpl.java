package com.chothuenhatro.repository.custom.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.chothuenhatro.builder.ProductSearchBuilder;
import com.chothuenhatro.builder.UserSearchBuilder;
import com.chothuenhatro.entity.ProductEntity;
import com.chothuenhatro.entity.UserEntity;
import com.chothuenhatro.repository.custom.UserRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> findByCondition(UserSearchBuilder userSearchBuilder) {
        try {
            StringBuilder sb = new StringBuilder("select * from users u " +
                    "join user_role ur on ur.user_id = u.id " +
                    "and ur.role_id = 2");
            sb = buildQuerySearch(userSearchBuilder, sb);
            Query query = entityManager.createNativeQuery(sb.toString(), UserEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<UserEntity> findStaffs() {
        try {
            StringBuilder sb = new StringBuilder("");
            sb.append("select * from users u " +
                    "join user_role ur on ur.user_id = u.id " +
                    "and ur.role_id = 2");
            Query query = entityManager.createNativeQuery(sb.toString(), UserEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private StringBuilder buildQuerySearch(UserSearchBuilder userSearchBuilder, StringBuilder sb) {
        Field[] fields = UserSearchBuilder.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (Objects.nonNull(field.get(userSearchBuilder))) {
                    if (field.getType().getName().equals("java.lang.String")) {
                        sb.append(" and u." + field.getName() + " like '%" + field.get(userSearchBuilder) + "%'");
                    } else if (field.getType().getName().equals("java.lang.Integer")) {
                        sb.append(" and u." + field.getName() + " = " + field.get(userSearchBuilder) + "");
                    }
                }
            }
            return sb;
        } catch (Exception e) {
            return null;
        }
    }
}
