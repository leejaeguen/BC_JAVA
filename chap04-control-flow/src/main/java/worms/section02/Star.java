package worms.section02;

import java.util.Scanner;

public class Star {
    public void printStar() {
        /* 설명. 별찍기 */
        /* 설명.
         *      *
         *     **
         *    ***
         *   ****
         *  *****
         * */
        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수 하나를 입력하세요: ");
        int input = sc.nextInt();

        for (int i = 0; i < input; i++) {
            System.out.print(" ".repeat(input - i + 1));
            System.out.println("*".repeat(i + 1));
        }
    }
}
