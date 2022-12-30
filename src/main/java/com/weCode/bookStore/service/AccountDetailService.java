package com.weCode.bookStore.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.weCode.bookStore.dto.AccountDto;

@Service
public class AccountDetailService implements UserDetailsService {

    private final AccountService userService;


    public AccountDetailService(AccountService userService) {
        this.userService = userService;
    }


    //this is functionwhich is used by spring security for loading user from db
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        AccountDto userByEmail = userService.getUserByEmail(username);
        return new User(userByEmail.getEmail(), userByEmail.getPassword(), new ArrayList<>());
    }

}
