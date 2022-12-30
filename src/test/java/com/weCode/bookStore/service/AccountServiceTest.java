package com.weCode.bookStore.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.weCode.bookStore.dto.AccountDto;
import com.weCode.bookStore.model.Account;
import com.weCode.bookStore.repository.AccountRepository;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService userService;

    @Mock
    private AccountRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void shouldReturnUserIdWhenCalledWithUserData() {
        UUID id = UUID.randomUUID();

        when(userRepository.saveAndFlush(any())).thenReturn(getUser(id));
        when(modelMapper.map(any(), any())).thenReturn(getUser(id));

        UUID uuid = userService.addUser(getUserDto());

        assertThat(uuid).isNotNull();
        assertThat(uuid).isEqualTo(id);
    }

    private AccountDto getUserDto() {
        return AccountDto.builder()
                .password("password")
                .id(UUID.randomUUID())
                .name("username")
                .email("example@gmail.com")
                .build();
    }

    private Account getUser(UUID id) {
        return Account.builder()
                .password("password")
                .id(id)
                .name("username")
                .email("example@gmail.com")
                .build();
    }

    @Test
    void shouldReturnUserWhenEmailIsExist() {
        UUID id = UUID.randomUUID();

        when(userRepository.findByEmail(anyString())).thenReturn(getUser(id));
        when(modelMapper.map(any(), any())).thenReturn(getUserDto());

        AccountDto email = userService.getUserByEmail("exmple@gmail.com");

        assertThat(email).isNotNull();
        assertThat(email.getName()).isEqualTo("username");
    }


    @Test
    void shouldThrowErrorWhenEmailIsNotExist() {

        when(userRepository.findByEmail(anyString())).thenThrow(new RuntimeException("error"));
  
        assertThatThrownBy(()-> userService.getUserByEmail("exmple@gmail.com")).isInstanceOf(RuntimeException.class);
    }
}
