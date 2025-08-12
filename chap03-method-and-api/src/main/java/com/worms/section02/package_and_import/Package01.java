package com.worms.section02.package_and_import;

import com.worms.section01.Calculator;

import java.sql.Date;

public class Package01 {
    public static void main(String[] args) {

        /* 수업목표. 패키지에 대해 이해할 수 있다. */
        /* 설명.
         *  패키지의 의미
         *  1. 클래스의 소속
         *  2. 원래는 클래스명의 일부분
         *  3. 경우에 따라 생략 가능
        * */

        com.worms.section01.Calculator cal = new com.worms.section01.Calculator();

        /* 설명. import를 활용하면 다른 패키지의 클래스도 줄여쓸 수 있다. */
        Calculator cal2 = new Calculator();

        System.out.println("두 수의 합은? " + cal.PlusTwoNumbers(100, 10));
        System.out.println("두 수의 합은? " + cal2.PlusTwoNumbers(100, 10));
        System.out.println("두 수의 합은? " + Calculator.MaxTwoNumvers(100, 10));

        /* 설명. Date형을 통한 패키지 구분 확인 */
        java.util.Date utilDate = new java.util.Date(0L);
        // java.sql.Date sqlDate = new java.sql.Date(0L);
        Date sqlDate = new Date(0L);
    }
}
