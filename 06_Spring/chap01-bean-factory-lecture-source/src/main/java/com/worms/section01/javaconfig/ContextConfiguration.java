package com.worms.section01.javaconfig;

import com.worms.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    /* 설명. 메소드명이 기본 bean의 이름이 되고, 다른 이름을 하고 싶으면 어노테이션에 이름을 작성할 수 있다. */
    @Bean
    public MemberDTO memberDTO() {
        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }
}
