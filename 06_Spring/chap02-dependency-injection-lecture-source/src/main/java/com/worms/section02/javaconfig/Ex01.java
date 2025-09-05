package com.worms.section02.javaconfig;

import com.worms.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

public class Ex01 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfigurarion.class);

        MemberDTO member = context.getBean(MemberDTO.class);
        System.out.println("member = " + member);
    }
}
