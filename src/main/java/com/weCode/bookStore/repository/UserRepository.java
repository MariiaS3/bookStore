package com.weCode.bookStore.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weCode.bookStore.model.User;

public interface UserRepository extends JpaRepository<User, UUID>{
    User findByEmail(String email);
}
