package com.worms.userservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /* 설명. DTO <-> DTO <-> Entity, 필요한 순간에 의존성 주입을 받기 위해 bean으로 등록 */
    @Bean
    public ModelMapper getMaodelMapper() {
        return new ModelMapper();
    }
}