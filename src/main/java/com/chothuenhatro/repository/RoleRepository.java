package com.chothuenhatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chothuenhatro.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findOneByCode(String code);
}
