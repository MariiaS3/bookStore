package com.weCode.bookStore.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weCode.bookStore.model.Account;

public interface AccountRepository extends JpaRepository<Account, UUID>{
    Account findByEmail(String email);
}
