package org.example.section01;

public class Ex03 {
    public static void main(String[] args) {
        /* 수업 목표. 단항 연산자이자 증감연산자에 대해 이해하고 활용할 수 있다 */
        int num = 20;
        System.out.println("num = " + num);

        num++;
        System.out.println("num = " + num);

        ++num;
        System.out.println("num = " + num);

        num--;
        System.out.println("num = " + num);

        --num;
        System.out.println("num = " + num);

        int firstNum = 20;
        int result = firstNum++ + 3;
        System.out.println("result = " + result);
        System.out.println("firstNum = " + firstNum);
        System.out.println("firstNum++ = " + firstNum++);
        System.out.println("firstNum = " + firstNum);

    }
}

