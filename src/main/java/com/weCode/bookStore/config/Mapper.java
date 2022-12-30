package com.weCode.bookStore.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

    @Bean
    public ModelMapper modelMapper(){
		System.out.println("---------------------mapper----------------------------");

        return new ModelMapper();
    }
}
