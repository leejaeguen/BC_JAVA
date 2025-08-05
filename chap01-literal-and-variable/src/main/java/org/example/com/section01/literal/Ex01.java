package org.example.com.section01.literal;

public class Ex01 {
    public static void main(String[] args) {
        // 한 줄 주석

        /*
            범위 주석1
            범위 주석2
            (설명이 좀 길때)
         */

        /* 수업목표. 여러 가지 값의 형태를 출력할 수 있다. */
        /* 목차. 1. 숫자 형태의 값 */
        /* 목차. 1-1. 정수 형태의 값 출력 */
        System.out.println(123);

        /* 목차. 1-2. 살수 형태의 값 출력 */
        System.out.println(1.234);
        /* 목차. 2. 문자 형태의 값 출력 */
        System.out.println('a'); //자바는 하나의 문자는 싱글쿼테이션(')
        System.out.println('1');

        // System.out.println(''); 값이 없는 문자는 없음
        System.out.println('\u0000');

        /* 목차. 3. 문자열 형태의 값 출력 */
        System.out.println("안녕하세여");
        System.out.println("a");
        System.out.println("");

        /* 목차. 4. 논리 형태의 값 출력 */
        System.out.println(true);
        System.out.println(false);
        System.out.println("ture");

    }
}
