package com.worms.springdatajpa.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /* 설명. 미리 build.gradle에 dependency로 추가해 둘 것 */
    /* 설명. DTO <-> Entity 매핑을 위한 modelmapper 라이브러리 bean 추가 */
    @Bean
    public ModelMapper modelMapper() {return new ModelMapper();}
}