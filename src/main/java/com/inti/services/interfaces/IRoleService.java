package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Role;

public interface IRoleService {
	List<Role> findAll();

	Role findOne(Long idRole);

	Role save(Role role);

	void delete(Long idRole);

	Role findByIdRoleAndLibelle(Long idRole, String Libelle);
}