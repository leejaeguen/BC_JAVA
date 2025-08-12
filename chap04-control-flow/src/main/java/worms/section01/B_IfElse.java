package worms.section01;

import java.util.Scanner;

public class B_IfElse {
    public void testSimpleIfElseStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 한 개를 입력하세요: ");

        int input = sc.nextInt();

        if (input % 2 > 0) {
            System.out.println("입력하신 정수는 홀수입니다.");
        } else {
            System.out.println("입력하신 정수는 짝수입니다.");
        }

    }

    public void testNestedIfElseStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 한 개를 입력하세요: ");

        int input = sc.nextInt();
        
        /* 설명. 양수이면서 짝수, 양수이면서 홀수 */

        if (input !=0) {
            if (input > 0) {
                if (input % 2 == 0) {
                    System.out.println("양수+짝수");
                } else {
                    System.out.println("양수 + 홀수");
                }
            }
        } else {
            System.out.println("0");
        }
    }
}
