package com.weCode.bookStore.config;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class CrossOriginConfig implements WebMvcConfigurer{
       
    //    @Override
       public void addCorsMappings(CorsRegistry registry) {
           registry.addMapping("/**");
       }
}
