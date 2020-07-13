package com.tts.eCommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
public User findByUsername(String username);
}