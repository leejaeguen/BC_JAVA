package org.example.section01;

public class Ex01 {
    public static void main(String[] args) {
        /* 수업목표. 산술연산자에 대해 이해하고 활용할 수 있다.  */
        int num1 = 20;
        int num2 = 7;

        System.out.println("num1 + num2" + (num1 + num2));
        System.out.println("num1 - num2" + (num1 - num2));
        System.out.println("num1 * num2" + (num1 * num2));

        double testNum =  num1 / (double)num2;
        System.out.println("testNum = " + testNum);

        double testNum2 = (int)(testNum * 100) / (double)100;
        System.out.println("testNum2 = " + testNum2);

        System.out.println("num1 % num2 = " + (num1 % num2));
    }
}
