package com.worms.section02.xmlconfig;

import com.worms.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        ApplicationContext context =
                new GenericXmlApplicationContext("section02/xmlconfig/spring-context.xml");

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName: " + beanName);
        }
            
        /* 설명. 스프링의 IOC Container에서 관리중인 bean을 따로 추출 해보자 */
        /* 설명. 1. bean의 이름(id)를 가지고 컨테이너에서 추출 */
        MemberDTO member = (MemberDTO) context.getBean("member2");
        System.out.println("member: " + member);

        /* 설명. 2. bean의 클래스의 메타 정보(bean의 타입)을 전달하며 추출 */
        MemberDTO member2 = context.getBean(MemberDTO.class);
        System.out.println("두 번째 member: " + member2);

        /* 설명. 3. bean의 id와 클래스의 메타 정보를 전달하며 추출 */
        MemberDTO member3 = context.getBean("member2",  MemberDTO.class);
        System.out.println("세 번째 member: " + member3);
    }
}
