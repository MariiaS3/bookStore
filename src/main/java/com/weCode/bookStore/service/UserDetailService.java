package com.weCode.bookStore.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private final PasswordEncoder  passwordEncoder;

    public UserDetailService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    //this is functionwhich is used by spring security for loading user from db
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return new User("peter@gmail.com", passwordEncoder.encode("password"), new ArrayList<>());
    }

}
