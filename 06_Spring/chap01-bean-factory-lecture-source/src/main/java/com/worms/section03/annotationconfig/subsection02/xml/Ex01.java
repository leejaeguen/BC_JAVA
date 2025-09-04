package com.worms.section03.annotationconfig.subsection02.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        ApplicationContext context =
                new GenericXmlApplicationContext("section03/annotationconfig/subsection02/xml/spring-context.xml");

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
    }
}
