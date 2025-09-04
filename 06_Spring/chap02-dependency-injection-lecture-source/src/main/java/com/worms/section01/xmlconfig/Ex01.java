package com.worms.section01.xmlconfig;

import com.worms.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        /* 설명. new MemberDTO(1, "홍길동", "010-123-1234", "worms@naver.com", new PersonalAccount(20, "", 0) */
        MemberDTO member = context.getBean(MemberDTO.class);
        System.out.println("member = " + member);
    }
}
