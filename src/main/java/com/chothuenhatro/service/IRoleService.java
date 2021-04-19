package com.chothuenhatro.service;

import java.util.List;
import java.util.Map;

import com.chothuenhatro.dto.RoleDTO;

public interface IRoleService {
	List<RoleDTO> findAll();
	Map<String,String> getRoles();
}
