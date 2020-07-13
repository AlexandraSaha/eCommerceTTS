package com.tts.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
public Role findByRole(String role);
}
