package com.weCode.bookStore.service;

import java.util.Objects;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.weCode.bookStore.dto.AccountDto;
import com.weCode.bookStore.model.Account;
import com.weCode.bookStore.repository.AccountRepository;

@Service
public class AccountService {
    
    private final AccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public AccountService(AccountRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }
    
    public UUID addUser(AccountDto userDto){
        Account user = modelMapper.map(userDto, Account.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setId(null);

        Account createUser = userRepository.saveAndFlush(user);

        return createUser.getId();
    }
    
    public AccountDto getUserByEmail(String email){
        Account byEmail = userRepository.findByEmail(email);

        if(Objects.isNull(byEmail)){
            throw new RuntimeException("user not exist with this email: " + email);
        }
        return modelMapper.map(byEmail, AccountDto.class);

    }
}
