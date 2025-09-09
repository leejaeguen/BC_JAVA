package com.worms.exceptionhandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class ContextConfiguration {

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver
                = new SimpleMappingExceptionResolver();

        /* 설명. 1. 예외 타입과 예외를 처리 할 페이지를 설정 */
        Properties props = new Properties();
        props.setProperty("java.lang.NullPointerException", "error/nullPointer");
        props.setProperty("MemberRegistException", "error/memberRegist");

        /* 설명. 2. 그 외 나머지 예외에 대한 default 페이지 설정 */
        simpleMappingExceptionResolver.setExceptionMappings(props);
        simpleMappingExceptionResolver.setDefaultErrorView("error/default");

        /* 설명. 3. 예외 객체를 담기 위한 Attribute Key값 설정 (화면에서 예외 메시지 확인 시 사용할 key값) */
        simpleMappingExceptionResolver.setExceptionAttribute("exceptionMessage");

        return simpleMappingExceptionResolver;
    }
}
