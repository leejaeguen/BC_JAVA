package com.worms.section03.properties.subsection02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class Ex01 {
    public static void main(String[] args) {

        /* 설명.
         *  i18n 소프트웨어의 국제화(Internationalization에서 첫 글자인 I와 마지막 글자인 N 사이의 알파벳 갯수를 고려)란?
         *  국제화를 하기 위해서는 지켜야 할 것들이 많다.
         *  1. 언어, 지역별 번역
         *  2. OS/Platform별 인코딩
         *  3. 문자열 치환 방법
         *  4. 국제화 UI(문자열 크기 변화, 폰트, 아이콘 등)
         *  5. 쓰기 방향의 차이
         *  6. 숫자, 공백, 화폐, 날짜, 주소, 측정 단위 등
         *  7. 타임존, 썸머타임 등 시각
         *  8. 문자열 정렬 방법
         * */
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String error404MessageKR = context.getMessage("error.404", null, Locale.KOREA);
        String error500MessageKR = context.getMessage("error.500",
                new Object[]{"여러분", new java.util.Date()}, Locale.KOREA);

        System.out.println("I18N 404 한국버전: "  + error404MessageKR);
        System.out.println("I18N 500 한국버전: "  + error500MessageKR);

        String error404MessageUS = context.getMessage("error.404", null, Locale.US);
        String error500MessageUS = context.getMessage("error.500",
                new Object[]{"you", new java.util.Date()}, Locale.US);

        System.out.println("I18N 404 미국버전: "  + error404MessageUS);
        System.out.println("I18N 500 미국버전: "  + error500MessageUS);
    }
}