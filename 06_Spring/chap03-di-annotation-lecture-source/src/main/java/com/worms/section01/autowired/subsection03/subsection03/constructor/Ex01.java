package com.worms.section01.autowired.subsection03.subsection03.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        BookService bookService =
                context.getBean("constructorService", BookService.class);
        System.out.println("bookService = " + bookService);

        bookService.findAllBook().forEach(System.out::println);

        System.out.println("2번 책: " + bookService.findBookBySequenceOf(2));
    }
}
