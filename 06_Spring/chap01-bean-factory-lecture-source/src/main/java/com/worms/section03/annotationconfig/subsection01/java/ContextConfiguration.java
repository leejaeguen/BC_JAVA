package com.worms.section03.annotationconfig.subsection01.java;

import com.worms.common.MemberDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration("config")

/* 설명. 1. 기본적으로 설정파일이 있는 패키지 및 하위만 Scan 하지만 basePackage를 바꾸면 다른 범위도 가능 */
//@ComponentScan(basePackages = {"com.worms", "com.worms.section01"})

/* 설명. 2. 범위 및 필터를 적용해서 제외하고자 하는 bean을 등록하는 경우(excludeFilters) */
//@ComponentScan(basePackages = "com.worms",
//               excludeFilters = {
//                    /* 설명. 2-1. 타입으로 설정 */
//                    @ComponentScan.Filter(
////                            type = FilterType.ASSIGNABLE_TYPE,
////                            classes = {MemberDAO.class})
//
//                    /* 설명. 2-2 어노테이션으로 설정 */
//                    type = FilterType.ANNOTATION,
//                    classes = {org.springframework.stereotype.Controller.class}
//                    )
//               })

/* 설명. 3. 범위 및 필터를 적용해서 포함(등록)하고자 하는 bean을 등록하는 경우(includerFilters) */
@ComponentScan(basePackages = "com.worms",
                useDefaultFilters = false,      // 현재 범위의 bean들은 일단 모두 off
                includeFilters = {@ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = {MemberDAO.class}     // MemberDAO 타입만 등록
                )})
public class ContextConfiguration {
}
