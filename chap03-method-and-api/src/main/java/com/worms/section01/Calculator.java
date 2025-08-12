package com.worms.section01;

public class Calculator {
    public int PlusTwoNumbers(int first, int second) {
        return first + second;
    }

    public int MinTwoNumvers(int first, int second) {
        return (first > second) ? second : first;
    }
    
    /* 설명. static method일 경우 */
    public static int MaxTwoNumvers(int first, int second) {
        return (first > second) ? first : second;
    }
}
