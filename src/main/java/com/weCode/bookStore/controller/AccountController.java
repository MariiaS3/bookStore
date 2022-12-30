package com.weCode.bookStore.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.weCode.bookStore.config.JwtUtil;
import com.weCode.bookStore.dto.AuthenticationRequest;
import com.weCode.bookStore.dto.AuthenticationResponse;
import com.weCode.bookStore.dto.AccountDto;
import com.weCode.bookStore.service.AccountDetailService;
import com.weCode.bookStore.service.AccountService;

@Validated
@Deprecated
@RestController
@RequestMapping("/api/v1")
public class AccountController {
    
    // private final AuthenticationManager authenticationManager;
    private final AccountDetailService userDetailService;
    // private final JwtUtil  jwtUtils;
    private final AccountService userService;



    public AccountController(/*AuthenticationManager authenticationManager,*/ AccountDetailService userDetailService,
           /*  JwtUtil jwtUtils,*/ AccountService userService) {
        // this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        // this.jwtUtils = jwtUtils;
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        // try{
        //     authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        // }catch(BadCredentialsException ex){
        //     throw new RuntimeException("username or password incorect");
        // }

        // UserDetails userDetails= userDetailService.loadUserByUsername(request.getEmail());
        // String token = jwtUtils.genetateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse("Bearer "+"token"));
    }


    @PostMapping("/register")
    public ResponseEntity<UUID> addUser(@Valid @RequestBody AccountDto userDto){
            UUID uuid = userService.addUser(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(uuid);
    }
}
