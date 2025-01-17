package com.cardg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cardg.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query(value = "SELECT * FROM role ro where ro.role_name = :roleName", nativeQuery = true)
	public Role findByRoleName(@Param("roleName") String roleName);

}
