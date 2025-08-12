package com.worms.section01;

public class Method6 {
    public static void main(String[] args) {

        /* 수업목표. 다른 클래스에 작성한 메소드를 활용할 수 있다. */

        Calculator cals = new Calculator();

        int first = 100;
        int second = 50;

        /* 설명. 덧셈기능 */
        System.out.println("두 수의 합은? " + cals.PlusTwoNumbers(first, second));

        /* 설명. 최소값 */
        System.out.println("두 수 중 최소값은?" + cals.MinTwoNumvers(first, second));

        /* 설명. 최대값 */
        // static인 경우
        System.out.println("두 수 중 최대값은?" + Calculator.MaxTwoNumvers(first, second));
    }
}
